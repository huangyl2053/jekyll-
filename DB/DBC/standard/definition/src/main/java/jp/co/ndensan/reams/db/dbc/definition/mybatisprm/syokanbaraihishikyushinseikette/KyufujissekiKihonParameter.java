/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 社福軽減額サービス種類一覧MyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1030-200 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiKihonParameter {

    private final HokenshaNo 保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final RString 給付実績区分コード;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 給付実績区分コード 給付実績区分コード
     */
    protected KyufujissekiKihonParameter(HokenshaNo 保険者番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 給付実績区分コード) {
        this.保険者番号 = 保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.給付実績区分コード = 給付実績区分コード;
    }

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 給付実績区分コード 給付実績区分コード
     * @return ShafukukeigenServiceParameter
     */
    public static KyufujissekiKihonParameter createSelectByKeyParam(HokenshaNo 保険者番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 給付実績区分コード) {
        return new KyufujissekiKihonParameter(保険者番号, 被保険者番号, サービス提供年月, 整理番号, 給付実績区分コード);
    }
}
