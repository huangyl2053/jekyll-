/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 通知書発行情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
//@lombok.Value
public class TsuchishoHakkoJohoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public TsuchishoHakkoJohoIdentifier(ShinseishoKanriNo 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }
}
