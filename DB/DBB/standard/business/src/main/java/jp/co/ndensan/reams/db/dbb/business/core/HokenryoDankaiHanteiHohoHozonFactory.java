/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public final class HokenryoDankaiHanteiHohoHozonFactory {

    private static final int SEIREKI_2012 = 2012;
    private static final int SEIREKI_2014 = 2014;

    private HokenryoDankaiHanteiHohoHozonFactory() {
    }

    public static HokenryoDankaiHanteiHohoHozon createHokenryoDankaiHanteiHoho(HokenryoDankaiInput hokenryoDankaiInput) {

        RString fukanendo = hokenryoDankaiInput.getFukaNendo();
        if (fukanendo == null || fukanendo.isEmpty()) {
            return null;
        }

        int seireki = Integer.parseInt(String.valueOf(fukanendo));
        HokenryoDankaiHanteiHohoHozon ret;

        if (SEIREKI_2012 <= seireki && seireki <= SEIREKI_2014) {
            ret = new 第4期(hokenryoDankaiInput);

        } else {
            ret = null;
        }

        return ret;

    }
}
