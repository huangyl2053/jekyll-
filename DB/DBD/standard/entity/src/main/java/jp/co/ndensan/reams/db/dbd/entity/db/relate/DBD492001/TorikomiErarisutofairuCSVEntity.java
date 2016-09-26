/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * エラーメッセージEntity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiErarisutofairuCSVEntity {

    @CsvField(order = 1, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 2, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 3, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 4, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 5, name = "枝番")
    private RString 枝番;
    @CsvField(order = 6, name = "申請区分_法令_コード")
    private RString 申請区分_法令_コード;
    @CsvField(order = 7, name = "申請区分_申請時_コード")
    private RString 申請区分_申請時_コード;
    @CsvField(order = 8, name = "取下区分コード")
    private RString 取下区分コード;
    @CsvField(order = 9, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 10, name = "申請代行区分コード")
    private RString 申請代行区分コード;
    @CsvField(order = 11, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 12, name = "年齢")
    private RString 年齢;
    @CsvField(order = 13, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 14, name = "被保険者ｶﾅ氏名")
    private RString 被保険者ｶﾅ氏名;
    @CsvField(order = 15, name = "被保険者漢字氏名")
    private RString 被保険者漢字氏名;
    @CsvField(order = 16, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 17, name = "住所")
    private RString 住所;
    @CsvField(order = 18, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 19, name = "病院施設等の名称")
    private RString 病院施設等の名称;
    @CsvField(order = 20, name = "病院施設等の所在地")
    private RString 病院施設等の所在地;
    @CsvField(order = 21, name = "エラーメッセージ")
    private RString エラーメッセージ;

}
