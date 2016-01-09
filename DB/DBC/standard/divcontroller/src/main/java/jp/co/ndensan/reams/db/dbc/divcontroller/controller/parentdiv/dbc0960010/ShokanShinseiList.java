/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0960010;

import jp.co.ndensan.reams.db.dbc.business.core.shokanshinseiichiran.ShokanShinseiIchiran;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0960010.ShokanShinseiHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshinseiichiran.ShokanShinseiIchiranManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 共有子Div「償還払申請一覧」のイベントを定義した共有子Divです。
 *
 *
 */
public class ShokanShinseiList {

    private static final RString 追加モード = new RString("追加");
    private static final RString 選択モード = new RString("選択");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final int 桁数_6 = 6;
    private HihokenshaNo 償還払申請一覧_被保険者番号;
    private FlexibleYearMonth 償還払申請一覧_サービス年月From;
    private FlexibleYearMonth 償還払申請一覧_サービス年月To;

    public ResponseData<ShokanShinseiListDiv> onLoad(ShokanShinseiListDiv requestdiv) {
        償還払申請一覧_被保険者番号 = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号, HihokenshaNo.class);
        償還払申請一覧_サービス年月From = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_サービス年月From, FlexibleYearMonth.class);
        償還払申請一覧_サービス年月To = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_サービス年月To, FlexibleYearMonth.class);

        SearchResult<ShokanShinseiIchiran> shokandhinseiichiran = ShokanShinseiIchiranManager.
                createInstance().getShokanShinseiListSyokai(償還払申請一覧_被保険者番号,
                        償還払申請一覧_サービス年月From,
                        償還払申請一覧_サービス年月To);
        RString mode = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_モード, RString.class);
        getHandler(requestdiv).initialize(mode, shokandhinseiichiran);
        return ResponseData.of(requestdiv).respond();

    }

    /**
     * 「申請を追加する」ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ResponseData<ShokanShinseiListDiv>
     */
    public ResponseData<ShokanShinseiListDiv> onClick_InsertButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        get申請を追加するcheck(requestDiv);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, requestDiv.getTxtServiceYM().getValue());
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 追加モード);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, 償還払申請一覧_被保険者番号);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, RString.EMPTY);

        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 検索ボタン押押下です。
     *
     * @param requestDiv　ShokanShinseiListDiv
     * @return ResponseData<ShokanShinseiListDiv>
     */
    public ResponseData<ShokanShinseiListDiv> onSelectByDbClick(ShokanShinseiListDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        get検索ボタンcheck(requestDiv);
        SearchResult<ShokanShinseiIchiran> shokandhinseiichiran = ShokanShinseiIchiranManager.
                createInstance().getShokanShinseiListShinsei(ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号, HihokenshaNo.class),
                        new FlexibleYearMonth(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().toDateString()),
                        new FlexibleYearMonth(requestDiv.getTxtServiceYMTo().getValue().getYearMonth().toDateString()));
        RString mode = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_モード, RString.class);
        getHandler(requestDiv).initialize(mode, shokandhinseiichiran);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 選択ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ResponseData<ShokanShinseiListDiv>
     */
    public ResponseData<ShokanShinseiListDiv> onClick_SelectButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            requestDiv.getDgShinseiList().getGridSetting().selectedRowCount();
            dgShinseiList_Row dgShinseiList = requestDiv.getDgShinseiList().getSelectedItems().get(0);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, requestDiv.getTxtServiceYMFrom().getValue().getYearMonth());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, requestDiv.getTxtServiceYMTo().getValue().getYearMonth());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 選択モード);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, dgShinseiList.getHiHokenshaNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, dgShinseiList.getYoshikiNo());
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 修正ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ResponseData<ShokanShinseiListDiv>
     */
    public ResponseData<ShokanShinseiListDiv> onClick_ModifyButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            requestDiv.getDgShinseiList().getGridSetting().selectedRowCount();
            dgShinseiList_Row dgShinseiList = requestDiv.getDgShinseiList().getSelectedItems().get(0);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, requestDiv.getTxtServiceYMFrom().getValue().getYearMonth());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, requestDiv.getTxtServiceYMTo().getValue().getYearMonth());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 修正モード);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, dgShinseiList.getHiHokenshaNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, dgShinseiList.getYoshikiNo());
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 削除ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ResponseData<ShokanShinseiListDiv>
     */
    public ResponseData<ShokanShinseiListDiv> onClick_DeleteButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            requestDiv.getDgShinseiList().getGridSetting().selectedRowCount();
            dgShinseiList_Row dgShinseiList = requestDiv.getDgShinseiList().getSelectedItems().get(0);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, requestDiv.getTxtServiceYMFrom().getValue().getYearMonth());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, requestDiv.getTxtServiceYMTo().getValue().getYearMonth());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 削除モード);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, dgShinseiList.getHiHokenshaNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, dgShinseiList.getYoshikiNo());
        }
        return ResponseData.of(requestDiv).respond();
    }

    private ShokanShinseiHandler getHandler(ShokanShinseiListDiv requestdiv) {
        return new ShokanShinseiHandler(requestdiv);
    }

    private void get申請を追加するcheck(ShokanShinseiListDiv requestDiv) {
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            if (RDate.getNowDate().getYearMonth().isBefore(requestDiv.getTxtServiceYM().getValue().getYearMonth())) {
                throw new ApplicationException(
                        UrWarningMessages.日付の前後関係逆転以降.getMessage().replace(
                                requestDiv.getTxtServiceYM().getValue().getYearMonth().toString(), RDate.getNowDate().getYearMonth().toString()));
            }
            int count = ShokanShinseiIchiranManager.createInstance().getShokanShinseiCount(
                    ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号,
                            HihokenshaNo.class), new FlexibleYearMonth(
                            requestDiv.getTxtServiceYM().getValue().getYearMonth().toDateString()));
            if (count > 1) {
                throw new ApplicationException(
                        UrErrorMessages.既に登録済.getMessage().replace(
                                requestDiv.getTxtServiceYM().getValue().getYearMonth().toString()));
            }
        }
    }

    private void get検索ボタンcheck(ShokanShinseiListDiv requestDiv) {
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            if (requestDiv.getTxtServiceYMFrom().getValue().getYearMonth() == null && requestDiv.getTxtServiceYMTo().getValue().getYearMonth() == null) {
                throw new ApplicationException(
                        UrErrorMessages.期間が不正.getMessage());
            }
            if (requestDiv.getTxtServiceYMFrom().getValue().getYearMonth() != null && requestDiv.getTxtServiceYMTo().getValue().getYearMonth() != null) {
                if (requestDiv.getTxtServiceYMTo().getValue().getYearMonth().isBefore(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth())) {
                    throw new ApplicationException(
                            UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace(
                                    requestDiv.getTxtServiceYMFrom().getValue().toString(), requestDiv.getTxtServiceYMTo().getValue().toString()));
                }
            }
        }
    }
}
