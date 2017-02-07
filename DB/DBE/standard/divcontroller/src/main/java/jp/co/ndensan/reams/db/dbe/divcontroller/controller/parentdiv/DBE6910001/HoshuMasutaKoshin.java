/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6910001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinBetsuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinBetsuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTankaIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.DBE6910001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.HoshuMasutaKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgChosainhoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgHomonChosahoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgIkenShohoshuTankaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001.dgShinsakaiIinBetuTanka_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001.HoshuMasutaKoshinHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6910001.HoshuMasutaKoshinValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.hoshumasutakoshin.HoshuMasutaKoshinManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 報酬マスタメンテナンス画面のクラスです。
 *
 * @reamsid_L DBE-1710-010 dingyi
 */
public class HoshuMasutaKoshin {

    private final RString タブ名_審査員報酬単価マスタ = new RString("審査員報酬単価マスタ");
    private final RString タブ名_意見書報酬単価マスタ = new RString("意見書報酬単価マスタ");
    private final RString タブ名_訪問調査報酬単価マスタ = new RString("訪問調査報酬単価マスタ");
    private final RString タブ名_審査会委員別単価マスタ = new RString("審査会委員別単価マスタ");
    private final RString 追加モード = new RString("追加");
    private final RString 更新モード = new RString("修正");
    private final RString 削除モード = new RString("削除");

    /**
     * 報酬マスタメンテナンス画面の初期化処理です。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onLoad(HoshuMasutaKoshinDiv div) {
        set審査員報酬単価マスタ情報(div);
        set意見書報酬単価マスタ情報(div);
        set訪問調査報酬単価マスタ情報(div);
        set審査会委員別単価マスタ情報(div);
        div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabChosainhoshuTanka());
        return ResponseData.of(div).respond();
    }

    /**
     * 報酬マスタ更新タブのonChange処理です。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onChange_tabHoshuMasutaKoshin(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();

        RString 選択したタブ名 = div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getSelectedItem().getTitle();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                if (画面状態.equals(DBE6910001StateName.審査明細.getName())) {
                    div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getTabChosainhoshuTanka());
                }
                if (画面状態.equals(DBE6910001StateName.委員別明細.getName())) {
                    div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getTbShinsakaiIinBetuTanka());
                }
                if (画面状態.equals(DBE6910001StateName.意見明細.getName())) {
                    div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getTblIkenShohoshuTanka());
                }
                if (画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
                    div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().getTabHomonChosahoshuTanka());
                }

                return ResponseData.of(div).respond();
            }
        }
        if (タブ名_審査員報酬単価マスタ.equals(選択したタブ名)) {
            div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabChosainhoshuTanka());
        } else if (タブ名_意見書報酬単価マスタ.equals(選択したタブ名)) {
            div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTblIkenShohoshuTanka());
        } else if (タブ名_訪問調査報酬単価マスタ.equals(選択したタブ名)) {
            div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTabHomonChosahoshuTanka());
        } else if (タブ名_審査会委員別単価マスタ.equals(選択したタブ名)) {
            div.getHoshuMasutaTab().getTabHoshuMasutaKoshin().setSelectedItem(div.getHoshuMasutaTab().getTbShinsakaiIinBetuTanka());
        }
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 審査員報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnChoTsuika(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnChoTsuika();
        return ResponseData.of(div).setState(DBE6910001StateName.審査明細);
    }

    /**
     * 審査員報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnChosainModify(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnChosainModify(div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.審査明細);
    }

    /**
     * 審査員報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnChosainDelete(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnChosainDelete(div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.審査明細);
    }

    /**
     * 審査員報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnChoTorikesu(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnChoTorikesu();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 審査員報酬単価マスタ更新するボタンを押下するの場合、審査員報酬単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnChoKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).check審査員報酬単価マスタ();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報 = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getDataSource();
        for (dgChosainhoshuTankaIchiran_Row row : 審査員報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState()) || 更新モード.equals(row.getColumnState()) || 削除モード.equals(row.getColumnState())) {
                ViewStateHolder.remove(ViewStateKeys.審査員報酬単価マスタ情報);
                ViewStateHolder.put(ViewStateKeys.審査員報酬単価マスタ情報, ViewStateHolder.get(ViewStateKeys.審査員報酬単価マスタ情報Bak, Models.class));
            }
        }
        getHandler(div).onClick_btnChoKousin();
        update審査員報酬単価マスタ情報(div);
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 意見書報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnIkenTsuika(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnIkenTsuika();
        return ResponseData.of(div).setState(DBE6910001StateName.意見明細);
    }

    /**
     * 意見書報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnIkenShoModify(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnIkenShoModify(div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.意見明細);
    }

    /**
     * 意見書報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnIkenShoDelete(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnIkenShoDelete(div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.意見明細);
    }

    /**
     * 意見書報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnIkenTorikesu(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnIkenTorikesu();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 意見書報酬単価マスタ更新するボタンを押下するの場合、意見書報酬単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnIkenKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).check意見書報酬単価マスタ();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報 = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getDataSource();
        for (dgIkenShohoshuTankaIchiran_Row row : 意見書報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState()) || 更新モード.equals(row.getColumnState()) || 削除モード.equals(row.getColumnState())) {
                ViewStateHolder.remove(ViewStateKeys.意見書報酬単価マスタ情報);
                ViewStateHolder.put(ViewStateKeys.意見書報酬単価マスタ情報, ViewStateHolder.get(ViewStateKeys.意見書報酬単価マスタ情報Bak, Models.class));
            }
        }
        getHandler(div).onClick_btnIkenKousin();
        update意見書報酬単価マスタ情報(div);
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 訪問調査報酬単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHomTsuika(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnHomTsuika();
        return ResponseData.of(div).setState(DBE6910001StateName.訪問明細);
    }

    /**
     * 訪問調査報酬単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnHomonChosaModify(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnHomonChosaModify(div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.訪問明細);
    }

    /**
     * 訪問調査報酬単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnHomonChosaDelete(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnHomonChosaDelete(div.getHoshuMasutaTab().getDgHomonChosahoshuTankaIchiran().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.訪問明細);
    }

    /**
     * 訪問調査報酬単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHomTorikesu(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnHomTorikesu();
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 訪問調査報酬単価マスタ更新するボタンを押下するの場合、訪問調査報酬単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHomKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).check訪問調査報酬単価マスタ();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報 = div.getHoshuMasutaTab().
                getDgHomonChosahoshuTankaIchiran().getDataSource();
        for (dgHomonChosahoshuTankaIchiran_Row row : 訪問調査報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState()) || 更新モード.equals(row.getColumnState()) || 削除モード.equals(row.getColumnState())) {
                ViewStateHolder.remove(ViewStateKeys.訪問調査報酬単価マスタ情報);
                ViewStateHolder.put(ViewStateKeys.訪問調査報酬単価マスタ情報, ViewStateHolder.get(ViewStateKeys.訪問調査報酬単価マスタ情報Bak, Models.class));
            }
        }
        getHandler(div).onClick_btnHomKousin();
        update訪問調査報酬単価マスタ情報(div);
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 審査会委員別単価マスタ追加するボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnBetuTsuika(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnBetuTsuika();
        div.getHoshuMasutaTab().getShinsakaiIinBetuTankaMeisai().getBtnShinsakaiIinGuide().setDisabled(false);
        return ResponseData.of(div).setState(DBE6910001StateName.委員別明細);
    }

    /**
     * 審査会委員別単価マスタ一覧Gridの修正ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnShinsakaiIinBetuModify(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnShinsakaiIinBetuModify(div.getHoshuMasutaTab().getDgShinsakaiIinBetuTanka().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.委員別明細);
    }

    /**
     * 審査会委員別単価マスタ一覧Gridの削除ボタンを押下するの場合、明細パネルを表示します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onSelect_btnShinsakaiIinBetuDelete(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onSelect_btnShinsakaiIinBetuDelete(div.getHoshuMasutaTab().getDgShinsakaiIinBetuTanka().getActiveRow());
        return ResponseData.of(div).setState(DBE6910001StateName.委員別明細);
    }

    /**
     * 審査会委員別単価マスタ入力を取りやめるボタンを押下するの場合、内容を破棄して一覧状態に戻ります。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnBetuTorikesu(HoshuMasutaKoshinDiv div) {
        RString 画面状態;
        画面状態 = ResponseHolder.getState();
        if (画面状態.equals(DBE6910001StateName.委員別明細.getName())
                || 画面状態.equals(DBE6910001StateName.審査明細.getName())
                || 画面状態.equals(DBE6910001StateName.意見明細.getName())
                || 画面状態.equals(DBE6910001StateName.訪問明細.getName())) {
            if (!ResponseHolder.isReRequest()) {
                QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                        UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
            if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return ResponseData.of(div).respond();
            }
        }
        getHandler(div).onClick_btnBetuTorikesu();
        div.getHoshuMasutaTab().getShinsakaiIinBetuTankaMeisai().getBtnShinsakaiIinGuide().setDisabled(true);
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 審査員コードのonBlurイベント（審査員氏名を取得し、画面に設定する）。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onBlur_txtShinsaIinKodo(HoshuMasutaKoshinDiv div) {
        getHandler(div).onBlur_txtShinsaIinKodo();
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).check認定審査会委員();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員別単価マスタ更新するボタンを押下するの場合、審査会委員別単価マスタ一覧を更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnBetuKousin(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs controlPairs = getValidationHandler(div).check審査会委員別単価マスタ();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        List<dgShinsakaiIinBetuTanka_Row> 審査会委員別単価一覧情報 = div.getHoshuMasutaTab().
                getDgShinsakaiIinBetuTanka().getDataSource();
        for (dgShinsakaiIinBetuTanka_Row row : 審査会委員別単価一覧情報) {
            if (追加モード.equals(row.getColumnState()) || 更新モード.equals(row.getColumnState()) || 削除モード.equals(row.getColumnState())) {
                ViewStateHolder.remove(ViewStateKeys.審査会委員別単価マスタ情報);
                ViewStateHolder.put(ViewStateKeys.審査会委員別単価マスタ情報, ViewStateHolder.get(ViewStateKeys.審査会委員別単価マスタ情報Bak, Models.class));
            }
        }
        getHandler(div).onClick_btnBetuKousin();
        update審査会委員別単価マスタ情報(div);
        div.getHoshuMasutaTab().getShinsakaiIinBetuTankaMeisai().getBtnShinsakaiIinGuide().setDisabled(true);
        return ResponseData.of(div).setState(DBE6910001StateName.照会);
    }

    /**
     * 保存するボタンを押下するの場合、入力データをＤＢに更新します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onClick_btnHozon(HoshuMasutaKoshinDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForUpdate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            update一覧情報();
            div.getShinsakaiMessage().getCcdKaigoKanryoMessage().setMessage(
                    new RString("報酬マスタメンテナンスの保存処理が完了しました。"),
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, true);
            return ResponseData.of(div).setState(DBE6910001StateName.完了状態);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 認定審査会委員ガイドのデータを設定します。
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onOKClose_ShinsakaiIinGuide(HoshuMasutaKoshinDiv div) {
        div.getHoshuMasutaTab().getShinsakaiIinBetuTankaMeisai().getTxtShinsaIinKodo().setValue(div.getHdnShinsakaiIinCode());
        div.getHoshuMasutaTab().getShinsakaiIinBetuTankaMeisai().getTxtShinsaIinName().setValue(div.getHdnShinsakaiIinName());
        return ResponseData.of(div).respond();
    }

    /**
     * 認定審査会委員ガイドのonBefore_ShinsakaiIinGuide
     *
     * @param div 報酬マスタメンテナンスDiv
     * @return ResponseData<HoshuMasutaKoshinDiv>
     */
    public ResponseData<HoshuMasutaKoshinDiv> onBefore_ShinsakaiIinGuide(HoshuMasutaKoshinDiv div) {
        return ResponseData.of(div).respond();
    }

    private void set審査員報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ情報;
        Models<ShinsakaiIinHoshuTankaIdentifier, ShinsakaiIinHoshuTanka> 審査員報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査員報酬単価マスタ情報, Models.class);
        if (null == 審査員報酬単価情報Model || 審査員報酬単価情報Model.values().isEmpty()) {
            審査員報酬単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get審査員報酬単価マスタ情報().records();
            ViewStateHolder.put(ViewStateKeys.審査員報酬単価マスタ情報, Models.create(審査員報酬単価マスタ情報));
        } else {
            審査員報酬単価マスタ情報 = new ArrayList<>(審査員報酬単価情報Model.values());
        }
        getHandler(div).set審査員報酬単価マスタタブ(審査員報酬単価マスタ情報);
    }

    private void set意見書報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ情報;
        Models<ShujiiIkenshoHoshuTankaIdentifier, ShujiiIkenshoHoshuTanka> 意見書報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.意見書報酬単価マスタ情報, Models.class);
        if (null == 意見書報酬単価情報Model || 意見書報酬単価情報Model.values().isEmpty()) {
            意見書報酬単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get意見書報酬単価マスタ情報().records();
            ViewStateHolder.put(ViewStateKeys.意見書報酬単価マスタ情報, Models.create(意見書報酬単価マスタ情報));
        } else {
            意見書報酬単価マスタ情報 = new ArrayList<>(意見書報酬単価情報Model.values());
        }
        getHandler(div).set意見書報酬単価マスタタブ(意見書報酬単価マスタ情報);
    }

    private void set訪問調査報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ情報;
        Models<NinteiChosaHoshuTankaIdentifier, NinteiChosaHoshuTanka> 訪問調査報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.class);
        if (null == 訪問調査報酬単価情報Model || 訪問調査報酬単価情報Model.values().isEmpty()) {
            訪問調査報酬単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get認定調査報酬単価マスタ情報().records();
            ViewStateHolder.put(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.create(訪問調査報酬単価マスタ情報));
        } else {
            訪問調査報酬単価マスタ情報 = new ArrayList<>(訪問調査報酬単価情報Model.values());
        }
        getHandler(div).set訪問調査報酬単価マスタタブ(訪問調査報酬単価マスタ情報);
    }

    private void set審査会委員別単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<ShinsakaiIinBetsuTanka> 審査会委員別単価マスタ情報;
        Models<ShinsakaiIinBetsuTankaIdentifier, ShinsakaiIinBetsuTanka> 審査会委員別単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査会委員別単価マスタ情報, Models.class);
        if (null == 審査会委員別単価情報Model || 審査会委員別単価情報Model.values().isEmpty()) {
            審査会委員別単価マスタ情報 = HoshuMasutaKoshinManager.createInstance().get審査会委員別単価マスタ情報().records();
            ViewStateHolder.put(ViewStateKeys.審査会委員別単価マスタ情報, Models.create(審査会委員別単価マスタ情報));
        } else {
            審査会委員別単価マスタ情報 = new ArrayList<>(審査会委員別単価情報Model.values());
        }
        getHandler(div).set審査会委員別単価マスタタブ(審査会委員別単価マスタ情報);
    }

    private void update一覧情報() {
        List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ更新情報 = new ArrayList<>();
        List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ更新情報 = new ArrayList<>();
        List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ更新情報 = new ArrayList<>();
        List<ShinsakaiIinBetsuTanka> 審査会委員別単価マスタ更新情報 = new ArrayList<>();

        Models<ShinsakaiIinHoshuTankaIdentifier, ShinsakaiIinHoshuTanka> 審査員報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査員報酬単価マスタ情報, Models.class);
        if (null != 審査員報酬単価情報Model && null != 審査員報酬単価情報Model.values()) {
            審査員報酬単価マスタ更新情報 = new ArrayList<>(審査員報酬単価情報Model.values());
        }

        Models<ShujiiIkenshoHoshuTankaIdentifier, ShujiiIkenshoHoshuTanka> 意見書報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.意見書報酬単価マスタ情報, Models.class);
        if (null != 意見書報酬単価情報Model && null != 意見書報酬単価情報Model.values()) {
            意見書報酬単価マスタ更新情報 = new ArrayList<>(意見書報酬単価情報Model.values());
        }

        Models<NinteiChosaHoshuTankaIdentifier, NinteiChosaHoshuTanka> 訪問調査報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.class);
        if (null != 訪問調査報酬単価情報Model && null != 訪問調査報酬単価情報Model.values()) {
            訪問調査報酬単価マスタ更新情報 = new ArrayList<>(訪問調査報酬単価情報Model.values());
        }

        Models<ShinsakaiIinBetsuTankaIdentifier, ShinsakaiIinBetsuTanka> 審査会委員別単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査会委員別単価マスタ情報, Models.class);
        if (null != 審査会委員別単価情報Model && null != 審査会委員別単価情報Model.values()) {
            審査会委員別単価マスタ更新情報 = new ArrayList<>(審査会委員別単価情報Model.values());
        }

        HoshuMasutaKoshinManager.createInstance().updateマスタ情報(
                審査員報酬単価マスタ更新情報, 意見書報酬単価マスタ更新情報,
                訪問調査報酬単価マスタ更新情報, 審査会委員別単価マスタ更新情報);
    }

    private List<ShinsakaiIinHoshuTanka> update審査員報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgChosainhoshuTankaIchiran_Row> 審査員報酬単価一覧情報 = div.getHoshuMasutaTab().getDgChosainhoshuTankaIchiran().getDataSource();
        List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ更新情報;
        Models<ShinsakaiIinHoshuTankaIdentifier, ShinsakaiIinHoshuTanka> 審査員報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査員報酬単価マスタ情報, Models.class);
        for (dgChosainhoshuTankaIchiran_Row row : 審査員報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState())) {
                ShinsakaiIinHoshuTanka 新規情報 = new ShinsakaiIinHoshuTanka(
                        new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth(),
                        row.getTanka().getValue());
                審査員報酬単価情報Model.add(新規情報);
            } else if (更新モード.equals(row.getColumnState())) {
                ShinsakaiIinHoshuTankaIdentifier 識別子 = new ShinsakaiIinHoshuTankaIdentifier(
                    new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                    row.getKaishiYM().getValue().getYearMonth(),
                    row.getShuryoYMbak().getValue().getYearMonth());
                if (row.getShuryoYMbak().getValue().getYearMonth().compareTo(row.getShuryoYM().getValue().getYearMonth()) == 0) {
                    ShinsakaiIinHoshuTanka 更新情報 = 審査員報酬単価情報Model.get(識別子).createBuilderForEdit().
                            set単価(row.getTanka().getValue()).build().modifiedModel();
                    審査員報酬単価情報Model.add(更新情報);
                } else {
                    ShinsakaiIinHoshuTanka 削除情報 = 審査員報酬単価情報Model.get(識別子).deleted();
                    審査員報酬単価情報Model.add(削除情報);
                    ShinsakaiIinHoshuTanka 新規情報 = new ShinsakaiIinHoshuTanka(
                            new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                            row.getKaishiYM().getValue().getYearMonth(),
                            row.getShuryoYM().getValue().getYearMonth(),
                            row.getTanka().getValue());
                    審査員報酬単価情報Model.add(新規情報);
                }
            } else if (削除モード.equals(row.getColumnState())) {
                ShinsakaiIinHoshuTankaIdentifier 識別子 = new ShinsakaiIinHoshuTankaIdentifier(
                    new CodeShubetsu(row.getKaigoNinteiShinsaIinShubetsuCode()),
                    row.getKaishiYM().getValue().getYearMonth(),
                    row.getShuryoYMbak().getValue().getYearMonth());
                ShinsakaiIinHoshuTanka 削除情報 = 審査員報酬単価情報Model.get(識別子).deleted();
                審査員報酬単価情報Model.add(削除情報);
            }
        }
        ViewStateHolder.put(ViewStateKeys.審査員報酬単価マスタ情報Bak, ViewStateHolder.get(ViewStateKeys.審査員報酬単価マスタ情報, Models.class));
        ViewStateHolder.put(ViewStateKeys.審査員報酬単価マスタ情報, 審査員報酬単価情報Model);
        審査員報酬単価マスタ更新情報 = new ArrayList<>(審査員報酬単価情報Model.values());
        return 審査員報酬単価マスタ更新情報;
    }

    private List<ShujiiIkenshoHoshuTanka> update意見書報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgIkenShohoshuTankaIchiran_Row> 意見書報酬単価一覧情報 = div.getHoshuMasutaTab().getDgIkenShohoshuTankaIchiran().getDataSource();
        List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ更新情報;
        Models<ShujiiIkenshoHoshuTankaIdentifier, ShujiiIkenshoHoshuTanka> 意見書報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.意見書報酬単価マスタ情報, Models.class);
        for (dgIkenShohoshuTankaIchiran_Row row : 意見書報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState())) {
                ShujiiIkenshoHoshuTanka 新規情報 = new ShujiiIkenshoHoshuTanka(
                        new Code(row.getZaitakuShisetsuKubunCode()),
                        new Code(row.getIkenshoSakuseiKaisuKubunCode()),
                        row.getKaishiYM().getValue().getYearMonth());
                新規情報 = 新規情報.createBuilderForEdit().
                        set終了年月(row.getShuryoYM().getValue().getYearMonth()).
                        set単価(row.getTanka().getValue()).
                        build();
                意見書報酬単価情報Model.add(新規情報);
            } else if (更新モード.equals(row.getColumnState())) {
                ShujiiIkenshoHoshuTankaIdentifier 識別子 = new ShujiiIkenshoHoshuTankaIdentifier(
                        new Code(row.getZaitakuShisetsuKubunCode()),
                        new Code(row.getIkenshoSakuseiKaisuKubunCode()),
                        row.getKaishiYM().getValue().getYearMonth());
                ShujiiIkenshoHoshuTanka 修正情報 = 意見書報酬単価情報Model.get(識別子).createBuilderForEdit().
                        set終了年月(row.getShuryoYM().getValue().getYearMonth()).
                        set単価(row.getTanka().getValue()).
                        build().modifiedModel();
                意見書報酬単価情報Model.add(修正情報);
            } else if (削除モード.equals(row.getColumnState())) {
                ShujiiIkenshoHoshuTankaIdentifier 識別子 = new ShujiiIkenshoHoshuTankaIdentifier(
                        new Code(row.getZaitakuShisetsuKubunCode()),
                        new Code(row.getIkenshoSakuseiKaisuKubunCode()),
                        row.getKaishiYM().getValue().getYearMonth());
                ShujiiIkenshoHoshuTanka 削除情報 = 意見書報酬単価情報Model.get(識別子).deleted();
                意見書報酬単価情報Model.add(削除情報);
            }
        }
        ViewStateHolder.put(ViewStateKeys.意見書報酬単価マスタ情報Bak, ViewStateHolder.get(ViewStateKeys.意見書報酬単価マスタ情報, Models.class));
        ViewStateHolder.put(ViewStateKeys.意見書報酬単価マスタ情報, 意見書報酬単価情報Model);
        意見書報酬単価マスタ更新情報 = new ArrayList<>(意見書報酬単価情報Model.values());
        return 意見書報酬単価マスタ更新情報;
    }

    private List<NinteiChosaHoshuTanka> update訪問調査報酬単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgHomonChosahoshuTankaIchiran_Row> 訪問調査報酬単価一覧情報 = div.getHoshuMasutaTab().
                getDgHomonChosahoshuTankaIchiran().getDataSource();
        List<NinteiChosaHoshuTanka> 訪問調査報酬単価マスタ更新情報;
        Models<NinteiChosaHoshuTankaIdentifier, NinteiChosaHoshuTanka> 訪問調査報酬単価情報Model
                = ViewStateHolder.get(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.class);
        for (dgHomonChosahoshuTankaIchiran_Row row : 訪問調査報酬単価一覧情報) {
            if (追加モード.equals(row.getColumnState())) {
                NinteiChosaHoshuTanka 新規情報 = new NinteiChosaHoshuTanka(
                        new Code(row.getChosaKubunCode()),
                        new Code(row.getHomonShubetsuCode()),
                        row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYM().getValue().getYearMonth());
                新規情報 = 新規情報.createBuilderForEdit().
                        set単価(row.getTanka().getValue()).
                        build();
                訪問調査報酬単価情報Model.add(新規情報);
            } else if (更新モード.equals(row.getColumnState())) {
                NinteiChosaHoshuTankaIdentifier 識別子 = new NinteiChosaHoshuTankaIdentifier(
                    new Code(row.getChosaKubunCode()),
                    new Code(row.getHomonShubetsuCode()),
                    row.getKaishiYM().getValue().getYearMonth(),
                    row.getShuryoYMbak().getValue().getYearMonth());
                NinteiChosaHoshuTanka 既存情報 = 訪問調査報酬単価情報Model.get(識別子);
                if (既存情報.get終了年月().compareTo(row.getShuryoYM().getValue().getYearMonth()) == 0) {
                    NinteiChosaHoshuTanka 更新情報 = 訪問調査報酬単価情報Model.get(識別子).createBuilderForEdit().
                            set単価(row.getTanka().getValue()).
                            build().modifiedModel();
                    訪問調査報酬単価情報Model.add(更新情報);
                }else {
                    NinteiChosaHoshuTanka 削除情報 = 訪問調査報酬単価情報Model.get(識別子).deleted();
                    訪問調査報酬単価情報Model.add(削除情報);
                    NinteiChosaHoshuTanka 新規情報 = new NinteiChosaHoshuTanka(
                            new Code(row.getChosaKubunCode()),
                            new Code(row.getHomonShubetsuCode()),
                            row.getKaishiYM().getValue().getYearMonth(),
                            row.getShuryoYM().getValue().getYearMonth());
                    新規情報 = 新規情報.createBuilderForEdit().
                            set単価(row.getTanka().getValue()).
                            build();
                    訪問調査報酬単価情報Model.add(新規情報);
                }
            } else if (削除モード.equals(row.getColumnState())) {
                NinteiChosaHoshuTankaIdentifier 識別子 = new NinteiChosaHoshuTankaIdentifier(
                    new Code(row.getChosaKubunCode()),
                    new Code(row.getHomonShubetsuCode()),
                    row.getKaishiYM().getValue().getYearMonth(),
                        row.getShuryoYMbak().getValue().getYearMonth());
                NinteiChosaHoshuTanka 削除情報 = 訪問調査報酬単価情報Model.get(識別子).deleted();
                訪問調査報酬単価情報Model.add(削除情報);
            }
        }
        ViewStateHolder.put(ViewStateKeys.訪問調査報酬単価マスタ情報Bak, ViewStateHolder.get(ViewStateKeys.訪問調査報酬単価マスタ情報, Models.class));
        ViewStateHolder.put(ViewStateKeys.訪問調査報酬単価マスタ情報, 訪問調査報酬単価情報Model);
        訪問調査報酬単価マスタ更新情報 = new ArrayList<>(訪問調査報酬単価情報Model.values());
        return 訪問調査報酬単価マスタ更新情報;
    }

    private List<ShinsakaiIinBetsuTanka> update審査会委員別単価マスタ情報(HoshuMasutaKoshinDiv div) {
        List<dgShinsakaiIinBetuTanka_Row> 審査会委員別単価一覧情報 = div.getHoshuMasutaTab().
                getDgShinsakaiIinBetuTanka().getDataSource();
        List<ShinsakaiIinBetsuTanka> 審査会委員別単価マスタ更新情報;
        Models<ShinsakaiIinBetsuTankaIdentifier, ShinsakaiIinBetsuTanka> 審査会委員別単価情報Model
                = ViewStateHolder.get(ViewStateKeys.審査会委員別単価マスタ情報, Models.class);
        for (dgShinsakaiIinBetuTanka_Row row : 審査会委員別単価一覧情報) {
            FlexibleYearMonth 既存終了年月 = !row.getShuryoYMbak().getValue().isEmpty() ? row.getShuryoYMbak().getValue().getYearMonth() : FlexibleYearMonth.MAX;
            FlexibleYearMonth 新規終了年月 = !row.getShuryoYM().getValue().isEmpty() ? row.getShuryoYM().getValue().getYearMonth() : FlexibleYearMonth.MAX;
            RString 氏名 = null != row.getShinsakaiIinName() ? row.getShinsakaiIinName() : RString.EMPTY;
            if (追加モード.equals(row.getColumnState())) {
                ShinsakaiIinBetsuTanka 新規情報 = new ShinsakaiIinBetsuTanka(
                        row.getShinsakaiIinCode(),
                        row.getKaishiYM().getValue().getYearMonth(),
                        新規終了年月,
                        氏名);
                新規情報 = 新規情報.createBuilderForEdit().
                        set単価(row.getTanka().getValue()).
                        setその他単価(row.getSonotaTanka().getValue()).
                        build();
                審査会委員別単価情報Model.add(新規情報);
            } else if (更新モード.equals(row.getColumnState())) {
                ShinsakaiIinBetsuTankaIdentifier 識別子 = new ShinsakaiIinBetsuTankaIdentifier(
                        row.getShinsakaiIinCode(),
                        row.getKaishiYM().getValue().getYearMonth(),
                        既存終了年月);
                if (既存終了年月.equals(新規終了年月)) {
                    ShinsakaiIinBetsuTanka 更新情報 = 審査会委員別単価情報Model.get(識別子).createBuilderForEdit().
                            set単価(row.getTanka().getValue()).
                            setその他単価(row.getSonotaTanka().getValue()).
                            set氏名(氏名).
                            build().modifiedModel();
                    審査会委員別単価情報Model.add(更新情報);
                } else {
                    ShinsakaiIinBetsuTanka 削除情報 = 審査会委員別単価情報Model.get(識別子).deleted();
                    審査会委員別単価情報Model.add(削除情報);
                    ShinsakaiIinBetsuTanka 新規情報 = new ShinsakaiIinBetsuTanka(
                            row.getShinsakaiIinCode(),
                            row.getKaishiYM().getValue().getYearMonth(),
                            新規終了年月,
                            氏名);
                    新規情報 = 新規情報.createBuilderForEdit().
                            set単価(row.getTanka().getValue()).
                            setその他単価(row.getSonotaTanka().getValue()).
                            build();
                    審査会委員別単価情報Model.add(新規情報);
                }
            } else if (削除モード.equals(row.getColumnState())) {
                ShinsakaiIinBetsuTankaIdentifier 識別子 = new ShinsakaiIinBetsuTankaIdentifier(
                        row.getShinsakaiIinCode(),
                        row.getKaishiYM().getValue().getYearMonth(),
                        既存終了年月);
                ShinsakaiIinBetsuTanka 削除情報 = 審査会委員別単価情報Model.get(識別子).deleted();
                審査会委員別単価情報Model.add(削除情報);
            }
        }
        ViewStateHolder.put(ViewStateKeys.審査会委員別単価マスタ情報Bak, ViewStateHolder.get(ViewStateKeys.審査会委員別単価マスタ情報, Models.class));
        ViewStateHolder.put(ViewStateKeys.審査会委員別単価マスタ情報, 審査会委員別単価情報Model);
        審査会委員別単価マスタ更新情報 = new ArrayList<>(審査会委員別単価情報Model.values());
        return 審査会委員別単価マスタ更新情報;
    }

    private HoshuMasutaKoshinHandler getHandler(HoshuMasutaKoshinDiv div) {
        return new HoshuMasutaKoshinHandler(div);
    }

    private HoshuMasutaKoshinValidationHandler getValidationHandler(HoshuMasutaKoshinDiv div) {
        return new HoshuMasutaKoshinValidationHandler(div);
    }

}
