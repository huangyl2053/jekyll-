/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320002;

import jp.co.ndensan.reams.db.dbb.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.DbbViewStateKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName.履歴一覧;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName.期割;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName.減免;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.DBB0320002TransitionEventName.特別徴収;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320002.SetaiinFukaShokaiControlDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課照会の世帯員所得Divの賦課照会コントロールdivです。
 *
 * @author N3317 塚田 萌
 */
public class SetaiinFukaShokaiControl {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div 賦課照会コントロール
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinFukaShokaiControlDiv> onload(SetaiinFukaShokaiControlDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div 賦課照会コントロール
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinFukaShokaiControlDiv> onActive(SetaiinFukaShokaiControlDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 賦課照会コントロール
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinFukaShokaiControlDiv> initialize(SetaiinFukaShokaiControlDiv div) {

        // 値をクリアする。
        clearDiv(div);

        // 賦課照会コントロールキーより、値を表示する。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        div.getTxtChoteiNendo().setDomain(key.get調定年度());
        div.getTxtFukaNendo().setDomain(key.get賦課年度());
        div.getTxtKoseiM().setValue(key.get更正月());
        div.getTxtKoseiYMD().setValue(new FlexibleDate(key.get更正日時().getDate().toString()));
        div.getTxtKoseiTime().setValue(key.get更正日時().getRDateTime().getTime());
        return createResponseData(div);
    }

    /**
     * 履歴一覧を表示するボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinFukaShokaiControlDiv> onClick_rireki(SetaiinFukaShokaiControlDiv div) {

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
    public ResponseData<SetaiinFukaShokaiControlDiv> onClick_loadFukakonkyo(SetaiinFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーを渡す。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 賦課根拠・期割へ遷移する。
        return ResponseData.of(div).forwardWithEventName(期割).respond();

    }

    /**
     * 特別徴収ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinFukaShokaiControlDiv> onClick_btnTokucho(SetaiinFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーを渡す。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 特別徴収へ遷移する。
        return ResponseData.of(div).forwardWithEventName(特別徴収).respond();

    }

    /**
     * 減免・徴収猶予ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<SetaiinFukaShokaiControlDiv> onClick_btnGenmen(SetaiinFukaShokaiControlDiv div) {

        // 賦課照会コントロールキーを渡す。
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(DbbViewStateKey.FukaShokaiKey, key);
        // 減免・徴収猶予へ遷移する。
        return ResponseData.of(div).forwardWithEventName(減免).respond();

    }

    private void clearDiv(SetaiinFukaShokaiControlDiv div) {
        div.getTxtChoteiNendo().clearDomain();
        div.getTxtFukaNendo().clearDomain();
        div.getTxtKoseiM().clearValue();
        div.getTxtKoseiYMD().clearValue();
        div.getTxtKoseiTime().clearValue();
    }

    private ResponseData<SetaiinFukaShokaiControlDiv> createResponseData(SetaiinFukaShokaiControlDiv div) {
        return ResponseData.of(div).respond();
    }
}
