/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020005;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachiku.ChosaChikuBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.DBE2020005StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.dgNinteiChosainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.mainPanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020005.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.service.core.chosachiku.ChosaChikuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 地区認定調査員情報のコントローラです。
 *
 */
public class mainPanel {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");

    /**
     * 初期化の設定します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onLoad(mainPanelDiv div) {
        List<ChosaChikuBusiness> businessList = ChosaChikuManager.createInstance().getChosaChikuList().records();
        if (businessList == null || businessList.isEmpty()) {
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).detaCheck();
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
            }
        }
        getHandler(div).onLoad(businessList);
        return ResponseData.of(div).setState(DBE2020005StateName.調査地区一覧);
    }

    /**
     * 調査地区一覧の行クリックします。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClik_btnSelect(mainPanelDiv div) {
        getHandler(div).onClik_btnSelect();
        if (div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource() == null
                || div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource().isEmpty()) {
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).detaCheck();
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
            }
        }
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
    }

    /**
     * 認定調査員を追加します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClick_btnAdd(mainPanelDiv div) {
        getHandler(div).onClick_btnAdd();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 修正ボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClick_btnModify(mainPanelDiv div) {
        getHandler(div).onClick_btnModify();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 削除ボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClick_btnDelete(mainPanelDiv div) {
        getHandler(div).onClick_btnDelete();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * ダブルクリック押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClick_btnDouble(mainPanelDiv div) {
        getHandler(div).onClick_btnDouble();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査委託先コードフォーカスをなくなるです。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onBlur_ChosaItakusaki(mainPanelDiv div) {
        getHandler(div).onBlur_ChosaItakusaki();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査員コードフォーカスをなくなるです。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onBlur_Chosain(mainPanelDiv div) {
        getHandler(div).onBlur_Chosain();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 取消するボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClick_btnTorikeshi(mainPanelDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onClick_btnTorikeshi();
            return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
        }
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 確定するボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> onClick_btnKakutei(mainPanelDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).validateCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        getHandler(div).onClick_btnKakutei();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
    }

    /**
     * 調査地区一覧へ戻るボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> btnChosaChikuIchiran(mainPanelDiv div) {
        List<dgNinteiChosainList_Row> ichiranList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();

        boolean isUpdate = false;
        for (dgNinteiChosainList_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.検索画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.検索画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).btnChosaChikuIchiran();
                return ResponseData.of(div).setState(DBE2020005StateName.調査地区一覧);
            }
        }
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
    }

    /**
     * 認定調査員一覧へ戻るボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> btnBackNinteiChosaInIchiran(mainPanelDiv div) {
        if (削除.equals(div.getNinteiChosainInput().getTxtJotai()) || RString.EMPTY.equals(div.getNinteiChosainInput().getTxtJotai())) {
            getHandler(div).btnBackNinteiChosaInIchiran();
            return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
        }
        if (追加.equals(div.getNinteiChosainInput().getTxtJotai()) && div.getNinteiChosainInput().getTxtYusenNo().getValue() != null
                && !div.getNinteiChosainInput().getTxtBiko().getValue().isNullOrEmpty()
                && !div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue().isNullOrEmpty()
                && !div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue().isNullOrEmpty()) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).btnBackNinteiChosaInIchiran();
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
            }
        }
        if (修正.equals(div.getNinteiChosainInput().getTxtJotai()) && !div.getNinteiChosainInput().getTxtBiko().getValue().isNullOrEmpty()
                && div.getNinteiChosainInput().getTxtYusenNo().getValue() != null) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).btnBackNinteiChosaInIchiran();
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
            }
        }
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 保存するボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> btnUpdate(mainPanelDiv div) {
        List<dgNinteiChosainList_Row> ichiranList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();
        boolean isUpdate = false;
        for (dgNinteiChosainList_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).認定調査員一覧Check();
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).btnUpdate_Del();
            if (validationMessageControlPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
            }
            getHandler(div).btnUpdate();
            // TODO QA840 完了メッセージの設定方法
            // div.getCcdKanryoMessage().setMessage(RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2020005StateName.完了);
        }
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
    }

    /**
     * 完了するボタンが押下します。
     *
     * @param div mainPanelDiv
     * @return ResponseData<mainPanelDiv>
     */
    public ResponseData<mainPanelDiv> btnComplete(mainPanelDiv div) {
        return ResponseData.of(div).setState(DBE2020005StateName.完了);
    }

    private MainPanelHandler getHandler(mainPanelDiv div) {
        return new MainPanelHandler(div);
    }
    // TODO 認定調査委託先検索ボタンと認定調査員検索ボタン、DBZ.ChosaItakusakiAndChosainGuide未実装 QA807

}
