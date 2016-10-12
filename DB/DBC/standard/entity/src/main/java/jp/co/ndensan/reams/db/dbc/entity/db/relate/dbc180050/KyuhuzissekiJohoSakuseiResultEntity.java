/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(給付実績情報作成データResultEntity)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuhuzissekiJohoSakuseiResultEntity {

    private FlexibleYear 年度;
    private RString 給付実績情報作成区分コード;
    private HokenKyufuRitsu 保険給付率;
    private NyuryokuShikibetsuNo 入力識別番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 整理番号;
    private ServiceShuruiCode サービス種類コード;
    private Decimal 利用者負担額;
    private Decimal 後保険請求分請求額;
    private Decimal 軽減率;
    private Decimal 後受領すべき利用者負担の総額;
    private Decimal 後軽減額;
    private Decimal 後軽減後利用者負担額;
    private FlexibleYearMonth 審査年月;
    private Decimal 履歴番号;
    private Decimal 利用者負担額合計;
    private Decimal 算定基準額;
    private Decimal 支払済金額合計;
    private Decimal 高額支給額;
}
