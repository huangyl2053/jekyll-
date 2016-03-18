/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2020007;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.ChosaChikuChichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosachikuchichoson.UzT0007CodeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.chosachikuchichoson.ChosaChikuChichosonParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.DBE2020007StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.NinteiChosaSchedule7MainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.dgChosaChikuChichosonList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020007.dgChosaChikuList_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020007.MainPanelHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2020007.MainPanelValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.chosachikuchichoson.ChosaChikuFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChikuShichosonIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 認定調査スケジュール登録7のコントローラです。
 */
public class NinteiChosaSchedule7Main {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString SELECT_KEY_1 = new RString("key0");
    private static final RString ROOTTITLE = new RString("調査地区市町村マスタの保存処理が完了しました。");

    /**
     * 初期化の設定します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onLoad(NinteiChosaSchedule7MainDiv div) {
        List<UzT0007CodeBusiness> businessList = ChosaChikuFinder.createInstance().getChosaChikuList().records();
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForOnLoad(businessList);
        getHandler(div).onLoad(businessList);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区一覧);
    }

    /**
     * 調査地区一覧の行クリックします。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClik_SelectBtn(NinteiChosaSchedule7MainDiv div) {
        dgChosaChikuList_Row dgRow = div.getChosaChikuPanel().getDgChosaChikuList().getSelectedItems().get(0);
        List<ChosaChikuChichosonBusiness> businessList = ChosaChikuFinder.createInstance()
                .getChosaChikuChichosonList(
                        ChosaChikuChichosonParameter.createParameter(dgRow.getChosaChikuCode(),
                                RString.EMPTY)).records();
        List<ChikuShichoson> 地区市町村情報 = ChosaChikuFinder.createInstance().
                get地区市町村情報(new Code(dgRow.getChosaChikuCode())).records();
        Models<ChikuShichosonIdentifier, ChikuShichoson> chikuShiChosain = Models.create(地区市町村情報);
        ViewStateHolder.put(ViewStateKeys.認定調査スケジュール登録7_地区市町村情報, chikuShiChosain);
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSelectbtn(businessList);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onClik_SelectBtn(businessList, dgRow);
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
    }

    /**
     * 調査地区市町村を追加します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_AddBtn(NinteiChosaSchedule7MainDiv div) {
        getHandler(div).onClick_AddBtn();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 修正ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_ModifyBtn(NinteiChosaSchedule7MainDiv div) {
        getHandler(div).onClick_ModifyBtn();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 削除ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_DeleteBtn(NinteiChosaSchedule7MainDiv div) {
        getHandler(div).onClick_DeleteBtn();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 調査地区市町村一覧Gridのダブルクリック。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_DoubleBtn(NinteiChosaSchedule7MainDiv div) {
        getHandler(div).onClick_DoubleBtn();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 市町村検索が戻します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onOkClose_Dialog(NinteiChosaSchedule7MainDiv div) {
        getHandler(div).onOkClose_Dialog();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 市町村コードフォーカスをなくなります。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onBlur_ShichosonCode(NinteiChosaSchedule7MainDiv div) {
        getHandler(div).onBlur_ShichosonCode();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 「取消する」ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_btnTorikeshi(NinteiChosaSchedule7MainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).onClick_TorikeshiBtn();
            return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
        }
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
    }

    /**
     * 「確定する」ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_KakuteiBtn(NinteiChosaSchedule7MainDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForKakuTeiBtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onClick_KakuteiBtn();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_HozonnBtn(NinteiChosaSchedule7MainDiv div) {
        List<dgChosaChikuChichosonList_Row> ichiranList = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getDataSource();
        boolean isUpdate = false;
        for (dgChosaChikuChichosonList_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (!isUpdate) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor編集状態();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForHozonnBtn();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
            getHandler(div).onClick_HozonnBtn();
            div.getCcdKanryoMessage().setMessage(ROOTTITLE, RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE2020007StateName.完了);
        }
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
    }

    /**
     * 調査地区一覧へ戻るボタンが押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_chosaChikuIchiranBtn(NinteiChosaSchedule7MainDiv div) {
        List<dgChosaChikuChichosonList_Row> ichiranList = div.getChosaChikuShichosonPanel().getDgChosaChikuChichosonList().getDataSource();
        boolean isUpdate = false;
        for (dgChosaChikuChichosonList_Row row : ichiranList) {
            if (!RString.EMPTY.equals(row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        if (isUpdate) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).chosaChikuIchiranBtn();
                return ResponseData.of(div).setState(DBE2020007StateName.調査地区一覧);
            }
        }
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
    }

    /**
     * 「調査地区市町村一覧へ戻る」ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_chosaChikuShichoSonIchiranBtn(NinteiChosaSchedule7MainDiv div) {
        if (状態_削除.equals(div.getChosaChikuShichosoInput().getTxtJotai())) {
            getHandler(div).chosaChikuShichoSonIchiranBtn();
            return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
        }
        if (状態_追加.equals(div.getChosaChikuShichosoInput().getTxtJotai())
                && (div.getChosaChikuShichosoInput().getTxtYusenNo().getValue() != null
                || !div.getChosaChikuShichosoInput().getTxtShichoSonCode().getValue().isNullOrEmpty()
                || !SELECT_KEY_1.equals(div.getChosaChikuShichosoInput().getRadJiChikuFlag().getSelectedKey())
                || !div.getChosaChikuShichosoInput().getTxtShichoSonMeisho().getValue().isNullOrEmpty())) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).chosaChikuShichoSonIchiranBtn();
                return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
            } else {
                return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
            }
        } else if (状態_修正.equals(div.getChosaChikuShichosoInput().getTxtJotai())
                && (!div.getChosaChikuShichosoInput().getHdnYusenNo().toString().equals(
                        div.getChosaChikuShichosoInput().getTxtYusenNo().getValue().toString())
                || !div.getChosaChikuShichosoInput().getHdnJichiku().equals(
                        div.getChosaChikuShichosoInput().getRadJiChikuFlag().getSelectedKey()))) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.画面遷移の確認.getMessage()).respond();
            }
            if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
                getHandler(div).chosaChikuShichoSonIchiranBtn();
                return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
            } else {
                return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村情報登録);
            }
        }
        getHandler(div).chosaChikuShichoSonIchiranBtn();
        return ResponseData.of(div).setState(DBE2020007StateName.調査地区市町村一覧);
    }

    /**
     * 「完了する」ボタンを押下します。
     *
     * @param div NinteiChosaSchedule7MainDiv
     * @return ResponseData<NinteiChosaSchedule7MainDiv>
     */
    public ResponseData<NinteiChosaSchedule7MainDiv> onClick_KanryouBtn(NinteiChosaSchedule7MainDiv div) {
        return ResponseData.of(div).setState(DBE2020007StateName.完了);
    }

    private MainPanelHandler getHandler(NinteiChosaSchedule7MainDiv div) {
        return new MainPanelHandler(div);
    }

    private MainPanelValidationHandler getValidationHandler(NinteiChosaSchedule7MainDiv div) {
        return new MainPanelValidationHandler(div);
    }
}
