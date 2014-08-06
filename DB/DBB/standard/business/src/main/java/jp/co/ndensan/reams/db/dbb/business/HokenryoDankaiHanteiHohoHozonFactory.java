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
public class HokenryoDankaiHanteiHohoHozonFactory {

    public static HokenryoDankaiHanteiHohoHozon CreateHokenryoDankaiHanteiHoho(HokenryoDankaiInput hokenryoDankaiInput) {

        String fukanendo = hokenryoDankaiInput.getFukaNendo();
        if (fukanendo == null || fukanendo.isEmpty()) {
            return null;
        }

        int seireki = Integer.parseInt(fukanendo);
        HokenryoDankaiHanteiHohoHozon ret;

        if (2012 <= seireki && seireki <= 2014) {
            ret = new 第4期(hokenryoDankaiInput);

        } else {
            ret = null;
        }

        return ret;

    }
}
