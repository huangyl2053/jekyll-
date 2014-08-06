/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public class 段階判定_金額 implements IHanteiHoho {

    private Decimal kagen;
    private Decimal jogen;

    public 段階判定_金額(Decimal kagen, Decimal jogen) {
        this.kagen = kagen;
        this.jogen = jogen;
    }

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {

        Decimal gokeiKingaku = hokenryoDankaiInput.getFukaKonkyo().getGokeiShotoku().add(hokenryoDankaiInput.getFukaKonkyo().getKotekiNenkinShunyu());

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
