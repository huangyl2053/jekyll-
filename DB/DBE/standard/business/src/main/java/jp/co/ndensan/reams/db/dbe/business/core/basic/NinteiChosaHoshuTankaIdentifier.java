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
 * 認定調査報酬単価の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NinteiChosaHoshuTankaIdentifier implements Serializable {

    private static final long serialVersionUID = 2098190294776693772L;
    private final Code 調査区分;
    private final Code 訪問種別;
    private final FlexibleYearMonth 開始年月;
    private final FlexibleYearMonth 終了年月;

    /**
     * コンストラクタです。
     *
     * @param 調査区分 調査区分
     * @param 訪問種別 訪問種別
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     */
    public NinteiChosaHoshuTankaIdentifier(Code 調査区分,
            Code 訪問種別,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) {
        this.調査区分 = 調査区分;
        this.訪問種別 = 訪問種別;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
    }
}
