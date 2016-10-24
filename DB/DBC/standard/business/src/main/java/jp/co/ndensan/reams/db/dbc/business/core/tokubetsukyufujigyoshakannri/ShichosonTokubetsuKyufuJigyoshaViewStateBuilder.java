/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuChiikiKasanGemmenViewState;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShichosonTokubetsuKyufuJigyoshaViewStateViewState}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class ShichosonTokubetsuKyufuJigyoshaViewStateBuilder {

    private ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者情報;
    private RString state;
    private int rirekiNo;

    ShichosonTokubetsuKyufuJigyoshaViewStateBuilder(ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者情報,
            RString state, int rirekiNo) {
        this.市町村特別給付サービス事業者情報 = 市町村特別給付サービス事業者情報;
        this.state = state;
        this.rirekiNo = rirekiNo;
    }

    /**
     * EntityDataStateを設定します。
     *
     * @param state EntityDataState
     * @return {@link ShichosonTokubetsuKyufuJigyoshaViewState}のインスタンス
     */
    public ShichosonTokubetsuKyufuJigyoshaViewStateBuilder setState(RString state) {
        this.state = state;
        return this;
    }

    /**
     * 処理後履歴番号を設定します。
     *
     * @param rirekiNo 処理後履歴番号
     * @return {@link TokubetsuchiikiKasanGemmenViewState}のインスタンス
     */
    public ShichosonTokubetsuKyufuJigyoshaViewStateBuilder setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
        return this;
    }

    /**
     * {@link TokubetsuChiikiKasanGemmenViewState}のインスタンスを生成します。
     *
     * @return {@link TokubetsuChiikiKasanGemmenViewState}のインスタンス
     */
    public ShichosonTokubetsuKyufuJigyoshaViewState build() {
        return new ShichosonTokubetsuKyufuJigyoshaViewState(市町村特別給付サービス事業者情報, state, rirekiNo);
    }
}
