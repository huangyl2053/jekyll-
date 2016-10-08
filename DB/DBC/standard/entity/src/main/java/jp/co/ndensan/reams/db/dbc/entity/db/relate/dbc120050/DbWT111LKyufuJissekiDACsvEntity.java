/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績DA一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111LKyufuJissekiDACsvEntity {

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
    @CsvField(order = 60, name = "証記載保険者番号")
    private HokenshaNo 証記載保険者番号;
    @CsvField(order = 70, name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @CsvField(order = 80, name = "サービス提供年月")
    private FlexibleYearMonth サービス提供年月;
    @CsvField(order = 90, name = "事業所番号")
    private JigyoshaNo 事業所番号;
    @CsvField(order = 100, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 110, name = "軽減率")
    private Decimal 軽減率;
    @CsvField(order = 120, name = "サービス種類コード")
    private ServiceShuruiCode サービス種類コード;
    @CsvField(order = 130, name = "受領すべき利用者負担の総額")
    private Decimal 受領すべき利用者負担の総額;
    @CsvField(order = 140, name = "軽減額")
    private Decimal 軽減額;
    @CsvField(order = 150, name = "軽減後利用者負担額")
    private Decimal 軽減後利用者負担額;
    @CsvField(order = 160, name = "備考")
    private RString 備考;
    @CsvField(order = 170, name = "後_受領すべき利用者負担の総額")
    private Decimal 後_受領すべき利用者負担の総額;
    @CsvField(order = 180, name = "後_軽減額")
    private Decimal 後_軽減額;
    @CsvField(order = 190, name = "後_軽減後利用者負担額")
    private Decimal 後_軽減後利用者負担額;
    @CsvField(order = 200, name = "再審査回数")
    private Integer 再審査回数;
    @CsvField(order = 210, name = "過誤回数")
    private Integer 過誤回数;
    @CsvField(order = 220, name = "審査年月")
    private FlexibleYearMonth 審査年月;

}
