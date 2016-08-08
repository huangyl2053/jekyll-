/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 意見書作成報酬単価の識別子です。
 *
 * @reamsid_L DBE-9999-021 dingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShujiiIkenshoHoshuTankaIdentifier implements Serializable {

    private static final long serialVersionUID = -1181186379015561671L;
    private final Code 在宅施設区分;
    private final Code 意見書作成回数区分;
    private final FlexibleYearMonth 開始年月;

    /**
     * コンストラクタです。
     *
     * @param 在宅施設区分 在宅施設区分
     * @param 意見書作成回数区分 意見書作成回数区分
     * @param 開始年月 開始年月
     */
    public ShujiiIkenshoHoshuTankaIdentifier(Code 在宅施設区分,
            Code 意見書作成回数区分,
            FlexibleYearMonth 開始年月) {
        this.在宅施設区分 = 在宅施設区分;
        this.意見書作成回数区分 = 意見書作成回数区分;
        this.開始年月 = 開始年月;
    }
}
