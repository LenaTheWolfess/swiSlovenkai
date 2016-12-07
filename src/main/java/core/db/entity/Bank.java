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
@Table(name = "mybank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "prime_interest_rate")
    private Double primeInterestRate;

    /**
     * vracia id banky, ktore odpoveda identifikatoru v tabulke Banka, nastavuje
     * ho databaza autoinkrementacne
     *
     * @return id odpovedajuce identifikatoru v tabulke Bank
     */
    public Long getId() {
        return id;
    }

    /**
     * nastavuje id banky, ktore odpoveda identifikatoru v tabulke Banka,
     * nastavuje ho databaza autoinkrementacne
     *
     * @param id id odpovedajuce identifikatoru v tabulke Bank,
     * autoinkrementacne
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * vracia meno banky
     *
     * @return meno banky
     */
    public String getName() {
        return name;
    }

    /**
     * nastavuje meno banky
     *
     * @param name meno banky, NotNull, dlzka od 1 do 50
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * vracia zakladnu urokovu mieru banky, ku ktorej sa budu
     * pripocitavat/odpocitavat uroky podla splnenych podmienok
     *
     * @return zakladny urok banky
     */
    public Double getPrimeInterestRate() {
        return primeInterestRate;
    }

    /**
     * nastavuje zakladnu urokovu mieru banky, ku ktorej sa budu
     * pripocitavat/odpocitavat uroky podla splnenych podmienok
     *
     * @param primeInterestRate zakladny urok banky, NotNull
     */
    public void setPrimeInterestRate(Double primeInterestRate) {
        this.primeInterestRate = primeInterestRate;
    }

    /***
     * vracia meno banky
     */
    @Override
    public String toString() {
        return this.name;
    }

}
