/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * サービス種類支給額の取得用パラメータクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufuJikoSakuseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final int 履歴番号;
    private final FlexibleYearMonth 利用年月;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 利用年月 FlexibleYearMonth
     */
    private KyufuJikoSakuseiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
        this.利用年月 = 利用年月;
    }

    /**
     * パラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 利用年月 FlexibleYearMonth
     * @return サービス種類支給額の取得用パラメータ
     */
    public static KyufuJikoSakuseiParameter createParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月) {
        return new KyufuJikoSakuseiParameter(被保険者番号, 対象年月, 履歴番号, 利用年月);
    }
}
