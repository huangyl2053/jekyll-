/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005.FukaJohoHikakuPresenter.IFukaHikakuPresenter;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005.input.FukaHikakuTargets;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.FukaJohoHikakuDiv;

/**
 * 賦課比較の処理をハンドリングします。
 */
public class FukaHikakuHandler {

    private final FukaJohoHikakuDiv div;

    /**
     * 指定の{@link FukaJohoHikakuDiv}を操作するインスタンスを生成します。
     *
     * @param div {@link FukaJohoHikakuDiv}
     */
    public FukaHikakuHandler(FukaJohoHikakuDiv div) {
        this.div = div;
    }

    /**
     * {@link FukaHikakuHandler}生成時に指定された{@link FukaJohoHikakuDiv}に対して比較対象を描画します。
     *
     * @param targets 比較対象。Divへ出力される。
     */
    protected void diplayComparingValues(FukaHikakuTargets targets) {
        IFukaHikakuPresenter presenter = FukaJohoHikakuPresenter.createInstance(targets);
        presenter.presentComparingValues(div);
    }
}
