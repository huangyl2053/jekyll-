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
 */
@lombok.Getter
public final class JutakuKaishuJyusyoChofukuHannteiMapperParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYM;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 主キー2 主キー2
     * @param サービス提供年月 サービス提供年月
     *
     */
    private JutakuKaishuJyusyoChofukuHannteiMapperParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月
    ) {
        this.hiHokenshaNo = 被保険者番号;
        this.serviceTeikyoYM = サービス提供年月;

    }

    /**
     * 住宅改修費改修住所重複判定のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return パラメータ
     */
    public static JutakuKaishuJyusyoChofukuHannteiMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月
    ) {
        return new JutakuKaishuJyusyoChofukuHannteiMapperParameter(被保険者番号, サービス提供年月);
    }
}
