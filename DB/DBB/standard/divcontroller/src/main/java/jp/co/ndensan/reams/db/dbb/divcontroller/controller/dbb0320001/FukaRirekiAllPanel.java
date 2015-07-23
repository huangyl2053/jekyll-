/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320001;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiDisplayMode;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaRirekiAllPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.IViewStateValue;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 全賦課履歴Divのコントローラです。
 *
 * @author n3317 塚田 萌
 */
public class FukaRirekiAllPanel {

    /**
     * 初回表示時の初期処理です。
     *
     * @param div 全賦課履歴Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiAllPanelDiv> initialize(FukaRirekiAllPanelDiv div) {

        div.getLblMode().setText(FukaShokaiDisplayMode.初回.getCode());

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

        if (div.getLblMode().getText().compareTo(FukaShokaiDisplayMode.二回目以降.getCode()) != 0) {

            div.getLblMode().setText(FukaShokaiDisplayMode.二回目以降.getCode());

            FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();

//        div.getCcdFukaRirekiAll().reload(key.get被保険者番号(), key.get調定年度(), key.get賦課年度(), key.get通知書番号());
            div.getCcdFukaRirekiAll().reload(key.get通知書番号());

        }
        return createResponseData(div);
    }

    private ResponseData<FukaRirekiAllPanelDiv> createResponseData(FukaRirekiAllPanelDiv div) {
        ResponseData<FukaRirekiAllPanelDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
