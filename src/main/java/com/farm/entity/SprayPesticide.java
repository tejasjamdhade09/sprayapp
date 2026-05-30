package com.farm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spray_pesticide")
public class SprayPesticide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "spray_id")
    private SprayRecord sprayRecord;

    @ManyToOne
    @JoinColumn(name = "pesticide_id")
    private Pesticide pesticide;

    private Double sprayedQty;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public SprayRecord getSprayRecord() { return sprayRecord; }
    public void setSprayRecord(SprayRecord sprayRecord) { this.sprayRecord = sprayRecord; }

    public Pesticide getPesticide() { return pesticide; }
    public void setPesticide(Pesticide pesticide) { this.pesticide = pesticide; }

    public Double getSprayedQty() { return sprayedQty; }
    public void setSprayedQty(Double sprayedQty) { this.sprayedQty = sprayedQty; }
}
