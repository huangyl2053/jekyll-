/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiInput {

    private String fukaNendo;
    private FukaKonkyo fukaKonkyo;
    private SeigyoJoho seigyoJoho;

    /**
     * @return the fukaNendo
     */
    public String getFukaNendo() {
        return fukaNendo;
    }

    /**
     * @param fukaNendo the fukaNendo to set
     */
    public void setFukaNendo(String fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * @return the fukaKonkyo
     */
    public FukaKonkyo getFukaKonkyo() {
        return fukaKonkyo;
    }

    /**
     * @param fukaKonkyo the fukaKonkyo to set
     */
    public void setFukaKonkyo(FukaKonkyo fukaKonkyo) {
        this.fukaKonkyo = fukaKonkyo;
    }

    /**
     * @return the seigyoJoho
     */
    public SeigyoJoho getSeigyoJoho() {
        return seigyoJoho;
    }

    /**
     * @param seigyoJoho the seigyoJoho to set
     */
    public void setSeigyoJoho(SeigyoJoho seigyoJoho) {
        this.seigyoJoho = seigyoJoho;
    }
}
