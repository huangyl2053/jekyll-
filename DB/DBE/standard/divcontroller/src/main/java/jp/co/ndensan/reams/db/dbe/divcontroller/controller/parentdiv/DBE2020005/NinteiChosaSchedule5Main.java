/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachiku.ChosaChikuBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.DBE2020005StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.NinteiChosaSchedule5MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.dgChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020005.dgNinteiChosainList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020005.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.service.core.chosachiku.ChosaChikuManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosain;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuNinteiChosainIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 地区認定調査員情報のコントローラです。
 *
 * @reamsid_L DBE-0021-010 zhangzhiming
 */
public class NinteiChosaSchedule5Main {

    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString ROOTTITLE = new RString("地区認定調査員マスタの保存処理が完了しました。");

    /**
     * 初期化の設定します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onLoad(NinteiChosaSchedule5MainDiv div) {
        List<ChosaChikuBusiness> businessList = ChosaChikuManager.createInstance().getChosaChikuList().records();
        if (businessList == null || businessList.isEmpty()) {
            List<dgChosaChikuList_Row> rowList = new ArrayList<>();
            div.getChosaChikuPanel().getDgChosaChikuList().setDataSource(rowList);
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
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClik_btnSelect(NinteiChosaSchedule5MainDiv div) {
        Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> chikuNinteiChosain = getHandler(div).onClik_btnSelect();
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録5_地区認定調査員情報, chikuNinteiChosain);
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
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClick_btnAdd(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onClick_btnAdd();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 修正ボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClick_btnModify(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onClick_btnModify();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 削除ボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClick_btnDelete(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onClick_btnDelete();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * ダブルクリック押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClick_btnDouble(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onClick_btnDouble();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査委託先コードフォーカスをなくなるです。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onBlur_ChosaItakusaki(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onBlur_ChosaItakusaki();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査員コードフォーカスをなくなるです。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onBlur_Chosain(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onBlur_Chosain();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 取消するボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClick_btnTorikeshi(NinteiChosaSchedule5MainDiv div) {
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
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onClick_btnKakutei(NinteiChosaSchedule5MainDiv div) {
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
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> btnChosaChikuIchiran(NinteiChosaSchedule5MainDiv div) {
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
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).btnChosaChikuIchiran();
                return ResponseData.of(div).setState(DBE2020005StateName.調査地区一覧);
            } else {
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
            }
        }
        return ResponseData.of(div).setState(DBE2020005StateName.調査地区一覧);
    }

    /**
     * 認定調査員一覧へ戻るボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> btnBackNinteiChosaInIchiran(NinteiChosaSchedule5MainDiv div) {
        if (削除.equals(div.getNinteiChosainInput().getTxtJotai())) {
            getHandler(div).btnBackNinteiChosaInIchiran();
            return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
        }
        if (追加.equals(div.getNinteiChosainInput().getTxtJotai()) && (div.getNinteiChosainInput().getTxtYusenNo().getValue() != null
                || !div.getNinteiChosainInput().getTxtBiko().getValue().isNullOrEmpty()
                || !div.getNinteiChosainInput().getTxtNinteiChosaItakusakiCode().getValue().isNullOrEmpty()
                || !div.getNinteiChosainInput().getTxtNinteiChosainCode().getValue().isNullOrEmpty())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).btnBackNinteiChosaInIchiran();
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
            } else {
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
            }
        } else if (修正.equals(div.getNinteiChosainInput().getTxtJotai()) && (!div.getNinteiChosainInput().getTxtBiko().getValue().
                equals(div.getNinteiChosainInput().getHidBiko()) || !new RString(div.getNinteiChosainInput().getTxtYusenNo().getValue()
                        .toString()).equals(div.getNinteiChosainInput().getHidYusenNo()))) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.画面遷移の確認.getMessage().getCode(),
                        UrQuestionMessages.画面遷移の確認.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.画面遷移の確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).btnBackNinteiChosaInIchiran();
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
            } else {
                return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
            }
        }
        getHandler(div).btnBackNinteiChosaInIchiran();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
    }

    /**
     * 保存するボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> btnUpdate(NinteiChosaSchedule5MainDiv div) {
        List<dgNinteiChosainList_Row> ichiranList = div.getNinteiChosainPanel().getDgNinteiChosainList().getDataSource();
        boolean isUpdate = false;
        for (dgNinteiChosainList_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
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
            Models<ChikuNinteiChosainIdentifier, ChikuNinteiChosain> models
                    = ViewStateHolder.get(ViewStateKeys.認定調査スケジュール登録5_地区認定調査員情報, Models.class);
            getHandler(div).btnUpdate(models);
            div.getCcdKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2020005StateName.完了);
        }
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員一覧);
    }

    /**
     * 完了するボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> btnComplete(NinteiChosaSchedule5MainDiv div) {
        return ResponseData.of(div).setState(DBE2020005StateName.完了);
    }

    private MainPanelHandler getHandler(NinteiChosaSchedule5MainDiv div) {
        return new MainPanelHandler(div);
    }

    /**
     * 認定調査委託先検索ボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onOpen_ChosaItakusaki(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onOpen_ChosaItakusaki();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査委託先検索が戻します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onOkClose_ChosaItakusaki(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onOkClose_ChosaItakusaki();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査員検索ボタンが押下します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onOpen_Chosain(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onOpen_Chosain();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }

    /**
     * 認定調査員検索が戻します。
     *
     * @param div NinteiChosaSchedule5MainDiv
     * @return ResponseData<NinteiChosaSchedule5MainDiv>
     */
    public ResponseData<NinteiChosaSchedule5MainDiv> onOkClose_Chosain(NinteiChosaSchedule5MainDiv div) {
        getHandler(div).onOkClose_Chosain();
        return ResponseData.of(div).setState(DBE2020005StateName.認定調査員情報登録);
    }
}
