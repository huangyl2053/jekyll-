/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 *
 * @author N2810
 */
public final class HokenryoDankaiHanteiHohoHozonFactory {

    private static final int SEIREKI_2012 = 2012;
    private static final int SEIREKI_2014 = 2014;
    private static final int SEIREKI_2015 = 2015;
    private static final int SEIREKI_2017 = 2017;

    private HokenryoDankaiHanteiHohoHozonFactory() {
    }

    /**
     * createHokenryoDankaiHanteiHohoクラスです。
     *
     * @param hokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter
     * @return HokenryoDankaiHanteiHohoHozon HokenryoDankaiHanteiHohoHozon
     */
    public static HokenryoDankaiHanteiHohoHozon createHokenryoDankaiHanteiHoho(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        FlexibleYear fukanendo = hokenryoDankaiHanteiParameter.getFukaNendo();
        if (fukanendo == null || fukanendo.isEmpty()) {
            return null;
        }

        int seireki = Integer.parseInt(String.valueOf(fukanendo));
        HokenryoDankaiHanteiHohoHozon ret;

        if (SEIREKI_2012 <= seireki && seireki <= SEIREKI_2014) {
            ret = new Dai5Ki(hokenryoDankaiHanteiParameter);

        } else if (SEIREKI_2015 <= seireki && seireki <= SEIREKI_2017) {
            ret = new Dai6Ki(hokenryoDankaiHanteiParameter);
        } else {
            ret = null;
        }

        return ret;

    }
}
