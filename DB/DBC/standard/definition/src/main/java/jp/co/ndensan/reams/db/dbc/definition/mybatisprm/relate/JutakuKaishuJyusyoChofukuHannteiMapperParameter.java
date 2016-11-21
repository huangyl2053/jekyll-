/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 住宅改修費改修住所重複判定のMyBatis用パラメータクラスです
 *
 * @reamsid_L DBC-0992-130 yangchenbing
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JutakuKaishuJyusyoChofukuHannteiMapperParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth kaishiServiceTeikyoYM;
    private final FlexibleYearMonth syuryoServiceTeikyoYM;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 開始サービス提供年月 FlexibleYearMonth
     * @param 終了サービス提供年月 FlexibleYearMonth
     *
     */
    private JutakuKaishuJyusyoChofukuHannteiMapperParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 開始サービス提供年月,
            FlexibleYearMonth 終了サービス提供年月
    ) {
        this.hiHokenshaNo = 被保険者番号;
        this.kaishiServiceTeikyoYM = 開始サービス提供年月;
        this.syuryoServiceTeikyoYM = 終了サービス提供年月;

    }

    /**
     * 住宅改修費改修住所重複判定のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 開始サービス提供年月 FlexibleYearMonth
     * @param 終了サービス提供年月 FlexibleYearMonth
     * @return パラメータ
     */
    public static JutakuKaishuJyusyoChofukuHannteiMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 開始サービス提供年月,
            FlexibleYearMonth 終了サービス提供年月
    ) {
        return new JutakuKaishuJyusyoChofukuHannteiMapperParameter(被保険者番号, 開始サービス提供年月, 終了サービス提供年月);
    }
}
