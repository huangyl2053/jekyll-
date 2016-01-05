/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（基本調査）の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteichosahyoKihonChosaIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 要介護認定調査履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     */
    public NinteichosahyoKihonChosaIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.要介護認定調査履歴番号 = 要介護認定調査履歴番号;
    }
}
