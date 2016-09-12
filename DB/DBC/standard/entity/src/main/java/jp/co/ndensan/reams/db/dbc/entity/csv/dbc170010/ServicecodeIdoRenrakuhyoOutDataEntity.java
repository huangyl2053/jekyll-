/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc170010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 送付対象データのクラスです。
 *
 * @reamsid_L DBC-4740-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServicecodeIdoRenrakuhyoOutDataEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号_連番;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "異動年月日")
    private RString 異動年月日;
    @CsvField(order = 50, name = "異動区分コード")
    private RString 異動区分コード;
    @CsvField(order = 60, name = "異動事由")
    private RString 異動事由;
    @CsvField(order = 70, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 90, name = "サービス項目コード")
    private RString サービス項目コード;
    @CsvField(order = 100, name = "適用開始年月")
    private RString 適用開始年月;
    @CsvField(order = 110, name = "適用終了年月")
    private RString 適用終了年月;
    @CsvField(order = 120, name = "サービス名称")
    private RString サービス名称;
    @CsvField(order = 130, name = "単位数")
    private RString 単位数;
    @CsvField(order = 140, name = "算定単位")
    private RString 算定単位;
    @CsvField(order = 150, name = "制限日数・回数")
    private RString 制限日数回数;
    @CsvField(order = 160, name = "算定回数制限期間")
    private RString 算定回数制限期間;
    @CsvField(order = 170, name = "支給限度額対象区分")
    private RString 支給限度額対象区分;
    @CsvField(order = 180, name = "給付率")
    private RString 給付率;
    @CsvField(order = 190, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 200, name = "事業対象者実施区分")
    private RString 事業対象者実施区分;
    @CsvField(order = 210, name = "要支援１受給者実施区分")
    private RString 要支援１受給者実施区分;
    @CsvField(order = 220, name = "要支援２受給者実施区分")
    private RString 要支援２受給者実施区分;
}
