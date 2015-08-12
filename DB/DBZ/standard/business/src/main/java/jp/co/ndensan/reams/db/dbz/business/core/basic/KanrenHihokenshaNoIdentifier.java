/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 関連被保険者番号の識別子です。
 */
@Value
public class KanrenHihokenshaNoIdentifier implements Serializable {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final HihokenshaNo 最新被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 最新被保険者番号 最新被保険者番号
     */
    public KanrenHihokenshaNoIdentifier(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 最新被保険者番号) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.最新被保険者番号 = 最新被保険者番号;
    }
}
