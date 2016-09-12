/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import java.io.Serializable;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付額減額情報のクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugakuGengakuInfo implements Serializable {

    private final Decimal 徴収権消滅期間;
    private final Decimal 納付済期間;
    private final int 給付額減額期間;
    private final Map<FlexibleYear, KyufugakuGengakuMeisai> 給付額減額明細マップ;

    /**
     * コンストラクタです。
     *
     * @param 徴収権消滅期間 徴収権消滅期間
     * @param 納付済期間 納付済期間
     * @param 給付額減額期間 給付額減額期間
     * @param 給付額減額明細マップ 給付額減額明細マップ
     */
    public KyufugakuGengakuInfo(Decimal 徴収権消滅期間,
            Decimal 納付済期間,
            int 給付額減額期間,
            Map<FlexibleYear, KyufugakuGengakuMeisai> 給付額減額明細マップ) {
        this.徴収権消滅期間 = 徴収権消滅期間;
        this.納付済期間 = 納付済期間;
        this.給付額減額期間 = 給付額減額期間;
        this.給付額減額明細マップ = 給付額減額明細マップ;

    }

}
