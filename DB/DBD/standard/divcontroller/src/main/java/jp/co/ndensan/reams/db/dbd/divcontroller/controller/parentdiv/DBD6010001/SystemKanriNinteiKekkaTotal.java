    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD6010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.DBD6010001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * システム管理登録（認定結果通知書文言変更）画面のDivControllerです。
 *
 * @reamsid_L DBD-3760-010 tz_chengpeng
 */
public class SystemKanriNinteiKekkaTotal {

    /**
     * 画面初期化
     *
     * @param div SystemKanriNinteiKekkaTotalDiv
     * @return ResponseData<SystemKanriNinteiKekkaTotalDiv>
     */
    public ResponseData<SystemKanriNinteiKekkaTotalDiv> onLoad(SystemKanriNinteiKekkaTotalDiv div) {
        getHandler(div).setInitializeFuKaJoho();
        return ResponseData.of(div).setState(DBD6010001StateName.初期状態);
    }

    /**
     * 「保存する」ボタンの処理
     *
     * @param div SystemKanriNinteiKekkaTotalDiv
     * @return ResponseData<SystemKanriNinteiKekkaTotalDiv>
     */
    public ResponseData<SystemKanriNinteiKekkaTotalDiv> onClick_btnUpdate(SystemKanriNinteiKekkaTotalDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).uzT0007CodeEntityデータ更新();
            div.getKoshinKekkaKakunin().getCcdKaigoKanryoMessage().setSuccessMessage(new RString(UrInformationMessages.保存終了.getMessage().evaluate()));
            return ResponseData.of(div).setState(DBD6010001StateName.完了状態);
        } else {
            return ResponseData.of(div).respond();
        }
    }

    private SystemKanriNinteiKekkaTotalValidationHandler getValidationHandler(SystemKanriNinteiKekkaTotalDiv div) {
        return new SystemKanriNinteiKekkaTotalValidationHandler(div);
    }

    private SystemKanriNinteiKekkaTotalHandler getHandler(SystemKanriNinteiKekkaTotalDiv div) {
        return new SystemKanriNinteiKekkaTotalHandler(div);
    }
}
