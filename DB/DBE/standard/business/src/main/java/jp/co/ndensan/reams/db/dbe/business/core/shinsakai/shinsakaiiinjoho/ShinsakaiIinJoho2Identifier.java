/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiiinjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiIinJoho2Identifier implements Serializable {

    private static final long serialVersionUID = 4427164216551724419L;
    private final RString 介護認定審査会委員コード;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    public ShinsakaiIinJoho2Identifier(RString 介護認定審査会委員コード) {
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
    }

}
