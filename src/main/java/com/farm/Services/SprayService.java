package com.farm.Services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.farm.repository.SprayRecordRepository;
import com.farm.entity.*;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.List;

@Service
public class SprayService {
    @Autowired private SprayRecordRepository sprayRepo;
    @Autowired private PesticideService pesticideService;

    private final double LOW_STOCK_THRESHOLD = 100.0;

    @Transactional
    public SprayRecord saveSpray(SprayRecord spray) {
        SprayRecord saved = sprayRepo.save(spray);

        List<SprayPesticide> uses = saved.getPesticideUses();
        if (uses != null) {
            for (SprayPesticide use : uses) {
                if (use.getPesticide() != null && use.getSprayedQty() != null) {
                    pesticideService.decreaseStock(
                        use.getPesticide().getPesticideId(),
                        use.getSprayedQty()
                    );
                }
            }
        }
        return saved;
    }

    public long daysToPrecutting(SprayRecord r) {
        if (r.getPlot() == null || r.getPlot().getPrecuttingDate() == null || r.getSprayDate() == null)
            return Long.MIN_VALUE;

        LocalDate spray = r.getSprayDate();
        LocalDate precut = r.getPlot().getPrecuttingDate();
        return ChronoUnit.DAYS.between(spray, precut);
    }

    
    public List<Pesticide> checkLowStock() {
        return pesticideService.findLowStock(LOW_STOCK_THRESHOLD);
    }

    public List<SprayRecord> getAll() {
        return sprayRepo.findAll();
    }
}
