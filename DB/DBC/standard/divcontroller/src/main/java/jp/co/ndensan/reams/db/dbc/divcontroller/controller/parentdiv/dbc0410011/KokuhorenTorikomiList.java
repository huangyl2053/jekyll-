/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0410011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenTorikomiJohoKey;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.DBC0410011TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0410011.KokuhorenTorikomiListHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0410011.KokuhorenTorikomiListValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.basic.IryoHokenRirekiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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

        dgKokuhorenTorikomiList_Row row = div.getDgKokuhorenTorikomiList().getSelectedItems().get(0);
        KokuhorenTorikomiJohoKey viewStateHolder = new KokuhorenTorikomiJohoKey(
                div.getTxtShoriYM().getValue().seireki().separator(Separator.NONE).getYearMonth(),
                new KokanShikibetsuNo(row.getKokanShikibetsuNo()),
                row.getTxtTorikomiJoho(),
                row.getSaishoriFlag(),
                row.getBatchID());
        ViewStateHolder.put(ViewStateKey.国保連取込情報, viewStateHolder);

        RString paramete = getHandler(div).getParamter(row.getKokanShikibetsuNo());
        return ResponseData.of(div).forwardWithEventName(DBC0410011TransitionEventName.バッチ起動)
                .parameter(paramete);
    }

    private KokuhorenTorikomiListHandler getHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListHandler(div);
    }

    private KokuhorenTorikomiListValidationHandler getValidationHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListValidationHandler(div);
    }
}
