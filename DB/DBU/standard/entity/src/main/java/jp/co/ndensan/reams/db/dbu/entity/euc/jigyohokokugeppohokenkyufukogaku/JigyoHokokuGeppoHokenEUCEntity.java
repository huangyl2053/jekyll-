/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.euc.jigyohokokugeppohokenkyufukogaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 根拠CSV作成情報のCSV用データEntityです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class JigyoHokokuGeppoHokenEUCEntity implements IJigyoHokokuGeppoHokenEUCEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "集計区分")
    private RString 集計区分;
    @CsvField(order = 3, name = "表番号")
    private RString 表番号;
    @CsvField(order = 4, name = "集計番号")
    private RString 集計番号;
    @CsvField(order = 5, name = "集計単位")
    private RString 集計単位;
    @CsvField(order = 6, name = "縦番号")
    private RString 縦番号;
    @CsvField(order = 7, name = "横番号")
    private RString 横番号;
    @CsvField(order = 8, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 9, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 10, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 11, name = "履歴番号")
    private int 履歴番号;
    @CsvField(order = 12, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 13, name = "支給金額")
    private Decimal 支給金額;
    @CsvField(order = 14, name = "支払済金額合計")
    private Decimal 支払済金額合計;
    @CsvField(order = 15, name = "世帯集約番号")
    private RString 世帯集約番号;
    @CsvField(order = 16, name = "様式区分")
    private RString 様式区分;
    @CsvField(order = 17, name = "世帯合算受給区分")
    private RString 世帯合算受給区分;
    @CsvField(order = 18, name = "備考1")
    private RString 備考1;
    @CsvField(order = 19, name = "備考2")
    private RString 備考2;
    @CsvField(order = 20, name = "備考3")
    private RString 備考3;
    @CsvField(order = 21, name = "備考4")
    private RString 備考4;
    @CsvField(order = 22, name = "備考5")
    private RString 備考5;
    @CsvField(order = 23, name = "入力識別番号")
    private NyuryokuShikibetsuNo 入力識別番号;
    @CsvField(order = 24, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 25, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 26, name = "公費１負担番号")
    private RString 公費１負担番号;
    @CsvField(order = 27, name = "公費２負担番号")
    private RString 公費２負担番号;
    @CsvField(order = 28, name = "公費３負担番号")
    private RString 公費３負担番号;
    @CsvField(order = 29, name = "公費１支給額")
    private Decimal 公費１支給額;
    @CsvField(order = 30, name = "公費２支給額")
    private Decimal 公費２支給額;
    @CsvField(order = 31, name = "公費３支給額")
    private Decimal 公費３支給額;
    @CsvField(order = 32, name = "審査年月")
    private FlexibleYearMonth 審査年月;
    @CsvField(order = 33, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 34, name = "広住特措置元市町村コード")
    private LasdecCode 広住特措置元市町村コード;
    @CsvField(order = 35, name = "旧市町村コード")
    private LasdecCode 旧市町村コード;
}
