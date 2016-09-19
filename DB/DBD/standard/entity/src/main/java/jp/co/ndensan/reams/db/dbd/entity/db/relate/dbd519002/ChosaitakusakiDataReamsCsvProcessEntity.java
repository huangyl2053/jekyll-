/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * (認定調査委託先情報CSV)_電算版CSVのentityです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaitakusakiDataReamsCsvProcessEntity {

    @CsvField(order = 10, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 20, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 30, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 40, name = "認定調査委託先コード")
    private RString 認定調査委託先コード;
    @CsvField(order = 50, name = "事業者名称")
    private RString 事業者名称;
    @CsvField(order = 60, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 70, name = "住所")
    private RString 住所;
    @CsvField(order = 80, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 90, name = "調査委託区分")
    private RString 調査委託区分;
    @CsvField(order = 100, name = "状況フラグ")
    private RString 状況フラグ;

    /**
     * コンストラクタです。
     *
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 機能コード 機能コード
     * @param 識別コード 識別コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 事業者名称 事業者名称
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 調査委託区分 調査委託区分
     * @param 状況フラグ 状況フラグ
     */
    public ChosaitakusakiDataReamsCsvProcessEntity(
            RString シーケンシャル番号,
            RString 機能コード,
            RString 識別コード,
            RString 認定調査委託先コード,
            RString 事業者名称,
            RString 郵便番号,
            RString 住所,
            RString 電話番号,
            RString 調査委託区分,
            RString 状況フラグ) {
        this.シーケンシャル番号 = シーケンシャル番号;
        this.機能コード = 機能コード;
        this.識別コード = 識別コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.事業者名称 = 事業者名称;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.調査委託区分 = 調査委託区分;
        this.状況フラグ = 状況フラグ;
    }
}
