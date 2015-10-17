/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護第三者行為求償明細の識別子です。
 */
@Value
public class DaisanshaKoiKyushoMeisaiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 第三者行為届出管理番号;
    private final RString 第三者行為求償請求番号;
    private final FlexibleYearMonth サービス提供年月;
    private final JigyoshaNo サービス提供事業者番号;
    private final ServiceShuruiCode サービス種類コード;
    private final Decimal 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     * @param サービス提供年月 サービス提供年月
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param 履歴番号 履歴番号
     */
    public DaisanshaKoiKyushoMeisaiIdentifier(HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            Decimal 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.第三者行為届出管理番号 = 第三者行為届出管理番号;
        this.第三者行為求償請求番号 = 第三者行為求償請求番号;
        this.サービス提供年月 = サービス提供年月;
        this.サービス提供事業者番号 = サービス提供事業者番号;
        this.サービス種類コード = サービス種類コード;
        this.履歴番号 = 履歴番号;
    }
}
