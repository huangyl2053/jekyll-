/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001.old;

//import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
//import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
//import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiDisplayMode;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaRirekiAllPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 全賦課履歴Divのコントローラです。
 *
 * @author n3317 塚田 萌
 */
public class FukaRirekiAllPanel {

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiAllPanelDiv> onLoad(FukaRirekiAllPanelDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiAllPanelDiv> onActive(FukaRirekiAllPanelDiv div) {
        return reload(div);
    }

    /**
     * 初回表示時の初期処理です。
     *
     * @param div 全賦課履歴Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiAllPanelDiv> initialize(FukaRirekiAllPanelDiv div) {
//        div.getLblMode().setText(FukaShokaiDisplayMode.初回.getCode());
//        int rirekiSize;
//
//        // 初回はdatagridロード処理いらない
//        if (fukaTaishoshaKey.get賦課年度().isMaxOrMin()) {
//            rirekiSize = div.getCcdFukaRirekiAll().load(fukaTaishoshaKey.get被保険者番号());
//        } else {
//            rirekiSize = div.getCcdFukaRirekiAll().load(
//                    new ChoteiNendo(fukaTaishoshaKey.get調定年度()),
//                    new FukaNendo(fukaTaishoshaKey.get賦課年度()),
//                    new TsuchishoNo(fukaTaishoshaKey.get通知書番号().value()));
//        }
//
//                div.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All().findFirst().get(), AtenaMeisho.EMPTY);
        return createResponseData(div);
    }

    /**
     * ２回目以降の初期処理です。
     *
     * @param div 全賦課履歴Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiAllPanelDiv> reload(FukaRirekiAllPanelDiv div) {
//        if (div.getLblMode().getText().compareTo(FukaShokaiDisplayMode.二回目以降.getCode()) != 0) {
//
//            div.getLblMode().setText(FukaShokaiDisplayMode.二回目以降.getCode());
//
//            FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
//
////        div.getCcdFukaRirekiAll().reload(key.get被保険者番号(), key.get調定年度(), key.get賦課年度(), key.get通知書番号());
//            div.getCcdFukaRirekiAll().reload(key.get通知書番号());
//
//        }
        return createResponseData(div);
    }

    private ResponseData<FukaRirekiAllPanelDiv> createResponseData(FukaRirekiAllPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
