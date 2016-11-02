/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param;

import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;

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
    private List<KazeiKubunHonninKubun> setaiinKazeiKubunList;
    private Decimal gokeiShotoku;
    private Decimal kotekiNenkinShunyu;
    private KazeiKubun zennendoKazeiKubun;
    private SetaiKazeiKubun zennendoSetaiKazeiKubun;

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
     * @return the List<KazeiKubunHonninKubun>
     */
    public List<KazeiKubunHonninKubun> getSetaiinKazeiKubunList() {
        return setaiinKazeiKubunList;
    }

    /**
     * @param setaiinKazeiKubunList the setaiinKazeiKubunList to set
     */
    public void setSetaiinKazeiKubunList(List<KazeiKubunHonninKubun> setaiinKazeiKubunList) {
        this.setaiinKazeiKubunList = setaiinKazeiKubunList;
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
     * @return the zennendoKazeiKubun
     */
    public KazeiKubun getZennendoKazeiKubun() {
        return zennendoKazeiKubun;
    }

    /**
     * @param zennendoKazeiKubun the zennendoKazeiKubun to set
     */
    public void setZennendoKazeiKubun(KazeiKubun zennendoKazeiKubun) {
        this.zennendoKazeiKubun = zennendoKazeiKubun;
    }

    /**
     * @return the zennendoSetaiKazeiKubun
     */
    public SetaiKazeiKubun getZennendoSetaiKazeiKubun() {
        return zennendoSetaiKazeiKubun;
    }

    /**
     * @param zennendoSetaiKazeiKubun the zennendoSetaiKazeiKubun to set
     */
    public void setZennendoSetaiKazeiKubun(SetaiKazeiKubun zennendoSetaiKazeiKubun) {
        this.zennendoSetaiKazeiKubun = zennendoSetaiKazeiKubun;
    }

    /**
     * @param setaiinKazeiKubunList setaiinKazeiKubunList
     * @return 世帯課税
     */
    public boolean is世帯課税(List<KazeiKubunHonninKubun> setaiinKazeiKubunList) {

        boolean 世帯課税 = false;
        for (KazeiKubunHonninKubun kazeiKubunHonninKubun : setaiinKazeiKubunList) {
            if (KazeiKubun.課税.getコード().equals(kazeiKubunHonninKubun.get課税区分().getコード())) {
                世帯課税 = true;
            }
        }
        return 世帯課税;
    }

}
