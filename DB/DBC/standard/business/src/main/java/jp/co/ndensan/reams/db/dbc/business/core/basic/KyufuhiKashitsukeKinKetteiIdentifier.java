/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金決定の識別子です。
 */
@Value
public class KyufuhiKashitsukeKinKetteiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 借入申請年月日;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 借入申請年月日 借入申請年月日
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukeKinKetteiIdentifier(HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.借入申請年月日 = 借入申請年月日;
        this.履歴番号 = 履歴番号;
    }
}
