/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5020001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.DBD5020001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.DBD5020001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituHandler.GamenJoho;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 要介護認定処理画面のDivControllerです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public class ShokkenTorikeshiIchibuSoshitu {

    /**
     * 要介護認定処理画面キーのEnum
     */
    private enum 要介護認定処理画面キー {

        /**
         * 画面更新用情報
         */
        画面更新用情報;
    }

    /**
     * 画面初期化
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onLoad(ShokkenTorikeshiIchibuSoshituDiv div) {

        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);

        ShokkenTorikeshiIchibuSoshituHandler handler = getHandler(div);

        GamenJoho 画面更新用情報 = handler.onLoad(申請書管理番号, 被保険者番号);

        ValidationMessageControlPairs pairs = getValidationHandler(div).validate履歴番号();
        if (pairs.iterator().hasNext()) {
            div.setHdnKekkaCommonDivMode(new RString(KekkaShosaiJohoDiv.ShoriType.ShokaiMode.toString()));
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        ViewStateHolder.put(要介護認定処理画面キー.画面更新用情報, 画面更新用情報);

        return ResponseData.of(div).setState(DBD5020001StateName.要介護認定);
    }

    /**
     * 「連絡先」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnRenrakusaki(ShokkenTorikeshiIchibuSoshituDiv div) {
        // TODO. 仕様書に記述しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡先」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnRenrakusaki(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入所」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnNyuinShisetsuNyujo(ShokkenTorikeshiIchibuSoshituDiv div) {
        // TODO. 仕様書に記述しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「施設入所」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnNyuinShisetsuNyujo(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡事項」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnShichosonRenrakuJiko(ShokkenTorikeshiIchibuSoshituDiv div) {
        // TODO. 仕様書に記述しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡事項」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnShichosonRenrakuJiko(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「前回認定値」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnZenkaiNinteichi(ShokkenTorikeshiIchibuSoshituDiv div) {
        // TODO. DBZ.KekkaShosaiJohoについて、実装しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「前回認定値」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnZenkaiNinteichi(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 「今回認定値」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnKonkaiNinteichi(ShokkenTorikeshiIchibuSoshituDiv div) {
        // TODO. DBZ.KekkaShosaiJohoについて、実装しない。
//        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
//        getHandler(div).onBeforeOpenDialog_btnDispGemmenJoho(taishoshaKey);
        return ResponseData.of(div).respond();
    }

    /**
     * 「今回認定値」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnKonkaiNinteichi(ShokkenTorikeshiIchibuSoshituDiv div) {
        // TODO. DBZ.KekkaShosaiJohoについて、実装しない。
//        JigyoshaMode jigyoshaMode = DataPassingConverter.deserialize(div.
//                getJigyoshaMode(), JigyoshaMode.class);
        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onClick_btnBack(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD5020001TransitionEventName.一覧へ戻る).respond();
    }

    /**
     * 「保存する」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onClick_btnUpdate(ShokkenTorikeshiIchibuSoshituDiv div) {

        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }

            return ResponseData.of(div).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            GamenJoho 画面更新用情報 = ViewStateHolder.get(要介護認定処理画面キー.画面更新用情報, GamenJoho.class);
            getHandler(div).save(画面更新用情報);
        }

        if (div.getTitle().contains("却下")) {
            return ResponseData.of(div).setState(DBD5020001StateName.却下完了);
        } else {
            return ResponseData.of(div).setState(DBD5020001StateName.認定完了);
        }

    }

    /**
     * 「要介護認定結果通知書を発行する」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onClick_btnToKubunHenkoTsuchisho(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD5020001TransitionEventName.サービス変更通知書を発行).respond();
    }

    /**
     * 「認定却下通知書を発行する」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onClick_btnToServiceHenkoTsuchisho(ShokkenTorikeshiIchibuSoshituDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD5020001TransitionEventName.区分変更通知書を発行).respond();
    }

    private ShokkenTorikeshiIchibuSoshituHandler getHandler(ShokkenTorikeshiIchibuSoshituDiv div) {
        return new ShokkenTorikeshiIchibuSoshituHandler(div);
    }

    private ShokkenTorikeshiIchibuSoshituValidationHandler getValidationHandler(ShokkenTorikeshiIchibuSoshituDiv div) {
        return new ShokkenTorikeshiIchibuSoshituValidationHandler(div);
    }
}
