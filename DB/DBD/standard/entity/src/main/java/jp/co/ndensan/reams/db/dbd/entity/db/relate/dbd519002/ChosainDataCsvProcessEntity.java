/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519002;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * (認定調査員情報CSVのentityです。
 *
 * @reamsid_L DBD-2100-020 liwul
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosainDataCsvProcessEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "認定調査委託先コード")
    private RString 認定調査委託先コード;
    @CsvField(order = 5, name = "認定調査員コード")
    private RString 認定調査員コード;
    @CsvField(order = 6, name = "調査員氏名")
    private RString 調査員氏名;
    @CsvField(order = 7, name = "調査員氏名カナ")
    private RString 調査員氏名カナ;
    @CsvField(order = 8, name = "調査員資格")
    private RString 調査員資格;
    @CsvField(order = 9, name = "状況フラグ")
    private RString 状況フラグ;

    /**
     * コンストラクタです。
     *
     * @param シーケンシャル番号 シーケンシャル番号
     * @param 機能コード 機能コード
     * @param 識別コード 識別コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 調査員氏名 調査員氏名
     * @param 調査員氏名カナ 調査員氏名カナ
     * @param 調査員資格 調査員資格
     * @param 状況フラグ 状況フラグ
     */
    public ChosainDataCsvProcessEntity(
            RString シーケンシャル番号,
            RString 機能コード, RString 識別コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 調査員氏名,
            RString 調査員氏名カナ,
            RString 調査員資格,
            RString 状況フラグ) {
        this.シーケンシャル番号 = シーケンシャル番号;
        this.機能コード = 機能コード;
        this.識別コード = 識別コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.調査員氏名 = 調査員氏名;
        this.調査員氏名カナ = 調査員氏名カナ;
        this.調査員資格 = 調査員資格;
        this.状況フラグ = 状況フラグ;
    }

}
