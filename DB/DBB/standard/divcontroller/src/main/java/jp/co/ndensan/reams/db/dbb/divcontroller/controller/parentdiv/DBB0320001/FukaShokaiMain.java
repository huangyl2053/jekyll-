/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.DBB0320001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiMainDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 賦課照会メインパネル
 */
public class FukaShokaiMain {

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onLoad(FukaShokaiMainDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        DBB0320001StateName state = handler.initializeWithFirstState();
        if (state == DBB0320001StateName.Default) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        return ResponseData.of(div).setState(state);
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnRirekiHyoji(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.show全賦課履歴();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onSelect_dgFukaRirekiAll(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.show賦課履歴一覧();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onSelect_dgFukaRirekiFukaRireki(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.show賦課根拠期割();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_MaeHikaku(FukaShokaiMainDiv div) {
        FukaShokaiMainHandler handler = new FukaShokaiMainHandler(div);
        handler.compareWith前履歴();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnZenkairesultHyoji(FukaShokaiMainDiv div) {
        return clearViewStateKeys(div);
    }

    private ResponseData<FukaShokaiMainDiv> clearViewStateKeys(FukaShokaiMainDiv div) {
        FukaShokaiController.clearFukaTaishoshaKeyAndFukaShokaiKey();
        return ResponseData.of(div).respond();
    }

    /**
     * @param div {@link FukaShokaiMainDiv}
     * @return レスポンス
     */
    public ResponseData<FukaShokaiMainDiv> onClick_btnResearch(FukaShokaiMainDiv div) {
        return clearViewStateKeys(div);
    }
}
