/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteischedule.chikuninteichosain;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 地区認定調査員の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ChikuNinteiChosainIdentifier implements Serializable {

    private static final long serialVersionUID = 9194543140465438824L;

    private final Code 調査地区コード;
    private final RString 認定調査委託先コード;
    private final RString 認定調査員コード;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     */
    public ChikuNinteiChosainIdentifier(Code 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            LasdecCode 市町村コード) {
        this.調査地区コード = 調査地区コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.市町村コード = 市町村コード;
    }
}
