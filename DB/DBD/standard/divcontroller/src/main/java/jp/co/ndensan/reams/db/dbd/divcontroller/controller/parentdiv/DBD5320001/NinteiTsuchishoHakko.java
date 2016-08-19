/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5320001;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutisho;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5320001.TsutishoHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdQuestionMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.DBD5320001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.DBD5320001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.NinteiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001.NinteiTsuchishoHakkoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001.NinteiTsuchishoHakkoValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 要介護認定通知書発行画面のDivControllerです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public class NinteiTsuchishoHakko {

    /**
     * 要介護認定通知書発行キーのEnum
     */
    private enum 要介護認定通知書発行画面キー {

        /**
         * 画面更新用情報
         */
        画面更新用情報,
        /**
         * 画面ダイアローグ番号
         */
        画面ダイアローグ番号;
    }

    /**
     * 画面初期化
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onLoad(NinteiTsuchishoHakkoDiv div) {

        getHandler(div).onLoad();
        return ResponseData.of(div).setState(DBD5320001StateName.初始状態);
    }

    /**
     * 「条件をクリアする」ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnJokenClear(NinteiTsuchishoHakkoDiv div) {
        getHandler(div).clearJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnKensaku(NinteiTsuchishoHakkoDiv div) {

        getHandler(div).clearChohyoArea();
        List<YokaigoNinteiTsutisho> 画面更新用データ = getHandler(div).kensaku();

        ValidationMessageControlPairs pairs = getValidationHandler(div).validate();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                画面更新用データ.get(0).get申請書管理番号());
        ExpandedInformation expandedInfoHihoNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                div.getTxtHihoNo().getValue());
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo, expandedInfoHihoNo);
        AccessLogger.log(AccessLogType.照会, personalData);

        ViewStateHolder.put(要介護認定通知書発行画面キー.画面更新用情報, (Serializable) 画面更新用データ);

        return ResponseData.of(div).setState(DBD5320001StateName.個別発行);
    }

    /**
     * radPrintSelectのクリック処理
     *
     * @param div NinteiTsuchishoHakkoDivDiv
     * @return ResponseData
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_radPrintSelect(NinteiTsuchishoHakkoDiv div) {
        getHandler(div).clearJoken();
        getHandler(div).clearChohyoArea();
        boolean is個別発行 = div.getRadPrintSelect().getSelectedKey().equals(NinteiTsuchishoHakkoHandler.RadioValue.個別発行を行う.getKey());

        if (is個別発行) {
            return ResponseData.of(div).setState(DBD5320001StateName.初始状態);
        } else {
            getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.一括発行パネル);
            return ResponseData.of(div).setState(DBD5320001StateName.一括発行);
        }
    }

    /**
     * 「認定結果通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_NinteiKekkaTsuchi(NinteiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate選択対象();
        if (pairs.iterator().hasNext()) {
            div.getNinteiKekkaTsuchi().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行認定結果通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス変更通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_ServiceHenkoTsuchi(NinteiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate選択対象();
        if (pairs.iterator().hasNext()) {
            div.getServiceHenkoTsuchi().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行サービス変更通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「要介護度変更通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_YokaigodoHenkoTsuchi(NinteiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate選択対象();
        if (pairs.iterator().hasNext()) {
            div.getYokaigodoHenkoTsuchi().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行要介護度変更通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「認定却下通知書」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_NinteiKyakkaTshuchi(NinteiTsuchishoHakkoDiv div) {
        ValidationMessageControlPairs pairs = getValidationHandler(div).validate選択対象();
        if (pairs.iterator().hasNext()) {
            div.getNinteiKyakkaTshuchi().setIsOpen(false);
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.個別発行認定却下通知書パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「一括発行」エリアのOPEN処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onOpen_IkkatsuHakko(NinteiTsuchishoHakkoDiv div) {
        getHandler(div).openChohyoPanel(NinteiTsuchishoHakkoHandler.PanelType.一括発行パネル);

        return ResponseData.of(div).respond();
    }

    /**
     * 「却下理由にコピー」ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnCopyJiyuToRiyu(NinteiTsuchishoHakkoDiv div) {
        div.getTxtKyakkaRiyu().setValue(div.getTxtIdoJiyu().getValue());
        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」個別発行ボタンの処理前のチェック
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnUpdateValidate(NinteiTsuchishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs pairs = getValidationHandler(div).validate選択対象();
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }

            return ResponseData.of(div).addMessage(DbdQuestionMessages.処理実行の確認.getMessage(ButtonSelectPattern.OKCancel)).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」個別発行ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnUpdate(NinteiTsuchishoHakkoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        List<YokaigoNinteiTsutisho> 画面更新用情報 = ViewStateHolder.get(要介護認定通知書発行画面キー.画面更新用情報, List.class);
        SourceDataCollection collection = getHandler(div).printAndSave(画面更新用情報);
        response.data = collection;
        return response;
    }

    /**
     * 「通知書を発行する」個別発行ボタンの処理後の遷移
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<NinteiTsuchishoHakkoDiv> onClick_btnUpdateAfterPrint(NinteiTsuchishoHakkoDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.保存終了.getMessage()).respond();
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getCcdKanryoMessege().setMessage(new RString("更新処理が正常に終了しました。"), RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).forwardWithEventName(DBD5320001TransitionEventName.完了).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「通知書を発行する」一括発行ボタンの処理
     *
     * @param div NinteiTsuchishoHakkoDiv
     * @return ResponseData<NinteiTsuchishoHakkoDiv>
     */
    public ResponseData<TsutishoHakkoParameter> onClick_btnIkkatsuHakkoUpdate(NinteiTsuchishoHakkoDiv div) {
        TsutishoHakkoParameter param = getHandler(div).createTsutishoHakkoParameter();
        div.getCcdKanryoMessege().setMessage(new RString("更新処理が正常に終了しました。"), RString.EMPTY, RString.EMPTY, true);
        return ResponseData.of(param).forwardWithEventName(DBD5320001TransitionEventName.完了).respond();
    }

    private NinteiTsuchishoHakkoHandler getHandler(NinteiTsuchishoHakkoDiv div) {
        return new NinteiTsuchishoHakkoHandler(div);
    }

    private NinteiTsuchishoHakkoValidationHandler getValidationHandler(NinteiTsuchishoHakkoDiv div) {
        return new NinteiTsuchishoHakkoValidationHandler(div);
    }
}
