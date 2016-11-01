/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc170020;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護サービス内容取込結果のCSVファイルのエンティティです。
 *
 * @reamsid_L DBC-3400-030 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoSabisuNaiyoCsvEntity {

    @CsvField(order = 1, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 2, name = "サービス項目コード")
    private RString サービス項目コード;
    @CsvField(order = 3, name = "提供開始年月")
    private RString 提供開始年月;
    @CsvField(order = 4, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 5, name = "提供終了年月")
    private RString 提供終了年月;
    @CsvField(order = 6, name = "サービス名称")
    private RString サービス名称;
    @CsvField(order = 7, name = "サービス略称")
    private RString サービス略称;
    @CsvField(order = 8, name = "単位数")
    private RString 単位数;
    @CsvField(order = 9, name = "単位数識別")
    private RString 単位数識別;
    @CsvField(order = 10, name = "単位数算定単位")
    private RString 単位数算定単位;
    @CsvField(order = 11, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 12, name = "限度額対象外フラグ")
    private RString 限度額対象外フラグ;
    @CsvField(order = 13, name = "外部サービス利用型区分")
    private RString 外部サービス利用型区分;
    @CsvField(order = 14, name = "特別地域加算フラグ")
    private RString 特別地域加算フラグ;
    @CsvField(order = 15, name = "利用者負担定率・定額区分")
    private RString 利用者負担定率_定額区分;
    @CsvField(order = 16, name = "更新有無フラグ")
    private RString 更新有無フラグ;
    @CsvField(order = 17, name = "元点数")
    private RString 元点数;
    @CsvField(order = 18, name = "元限度額対象外フラグ")
    private RString 元限度額対象外フラグ;
    @CsvField(order = 19, name = "元単位数識別コード")
    private RString 元単位数識別コード;
    @CsvField(order = 20, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 21, name = "給付率")
    private RString 給付率;
    @CsvField(order = 22, name = "二次予防事業対象者実施区分（非該当）")
    private RString 二次予防事業対象者実施区分_非該当;
    @CsvField(order = 23, name = "要支援１受給者実施区分")
    private RString 要支援１受給者実施区分;
    @CsvField(order = 24, name = "要支援２受給者実施区分")
    private RString 要支援２受給者実施区分;
    @CsvField(order = 25, name = "対象事業者実施区分")
    private RString 対象事業者実施区分;
    @CsvField(order = 26, name = "対象事業者実施区分")
    private RString 総合事業サービス区分;
    @CsvField(order = 27, name = "制限日数回数")
    private RString 制限日数回数;
    @CsvField(order = 28, name = "算定回数制限期間区分")
    private RString 算定回数制限期間区分;
}
