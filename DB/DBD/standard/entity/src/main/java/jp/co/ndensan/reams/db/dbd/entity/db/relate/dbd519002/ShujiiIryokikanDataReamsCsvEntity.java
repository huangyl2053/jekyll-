/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * (主治医医療機関情報CSV)_電算版entityです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIryokikanDataReamsCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "医療機関コード")
    private RString 医療機関コード;
    @CsvField(order = 5, name = "医療機関名称")
    private RString 医療機関名称;
    @CsvField(order = 6, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 7, name = "住所")
    private RString 住所;
    @CsvField(order = 8, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 9, name = "状況フラグ")
    private RString 状況フラグ;

    /**
     * コンストラクタです。
     *
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 機能コード 機能コード
     * @param 識別コード 識別コード
     * @param 医療機関コード 医療機関コード
     * @param 医療機関名称 医療機関名称
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 状況フラグ 状況フラグ
     */
    public ShujiiIryokikanDataReamsCsvEntity(
            RString シーケンシャル番号,
            RString 機能コード,
            RString 識別コード,
            RString 医療機関コード,
            RString 医療機関名称,
            RString 郵便番号,
            RString 住所,
            RString 電話番号,
            RString 状況フラグ) {
        this.シーケンシャル番号 = シーケンシャル番号;
        this.機能コード = 機能コード;
        this.識別コード = 識別コード;
        this.医療機関コード = 医療機関コード;
        this.医療機関名称 = 医療機関名称;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.状況フラグ = 状況フラグ;
    }

}
