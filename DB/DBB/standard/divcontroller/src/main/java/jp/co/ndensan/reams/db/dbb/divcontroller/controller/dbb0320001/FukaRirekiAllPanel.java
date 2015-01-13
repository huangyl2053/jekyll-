/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320001;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukaRirekiAllPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.IViewStateValue;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

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

        //TODO viewStateから対象者キーを取得
        //TODO 対象者キーに賦課年度が入っているかいないかで分岐する
        int rirekiSize;
        rirekiSize = div.getCcdFukaRirekiAll().load(HihokenshaNo.EMPTY, FukaNendo.EMPTY);
        rirekiSize = div.getCcdFukaRirekiAll().load(HihokenshaNo.EMPTY);

        if (rirekiSize == 1) {
            FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(
                    div.getCcdFukaRirekiAll().get賦課履歴().get賦課履歴All().findFirst().get());
            IViewStateValue<FukaShokaiKey> value = ViewStates.access().valueAssignedToA(FukaShokaiKey.class);
            value.put(key);
        }

        return createResponseData(div);
    }

    /**
     * ２回目以降の初期処理です。
     *
     * @param div 全賦課履歴Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaRirekiAllPanelDiv> reload(FukaRirekiAllPanelDiv div) {

        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();

        div.getCcdFukaRirekiAll().reload(key.get被保険者番号(), key.get調定年度(), key.get賦課年度(), key.get通知書番号());

        return createResponseData(div);
    }

    private ResponseData<FukaRirekiAllPanelDiv> createResponseData(FukaRirekiAllPanelDiv div) {
        ResponseData<FukaRirekiAllPanelDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
