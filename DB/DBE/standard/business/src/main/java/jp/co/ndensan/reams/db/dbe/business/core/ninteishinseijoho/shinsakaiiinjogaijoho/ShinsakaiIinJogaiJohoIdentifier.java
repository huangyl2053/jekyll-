/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 審査会委員除外情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiIinJogaiJohoIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     */
    public ShinsakaiIinJogaiJohoIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 連番) {
        this.申請書管理番号 = 申請書管理番号;
        this.連番 = 連番;
    }
}
