/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込の高額介護サービス費情報レコードのCsvMeisaiEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity {
    
    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号（連番）")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 70, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 100, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 110, name = "受付年月日")
    private RString 受付年月日;
    @CsvField(order = 120, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 130, name = "公費１負担番号")
    private RString 公費１負担番号;
    @CsvField(order = 140, name = "公費２負担番号")
    private RString 公費２負担番号;
    @CsvField(order = 150, name = "公費３負担番号")
    private RString 公費３負担番号;
    @CsvField(order = 160, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 170, name = "公費１負担額")
    private RString 公費１負担額;
    @CsvField(order = 180, name = "公費２負担額")
    private RString 公費２負担額;
    @CsvField(order = 190, name = "公費３負担額")
    private RString 公費３負担額;
    @CsvField(order = 200, name = "支給額")
    private RString 支給額;
    @CsvField(order = 210, name = "公費１支給額")
    private RString 公費１支給額;
    @CsvField(order = 220, name = "公費２支給額")
    private RString 公費２支給額;
    @CsvField(order = 230, name = "公費３支給額")
    private RString 公費３支給額;
    @CsvField(order = 240, name = "審査年月")
    private RString 審査年月;
    @CsvField(order = 250, name = "ブランク")
    private RString ブランク;
    
}
