/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月別保険料段階クラスです。 保険料段階判定の結果。月ごとの保険料段階を保持する。
 *
 */
public class TsukibetsuHokenryoDankai {

    private RString 保険料段階04月 = RString.EMPTY;
    private RString 保険料段階05月 = RString.EMPTY;
    private RString 保険料段階06月 = RString.EMPTY;
    private RString 保険料段階07月 = RString.EMPTY;
    private RString 保険料段階08月 = RString.EMPTY;
    private RString 保険料段階09月 = RString.EMPTY;
    private RString 保険料段階10月 = RString.EMPTY;
    private RString 保険料段階11月 = RString.EMPTY;
    private RString 保険料段階12月 = RString.EMPTY;
    private RString 保険料段階01月 = RString.EMPTY;
    private RString 保険料段階02月 = RString.EMPTY;
    private RString 保険料段階03月 = RString.EMPTY;

    /**
     * TsukibetsuHokenryoDankaiクラスです。
     *
     */
    public TsukibetsuHokenryoDankai() {

    }

    /**
     * TsukibetsuHokenryoDankaiクラスです。
     *
     * @param hokenryoDankai hokenryoDankai
     */
    public TsukibetsuHokenryoDankai(RString hokenryoDankai) {
        保険料段階04月 = hokenryoDankai;
        保険料段階05月 = hokenryoDankai;
        保険料段階06月 = hokenryoDankai;
        保険料段階07月 = hokenryoDankai;
        保険料段階08月 = hokenryoDankai;
        保険料段階09月 = hokenryoDankai;
        保険料段階10月 = hokenryoDankai;
        保険料段階11月 = hokenryoDankai;
        保険料段階12月 = hokenryoDankai;
        保険料段階01月 = hokenryoDankai;
        保険料段階02月 = hokenryoDankai;
        保険料段階03月 = hokenryoDankai;

//        保険料段階04月.setSystemDankai(hokenryoDankai);
//        保険料段階05月.setSystemDankai(hokenryoDankai);
//        保険料段階06月.setSystemDankai(hokenryoDankai);
//        保険料段階07月.setSystemDankai(hokenryoDankai);
//        保険料段階08月.setSystemDankai(hokenryoDankai);
//        保険料段階09月.setSystemDankai(hokenryoDankai);
//        保険料段階10月.setSystemDankai(hokenryoDankai);
//        保険料段階11月.setSystemDankai(hokenryoDankai);
//        保険料段階12月.setSystemDankai(hokenryoDankai);
//        保険料段階01月.setSystemDankai(hokenryoDankai);
//        保険料段階02月.setSystemDankai(hokenryoDankai);
//        保険料段階03月.setSystemDankai(hokenryoDankai);
    }

    /**
     * TsukibetsuHokenryoDankaiクラスです。
     *
     * @param hokenryoDankaiMap hokenryoDankaiMap
     */
    protected void createHokenryoDankaiOutput(Map<RString, RString> hokenryoDankaiMap) {
        //Map<RString, HokenryoDankai> tsukibetsuHokenryoDankai = new HashMap<>();

        Set<Map.Entry<RString, RString>> set = hokenryoDankaiMap.entrySet();
        Iterator<Map.Entry<RString, RString>> it = set.iterator();
        //mapからkey(段階数)を取得
        while (it.hasNext()) {

            Map.Entry<RString, RString> entry = it.next();
            RString key = entry.getKey();
            //取得した段階の判定方法を取得
            RString hokenryodankai = hokenryoDankaiMap.get(key);
            //hanteiResult = KakuDankaiHantei(hokenryoDankaiInput,hanteihohoList);

            switch (key.toString()) {
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
                default:
                    break;
            }
        }
    }

    /**
     * TsukibetsuHokenryoDankaiクラスです。
     *
     * @return Map<RString, HokenryoDankai>
     */
    public Map<RString, RString> createHokenryoDankaiMap() {
        Map<RString, RString> hokenryoDankaiMap = new HashMap<>();

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
    public RString get保険料段階04月() {
        return 保険料段階04月;
    }

    /**
     * @param 保険料段階04月 the 保険料段階04月 to set
     */
    protected void set保険料段階04月(RString 保険料段階04月) {
        this.保険料段階04月 = 保険料段階04月;
    }

    /**
     * @return the 保険料段階05月
     */
    public RString get保険料段階05月() {
        return 保険料段階05月;
    }

    /**
     * @param 保険料段階05月 the 保険料段階05月 to set
     */
    protected void set保険料段階05月(RString 保険料段階05月) {
        this.保険料段階05月 = 保険料段階05月;
    }

    /**
     * @return the 保険料段階06月
     */
    public RString get保険料段階06月() {
        return 保険料段階06月;
    }

    /**
     * @param 保険料段階06月 the 保険料段階06月 to set
     */
    protected void set保険料段階06月(RString 保険料段階06月) {
        this.保険料段階06月 = 保険料段階06月;
    }

    /**
     * @return the 保険料段階07月
     */
    public RString get保険料段階07月() {
        return 保険料段階07月;
    }

    /**
     * @param 保険料段階07月 the 保険料段階07月 to set
     */
    protected void set保険料段階07月(RString 保険料段階07月) {
        this.保険料段階07月 = 保険料段階07月;
    }

    /**
     * @return the 保険料段階08月
     */
    public RString get保険料段階08月() {
        return 保険料段階08月;
    }

    /**
     * @param 保険料段階08月 the 保険料段階08月 to set
     */
    protected void set保険料段階08月(RString 保険料段階08月) {
        this.保険料段階08月 = 保険料段階08月;
    }

    /**
     * @return the 保険料段階09月
     */
    public RString get保険料段階09月() {
        return 保険料段階09月;
    }

    /**
     * @param 保険料段階09月 the 保険料段階09月 to set
     */
    protected void set保険料段階09月(RString 保険料段階09月) {
        this.保険料段階09月 = 保険料段階09月;
    }

    /**
     * @return the 保険料段階10月
     */
    public RString get保険料段階10月() {
        return 保険料段階10月;
    }

    /**
     * @param 保険料段階10月 the 保険料段階10月 to set
     */
    protected void set保険料段階10月(RString 保険料段階10月) {
        this.保険料段階10月 = 保険料段階10月;
    }

    /**
     * @return the 保険料段階11月
     */
    public RString get保険料段階11月() {
        return 保険料段階11月;
    }

    /**
     * @param 保険料段階11月 the 保険料段階11月 to set
     */
    protected void set保険料段階11月(RString 保険料段階11月) {
        this.保険料段階11月 = 保険料段階11月;
    }

    /**
     * @return the 保険料段階12月
     */
    public RString get保険料段階12月() {
        return 保険料段階12月;
    }

    /**
     * @param 保険料段階12月 the 保険料段階12月 to set
     */
    protected void set保険料段階12月(RString 保険料段階12月) {
        this.保険料段階12月 = 保険料段階12月;
    }

    /**
     * @return the 保険料段階01月
     */
    public RString get保険料段階01月() {
        return 保険料段階01月;
    }

    /**
     * @param 保険料段階01月 the 保険料段階01月 to set
     */
    protected void set保険料段階01月(RString 保険料段階01月) {
        this.保険料段階01月 = 保険料段階01月;
    }

    /**
     * @return the 保険料段階02月
     */
    public RString get保険料段階02月() {
        return 保険料段階02月;
    }

    /**
     * @param 保険料段階02月 the 保険料段階02月 to set
     */
    protected void set保険料段階02月(RString 保険料段階02月) {
        this.保険料段階02月 = 保険料段階02月;
    }

    /**
     * @return the 保険料段階03月
     */
    public RString get保険料段階03月() {
        return 保険料段階03月;
    }

    /**
     * @param 保険料段階03月 the 保険料段階03月 to set
     */
    protected void set保険料段階03月(RString 保険料段階03月) {
        this.保険料段階03月 = 保険料段階03月;
    }
}
