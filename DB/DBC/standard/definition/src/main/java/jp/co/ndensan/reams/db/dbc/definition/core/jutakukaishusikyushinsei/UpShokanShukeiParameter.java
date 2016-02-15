/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 償還払請求集計更新MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpShokanShukeiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;
    private final RString 連番;
    private final RString 審査方法区分コード;
    private final FlexibleYearMonth 審査年月;
    private final RString 支給区分コード;
    private final int 支払金額;
    private final int 増減点;
    private final int 請求額差額金額;
    private final RString 増減理由等;
    private final RString 不支給理由等;
    private final RString 購入改修履歴等;

    /**
     * コンストラクタです。
     *
     */
    private UpShokanShukeiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            RString 審査方法区分コード,
            FlexibleYearMonth 審査年月,
            RString 支給区分コード,
            int 支払金額,
            int 増減点,
            int 請求額差額金額,
            RString 増減理由等,
            RString 不支給理由等,
            RString 購入改修履歴等) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.審査方法区分コード = 審査方法区分コード;
        this.審査年月 = 審査年月;
        this.支給区分コード = 支給区分コード;
        this.支払金額 = 支払金額;
        this.増減点 = 増減点;
        this.請求額差額金額 = 請求額差額金額;
        this.増減理由等 = 増減理由等;
        this.不支給理由等 = 不支給理由等;
        this.購入改修履歴等 = 購入改修履歴等;

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
     * @param 連番
     * @param 審査方法区分コード
     * @param 審査年月
     * @param 支給区分コード
     * @param 支払金額
     * @param 増減点
     * @param 請求額差額金額
     * @param 増減理由等
     * @param 不支給理由等
     * @param 購入改修履歴等
     * @return
     */
    public static UpShokanShukeiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            RString 審査方法区分コード,
            FlexibleYearMonth 審査年月,
            RString 支給区分コード,
            int 支払金額,
            int 増減点,
            int 請求額差額金額,
            RString 増減理由等,
            RString 不支給理由等,
            RString 購入改修履歴等) {
        return new UpShokanShukeiParameter(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号,
                連番, 審査方法区分コード, 審査年月, 支給区分コード, 支払金額, 増減点, 請求額差額金額,
                増減理由等, 不支給理由等, 購入改修履歴等);
    }
}
