package com.duck.go2ductor.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author DucTN
 * @project go2ductor
 * @on 4/4/2023
 */
@Entity
@Table(name = "medician")
public class Medician {
    @Id
    private Long id;
    private String name;
    private String manufacturer;
    private String dosage_form;
    private String strength;
    private String composition;
    private String indications;
    private String contraindications;
    private String side_effects;
    private String storage_instructions;
    private BigDecimal price;
    private String image;

    public Medician() {
    }

    public Medician(Long id, String name, String manufacturer, String dosage_form, String strength, String composition, String indications, String contraindications, String side_effects, String storage_instructions, BigDecimal price, String image) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.dosage_form = dosage_form;
        this.strength = strength;
        this.composition = composition;
        this.indications = indications;
        this.contraindications = contraindications;
        this.side_effects = side_effects;
        this.storage_instructions = storage_instructions;
        this.price = price;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDosage_form() {
        return dosage_form;
    }

    public void setDosage_form(String dosage_form) {
        this.dosage_form = dosage_form;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getSide_effects() {
        return side_effects;
    }

    public void setSide_effects(String side_effects) {
        this.side_effects = side_effects;
    }

    public String getStorage_instructions() {
        return storage_instructions;
    }

    public void setStorage_instructions(String storage_instructions) {
        this.storage_instructions = storage_instructions;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
