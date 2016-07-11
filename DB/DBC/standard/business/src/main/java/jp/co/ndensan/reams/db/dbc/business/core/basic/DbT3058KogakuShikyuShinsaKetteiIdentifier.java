/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 高額介護サービス費支給審査決定の識別子です。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class DbT3058KogakuShikyuShinsaKetteiIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final HokenshaNo 証記載保険者番号;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 履歴番号 履歴番号
     */
    public DbT3058KogakuShikyuShinsaKetteiIdentifier(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
