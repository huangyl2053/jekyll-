/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護サービス内容の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KaigoServiceNaiyouIdentifier implements Serializable {

    private static final long serialVersionUID = -7180918752677742109L;

    private final KaigoServiceShuruiCode サービス種類コード;
    private final RString サービス項目コード;
    private final FlexibleYearMonth 提供開始年月;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     * @param 提供開始年月 提供開始年月
     * @param 履歴番号 履歴番号
     */
    public KaigoServiceNaiyouIdentifier(KaigoServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 提供開始年月,
            Decimal 履歴番号) {
        this.サービス種類コード = サービス種類コード;
        this.サービス項目コード = サービス項目コード;
        this.提供開始年月 = 提供開始年月;
        this.履歴番号 = 履歴番号;
    }
}
