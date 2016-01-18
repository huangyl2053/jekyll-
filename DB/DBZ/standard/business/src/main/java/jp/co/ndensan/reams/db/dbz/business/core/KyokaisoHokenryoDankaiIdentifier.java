/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 境界層保険料段階の識別子です。
 */
@Value
public class KyokaisoHokenryoDankaiIdentifier implements Serializable {

    private static final long serialVersionUID = 7573451962586234880L;
    private final HihokenshaNo 被保険者番号;
    private final Decimal 履歴番号;
    private final FlexibleYearMonth 適用開始年月;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 適用開始年月 適用開始年月
     */
    public KyokaisoHokenryoDankaiIdentifier(HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            FlexibleYearMonth 適用開始年月) {
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.適用開始年月 = 適用開始年月;
    }

    /**
     * get被保険者番号
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * get履歴番号
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return 履歴番号;
    }

    /**
     * get適用開始年月
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return 適用開始年月;
    }
}
