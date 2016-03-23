/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nengakukeisan.param;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core.TsukibetsuHokenryoDankai;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年額計算で用いる賦課根拠。
 *
 * @author n3336
 */
public class NengakuFukaKonkyo {

    private FlexibleDate 賦課基準日;
    private FlexibleDate 資格取得日;
    private FlexibleDate 資格喪失日;
    private TsukibetsuHokenryoDankai 月別保険料段階;
    private RString ランク_4月;
    private RString ランク_5月;
    private RString ランク_6月;
    private RString ランク_7月;
    private RString ランク_8月;
    private RString ランク_9月;
    private RString ランク_10月;
    private RString ランク_11月;
    private RString ランク_12月;
    private RString ランク_1月;
    private RString ランク_2月;
    private RString ランク_3月;

    public FlexibleDate get賦課基準日() {
        return 賦課基準日;
    }

    protected void set賦課基準日(FlexibleDate 賦課基準日) {
        this.賦課基準日 = 賦課基準日;
    }

    public FlexibleDate get資格取得日() {
        return 資格取得日;
    }

    protected void set資格取得日(FlexibleDate 資格取得日) {
        this.資格取得日 = 資格取得日;
    }

    public FlexibleDate get資格喪失日() {
        return 資格喪失日;
    }

    protected void set資格喪失日(FlexibleDate 資格喪失日) {
        this.資格喪失日 = 資格喪失日;
    }

    public TsukibetsuHokenryoDankai get月別保険料段階() {
        return 月別保険料段階;
    }

    protected void set月別保険料段階(TsukibetsuHokenryoDankai 月別保険料段階) {
        this.月別保険料段階 = 月別保険料段階;
    }

    public Map<RString, RString> createRankMap() {
        Map<RString, RString> map = new HashMap<>();
        map.put(new RString("4"), ランク_4月);
        map.put(new RString("5"), ランク_5月);
        map.put(new RString("6"), ランク_6月);
        map.put(new RString("7"), ランク_7月);
        map.put(new RString("8"), ランク_8月);
        map.put(new RString("9"), ランク_9月);
        map.put(new RString("10"), ランク_10月);
        map.put(new RString("11"), ランク_11月);
        map.put(new RString("12"), ランク_12月);
        map.put(new RString("1"), ランク_1月);
        map.put(new RString("2"), ランク_2月);
        map.put(new RString("3"), ランク_3月);

        return map;
    }

    public RString getランク_4月() {
        return ランク_4月;
    }

    protected void setランク_4月(RString ランク_4月) {
        this.ランク_4月 = ランク_4月;
    }

    public RString getランク_5月() {
        return ランク_5月;
    }

    protected void setランク_5月(RString ランク_5月) {
        this.ランク_5月 = ランク_5月;
    }

    public RString getランク_6月() {
        return ランク_6月;
    }

    protected void setランク_6月(RString ランク_6月) {
        this.ランク_6月 = ランク_6月;
    }

    public RString getランク_7月() {
        return ランク_7月;
    }

    protected void setランク_7月(RString ランク_7月) {
        this.ランク_7月 = ランク_7月;
    }

    public RString getランク_8月() {
        return ランク_8月;
    }

    protected void setランク_8月(RString ランク_8月) {
        this.ランク_8月 = ランク_8月;
    }

    public RString getランク_9月() {
        return ランク_9月;
    }

    protected void setランク_9月(RString ランク_9月) {
        this.ランク_9月 = ランク_9月;
    }

    public RString getランク_10月() {
        return ランク_10月;
    }

    protected void setランク_10月(RString ランク_10月) {
        this.ランク_10月 = ランク_10月;
    }

    public RString getランク_11月() {
        return ランク_11月;
    }

    protected void setランク_11月(RString ランク_11月) {
        this.ランク_11月 = ランク_11月;
    }

    public RString getランク_12月() {
        return ランク_12月;
    }

    protected void setランク_12月(RString ランク_12月) {
        this.ランク_12月 = ランク_12月;
    }

    public RString getランク_1月() {
        return ランク_1月;
    }

    protected void setランク_1月(RString ランク_1月) {
        this.ランク_1月 = ランク_1月;
    }

    public RString getランク_2月() {
        return ランク_2月;
    }

    protected void setランク_2月(RString ランク_2月) {
        this.ランク_2月 = ランク_2月;
    }

    public RString getランク_3月() {
        return ランク_3月;
    }

    protected void setランク_3月(RString ランク_3月) {
        this.ランク_3月 = ランク_3月;
    }

}
