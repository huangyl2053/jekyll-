/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5020001;

import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.DBD5020001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.DBD5020001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituGamenJoho;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho.YokaigoNinteiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoOutModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

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

        ShokkenTorikeshiIchibuSoshituHandler handler = getHandler(div);

        ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報 = handler.onLoad(申請書管理番号);
        ViewStateHolder.put(要介護認定処理画面キー.画面更新用情報, 画面更新用情報);
        
        // TODO 今回認定値、前回認定値、連絡先ボタン押した際、onBeforeする前に画面が開いてしまうとエラー
        //      基盤の問題で、1.14以降は修正されている模様　しばらく安定していたら消して良い(現在11/11)
//        setHdn(div, 画面更新用情報, 申請書管理番号);

        ValidationMessageControlPairs pairs = getValidationHandler(div).validate履歴番号();
        if (pairs.iterator().hasNext()) {
            div.setHdnKekkaCommonDivMode(new RString(KekkaShosaiJohoDiv.ShoriType.ShokaiMode.toString()));
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), true);
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        
        PersonalData personalData = PersonalData.of(new ShikibetsuCode(RString.EMPTY), new ExpandedInformation(new Code("0001"),
                new RString("申請書管理番号"), 申請書管理番号));
        AccessLogger.log(AccessLogType.照会, personalData);

        boolean gotLock = 前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }

        //TODO sync-24 マージ 暫定
        return ResponseData.of(div).setState(DBD5020001StateName.要介護認定);
    }

    /**
     * 「連絡先」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnRenrakusaki(ShokkenTorikeshiIchibuSoshituDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        NinteiShinseiBusinessCollection renrakusakiJoho = new NinteiShinseiBusinessCollection();
        renrakusakiJoho.setDbdBusiness(YokaigoNinteiJohoManager.createInstance().get連絡先情報(申請書管理番号));
        div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(renrakusakiJoho));
        div.setHdnRenrakusakiReadOnly(new RString("1"));
        div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(new NinteiShinseiBusinessCollection()));
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
        ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報 = ViewStateHolder.get(要介護認定処理画面キー.画面更新用情報, ShokkenTorikeshiIchibuSoshituGamenJoho.class);
        YokaigoNinteiJoho 今回情報 = 画面更新用情報.get今回情報();
        div.setHdnShikibetsuCode(今回情報.get識別コード受給() == null ? RString.EMPTY : 今回情報.get識別コード受給().getColumnValue());
        div.setHdnDisplayModeKey(new RString(ShisetsuNyutaishoRirekiKanriDiv.DisplayMode.照会.toString()));
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
        NinteiShinseiCodeModel model = new NinteiShinseiCodeModel();
        model.set表示モード(NinteiShinseiCodeModel.HyojiMode.ShokaiMode);
        model.set連絡事項(div.getHdnRenrakuJiko());
        ViewStateHolder.put(ViewStateKeys.モード, model);
        return ResponseData.of(div).respond();
    }

    /**
     * 「連絡事項」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnShichosonRenrakuJiko(ShokkenTorikeshiIchibuSoshituDiv div) {
        NinteiShinseiCodeModel model = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        div.setHdnRenrakuJiko(model.get連絡事項());
        return ResponseData.of(div).respond();
    }

    /**
     * 「前回認定値」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onBeforeOpenDialog_btnZenkaiNinteichi(ShokkenTorikeshiIchibuSoshituDiv div) {

        ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報 = ViewStateHolder.get(要介護認定処理画面キー.画面更新用情報, ShokkenTorikeshiIchibuSoshituGamenJoho.class);
        YokaigoNinteiJoho 前回情報 = 画面更新用情報.get前回情報();
        if (null == 前回情報) {
            return ResponseData.of(div).respond();
        }

        div.setHdnZenkaiSerializedBusiness(DataPassingConverter.serialize(getHandler(div).getKekkaShosaiJohoModel(前回情報, false)));
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
        ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報 = ViewStateHolder.get(要介護認定処理画面キー.画面更新用情報, ShokkenTorikeshiIchibuSoshituGamenJoho.class);
        YokaigoNinteiJoho 今回情報 = 画面更新用情報.get今回情報();
        if (null == 今回情報) {
            return ResponseData.of(div).respond();
        }

        div.setHdnKonkaiSerializedBusiness(DataPassingConverter.serialize(getHandler(div).getKekkaShosaiJohoModel(今回情報, true)));
        return ResponseData.of(div).respond();
    }

    /**
     * 「今回認定値」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDivDiv
     * @return ResponseData
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onOkClose_btnKonkaiNinteichi(ShokkenTorikeshiIchibuSoshituDiv div) {

        KekkaShosaiJohoOutModel model = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);

        getHandler(div).setKonkaiNinteichiAreaAfterOkClose(model);

        return ResponseData.of(div).respond();
    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     * @return ResponseData<ShokkenTorikeshiIchibuSoshituDiv>
     */
    public ResponseData<ShokkenTorikeshiIchibuSoshituDiv> onClick_btnBack(ShokkenTorikeshiIchibuSoshituDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).forwardWithEventName(DBD5020001TransitionEventName.一覧へ戻る).respond();
        }

        return ResponseData.of(div).respond();
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
            ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報 = ViewStateHolder.get(要介護認定処理画面キー.画面更新用情報, ShokkenTorikeshiIchibuSoshituGamenJoho.class);
            getHandler(div).save(画面更新用情報);
        } else {
            return ResponseData.of(div).respond();
        }
        前排他キーの解除();
        if (div.getTitle().contains("却下")) {
            div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString("却下処理が正常に終了しました。"));
            div.setTitle(new RString("要介護認定却下完了"));
            return ResponseData.of(div).setState(DBD5020001StateName.却下完了);
        } else {
            div.getCcdKaigoKanryoMessage().setSuccessMessage(new RString("更新処理が正常に終了しました。"));
            div.setTitle(new RString("要介護認定完了"));
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

    private boolean 前排他キーのセット() {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        return RealInitialLocker.tryGetLock(排他キー);
    }

    private void 前排他キーの解除() {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        LockingKey 排他キー = new LockingKey(申請書管理番号);
        RealInitialLocker.release(排他キー);
    }
    
//    private void setHdn(ShokkenTorikeshiIchibuSoshituDiv div, ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報, RString 申請書管理番号) {
//        YokaigoNinteiJoho 今回情報 = 画面更新用情報.get今回情報();
//        if (今回情報 != null) {
//            div.setHdnKonkaiSerializedBusiness(DataPassingConverter.serialize(getHandler(div).getKekkaShosaiJohoModel(今回情報, true)));
//            div.setHdnShikibetsuCode(今回情報.get識別コード受給() == null ? RString.EMPTY : 今回情報.get識別コード受給().getColumnValue());
//        }
//        YokaigoNinteiJoho 前回情報 = 画面更新用情報.get前回情報();
//        if (前回情報 != null) {
//            div.setHdnZenkaiSerializedBusiness(DataPassingConverter.serialize(getHandler(div).getKekkaShosaiJohoModel(前回情報, false)));
//        }
//        NinteiShinseiBusinessCollection renrakusakiJoho = new NinteiShinseiBusinessCollection();
//        renrakusakiJoho.setDbdBusiness(YokaigoNinteiJohoManager.createInstance().get連絡先情報(申請書管理番号));
//        div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(renrakusakiJoho));
//        div.setHdnRenrakusakiReadOnly(new RString("1"));
//        div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(new NinteiShinseiBusinessCollection()));
//        div.setHdnDisplayModeKey(new RString("照会"));
//    }
}
