/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金延滞利息金徴収の識別子です。
 */
@Value
public class KyufuhiKashitsukeKinEntaiRisokuKinChoshuIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 貸付管理番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 貸付管理番号 貸付管理番号
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuIdentifier(HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.貸付管理番号 = 貸付管理番号;
        this.履歴番号 = 履歴番号;
    }
}
