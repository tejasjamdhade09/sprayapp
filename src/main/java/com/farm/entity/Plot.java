package com.farm.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name = "plot")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plotId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "crop_id")
    private Crop crop;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 🟢 helps with Thymeleaf date fields
    private LocalDate precuttingDate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    // --- Getters & Setters ---
    public Long getPlotId() { return plotId; }
    public void setPlotId(Long plotId) { this.plotId = plotId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Crop getCrop() { return crop; }
    public void setCrop(Crop crop) { this.crop = crop; }

    public LocalDate getPrecuttingDate() { return precuttingDate; }
    public void setPrecuttingDate(LocalDate precuttingDate) { this.precuttingDate = precuttingDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
