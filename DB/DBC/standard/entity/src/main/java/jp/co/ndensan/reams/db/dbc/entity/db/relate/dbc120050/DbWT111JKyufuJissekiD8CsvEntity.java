/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績D8一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111JKyufuJissekiD8CsvEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private KokanShikibetsuNo 交換情報識別番号;
    @CsvField(order = 40, name = "入力識別番号")
    private NyuryokuShikibetsuNo 入力識別番号;
    @CsvField(order = 50, name = "レコード種別コード")
    private RString レコード種別コード;
    @CsvField(order = 60, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 70, name = "証記載保険者番号")
    private HokenshaNo 証記載保険者番号;
    @CsvField(order = 80, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 90, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 100, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 110, name = "受付年月日")
    private FlexibleDate 受付年月日;
    @CsvField(order = 120, name = "決定年月日")
    private FlexibleDate 決定年月日;
    @CsvField(order = 130, name = "公費１負担番号")
    private RString 公費１負担番号;
    @CsvField(order = 140, name = "公費２負担番号")
    private RString 公費２負担番号;
    @CsvField(order = 150, name = "公費３負担番号")
    private RString 公費３負担番号;
    @CsvField(order = 160, name = "利用者負担額")
    private int 利用者負担額;
    @CsvField(order = 170, name = "公費１負担額")
    private int 公費１負担額;
    @CsvField(order = 180, name = "公費２負担額")
    private int 公費２負担額;
    @CsvField(order = 190, name = "公費３負担額")
    private int 公費３負担額;
    @CsvField(order = 200, name = "支給額")
    private int 支給額;
    @CsvField(order = 210, name = "公費１支給額")
    private int 公費１支給額;
    @CsvField(order = 220, name = "公費２支給額")
    private int 公費２支給額;
    @CsvField(order = 230, name = "公費３支給額")
    private int 公費３支給額;
    @CsvField(order = 240, name = "審査年月")
    private FlexibleYearMonth 審査年月;
}
