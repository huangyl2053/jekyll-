/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員別単価の識別子です。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiIinBetsuTankaIdentifier implements Serializable {

    private static final long serialVersionUID = -614336832458406393L;
    private final RString 介護認定審査会委員コード;
    private final FlexibleYearMonth 開始年月;
    private final FlexibleYearMonth 終了年月;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     */
    public ShinsakaiIinBetsuTankaIdentifier(RString 介護認定審査会委員コード,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) {
        this.介護認定審査会委員コード = 介護認定審査会委員コード;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
    }
}
