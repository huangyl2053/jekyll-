/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績情報Entityクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceMeisaiEntity {

    private NyuryokuShikibetsuNo 入力識別番号;
    private RString 給付実績情報作成区分コード;
    private RString 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 給付実績区分コード;
    private JigyoshaNo 事業所番号;
    private RString 要介護状態区分コード;
    private RString 旧措置入所者特例コード;
    private FlexibleDate 認定有効期間_開始年月日;
    private FlexibleDate 認定有効期間_終了年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 居宅サービス計画作成区分コード;
    private RString 計画事業所番号;
    private FlexibleDate 入所院年月日;
    private FlexibleDate 退所院年月日;
    private Decimal 入所院実日数;
    private Decimal 保険給付率;
    private Decimal 公費１給付率;
    private Decimal 公費２給付率;
    private Decimal 公費３給付率;
    private RString 保険者番号_後期;
    private RString 被保険者番号_後期;
    private RString 保険者番号_国保;
    private RString 被保険者証番号_国保;
    private RString 個人番号_国保;
    private RString サービスコード;
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private Decimal 後_単位数;
    private Decimal 後_回数;
    private Decimal 後公費１対象日数回数;
    private Decimal 後公費２対象日数回数;
    private Decimal 後公費３対象日数回数;
    private Decimal 後_サービス単位数;
    private Decimal 後公費１対象サービス単位数;
    private Decimal 後公費２対象サービス単位数;
    private Decimal 後公費３対象サービス単位数;
    private Decimal 再審査回数;
    private Decimal 過誤回数;
    private FlexibleYearMonth 審査年月;

}
