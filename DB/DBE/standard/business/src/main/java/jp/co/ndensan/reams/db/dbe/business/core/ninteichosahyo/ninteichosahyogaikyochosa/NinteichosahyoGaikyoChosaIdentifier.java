/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyogaikyochosa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（概況調査）の識別子です。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteichosahyoGaikyoChosaIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 認定調査依頼履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public NinteichosahyoGaikyoChosaIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
    }
}
