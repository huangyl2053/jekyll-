/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Value;

/**
 * 境界層該当者の識別子です。
 */
@Value
public class KyokaisoGaitoshaIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public KyokaisoGaitoshaIdentifier(HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
