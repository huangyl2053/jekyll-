/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報CSV_電算版のentityです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiDataReamsCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "主治医医療機関コード")
    private RString 主治医医療機関コード;
    @CsvField(order = 5, name = "主治医コード")
    private RString 主治医コード;
    @CsvField(order = 6, name = "主治医氏名")
    private RString 主治医氏名;
    @CsvField(order = 7, name = "状況フラグ")
    private RString 状況フラグ;

    /**
     * コンストラクタです。
     *
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 機能コード 機能コード
     * @param 識別コード 識別コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 主治医氏名 主治医氏名
     * @param 主治医カナ 主治医カナ
     * @param 状況フラグ 状況フラグ
     */
    public ShujiiDataReamsCsvEntity(
            RString シーケンシャル番号,
            RString 機能コード,
            RString 識別コード,
            RString 主治医医療機関コード,
            RString 主治医コード,
            RString 主治医氏名,
            RString 状況フラグ) {
        this.シーケンシャル番号 = シーケンシャル番号;
        this.機能コード = 機能コード;
        this.識別コード = 識別コード;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.主治医氏名 = 主治医氏名;
        this.状況フラグ = 状況フラグ;
    }

}
