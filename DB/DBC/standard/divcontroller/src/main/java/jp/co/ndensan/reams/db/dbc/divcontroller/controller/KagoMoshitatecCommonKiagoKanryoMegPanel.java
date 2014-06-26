/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KagoMoshitatecCommonKiagoKanryoMegPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011.KyufuJissekiGaitoshaListPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書登録 過誤申立情報を保存する
 * @author n8223
 */
public class KagoMoshitatecCommonKiagoKanryoMegPanel  {
    
    final static  String Title ="介護給付費過誤申立書登録";
    final static  String Message ="過誤申立書を保存しました。";
    
     public ResponseData<KagoMoshitatecCommonKiagoKanryoMegPanelDiv> onClick_btnSave(KagoMoshitatecCommonKiagoKanryoMegPanelDiv panel ,KyufuJissekiGaitoshaListPanelDiv  gaitoshaListPanel) {
        ResponseData<KagoMoshitatecCommonKiagoKanryoMegPanelDiv> response = new ResponseData<>();
        setKagoMoshitatecCommonKiagoKanryoMessg(panel, gaitoshaListPanel);

        response.data = panel;
        return response;
    }

    private void setKagoMoshitatecCommonKiagoKanryoMessg(KagoMoshitatecCommonKiagoKanryoMegPanelDiv panel, KyufuJissekiGaitoshaListPanelDiv gaitoshaListPanel) {
        
        if(gaitoshaListPanel.getDgHihokenshaSearchGaitosha().getDataSource().size() >= 0 ) {
            panel.getCommonKiagoKanryoMessageChildDiv1().getKanryoMessage().getLblMessageMain().setText(new RString(Message));
            panel.getCommonKiagoKanryoMessageChildDiv1().getKanryoMessage().getLblTaishoTitle().setVisible(false);
        }
    }
}
