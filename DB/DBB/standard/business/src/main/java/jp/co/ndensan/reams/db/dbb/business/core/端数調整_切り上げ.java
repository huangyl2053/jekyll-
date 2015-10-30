/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3336
 */
public class 端数調整_切り上げ implements I端数調整 {

    private final RString tanni;

    端数調整_切り上げ(RString tanni) {
        this.tanni = tanni;
    }

    @Override
    public Decimal calc端数(Decimal 年額保険料) {
        if (年額保険料.remainder(new Decimal(String.valueOf(this.tanni))).compareTo(new Decimal("0")) != 0) {
            return 年額保険料.subtract(年額保険料.remainder(new Decimal(String.valueOf(this.tanni)))).add(new Decimal(String.valueOf(this.tanni)));
        }
        return 年額保険料;
    }

}
