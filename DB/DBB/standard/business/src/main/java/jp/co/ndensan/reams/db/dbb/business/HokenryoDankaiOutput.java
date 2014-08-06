/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author N2810
 */
public class HokenryoDankaiOutput {

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

    public HokenryoDankaiOutput() {

    }

    public HokenryoDankaiOutput(String hokenryoDankai) {
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
    }

    protected void CreateHokenryoDankaiOutput(Map<String, HokenryoDankai> hokenryoDankaiMap) {
        //Map<String, HokenryoDankai> hokenryoDankaiOutput = new HashMap<>();

        //mapからkey(段階数)を取得
        for (String tsuki : hokenryoDankaiMap.keySet()) {

            //取得した段階の判定方法を取得
            HokenryoDankai hokenryodankai = hokenryoDankaiMap.get(tsuki);
            //hanteiResult = KakuDankaiHantei(hokenryoDankaiInput,hanteihohoList);

            switch (tsuki) {
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

    protected Map<String, HokenryoDankai> CreateHokenryoDankaiMap() {
        Map<String, HokenryoDankai> hokenryoDankaiMap = new HashMap<>();

        hokenryoDankaiMap.put("1", get保険料段階01月());
        hokenryoDankaiMap.put("2", get保険料段階02月());
        hokenryoDankaiMap.put("3", get保険料段階03月());
        hokenryoDankaiMap.put("4", get保険料段階04月());
        hokenryoDankaiMap.put("5", get保険料段階05月());
        hokenryoDankaiMap.put("6", get保険料段階06月());
        hokenryoDankaiMap.put("7", get保険料段階07月());
        hokenryoDankaiMap.put("8", get保険料段階08月());
        hokenryoDankaiMap.put("9", get保険料段階09月());
        hokenryoDankaiMap.put("10", get保険料段階10月());
        hokenryoDankaiMap.put("11", get保険料段階11月());
        hokenryoDankaiMap.put("12", get保険料段階12月());
        
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
    public void set保険料段階04月(HokenryoDankai 保険料段階04月) {
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
    public void set保険料段階05月(HokenryoDankai 保険料段階05月) {
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
    public void set保険料段階06月(HokenryoDankai 保険料段階06月) {
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
    public void set保険料段階07月(HokenryoDankai 保険料段階07月) {
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
    public void set保険料段階08月(HokenryoDankai 保険料段階08月) {
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
    public void set保険料段階09月(HokenryoDankai 保険料段階09月) {
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
    public void set保険料段階10月(HokenryoDankai 保険料段階10月) {
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
    public void set保険料段階11月(HokenryoDankai 保険料段階11月) {
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
    public void set保険料段階12月(HokenryoDankai 保険料段階12月) {
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
    public void set保険料段階01月(HokenryoDankai 保険料段階01月) {
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
    public void set保険料段階02月(HokenryoDankai 保険料段階02月) {
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
    public void set保険料段階03月(HokenryoDankai 保険料段階03月) {
        this.保険料段階03月 = 保険料段階03月;
    }
}
