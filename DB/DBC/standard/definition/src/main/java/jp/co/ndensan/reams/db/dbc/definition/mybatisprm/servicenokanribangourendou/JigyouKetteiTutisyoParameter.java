/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicenokanribangourendou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 決定通知書用パラメータクラスです。
 *
 * @reamsid_L DBC-4760-050 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JigyouKetteiTutisyoParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final int 履歴番号;
    private final HokenshaNo 証記載保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 証記載保険者番号 HokenshaNo
     */
    private JigyouKetteiTutisyoParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            int 履歴番号,
            HokenshaNo 証記載保険者番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.履歴番号 = 履歴番号;
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /**
     * パラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     * @param 証記載保険者番号 HokenshaNo
     * @return 決定通知書用パラメータ
     */
    public static JigyouKetteiTutisyoParameter createParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            int 履歴番号,
            HokenshaNo 証記載保険者番号) {
        return new JigyouKetteiTutisyoParameter(被保険者番号, サービス提供年月, 履歴番号, 証記載保険者番号);
    }
}
