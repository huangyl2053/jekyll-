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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D9一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111KKyufuJissekiD9TempEntity {

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
    private RString レコード順次番号;
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private Decimal 費用単価;
    private Decimal 負担限度額;
    private Integer 日数;
    private Integer 公費１日数;
    private Integer 公費２日数;
    private Integer 公費３日数;
    private Decimal 費用額;
    private Decimal 保険分請求額;
    private Decimal 公費１負担額_明細;
    private Decimal 公費２負担額_明細;
    private Decimal 公費3負担額_明細;
    private Decimal 利用者負担額;
    private Decimal 費用額合計;
    private Decimal 保険分請求額合計;
    private Decimal 利用者負担額合計;
    private Decimal 公費１_負担額合計;
    private Decimal 公費１_請求額;
    private Decimal 公費１_本人負担月額;
    private Decimal 公費２_負担額合計;
    private Decimal 公費２_請求額;
    private Decimal 公費２_本人負担月額;
    private Decimal 公費３_負担額合計;
    private Decimal 公費３_請求額;
    private Decimal 公費３_本人負担月額;
    private Decimal 後_費用単価;
    private Integer 後_日数;
    private Integer 後_公費１日数;
    private Integer 後_公費２日数;
    private Integer 後_公費３日数;
    private Decimal 後_費用額;
    private Decimal 後_保険分請求額;
    private Decimal 後_公費１負担額_明細;
    private Decimal 後_公費2負担額_明細;
    private Decimal 後_公費3負担額_明細;
    private Decimal 後_利用者負担額;
    private Decimal 後_費用額合計;
    private Decimal 後_保険分請求額合計;
    private Decimal 後_利用者負担額合計;
    private Decimal 後_公費１_負担額合計;
    private Decimal 後_公費１_請求額;
    private Decimal 後_公費１_本人負担月額;
    private Decimal 後_公費２_負担額合計;
    private Decimal 後_公費２_請求額;
    private Decimal 後_公費２_本人負担月額;
    private Decimal 後_公費３_負担額合計;
    private Decimal 後_公費３_請求額;
    private Decimal 後_公費３_本人負担月額;
    private Integer 再審査回数;
    private Integer 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}
