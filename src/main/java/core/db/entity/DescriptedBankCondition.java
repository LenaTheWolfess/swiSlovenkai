/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.entity;

/**
 * obalovac pre podmienku vybranu bankou
 * @author Slavomír
 */
public class DescriptedBankCondition {

    private String description;
    private Long idB;
    private Long idC;
    private Long id;
    private Mark mark;
    private double value;
    private double rate;

    private boolean selected;

    public DescriptedBankCondition(String description, Long idB, Long idC, Long id, Mark mark, double value, double rate) {
        this.description = description;
        this.idB = idB;
        this.idC = idC;
        this.id = id;
        this.mark = mark;
        this.value = value;
        this.rate = rate;
        this.selected = false;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void actionClick() {
        selected = !selected;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdB() {
        return idB;
    }

    public Long getIdC() {
        return idC;
    }

    public Long getId() {
        return id;
    }

    public Mark getMark() {
        return mark;
    }

    public double getValue() {
        return value;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return description +" "+ mark.toString()+" "+ value;
    }

}
