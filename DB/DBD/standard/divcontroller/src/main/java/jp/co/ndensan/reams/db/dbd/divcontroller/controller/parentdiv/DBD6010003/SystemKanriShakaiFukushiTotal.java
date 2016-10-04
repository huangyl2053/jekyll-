/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD6010003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003.DBD6010003StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（社会福祉法人確認番号）画面のDivControllerです。
 *
 * @reamsid_L DBD-3762-010 tz_chengpeng
 */
public class SystemKanriShakaiFukushiTotal {

    /**
     * 画面初期化
     *
     * @param div SystemKanriShakaiFukushiTotalDiv
     * @return ResponseData<SystemKanriShakaiFukushiTotalDiv>
     */
    public ResponseData<SystemKanriShakaiFukushiTotalDiv> onLoad(SystemKanriShakaiFukushiTotalDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBD6010003StateName.初期状態);
    }

    /**
     * 「保存」ボタンの処理
     *
     * @param div SystemKanriShakaiFukushiTotalDiv
     * @return ResponseData<SystemKanriShakaiFukushiTotalDiv>
     */
    public ResponseData<SystemKanriShakaiFukushiTotalDiv> onClick_btnUpdate(SystemKanriShakaiFukushiTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save画面項目();
            div.getKoshinKekkaKakunin().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBD6010003StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private SystemKanriShakaiFukushiTotalHandler getHandler(SystemKanriShakaiFukushiTotalDiv div) {
        return new SystemKanriShakaiFukushiTotalHandler(div);
    }

    private SystemKanriShakaiFukushiTotalValidationHandler getValidationHandler(SystemKanriShakaiFukushiTotalDiv div) {
        return new SystemKanriShakaiFukushiTotalValidationHandler(div);
    }
}
