/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会割当委員情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiWariateIinJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -8657583943552337714L;
    private final RString 介護認定審査会開催番号;
    private final RString 介護認定審査会委員コード;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     */
    public ShinsakaiWariateIinJohoIdentifier(RString 介護認定審査会開催番号,
            RString 介護認定審査会委員コード) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
    }
}
