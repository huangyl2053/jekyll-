/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.Date;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public class FukaKonkyo {

    private Date fukakijunYMD;
    private Date seihoStartYMD;
    private Date seihoEndYMD;
    private Date roreiNenkinStartYMD;
    private Date roreiNenkinEndYMD;
    private RString setaiKazeiKubun;
    private RString honninKazeiKubun;
    private Decimal gokeiShotoku;
    private Decimal kotekiNenkinShunyu;

    /**
     * @return the fukakijunYMD
     */
    public Date getFukakijunYMD() {
        return fukakijunYMD;
    }

    /**
     * @param fukakijunYMD the FukakijunYMD to set
     */
    public void setFukakijunYMD(Date fukakijunYMD) {
        this.fukakijunYMD = fukakijunYMD;
    }

    /**
     * @return the seihoStartYMD
     */
    public Date getSeihoStartYMD() {
        return seihoStartYMD;
    }

    /**
     * @param seihoStartYMD the seihoStartYMD to set
     */
    public void setSeihoStartYMD(Date seihoStartYMD) {
        this.seihoStartYMD = seihoStartYMD;
    }

    /**
     * @return the seihoEndYMD
     */
    public Date getSeihoEndYMD() {
        return seihoEndYMD;
    }

    /**
     * @param seihoEndYMD the seihoEndYMD to set
     */
    public void setSeihoEndYMD(Date seihoEndYMD) {
        this.seihoEndYMD = seihoEndYMD;
    }

    /**
     * @return the roreiNenkinStartYMD
     */
    public Date getRoreiNenkinStartYMD() {
        return roreiNenkinStartYMD;
    }

    /**
     * @param roreiNenkinStartYMD the roreiNenkinStartYMD to set
     */
    public void setRoreiNenkinStartYMD(Date roreiNenkinStartYMD) {
        this.roreiNenkinStartYMD = roreiNenkinStartYMD;
    }

    /**
     * @return the roreiNenkinEndYMD
     */
    public Date getRoreiNenkinEndYMD() {
        return roreiNenkinEndYMD;
    }

    /**
     * @param roreiNenkinEndYMD the roreiNenkinEndYMD to set
     */
    public void setRoreiNenkinEndYMD(Date roreiNenkinEndYMD) {
        this.roreiNenkinEndYMD = roreiNenkinEndYMD;
    }

    /**
     * @return the setaiKazeiKubun
     */
    public RString getSetaiKazeiKubun() {
        return setaiKazeiKubun;
    }

    /**
     * @param setaiKazeiKubun the setaiKazeiKubun to set
     */
    public void setSetaiKazeiKubun(RString setaiKazeiKubun) {
        this.setaiKazeiKubun = setaiKazeiKubun;
    }

    /**
     * @return the honninKazeiKubun
     */
    public RString getHonninKazeiKubun() {
        return honninKazeiKubun;
    }

    /**
     * @param honninKazeiKubun the honninKazeiKubun to set
     */
    public void setHonninKazeiKubun(RString honninKazeiKubun) {
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

}
