/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.DBC0200011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.HokenshaSofuListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.dgHokenshaSofuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200011.HokenshaSofuListPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200011.HokenshaSofuListPanelHandlerValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 保険者情報送付データ作成
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class HokenshaSofuListPanel {

    private FlexibleYearMonth 処理年月;

    /**
     * 初期化のンメソッドます。
     *
     * @param div HokenshaSofuListPanelDiv
     * @return ResponseData HokenshaSofuListPanelDiv
     */
    public ResponseData<HokenshaSofuListPanelDiv> onLoad(HokenshaSofuListPanelDiv div) {
        処理年月 = getHandler(div).get処理年月();
        div.getTxtShoriNengetsu().setValue(new RDate(処理年月.toDateString().toString()));
        getHandler(div).initialize(処理年月);
        return ResponseData.of(div).respond();
    }

    /**
     *
     * @param div HokenshaSofuListPanelDiv
     * @return ResponseData HokenshaSofuListPanelDiv
     */
    public ResponseData<HokenshaSofuListPanelDiv> onClick_btnHyojisuru(HokenshaSofuListPanelDiv div) {
        処理年月 = new FlexibleYearMonth(div.getTxtShoriNengetsu().getValue().getYearMonth().toDateString());
        getHandler(div).initialize(処理年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 処理年月テキストボックス変更時にリストを更新します。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<HokenshaSofuListPanelDiv> onChange_txtShoriYM(HokenshaSofuListPanelDiv div) {
        if (div.getTxtShoriNengetsu().getValue() == null) {
            ValidationMessageControlPairs valid = getValidationHandler(div).validateFor処理年月未入力チェック();
            if (valid.iterator().hasNext()) {
                div.getBtnHyojisuru().setDisabled(true);
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        処理年月 = new FlexibleYearMonth(div.getTxtShoriNengetsu().getValue().getYearMonth().toDateString());
        getHandler(div).initialize(処理年月);
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」アイコンのメソッドます。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<HokenshaSofuListPanelDiv> onSelect_dgKokuhorenTorikomiList_Row(
            HokenshaSofuListPanelDiv div) {
        RString 再処理区分 = getHandler(div).get再処理区分(div);
        dgHokenshaSofuList_Row row = div.getDgHokenshaSofuList().getClickedItem();
        KokuhorenDataSofuViewState parmater = new KokuhorenDataSofuViewState(
                div.getTxtShoriNengetsu().getValue().getYearMonth(), 再処理区分, row.getKokanShikibetsuNo());
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);
        RString paramete = row.getKokanShikibetsuNo();
        return ResponseData.of(div).forwardWithEventName(DBC0200011TransitionEventName.バッチ起動)
                .parameter(paramete);
    }

    /**
     * 「スケジュール設定」ボタンのメソッドます。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<HokenshaSofuListPanelDiv> onClick_btnScheduleSetting(HokenshaSofuListPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理年月, div.getTxtShoriNengetsu().getValue());
        return ResponseData.of(div).forwardWithEventName(DBC0200011TransitionEventName.スケジュール設定へ).respond();
    }

    /**
     * 保険者情報送付データ作成のHandlerクラスを取得のンメソッドます。
     *
     * @param div YokaigoninteiJigyotaishoRirekiListDiv
     * @return YokaigoninteiJigyotaishoRirekiListHandler
     */
    private HokenshaSofuListPanelHandler getHandler(HokenshaSofuListPanelDiv div) {
        return new HokenshaSofuListPanelHandler(div);
    }

    private HokenshaSofuListPanelHandlerValidationHandler getValidationHandler(HokenshaSofuListPanelDiv div) {
        return new HokenshaSofuListPanelHandlerValidationHandler(div);
    }
}
