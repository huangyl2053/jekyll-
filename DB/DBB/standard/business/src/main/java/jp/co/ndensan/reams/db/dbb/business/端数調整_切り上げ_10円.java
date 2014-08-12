/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3336
 */
public class 端数調整_切り上げ_10円 implements I端数調整{
    @Override
    public Decimal Calc端数(Decimal 年額保険料) {
        if(年額保険料.remainder(new Decimal("10")).compareTo(new Decimal("0")) != 0){
            return 年額保険料.subtract(年額保険料.remainder(new Decimal("10"))).add(new Decimal("10"));        
        }
        return 年額保険料;
    }
}
