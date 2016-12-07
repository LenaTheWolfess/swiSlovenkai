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
import javax.validation.constraints.Size;

/**
 *
 * @author Rastislav
 */
@Entity
@Table(name = "myinfocondition")
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "expression")
    private String expression;

    /**
     * vracia id podmienky odpovedajuce identifikatoru v tabulke myinfoondition
     *
     * @return id podmienky
     */
    public Long getId() {
        return id;
    }

    /**
     * nastavuje id podmienky odpovedajuce identifikatoru v tabulke
     * myinfoondition, AUTOINCREMENT
     *
     * @param id id podmienky
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * vracia slovny popis podmienky
     *
     * @return slovny popis podmienky
     */
    public String getDescription() {
        return description;
    }

    /**
     * nastavuje slovny popis podmienky, ktory vystihuje podstatu expression
     *
     * @param description slovny popis podmienky,NotNull,lenght=<1,100>
     * @see #getExpression()
     * @see #setExpression(String expression)
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * vracia mysql/sql select ktorý po doplnení parametrov id zakaznika,
     * požičaná suma a vykonani vráti hodnotu záujmu, ktorá sa na základe Mark
     * porovná s value a určí sa či je vyskladaná podmienka banky splnená
     *
     * @return sql select čakajúci ako parametre id zakaznika , požičaná sumu
     * @see BankCondition
     */
    public String getExpression() {
        return expression;
    }

    /**
     * nastavuje mysql/sql select ktorý po doplnení parametrov id zakaznika,
     * požičaná suma a vykonani vráti hodnotu záujmu, ktorá sa na základe Mark
     * porovná s value a určí sa či je vyskladaná podmienka banky splnená
     *
     * @param expression NotNull, dĺžka od 1 do = 50, select čakajúci ako
     * parametre id zakaznika , požičaná sumu
     * @see BankCondition
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }
    /***
     * vracia popis podmienky
     */
    @Override
    public String toString() {
        return description;
    }

}
