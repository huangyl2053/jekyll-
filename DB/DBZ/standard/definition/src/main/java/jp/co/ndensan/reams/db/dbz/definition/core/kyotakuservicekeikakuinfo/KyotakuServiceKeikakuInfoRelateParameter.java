/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikakuinfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 *
 * 居宅サービス計画情報のパラメータクラス。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyotakuServiceKeikakuInfoRelateParameter {

    private final HihokenshaNo hihokenshaNo;
    private final FlexibleYearMonth taishoYM;

    /**
     * コンストラクタです。
     *
     * @param hihokenshano 被保険者番号
     * @param taishoYM 対象年月
     */
    private KyotakuServiceKeikakuInfoRelateParameter(
            HihokenshaNo hihokenshaNo,
            FlexibleYearMonth taishoYM
    ) {
        this.hihokenshaNo = hihokenshaNo;
        this.taishoYM = taishoYM;
    }

    /**
     * 居宅サービス計画情報のパラメータを生成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param taishoYM 対象年月
     * @return 居宅サービス計画情報のパラメータ
     */
    public static KyotakuServiceKeikakuInfoRelateParameter createParam(
            HihokenshaNo hihokenshaNo,
            FlexibleYearMonth taishoYM) {
        return new KyotakuServiceKeikakuInfoRelateParameter(
                hihokenshaNo,
                taishoYM);
    }
}
