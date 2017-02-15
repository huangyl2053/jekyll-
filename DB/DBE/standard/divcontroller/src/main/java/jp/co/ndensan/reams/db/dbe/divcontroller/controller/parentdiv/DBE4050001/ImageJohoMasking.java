/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE4050001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imagejohomasking.ImageJohoMaskingResult;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoiraitaishoichiran.ShinseishoKanriNoList;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeQuestionMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.DBE4050001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.ImageJohoMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4050001.dgImageMaskingTaisho_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001.ImageJohoMaskingHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE4050001.ImageJohoMaskingValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * イメージ情報マスキングのコントローラです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
public class ImageJohoMasking {

    private static final RString UICONTAINERID_DBEUC20801 = new RString("DBEUC20801");

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

    /**
     * 画面検索条件より、処理対象者データを取得する
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTaishoKensaku(ImageJohoMaskingDiv div) {
        List<ImageJohoMaskingResult> resultList = getHandler(div).get対象者for画面();
        if (!ResponseHolder.isReRequest() && resultList.isEmpty()) {
            throw new ApplicationException(UrInformationMessages.該当データなし.getMessage());
        }
        getHandler(div).setDataGrid(resultList);
        return ResponseData.of(div).setState(DBE4050001StateName.検索結果表示);
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
        getHandler(div).setMeisai();
        getHandler(div).setDisabledStateToButton();
        return ResponseData.of(div).setState(DBE4050001StateName.イメージ情報表示);
    }

    /**
     * 取消するボタンを選択する場合、今回編集したマスキングイメージを破棄します。
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnTorikeshi(ImageJohoMaskingDiv div) {
        getHandler(div).deleteEditedData();
        getHandler(div).setDisabledStateToButton();
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
        getHandler(div).setDisabledStateToButton();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「対象選択に戻る」ボタン押下時のイベントです
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onClick_btnBackIchiran(ImageJohoMaskingDiv div) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
        if (ResponseHolder.getUIContainerId().equals(UICONTAINERID_DBEUC20801)) {
            return ResponseData.of(div).setState(DBE4050001StateName.完了処理遷移表示);
        } else {
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
            boolean has変更ファイル = false;
            ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
            for (dgImageMaskingTaisho_Row row : div.getDgImageMaskingTaisho().getDataSource()) {
                if (!row.getState().equals(RString.EMPTY)) {
                    has変更ファイル = true;
                    break;
                }
            }
            if (!has変更ファイル) {
                getValidationHandler().マスキングデータの存在チェック(validationMessages);
                return ResponseData.of(div).addValidationMessages(validationMessages).respond();
            }
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).update();
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), true);
            boolean マスキング完了済 = ViewStateHolder.get(ViewStateKeys.保存フラグ, boolean.class);
            if (マスキング完了済) {
                return ResponseData.of(div).setState(DBE4050001StateName.完了表示基本運用遷移無);
            } else {
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
        dgImageMaskingTaisho_Row row = div.getDgImageMaskingTaisho().getActiveRow();
        if (!ResponseHolder.isReRequest()) {
            if (!row.getMaskImagePath().isEmpty() || !row.getEditImagePath().isEmpty()) {
                QuestionMessage message = new QuestionMessage(DbeQuestionMessages.データ有確認.getMessage().getCode(),
                        DbeQuestionMessages.データ有確認.getMessage().replace("マスキングイメージ", "再度マスキングを").evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else {
                div.setHiddenImagePath(row.getImagePath());
                return ResponseData.of(div).respond();
            }
        }
        if (new RString(DbeQuestionMessages.データ有確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.setHiddenImagePath(row.getImagePath());
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * マスキング編集ボタンを押下すると、マスキングデータに対してマスキング処理を行います
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onBefore_onClickbtnMaskingMask(ImageJohoMaskingDiv div) {
        if (div.getDgImageMaskingTaisho().getActiveRow().getEditImagePath().isEmpty()) {
            div.setHiddenImagePath(div.getDgImageMaskingTaisho().getActiveRow().getMaskImagePath());
        } else {
            div.setHiddenImagePath(div.getDgImageMaskingTaisho().getActiveRow().getEditImagePath());
        }
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
        getHandler(div).setDisabledStateToButton();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnUpdate"), false);
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッド上で編集したいイメージを選択した時の処理です
     *
     * @param div イメージ情報マスキングDiv
     * @return ResponseData<イメージ情報マスキングDiv>
     */
    public ResponseData<ImageJohoMaskingDiv> onSelect_dgImageMaskingTaisho(ImageJohoMaskingDiv div) {
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

    private ImageJohoMaskingHandler getHandler(ImageJohoMaskingDiv div) {
        return new ImageJohoMaskingHandler(div);
    }

    private ImageJohoMaskingValidationHandler getValidationHandler() {
        return new ImageJohoMaskingValidationHandler();
    }

}
