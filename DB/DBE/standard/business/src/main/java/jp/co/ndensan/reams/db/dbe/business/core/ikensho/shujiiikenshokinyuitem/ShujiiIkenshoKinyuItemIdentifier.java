/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定主治医意見書記入項目の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShujiiIkenshoKinyuItemIdentifier implements Serializable {

    private static final long serialVersionUID = -5419467430068468871L;

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 主治医意見書作成依頼履歴番号;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @param 連番 連番
     */
    public ShujiiIkenshoKinyuItemIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号,
            int 連番) {
        this.申請書管理番号 = 申請書管理番号;
        this.主治医意見書作成依頼履歴番号 = 主治医意見書作成依頼履歴番号;
        this.連番 = 連番;
    }
}
