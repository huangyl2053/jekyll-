/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufuhigenmenjyouhouregister;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhigenmenjyouhouregister.KyufuhigenmenjyouhouRegisterEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCMN71001_給付費通知減免情報補正登録用Businessクラスです。
 *
 * @reamsid_L DBC-2260-030 xuyongchao
 */
public class KyufuhigenmenjyouhouRegisterResult {

    private final KyufuhigenmenjyouhouRegisterEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link KyufuhigenmenjyouhouRegisterEntity}より{@link KyufuhigenmenjyouhouRegister}を生成します。
     *
     * @param entity DBより取得した{@link KyufuhigenmenjyouhouRegisterEntity}
     */
    public KyufuhigenmenjyouhouRegisterResult(KyufuhigenmenjyouhouRegisterEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費通知減免情報補正登録"));
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public AtenaMeisho get事業者名称() {
        return entity.getJigyoshaName();
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス種類略称を取得します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return entity.getServiceShuruiRyakusho();
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類() {
        if ((null != getサービス種類コード() || !getサービス種類コード().isEmpty())
                && (null != getサービス種類略称() || !getサービス種類略称().isEmpty())) {
            return new RString(getサービス種類コード().toString() + RString.HALF_SPACE.toString() + getサービス種類略称().toString());
        }
        return RString.EMPTY;
    }

    /**
     * 利用者負担額を取得します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * サービス費用合計額を取得します。
     *
     * @return サービス費用合計額
     */
    public Decimal getサービス費用合計額() {
        return entity.getServiceHiyoTotal();
    }

}
