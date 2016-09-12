/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬実績情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiIinHoshuJissekiJohoIdentifier implements Serializable {

    private final RString 介護認定審査会委員コード;
    private final Code 審査会委員報酬区分;
    private final FlexibleDate 実施年月日;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 審査会委員報酬区分 審査会委員報酬区分
     * @param 実施年月日 実施年月日
     * @param 連番 連番
     */
    public ShinsakaiIinHoshuJissekiJohoIdentifier(RString 介護認定審査会委員コード,
            Code 審査会委員報酬区分,
            FlexibleDate 実施年月日,
            int 連番) {
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
        this.審査会委員報酬区分 = 審査会委員報酬区分;
        this.実施年月日 = 実施年月日;
        this.連番 = 連番;
    }
}
