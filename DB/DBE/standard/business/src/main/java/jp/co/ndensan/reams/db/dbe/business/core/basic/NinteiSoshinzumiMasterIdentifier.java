/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定送信済みマスタの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteiSoshinzumiMasterIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public NinteiSoshinzumiMasterIdentifier(ShinseishoKanriNo 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }
}
