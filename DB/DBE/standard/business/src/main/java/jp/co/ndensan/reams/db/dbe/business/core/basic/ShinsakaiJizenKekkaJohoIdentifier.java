/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会事前審査結果情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiJizenKekkaJohoIdentifier implements Serializable {

    private final RString 介護認定審査会開催番号;
    private final RString 介護認定審査会委員コード;
    private final int 介護認定審査会審査順;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 介護認定審査会審査順 介護認定審査会審査順
     */
    public ShinsakaiJizenKekkaJohoIdentifier(RString 介護認定審査会開催番号,
            RString 介護認定審査会委員コード,
            int 介護認定審査会審査順) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
        this.介護認定審査会審査順 = 介護認定審査会審査順;
    }
}
