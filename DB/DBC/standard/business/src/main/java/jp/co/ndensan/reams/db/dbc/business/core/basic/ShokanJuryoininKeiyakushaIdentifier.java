/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 償還受領委任契約者の識別子です。
 */
@Value
public class ShokanJuryoininKeiyakushaIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final FlexibleDate 受付年月日;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public ShokanJuryoininKeiyakushaIdentifier(HihokenshaNo 被保険者番号,
ShoKisaiHokenshaNo 証記載保険者番号,
FlexibleDate 受付年月日,
Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.受付年月日 = 受付年月日;
        this.履歴番号 = 履歴番号;
    }
}
