/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 償還払請求集計MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaveShokanShukeiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;
    private final RString 連番;
    private final ServiceShuruiCode サービス種類コード;
    private final Decimal 請求額;
    private final int 利用者負担額;
    private final FlexibleYearMonth 審査年月;
    private final RString 支給区分コード;

    /**
     * コンストラクタです。
     *
     */
    private SaveShokanShukeiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceShuruiCode サービス種類コード,
            Decimal 請求額,
            int 利用者負担額,
            FlexibleYearMonth 審査年月,
            RString 支給区分コード) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.サービス種類コード = サービス種類コード;
        this.請求額 = 請求額;
        this.利用者負担額 = 利用者負担額;
        this.審査年月 = 審査年月;
        this.支給区分コード = 支給区分コード;
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
     * @param サービス種類コード
     * @param 請求額
     * @param 利用者負担額
     * @param 審査年月
     * @param 支給区分コード
     * @return
     */
    public static SaveShokanShukeiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceShuruiCode サービス種類コード,
            Decimal 請求額,
            int 利用者負担額,
            FlexibleYearMonth 審査年月,
            RString 支給区分コード) {
        return new SaveShokanShukeiParameter(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号,
                明細番号, 連番, サービス種類コード, 請求額, 利用者負担額, 審査年月, 支給区分コード);
    }
}
