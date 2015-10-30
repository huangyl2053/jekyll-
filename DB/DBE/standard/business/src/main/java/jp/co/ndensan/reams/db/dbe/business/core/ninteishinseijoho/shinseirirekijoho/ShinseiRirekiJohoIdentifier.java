/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 申請履歴情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinseiRirekiJohoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請管理番号 申請管理番号
     */
    public ShinseiRirekiJohoIdentifier(ShinseishoKanriNo 申請管理番号) {
        this.申請管理番号 = 申請管理番号;
    }
}
