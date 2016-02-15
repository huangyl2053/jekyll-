/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 償還払請求住宅改修MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaveShokanJutakuKaishuParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;
    private final RString 審査方法区分コード;
    private final FlexibleYearMonth 事前申請サービス提供年月;
    private final RString 事前申請整理番号;
    private final List<JutakuKaishuParameter> 住宅改修List;

    /**
     * コンストラクタです。
     *
     */
    private SaveShokanJutakuKaishuParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 審査方法区分コード,
            FlexibleYearMonth 事前申請サービス提供年月,
            RString 事前申請整理番号,
            List<JutakuKaishuParameter> 住宅改修List) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
        this.審査方法区分コード = 審査方法区分コード;
        this.事前申請サービス提供年月 = 事前申請サービス提供年月;
        this.事前申請整理番号 = 事前申請整理番号;
        this.住宅改修List = 住宅改修List;
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
     * @param 審査方法区分コード
     * @param 事前申請サービス提供年月
     * @param 事前申請整理番号
     * @param 住宅改修List
     * @return
     */
    public static SaveShokanJutakuKaishuParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 審査方法区分コード,
            FlexibleYearMonth 事前申請サービス提供年月,
            RString 事前申請整理番号,
            List<JutakuKaishuParameter> 住宅改修List) {
        return new SaveShokanJutakuKaishuParameter(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号,
                明細番号, 審査方法区分コード, 事前申請サービス提供年月, 事前申請整理番号, 住宅改修List);
    }
}
