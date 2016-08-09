/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigosakuseimeisaitouroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 区分限度額統計情報取得用パラメータクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KubunGendoParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 利用年月;
    private final FlexibleDate 開始利用年月;
    private final FlexibleDate 終了利用年月;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 利用年月 FlexibleYearMonth
     * @param 開始利用年月 FlexibleDate
     * @param 終了利用年月 FlexibleDate
     */
    private KubunGendoParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 利用年月,
            FlexibleDate 開始利用年月,
            FlexibleDate 終了利用年月) {
        this.被保険者番号 = 被保険者番号;
        this.利用年月 = 利用年月;
        this.開始利用年月 = 開始利用年月;
        this.終了利用年月 = 終了利用年月;
    }

    /**
     * パラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 利用年月 FlexibleYearMonth
     * @param 開始利用年月 FlexibleDate
     * @param 終了利用年月 FlexibleDate
     * @return 区分限度額統計情報取得用パラメータ
     */
    public static KubunGendoParameter createParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 利用年月,
            FlexibleDate 開始利用年月,
            FlexibleDate 終了利用年月) {
        return new KubunGendoParameter(被保険者番号, 利用年月, 開始利用年月, 終了利用年月);
    }
}
