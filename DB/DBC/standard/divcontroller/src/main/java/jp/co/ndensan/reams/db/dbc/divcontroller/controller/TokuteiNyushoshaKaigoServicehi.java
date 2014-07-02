/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.TokuteiNyushoshaKaigoServicehiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgTokuteiNyushoshaKaigoServicehi_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class TokuteiNyushoshaKaigoServicehi {

    public ResponseData<TokuteiNyushoshaKaigoServicehiDiv> onLoad(TokuteiNyushoshaKaigoServicehiDiv panel) {
        ResponseData<TokuteiNyushoshaKaigoServicehiDiv> response = new ResponseData<>();

        //特定入所者介護サービスデータ取得、設定
        List<HashMap> tokuteiNyushoshaKaigoServicehi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/TokuteiNyushoshaKaigoServicehi.yml"));

        List<dgTokuteiNyushoshaKaigoServicehi_Row> tokuteiNyushoshaKaigoServicehiList = new ArrayList<>();
        for (int i = 0; i < tokuteiNyushoshaKaigoServicehi.size(); i++) {
            HashMap hashMap = tokuteiNyushoshaKaigoServicehi.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsService = ymlData.getAsRString("txtService");
            RString rsFutanGendogaku = ymlData.getAsRString("txtFutanGendogaku");
            RString rsKettei = ymlData.getAsRString("txtKettei");
            RString rsMeisaiGokei = ymlData.getAsRString("txtMeisaiGokei");
            RString rsHiyoTanka = ymlData.getAsRString("txtHiyoTanka");
            RString rsNissu = ymlData.getAsRString("txtNissu");
            RString rsHiyogaku = ymlData.getAsRString("txtHiyogaku");
            RString rsSeikyugaku = ymlData.getAsRString("txtSeikyugaku");
            RString rsRiyoshaFutangaku = ymlData.getAsRString("txtRiyoshaFutangaku");
            RString rsKohi1Nissu = ymlData.getAsRString("txtKohi1Nissu");
            RString rsKohi1Futangaku = ymlData.getAsRString("txtKohi1Futangaku");
            RString rsKohi1Seikyugaku = ymlData.getAsRString("txtKohi1Seikyugaku");
            RString rsKohi1HonninFutangaku = ymlData.getAsRString("txtKohi1HonninFutangaku");
            RString rsKohi2Nissu = ymlData.getAsRString("txtKohi2Nissu");
            RString rsKohi2Futangaku = ymlData.getAsRString("txtKohi2Futangaku");
            RString rsKohi2Seikyugaku = ymlData.getAsRString("txtKohi2Seikyugaku");
            RString rsKohi2HonninFutangaku = ymlData.getAsRString("txtKohi2HonninFutangaku");
            RString rsKohi3Nissu = ymlData.getAsRString("txtKohi3Nissu");
            RString rsKohi3Futangaku = ymlData.getAsRString("txtKohi3Futangaku");
            RString rsKohi3Seikyugaku = ymlData.getAsRString("txtKohi3Seikyugaku");
            RString rsKohi3HonninFutangaku = ymlData.getAsRString("txtKohi3HonninFutangaku");
            RString rsSaishinsaKaisu = ymlData.getAsRString("txtSaishinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            tokuteiNyushoshaKaigoServicehiList.add(createTokuteiNyushoshaKaigoServicehiRow(
                    rsService, rsFutanGendogaku, rsKettei, rsMeisaiGokei, rsHiyoTanka, rsNissu,
                    rsHiyogaku, rsSeikyugaku, rsRiyoshaFutangaku, rsKohi1Nissu, rsKohi1Futangaku,
                    rsKohi1Seikyugaku, rsKohi1HonninFutangaku, rsKohi2Nissu, rsKohi2Futangaku,
                    rsKohi2Seikyugaku, rsKohi2HonninFutangaku, rsKohi3Nissu, rsKohi3Futangaku,
                    rsKohi3Seikyugaku, rsKohi3HonninFutangaku,
                    rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgTokuteiNyushoshaKaigoServicehi().setDataSource(tokuteiNyushoshaKaigoServicehiList);

//        List<dgTokuteiNyushoshaKaigoServicehi_Row> list = new ArrayList<>();
//        list.add(createTokuteiNyushoshaKaigoServicehiRow("592111:短期生活食費", "1,000", "", "明細", "976", "5", "101", "102", "106", "1", "103", "", "", "2", "104", "", "", "3", "105", "", "", "40", "41", "平26.01"));
//        list.add(createTokuteiNyushoshaKaigoServicehiRow("592121:短期生活ユニット型個室", "1,000", "", "明細", "976", "5", "101", "102", "106", "1", "103", "", "", "2", "104", "", "", "3", "105", "", "", "40", "41", "平26.01"));
//        list.add(createTokuteiNyushoshaKaigoServicehiRow("", "", "", "合計", "", "", "107", "103", "109", "", "41,110", "110", "111", "", "112", "113", "114", "", "115", "116", "111", "", "", ""));
//        list.add(createTokuteiNyushoshaKaigoServicehiRow("592111:短期生活食費", "1,000", "", "明細", "118", "19", "123", "123", "127", "20", "124", "", "", "21", "125", "", "", "22", "126", "", "", "", "", ""));
//        list.add(createTokuteiNyushoshaKaigoServicehiRow("592121:短期生活ユニット型個室", "1,000", "", "明細", "118", "19", "123", "123", "127", "20", "124", "", "", "21", "125", "", "", "22", "126", "", "", "", "", ""));
//        list.add(createTokuteiNyushoshaKaigoServicehiRow("", "", "", "合計", "", "", "128", "108", "130", "", "131", "132", "133", "", "134", "135", "136", "", "137", "138", "133", "", "", ""));
//        panel.getDgTokuteiNyushoshaKaigoServicehi().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgTokuteiNyushoshaKaigoServicehi_Row createTokuteiNyushoshaKaigoServicehiRow(
            RString txtService, RString txtFutanGendogaku, RString txtKettei, RString txtMeisaiGokei,
            RString txtHiyoTanka, RString txtNissu, RString txtHiyogaku, RString txtSeikyugaku, RString txtRiyoshaFutangaku,
            RString txtKohi1Nissu, RString txtKohi1Futangaku, RString txtKohi1Seikyugaku, RString txtKohi1HonninFutangaku,
            RString txtKohi2Nissu, RString txtKohi2Futangaku, RString txtKohi2Seikyugaku, RString txtKohi2HonninFutangaku,
            RString txtKohi3Nissu, RString txtKohi3Futangaku, RString txtKohi3Seikyugaku, RString txtKohi3HonninFutangaku,
            RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
//            String txtService, String txtFutanGendogaku, String txtKettei, String txtMeisaiGokei,
//            String txtHiyoTanka, String txtNissu, String txtHiyogaku, String txtSeikyugaku, String txtRiyoshaFutangaku,
//            String txtKohi1Nissu, String txtKohi1Futangaku, String txtKohi1Seikyugaku, String txtKohi1HonninFutangaku,
//            String txtKohi2Nissu, String txtKohi2Futangaku, String txtKohi2Seikyugaku, String txtKohi2HonninFutangaku,
//            String txtKohi3Nissu, String txtKohi3Futangaku, String txtKohi3Seikyugaku, String txtKohi3HonninFutangaku,
//            String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgTokuteiNyushoshaKaigoServicehi_Row(
                txtService, txtFutanGendogaku, txtKettei, txtMeisaiGokei,
                txtHiyoTanka, txtNissu, txtHiyogaku, txtSeikyugaku, txtRiyoshaFutangaku,
                txtKohi1Nissu, txtKohi1Futangaku, txtKohi1Seikyugaku, txtKohi1HonninFutangaku,
                txtKohi2Nissu, txtKohi2Futangaku, txtKohi2Seikyugaku, txtKohi2HonninFutangaku,
                txtKohi3Nissu, txtKohi3Futangaku, txtKohi3Seikyugaku, txtKohi3HonninFutangaku,
                txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
//                new RString(txtService), new RString(txtFutanGendogaku), new RString(txtKettei), new RString(txtMeisaiGokei),
//                new RString(txtHiyoTanka), new RString(txtNissu), new RString(txtHiyogaku), new RString(txtSeikyugaku), new RString(txtRiyoshaFutangaku),
//                new RString(txtKohi1Nissu), new RString(txtKohi1Futangaku), new RString(txtKohi1Seikyugaku), new RString(txtKohi1HonninFutangaku),
//                new RString(txtKohi2Nissu), new RString(txtKohi2Futangaku), new RString(txtKohi2Seikyugaku), new RString(txtKohi2HonninFutangaku),
//                new RString(txtKohi3Nissu), new RString(txtKohi3Futangaku), new RString(txtKohi3Seikyugaku), new RString(txtKohi3HonninFutangaku),
//                new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
