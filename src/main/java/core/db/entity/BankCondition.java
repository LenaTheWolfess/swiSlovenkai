/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Rastislav
 */
@Entity
@Table(name = "mybankcondition")
public class BankCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "idB")
    private Long idB;

    @NotNull
    @Column(name = "idC")
    private Long idC;

    @NotNull
    @Column(name = "mark")
    private Long mark;

    @NotNull
    @Column(name = "value")
    private Integer value;

    @NotNull
    @Column(name = "change_interest_rate")
    private Double changeInterestRate;

    /**
     * vracia id podmienky nastavenej pre banku odpovedajuc identifikatoru v
     * tabulke BankCondition
     *
     * @return id id Podmienky Banky
     */
    public Long getId() {
        return id;
    }

    /**
     * nastavuje id podmienky pre banku odpovedajuc identifikatoru v tabulke
     * BankCondition
     *
     * @param idBC id Podmienky Banky, AUTOINCREMENT
     */
    public void setIdBC(Long idBC) {
        this.id = idBC;
    }

    /**
     * vracia id banky pre ktoru je tato podmienka nastavena
     *
     * @return id banky
     */
    public Long getIdB() {
        return idB;
    }

    /**
     * nasatvuje id banky pre ktoru chceme tuto podmienku
     *
     * @param idB id banky, NotNull
     */
    public void setIdB(Long idB) {
        this.idB = idB;
    }

    /**
     * vracia id podmienky ktora je nastavena pre danu banku
     * @return id Podmienky
     */
    public Long getIdC() {
        return idC;
    }

    /**
     * nastavuje id podmienky ktoru chceme pre danu banku
     *
     * @param idC NotNull
     */
    public void setIdC(Long idC) {
        this.idC = idC;
    }

    /**
     * vracia Long ktory reprezentuje porovnavacie znamienko v podmienke<br>
     * 0 = <br>
     * 1 $gt= <br>
     * -1 $lt= <br> 
     * -2 $lt <br> 
     * 2 $gt <br>
     *
     * @return cislo reprezentujuce porovnavacie znamienko
     */
    public Long getMark() {
        return mark;
    }

    /**
     * nastavuje Long ktory reprezentuje porovnavacie znamienko v
     * podmienke<br>
     * 0 = <br>
     * 1 $gt= <br>
     * -1 $lt= <br> 
     * -2 $lt <br> 
     * 2 $gt <br>
     *
     * @param mark cislo reprezentujuce porovnavacie znamienko, Set{-2,-1,0,1,2}
     */
    public void setMark(Long mark) {
        this.mark = mark;
    }

    /**
     * vracia hodnotu s ktorou sa porovnava hodnota zaujmu
     * @return hodnota s ktorou sa porovnava hodnota zaujmu
     * @see Condition
     */
    public Integer getValue() {
        return value;
    }

    /**
     * nastavuje hodnotu s ktorou sa porovnava hodnota záujmu
     * @param value hodnota s ktorou sa porovnava hodnota záujmu, NotNull
     * @see Condition
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * vracia o kolko sa ma zmenit urok ak je podmienka splnena
     * @return ako sa meni urok
     */
    public Double getChangeInterestRate() {
        return changeInterestRate;
    }

    /**
     * nasatvuje ako sa zmeni urok ak bude podmienka splnena
     * @param changeInterestRate hodnota o ktore sa zmeni urok (signed), NotNull
     */
    public void setChangeInterestRate(Double changeInterestRate) {
        this.changeInterestRate = changeInterestRate;
    }

}
