/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshoirai.ninteishinseijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定申請情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteiShinseiJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -7691456240198140246L;
    private final ShinseishoKanriNo 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public NinteiShinseiJohoIdentifier(ShinseishoKanriNo 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }
}
