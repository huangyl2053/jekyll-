/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬実績情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteiChosaHoshuJissekiJohoIdentifier implements Serializable {

    private final RString 認定調査委託先コード;
    private final RString 認定調査員コード;
    private final ShinseishoKanriNo 申請書管理番号;
    private final int 認定調査依頼履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査員コード 認定調査員コード
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public NinteiChosaHoshuJissekiJohoIdentifier(
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
    }
}
