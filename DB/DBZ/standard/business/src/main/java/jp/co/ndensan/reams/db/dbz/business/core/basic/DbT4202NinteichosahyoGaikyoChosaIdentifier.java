/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（概況調査）の識別子です。
 *
 * @reamsid_L DBZ-9999-011 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class DbT4202NinteichosahyoGaikyoChosaIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final int 認定調査依頼履歴番号;
    private final RString 概況調査テキスト_イメージ区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況調査テキスト_イメージ区分 概況調査テキスト_イメージ区分
     */
    public DbT4202NinteichosahyoGaikyoChosaIdentifier(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 概況調査テキスト_イメージ区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.概況調査テキスト_イメージ区分 = 概況調査テキスト_イメージ区分;
    }
}
