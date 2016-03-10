/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤決定通知書情報取込（公費負担者分）ヘッダ部
 */
public class KagoKetteiKohifutanshaInHeaderCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 30, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 40, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 50, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 60, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 70, name = "頁")
    private RString 頁;
    @CsvField(order = 80, name = "国保連合会名")
    private RString 国保連合会名;

    /**
     * 交換情報識別番号を取得する。
     *
     * @return the 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return 交換情報識別番号;
    }

    /**
     * 交換情報識別番号を設定する。
     *
     * @param 交換情報識別番号 the 交換情報識別番号 to set
     */
    public void set交換情報識別番号(RString 交換情報識別番号) {
        this.交換情報識別番号 = 交換情報識別番号;
    }

    /**
     * 帳票レコード種別を取得する。
     *
     * @return the 帳票レコード種別
     */
    public RString get帳票レコード種別() {
        return 帳票レコード種別;
    }

    /**
     * 帳票レコード種別を設定する。
     *
     * @param 帳票レコード種別 the 帳票レコード種別 to set
     */
    public void set帳票レコード種別(RString 帳票レコード種別) {
        this.帳票レコード種別 = 帳票レコード種別;
    }

    /**
     * 取扱年月を取得する。
     *
     * @return the 取扱年月
     */
    public RString get取扱年月() {
        return 取扱年月;
    }

    /**
     * 取扱年月を設定する。
     *
     * @param 取扱年月 the 取扱年月 to set
     */
    public void set取扱年月(RString 取扱年月) {
        this.取扱年月 = 取扱年月;
    }

    /**
     * 公費負担者番号を取得する。
     *
     * @return the 公費負担者番号
     */
    public RString get公費負担者番号() {
        return 公費負担者番号;
    }

    /**
     * 公費負担者番号を設定する。
     *
     * @param 公費負担者番号 the 公費負担者番号 to set
     */
    public void set公費負担者番号(RString 公費負担者番号) {
        this.公費負担者番号 = 公費負担者番号;
    }

    /**
     * 公費負担者名を取得する。
     *
     * @return the 公費負担者名
     */
    public RString get公費負担者名() {
        return 公費負担者名;
    }

    /**
     * 公費負担者名を設定する。
     *
     * @param 公費負担者名 the 公費負担者名 to set
     */
    public void set公費負担者名(RString 公費負担者名) {
        this.公費負担者名 = 公費負担者名;
    }

    /**
     * 作成年月日を取得する。
     *
     * @return the 作成年月日
     */
    public RString get作成年月日() {
        return 作成年月日;
    }

    /**
     * 作成年月日を設定する。
     *
     * @param 作成年月日 the 作成年月日 to set
     */
    public void set作成年月日(RString 作成年月日) {
        this.作成年月日 = 作成年月日;
    }

    /**
     * 頁を取得する。
     *
     * @return the 頁
     */
    public RString get頁() {
        return 頁;
    }

    /**
     * 頁を設定する。
     *
     * @param 頁 the 頁 to set
     */
    public void set頁(RString 頁) {
        this.頁 = 頁;
    }

    /**
     * 国保連合会名を取得する。
     *
     * @return the 国保連合会名
     */
    public RString get国保連合会名() {
        return 国保連合会名;
    }

    /**
     * 国保連合会名を設定する。
     *
     * @param 国保連合会名 the 国保連合会名 to set
     */
    public void set国保連合会名(RString 国保連合会名) {
        this.国保連合会名 = 国保連合会名;
    }

}
