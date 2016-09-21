/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import lombok.Value;

/**
 * 高額受領委任契約事業者の識別子です。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJuryoininKeiyakuJigyoshaIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public KogakuJuryoininKeiyakuJigyoshaIdentifier(HihokenshaNo 被保険者番号, int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
