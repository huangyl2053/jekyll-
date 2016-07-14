/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.ShokujiHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgShokujiHiyoToH1503_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class ShokujiHiyo {

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel ShokujiHiyoDiv
     * @return ResponseData
     */
    public ResponseData<ShokujiHiyoDiv> onLoad(ShokujiHiyoDiv panel) {
        ResponseData<ShokujiHiyoDiv> response = new ResponseData<>();

        //食事費用データ取得、設定
        List<HashMap> shokujiHiyo = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/ShokujiHiyo.yml"));

        List<dgShokujiHiyoToH1503_Row> shokujiHiyoList = new ArrayList<>();
        for (int i = 0; i < shokujiHiyo.size(); i++) {
            HashMap hashMap = shokujiHiyo.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsKihon = ymlData.getAsRString("txtKihon");
            RString rsZengo = ymlData.getAsRString("txtZengo");
            RString rsTeikyoNissu = ymlData.getAsRString("txtTeikyoNissu");
            RString rsTeikyoTanka = ymlData.getAsRString("txtTeikyoTanka");
            RString rsTeikyoKingaku = ymlData.getAsRString("txtTeikyoKingaku");
            RString rsShokujiTeikyohiGokei = ymlData.getAsRString("txtShokujiTeikyohiGokei");
            RString rsHyojunFutangakuTsuki = ymlData.getAsRString("txtHyojunFutangakuTsuki");
            RString rsHyojunFutangakuHi = ymlData.getAsRString("txtHyojunFutangakuHi");
            RString rsKohi = ymlData.getAsRString("txtKohi");
            RString rsShokujiTeikyoNobeNissu = ymlData.getAsRString("txtShokujiTeikyoNobeNissu");
            RString rsSeikyugakuZengo = ymlData.getAsRString("txtSeikyugakuZengo");
            RString rsKohiSeikyu = ymlData.getAsRString("txtKohiSeikyu");
            RString rsShokujiTeikyohiSeikyugaku = ymlData.getAsRString("txtShokujiTeikyohiSeikyugaku");
            RString rsSaishinsaKaisu = ymlData.getAsRString("txtSaishinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            shokujiHiyoList.add(createShokujiHiyoToH1503Row(
                    rsKihon, rsZengo, rsTeikyoNissu, rsTeikyoTanka, rsTeikyoKingaku, rsShokujiTeikyohiGokei,
                    rsHyojunFutangakuTsuki, rsHyojunFutangakuHi, rsKohi, rsShokujiTeikyoNobeNissu,
                    rsSeikyugakuZengo, rsKohiSeikyu, rsShokujiTeikyohiSeikyugaku,
                    rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgShokujiHiyoToH1503().setDataSource(shokujiHiyoList);

//        List<dgShokujiHiyoToH1503_Row> list = new ArrayList<>();
//        list.add(createShokujiHiyoToH1503Row("基本", "", "20", "1,500", "110,000", "210,000", "19,000", "3,000", "", "30", "決定前", "", "310,000", "1", "2", "平26.01"));
//        list.add(createShokujiHiyoToH1503Row("", "後", "", "5,000", "", "", "", "", "公費１", "31", "", "公費１", "320,000", "", "", ""));
//        list.add(createShokujiHiyoToH1503Row("特別", "", "10", "2,000", "130,000", "", "", "", "公費２", "32", "", "公費２", "330,000", "", "", ""));
//        list.add(createShokujiHiyoToH1503Row("", "後", "", "1,000", "", "", "", "", "公費３", "33", "", "公費３", "340,000", "", "", ""));
//        panel.getDgShokujiHiyoToH1503().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgShokujiHiyoToH1503_Row createShokujiHiyoToH1503Row(
            RString txtKihon, RString txtZengo, RString txtTeikyoNissu, RString txtTeikyoTanka, RString txtTeikyoKingaku,
            RString txtShokujiTeikyohiGokei, RString txtHyojunFutangakuTsuki, RString txtHyojunFutangakuHi, RString txtKohi,
            RString txtShokujiTeikyoNobeNissu, RString txtSeikyugakuZengo, RString txtKohiSeikyu, RString txtShokujiTeikyohiSeikyugaku,
            RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
//            String txtKihon, String txtZengo, String txtTeikyoNissu, String txtTeikyoTanka, String txtTeikyoKingaku,
//            String txtShokujiTeikyohiGokei, String txtHyojunFutangakuTsuki, String txtHyojunFutangakuHi, String txtKohi,
//            String txtShokujiTeikyoNobeNissu, String txtSeikyugakuZengo, String txtKohiSeikyu, String txtShokujiTeikyohiSeikyugaku,
//            String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgShokujiHiyoToH1503_Row(
                txtKihon, txtZengo, txtTeikyoNissu, txtTeikyoTanka, txtTeikyoKingaku,
                txtShokujiTeikyohiGokei, txtHyojunFutangakuTsuki, txtHyojunFutangakuHi, txtKohi,
                txtShokujiTeikyoNobeNissu, txtSeikyugakuZengo, txtKohiSeikyu, txtShokujiTeikyohiSeikyugaku,
                txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
//                new RString(txtKihon), new RString(txtZengo), new RString(txtTeikyoNissu), new RString(txtTeikyoTanka), new RString(txtTeikyoKingaku),
//                new RString(txtShokujiTeikyohiGokei), new RString(txtHyojunFutangakuTsuki), new RString(txtHyojunFutangakuHi), new RString(txtKohi),
//                new RString(txtShokujiTeikyoNobeNissu), new RString(txtSeikyugakuZengo), new RString(txtKohiSeikyu), new RString(txtShokujiTeikyohiSeikyugaku),
//                new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
