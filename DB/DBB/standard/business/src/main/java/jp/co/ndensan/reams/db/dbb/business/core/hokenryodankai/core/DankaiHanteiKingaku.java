/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
class DankaiHanteiKingaku implements IHanteiHoho {

    private final Decimal kagen;
    private final Decimal jogen;

    public DankaiHanteiKingaku(Decimal kagen, Decimal jogen) {
        this.kagen = kagen;
        this.jogen = jogen;
    }

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        Decimal gokeiKingaku = hokenryoDankaiHanteiParameter.getFukaKonkyo().getGokeiShotoku()
                .add(hokenryoDankaiHanteiParameter.getFukaKonkyo().getKotekiNenkinShunyu());

        if (getJogen().compareTo(new Decimal(-1)) == 0) {
            return (0 <= gokeiKingaku.compareTo(getKagen()));
        } else {
            // 下限＜＝合計金額　AND 合計金額＜＝上限
            return (0 <= gokeiKingaku.compareTo(getKagen()) && gokeiKingaku.compareTo(getJogen()) <= 0);
        }

    }

    /**
     * @return the kagen
     */
    public Decimal getKagen() {
        return kagen;
    }

    /**
     * @return the jogen
     */
    public Decimal getJogen() {
        return jogen;
    }

}
