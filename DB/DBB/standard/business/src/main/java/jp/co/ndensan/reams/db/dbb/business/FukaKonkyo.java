/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.Date;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author N2810
 */
public class FukaKonkyo {

    private Date FukakijunYMD;
    private Date SeihoStartYMD;
    private Date SeihoEndYMD;
    private Date RoreiNenkinStartYMD;
    private Date RoreiNenkinEndYMD;
    private String SetaiKazeiKubun;
    private String HonninKazeiKubun;
    private Decimal GokeiShotoku;
    private Decimal KotekiNenkinShunyu;

    /**
     * @return the FukakijunYMD
     */
    public Date getFukakijunYMD() {
        return FukakijunYMD;
    }

    /**
     * @param FukakijunYMD the FukakijunYMD to set
     */
    public void setFukakijunYMD(Date FukakijunYMD) {
        this.FukakijunYMD = FukakijunYMD;
    }

    /**
     * @return the SeihoStartYMD
     */
    public Date getSeihoStartYMD() {
        return SeihoStartYMD;
    }

    /**
     * @param SeihoStartYMD the SeihoStartYMD to set
     */
    public void setSeihoStartYMD(Date SeihoStartYMD) {
        this.SeihoStartYMD = SeihoStartYMD;
    }

    /**
     * @return the SeihoEndYMD
     */
    public Date getSeihoEndYMD() {
        return SeihoEndYMD;
    }

    /**
     * @param SeihoEndYMD the SeihoEndYMD to set
     */
    public void setSeihoEndYMD(Date SeihoEndYMD) {
        this.SeihoEndYMD = SeihoEndYMD;
    }

    /**
     * @return the RoreiNenkinStartYMD
     */
    public Date getRoreiNenkinStartYMD() {
        return RoreiNenkinStartYMD;
    }

    /**
     * @param RoreiNenkinStartYMD the RoreiNenkinStartYMD to set
     */
    public void setRoreiNenkinStartYMD(Date RoreiNenkinStartYMD) {
        this.RoreiNenkinStartYMD = RoreiNenkinStartYMD;
    }

    /**
     * @return the RoreiNenkinEndYMD
     */
    public Date getRoreiNenkinEndYMD() {
        return RoreiNenkinEndYMD;
    }

    /**
     * @param RoreiNenkinEndYMD the RoreiNenkinEndYMD to set
     */
    public void setRoreiNenkinEndYMD(Date RoreiNenkinEndYMD) {
        this.RoreiNenkinEndYMD = RoreiNenkinEndYMD;
    }

    /**
     * @return the SetaiKazeiKubun
     */
    public String getSetaiKazeiKubun() {
        return SetaiKazeiKubun;
    }

    /**
     * @param SetaiKazeiKubun the SetaiKazeiKubun to set
     */
    public void setSetaiKazeiKubun(String SetaiKazeiKubun) {
        this.SetaiKazeiKubun = SetaiKazeiKubun;
    }

    /**
     * @return the HonninKazeiKubun
     */
    public String getHonninKazeiKubun() {
        return HonninKazeiKubun;
    }

    /**
     * @param HonninKazeiKubun the HonninKazeiKubun to set
     */
    public void setHonninKazeiKubun(String HonninKazeiKubun) {
        this.HonninKazeiKubun = HonninKazeiKubun;
    }

    /**
     * @return the GokeiShotoku
     */
    public Decimal getGokeiShotoku() {
        return GokeiShotoku;
    }

    /**
     * @param GokeiShotoku the GokeiShotoku to set
     */
    public void setGokeiShotoku(Decimal GokeiShotoku) {
        this.GokeiShotoku = GokeiShotoku;
    }

    /**
     * @return the KotekiNenkinShunyu
     */
    public Decimal getKotekiNenkinShunyu() {
        return KotekiNenkinShunyu;
    }

    /**
     * @param KotekiNenkinShunyu the KotekiNenkinShunyu to set
     */
    public void setKotekiNenkinShunyu(Decimal KotekiNenkinShunyu) {
        this.KotekiNenkinShunyu = KotekiNenkinShunyu;
    }

}
