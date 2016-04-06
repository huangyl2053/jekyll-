/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.ShokanShinseiList;

import jp.co.ndensan.reams.db.dbc.business.core.shokanshinseiichiran.ShokanShinseiIchiran;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList.ShokanShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList.dgShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.shokanshinseilisthandler.ShokanShinseiHandler;
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
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「償還払申請一覧」のイベントを定義した共有子Divです。
 *
 */
public class ShokanShinseiList {

    private static final RString 追加モード = new RString("追加");
    private static final RString 選択モード = new RString("選択");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 照会 = new RString("照会");

    /**
     * 償還払申請一覧の初期化。<br/>
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ResponseData<ShokanShinseiListDiv>
     */
    public ResponseData<ShokanShinseiListDiv> onLoad(ShokanShinseiListDiv requestDiv) {
        RString モード = requestDiv.getモード();
        HihokenshaNo 被保険者番号 = DataPassingConverter.deserialize(requestDiv.get被保険者番号(), HihokenshaNo.class);
        FlexibleYearMonth サービス年月From = DataPassingConverter.deserialize(requestDiv.getサービス年月From(), FlexibleYearMonth.class);
        FlexibleYearMonth サービス年月To = DataPassingConverter.deserialize(requestDiv.getサービス年月To(), FlexibleYearMonth.class);

        ResponseData<ShokanShinseiListDiv> responseData = new ResponseData<>();
        if (!RString.isNullOrEmpty(モード) && 被保険者番号 != null
                && サービス年月From != null && サービス年月To != null) {
            requestDiv.initialize(モード, 被保険者番号, サービス年月From, サービス年月To);

        }
        responseData.data = requestDiv;

        return responseData;
    }

    /**
     * 「申請を追加する」ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ShokanShinseiListDivのResponseData
     */
    public ResponseData<ShokanShinseiListDiv> onClick_InsertButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        get申請を追加するcheck(requestDiv);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, requestDiv.getTxtServiceYM().getValue().getYearMonth());
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 追加モード);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, RString.EMPTY);

        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 検索ボタン押押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ShokanShinseiListDivのResponseData
     */
    public ResponseData<ShokanShinseiListDiv> onSelectByDbClick(ShokanShinseiListDiv requestDiv) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            get検索ボタンcheck(requestDiv);
            RString mode = ViewStateHolder.get(ViewStateKeys.償還払申請一覧_モード, RString.class);
            SearchResult<ShokanShinseiIchiran> shokandhinseiichiran;
            FlexibleYearMonth serviceYMFrom = null;
            if (requestDiv.getTxtServiceYMFrom().getValue() != null) {
                serviceYMFrom = new FlexibleYearMonth(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().toDateString());
            }
            FlexibleYearMonth serviceYMTo = null;
            if (requestDiv.getTxtServiceYMTo().getValue() != null) {
                serviceYMTo = new FlexibleYearMonth(requestDiv.getTxtServiceYMTo().getValue().getYearMonth().toDateString());
            }
            if (照会.equals(mode)) {
                shokandhinseiichiran = ShokanShinseiIchiranManager.
                        createInstance().getShokanShinseiListSyokai(ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号, HihokenshaNo.class),
                                serviceYMFrom,
                                serviceYMTo);
            } else {
                shokandhinseiichiran = ShokanShinseiIchiranManager.
                        createInstance().getShokanShinseiListShinsei(ViewStateHolder.get(ViewStateKeys.償還払申請一覧_被保険者番号, HihokenshaNo.class),
                                serviceYMFrom,
                                serviceYMTo);
            }

            getHandler(requestDiv).initialize(mode, shokandhinseiichiran);
        }

        return ResponseData.of(requestDiv)
                .respond();
    }

    /**
     * 選択ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ShokanShinseiListDivのResponseData
     */
    public ResponseData<ShokanShinseiListDiv> onClick_SelectButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        get選択ボタンcheck(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 修正ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ShokanShinseiListDivのResponseData
     */
    public ResponseData<ShokanShinseiListDiv> onClick_ModifyButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }
        get修正ボタンcheck(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 削除ボタン押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ShokanShinseiListDivのResponseData
     */
    public ResponseData<ShokanShinseiListDiv> onClick_DeleteButton(ShokanShinseiListDiv requestDiv) {

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        get削除ボタンcheck(requestDiv);
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
                            HihokenshaNo.class
                    ), new FlexibleYearMonth(
                            requestDiv.getTxtServiceYM().getValue().getYearMonth().toDateString()));
            if (count
                    > 1) {
                throw new ApplicationException(
                        UrErrorMessages.既に登録済.getMessage().replace(
                                requestDiv.getTxtServiceYM().getValue().getYearMonth().toString()));
            }
        }
    }

    private void get検索ボタンcheck(ShokanShinseiListDiv requestDiv) {

        if (requestDiv.getTxtServiceYMFrom().getValue() == null && requestDiv.getTxtServiceYMTo().getValue() == null) {
            throw new ApplicationException(
                    UrErrorMessages.期間が不正.getMessage());
        }
        if ((requestDiv.getTxtServiceYMFrom().getValue() != null && !RString.EMPTY.equals(requestDiv.getTxtServiceYMFrom().getValue().toDateString()))
                && (requestDiv.getTxtServiceYMTo().getValue() != null && !RString.EMPTY.equals(requestDiv.getTxtServiceYMTo().getValue().toDateString()))) {
            if (requestDiv.getTxtServiceYMTo().getValue().getYearMonth().isBefore(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth())) {
                throw new ApplicationException(
                        UrErrorMessages.期間が不正_追加メッセージあり２.getMessage().replace(
                                requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().toString(),
                                requestDiv.getTxtServiceYMTo().getValue().getYearMonth().toString()));
            }
        }
    }

    private void get選択ボタンcheck(ShokanShinseiListDiv requestDiv) {
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            requestDiv.getDgShinseiList().getGridSetting().selectedRowCount();
            dgShinseiList_Row dgShinseiList = requestDiv.getDgShinseiList().getSelectedItems().get(0);
            FlexibleYearMonth serviceYMFrom = FlexibleYearMonth.EMPTY;
            if (requestDiv.getTxtServiceYMFrom().getValue() != null) {
                serviceYMFrom = new FlexibleYearMonth(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().toDateString());
            }
            FlexibleYearMonth serviceYMTo = FlexibleYearMonth.EMPTY;
            if (requestDiv.getTxtServiceYMTo().getValue() != null) {
                serviceYMTo = new FlexibleYearMonth(requestDiv.getTxtServiceYMTo().getValue().getYearMonth().toDateString());
            }
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, serviceYMFrom);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, serviceYMTo);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 選択モード);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, new HihokenshaNo(dgShinseiList.getHiHokenshaNo()));
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, dgShinseiList.getYoshikiNo());
        }
    }

    private void get修正ボタンcheck(ShokanShinseiListDiv requestDiv) {
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            requestDiv.getDgShinseiList().getGridSetting().selectedRowCount();
            dgShinseiList_Row dgShinseiList = requestDiv.getDgShinseiList().getSelectedItems().get(0);
            FlexibleYearMonth serviceYMFrom = FlexibleYearMonth.EMPTY;
            if (requestDiv.getTxtServiceYMFrom().getValue() != null) {
                serviceYMFrom = new FlexibleYearMonth(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().toDateString());
            }
            FlexibleYearMonth serviceYMTo = FlexibleYearMonth.EMPTY;
            if (requestDiv.getTxtServiceYMTo().getValue() != null) {
                serviceYMTo = new FlexibleYearMonth(requestDiv.getTxtServiceYMTo().getValue().getYearMonth().toDateString());
            }
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, serviceYMFrom);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, serviceYMTo);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 修正モード);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, new HihokenshaNo(dgShinseiList.getHiHokenshaNo()));
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, dgShinseiList.getYoshikiNo());
        }
    }

    private void get削除ボタンcheck(ShokanShinseiListDiv requestDiv) {
        if (new RString(UrQuestionMessages.処理実行の確認.getMessage().getCode()).equals(
                ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            requestDiv.getDgShinseiList().getGridSetting().selectedRowCount();
            dgShinseiList_Row dgShinseiList = requestDiv.getDgShinseiList().getSelectedItems().get(0);
            FlexibleYearMonth serviceYMFrom = FlexibleYearMonth.EMPTY;
            if (requestDiv.getTxtServiceYMFrom().getValue() != null) {
                serviceYMFrom = new FlexibleYearMonth(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().toDateString());
            }
            FlexibleYearMonth serviceYMTo = FlexibleYearMonth.EMPTY;
            if (requestDiv.getTxtServiceYMTo().getValue() != null) {
                serviceYMTo = new FlexibleYearMonth(requestDiv.getTxtServiceYMTo().getValue().getYearMonth().toDateString());
            }
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月From, serviceYMFrom);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月To, serviceYMTo);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_モード, 削除モード);
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_被保険者番号, new HihokenshaNo(dgShinseiList.getHiHokenshaNo()));
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.償還払申請一覧_様式番号, dgShinseiList.getYoshikiNo());
        }
    }

}
