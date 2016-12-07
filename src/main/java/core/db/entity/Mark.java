/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.entity;

/**
 * Reprezentant Mark z BankCondition
 * @see BankCondition
 * @author Slavomír
 */
public class Mark {

    private Long id;
    private String text;

    /***
     * vytvori novy ojekt Mark
     * @param id mark v BankCondition
     * @param text znamienko podla mark v BankCondition
     * @see BankCondition.getMark()
     */
    public Mark(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }

}
