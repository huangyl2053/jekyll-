/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 償還払請求基本MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaveShokanKihonParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;
    private final HokenKyufuRitsu 保険給付率;
    private final int サービス単位数;
    private final Decimal 保険請求額;
    private final int 利用者負担額;

    /**
     * コンストラクタです。
     *
     */
    private SaveShokanKihonParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            HokenKyufuRitsu 保険給付率,
            int サービス単位数,
            Decimal 保険請求額,
            int 利用者負担額) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
        this.保険給付率 = 保険給付率;
        this.サービス単位数 = サービス単位数;
        this.保険請求額 = 保険請求額;
        this.利用者負担額 = 利用者負担額;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 保険給付率
     * @param サービス単位数
     * @param 保険請求額
     * @param 利用者負担額
     * @return
     */
    public static SaveShokanKihonParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            HokenKyufuRitsu 保険給付率,
            int サービス単位数,
            Decimal 保険請求額,
            int 利用者負担額) {
        return new SaveShokanKihonParameter(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号,
                明細番号, 保険給付率, サービス単位数, 保険請求額, 利用者負担額);
    }
}
