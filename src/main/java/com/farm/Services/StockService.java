package com.farm.Services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.farm.entity.Pesticide;
import com.farm.repository.PesticideRepository;

@Service
public class StockService {

    @Autowired
    private PesticideRepository pesticideRepository;

    // Get all pesticides
    public List<Pesticide> getAllStock() {
        return pesticideRepository.findAll();
    }

    // Get only low stock pesticides (below threshold)
    public List<Pesticide> getLowStock(Double threshold) {
        return pesticideRepository.findByQtyLessThan(threshold);
    }
}
