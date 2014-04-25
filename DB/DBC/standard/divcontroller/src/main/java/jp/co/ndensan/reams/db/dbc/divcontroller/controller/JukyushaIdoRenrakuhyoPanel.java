/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public class JukyushaIdoRenrakuhyoPanel {

    public ResponseData<JukyushaIdoRenrakuhyoPanelDiv> onLoad(
            JukyushaIdoRenrakuhyoPanelDiv renrakuhyoPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {

        set基本情報(renrakuhyoPanel);
        set連絡票情報(renrakuhyoPanel);

        ResponseData<JukyushaIdoRenrakuhyoPanelDiv> response = new ResponseData<>();
        response.data = renrakuhyoPanel;

        return response;
    }

//    public ResponseData<JukyushaIdoRenrakuhyoDetailPanelDiv> onClick_btnReSearch(
//            JukyushaIdoRenrakuhyoDetailPanelDiv detailPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
////        testData = createTestData();
//
//        ResponseData<JukyushaIdoRenrakuhyoDetailPanelDiv> response = new ResponseData<>();
//        response.data = detailPanel;
//
//        return response;
//    }
    private void set基本情報(JukyushaIdoRenrakuhyoPanelDiv panel) {
        panel.getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoHihoNo().setValue(new RString("0000000001"));
        panel.getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoHihoName().setValue(new RString("電算　太郎"));
        panel.getJukyushaIdoRenrakuhyoKihonJoho().getTxtRenrakuhyoSendYM().setValue(new RString("20111111"));
        panel.getJukyushaIdoRenrakuhyoKihonJoho().getTxtHihoBirthday().setValue(new RString("20111111"));
        panel.getJukyushaIdoRenrakuhyoKihonJoho().getTxtShokisaiHokenshaNo().setValue(new RString("123456"));
        panel.getJukyushaIdoRenrakuhyoKihonJoho().getTxtKoikiHokenshaNo().setValue(new RString("123456"));

//        panel.getJukyushaIdoRenrakuhyoKihonJoho().getDdlIdoJiyu().setSelectedItem(RString.EMPTY);
    }

    private void set連絡票情報(JukyushaIdoRenrakuhyoPanelDiv panel) {
//        setTab1(panel);
//        setTab2(panel);
//
//    }
//
//    private void setTab1(JukyushaIdoRenrakuhyoPanelDiv panel) {
//        //支給限度基準額
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuHomonTsushoShikyuGendoKijungaku().setValue(new RString("1000"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuTankiNyushoShikyuGendoKijungaku().setValue(new RString("1000"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuHomonTsushoKanriTekiyoDateRange().setFromValue(new RString("20111111"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuHomonTsushoKanriTekiyoDateRange().setToValue(new RString("20111111"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuTankiNyushoKanriTekiyoDateRange().setFromValue(new RString("20111111"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoShikyugendoKijungaku().getTxtKyuTankiNyushoKanriTekiyoDateRange().setToValue(new RString("20111111"));
//
//        //要介護認定
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoYokaigonintei().getTxtShinseiDate().setValue(new RString("20111111"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoYokaigonintei().getTxtNinteiDateRange().setFromValue(new RString("20111111"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoYokaigonintei().getTxtNinteiDateRange().setToValue(new RString("20111111"));
//        //二次予防
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoNijiyoboJigyo().getTxtNijiyoboJigyoYukoDateRange().setFromValue(new RString("20111111"));
//        panel.getJukyushaIdoRenrakuhyoDetailTab().getRenrakuhyoDetailTab1().
//                getJukyushaIdoRenrakuhyoNijiyoboJigyo().getTxtNijiyoboJigyoYukoDateRange().setToValue(new RString("20111111"));
//    }
//
//    private void setTab2(JukyushaIdoRenrakuhyoDetailPanelDiv panel) {
//
    }
}
