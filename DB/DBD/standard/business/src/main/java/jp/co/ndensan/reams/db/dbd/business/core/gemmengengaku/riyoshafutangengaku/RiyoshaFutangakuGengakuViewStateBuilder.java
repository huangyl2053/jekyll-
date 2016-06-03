/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku;

import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * {@link RiyoshaFutangakuGengakuViewState}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBD-3600-010 xuyue
 */
public class RiyoshaFutangakuGengakuViewStateBuilder {

    private final RiyoshaFutangakuGengaku joho;
    private EntityDataState state;
    private int shorigoRirekiNo;

    RiyoshaFutangakuGengakuViewStateBuilder(RiyoshaFutangakuGengaku joho,
            EntityDataState state, int shorigoRirekiNo) {
        this.joho = joho;
        this.state = state;
        this.shorigoRirekiNo = shorigoRirekiNo;
    }

    /**
     * EntityDataStateを設定します。
     *
     * @param state EntityDataState
     * @return {@link RiyoshaFutangakuGengakuViewState}のインスタンス
     */
    public RiyoshaFutangakuGengakuViewStateBuilder setState(EntityDataState state) {
        this.state = state;
        return this;
    }

    /**
     * 処理後履歴番号を設定します。
     *
     * @param shinseiRirekiNo 処理後履歴番号
     * @return {@link RiyoshaFutangakuGengakuViewState}のインスタンス
     */
    public RiyoshaFutangakuGengakuViewStateBuilder setShorigoRirekiNo(int shinseiRirekiNo) {
        this.shorigoRirekiNo = shinseiRirekiNo;
        return this;
    }

    /**
     * {@link RiyoshaFutangakuGengakuViewState}のインスタンスを生成します。
     *
     * @return {@link RiyoshaFutangakuGengakuViewState}のインスタンス
     */
    public RiyoshaFutangakuGengakuViewState build() {
        return new RiyoshaFutangakuGengakuViewState(joho, state, shorigoRirekiNo);
    }

}
