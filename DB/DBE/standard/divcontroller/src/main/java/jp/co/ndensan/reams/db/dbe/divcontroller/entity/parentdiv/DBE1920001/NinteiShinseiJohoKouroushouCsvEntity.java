/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報ファイルEntity(厚労省)です。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoKouroushouCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 5, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 6, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 7, name = "主キー補助項目")
    private RString 主キー補助項目;
    @CsvField(order = 8, name = "申請区分(法令)コード")
    private RString 申請区分コード_法令;
    @CsvField(order = 9, name = "申請区分(申請時)コード")
    private RString 申請区分コード_申請時;
    @CsvField(order = 10, name = "取下区分コード")
    private RString 取下区分コード;
    @CsvField(order = 11, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 12, name = "申請代行区分コード")
    private RString 申請代行区分コード;
    @CsvField(order = 13, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 14, name = "年齢")
    private RString 年齢;
    @CsvField(order = 15, name = "性別")
    private RString 性別;
    @CsvField(order = 16, name = "氏名(カナ)")
    private RString 氏名_カナ;
    @CsvField(order = 17, name = "氏名")
    private RString 氏名;
    private int 項目数;
}
