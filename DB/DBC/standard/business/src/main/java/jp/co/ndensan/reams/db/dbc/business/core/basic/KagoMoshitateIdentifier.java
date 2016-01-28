/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Value;

/**
 * 過誤申立の識別子です。
 */
@Value
public class KagoMoshitateIdentifier implements Serializable {

    private final JigyoshaNo 事業所番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 事業所番号 事業所番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 履歴番号 履歴番号
     */
    public KagoMoshitateIdentifier(JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            int 履歴番号) {
        this.事業所番号 = 事業所番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.履歴番号 = 履歴番号;
    }
}
