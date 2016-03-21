/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5100002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.kaigoninteishinsakai.KaigoNinteiShinsakaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.ShinsakaiAutoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100002.ShinsakaiAutoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100002.ValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会自動割付取得処理。
 */
public class ShinsakaiAuto {

    /**
     * 審査会自動割付。<br/>
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    public ResponseData<ShinsakaiAutoDiv> onLoad(ShinsakaiAutoDiv shinDiv) {
        List<ShinsaKayiJidouWaritsukeBusiness> shinsaKayiList
                = ShinsaKayiJidouWaritsukeFinder.createInstance().getHanteiKekka(ViewStateHolder.get(ViewStateKeys.審査会一覧_開催番号, KaigoNinteiShinsakaiParameter.class)).records();
        getHandler(shinDiv).onLoad(shinsaKayiList);
        return createResponse(shinDiv);
    }

    /**
     * 「自動割付を実行する」ボタン押下、バッチパラメータを引き渡し、バッチを起動する。
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    // TODO 対象者自動割付（DBE510001）バッチ実装しない。
    public ResponseData<ShinsakaiAutoDiv> onClick_ShinsaBtn(ShinsakaiAutoDiv shinDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(shinDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessages = onClick_btnCheck(shinDiv);
            if (validationMessages.iterator().hasNext()) {
                return ResponseData.of(shinDiv).addValidationMessages(validationMessages).respond();
            }
        }
        return createResponseData(shinDiv);
    }

    /**
     * 入力チェック。<br/>
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    public ValidationMessageControlPairs onClick_btnCheck(ShinsakaiAutoDiv shinDiv) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();

        getValidationHandler(shinDiv).審査会データ空チェック(validationMessages);
        getValidationHandler(shinDiv).審査会未選択チェック(validationMessages);
        getValidationHandler(shinDiv).審査会開催チェック(validationMessages);
        getValidationHandler(shinDiv).ダミー審査会選択不可(validationMessages);
        return validationMessages;
    }

//    /**
//     * 「審査会一覧へ戻る」ボタン。<br/>
//     *
//     * @param shinDiv ShinsakaiAutoDiv
//     * @return ResponseData<ShinsakaiAutoDiv>
//     */
    // QA938 画面遷移処理はUIContainer存在しません
//    public ResponseData<ShinsakaiAutoDiv> onClick_btnPrintSchedule(ShinsakaiAutoDiv shinDiv) {
//        return ResponseData.of(shinDiv).forwardWithEventName().respond();
//    }
    private ResponseData<ShinsakaiAutoDiv> createResponseData(ShinsakaiAutoDiv shinDiv) {
        ResponseData<ShinsakaiAutoDiv> response = new ResponseData();
        response.data = shinDiv;
        return response;
    }

    private ShinsakaiAutoHandler getHandler(ShinsakaiAutoDiv shinDiv) {
        return new ShinsakaiAutoHandler(shinDiv);
    }

    private ResponseData<ShinsakaiAutoDiv> createResponse(ShinsakaiAutoDiv shinDiv) {
        return ResponseData.of(shinDiv).respond();
    }

    private ValidationHandler getValidationHandler(ShinsakaiAutoDiv shinDiv) {
        return new ValidationHandler(shinDiv);
    }

}
