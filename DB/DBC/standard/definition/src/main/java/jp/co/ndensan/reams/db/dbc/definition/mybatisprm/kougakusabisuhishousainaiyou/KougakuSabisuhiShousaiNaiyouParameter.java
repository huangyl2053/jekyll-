/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakusabisuhishousainaiyou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * ビジネス設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-020 quxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuSabisuhiShousaiNaiyouParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final HokenshaNo 証記載保険者番号;
    private final int 履歴番号;

    /**
     * コンストラクタです
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 証記載保険者番号 HihokenshaNo
     * @param 履歴番号 Decimal
     */
    public KougakuSabisuhiShousaiNaiyouParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.証記載保険者番号 = 証記載保険者番号;
        this.履歴番号 = 履歴番号;
    }
}
