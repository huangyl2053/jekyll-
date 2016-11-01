/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.jyutakugaisyunaiyolist;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.JyutakugaisyunaiyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.IAtenaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKangaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「住宅改修内容一覧」のイベントを定義した共有子Divです。
 *
 * @reamsid_L DBC-0940-010 yaodongsheng
 */
public class JyutakugaisyunaiyoList {

    private static final RString モード_追加 = new RString("追加");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_選択 = new RString("選択");
    private static final RString CONMA = new RString(",");

    /**
     * 追加ボタンを押下した際に実行します。
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
     * 削除ボタンを押下した際に実行します。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_DeleteButton(JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv = setPnlNyuryokuArea(モード_削除, requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 選択ボタンを押下した際に実行します。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_SelectButton(JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv = setPnlNyuryokuArea(モード_選択, requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 本人住所をコピーするボタンを押下した際に実行します。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_CopyButton(JyutakugaisyunaiyoListDiv requestDiv) {
        ShikibetsuCode shikibetsuCode = DataPassingConverter.deserialize(
                requestDiv.getJushoData(), ShikibetsuCode.class);
        requestDiv.getTxtJyusyo().setValue(get連結住所(shikibetsuCode));
        requestDiv.getBtnClear().setDisabled(false);
        requestDiv.getBtnDetailConfirm().setDisabled(false);
        requestDiv.getBtnHonnijyusyoCopy().setDisabled(false);
        return ResponseData.of(requestDiv).respond();
    }

    private RString get連結住所(ShikibetsuCode 識別コード) {
        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoService.getShikibetsuTaishoFinder().
                get識別対象(GyomuCode.DB介護保険, 識別コード, KensakuYusenKubun.住登外優先);
        IAtesakiGyomuHanteiKey 業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険);
        IAtenaSearchKey 宛名検索キー = new AtenaSearchKeyBuilder(KensakuYusenKubun.住登外優先, 業務判定キー).set識別コード(識別コード).build();

        JushoEditorBuilder jushobuilder = new JushoEditorBuilder(識別対象.get住所());
        jushobuilder.set管内住所編集パターン(JushoKannaiEditPattern.toValue(宛名検索キー.get住所編集方法().code()));
        jushobuilder.set管外住所編集パターン(JushoKangaiEditPattern.space方書);

        return jushobuilder.build().editJusho().get編集後住所All();
    }

    /**
     * 入力内容をクリアするボタンを押下した際に実行します。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_ClearButton(JyutakugaisyunaiyoListDiv requestDiv) {
        if (モード_追加.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            requestDiv = clear内容(requestDiv);
        } else if (モード_修正.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            set入力内容(requestDiv, requestDiv.getDgGaisyuList().getActiveRow());
        }
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 明細を確定するボタンを押下した際に実行します。
     *
     * @param requestDiv JyutakugaisyunaiyoListDiv
     * @return JyutakugaisyunaiyoListDivのResponseData
     */
    public ResponseData<JyutakugaisyunaiyoListDiv> onClick_ConfirmButton(JyutakugaisyunaiyoListDiv requestDiv) {
        List<dgGaisyuList_Row> list = requestDiv.getDgGaisyuList().getDataSource();
        if ((モード_追加.equals(requestDiv.getPnlNyuryokuArea().getState()) || モード_修正.equals(requestDiv.getPnlNyuryokuArea().getState()))) {
            JyutakugaisyunaiyoListValidationHandler validationHandler = getValidationHandler(requestDiv);
            FlexibleYearMonth サービス年月 = ViewStateHolder.get(ViewStateKeys.住宅改修内容一覧_サービス年月, FlexibleYearMonth.class);
            ValidationMessageControlPairs validPairs = validationHandler.validateFor着工日とサービス年月提供着工年月のチェック(サービス年月);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
            }
        }
        dgGaisyuList_Row dgGaisyuListRow;
        if (モード_追加.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            ValidationMessageControlPairs validPairs = getCheck(requestDiv);
            if (validPairs.iterator().hasNext()) {
                requestDiv.getBtnClear().setDisabled(false);
                requestDiv.getBtnDetailConfirm().setDisabled(false);
                requestDiv.getBtnHonnijyusyoCopy().setDisabled(false);
                return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
            }
            dgGaisyuListRow = new dgGaisyuList_Row();
            dgGaisyuListRow.setTxtJyotai(モード_追加);
            dgGaisyuListRow.setTxtSeiriNo(RString.EMPTY);
            list.add(listRowSet(dgGaisyuListRow, requestDiv));
        } else {
            requestDiv.getDgGaisyuList().getGridSetting().selectedRowCount();
            dgGaisyuListRow = requestDiv.getDgGaisyuList().getSelectedItems().get(0);
            ResponseData<JyutakugaisyunaiyoListDiv> messages = checkMessages(dgGaisyuListRow, requestDiv);
            if (messages != null) {
                return messages;
            }
        }
        clearAll(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    private ResponseData<JyutakugaisyunaiyoListDiv> checkMessages(dgGaisyuList_Row dgGaisyuListRow, JyutakugaisyunaiyoListDiv requestDiv) {
        if (モード_修正.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            ValidationMessageControlPairs validPairs = getCheck(requestDiv);
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(requestDiv).addValidationMessages(validPairs).respond();
            }
            if (!モード_追加.equals(dgGaisyuListRow.getTxtJyotai())) {
                dgGaisyuListRow.setTxtJyotai(モード_修正);
            }
            listRowSet(dgGaisyuListRow, requestDiv);
        } else if (モード_削除.equals(requestDiv.getPnlNyuryokuArea().getState())) {
            if (モード_追加.equals(dgGaisyuListRow.getTxtJyotai())) {
                requestDiv.getDgGaisyuList().getDataSource().remove(dgGaisyuListRow);
            } else {
                dgGaisyuListRow.setTxtJyotai(モード_削除);
            }
        }
        return null;
    }

    private ValidationMessageControlPairs getCheck(JyutakugaisyunaiyoListDiv requestDiv) {
        JyutakugaisyunaiyoListValidationHandler validationHandler = getValidationHandler(requestDiv);
        ValidationMessageControlPairs validPairs = validationHandler.validateFor着工日と完成日の前後順();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        validPairs = validationHandler.validateFor事業者();
        if (validPairs.iterator().hasNext()) {
            return validPairs;
        }
        return validPairs;
    }

    private JyutakugaisyunaiyoListDiv setPnlNyuryokuArea(RString 状態, JyutakugaisyunaiyoListDiv requestDiv) {
        requestDiv.getDgGaisyuList().getGridSetting().selectedRowCount();
        dgGaisyuList_Row dgGaisyuListRow = requestDiv.getDgGaisyuList().getSelectedItems().get(0);
        set入力内容(requestDiv, dgGaisyuListRow);
        if (モード_修正.equals(状態)) {
            requestDiv = clear制御活性(requestDiv);
            requestDiv.getPnlNyuryokuArea().setState(モード_修正);
        }
        if (モード_削除.equals(状態)) {
            requestDiv = clear制御非活性(requestDiv);
            requestDiv.getBtnDetailConfirm().setDisabled(false);
            requestDiv.getPnlNyuryokuArea().setState(モード_削除);
        }
        if (モード_選択.equals(状態)) {
            requestDiv = clear制御非活性(requestDiv);
            requestDiv.getBtnClear().setDisabled(true);
            requestDiv.getBtnHonnijyusyoCopy().setDisabled(true);
            requestDiv.getBtnDetailConfirm().setDisabled(true);
        }
        return requestDiv;
    }

    private JyutakugaisyunaiyoListValidationHandler getValidationHandler(JyutakugaisyunaiyoListDiv div) {
        return new JyutakugaisyunaiyoListValidationHandler(div);
    }

    private void set入力内容(JyutakugaisyunaiyoListDiv requestDiv, dgGaisyuList_Row dgGaisyuListRow) {
        requestDiv.getTxtKaisyunaiyo().setValue(dgGaisyuListRow.getTxtKaishuNaiyo());
        requestDiv.getTxtJigyosya().setValue(dgGaisyuListRow.getTxtJigyosha());
        if (dgGaisyuListRow.getTxtJutakuAddress() != null) {
            requestDiv.getTxtJyusyo().setValue(dgGaisyuListRow.getTxtJutakuAddress());
        }
        if (!RString.isNullOrEmpty(dgGaisyuListRow.getTxtChakkoYoteibi())) {
            requestDiv.getTxtTyakkoyotebi().setValue(new RDate(dgGaisyuListRow.getTxtChakkoYoteibi().toString()));
        }
        if (!RString.isNullOrEmpty(dgGaisyuListRow.getTxtKanseiYoteibi())) {
            requestDiv.getTxtKanseyotebi().setValue(new RDate(dgGaisyuListRow.getTxtKanseiYoteibi().toString()));
        }
        if (!RString.isNullOrEmpty(dgGaisyuListRow.getTxtKaishuKingaku())) {
            requestDiv.getTxtKaisyukingaku().setValue(new Decimal(
                    dgGaisyuListRow.getTxtKaishuKingaku().toString().replaceAll(CONMA.toString(), RString.EMPTY.toString()).trim()));
        }
    }

    private JyutakugaisyunaiyoListDiv clearAll(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setValue(RString.EMPTY);
        div.getTxtKaisyunaiyo().setDisabled(true);
        div.getTxtJigyosya().setValue(RString.EMPTY);
        div.getTxtJigyosya().setDisabled(true);
        div.getBtnHonnijyusyoCopy().setDisabled(true);
        div.getTxtJyusyo().clearValue();
        div.getTxtJyusyo().setDisabled(true);
        div.getTxtTyakkoyotebi().clearValue();
        div.getTxtTyakkoyotebi().setDisabled(true);
        div.getTxtKanseyotebi().clearValue();
        div.getTxtKanseyotebi().setDisabled(true);
        div.getTxtKaisyukingaku().clearValue();
        div.getTxtKaisyukingaku().setDisabled(true);
        div.getBtnClear().setDisabled(true);
        div.getBtnDetailConfirm().setDisabled(true);
        div.getPnlNyuryokuArea().setState(RString.EMPTY);
        return div;
    }

    private JyutakugaisyunaiyoListDiv clear制御非活性(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setDisabled(true);
        div.getTxtJigyosya().setDisabled(true);
        div.getBtnHonnijyusyoCopy().setDisabled(true);
        div.getTxtJyusyo().setDisabled(true);
        div.getTxtTyakkoyotebi().setDisabled(true);
        div.getTxtKanseyotebi().setDisabled(true);
        div.getTxtKaisyukingaku().setDisabled(true);
        div.getBtnClear().setDisabled(true);
        div.getBtnDetailConfirm().setDisabled(true);
        return div;
    }

    private JyutakugaisyunaiyoListDiv clear制御活性(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setDisabled(false);
        div.getTxtKaisyunaiyo().setReadOnly(false);
        div.getTxtJigyosya().setDisabled(false);
        div.getBtnHonnijyusyoCopy().setDisabled(false);
        div.getTxtJyusyo().setDisabled(false);
        div.getTxtJyusyo().setReadOnly(false);
        div.getTxtTyakkoyotebi().setDisabled(false);
        div.getTxtKanseyotebi().setDisabled(false);
        div.getTxtKanseyotebi().setReadOnly(false);
        div.getTxtKaisyukingaku().setDisabled(false);
        div.getTxtKaisyukingaku().setReadOnly(false);
        div.getBtnClear().setDisabled(false);
        div.getBtnDetailConfirm().setDisabled(false);
        return div;
    }

    private JyutakugaisyunaiyoListDiv clear内容(JyutakugaisyunaiyoListDiv div) {
        div.getTxtKaisyunaiyo().setValue(RString.EMPTY);
        div.getTxtJigyosya().setValue(RString.EMPTY);
        div.getTxtJyusyo().clearValue();
        div.getTxtTyakkoyotebi().clearValue();
        div.getTxtKanseyotebi().clearValue();
        div.getTxtKaisyukingaku().clearValue();
        return div;
    }

    private dgGaisyuList_Row listRowSet(dgGaisyuList_Row dgGaisyuListRow, JyutakugaisyunaiyoListDiv requestDiv) {
        dgGaisyuListRow.setTxtJutakuAddress(requestDiv.getTxtJyusyo().getValue());
        dgGaisyuListRow.setTxtKaishuNaiyo(new RString(requestDiv.getTxtKaisyunaiyo().getValue().toString()));
        if (requestDiv.getTxtTyakkoyotebi().getValue() == null) {
            dgGaisyuListRow.setTxtChakkoYoteibi(RString.EMPTY);
        } else {
            dgGaisyuListRow.setTxtChakkoYoteibi(requestDiv.getTxtTyakkoyotebi().getValue().wareki().toDateString());
        }
        if (requestDiv.getTxtKanseyotebi().getValue() == null) {
            dgGaisyuListRow.setTxtKanseiYoteibi(RString.EMPTY);
        } else {
            dgGaisyuListRow.setTxtKanseiYoteibi(requestDiv.getTxtKanseyotebi().getValue().wareki().toDateString());
        }
        if (requestDiv.getTxtKaisyukingaku().getValue() == null) {
            dgGaisyuListRow.setTxtKaishuKingaku(RString.EMPTY);
        } else {
            dgGaisyuListRow.setTxtKaishuKingaku(DecimalFormatter.toコンマ区切りRString(requestDiv.getTxtKaisyukingaku().getValue(), 0));
        }
        dgGaisyuListRow.setTxtJigyosha(requestDiv.getTxtJigyosya().getValue());
        return dgGaisyuListRow;
    }
}
