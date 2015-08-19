/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import lombok.Value;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業高額介護サービス費支給審査決定の識別子です。
 */
@Value
public class KogakuShikyuShinsaKetteiIdentifier implements Serializable {

    private final FlexibleYearMonth 決定者受取年月;
    private final HokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 通知書番号;

    /**
     * コンストラクタです。
     *
     * @param 決定者受取年月 決定者受取年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 通知書番号 通知書番号
     */
    public KogakuShikyuShinsaKetteiIdentifier(FlexibleYearMonth 決定者受取年月,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 通知書番号) {
        this.決定者受取年月 = 決定者受取年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.通知書番号 = 通知書番号;
    }
}
