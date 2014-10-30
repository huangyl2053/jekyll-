/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author n3336
 */
public class NengakuFukaKonkyo {
    private RDate 賦課基準日;
    private RDate 資格取得日;
    private RDate 資格喪失日;
    private HokenryoDankai 保険料段階_4月;
    private HokenryoDankai 保険料段階_5月;
    private HokenryoDankai 保険料段階_6月;
    private HokenryoDankai 保険料段階_7月;
    private HokenryoDankai 保険料段階_8月;
    private HokenryoDankai 保険料段階_9月;
    private HokenryoDankai 保険料段階_10月;
    private HokenryoDankai 保険料段階_11月;
    private HokenryoDankai 保険料段階_12月;
    private HokenryoDankai 保険料段階_1月;
    private HokenryoDankai 保険料段階_2月;
    private HokenryoDankai 保険料段階_3月;
    private String ランク_4月;
    private String ランク_5月;
    private String ランク_6月;
    private String ランク_7月;
    private String ランク_8月;
    private String ランク_9月;
    private String ランク_10月;
    private String ランク_11月;
    private String ランク_12月;
    private String ランク_1月;
    private String ランク_2月;
    private String ランク_3月;

    public RDate get賦課基準日() {
        return 賦課基準日;
    }

    public void set賦課基準日(RDate 賦課基準日) {
        this.賦課基準日 = 賦課基準日;
    }

    public RDate get資格取得日() {
        return 資格取得日;
    }

    public void set資格取得日(RDate 資格取得日) {
        this.資格取得日 = 資格取得日;
    }

    public RDate get資格喪失日() {
        return 資格喪失日;
    }

    public void set資格喪失日(RDate 資格喪失日) {
        this.資格喪失日 = 資格喪失日;
    }
    
    
    public Map<String, HokenryoDankai> createHokenryoDankaiMap(){
        Map<String, HokenryoDankai> map = new HashMap<>();
        map.put("4", 保険料段階_4月);
        map.put("5", 保険料段階_5月);
        map.put("6", 保険料段階_6月);
        map.put("7", 保険料段階_7月);
        map.put("8", 保険料段階_8月);
        map.put("9", 保険料段階_9月);
        map.put("10", 保険料段階_10月);
        map.put("11", 保険料段階_11月);
        map.put("12", 保険料段階_12月);
        map.put("1", 保険料段階_1月);
        map.put("2", 保険料段階_2月);
        map.put("3", 保険料段階_3月);
        
        return map;
    }
    
    public Map<String, String> createRankMap(){
        Map<String, String> map = new HashMap<>();
        map.put("4", ランク_4月);
        map.put("5", ランク_5月);
        map.put("6", ランク_6月);
        map.put("7", ランク_7月);
        map.put("8", ランク_8月);
        map.put("9", ランク_9月);
        map.put("10", ランク_10月);
        map.put("11", ランク_11月);
        map.put("12", ランク_12月);
        map.put("1", ランク_1月);
        map.put("2", ランク_2月);
        map.put("3", ランク_3月);
        
        return map;
    }

    public HokenryoDankai get保険料段階_4月() {
        return 保険料段階_4月;
    }

    public void set保険料段階_4月(HokenryoDankai 保険料段階_4月) {
        this.保険料段階_4月 = 保険料段階_4月;
    }

    public HokenryoDankai get保険料段階_5月() {
        return 保険料段階_5月;
    }

    public void set保険料段階_5月(HokenryoDankai 保険料段階_5月) {
        this.保険料段階_5月 = 保険料段階_5月;
    }

    public HokenryoDankai get保険料段階_6月() {
        return 保険料段階_6月;
    }

    public void set保険料段階_6月(HokenryoDankai 保険料段階_6月) {
        this.保険料段階_6月 = 保険料段階_6月;
    }

    public HokenryoDankai get保険料段階_7月() {
        return 保険料段階_7月;
    }
    
    public void set保険料段階_7月(HokenryoDankai 保険料段階_7月) {
        this.保険料段階_7月 = 保険料段階_7月;
    }

    public HokenryoDankai get保険料段階_8月() {
        return 保険料段階_8月;
    }

    public void set保険料段階_8月(HokenryoDankai 保険料段階_8月) {
        this.保険料段階_8月 = 保険料段階_8月;
    }

    public HokenryoDankai get保険料段階_9月() {
        return 保険料段階_9月;
    }

    public void set保険料段階_9月(HokenryoDankai 保険料段階_9月) {
        this.保険料段階_9月 = 保険料段階_9月;
    }

    public HokenryoDankai get保険料段階_10月() {
        return 保険料段階_10月;
    }

    public void set保険料段階_10月(HokenryoDankai 保険料段階_10月) {
        this.保険料段階_10月 = 保険料段階_10月;
    }

    public HokenryoDankai get保険料段階_11月() {
        return 保険料段階_11月;
    }

    public void set保険料段階_11月(HokenryoDankai 保険料段階_11月) {
        this.保険料段階_11月 = 保険料段階_11月;
    }

    public HokenryoDankai get保険料段階_12月() {
        return 保険料段階_12月;
    }

    public void set保険料段階_12月(HokenryoDankai 保険料段階_12月) {
        this.保険料段階_12月 = 保険料段階_12月;
    }

    public HokenryoDankai get保険料段階_1月() {
        return 保険料段階_1月;
    }

    public void set保険料段階_1月(HokenryoDankai 保険料段階_1月) {
        this.保険料段階_1月 = 保険料段階_1月;
    }

    public HokenryoDankai get保険料段階_2月() {
        return 保険料段階_2月;
    }

    public void set保険料段階_2月(HokenryoDankai 保険料段階_2月) {
        this.保険料段階_2月 = 保険料段階_2月;
    }

    public HokenryoDankai get保険料段階_3月() {
        return 保険料段階_3月;
    }

    public void set保険料段階_3月(HokenryoDankai 保険料段階_3月) {
        this.保険料段階_3月 = 保険料段階_3月;
    }

    public String getランク_4月() {
        return ランク_4月;
    }

    public void setランク_4月(String ランク_4月) {
        this.ランク_4月 = ランク_4月;
    }

    public String getランク_5月() {
        return ランク_5月;
    }

    public void setランク_5月(String ランク_5月) {
        this.ランク_5月 = ランク_5月;
    }

    public String getランク_6月() {
        return ランク_6月;
    }

    public void setランク_6月(String ランク_6月) {
        this.ランク_6月 = ランク_6月;
    }

    public String getランク_7月() {
        return ランク_7月;
    }

    public void setランク_7月(String ランク_7月) {
        this.ランク_7月 = ランク_7月;
    }

    public String getランク_8月() {
        return ランク_8月;
    }

    public void setランク_8月(String ランク_8月) {
        this.ランク_8月 = ランク_8月;
    }

    public String getランク_9月() {
        return ランク_9月;
    }

    public void setランク_9月(String ランク_9月) {
        this.ランク_9月 = ランク_9月;
    }

    public String getランク_10月() {
        return ランク_10月;
    }

    public void setランク_10月(String ランク_10月) {
        this.ランク_10月 = ランク_10月;
    }

    public String getランク_11月() {
        return ランク_11月;
    }

    public void setランク_11月(String ランク_11月) {
        this.ランク_11月 = ランク_11月;
    }

    public String getランク_12月() {
        return ランク_12月;
    }

    public void setランク_12月(String ランク_12月) {
        this.ランク_12月 = ランク_12月;
    }

    public String getランク_1月() {
        return ランク_1月;
    }

    public void setランク_1月(String ランク_1月) {
        this.ランク_1月 = ランク_1月;
    }

    public String getランク_2月() {
        return ランク_2月;
    }

    public void setランク_2月(String ランク_2月) {
        this.ランク_2月 = ランク_2月;
    }

    public String getランク_3月() {
        return ランク_3月;
    }

    public void setランク_3月(String ランク_3月) {
        this.ランク_3月 = ランク_3月;
    }
    
    
    
}
