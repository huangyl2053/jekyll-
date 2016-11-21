/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0200011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.hihokenshajohosoufudatasakuseyi.KokuhorenSofuJohoResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.DBC0200011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.HokenshaSofuListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011.dgHokenshaSofuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200011.HokenshaSofuListPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200011.HokenshaSofuListPanelHandlerValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0200011.KokuhorenDataSofuViewState;
import jp.co.ndensan.reams.db.dbc.service.core.hihokenshajohosoufudatasakuseyi.HihokenshaJohoSoufuDataSakuseyi;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 保険者情報送付データ作成のクラスです。
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class HokenshaSofuListPanel {

    private FlexibleYearMonth 処理年月;
    private static final int 定数_0 = 0;
    private static final int 定数_3 = 3;

    /**
     * 初期化のンメソッドます。
     *
     * @param div HokenshaSofuListPanelDiv
     * @return ResponseData HokenshaSofuListPanelDiv
     */
    public ResponseData<HokenshaSofuListPanelDiv> onLoad(HokenshaSofuListPanelDiv div) {
        処理年月 = getHandler(div).get処理年月();
        div.getTxtShoriNengetsu().setValue(new RDate(処理年月.toDateString().toString()));

        HihokenshaJohoSoufuDataSakuseyi 保険者情報送付 = HihokenshaJohoSoufuDataSakuseyi.createInstance();
        List<KokuhorenSofuJohoResult> resultList = 保険者情報送付.getKokuhorenSofuJoho(処理年月);
        if (!ResponseHolder.isReRequest() && (resultList.isEmpty())) {
            return ResponseData.of(div).addMessage(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).initialize(処理年月, resultList);
        }
        getHandler(div).initialize(処理年月, resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 「表示する」ボタンのメソッドます。
     *
     * @param div HokenshaSofuListPanelDiv
     * @return ResponseData HokenshaSofuListPanelDiv
     */
    public ResponseData<HokenshaSofuListPanelDiv> onClick_btnHyojisuru(HokenshaSofuListPanelDiv div) {
        if (div.getTxtShoriNengetsu().getValue() == null) {
            ValidationMessageControlPairs valid = getValidationHandler(div).validateFor処理年月未入力チェック();
            if (valid.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        処理年月 = new FlexibleYearMonth(div.getTxtShoriNengetsu().getValue().getYearMonth().toDateString());

        HihokenshaJohoSoufuDataSakuseyi 保険者情報送付 = HihokenshaJohoSoufuDataSakuseyi.createInstance();
        List<KokuhorenSofuJohoResult> resultList = 保険者情報送付.getKokuhorenSofuJoho(処理年月);
        if (!ResponseHolder.isReRequest() && (resultList.isEmpty())) {
            return ResponseData.of(div).addMessage(DbcErrorMessages.償還払い費支給申請決定_証明書情報未入力.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).initialize(処理年月, resultList);
        }
        getHandler(div).initialize(処理年月, resultList);
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
        ViewStateHolder.put(ViewStateHolderName.国保連送付情報, parmater);
        RString paramete = row.getKokanShikibetsuNo().substring(定数_0, 定数_3);
        return ResponseData.of(div).forwardWithEventName(DBC0200011TransitionEventName.バッチ起動)
                .parameter(paramete);
    }

    /**
     * スケジュール設定へのメソッドます。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData HokenshaSofuListPanelDiv
     */
    public ResponseData<HokenshaSofuListPanelDiv> onClick_btnScheduleSetting(HokenshaSofuListPanelDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理年月, div.getTxtShoriNengetsu().getValue());
        return ResponseData.of(div).forwardWithEventName(DBC0200011TransitionEventName.スケジュール設定へ).respond();
    }

    private HokenshaSofuListPanelHandler getHandler(HokenshaSofuListPanelDiv div) {
        return new HokenshaSofuListPanelHandler(div);
    }

    private HokenshaSofuListPanelHandlerValidationHandler getValidationHandler(HokenshaSofuListPanelDiv div) {
        return new HokenshaSofuListPanelHandlerValidationHandler(div);
    }
}
