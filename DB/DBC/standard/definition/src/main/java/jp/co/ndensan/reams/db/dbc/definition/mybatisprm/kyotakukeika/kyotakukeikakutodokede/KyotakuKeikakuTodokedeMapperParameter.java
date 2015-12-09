/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakutodokede;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画届出を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KyotakuKeikakuTodokedeMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final Decimal 履歴番号;

    private final boolean uses被保険者番号;
    private final boolean uses対象年月;
    private final boolean uses履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param uses被保険者番号 uses被保険者番号
     * @param uses対象年月 uses対象年月
     * @param uses履歴番号 uses履歴番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KyotakuKeikakuTodokedeMapperParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull FlexibleYearMonth 対象年月,
            @lombok.NonNull Decimal 履歴番号,
            boolean uses被保険者番号,
            boolean uses対象年月,
            boolean uses履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
        this.uses被保険者番号 = uses被保険者番号;
        this.uses対象年月 = uses対象年月;
        this.uses履歴番号 = uses履歴番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @return 居宅給付計画届出検索パラメータ
     */
    public static KyotakuKeikakuTodokedeMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        return new KyotakuKeikakuTodokedeMapperParameter(被保険者番号, 対象年月, 履歴番号, true, true, true);
    }
}
