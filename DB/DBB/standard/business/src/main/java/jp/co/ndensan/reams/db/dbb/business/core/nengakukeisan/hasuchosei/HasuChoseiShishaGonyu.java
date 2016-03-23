/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.hasuchosei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 端数調整_四捨五入
 *
 * @author n3336
 */
class HasuChoseiShishaGonyu implements IHasuChosei {

    private final RString tanni;

    public HasuChoseiShishaGonyu(RString tanni) {
        this.tanni = tanni;
    }

    @Override
    public Decimal calc端数(Decimal 年額保険料) {
        Integer half = Integer.parseInt(String.valueOf(this.tanni));
        half = half / 2;
        if ((年額保険料.remainder(new Decimal(String.valueOf(this.tanni)))).compareTo(new Decimal(half.toString())) >= 0) {
            return 年額保険料.subtract(年額保険料.remainder(new Decimal(String.valueOf(this.tanni)))).add(new Decimal(String.valueOf(this.tanni)));
        }
        return 年額保険料.subtract(年額保険料.remainder(new Decimal(String.valueOf(this.tanni))));
    }

}
