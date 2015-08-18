/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;

/**
 * 資格検索Aliveの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
//@lombok.Value TODO
public class ShikakuSearchAliveIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     */
    public ShikakuSearchAliveIdentifier(HihokenshaNo 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }
}
