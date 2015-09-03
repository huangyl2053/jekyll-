/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 連帯納付義務者の識別子です。
 */
@Value
public class RentaiGimushaIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public RentaiGimushaIdentifier(HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
