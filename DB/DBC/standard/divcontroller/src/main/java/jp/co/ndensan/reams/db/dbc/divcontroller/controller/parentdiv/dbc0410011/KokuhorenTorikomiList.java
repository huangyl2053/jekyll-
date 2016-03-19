/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.DBC0410011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0410011.KokuhorenTorikomiListHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0410011.KokuhorenTorikomiListValidationHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.kaigokyufukokuhorenjohotorikomi.KokuhorenDataTorikomiViewStateClass;
import jp.co.ndensan.reams.db.dbc.service.core.basic.IryoHokenRirekiManager;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ViewStateHolderName;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 国保連情報データ取込のクラスです
 */
public class KokuhorenTorikomiList {

    /**
     * 初期化
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
        getHandler(div).load(div, new RYearMonth(max処理年月.toDateString()));
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
        getHandler(div).load(div, div.getTxtShoriYM().getValue().getYearMonth());
        return ResponseData.of(div).respond();
    }

    /**
     * onSelect_dgKokuhorenTorikomiList_Row
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<KokuhorenTorikomiListDiv> onSelect_dgKokuhorenTorikomiList_Row(
            KokuhorenTorikomiListDiv div) {

        dgKokuhorenTorikomiList_Row row = div.getDgKokuhorenTorikomiList().getClickedItem();
        KokuhorenDataTorikomiViewStateClass parmater = new KokuhorenDataTorikomiViewStateClass(
                div.getTxtShoriYM().getValue().getYearMonth(),
                new RString("1"));
        ViewStateHolder.put(ViewStateHolderName.国保連取込情報, parmater);

        RString paramete = getHandler(div).getParamter(row.getKokanShikibetsuNo());
        return ResponseData.of(div).forwardWithEventName(DBC0410011TransitionEventName.バッチ起動)
                .parameter(paramete);
    }

    /**
     * 「スケジュール設定」ボタン
     *
     * @param div KokuhorenTorikomiListDiv
     * @return ResponseData
     */
    public ResponseData<KokuhorenTorikomiListDiv> onClick_btnScheduleSetting(KokuhorenTorikomiListDiv div) {
        ViewStateHolder.put(ViewStateKeys.処理年月, div.getTxtShoriYM().getValue());
        return ResponseData.of(div).respond();
    }

    private KokuhorenTorikomiListHandler getHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListHandler(div);
    }

    private KokuhorenTorikomiListValidationHandler getValidationHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListValidationHandler(div);
    }
}
