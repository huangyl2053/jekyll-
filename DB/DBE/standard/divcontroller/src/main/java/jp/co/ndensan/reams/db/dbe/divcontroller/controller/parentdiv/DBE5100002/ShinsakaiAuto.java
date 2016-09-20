/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5100002;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE510001.DBE510001_ShinsakaiAutoWaritsukeParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakai.KaigoNinteiShinsakaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.DBE5100002TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5100002.ShinsakaiAutoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100002.ShinsakaiAutoHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5100002.ValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.shinsakayijidouwaritsuke.ShinsaKayiJidouWaritsukeFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 審査会自動割付取得処理です。
 *
 * @reamsid_L DBE-1350-030 lizhuoxuan
 */
public class ShinsakaiAuto {

    /**
     * 審査会自動割付します。<br/>
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    public ResponseData<ShinsakaiAutoDiv> onLoad(ShinsakaiAutoDiv shinDiv) {
        List<ShinsaKayiJidouWaritsukeBusiness> shinsaKayiList
                = ShinsaKayiJidouWaritsukeFinder.createInstance().getHanteiKekka(ViewStateHolder.get(ViewStateKeys.開催番号,
                                KaigoNinteiShinsakaiParameter.class)).records();
        getHandler(shinDiv).onLoad(shinsaKayiList);
        return createResponse(shinDiv);
    }

    /**
     * 「自動割付を実行する」ボタン押下、バッチパラメータを引き渡し、バッチを起動します。
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    public ResponseData<ShinsakaiAutoDiv> onClick_ShinsaBtn(ShinsakaiAutoDiv shinDiv) {
        ValidationMessageControlPairs validationMessages = onClick_btnCheck(shinDiv);
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(shinDiv).addValidationMessages(validationMessages).respond();
        }
        return createResponseData(shinDiv);
    }

    /**
     * 「自動割付を実行する」ボタンを押下時、バッチパラメータを引き渡し、バッチを起動する。<br/>
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    public ResponseData<DBE510001_ShinsakaiAutoWaritsukeParameter> onClick_btnShinsakaiAuto(ShinsakaiAutoDiv shinDiv) {
        return ResponseData.of(getHandler(shinDiv).setBatchParameter()).respond();
    }

    /**
     * 入力チェックします。<br/>
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

    /**
     * 「審査会一覧へ戻る」ボタンを遷移処理します。<br/>
     *
     * @param shinDiv ShinsakaiAutoDiv
     * @return ResponseData<ShinsakaiAutoDiv>
     */
    public ResponseData<ShinsakaiAutoDiv> onClick_btnReturn(ShinsakaiAutoDiv shinDiv) {
        return ResponseData.of(shinDiv).forwardWithEventName(DBE5100002TransitionEventName.審査会一覧へ戻る).respond();
    }

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
