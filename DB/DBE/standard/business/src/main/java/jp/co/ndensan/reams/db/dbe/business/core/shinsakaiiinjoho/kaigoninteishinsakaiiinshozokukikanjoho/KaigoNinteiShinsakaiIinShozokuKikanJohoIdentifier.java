/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員所属機関情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -1178098786079834337L;

    private final RString 介護認定審査会委員コード;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 連番 連番
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoIdentifier(RString 介護認定審査会委員コード,
            int 連番) {
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
        this.連番 = 連番;
    }
}
