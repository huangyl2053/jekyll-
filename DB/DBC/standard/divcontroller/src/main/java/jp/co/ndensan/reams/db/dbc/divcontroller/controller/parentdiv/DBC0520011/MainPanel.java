/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0520011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.DBC0520011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011.MainPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011.MainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保資格情報登録
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class MainPanel {

    private ShikibetsuCode 識別コード;

    /**
     * 画面初期化
     *
     * @param mainPanelDiv mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<MainPanelDiv> onMainLoad(MainPanelDiv mainPanelDiv) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        識別コード = taishoshaKey.get識別コード();
//        HihokenshaNo 被保険者番号 = new HihokenshaNo(new RString("6000000010"));
//        識別コード = new ShikibetsuCode(new RString("000000000000010"));
        getHandler(mainPanelDiv).initialize(識別コード, 被保険者番号);
        return ResponseData.of(mainPanelDiv).respond();
    }

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }

    /**
     * 「保存する」ボタン押下
     *
     * @param mainPanelDiv mainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnSave(MainPanelDiv mainPanelDiv) {
        MainPanelHandler mainPanelHandler = new MainPanelHandler(mainPanelDiv);
        MainPanelValidationHandler validation = new MainPanelValidationHandler();
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        validation.資格期間大小関係チェック(pairs, mainPanelDiv);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(mainPanelDiv).addValidationMessages(pairs).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage("URZQ00010", "保存します。よろしいですか？");
            return ResponseData.of(mainPanelDiv).addMessage(message).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(mainPanelDiv).respond();
        }
        if (mainPanelHandler.updateorinsert(識別コード)) {
            mainPanelDiv.getCcdKaigoKanryoMessage().setMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()),
                    RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(mainPanelDiv).setState(DBC0520011StateName.完了);
        }
        return ResponseData.of(mainPanelDiv).respond();
    }

}
