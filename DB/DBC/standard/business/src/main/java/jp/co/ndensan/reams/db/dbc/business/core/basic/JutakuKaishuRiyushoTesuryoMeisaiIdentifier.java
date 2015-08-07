/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;

/**
 * 住宅改修理由書作成手数料請求明細の識別子です。
 */
@Value
public class JutakuKaishuRiyushoTesuryoMeisaiIdentifier implements Serializable {

    private final HokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public JutakuKaishuRiyushoTesuryoMeisaiIdentifier(HokenshaNo 証記載保険者番号,
HihokenshaNo 被保険者番号,
Decimal 履歴番号) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
