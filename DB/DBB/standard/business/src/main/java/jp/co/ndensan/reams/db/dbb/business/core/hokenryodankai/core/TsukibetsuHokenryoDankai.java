/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別保険料段階クラスです。 保険料段階判定の結果。月ごとの保険料段階を保持する。
 *
 */
public class TsukibetsuHokenryoDankai {

    private HokenryoDankai 保険料段階04月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階05月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階06月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階07月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階08月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階09月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階10月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階11月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階12月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階01月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階02月 = new HokenryoDankai();
    private HokenryoDankai 保険料段階03月 = new HokenryoDankai();

    public TsukibetsuHokenryoDankai() {

    }

    public TsukibetsuHokenryoDankai(RString hokenryoDankai) {
        保険料段階04月.setHokenryoDankai(hokenryoDankai);
        保険料段階05月.setHokenryoDankai(hokenryoDankai);
        保険料段階06月.setHokenryoDankai(hokenryoDankai);
        保険料段階07月.setHokenryoDankai(hokenryoDankai);
        保険料段階08月.setHokenryoDankai(hokenryoDankai);
        保険料段階09月.setHokenryoDankai(hokenryoDankai);
        保険料段階10月.setHokenryoDankai(hokenryoDankai);
        保険料段階11月.setHokenryoDankai(hokenryoDankai);
        保険料段階12月.setHokenryoDankai(hokenryoDankai);
        保険料段階01月.setHokenryoDankai(hokenryoDankai);
        保険料段階02月.setHokenryoDankai(hokenryoDankai);
        保険料段階03月.setHokenryoDankai(hokenryoDankai);

        保険料段階04月.setSystemDankai(hokenryoDankai);
        保険料段階05月.setSystemDankai(hokenryoDankai);
        保険料段階06月.setSystemDankai(hokenryoDankai);
        保険料段階07月.setSystemDankai(hokenryoDankai);
        保険料段階08月.setSystemDankai(hokenryoDankai);
        保険料段階09月.setSystemDankai(hokenryoDankai);
        保険料段階10月.setSystemDankai(hokenryoDankai);
        保険料段階11月.setSystemDankai(hokenryoDankai);
        保険料段階12月.setSystemDankai(hokenryoDankai);
        保険料段階01月.setSystemDankai(hokenryoDankai);
        保険料段階02月.setSystemDankai(hokenryoDankai);
        保険料段階03月.setSystemDankai(hokenryoDankai);
    }

    protected void createHokenryoDankaiOutput(Map<RString, HokenryoDankai> hokenryoDankaiMap) {
        //Map<RString, HokenryoDankai> tsukibetsuHokenryoDankai = new HashMap<>();

        //mapからkey(段階数)を取得
        for (RString tsuki : hokenryoDankaiMap.keySet()) {

            //取得した段階の判定方法を取得
            HokenryoDankai hokenryodankai = hokenryoDankaiMap.get(tsuki);
            //hanteiResult = KakuDankaiHantei(hokenryoDankaiInput,hanteihohoList);

            switch (tsuki.toString()) {
                case "1":
                    set保険料段階01月(hokenryodankai);
                    break;
                case "2":
                    set保険料段階02月(hokenryodankai);
                    break;
                case "3":
                    set保険料段階03月(hokenryodankai);
                    break;
                case "4":
                    set保険料段階04月(hokenryodankai);
                    break;
                case "5":
                    set保険料段階05月(hokenryodankai);
                    break;
                case "6":
                    set保険料段階06月(hokenryodankai);
                    break;
                case "7":
                    set保険料段階07月(hokenryodankai);
                    break;
                case "8":
                    set保険料段階08月(hokenryodankai);
                    break;
                case "9":
                    set保険料段階09月(hokenryodankai);
                    break;
                case "10":
                    set保険料段階10月(hokenryodankai);
                    break;
                case "11":
                    set保険料段階11月(hokenryodankai);
                    break;
                case "12":
                    set保険料段階12月(hokenryodankai);
                    break;
            }
        }
    }

    public Map<RString, HokenryoDankai> createHokenryoDankaiMap() {
        Map<RString, HokenryoDankai> hokenryoDankaiMap = new HashMap<>();

        hokenryoDankaiMap.put(new RString("1"), get保険料段階01月());
        hokenryoDankaiMap.put(new RString("2"), get保険料段階02月());
        hokenryoDankaiMap.put(new RString("3"), get保険料段階03月());
        hokenryoDankaiMap.put(new RString("4"), get保険料段階04月());
        hokenryoDankaiMap.put(new RString("5"), get保険料段階05月());
        hokenryoDankaiMap.put(new RString("6"), get保険料段階06月());
        hokenryoDankaiMap.put(new RString("7"), get保険料段階07月());
        hokenryoDankaiMap.put(new RString("8"), get保険料段階08月());
        hokenryoDankaiMap.put(new RString("9"), get保険料段階09月());
        hokenryoDankaiMap.put(new RString("10"), get保険料段階10月());
        hokenryoDankaiMap.put(new RString("11"), get保険料段階11月());
        hokenryoDankaiMap.put(new RString("12"), get保険料段階12月());

        return hokenryoDankaiMap;
    }

    /**
     * @return the 保険料段階04月
     */
    public HokenryoDankai get保険料段階04月() {
        return 保険料段階04月;
    }

    /**
     * @param 保険料段階04月 the 保険料段階04月 to set
     */
    protected void set保険料段階04月(HokenryoDankai 保険料段階04月) {
        this.保険料段階04月 = 保険料段階04月;
    }

    /**
     * @return the 保険料段階05月
     */
    public HokenryoDankai get保険料段階05月() {
        return 保険料段階05月;
    }

    /**
     * @param 保険料段階05月 the 保険料段階05月 to set
     */
    protected void set保険料段階05月(HokenryoDankai 保険料段階05月) {
        this.保険料段階05月 = 保険料段階05月;
    }

    /**
     * @return the 保険料段階06月
     */
    public HokenryoDankai get保険料段階06月() {
        return 保険料段階06月;
    }

    /**
     * @param 保険料段階06月 the 保険料段階06月 to set
     */
    protected void set保険料段階06月(HokenryoDankai 保険料段階06月) {
        this.保険料段階06月 = 保険料段階06月;
    }

    /**
     * @return the 保険料段階07月
     */
    public HokenryoDankai get保険料段階07月() {
        return 保険料段階07月;
    }

    /**
     * @param 保険料段階07月 the 保険料段階07月 to set
     */
    protected void set保険料段階07月(HokenryoDankai 保険料段階07月) {
        this.保険料段階07月 = 保険料段階07月;
    }

    /**
     * @return the 保険料段階08月
     */
    public HokenryoDankai get保険料段階08月() {
        return 保険料段階08月;
    }

    /**
     * @param 保険料段階08月 the 保険料段階08月 to set
     */
    protected void set保険料段階08月(HokenryoDankai 保険料段階08月) {
        this.保険料段階08月 = 保険料段階08月;
    }

    /**
     * @return the 保険料段階09月
     */
    public HokenryoDankai get保険料段階09月() {
        return 保険料段階09月;
    }

    /**
     * @param 保険料段階09月 the 保険料段階09月 to set
     */
    protected void set保険料段階09月(HokenryoDankai 保険料段階09月) {
        this.保険料段階09月 = 保険料段階09月;
    }

    /**
     * @return the 保険料段階10月
     */
    public HokenryoDankai get保険料段階10月() {
        return 保険料段階10月;
    }

    /**
     * @param 保険料段階10月 the 保険料段階10月 to set
     */
    protected void set保険料段階10月(HokenryoDankai 保険料段階10月) {
        this.保険料段階10月 = 保険料段階10月;
    }

    /**
     * @return the 保険料段階11月
     */
    public HokenryoDankai get保険料段階11月() {
        return 保険料段階11月;
    }

    /**
     * @param 保険料段階11月 the 保険料段階11月 to set
     */
    protected void set保険料段階11月(HokenryoDankai 保険料段階11月) {
        this.保険料段階11月 = 保険料段階11月;
    }

    /**
     * @return the 保険料段階12月
     */
    public HokenryoDankai get保険料段階12月() {
        return 保険料段階12月;
    }

    /**
     * @param 保険料段階12月 the 保険料段階12月 to set
     */
    protected void set保険料段階12月(HokenryoDankai 保険料段階12月) {
        this.保険料段階12月 = 保険料段階12月;
    }

    /**
     * @return the 保険料段階01月
     */
    public HokenryoDankai get保険料段階01月() {
        return 保険料段階01月;
    }

    /**
     * @param 保険料段階01月 the 保険料段階01月 to set
     */
    protected void set保険料段階01月(HokenryoDankai 保険料段階01月) {
        this.保険料段階01月 = 保険料段階01月;
    }

    /**
     * @return the 保険料段階02月
     */
    public HokenryoDankai get保険料段階02月() {
        return 保険料段階02月;
    }

    /**
     * @param 保険料段階02月 the 保険料段階02月 to set
     */
    protected void set保険料段階02月(HokenryoDankai 保険料段階02月) {
        this.保険料段階02月 = 保険料段階02月;
    }

    /**
     * @return the 保険料段階03月
     */
    public HokenryoDankai get保険料段階03月() {
        return 保険料段階03月;
    }

    /**
     * @param 保険料段階03月 the 保険料段階03月 to set
     */
    protected void set保険料段階03月(HokenryoDankai 保険料段階03月) {
        this.保険料段階03月 = 保険料段階03月;
    }
}
