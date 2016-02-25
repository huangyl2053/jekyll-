/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenTorikomiJohoKey;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.relate.KokuhorenTorikomiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenTorikomiList {

    public ResponseData<KokuhorenTorikomiListDiv> onLoad(KokuhorenTorikomiListDiv panel) {
        KokuhorenTorikomiManager realservice = new KokuhorenTorikomiManager();
        RYearMonth max処理年月 = realservice.get国保連IF管理Max処理年月();
        panel.getTxtShoriYM().setValue(new RDate(max処理年月.getYearValue(), max処理年月.getMonthValue()));
        getHandler(panel).load(panel, max処理年月);
        return ResponseData.of(panel).respond();
    }

    private KokuhorenTorikomiListHandler getHandler(KokuhorenTorikomiListDiv div) {
        return new KokuhorenTorikomiListHandler(div);
    }

    /**
     * 処理年月テキストボックス変更時にリストを更新します。
     *
     * @param panel KokuhorenTorikomiListDiv
     * @return response
     */
    public ResponseData<KokuhorenTorikomiListDiv> onChange_txtShoriYM(KokuhorenTorikomiListDiv panel) {
        getHandler(panel).load(panel, panel.getTxtShoriYM().getValue().getYearMonth());
        return ResponseData.of(panel).respond();
    }

    public ResponseData<KokuhorenTorikomiListDiv> onSelect_dgKokuhorenTorikomiList_Row(KokuhorenTorikomiListDiv panel) {

        dgKokuhorenTorikomiList_Row row = panel.getDgKokuhorenTorikomiList().getSelectedItems().get(0);
        KokuhorenTorikomiJohoKey viewStateHolder
                = new KokuhorenTorikomiJohoKey(panel.getTxtShoriYM().getValue().seireki().separator(Separator.NONE).getYearMonth(),
                        new KokanShikibetsuNo(row.getKokanShikibetsuNo()), row.getTxtTorikomiJoho(), row.getSaishoriFlag(), row.getBatchID());
        ViewStateHolder.put(ViewStateKey.国保連取込情報, viewStateHolder);

        return ResponseData.of(panel).respond();
    }

}
