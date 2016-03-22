/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費決定情報取込みの明細レコード
 */
public class KogakuKyufuKetteiInMeisaiCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 30, name = "No")
    private RString no;
    @CsvField(order = 40, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 50, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 60, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 70, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 80, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 90, name = "決定年月")
    private RString 決定年月;
    @CsvField(order = 100, name = "高額支給額")
    private RString 高額支給額;
    @CsvField(order = 110, name = "支払方法区分コード")
    private RString 支払方法区分コード;
    @CsvField(order = 120, name = "支払場所")
    private RString 支払場所;
    @CsvField(order = 130, name = "開始年月日")
    private RString 開始年月日;
    @CsvField(order = 140, name = "終了年月日")
    private RString 終了年月日;
    @CsvField(order = 150, name = "開始曜日")
    private RString 開始曜日;
    @CsvField(order = 160, name = "終了曜日")
    private RString 終了曜日;
    @CsvField(order = 170, name = "開始時間")
    private RString 開始時間;
    @CsvField(order = 180, name = "終了時間")
    private RString 終了時間;
    @CsvField(order = 190, name = "金融機関コード")
    private RString 金融機関コード;
    @CsvField(order = 200, name = "金融機関名")
    private RString 金融機関名;
    @CsvField(order = 210, name = "金融機関支店コード")
    private RString 金融機関支店コード;
    @CsvField(order = 220, name = "金融機関支店名")
    private RString 金融機関支店名;
    @CsvField(order = 230, name = "口座種目")
    private RString 口座種目;
    @CsvField(order = 240, name = "口座種目名")
    private RString 口座種目名;
    @CsvField(order = 250, name = "口座番号")
    private RString 口座番号;
    @CsvField(order = 260, name = "口座名義人カナ")
    private RString 口座名義人カナ;

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
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(RString 交換情報識別番号) {
        this.交換情報識別番号 = 交換情報識別番号;
    }

    /**
     * 帳票レコード種別を取得する。
     *
     * @return 帳票レコード種別
     */
    public RString get帳票レコード種別() {
        return 帳票レコード種別;
    }

    /**
     * 帳票レコード種別。
     *
     * @param 帳票レコード種別 RString
     */
    public void set帳票レコード種別(RString 帳票レコード種別) {
        this.帳票レコード種別 = 帳票レコード種別;
    }

    /**
     * Noを取得する。
     *
     * @return No
     */
    public RString getNo() {
        return no;
    }

    /**
     * setNo
     *
     * @param no RString
     */
    public void setNo(RString no) {
        this.no = no;
    }

    /**
     * 被保険者番号を取得する。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 被保険者番号。
     *
     * @param 被保険者番号 RString
     */
    public void set被保険者番号(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * get被保険者氏名
     *
     * @return RString
     */
    public RString get被保険者氏名() {
        return 被保険者氏名;
    }

    /**
     * set被保険者氏名
     *
     * @param 被保険者氏名 RString
     */
    public void set被保険者氏名(RString 被保険者氏名) {
        this.被保険者氏名 = 被保険者氏名;
    }

    /**
     * getサービス提供年月
     *
     * @return RString
     */
    public RString getサービス提供年月() {
        return サービス提供年月;
    }

    /**
     * setサービス提供年月
     *
     * @param サービス提供年月 RString
     */
    public void setサービス提供年月(RString サービス提供年月) {
        this.サービス提供年月 = サービス提供年月;
    }

    /**
     * get利用者負担額
     *
     * @return RString
     */
    public RString get利用者負担額() {
        return 利用者負担額;
    }

    /**
     * set利用者負担額
     *
     * @param 利用者負担額 RString
     */
    public void set利用者負担額(RString 利用者負担額) {
        this.利用者負担額 = 利用者負担額;
    }

    /**
     * get支給区分コード
     *
     * @return RString
     */
    public RString get支給区分コード() {
        return 支給区分コード;
    }

    /**
     * set支給区分コード
     *
     * @param 支給区分コード RString
     */
    public void set支給区分コード(RString 支給区分コード) {
        this.支給区分コード = 支給区分コード;
    }

    /**
     * get決定年月
     *
     * @return RString
     */
    public RString get決定年月() {
        return 決定年月;
    }

    /**
     * set決定年月
     *
     * @param 決定年月 RString
     */
    public void set決定年月(RString 決定年月) {
        this.決定年月 = 決定年月;
    }

    /**
     * get高額支給額
     *
     * @return RString
     */
    public RString get高額支給額() {
        return 高額支給額;
    }

    /**
     * set高額支給額
     *
     * @param 高額支給額 RString
     */
    public void set高額支給額(RString 高額支給額) {
        this.高額支給額 = 高額支給額;
    }

    /**
     * get支払方法区分コード
     *
     * @return RString
     */
    public RString get支払方法区分コード() {
        return 支払方法区分コード;
    }

    /**
     * set支払方法区分コード
     *
     * @param 支払方法区分コード RString
     */
    public void set支払方法区分コード(RString 支払方法区分コード) {
        this.支払方法区分コード = 支払方法区分コード;
    }

    /**
     * get支払場所
     *
     * @return RString
     */
    public RString get支払場所() {
        return 支払場所;
    }

    /**
     * set支払場所
     *
     * @param 支払場所 RString
     */
    public void set支払場所(RString 支払場所) {
        this.支払場所 = 支払場所;
    }

    /**
     * get開始年月日
     *
     * @return RString
     */
    public RString get開始年月日() {
        return 開始年月日;
    }

    /**
     * set開始年月日
     *
     * @param 開始年月日 RString
     */
    public void set開始年月日(RString 開始年月日) {
        this.開始年月日 = 開始年月日;
    }

    /**
     * get終了年月日
     *
     * @return RString
     */
    public RString get終了年月日() {
        return 終了年月日;
    }

    /**
     * set終了年月日
     *
     * @param 終了年月日 RString
     */
    public void set終了年月日(RString 終了年月日) {
        this.終了年月日 = 終了年月日;
    }

    /**
     * get開始曜日
     *
     * @return RString
     */
    public RString get開始曜日() {
        return 開始曜日;
    }

    /**
     * set開始曜日
     *
     * @param 開始曜日 RString
     */
    public void set開始曜日(RString 開始曜日) {
        this.開始曜日 = 開始曜日;
    }

    /**
     * get終了曜日
     *
     * @return RString
     */
    public RString get終了曜日() {
        return 終了曜日;
    }

    /**
     * set終了曜日
     *
     * @param 終了曜日 RString
     */
    public void set終了曜日(RString 終了曜日) {
        this.終了曜日 = 終了曜日;
    }

    /**
     * get開始時間
     *
     * @return RString
     */
    public RString get開始時間() {
        return 開始時間;
    }

    /**
     * set開始時間
     *
     * @param 開始時間 RString
     */
    public void set開始時間(RString 開始時間) {
        this.開始時間 = 開始時間;
    }

    /**
     * get終了時間
     *
     * @return RString
     */
    public RString get終了時間() {
        return 終了時間;
    }

    /**
     * set終了時間
     *
     * @param 終了時間 RString
     */
    public void set終了時間(RString 終了時間) {
        this.終了時間 = 終了時間;
    }

    /**
     * get金融機関コード
     *
     * @return RString
     */
    public RString get金融機関コード() {
        return 金融機関コード;
    }

    /**
     * set金融機関コード
     *
     * @param 金融機関コード RString
     */
    public void set金融機関コード(RString 金融機関コード) {
        this.金融機関コード = 金融機関コード;
    }

    /**
     * get金融機関名
     *
     * @return RString
     */
    public RString get金融機関名() {
        return 金融機関名;
    }

    /**
     * set金融機関名
     *
     * @param 金融機関名 RString
     */
    public void set金融機関名(RString 金融機関名) {
        this.金融機関名 = 金融機関名;
    }

    /**
     * get金融機関支店コード
     *
     * @return RString
     */
    public RString get金融機関支店コード() {
        return 金融機関支店コード;
    }

    /**
     * set金融機関支店コード
     *
     * @param 金融機関支店コード RString
     */
    public void set金融機関支店コード(RString 金融機関支店コード) {
        this.金融機関支店コード = 金融機関支店コード;
    }

    /**
     * get金融機関支店名
     *
     * @return RString
     */
    public RString get金融機関支店名() {
        return 金融機関支店名;
    }

    /**
     * set金融機関支店名
     *
     * @param 金融機関支店名 RString
     */
    public void set金融機関支店名(RString 金融機関支店名) {
        this.金融機関支店名 = 金融機関支店名;
    }

    /**
     * get口座種目
     *
     * @return RString
     */
    public RString get口座種目() {
        return 口座種目;
    }

    /**
     * set口座種目
     *
     * @param 口座種目 RString
     */
    public void set口座種目(RString 口座種目) {
        this.口座種目 = 口座種目;
    }

    /**
     * get口座種目名
     *
     * @return RString
     */
    public RString get口座種目名() {
        return 口座種目名;
    }

    /**
     * set口座種目名
     *
     * @param 口座種目名 RString
     */
    public void set口座種目名(RString 口座種目名) {
        this.口座種目名 = 口座種目名;
    }

    /**
     * get口座番号
     *
     * @return RString
     */
    public RString get口座番号() {
        return 口座番号;
    }

    /**
     * set口座番号
     *
     * @param 口座番号 RString
     */
    public void set口座番号(RString 口座番号) {
        this.口座番号 = 口座番号;
    }

    /**
     * get口座名義人カナ
     *
     * @return RString
     */
    public RString get口座名義人カナ() {
        return 口座名義人カナ;
    }

    /**
     * set口座名義人_カナ
     *
     * @param 口座名義人カナ RString
     */
    public void set口座名義人カナ(RString 口座名義人カナ) {
        this.口座名義人カナ = 口座名義人カナ;
    }

}
