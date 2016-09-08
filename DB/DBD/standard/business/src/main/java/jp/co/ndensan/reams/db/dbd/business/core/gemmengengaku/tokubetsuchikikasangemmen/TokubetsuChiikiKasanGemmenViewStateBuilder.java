/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen;

import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link TokubetsuChiikiKasanGemmenViewState}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-3680-010 miaojin
 */
public class TokubetsuChiikiKasanGemmenViewStateBuilder {

    private final TokubetsuchiikiKasanGemmen 特別地域加算減免申請情報;
    private EntityDataState state;
    private int shorigoRirekiNo;

    TokubetsuChiikiKasanGemmenViewStateBuilder(TokubetsuchiikiKasanGemmen 特別地域加算減免申請情報,
            EntityDataState state, int shorigoRirekiNo) {
        this.特別地域加算減免申請情報 = 特別地域加算減免申請情報;
        this.state = state;
        this.shorigoRirekiNo = shorigoRirekiNo;
    }

    /**
     * EntityDataStateを設定します。
     *
     * @param state EntityDataState
     * @return {@link TokubetsuchiikiKasanGemmenViewState}のインスタンス
     */
    public TokubetsuChiikiKasanGemmenViewStateBuilder setState(EntityDataState state) {
        this.state = state;
        return this;
    }

    /**
     * 処理後履歴番号を設定します。
     *
     * @param shinseiRirekiNo 処理後履歴番号
     * @return {@link TokubetsuchiikiKasanGemmenViewState}のインスタンス
     */
    public TokubetsuChiikiKasanGemmenViewStateBuilder setShorigoRirekiNo(int shinseiRirekiNo) {
        this.shorigoRirekiNo = shinseiRirekiNo;
        return this;
    }

    /**
     * {@link TokubetsuChiikiKasanGemmenViewState}のインスタンスを生成します。
     *
     * @return {@link TokubetsuChiikiKasanGemmenViewState}のインスタンス
     */
    public TokubetsuChiikiKasanGemmenViewState build() {
        return new TokubetsuChiikiKasanGemmenViewState(特別地域加算減免申請情報, state, shorigoRirekiNo);
    }
}
