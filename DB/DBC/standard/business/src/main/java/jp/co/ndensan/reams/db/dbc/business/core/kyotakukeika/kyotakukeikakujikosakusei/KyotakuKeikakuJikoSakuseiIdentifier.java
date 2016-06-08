/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 居宅給付計画自己作成の識別子です。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KyotakuKeikakuJikoSakuseiIdentifier implements Serializable {

    private static final long serialVersionUID = -4359181977769454962L;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth 対象年月;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuJikoSakuseiIdentifier(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.対象年月 = 対象年月;
        this.履歴番号 = 履歴番号;
    }
}
