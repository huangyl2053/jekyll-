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
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(一時表：給付実績情報Temp)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyuhuzissekiJohoTempEntity extends DbTableEntityBase<KyuhuzissekiJohoTempEntity> implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 年度;
    private NyuryokuShikibetsuNo 入力識別番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 整理番号;
    private ServiceShuruiCode サービス種類コード;
    private RString 給付実績情報作成区分コード;
    private HokenKyufuRitsu 保険給付率;
    private Decimal 後保険請求分請求額;
    private Decimal 利用者負担額;
    private Decimal 軽減率;
    private Decimal 軽減後自己負担額;
    private Decimal 高額サービス費用額;
}
