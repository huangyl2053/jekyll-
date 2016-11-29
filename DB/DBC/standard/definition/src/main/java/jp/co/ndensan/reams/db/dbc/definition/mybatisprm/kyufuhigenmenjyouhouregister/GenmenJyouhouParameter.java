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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private final RString 事業者番号;
    private final RString サービス種類コード;
    private final RString サービス提供年月の月初日;

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
     * @param 事業者番号 事業者番号
     * @param サービス種類コード サービス種類コード
     * @param サービス提供年月の月初日 サービス提供年月の月初日
     */
    protected GenmenJyouhouParameter(HihokenshaNo hiHokenshaNo,
            HokenshaNo shokisaiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            JigyoshaNo jigyoshoNo,
            ServiceShuruiCode serviceShuruiCode,
            Decimal riyoshaFutangaku,
            Decimal serviceHiyoTotal,
            Decimal rirekiNo,
            RString 事業者番号,
            RString サービス種類コード,
            RString サービス提供年月の月初日) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
        this.jigyoshoNo = jigyoshoNo;
        this.serviceShuruiCode = serviceShuruiCode;
        this.riyoshaFutangaku = riyoshaFutangaku;
        this.serviceHiyoTotal = serviceHiyoTotal;
        this.rirekiNo = rirekiNo;
        this.事業者番号 = 事業者番号;
        this.サービス種類コード = サービス種類コード;
        this.サービス提供年月の月初日 = サービス提供年月の月初日;
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
     * @return GenmenJyouhouParameter
     */
    public static GenmenJyouhouParameter createByKeyParam(HihokenshaNo hiHokenshaNo,
            HokenshaNo shokisaiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYM,
            JigyoshaNo jigyoshoNo,
            ServiceShuruiCode serviceShuruiCode,
            Decimal riyoshaFutangaku,
            Decimal serviceHiyoTotal,
            Decimal rirekiNo) {
        serviceShuruiCode = new ServiceShuruiCode(serviceShuruiCode.value().toString().substring(0, 2));
        return new GenmenJyouhouParameter(hiHokenshaNo,
                shokisaiHokenshaNo,
                serviceTeikyoYM,
                jigyoshoNo,
                serviceShuruiCode,
                riyoshaFutangaku,
                serviceHiyoTotal,
                Decimal.ONE,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * コンストラクタです。
     *
     * @param 事業者番号 事業者番号
     * @param サービス種類コード サービス種類コード
     * @param rstサービス提供年月 rstサービス提供年月
     * @return GenmenJyouhouParameter
     */
    public static GenmenJyouhouParameter createByKeyParam(
            RString 事業者番号,
            RString サービス種類コード,
            RString rstサービス提供年月) {
        FlexibleYearMonth tempサービス提供年月;
        RDate サービス提供年月 = null;
        RString rstサービス提供年月の月初日 = RString.EMPTY;
        if (!RString.isNullOrEmpty(rstサービス提供年月)) {
            tempサービス提供年月 = new FlexibleYearMonth(rstサービス提供年月);
            サービス提供年月 = new RDate(tempサービス提供年月.getYearValue(), tempサービス提供年月.getMonthValue(), 1);
        }
        if (サービス提供年月 != null) {
            rstサービス提供年月の月初日 = サービス提供年月.toDateString();
        }
        return new GenmenJyouhouParameter(HihokenshaNo.EMPTY,
                HokenshaNo.EMPTY,
                FlexibleYearMonth.EMPTY,
                JigyoshaNo.EMPTY,
                ServiceShuruiCode.EMPTY,
                Decimal.ZERO,
                Decimal.ZERO,
                Decimal.ZERO,
                事業者番号,
                サービス種類コード,
                rstサービス提供年月の月初日);
    }
}
