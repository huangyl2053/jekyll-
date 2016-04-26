/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 特別地域加算減免を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@lombok.Getter
public final class TokubetsuchiikiKasanGemmenMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final int 履歴番号;

    private final boolean uses被保険者番号;
    private final boolean uses履歴番号;

    /**
     * コンストラクタです。
     *
     * @param HihokenshaNo 被保険者番号
     * @param int 履歴番号
     * @param boolean uses被保険者番号
     * @param boolean uses履歴番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private TokubetsuchiikiKasanGemmenMapperParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            int 履歴番号,
            boolean uses被保険者番号,
            boolean uses履歴番号) {

        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;

        this.uses被保険者番号 = uses被保険者番号;
        this.uses履歴番号 = uses履歴番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param uses被保険者番号 uses被保険者番号
     * @param 履歴番号 履歴番号
     * @return 身体手帳検索パラメータ
     */
    public static TokubetsuchiikiKasanGemmenMapperParameter createSelectByKeyParam(
            HihokenshaNo uses被保険者番号,
            int 履歴番号) {
        return new TokubetsuchiikiKasanGemmenMapperParameter(uses被保険者番号, 履歴番号, true, true);
    }
}
