/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.jyutakugaisyunaiyolist;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu.ShokanJutakuKaishuBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.jyutakukaisyuyichiran.JyutakukaisyuyichiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 *
 * 共有子Div「住宅改修内容一覧」のイベントを定義した共有子Divです。
 */
public class JyutakugaisyunaiyoList {

    private static final RString モード_追加 = new RString("登録");
    private static final RString モード_修正 = new RString("更新");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_選択 = new RString("選択");

    /**
     * onLoadです。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onLoad(JyutakugaisyunaiyoListDiv requestDiv) {
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_サービス提供年月, FlexibleYearMonth.class);
        RString 整理番号 = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_整理番号, RString.class);
        RString 様式番号 = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_様式番号, RString.class);
        RString mode = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_モード, RString.class);
        SearchResult<ShokanJutakuKaishuBusiness> jyutakukaisyuList = JyutakukaisyuyichiranFinder
                .createInstance().selectJyutakukaisyuList(被保険者番号, サービス提供年月, 整理番号, 様式番号);
        getHandler(requestDiv).initialize(mode, jyutakukaisyuList);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 追加ボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_InsertButton(JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv.getPnlNyuryokuArea().setState(モード_追加);
        requestDiv = clear制御活性(requestDiv);
        requestDiv = clear内容(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 修正ボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_ModifyButton(JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv = setPnlNyuryokuArea(モード_修正, requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 削除ボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_DeleteButton(JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv = setPnlNyuryokuArea(モード_削除, requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 選択ボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_SelectButton(JyutakugaisyunaiyoListDiv requestDiv) {

        requestDiv = setPnlNyuryokuArea(モード_選択, requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 本人住所をコピーするボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_CopyButton(JyutakugaisyunaiyoListDiv requestDiv) {
        // TODOQA516 親画面はどの画面ですが。
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 入力内容をクリアするボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_ClearButton(JyutakugaisyunaiyoListDiv requestDiv) {
        if (モード_修正.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            setPnlNyuryokuArea(モード_修正, requestDiv);
        } else {
            requestDiv = clear内容(requestDiv);
        }
        requestDiv = clear制御非活性(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 明細を確定するボタン押下です。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_ConfirmButton(JyutakugaisyunaiyoListDiv requestDiv) {
        List<dgGaisyuList_Row> list = requestDiv.getDgGaisyuList().getDataSource();
        dgGaisyuList_Row dgGaisyuListRow;
        JyutakugaisyunaiyoListValidationHandler ValidationHandler = getValidationHandler(requestDiv);
        if (モード_追加.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            ValidationMessageControlPairs validPairs = ValidationHandler.validateFor着工日と完成日の前後順();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
            }
            validPairs = ValidationHandler.validateFor事業者();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
            }
            dgGaisyuListRow = new dgGaisyuList_Row();
            dgGaisyuListRow.setTxtJyotai(モード_追加);
            dgGaisyuListRow.setTxtSeiriNo(RString.EMPTY);

            list.add(listRowSet(dgGaisyuListRow, requestDiv));
        } else {
            requestDiv.getDgGaisyuList().getGridSetting().selectedRowCount();
            dgGaisyuListRow = requestDiv.getDgGaisyuList().getSelectedItems().get(0);
            int count = list.indexOf(dgGaisyuListRow);
            if (モード_修正.equals(requestDiv.getPnlNyuryokuArea().getState())) {
                ValidationMessageControlPairs validPairs = ValidationHandler.validateFor着工日と完成日の前後順();
                if (validPairs.iterator().hasNext()) {
                    return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
                }
                validPairs = ValidationHandler.validateFor事業者();
                if (validPairs.iterator().hasNext()) {
                    return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
                }
                dgGaisyuListRow.setTxtJyotai(モード_修正);
                listRowSet(dgGaisyuListRow, requestDiv);
            } else if (モード_削除.equals(requestDiv.getPnlNyuryokuArea().getState())) {
                dgGaisyuListRow.setTxtJyotai(モード_削除);
            }
            list.set(count, dgGaisyuListRow);
        }
        clearAll(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    private JyutakugaisyunaiyoListDiv setPnlNyuryokuArea(RString 状態, JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv.getDgGaisyuList().getGridSetting().selectedRowCount();
        dgGaisyuList_Row dgGaisyuListRow = requestDiv.getDgGaisyuList().getSelectedItems().get(0);
        requestDiv.getTxtKaisyunaiyo().setValue(dgGaisyuListRow.getTxtKaishuNaiyo());
        requestDiv.getTxtJigyosya().setValue(dgGaisyuListRow.getTxtJigyosha());
        if (dgGaisyuListRow.getTxtJutakuAddress() != null) {
            AtenaJusho domain = new AtenaJusho(dgGaisyuListRow.getTxtJutakuAddress());
            requestDiv.getTxtJyusyo().setDomain(domain);
        }
        if (dgGaisyuListRow.getTxtChakkoYoteibi() != null) {
            requestDiv.getTxtTyakkoyotebi().setValue(new RDate(dgGaisyuListRow.getTxtChakkoYoteibi().toString()));
        }
        if (dgGaisyuListRow.getTxtKanseiYoteibi() != null) {
            requestDiv.getTxtKanseyotebi().setValue(new RDate(dgGaisyuListRow.getTxtKanseiYoteibi().toString()));
        }
        if (dgGaisyuListRow.getTxtKaishuKingaku() != null && !dgGaisyuListRow.getTxtKaishuKingaku().isEmpty()) {
            requestDiv.getTxtKaisyukingaku().setValue(new Decimal(dgGaisyuListRow.getTxtKaishuKingaku().toString().trim()));
        }
        if (モード_修正.equals(状態)) {
            requestDiv = clear制御活性(requestDiv);
            requestDiv.getPnlNyuryokuArea().setState(モード_修正);
        }
        if (モード_削除.equals(状態)) {
            requestDiv = clear制御活性(requestDiv);
            requestDiv.getBtnClear().setDisabled(true);
            requestDiv.getBtnHonnijyusyoCopy().setDisabled(true);
            requestDiv.getPnlNyuryokuArea().setState(モード_削除);
        }
        if (モード_選択.equals(状態)) {
            requestDiv = clear制御活性(requestDiv);
            requestDiv.getBtnClear().setDisabled(true);
            requestDiv.getBtnHonnijyusyoCopy().setDisabled(true);
            requestDiv.getBtnDetailConfirm().setDisabled(true);
        }
        return requestDiv;
    }

    private JyutakugaisyunaiyoListHandler getHandler(JyutakugaisyunaiyoListDiv requestDiv) {
        return new JyutakugaisyunaiyoListHandler(requestDiv);
    }

    private JyutakugaisyunaiyoListValidationHandler getValidationHandler(JyutakugaisyunaiyoListDiv div) {
        return new JyutakugaisyunaiyoListValidationHandler(div);
    }

    private JyutakugaisyunaiyoListDiv clearAll(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setValue(RString.EMPTY);
        div.getTxtKaisyunaiyo().setReadOnly(true);
        div.getTxtJigyosya().setValue(RString.EMPTY);
        div.getTxtJigyosya().setReadOnly(true);
        div.getBtnHonnijyusyoCopy().setDisabled(true);
        div.getTxtJyusyo().clearDomain();
        div.getTxtJyusyo().setReadOnly(true);
        div.getTxtTyakkoyotebi().clearValue();
        div.getTxtTyakkoyotebi().setReadOnly(true);
        div.getTxtKanseyotebi().clearValue();
        div.getTxtKanseyotebi().setReadOnly(true);
        div.getTxtKaisyukingaku().clearValue();
        div.getTxtKaisyukingaku().setReadOnly(true);
        div.getBtnClear().setDisabled(true);
        div.getBtnDetailConfirm().setDisabled(true);
        div.getPnlNyuryokuArea().setState(RString.EMPTY);
        return div;
    }

    private JyutakugaisyunaiyoListDiv clear制御非活性(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setReadOnly(true);
        div.getTxtJigyosya().setReadOnly(true);
        div.getBtnHonnijyusyoCopy().setDisabled(true);
        div.getTxtJyusyo().setReadOnly(true);
        div.getTxtTyakkoyotebi().setReadOnly(true);
        div.getTxtKanseyotebi().setReadOnly(true);
        div.getTxtKaisyukingaku().setReadOnly(true);
        div.getBtnClear().setDisabled(true);
        div.getBtnDetailConfirm().setDisabled(true);
        return div;
    }

    private JyutakugaisyunaiyoListDiv clear制御活性(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setReadOnly(false);
        div.getTxtJigyosya().setReadOnly(false);
        div.getBtnHonnijyusyoCopy().setDisabled(false);
        div.getTxtJyusyo().setReadOnly(false);
        div.getTxtTyakkoyotebi().setReadOnly(false);
        div.getTxtKanseyotebi().setReadOnly(false);
        div.getTxtKaisyukingaku().setReadOnly(false);
        div.getBtnClear().setDisabled(false);
        div.getBtnDetailConfirm().setDisabled(false);
        return div;
    }

    private JyutakugaisyunaiyoListDiv clear内容(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setValue(RString.EMPTY);
        div.getTxtJigyosya().setValue(RString.EMPTY);
        div.getTxtJyusyo().clearDomain();
        div.getTxtTyakkoyotebi().clearValue();
        div.getTxtKanseyotebi().clearValue();
        div.getTxtKaisyukingaku().clearValue();
        return div;
    }

    private dgGaisyuList_Row listRowSet(dgGaisyuList_Row dgGaisyuListRow, JyutakugaisyunaiyoListDiv requestDiv) {
        dgGaisyuListRow.setTxtJutakuAddress(requestDiv.getTxtJyusyo().getDomain().getColumnValue());
        dgGaisyuListRow.setTxtKaishuNaiyo(new RString(requestDiv.getTxtKaisyunaiyo().getValue().toString()));
        if (requestDiv.getTxtTyakkoyotebi().getValue() == null) {
            dgGaisyuListRow.setTxtChakkoYoteibi(RString.EMPTY);
        } else {
            dgGaisyuListRow.setTxtChakkoYoteibi(new RString(requestDiv.getTxtTyakkoyotebi().getValue().toString()));
        }
        if (requestDiv.getTxtKanseyotebi().getValue() == null) {
            dgGaisyuListRow.setTxtKanseiYoteibi(RString.EMPTY);
        } else {
            dgGaisyuListRow.setTxtKanseiYoteibi(new RString(requestDiv.getTxtKanseyotebi().getValue().toString()));
        }
        if (requestDiv.getTxtKaisyukingaku().getValue() == null) {
            dgGaisyuListRow.setTxtKaishuKingaku(RString.EMPTY);
        } else {
            dgGaisyuListRow.setTxtKaishuKingaku(new RString(requestDiv.getTxtKaisyukingaku().getValue().toString()));
        }
        dgGaisyuListRow.setTxtJigyosha(requestDiv.getTxtJigyosya().getValue());
        return dgGaisyuListRow;
    }
}
