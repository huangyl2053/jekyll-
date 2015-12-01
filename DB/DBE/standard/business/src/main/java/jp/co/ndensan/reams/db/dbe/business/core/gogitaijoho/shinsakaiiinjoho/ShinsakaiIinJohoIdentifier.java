/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiIinJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 8283015154606320923L;
    private final RString 介護認定審査会委員コード;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    public ShinsakaiIinJohoIdentifier(RString 介護認定審査会委員コード) {
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
    }
}
