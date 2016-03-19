/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費決定情報取込みの集計レコード
 */
public class KogakuKyufuKetteiInShukaiCSVEntity {

    @CsvField(order = 320, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 330, name = "資格喪失事由")
    private RString 資格喪失事由;
    @CsvField(order = 340, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 350, name = "全国住所コード")
    private RString 全国住所コード;
    @CsvField(order = 360, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 370, name = "住所")
    private RString 住所;
    @CsvField(order = 380, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 390, name = "行政区")
    private RString 行政区;
    @CsvField(order = 400, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 410, name = "氏名")
    private RString 氏名;

    /**
     * 識別コードを取得する。
     *
     * @return 識別コード RString
     */
    public RString get識別コード() {
        return 識別コード;
    }

    /**
     * 識別コード。
     *
     * @param 識別コード RString
     */
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /**
     * 資格喪失事由を取得する。
     *
     * @return 資格喪失事由 RString
     */
    public RString get資格喪失事由() {
        return 資格喪失事由;
    }

    /**
     * 資格喪失事由。
     *
     * @param 資格喪失事由 RString
     */
    public void set資格喪失事由(RString 資格喪失事由) {
        this.資格喪失事由 = 資格喪失事由;
    }

    /**
     * 資格喪失年月日を取得する。
     *
     * @return 資格喪失年月日 RString
     */
    public RString get資格喪失年月日() {
        return 資格喪失年月日;
    }

    /**
     * 資格喪失年月日。
     *
     * @param 資格喪失年月日 RString
     */
    public void set資格喪失年月日(RString 資格喪失年月日) {
        this.資格喪失年月日 = 資格喪失年月日;
    }

    /**
     * 全国住所コードを取得する。
     *
     * @return 全国住所コード RString
     */
    public RString get全国住所コード() {
        return 全国住所コード;
    }

    /**
     * 全国住所コード。
     *
     * @param 全国住所コード RString
     */
    public void set全国住所コード(RString 全国住所コード) {
        this.全国住所コード = 全国住所コード;
    }

    /**
     * 郵便番号
     *
     * @return RString
     */
    public RString get郵便番号() {
        return 郵便番号;
    }

    /**
     * set郵便番号
     *
     * @param 郵便番号 RString
     */
    public void set郵便番号(RString 郵便番号) {
        this.郵便番号 = 郵便番号;
    }

    /**
     * get住所
     *
     * @return RString
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * set住所
     *
     * @param 住所 RString
     */
    public void set住所(RString 住所) {
        this.住所 = 住所;
    }

    /**
     * get行政区コード
     *
     * @return RString
     */
    public RString get行政区コード() {
        return 行政区コード;
    }

    /**
     * set行政区コード
     *
     * @param 行政区コード RString
     */
    public void set行政区コード(RString 行政区コード) {
        this.行政区コード = 行政区コード;
    }

    /**
     * get行政区
     *
     * @return RString
     */
    public RString get行政区() {
        return 行政区;
    }

    /**
     * set行政区
     *
     * @param 行政区 RString
     */
    public void set行政区(RString 行政区) {
        this.行政区 = 行政区;
    }

    /**
     * get氏名カナ
     *
     * @return RString
     */
    public RString get氏名カナ() {
        return 氏名カナ;
    }

    /**
     * set氏名カナ
     *
     * @param 氏名カナ RString
     */
    public void set氏名カナ(RString 氏名カナ) {
        this.氏名カナ = 氏名カナ;
    }

    /**
     * get氏名
     *
     * @return RString
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * set氏名
     *
     * @param 氏名 RString
     */
    public void set氏名(RString 氏名) {
        this.氏名 = 氏名;
    }

}
