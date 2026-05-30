package com.farm.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "spray_record")
public class SprayRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    private Plot plot;

    private LocalDate sprayDate;
    private Double waterUsed;

    @OneToMany(mappedBy = "sprayRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SprayPesticide> pesticideUses;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Plot getPlot() { return plot; }
    public void setPlot(Plot plot) { this.plot = plot; }

    public LocalDate getSprayDate() { return sprayDate; }
    public void setSprayDate(LocalDate sprayDate) { this.sprayDate = sprayDate; }

    public Double getWaterUsed() { return waterUsed; }
    public void setWaterUsed(Double waterUsed) { this.waterUsed = waterUsed; }

    public List<SprayPesticide> getPesticideUses() { return pesticideUses; }
    public void setPesticideUses(List<SprayPesticide> pesticideUses) { this.pesticideUses = pesticideUses; }
}
