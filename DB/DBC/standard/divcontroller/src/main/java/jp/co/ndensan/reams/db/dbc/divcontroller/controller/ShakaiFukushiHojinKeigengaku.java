/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.ShakaiFukushiHojinKeigengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgShakaiFukushiHojinKeigengaku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class ShakaiFukushiHojinKeigengaku {

    public ResponseData<ShakaiFukushiHojinKeigengakuDiv> onLoad(ShakaiFukushiHojinKeigengakuDiv panel) {
        ResponseData<ShakaiFukushiHojinKeigengakuDiv> response = new ResponseData<>();

        //社会福祉法人軽減額データ取得、設定
        List<HashMap> shakaiFukushiHojinKeigengaku = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/ShakaiFukushiHojinKeigengaku.yml"));

        List<dgShakaiFukushiHojinKeigengaku_Row> shakaiFukushiHojinKeigengakuList = new ArrayList<>();
        for (int i = 0; i < shakaiFukushiHojinKeigengaku.size(); i++) {
            HashMap hashMap = shakaiFukushiHojinKeigengaku.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsKeigenritsu = ymlData.getAsRString("txtKeigenritsu");
            RString rsShurui = ymlData.getAsRString("txtShurui");
            RString rsZengo = ymlData.getAsRString("txtZengo");
            RString rsJuryoSubekiRiyoshaFutanSogaku = ymlData.getAsRString("txtJuryoSubekiRiyoshaFutanSogaku");
            RString rsKeigengaku = ymlData.getAsRString("txtKeigengaku");
            RString rsKeigengoRiyoshaFutangaku = ymlData.getAsRString("txtKeigengoRiyoshaFutangaku");
            RString rsBiko = ymlData.getAsRString("txtBiko");
            RString rsSaishinsaKaisu = ymlData.getAsRString("txtSaishinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            shakaiFukushiHojinKeigengakuList.add(createShakaiFukushiHojinKeigengakuRow(
                    rsKeigenritsu, rsShurui, rsZengo, rsJuryoSubekiRiyoshaFutanSogaku, rsKeigengaku,
                    rsKeigengoRiyoshaFutangaku, rsBiko,
                    rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgShakaiFukushiHojinKeigengaku().setDataSource(shakaiFukushiHojinKeigengakuList);

//        List<dgShakaiFukushiHojinKeigengaku_Row> list = new ArrayList<>();
//        list.add(createShakaiFukushiHojinKeigengakuRow("55.0", "21:短期入所生活介護", "", "50,000", "5,000", "9,500", "備考１", "1", "2", "平26.01"));
//        list.add(createShakaiFukushiHojinKeigengakuRow("", "", "後", "10,015", "1,025", "9,005", "", "", "", ""));
//        panel.getDgShakaiFukushiHojinKeigengaku().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgShakaiFukushiHojinKeigengaku_Row createShakaiFukushiHojinKeigengakuRow(
            RString txtKeigenritsu, RString txtShurui, RString txtZengo, RString txtJuryoSubekiRiyoshaFutanSogaku,
            RString txtKeigengaku, RString txtKeigengoRiyoshaFutangaku, RString txtBiko, RString txtSaishinsaKaisu,
            RString txtKagoKaisu, RString txtShinsaYM) {
//            String txtKeigenritsu, String txtShurui, String txtZengo, String txtJuryoSubekiRiyoshaFutanSogaku,
//            String txtKeigengaku, String txtKeigengoRiyoshaFutangaku, String txtBiko, String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgShakaiFukushiHojinKeigengaku_Row(
                txtKeigenritsu, txtShurui, txtZengo, txtJuryoSubekiRiyoshaFutanSogaku,
                txtKeigengaku, txtKeigengoRiyoshaFutangaku, txtBiko, txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
//                new RString(txtKeigenritsu), new RString(txtShurui), new RString(txtZengo), new RString(txtJuryoSubekiRiyoshaFutanSogaku),
//                new RString(txtKeigengaku), new RString(txtKeigengoRiyoshaFutangaku), new RString(txtBiko), new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
