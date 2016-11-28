/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.KazeiKubunHonninKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
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
        Decimal gokeiKingaku;
        if (isKasei(hokenryoDankaiHanteiParameter)) {
            gokeiKingaku = nullToZero(hokenryoDankaiHanteiParameter.getFukaKonkyo().getGokeiShotoku());
        } else {
            gokeiKingaku = nullToZero(hokenryoDankaiHanteiParameter.getFukaKonkyo().getGokeiShotoku())
                    .add(nullToZero(hokenryoDankaiHanteiParameter.getFukaKonkyo().getKotekiNenkinShunyu()));
        }
        if (getJogen().compareTo(new Decimal(-1)) == 0) {
            return (0 <= gokeiKingaku.compareTo(getKagen()));
        } else {
            // 下限＜＝合計金額　AND 合計金額＜＝上限
            return (0 <= gokeiKingaku.compareTo(getKagen()) && (gokeiKingaku.compareTo(getJogen()) <= 0 || getJogen().compareTo(Decimal.ZERO) == 0));
        }

    }

    private Boolean isKasei(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {
        if (null == hokenryoDankaiHanteiParameter.getFukaKonkyo().getZennendoKazeiKubun()) {
            for (KazeiKubunHonninKubun kazeiKubunHonninKubun : hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiinKazeiKubunList()) {
                if (HonninKubun.本人 == kazeiKubunHonninKubun.get本人区分()) {
                    return KazeiKubun.課税 == kazeiKubunHonninKubun.get課税区分();
                }
            }

            return false;
        }
        return SetaiKazeiKubun.非課税 == hokenryoDankaiHanteiParameter.getFukaKonkyo().getZennendoSetaiKazeiKubun();
    }

    private Decimal nullToZero(Decimal decimal) {
        return decimal == null ? Decimal.ZERO : decimal;
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
