/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010.temptable.KyufuJisekiKeyTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 特別地域加算軽減実績管理リストEntityクラスです．
 *
 * @reamsid_L DBD-3880-050 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChiikiKasanKeigenJissekiKanriListEntity extends DbTableEntityBase<KyufuJisekiKeyTempTableEntity> implements IDbAccessable {

    private JigyoshaNo 事業者番号;
    private RString 事業者名称;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private FlexibleYearMonth 審査年月;
    private RString 給付実績情報作成区分コード;
    private NyuryokuShikibetsuNo 入力識別番号;
    private boolean exists社福軽減給付実績;
    private HokenshaNo 証記載保険者番号;
    private boolean exists有効特地減免;
    private RString 通し番号;
    private ServiceShuruiCode 明細サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private RString サービス名称;
    private int 後単位数;
    private int 後日数回数;
    private int 後サービス単位数;
    private ServiceShuruiCode 集計サービス種類コード;
    private RString 保険請求額;
    private int 保険利用者負担額;

}
