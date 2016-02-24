/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1400011.KagoMoshitatecCommonKiagoKanryoMegPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1400011.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書登録 過誤申立情報を保存する。
 *
 * @author n8223
 */
public class KagoMoshitatecCommonKiagoKanryoMegPanel {

    static final RString MESSAGE = new RString("過誤申立書を更新しました。");

    public ResponseData<KagoMoshitatecCommonKiagoKanryoMegPanelDiv> onClick_btnSave(KagoMoshitatecCommonKiagoKanryoMegPanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListPanel) {
        setKagoMoshitatecCommonKiagoKanryoMessg(panel, gaitoshaListPanel);

        return ResponseData.of(panel).respond();
    }

    private void setKagoMoshitatecCommonKiagoKanryoMessg(KagoMoshitatecCommonKiagoKanryoMegPanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListPanel) {

        if (gaitoshaListPanel.getDgHihokenshaSearchGaitosha().getDataSource().size() >= 0) {

            panel.getCommonKiagoKanryoMessageChildDiv1().setSuccessMessage(MESSAGE);
        }
    }
}
