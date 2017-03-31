/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4050001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.business.core.textmasking.TextMaskingModel;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskingTaisho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001.ImageJohoMaskingHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001.ImageJohoMaskingValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * イメージ情報マスキングのコントローラです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMasking {

    private static final RString UICONTAINERID_DBEUC20801 = new RString("DBEUC20801");
    private static final RString 保存ボタン = new RString("btnUpdate");
    private static final RString 保存ボタン完了処理 = new RString("btnSavefromKanryo");

    /**
     * コンストラクタです。
     *
     */
    public ImageJohoMasking() {
    }

    /**
     * イメージ情報マスキング初期化の設定します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onLoad(ImageJohoMaskingDiv div) {
        getHandler(div).initialize();
        ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);
        if (shinseishoKanriNoList != null) {
            List<ImageJohoMaskingResult> resultList = getHandler(div).get対象者forリスト(shinseishoKanriNoList);
            if (!ResponseHolder.isReRequest() && resultList.isEmpty()) {
                return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
            }
            getHandler(div).setDataGrid(resultList);
            return ResponseData.of(div).setState(DBE4050001StateName.完了処理遷移表示);
        }
        return ResponseData.of(div).respond();
    }

    public ResponseData<ImageJohoMaskingDiv> onActive(ImageJohoMaskingDiv div) {
        if (ResponseHolder.getState().equals(DBE4050001StateName.検索結果表示.getName())
                || ResponseHolder.getState().equals(DBE4050001StateName.完了処理遷移表示.getName())) {
            List<ImageJohoMaskingResult> resultList;
            if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
                ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);
                resultList = getHandler(div).get対象者forリスト(shinseishoKanriNoList);
                getHandler(div).setDataGrid(resultList);
            } else {
                resultList = getHandler(div).get対象者for画面();
                getHandler(div).setDataGrid(resultList);
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 画面検索条件より、処理対象者データを取得する
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTaishoKensaku(ImageJohoMaskingDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        List<ImageJohoMaskingResult> resultList = getHandler(div).get対象者for画面();
        if (!ResponseHolder.isReRequest() && resultList.isEmpty()) {
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
    }

    /**
     * 画面検索条件より、処理対象者データを取得する
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onChange_ddlKensakuTaisho(ImageJohoMaskingDiv div) {
        if (new RString("0").equals(div.getDdlKensakuTaisho().getSelectedKey())) {
            getHandler(div).clearAndDisableSearchYMD();
        } else {
            div.getTxtSearchYMD().setDisabled(false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索条件入力値をクリアする
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnClear(ImageJohoMaskingDiv div) {
        getHandler(div).clear();
        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンを押下の場合、イメージ情報パネルが表示する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onSelectBySelectButton_dgImageMaskShoriTaishosha(ImageJohoMaskingDiv div) {
        if (!ResponseHolder.isReRequest() && !getHandler(div).setMeisai()) {
            return ResponseData.of(div).addMessage(UrErrorMessages.排他_他のユーザが使用中.getMessage()).respond();
        }
        getHandler(div).setDisabledStateToButton();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            return ResponseData.of(div).setState(DBE4050001StateName.イメージ表示完了処理);
        } else {
            return ResponseData.of(div).setState(DBE4050001StateName.イメージ情報表示);
        }
    }

    /**
     * 取消するボタンを選択する場合、今回編集したマスキングイメージを破棄します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTorikeshi(ImageJohoMaskingDiv div) {
        getHandler(div).deleteEditedData();
        getHandler(div).changeButtonState();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, !getHandler(div).hasChanged());
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, !getHandler(div).hasChanged());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「マスキングデータを削除する」ボタンを選択する場合、既に保存されているマスキングイメージを破棄します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnSakujo(ImageJohoMaskingDiv div) {
        getHandler(div).deleteMaskingData();
        getHandler(div).changeButtonState();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象選択に戻る」ボタン押下時のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnBackIchiran(ImageJohoMaskingDiv div) {
        getHandler(div).releaseLock();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, true);
            return ResponseData.of(div).setState(DBE4050001StateName.完了処理遷移表示);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, true);
            return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
        }
    }

    /**
     * 「保存する」ボタンを押下の場合、マスクデータを追加する。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnUpdate(ImageJohoMaskingDiv div) {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            if (!getHandler(div).hasChanged()) {
                getValidationHandler().マスキングデータの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).update();
            if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, true);
            } else {
                CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, true);
            }
            boolean マスキング完了済 = ViewStateHolder.get(ViewStateKeys.保存フラグ, boolean.class);
            if (マスキング完了済) {
                div.getCcdKanryoMessage().setMessage(new RString("マスキングの保存処理が完了しました。"),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBE4050001StateName.完了表示基本運用遷移無);
            } else {
                div.getCcdKanryoMessage().setMessage(new RString("マスキングの保存処理が完了しました。"),
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
                return ResponseData.of(div).setState(DBE4050001StateName.完了表示基本運用遷移有);
            }
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * マスキングするボタンを押下すると、原本に対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingGenpon(ImageJohoMaskingDiv div) {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        div.setHiddenImagePath(row.getImagePath());
        return ResponseData.of(div).respond();
    }

    /**
     * マスキング編集ボタンを押下すると、マスキングデータに対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingMask(ImageJohoMaskingDiv div) {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        if (row.getEditImagePath().isEmpty()) {
            div.setHiddenImagePath(row.getMaskImagePath());
        } else {
            div.setHiddenImagePath(row.getEditImagePath());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * マスキングするボタンを押下すると、原本に対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingGenponText(ImageJohoMaskingDiv div) {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        TextMaskingModel model = new TextMaskingModel();
        getHandler(div).setTextMaskingData(model, row);
        model.setマスキング対象テキスト(row.getImagePath());
        div.setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * マスキング編集ボタンを押下すると、マスキングデータに対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingMaskText(ImageJohoMaskingDiv div) {
        dgImageMaskingTaisho_Row row = ViewStateHolder.get(ViewStateKeys.詳細データ, dgImageMaskingTaisho_Row.class);
        TextMaskingModel model = new TextMaskingModel();
        getHandler(div).setTextMaskingData(model, row);
        if (row.getEditImagePath().isEmpty()) {
            model.setマスキング対象テキスト(row.getMaskImagePath());
        } else {
            model.setマスキング対象テキスト(row.getEditImagePath());
        }
        div.setHdnTextMasking(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    /**
     * イメージマスキングダイアログでデータが保存された時の処理です
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onOkClose(ImageJohoMaskingDiv div) {
        RString newImagePath = div.getHiddenImagePath();
        getHandler(div).updateRow(newImagePath);
        getHandler(div).changeButtonState();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * イメージマスキングダイアログでデータが保存された時の処理です
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onOkClose_textMasking(ImageJohoMaskingDiv div) {
        TextMaskingModel model = DataPassingConverter.deserialize(div.getHdnTextMasking(), TextMaskingModel.class);
        getHandler(div).updateRow(model.getマスキング対象テキスト());
        getHandler(div).changeButtonState();
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, false);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッド上で編集したいイメージを選択した時の処理です
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onSelect_dgImageMaskingTaisho(ImageJohoMaskingDiv div) {
        ViewStateHolder.put(ViewStateKeys.詳細データ, div.getDgImageMaskingTaisho().getActiveRow());
        getHandler(div).changeButtonState();
        return ResponseData.of(div).respond();
    }

    /**
     * 保存後の完了画面から続けて処理を行う際のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnContinue(ImageJohoMaskingDiv div) {
        List<ImageJohoMaskingResult> resultList;
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            ShinseishoKanriNoList shinseishoKanriNoList = ViewStateHolder.get(ViewStateKeys.申請書管理番号リスト, ShinseishoKanriNoList.class);
            resultList = getHandler(div).get対象者forリスト(shinseishoKanriNoList);
            getHandler(div).setDataGrid(resultList);
            return ResponseData.of(div).setState(DBE4050001StateName.完了処理遷移表示);
        } else {
            resultList = getHandler(div).get対象者for画面();
            getHandler(div).setDataGrid(resultList);
            return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
        }
    }

    /**
     * 保存後の完了画面で完了を選んだ際のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnComplete(ImageJohoMaskingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE4050001TransitionEventName.終了する).respond();
    }

    /**
     * 「基本運用・マスキングに戻る」ボタン押下時のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnBackKihonunyo(ImageJohoMaskingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE4050001TransitionEventName.基本運用へ遷移).respond();
    }

    /**
     * 「基本運用へ進む」ボタン押下時のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnKihonUnyou(ImageJohoMaskingDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE4050001TransitionEventName.基本運用へ遷移).respond();
    }

    /**
     * 対象者一覧画面「再検索」ボタン押下時のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnSaiKensaku(ImageJohoMaskingDiv div) {
        return ResponseData.of(div).setState(DBE4050001StateName.初期表示);
    }

    /**
     * マスキング選択画面「再検索」ボタン押下時のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnReSearch(ImageJohoMaskingDiv div) {
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン完了処理, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, true);
        }
        getHandler(div).releaseLock();
        getHandler(div).clear();
        return ResponseData.of(div).setState(DBE4050001StateName.初期表示);
    }

    public ResponseData<ImageJohoMaskingDiv> onClick_btnKekkaToroku(ImageJohoMaskingDiv div) {
        getHandler(div).getKekkaTorokuParam();
        return ResponseData.of(div).forwardWithEventName(DBE4050001TransitionEventName.認定調査結果登録に遷移).respond();
    }

    private ImageJohoMaskingHandler getHandler(ImageJohoMaskingDiv div) {
        return new ImageJohoMaskingHandler(div);
    }

    private ImageJohoMaskingValidationHandler getValidationHandler() {
        return new ImageJohoMaskingValidationHandler();
    }

}
