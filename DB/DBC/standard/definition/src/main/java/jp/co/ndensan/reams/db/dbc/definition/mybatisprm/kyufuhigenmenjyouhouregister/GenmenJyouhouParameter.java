/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhigenmenjyouhouregister;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCMN71001_給付費通知減免情報補正登録(減免補正情報の保存、給付実績情報の存在)Parameterクラスです。
 *
 * @reamsid_L DBC-2260-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class GenmenJyouhouParameter implements IMyBatisParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final HokenshaNo shokisaiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;
    private final JigyoshaNo jigyoshoNo;
    private final ServiceShuruiCode serviceShuruiCode;
    private final Decimal riyoshaFutangaku;
    private final Decimal serviceHiyoTotal;
    private final Decimal rirekiNo;
    private final RString state;

    /**
     * コンストラクタです。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param shokisaiHokenshaNo 証記載保険者番号
     * @param serviceTeikyoYM サービス年月
     * @param jigyoshoNo 事業所番号
     * @param serviceShuruiCode サービス種類コード
     * @param riyoshaFutangaku 利用者負担額合計額
     * @param serviceHiyoTotal サービス費用合計額
     * @param rirekiNo 履歴番号
     * @param state 状態
     */
    protected GenmenJyouhouParameter(HihokenshaNo hiHokenshaNo,
            HokenshaNo shokisaiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            JigyoshaNo jigyoshoNo,
            ServiceShuruiCode serviceShuruiCode,
            Decimal riyoshaFutangaku,
            Decimal serviceHiyoTotal,
            Decimal rirekiNo,
            RString state) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.jigyoshoNo = jigyoshoNo;
        this.serviceShuruiCode = serviceShuruiCode;
        this.riyoshaFutangaku = riyoshaFutangaku;
        this.serviceHiyoTotal = serviceHiyoTotal;
        this.rirekiNo = rirekiNo;
        this.state = state;
    }

    /**
     * コンストラクタです。
     *
     * @param hiHokenshaNo 被保険者番号
     * @param shokisaiHokenshaNo 証記載保険者番号
     * @param serviceTeikyoYM サービス年月
     * @param jigyoshoNo 事業所番号
     * @param serviceShuruiCode サービス種類コード
     * @param riyoshaFutangaku 利用者負担額合計額
     * @param serviceHiyoTotal サービス費用合計額
     * @param rirekiNo 履歴番号
     * @param state 状態
     * @return GenmenJyouhouParameter
     */
    public static GenmenJyouhouParameter createByKeyParam(HihokenshaNo hiHokenshaNo,
            HokenshaNo shokisaiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            JigyoshaNo jigyoshoNo,
            ServiceShuruiCode serviceShuruiCode,
            Decimal riyoshaFutangaku,
            Decimal serviceHiyoTotal,
            Decimal rirekiNo,
            RString state) {
        serviceShuruiCode = new ServiceShuruiCode(serviceShuruiCode.value().toString().substring(0, 2));
        return new GenmenJyouhouParameter(hiHokenshaNo,
                shokisaiHokenshaNo,
                serviceTeikyoYM,
                jigyoshoNo,
                serviceShuruiCode,
                riyoshaFutangaku,
                serviceHiyoTotal,
                Decimal.ONE,
                state);
    }
}
