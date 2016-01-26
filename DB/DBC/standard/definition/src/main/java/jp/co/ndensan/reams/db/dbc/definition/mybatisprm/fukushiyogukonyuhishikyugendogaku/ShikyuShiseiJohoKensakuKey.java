/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyugendogaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給申請情報検索キー
 *
 * @author Qi
 */
@lombok.Getter
public class ShikyuShiseiJohoKensakuKey {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    // TODO 明細番号
    private final RString 明細番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShikyuShiseiJohoKensakuKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
    }

    /**
     * 支給申請情報検索キーを作成する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 支給申請情報検索キー
     */
    public static ShikyuShiseiJohoKensakuKey createShikyuShiseiJohoKensakuKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return new ShikyuShiseiJohoKensakuKey(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }
}
