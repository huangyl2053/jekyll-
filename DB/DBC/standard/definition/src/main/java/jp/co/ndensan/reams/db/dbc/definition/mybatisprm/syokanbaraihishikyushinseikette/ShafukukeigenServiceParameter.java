/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 社福軽減額サービス種類一覧MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShafukukeigenServiceParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     */
    protected ShafukukeigenServiceParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス年月 = サービス年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public static ShafukukeigenServiceParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号,
            JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        return new ShafukukeigenServiceParameter(被保険者番号, サービス年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }
}
