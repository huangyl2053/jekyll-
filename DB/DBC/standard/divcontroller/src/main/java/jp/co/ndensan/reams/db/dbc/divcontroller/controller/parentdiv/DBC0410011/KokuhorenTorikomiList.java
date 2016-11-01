/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0410011;

import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.DBC0410011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0410011.KokuhorenTorikomiListHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0410011.KokuhorenTorikomiListValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbc.service.core.basic.IryoHokenRirekiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.viewstatename.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報データ取込のクラスです。
 *
 * @reamsid_L DBC-0980-460 wangkanglei
 */
public class KokuhorenTorikomiList {

    private static final RString 再処理可能 = new RString("再処理可能");
    private static final RString 再処理不可 = new RString("再処理不可");
    private static final int NUM_0 = 0;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;

    /**
     * 初期化のメソッドます。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return response
     */
    public ResponseData<KokuhorenTorikomiListDiv> onLoad(KokuhorenTorikomiListDiv div) {

        FlexibleYearMonth max処理年月 = IryoHokenRirekiManager.createInstance().getMaxShoriYearMonth();
        if (max処理年月 == null) {
            max処理年月 = new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toDateString());
        }
        div.getTxtShoriYM().setValue(new RDate(max処理年月.getYearValue(), max処理年月.getMonthValue()));
        getHandler(div).load(new RYearMonth(max処理年月.toDateString()));
        return ResponseData.of(div).respond();
    }

    /**
     * 処理年月テキストボックス変更時にリストを更新します。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<KokuhorenTorikomiListDiv> onChange_txtShoriYM(KokuhorenTorikomiListDiv div) {
        if (div.getTxtShoriYM().getValue() == null) {
            ValidationMessageControlPairs valid = getValidationHandler(div).validateFor処理年月未入力チェック();
            if (valid.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(valid).respond();
            }
        }
        getHandler(div).load(div.getTxtShoriYM().getValue().getYearMonth());
        return ResponseData.of(div).respond();
    }

    /**
     * 「選択」アイコンのメソッドます。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<KokuhorenTorikomiListDiv> onSelect_dgKokuhorenTorikomiList_Row(
            KokuhorenTorikomiListDiv div) {
        dgKokuhorenTorikomiList_Row row = div.getDgKokuhorenTorikomiList().getClickedItem();
        RString 再処理区分 = RString.EMPTY;
        if (再処理可能.equals(row.getSaishoriFlag())) {
            再処理区分 = SaiShoriKubun.再処理.getコード();
        } else if (再処理不可.equals(row.getSaishoriFlag())) {
            再処理区分 = SaiShoriKubun.空白.getコード();
        }
        RString 交換情報識別番号 = row.getKokanShikibetsuNo();
        KokuhorenDataTorikomiViewStateClass parmater = new KokuhorenDataTorikomiViewStateClass(
                div.getTxtShoriYM().getValue().getYearMonth(), 再処理区分);
        parmater.set交換情報識別番号(交換情報識別番号);
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);
        if (交換情報識別番号.length() == NUM_4) {
            交換情報識別番号 = 交換情報識別番号.substring(NUM_0, NUM_3);
        }
        RString paramete = getHandler(div).getParamter(交換情報識別番号);
        return ResponseData.of(div).forwardWithEventName(DBC0410011TransitionEventName.バッチ起動)
                .parameter(paramete);
    }

    /**
     * 「スケジュール設定」ボタンのメソッドます。
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<KokuhorenTorikomiListDiv> onClick_btnScheduleSetting(KokuhorenTorikomiListDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理年月, div.getTxtShoriYM().getValue());
        return ResponseData.of(div).forwardWithEventName(DBC0410011TransitionEventName.スケジュール設定へ).respond();
    }

    private KokuhorenTorikomiListHandler getHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListHandler(div);
    }

    private KokuhorenTorikomiListValidationHandler getValidationHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListValidationHandler(div);
    }
}
