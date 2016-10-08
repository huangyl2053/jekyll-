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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績D5一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111GKyufuJissekiD53CsvEntity {

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
    @CsvField(order = 110, name = "指定_基準該当等事業所区分コード")
    private RString 指定_基準該当等事業所区分コード;
    @CsvField(order = 120, name = "単位数単価")
    private Decimal 単位数単価;
    @CsvField(order = 130, name = "居宅サービス計画作成依頼届出年月日")
    private FlexibleDate 居宅サービス計画作成依頼届出年月日;
    @CsvField(order = 140, name = "サービス計画費明細行番号")
    private RString サービス計画費明細行番号;
    @CsvField(order = 150, name = "サービスコード")
    private ServiceCode サービスコード;
    @CsvField(order = 160, name = "単位数")
    private Decimal 単位数;
    @CsvField(order = 170, name = "回数")
    private Integer 回数;
    @CsvField(order = 180, name = "サービス単位数")
    private Decimal サービス単位数;
    @CsvField(order = 190, name = "サービス単位数合計")
    private Decimal サービス単位数合計;
    @CsvField(order = 200, name = "請求金額")
    private Decimal 請求金額;
    @CsvField(order = 210, name = "担当介護支援専門員番号")
    private RString 担当介護支援専門員番号;
    @CsvField(order = 220, name = "摘要")
    private RString 摘要;
    @CsvField(order = 230, name = "後_単位数")
    private Decimal 後_単位数;
    @CsvField(order = 240, name = "後_回数")
    private Integer 後_回数;
    @CsvField(order = 250, name = "後_サービス単位数")
    private Decimal 後_サービス単位数;
    @CsvField(order = 260, name = "後_サービス単位数合計")
    private Decimal 後_サービス単位数合計;
    @CsvField(order = 270, name = "後_請求金額")
    private Decimal 後_請求金額;
    @CsvField(order = 280, name = "再審査回数")
    private Integer 再審査回数;
    @CsvField(order = 290, name = "過誤回数")
    private Integer 過誤回数;
    @CsvField(order = 300, name = "審査年月")
    private FlexibleYearMonth 審査年月;
}
