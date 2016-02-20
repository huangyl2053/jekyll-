/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0700011;

import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0700011.BatchParamterInfoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0700011.BatchParamterInfoHandler;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 広域内転居結果一覧表作成画面Divを制御します。
 *
 * @author きょう亮
 */
public class BatchParamterInfo {

    public ResponseData<BatchParamterInfoDiv> onLoad(BatchParamterInfoDiv div) {
        SearchResult<KoikiZenShichosonJoho> 市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho();
        getHandler(div).onLoad(市町村List);
        return ResponseData.of(div).respond();
    }

    public ResponseData<BatchParamterInfoDiv> onClick(BatchParamterInfoDiv div) {
        getHandler(div).is入力チェック();
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
//            getHandler(div).click実行();
        } 
        return ResponseData.of(div).respond();
    }

    private BatchParamterInfoHandler getHandler(BatchParamterInfoDiv div) {
        return new BatchParamterInfoHandler(div);
    }
}
