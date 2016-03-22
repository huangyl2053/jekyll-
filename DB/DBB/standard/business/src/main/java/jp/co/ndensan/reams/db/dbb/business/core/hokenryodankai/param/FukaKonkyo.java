/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param;

import jp.co.ndensan.reams.db.dbz.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課根拠パラメータというクラスです。
 *
 *
 */
public class FukaKonkyo {

    private FlexibleDate fukakijunYMD;
    private FlexibleDate seihoStartYMD;
    private FlexibleDate seihoEndYMD;
    private FlexibleDate roreiNenkinStartYMD;
    private FlexibleDate roreiNenkinEndYMD;
    private KazeiKubun setaiKazeiKubun;
    private KazeiKubun honninKazeiKubun;
    private Decimal gokeiShotoku;
    private Decimal kotekiNenkinShunyu;

    /**
     * @return the fukakijunYMD
     */
    public FlexibleDate getFukakijunYMD() {
        return fukakijunYMD;
    }

    /**
     * @param fukakijunYMD the FukakijunYMD to set
     */
    public void setFukakijunYMD(FlexibleDate fukakijunYMD) {
        this.fukakijunYMD = fukakijunYMD;
    }

    /**
     * @return the seihoStartYMD
     */
    public FlexibleDate getSeihoStartYMD() {
        return seihoStartYMD;
    }

    /**
     * @param seihoStartYMD the seihoStartYMD to set
     */
    public void setSeihoStartYMD(FlexibleDate seihoStartYMD) {
        this.seihoStartYMD = seihoStartYMD;
    }

    /**
     * @return the seihoEndYMD
     */
    public FlexibleDate getSeihoEndYMD() {
        return seihoEndYMD;
    }

    /**
     * @param seihoEndYMD the seihoEndYMD to set
     */
    public void setSeihoEndYMD(FlexibleDate seihoEndYMD) {
        this.seihoEndYMD = seihoEndYMD;
    }

    /**
     * @return the roreiNenkinStartYMD
     */
    public FlexibleDate getRoreiNenkinStartYMD() {
        return roreiNenkinStartYMD;
    }

    /**
     * @param roreiNenkinStartYMD the roreiNenkinStartYMD to set
     */
    public void setRoreiNenkinStartYMD(FlexibleDate roreiNenkinStartYMD) {
        this.roreiNenkinStartYMD = roreiNenkinStartYMD;
    }

    /**
     * @return the roreiNenkinEndYMD
     */
    public FlexibleDate getRoreiNenkinEndYMD() {
        return roreiNenkinEndYMD;
    }

    /**
     * @param roreiNenkinEndYMD the roreiNenkinEndYMD to set
     */
    public void setRoreiNenkinEndYMD(FlexibleDate roreiNenkinEndYMD) {
        this.roreiNenkinEndYMD = roreiNenkinEndYMD;
    }

    /**
     * @return the setaiKazeiKubun
     */
    public KazeiKubun getSetaiKazeiKubun() {
        return setaiKazeiKubun;
    }

    /**
     * @param setaiKazeiKubun the setaiKazeiKubun to set
     */
    public void setSetaiKazeiKubun(KazeiKubun setaiKazeiKubun) {
        this.setaiKazeiKubun = setaiKazeiKubun;
    }

    /**
     * @return the honninKazeiKubun
     */
    public KazeiKubun getHonninKazeiKubun() {
        return honninKazeiKubun;
    }

    /**
     * @param honninKazeiKubun the honninKazeiKubun to set
     */
    public void setHonninKazeiKubun(KazeiKubun honninKazeiKubun) {
        this.honninKazeiKubun = honninKazeiKubun;
    }

    /**
     * @return the gokeiShotoku
     */
    public Decimal getGokeiShotoku() {
        return gokeiShotoku;
    }

    /**
     * @param gokeiShotoku the gokeiShotoku to set
     */
    public void setGokeiShotoku(Decimal gokeiShotoku) {
        this.gokeiShotoku = gokeiShotoku;
    }

    /**
     * @return the kotekiNenkinShunyu
     */
    public Decimal getKotekiNenkinShunyu() {
        return kotekiNenkinShunyu;
    }

    /**
     * @param kotekiNenkinShunyu the kotekiNenkinShunyu to set
     */
    public void setKotekiNenkinShunyu(Decimal kotekiNenkinShunyu) {
        this.kotekiNenkinShunyu = kotekiNenkinShunyu;
    }

    /**
     * @param honninKazeiKubun
     * @return 世帯課税
     */
    public boolean is世帯課税(KazeiKubun honninKazeiKubun) {

        boolean 世帯課税 = false;
        if (KazeiKubun.課税.getコード().equals(honninKazeiKubun.getコード())) {
            世帯課税 = true;
        }
        return 世帯課税;
    }

}
