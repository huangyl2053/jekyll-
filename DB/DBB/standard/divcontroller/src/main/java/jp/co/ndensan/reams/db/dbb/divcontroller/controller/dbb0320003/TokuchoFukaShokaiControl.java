/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320003;

import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.DbbViewStateKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.DBB0320003TransitionEventName.世帯員所得;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.DBB0320003TransitionEventName.履歴一覧;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.DBB0320003TransitionEventName.期割;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.DBB0320003TransitionEventName.減免;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.TokuchoFukaShokaiControlDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 特別徴収画面の賦課照会コントロールdivです。
 *
 * @author N3317 塚田 萌
 */
public class TokuchoFukaShokaiControl {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div 賦課照会コントロール
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> onload(TokuchoFukaShokaiControlDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div 賦課照会コントロール
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> onActive(TokuchoFukaShokaiControlDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 賦課照会コントロール
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> initialize(TokuchoFukaShokaiControlDiv div) {

        // 値をクリアする。
        clearDiv(div);

        // 賦課照会コントロールキーより、値を表示する。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        div.getTxtChoteiNendo().setDomain(key.get調定年度());
        div.getTxtFukaNendo().setDomain(key.get賦課年度());
        div.getTxtKoseiM().setValue(key.get更正月());
        div.getTxtKoseiYMD().setValue(new FlexibleDate(key.get更正日時().getDate().toString()));
        div.getTxtKoseiTime().setValue(key.get更正日時().getTime());
        return createResponseData(div);
    }

    /**
     * 履歴一覧を表示するボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> onClick_rireki(TokuchoFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーより、ViewStateに賦課履歴表示情報を保存する。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 賦課履歴へ遷移する。
        return ResponseData.of(div).forwardWithEventName(履歴一覧).respond();
    }

    /**
     * 賦課根拠・期割ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> onClick_loadFukakonkyo(TokuchoFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーを渡す。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 賦課根拠・期割へ遷移する。
        return ResponseData.of(div).forwardWithEventName(期割).respond();

    }

    /**
     * 世帯員所得ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> onClick_btnSetaiinShotoku(TokuchoFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーを渡す。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 世帯員所得へ遷移する。
        return ResponseData.of(div).forwardWithEventName(世帯員所得).respond();

    }

    /**
     * 減免・徴収猶予ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoFukaShokaiControlDiv> onClick_btnGenmen(TokuchoFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーを渡す。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 減免・徴収猶予へ遷移する。
        return ResponseData.of(div).forwardWithEventName(減免).respond();

    }

    private void clearDiv(TokuchoFukaShokaiControlDiv div) {
        div.getTxtChoteiNendo().clearDomain();
        div.getTxtFukaNendo().clearDomain();
        div.getTxtKoseiM().clearValue();
        div.getTxtKoseiYMD().clearValue();
        div.getTxtKoseiTime().clearValue();
    }

    private ResponseData<TokuchoFukaShokaiControlDiv> createResponseData(TokuchoFukaShokaiControlDiv div) {
        return ResponseData.of(div).respond();
    }
}
