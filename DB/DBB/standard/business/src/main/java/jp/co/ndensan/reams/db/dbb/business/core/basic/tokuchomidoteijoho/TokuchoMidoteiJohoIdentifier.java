/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchomidoteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴未同定情報の識別子です。
 *
 * @reamsid_L DBB-9999-012 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class TokuchoMidoteiJohoIdentifier implements Serializable {

    private final FlexibleYear 処理年度;
    private final RString 基礎年金番号;
    private final RString 年金コード;
    private final RString 捕捉月;
    private final ShikibetsuCode 識別コード;

    /**
     * コンストラクタです。
     *
     * @param 処理年度 処理年度
     * @param 基礎年金番号 基礎年金番号
     * @param 年金コード 年金コード
     * @param 捕捉月 捕捉月
     * @param 識別コード 識別コード
     */
    public TokuchoMidoteiJohoIdentifier(FlexibleYear 処理年度,
            RString 基礎年金番号,
            RString 年金コード,
            RString 捕捉月,
            ShikibetsuCode 識別コード) {
        this.処理年度 = 処理年度;
        this.基礎年金番号 = 基礎年金番号;
        this.年金コード = 年金コード;
        this.捕捉月 = 捕捉月;
        this.識別コード = 識別コード;
    }
}
