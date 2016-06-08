/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 老人保健受給者情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class RojinHokenJukyushaJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 3427737521532474502L;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     */
    public RojinHokenJukyushaJohoIdentifier(ShikibetsuCode 識別コード) {
        this.識別コード = 識別コード;
    }
}
