/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author n3336
 */
public class NengakuSeigyoJoho {

    private Decimal 端数単位;
    private String 端数調整方法;
    private Decimal 端数単位_ランク用;
    private String 端数調整方法_ランク用;
    private Map<String, Rank別基準金額> ランク別制御情報;

    public Decimal get端数単位() {
        return 端数単位;
    }

    public void set端数単位(Decimal 端数単位) {
        this.端数単位 = 端数単位;
    }

    public String get端数調整方法() {
        return 端数調整方法;
    }

    public void set端数調整方法(String 端数調整方法) {
        this.端数調整方法 = 端数調整方法;
    }

    public Decimal get端数単位_ランク用() {
        return 端数単位_ランク用;
    }

    public void set端数単位_ランク用(Decimal 端数単位_ランク用) {
        this.端数単位_ランク用 = 端数単位_ランク用;
    }

    public String get端数調整方法_ランク用() {
        return 端数調整方法_ランク用;
    }

    public void set端数調整方法_ランク用(String 端数調整方法_ランク用) {
        this.端数調整方法_ランク用 = 端数調整方法_ランク用;
    }

    public Map<String, Rank別基準金額> createランク別基準金額() {
        Map<String, Rank別基準金額> map = new HashMap<>();
        return map;
    }

    /**
     * @return the ランク別制御情報
     */
    public Map<String, Rank別基準金額> getランク別制御情報() {
        return ランク別制御情報;
    }

    /**
     * @param ランク別制御情報 the ランク別制御情報 to set
     */
    public void setランク別制御情報(Map<String, Rank別基準金額> ランク別制御情報) {
        this.ランク別制御情報 = ランク別制御情報;
    }

}
