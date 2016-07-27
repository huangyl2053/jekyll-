/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001.old;

import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiControlDiv;
import jp.co.ndensan.reams.db.dbb.service.core.FukaMiscManager;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 根拠・期割画面の賦課照会コントロールdivです。
 *
 * @author N3317 塚田 萌
 */
public class FukaShokaiControl {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> onLoad(FukaShokaiControlDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> onActive(FukaShokaiControlDiv div) {
        return reLoad(div);
    }

    /**
     * コントロールdivの「状態」が遷移した際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> onStateTransition(FukaShokaiControlDiv div) {
        return reLoad(div);
    }

    /**
     * コントロールdivの初期処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> initialize(FukaShokaiControlDiv div) {

//        FukaTaishoshaKey fukaTaishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
//        final FukaMiscManager fukaMiscManager = new FukaMiscManager();
//
//        // TODO 賦課根拠かこっちかでDBアクセスを一回にしたい
//        Fuka model = fukaMiscManager.find賦課直近(
//                fukaTaishoshaKey.get調定年度(),
//                fukaTaishoshaKey.get賦課年度(),
//                fukaTaishoshaKey.get通知書番号()).findFirst().get();
//
//        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, AtenaMeisho.EMPTY);
        FukaShokaiKey key = getkeyOrNull();
        if (key == null) {
            return createResponseData(setButtonsDisabled(div, true));
        } else {
            return createResponseData(setDisplay(div, key));
        }
    }

    /**
     * コントロールdivの初期処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaShokaiControlDiv> reLoad(FukaShokaiControlDiv div) {
        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();

        if (key == null || key.get調定年度() == null || key.get賦課年度() == null || key.get被保険者番号() == null
            || key.get調定年度().isEmpty() || key.get賦課年度().isEmpty() || key.get被保険者番号().isEmpty()) {
            return initialize(div);
        }

        return createResponseData(setDisplay(div, key));
    }

    private FukaShokaiKey getkeyOrNull() {

        FukaTaishoshaKey fukaTaishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
        final FukaMiscManager fukaMiscManager = new FukaMiscManager();

        // TODO 賦課根拠かこっちかでDBアクセスを一回にしたい
        Fuka model = fukaMiscManager.find賦課直近(
                fukaTaishoshaKey.get調定年度(),
                fukaTaishoshaKey.get賦課年度(),
                fukaTaishoshaKey.get通知書番号()).findFirst().orElse(null);
        if (model == null) {
            return null;
        }
        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, AtenaMeisho.EMPTY);
        return key;
    }

    private FukaShokaiControlDiv setButtonsDisabled(FukaShokaiControlDiv div, boolean disabled) {
        div.getBtnFukakonkyoKiwari().setDisabled(true);
        div.getBtnSetaiinShotoku().setDisabled(disabled);
        div.getBtnTokucho().setDisabled(disabled);
        div.getBtnGemmen().setDisabled(disabled);
        div.getBtnRirekiHyoji().setDisabled(disabled);
        return div;
    }

    private FukaShokaiControlDiv setDisplay(FukaShokaiControlDiv div, FukaShokaiKey key) {
        if (key.get調定年度() != null) {
            div.getTxtChoteiNendo().setDomain(key.get調定年度());
        }
        if (key.get賦課年度() != null) {
            div.getTxtFukaNendo().setDomain(key.get賦課年度());
        }
        if (key.get更正月() != null) {
            div.getTxtKoseiM().setValue(key.get更正月());
        }
        if (key.get更正日時() != null) {
            div.getTxtKoseiYMD().setValue(new FlexibleDate(key.get更正日時().getDate().toString()));
            div.getTxtKoseiTime().setValue(key.get更正日時().getRDateTime().getTime());
        }
        return div;
    }

    private ResponseData<FukaShokaiControlDiv> createResponseData(FukaShokaiControlDiv div) {
        return ResponseData.of(div).respond();
    }
}
