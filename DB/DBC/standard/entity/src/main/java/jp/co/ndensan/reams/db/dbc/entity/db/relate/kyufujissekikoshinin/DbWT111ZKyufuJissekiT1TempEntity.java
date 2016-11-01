/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績T1一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111ZKyufuJissekiT1TempEntity {

    private int 連番;
    private RString レコード番号;
    private RString 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 通し番号;
    private ServiceShuruiCode サービス種類コード;
    private Integer サービス実日数;
    private Decimal 計画単位数;
    private Decimal 限度額管理対象単位数;
    private Decimal 限度額管理対象外単位数;
    private Integer 短期入所計画日数;
    private Integer 短期入所実日数;
    private Decimal 保険_単位数合計;
    private Decimal 保険_単位数単価;
    private Decimal 保険_請求額;
    private Decimal 保険_利用者負担額;
    private Decimal 公費１_単位数合計;
    private Decimal 公費１_請求額;
    private Decimal 公費１_本人負担額;
    private Decimal 公費２_単位数合計;
    private Decimal 公費２_請求額;
    private Decimal 公費２_本人負担額;
    private Decimal 公費３_単位数合計;
    private Decimal 公費３_請求額;
    private Decimal 公費３_本人負担額;
    private Decimal 保険_出来高単位数合計;
    private Decimal 保険_出来高請求額;
    private Decimal 保険_出来高医療費利用者負担額;
    private Decimal 公費１_出来高単位数合計;
    private Decimal 公費１_出来高請求額;
    private Decimal 公費１_出来高医療費利用者負担額;
    private Decimal 公費２_出来高単位数合計;
    private Decimal 公費２_出来高請求額;
    private Decimal 公費２_出来高医療費本人負担額;
    private Decimal 公費３_出来高単位数合計;
    private Decimal 公費３_出来高請求額;
    private Decimal 公費３_出来高医療費本人負担額;
    private Integer 後_短期入所実日数;
    private Decimal 後_単位数合計;
    private Decimal 後_保険請求分請求額;
    private Decimal 後_公費１_単位数合計;
    private Decimal 後_公費１_請求額;
    private Decimal 後_公費２_単位数合計;
    private Decimal 後_公費２_請求額;
    private Decimal 後_公費３_単位数合計;
    private Decimal 後_公費３_請求額;
    private Decimal 後_保険_出来高単位数合計;
    private Decimal 後_保険_出来高請求額;
    private Decimal 後_公費１_出来高単位数合計;
    private Decimal 後_公費１_出来高請求額;
    private Decimal 後_公費２_出来高単位数合計;
    private Decimal 後_公費２_出来高請求額;
    private Decimal 後_公費３_出来高単位数合計;
    private Decimal 後_公費３_出来高請求額;
    private Integer 再審査回数;
    private Integer 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}
