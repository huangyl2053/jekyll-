/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteichosaItakusakiJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -3525745395175489257L;

    private final LasdecCode 市町村コード;
    private final RString 認定調査委託先コード;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     */
    public NinteichosaItakusakiJohoIdentifier(LasdecCode 市町村コード,
            RString 認定調査委託先コード) {
        this.市町村コード = 市町村コード;
        this.認定調査委託先コード = 認定調査委託先コード;
    }
}
