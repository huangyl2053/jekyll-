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
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.shokanshinseilisthandler.ShokanShinseiValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshinseiichiran.ShokanShinseiIchiranManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「償還払申請一覧」のイベントを定義した共有子Divです。
 *
 * @reamsid_L DBC-0960-010 hezhenzhen
 *
 */
public class ShokanShinseiList {

    private static final RString 追加モード = new RString("追加");
    private static final RString 選択モード = new RString("選択");
    private static final RString 修正モード = new RString("修正");
    private static final RString 削除モード = new RString("削除");
    private static final RString 照会 = new RString("照会");

    private ShokanShinseiValidationHandler createValidationHandler(ShokanShinseiListDiv div) {
        return new ShokanShinseiValidationHandler(div);
    }

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
            requestDiv.getTxtServiceYMFrom().setValue(new RDate(サービス年月From.toDateString().toString()));
            requestDiv.getTxtServiceYMTo().setValue(new RDate(サービス年月To.toDateString().toString()));
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
        ShokanShinseiValidationHandler validationHandler = createValidationHandler(requestDiv);
        ValidationMessageControlPairs validationMessages = validationHandler.サービス年月の有効性チェック(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class));
        if (validationMessages.iterator().hasNext() && !ResponseHolder.isWarningIgnoredRequest()) {
            return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(requestDiv).addMessage(UrQuestionMessages.処理実行の確認.getMessage()).respond();
        }

        ViewStateHolder.put(ViewStateKeys.サービス年月, requestDiv.getTxtServiceYM().getValue().getYearMonth().toDateString());
        ViewStateHolder.put(ViewStateKeys.サービス年月From, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.サービス年月To, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.モード, 追加モード);
        ViewStateHolder.put(ViewStateKeys.整理番号, RString.EMPTY);
        ViewStateHolder.put(ViewStateKeys.様式番号, RString.EMPTY);

        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 検索ボタン押押下です。
     *
     * @param requestDiv ShokanShinseiListDiv
     * @return ShokanShinseiListDivのResponseData
     */
    public ResponseData<ShokanShinseiListDiv> onSelectByDbClick(ShokanShinseiListDiv requestDiv) {
        ShokanShinseiValidationHandler validationHandler = createValidationHandler(requestDiv);
        ValidationMessageControlPairs validationMessages = validationHandler.検索ボタンcheck();
        if (validationMessages.iterator().hasNext()) {
            return ResponseData.of(requestDiv).addValidationMessages(validationMessages).respond();
        }

        RString mode = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
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
                    createInstance().getShokanShinseiListSyokai(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                            serviceYMFrom,
                            serviceYMTo);
        } else {
            shokandhinseiichiran = ShokanShinseiIchiranManager.
                    createInstance().getShokanShinseiListShinsei(ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class),
                            serviceYMFrom,
                            serviceYMTo);
        }
        if (!ResponseHolder.isReRequest() && (shokandhinseiichiran == null || shokandhinseiichiran.records().isEmpty())) {
            return ResponseData.of(requestDiv).addMessage(UrErrorMessages.該当データなし.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(requestDiv).initialize(mode, shokandhinseiichiran);
        }
        getHandler(requestDiv).initialize(mode, shokandhinseiichiran);

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

    private void get選択ボタンcheck(ShokanShinseiListDiv requestDiv) {

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
        ViewStateHolder.put(ViewStateKeys.サービス年月From, serviceYMFrom);
        ViewStateHolder.put(ViewStateKeys.サービス年月To, serviceYMTo);
        ViewStateHolder.put(ViewStateKeys.モード, 選択モード);
        ViewStateHolder.put(ViewStateKeys.サービス年月, dgShinseiList.getServiceTeikyoYM());
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(dgShinseiList.getHiHokenshaNo()));
        ViewStateHolder.put(ViewStateKeys.整理番号, dgShinseiList.getSeiriNo());
        ViewStateHolder.put(ViewStateKeys.様式番号, dgShinseiList.getYoshikiNo());
        ViewStateHolder.put(ViewStateKeys.決定日, dgShinseiList.getKetteiYMD());
        ViewStateHolder.put(ViewStateKeys.申請日, dgShinseiList.getShinseiYMD());
        ViewStateHolder.put(ViewStateKeys.事業者番号, new JigyoshaNo(dgShinseiList.getJigyoshaNo()));
        ViewStateHolder.put(ViewStateKeys.明細番号, dgShinseiList.getMeisaiNo());
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
            ViewStateHolder.put(ViewStateKeys.サービス年月From, serviceYMFrom);
            ViewStateHolder.put(ViewStateKeys.サービス年月To, serviceYMTo);
            ViewStateHolder.put(ViewStateKeys.モード, 修正モード);
            ViewStateHolder.put(ViewStateKeys.サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(dgShinseiList.getHiHokenshaNo()));
            ViewStateHolder.put(ViewStateKeys.整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.様式番号, dgShinseiList.getYoshikiNo());
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
            ViewStateHolder.put(ViewStateKeys.サービス年月From, serviceYMFrom);
            ViewStateHolder.put(ViewStateKeys.サービス年月To, serviceYMTo);
            ViewStateHolder.put(ViewStateKeys.モード, 削除モード);
            ViewStateHolder.put(ViewStateKeys.サービス年月, dgShinseiList.getServiceTeikyoYM());
            ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(dgShinseiList.getHiHokenshaNo()));
            ViewStateHolder.put(ViewStateKeys.整理番号, dgShinseiList.getSeiriNo());
            ViewStateHolder.put(ViewStateKeys.様式番号, dgShinseiList.getYoshikiNo());
        }
    }

}
