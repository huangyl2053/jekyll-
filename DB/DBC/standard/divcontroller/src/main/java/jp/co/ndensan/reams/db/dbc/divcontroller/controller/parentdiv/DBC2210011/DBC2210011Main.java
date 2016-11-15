/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2210011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch.TokubetsuKyufuJigyoshaSearchBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaDetailServiceList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011.DBC2210011MainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011.DBC2210011MainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyosha.TokubetsuKyufuJigyoshaService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 市町村特別給付・サービス事業者管理のDivControllerです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
public class DBC2210011Main {

    private final RString 追加モード = new RString("追加");
    private final RString 修正モード = new RString("修正");
    private final RString 削除モード = new RString("削除");
    private final RString 照会モード = new RString("照会");
    private final RString サービス追加モード = new RString("サービス追加");
    private final RString サービス修正モード = new RString("サービス修正");
    private final RString サービス照会モード = new RString("サービス照会");
    private static final int NO_10 = 10;
    private static final int NO_0 = 0;

    /**
     * 画面初期化します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onLoad(DBC2210011MainDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * C/DButtonをクリック。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_btnCdSearch(DBC2210011MainDiv div) {
        getHandler(div).onClick_binSetSearch();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するButtonをクリック。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_btnSearch(DBC2210011MainDiv div) {
        getHandler(div).onClick_btnSearch();
        return ResponseData.of(div).respond();
    }

    /**
     * 「事業者情報を追加する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_btnAdd(DBC2210011MainDiv div) {
        div.setHiddenModelOne(追加モード);
        getHandler(div).onClick_btnAddJigyosha();
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス事業者一覧DataGridの選択」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onSelect_JyugyoShaList(DBC2210011MainDiv div) {
        div.setHiddenModelOne(照会モード);
        RString 事業者Code = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow().getTxtJigyoshaCode();
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List = service.select事業者情報(事業者Code, NO_10, RString.EMPTY);
        if (事業者サービス情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.toString());
        } else {
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(事業者サービス情報List));
            getHandler(div).onSelect_byListSelect(事業者サービス情報List, div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow());
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス事業者一覧DataGridの修正」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onChange_JyugyoShaList(DBC2210011MainDiv div) {
        div.setHiddenModelOne(修正モード);
        RString 事業者Code = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow().getTxtJigyoshaCode();
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List = service.select事業者情報(事業者Code, NO_10, RString.EMPTY);
        if (事業者サービス情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.toString());
        } else {
            getHandler(div).前排他の設定(事業者Code);
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(事業者サービス情報List));
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者の情報, 事業者Code);
            getHandler(div).onSelect_byListModify(事業者サービス情報List, div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス事業者一覧DataGridの削除」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onDelete_JyugyoShaList(DBC2210011MainDiv div) {
        div.setHiddenModelOne(削除モード);
        RString 事業者Code = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow().getTxtJigyoshaCode();
        TokubetsuKyufuJigyoshaService service = TokubetsuKyufuJigyoshaService.createTokubetsuKyufuJigyoshaService();
        List<TokubetsuKyufuJigyoshaSearchBusiness> 事業者サービス情報List = service.select事業者情報(事業者Code, NO_10, RString.EMPTY);
        if (事業者サービス情報List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.toString());
        } else {
            getHandler(div).前排他の設定(事業者Code);
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(事業者サービス情報List));
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者の情報, 事業者Code);
            getHandler(div).onSelect_byListDelete(事業者サービス情報List, div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請者情報からコピー」(代表者情報パネル)ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_CopyShinseiJoho(DBC2210011MainDiv div) {
        getHandler(div).onClick_btnCopyFromShinseisha();
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス情報追加」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_AddServiceJoho(DBC2210011MainDiv div) {
        div.setHiddenModel(サービス追加モード);
        getHandler(div).onAdd_byDetail();
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス情報選択」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_selectShinseiShaJoho(DBC2210011MainDiv div) {
        div.setHiddenModel(サービス照会モード);
        List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報
                = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        getHandler(div).onSelect_byDetailSelect(getHandler(div).get情報と状態BySelectDataSouce(サービス事業者情報));
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス情報修正」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_ModifyShinseiShaJoho(DBC2210011MainDiv div) {
        div.setHiddenModel(サービス修正モード);
        List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報
                = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        getHandler(div).onSelect_byDetailModify(getHandler(div).get情報と状態BySelectDataSouce(サービス事業者情報));
        return ResponseData.of(div).respond();
    }

    /**
     * 「サービス情報削除」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_deleteShinseiShaJoho(DBC2210011MainDiv div) {
        if (追加モード.equals(div.getHiddenModelOne())) {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
            }
            if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.削除の確認.getMessage().getCode()))
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                        .getDataSource().remove(div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                                .getDgTokubetsuKyufuJigyoshaDetailServiceList().getClickedRowId());
            }
        } else if (修正モード.equals(div.getHiddenModelOne())) {
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList()
                    .getDgTokubetsuKyufuJigyoshaDetailServiceList().getActiveRow().setRowState(RowState.Deleted);
            List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報
                    = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
            TokubetsuKyufuJigyoshaSearchBusiness 削除情報 = getHandler(div).get情報と状態BySelectDataSouce(サービス事業者情報);
            削除情報.createBuilderForEdit().set論理削除フラグ(true);
            削除情報.get市町村特別給付サービス事業者().get事業者().setState(EntityDataState.Modified);

            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(サービス事業者情報));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「申請者情報からコピー」(管理者情報パネル)ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_CopyKanriSha(DBC2210011MainDiv div) {
        getHandler(div).onClick_管理者情報コピー();
        return ResponseData.of(div).respond();
    }

    /**
     * 「管理者情報からコピー」(事業者情報パネル)ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_CopyJyugyoSha(DBC2210011MainDiv div) {
        getHandler(div).onClick_btnCopyFromKanrisha();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_SaveButton(DBC2210011MainDiv div) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.保存の確認.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            set事業者コード重複チェック(div, pairs);
            getValidationHandler().サービス情報作成チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報
                    = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
            set情報削除Model(div, サービス事業者情報);
            getHandler(div).onClick_Save(サービス事業者情報);
            getHandler(div).前排他の解除(サービス事業者情報.get(0).get市町村特別給付用事業者番号().value());
            RString messageMain = new RString("市町村特別給付サービス事業者の登録が完了しました。");
            RString 事業者コード = new RString("事業者コード:");
            RString messageTaisho1 = 事業者コード.concat(サービス事業者情報.get(NO_0).get市町村特別給付用事業者番号().getColumnValue());
            div.getCcdKanryoMessage().setSuccessMessage(messageMain, messageTaisho1, RString.EMPTY);
            return ResponseData.of(div).setState(DBC2210011StateName.処理完了);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧へボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_backKensakuList(DBC2210011MainDiv div) {
        if (照会モード.equals(div.getHiddenModelOne())) {
            ViewStateHolder.clear();
            div.setHiddenModelOne(RString.EMPTY);
            getHandler(div).onClick_btnSearch();
            div.setHiddenModelOne(RString.EMPTY);
            div.setHiddenModel(RString.EMPTY);
            return ResponseData.of(div).setState(DBC2210011StateName.検索表示);
        } else {
            if (!ResponseHolder.isReRequest()) {
                return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
            }
            if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()))
                    && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
                修正削除の前排他の解除(div);
                ViewStateHolder.clear();
                getHandler(div).onClick_btnSearch();
                div.setHiddenModelOne(RString.EMPTY);
                div.setHiddenModel(RString.EMPTY);

                return ResponseData.of(div).setState(DBC2210011StateName.検索表示);

            }
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 「入力を確定する」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_Confirm(DBC2210011MainDiv div) {
        List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報
                = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者List, ArrayList.class);
        if (サービス追加モード.equals(div.getHiddenModel())) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            getValidationHandler().特別給付サービス重複チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            getValidationHandler().登録終了日チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
            if (サービス事業者情報 == null) {
                サービス事業者情報 = new ArrayList<>();
            }
            サービス事業者情報.add(getHandler(div).onClick_入力を確定_追加情報());
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(サービス事業者情報));

            dgTokubetsuKyufuJigyoshaDetailServiceList_Row row = new dgTokubetsuKyufuJigyoshaDetailServiceList_Row();
            div.getTokubetsuKyufuJigyoshaDetail().getTokubetsuKyufuJigyoshaDetailServiceList().getDgTokubetsuKyufuJigyoshaDetailServiceList()
                    .getDataSource().add(getHandler(div).onClick_入力を確定_追加(row, getHandler(div).onClick_入力を確定_追加情報()));
        } else if (サービス修正モード.equals(div.getHiddenModel())) {
            TokubetsuKyufuJigyoshaSearchBusiness 修正情報 = getHandler(div).get情報と状態BySelectDataSouce(サービス事業者情報);
            TokubetsuKyufuJigyoshaSearchBusiness 修正後情報 = getHandler(div).onClick_入力を確定_修正情報(修正情報);
            set修正後情報(サービス事業者情報, 修正後情報);
            getHandler(div).setサービス一覧(修正後情報);
            ViewStateHolder.put(ViewStateKeys.市町村特別給付サービス事業者List, new ArrayList(サービス事業者情報));
        }
        return ResponseData.of(div).setState(DBC2210011StateName.事業者詳細入力);
    }

    /**
     * 「入力をやめて戻る」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_DropBack(DBC2210011MainDiv div) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getMessageCode().equals(new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode()))
                && MessageDialogSelectedResult.Yes.equals(ResponseHolder.getButtonType())) {
            return ResponseData.of(div).setState(DBC2210011StateName.事業者詳細入力);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「戻る」ボタンを押下します。
     *
     * @param div 画面情報div
     * @return ResponseData<DBC2210011MainDiv>
     */
    public ResponseData<DBC2210011MainDiv> onClick_Back(DBC2210011MainDiv div) {
        if (照会モード.equals(div.getHiddenModelOne())) {
            return ResponseData.of(div).setState(DBC2210011StateName.事業者詳細照会);
        } else {
            return ResponseData.of(div).setState(DBC2210011StateName.事業者詳細入力);
        }
    }

    private void set修正後情報(List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報, TokubetsuKyufuJigyoshaSearchBusiness 修正後情報) {
        for (int index = 0; index < サービス事業者情報.size(); index++) {
            if (修正後情報.identifier().equals(サービス事業者情報.get(index).identifier())) {
                サービス事業者情報.add(index, 修正後情報);
                サービス事業者情報.remove(index + 1);
                return;
            }
        }
    }

    private DBC2210011MainHandler getHandler(DBC2210011MainDiv div) {
        return new DBC2210011MainHandler(div);
    }

    private DBC2210011MainValidationHandler getValidationHandler() {
        return new DBC2210011MainValidationHandler();
    }

    private void 修正削除の前排他の解除(DBC2210011MainDiv div) {
        if (修正モード.equals(div.getHiddenModelOne()) || 削除モード.equals(div.getHiddenModelOne())) {
            RString 事業者Code = ViewStateHolder.get(ViewStateKeys.市町村特別給付サービス事業者の情報, RString.class);
            getHandler(div).前排他の解除(事業者Code);
        }
    }

    private ResponseData<DBC2210011MainDiv> set事業者コード重複チェック(DBC2210011MainDiv div, ValidationMessageControlPairs pairs) {
        if (追加モード.equals(div.getHiddenModelOne())) {
            getValidationHandler().事業者コード重複チェック(pairs, div);
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        return null;
    }

    private void set情報削除Model(DBC2210011MainDiv div, List<TokubetsuKyufuJigyoshaSearchBusiness> サービス事業者情報) {
        if (削除モード.equals(div.getHiddenModelOne())) {
            for (TokubetsuKyufuJigyoshaSearchBusiness 事業者とサービス : サービス事業者情報) {
                事業者とサービス.get市町村特別給付サービス事業者().get事業者().setLogicalDeletedFlag(true);
                事業者とサービス.get市町村特別給付サービス事業者().get事業者().setState(EntityDataState.Modified);
            }
        }
    }
}
