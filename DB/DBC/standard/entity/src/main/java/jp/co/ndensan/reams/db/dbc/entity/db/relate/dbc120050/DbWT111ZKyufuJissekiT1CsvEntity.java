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
 * 給付実績T1一時TBLテーブルのcsvEntity。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111ZKyufuJissekiT1CsvEntity {

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
    @CsvField(order = 110, name = "サービス種類コード")
    private ServiceShuruiCode サービス種類コード;
    @CsvField(order = 120, name = "サービス実日数")
    private Integer サービス実日数;
    @CsvField(order = 130, name = "計画単位数")
    private Decimal 計画単位数;
    @CsvField(order = 140, name = "限度額管理対象単位数")
    private Decimal 限度額管理対象単位数;
    @CsvField(order = 150, name = "限度額管理対象外単位数")
    private Decimal 限度額管理対象外単位数;
    @CsvField(order = 160, name = "短期入所計画日数")
    private Integer 短期入所計画日数;
    @CsvField(order = 170, name = "短期入所実日数")
    private Integer 短期入所実日数;
    @CsvField(order = 180, name = "保険_単位数合計")
    private Decimal 保険_単位数合計;
    @CsvField(order = 190, name = "保険_単位数単価")
    private Decimal 保険_単位数単価;
    @CsvField(order = 200, name = "保険_請求額")
    private Decimal 保険_請求額;
    @CsvField(order = 210, name = "保険_利用者負担額")
    private Decimal 保険_利用者負担額;
    @CsvField(order = 220, name = "公費１_単位数合計")
    private Decimal 公費１_単位数合計;
    @CsvField(order = 230, name = "公費１_請求額")
    private Decimal 公費１_請求額;
    @CsvField(order = 240, name = "公費１_本人負担額")
    private Decimal 公費１_本人負担額;
    @CsvField(order = 250, name = "公費２_単位数合計")
    private Decimal 公費２_単位数合計;
    @CsvField(order = 260, name = "公費２_請求額")
    private Decimal 公費２_請求額;
    @CsvField(order = 270, name = "公費２_本人負担額")
    private Decimal 公費２_本人負担額;
    @CsvField(order = 280, name = "公費３_単位数合計")
    private Decimal 公費３_単位数合計;
    @CsvField(order = 290, name = "公費３_請求額")
    private Decimal 公費３_請求額;
    @CsvField(order = 300, name = "公費３_本人負担額")
    private Decimal 公費３_本人負担額;
    @CsvField(order = 310, name = "保険_出来高単位数合計")
    private Decimal 保険_出来高単位数合計;
    @CsvField(order = 320, name = "保険_出来高請求額")
    private Decimal 保険_出来高請求額;
    @CsvField(order = 330, name = "保険_出来高医療費利用者負担額")
    private Decimal 保険_出来高医療費利用者負担額;
    @CsvField(order = 340, name = "公費１_出来高単位数合計")
    private Decimal 公費１_出来高単位数合計;
    @CsvField(order = 350, name = "公費１_出来高請求額")
    private Decimal 公費１_出来高請求額;
    @CsvField(order = 360, name = "公費１_出来高医療費利用者負担額")
    private Decimal 公費１_出来高医療費利用者負担額;
    @CsvField(order = 370, name = "公費２_出来高単位数合計")
    private Decimal 公費２_出来高単位数合計;
    @CsvField(order = 380, name = "公費２_出来高請求額")
    private Decimal 公費２_出来高請求額;
    @CsvField(order = 390, name = "公費２_出来高医療費本人負担額")
    private Decimal 公費２_出来高医療費本人負担額;
    @CsvField(order = 400, name = "公費３_出来高単位数合計")
    private Decimal 公費３_出来高単位数合計;
    @CsvField(order = 410, name = "公費３_出来高請求額")
    private Decimal 公費３_出来高請求額;
    @CsvField(order = 420, name = "公費３_出来高医療費本人負担額")
    private Decimal 公費３_出来高医療費本人負担額;
    @CsvField(order = 430, name = "後_短期入所実日数")
    private Integer 後_短期入所実日数;
    @CsvField(order = 440, name = "後_単位数合計")
    private Decimal 後_単位数合計;
    @CsvField(order = 450, name = "後_保険請求分請求額")
    private Decimal 後_保険請求分請求額;
    @CsvField(order = 460, name = "後_公費１_単位数合計")
    private Decimal 後_公費１_単位数合計;
    @CsvField(order = 470, name = "後_公費１_請求額")
    private Decimal 後_公費１_請求額;
    @CsvField(order = 480, name = "後_公費２_単位数合計")
    private Decimal 後_公費２_単位数合計;
    @CsvField(order = 490, name = "後_公費２_請求額")
    private Decimal 後_公費２_請求額;
    @CsvField(order = 500, name = "後_公費３_単位数合計")
    private Decimal 後_公費３_単位数合計;
    @CsvField(order = 510, name = "後_公費３_請求額")
    private Decimal 後_公費３_請求額;
    @CsvField(order = 520, name = "後_保険_出来高単位数合計")
    private Decimal 後_保険_出来高単位数合計;
    @CsvField(order = 530, name = "後_保険_出来高請求額")
    private Decimal 後_保険_出来高請求額;
    @CsvField(order = 540, name = "後_公費１_出来高単位数合計")
    private Decimal 後_公費１_出来高単位数合計;
    @CsvField(order = 550, name = "後_公費１_出来高請求額")
    private Decimal 後_公費１_出来高請求額;
    @CsvField(order = 560, name = "後_公費２_出来高単位数合計")
    private Decimal 後_公費２_出来高単位数合計;
    @CsvField(order = 570, name = "後_公費２_出来高請求額")
    private Decimal 後_公費２_出来高請求額;
    @CsvField(order = 580, name = "後_公費３_出来高単位数合計")
    private Decimal 後_公費３_出来高単位数合計;
    @CsvField(order = 590, name = "後_公費３_出来高請求額")
    private Decimal 後_公費３_出来高請求額;
    @CsvField(order = 600, name = "再審査回数")
    private Integer 再審査回数;
    @CsvField(order = 610, name = "過誤回数")
    private Integer 過誤回数;
    @CsvField(order = 620, name = "審査年月")
    private FlexibleYearMonth 審査年月;

}
