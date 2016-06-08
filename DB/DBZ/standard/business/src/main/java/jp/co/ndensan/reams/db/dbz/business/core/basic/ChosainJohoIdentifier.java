/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 調査員情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ChosainJohoIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final ChosaItakusakiCode 認定調査委託先コード;
    private final ChosainCode 認定調査員コード;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     */
    public ChosainJohoIdentifier(LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) {
        this.市町村コード = 市町村コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
    }

    /**
     * get市町村コード
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * get認定調査委託先コード
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return 認定調査委託先コード;
    }

    /**
     * get認定調査員コード
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return 認定調査員コード;
    }

}
