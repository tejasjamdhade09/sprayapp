package com.farm.Services;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.farm.repository.PesticideRepository;
import com.farm.entity.Pesticide;
import java.util.List;

@Service
public class PesticideService {
  @Autowired
  private PesticideRepository pesticideRepository;

  public List<Pesticide> listAll() { return pesticideRepository.findAll(); }

  public Pesticide get(Long id) { return pesticideRepository.findById(id).orElse(null); }

  public Pesticide save(Pesticide p) { return pesticideRepository.save(p); }

  public void decreaseStock(Long pesticideId, Double usedQty) {
    if (usedQty == null || usedQty <= 0) return;
    Pesticide p = pesticideRepository.findById(pesticideId).orElse(null);
    if (p != null) {
      double newQty = (p.getQty() == null ? 0.0 : p.getQty()) - usedQty;
      p.setQty(newQty < 0 ? 0.0 : newQty);
      pesticideRepository.save(p);
    }
  }

  public List<Pesticide> findLowStock(Double threshold) {
    return pesticideRepository.findByQtyLessThan(threshold);
  }
}
