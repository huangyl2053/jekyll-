/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.riyoshafutangengaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 利用者負担額減額を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class RiyoshaFutangakuGengakuMapperParameter {

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final int 履歴番号;

    private final boolean uses証記載保険者番号;
    private final boolean uses被保険者番号;
    private final boolean uses履歴番号;

    private RiyoshaFutangakuGengakuMapperParameter(
            @lombok.NonNull ShoKisaiHokenshaNo 証記載保険者番号,
            @lombok.NonNull HihokenshaNo 被保険者番号,
            int 履歴番号,
            boolean uses証記載保険者番号,
            boolean uses被保険者番号,
            boolean uses履歴番号) {

        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;

        this.uses証記載保険者番号 = uses証記載保険者番号;
        this.uses被保険者番号 = uses被保険者番号;
        this.uses履歴番号 = uses履歴番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return 利用者負担額減額検索パラメータ
     */
    public static RiyoshaFutangakuGengakuMapperParameter createSelectByKeyParam(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        return new RiyoshaFutangakuGengakuMapperParameter(証記載保険者番号, 被保険者番号, 履歴番号, true, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担額減額検索パラメータ
     */
    public static RiyoshaFutangakuGengakuMapperParameter createSelectListParam(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号
    ) {
        return new RiyoshaFutangakuGengakuMapperParameter(証記載保険者番号, 被保険者番号, 0, true, true, false);
    }
}
