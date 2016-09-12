/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.tokubetsuchikikasangemmen;

import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別地域加算減免を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokubetsuchiikiKasanGemmenMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final int 履歴番号;
    private final RString 減免減額種類;

    private final boolean uses被保険者番号;
    private final boolean uses履歴番号;
    private final boolean uses減免減額種類;

    /**
     * コンストラクタです。
     *
     * @param HihokenshaNo 被保険者番号
     * @param int 履歴番号
     * @param RString 減免減額種類
     * @param boolean uses被保険者番号
     * @param boolean uses履歴番号
     * @param boolean uses減免減額種類
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private TokubetsuchiikiKasanGemmenMapperParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            int 履歴番号,
            RString 減免減額種類,
            boolean uses被保険者番号,
            boolean uses履歴番号,
            boolean uses減免減額種類) {

        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.減免減額種類 = 減免減額種類;

        this.uses被保険者番号 = uses被保険者番号;
        this.uses履歴番号 = uses履歴番号;
        this.uses減免減額種類 = uses減免減額種類;
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
        return new TokubetsuchiikiKasanGemmenMapperParameter(
                uses被保険者番号, 履歴番号, GemmenGengakuShurui.特別地域加算減免.getコード(), true, true, true);
    }
}
