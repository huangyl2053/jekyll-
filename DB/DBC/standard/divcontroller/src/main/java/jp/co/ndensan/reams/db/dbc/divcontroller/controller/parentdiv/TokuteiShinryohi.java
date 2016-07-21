/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.TokuteiShinryohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgTokuteiShinryohiFromH1504_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 *
 * @author N8156 宮本 康
 */
public class TokuteiShinryohi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel TokuteiShinryohiDiv
     * @return ResponseData
     */
    public ResponseData<TokuteiShinryohiDiv> onLoad(TokuteiShinryohiDiv panel) {
        ResponseData<TokuteiShinryohiDiv> response = new ResponseData<>();

        //特定療養費データ取得、設定
        List<HashMap> tokuteiShinryohi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/TokuteiShinryohi.yml"));

        List<dgTokuteiShinryohiFromH1504_Row> tokuteiShinryohiList = new ArrayList<>();
        for (int i = 0; i < tokuteiShinryohi.size(); i++) {
            HashMap hashMap = tokuteiShinryohi.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsShobyoName = ymlData.getAsRString("txtShobyoName");
            RString rsShikibetsu = ymlData.getAsRString("txtShikibetsu");
            RString rsKettei = ymlData.getAsRString("txtKettei");
            RString rsTanisu = ymlData.getAsRString("txtTanisu");
            RString rsKaisu = ymlData.getAsRString("txtKaisu");
            RString rsServiceTani = ymlData.getAsRString("txtServiceTani");
            RString rsGokeiTani = ymlData.getAsRString("txtGokeiTani");
            RString rsKohi1Kaisu = ymlData.getAsRString("txtKohi1Kaisu");
            RString rsKohi1Tani = ymlData.getAsRString("txtKohi1Tani");
            RString rsKohi1GokeiTani = ymlData.getAsRString("txtKohi1GokeiTani");
            RString rsKohi2Kaisu = ymlData.getAsRString("txtKohi2Kaisu");
            RString rsKohi2Tani = ymlData.getAsRString("txtKohi2Tani");
            RString rsKohi2GokeiTani = ymlData.getAsRString("txtKohi2GokeiTani");
            RString rsKohi3Kaisu = ymlData.getAsRString("txtKohi3Kaisu");
            RString rsKohi3Tani = ymlData.getAsRString("txtKohi3Tani");
            RString rsKohi3GokeiTani = ymlData.getAsRString("txtKohi3GokeiTani");
            RString rsSaishinsaKaisu = ymlData.getAsRString("txtSaishinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            tokuteiShinryohiList.add(createTokuteiShinryohiFromH1504Row(
                    rsShobyoName, rsShikibetsu, rsKettei, rsTanisu, rsKaisu, rsServiceTani,
                    rsGokeiTani, rsKohi1Kaisu, rsKohi1Tani, rsKohi1GokeiTani, rsKohi2Kaisu, rsKohi2Tani,
                    rsKohi2GokeiTani, rsKohi3Kaisu, rsKohi3Tani, rsKohi3GokeiTani,
                    rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgTokuteiShinryohiFromH1504().setDataSource(tokuteiShinryohiList);
//        List<dgTokuteiShinryohiFromH1504_Row> list = new ArrayList<>();
//        list.add(createTokuteiShinryohiFromH1504Row("傷病名", "10:医学情報提供(Ⅱ)", "", "100", "1", "200", "300", "1", "1", "1,000", "2", "2", "2,000", "3", "3", "3,000", "1", "2", "平26.01"));
//        list.add(createTokuteiShinryohiFromH1504Row("", "", "後", "100", "1", "200", "300", "1", "1", "1,000", "2", "2", "2,000", "3", "3", "3,000", "", "", ""));
//        panel.getDgTokuteiShinryohiFromH1504().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgTokuteiShinryohiFromH1504_Row createTokuteiShinryohiFromH1504Row(
            //            String txtShobyoName, String txtShikibetsu, String txtKettei, String txtTanisu,
            //            String txtKaisu, String txtServiceTani, String txtGokeiTani, String txtKohi1Kaisu, String txtKohi1Tani,
            //            String txtKohi1GokeiTani, String txtKohi2Kaisu, String txtKohi2Tani, String txtKohi2GokeiTani, String txtKohi3Kaisu,
            //            String txtKohi3Tani, String txtKohi3GokeiTani, String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
            RString txtShobyoName, RString txtShikibetsu, RString txtKettei, RString txtTanisu,
            RString txtKaisu, RString txtServiceTani, RString txtGokeiTani, RString txtKohi1Kaisu, RString txtKohi1Tani,
            RString txtKohi1GokeiTani, RString txtKohi2Kaisu, RString txtKohi2Tani, RString txtKohi2GokeiTani, RString txtKohi3Kaisu,
            RString txtKohi3Tani, RString txtKohi3GokeiTani, RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgTokuteiShinryohiFromH1504_Row(
                //                new RString(txtShobyoName), new RString(txtShikibetsu), new Button(), new RString(txtKettei), new RString(txtTanisu),
                //                new RString(txtKaisu), new RString(txtServiceTani), new RString(txtGokeiTani), new RString(txtKohi1Kaisu), new RString(txtKohi1Tani),
                //                new RString(txtKohi1GokeiTani), new RString(txtKohi2Kaisu), new RString(txtKohi2Tani), new RString(txtKohi2GokeiTani), new RString(txtKohi3Kaisu),
                //                new RString(txtKohi3Tani), new RString(txtKohi3GokeiTani), new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
                txtShobyoName, txtShikibetsu, new Button(), txtKettei, txtTanisu,
                txtKaisu, txtServiceTani, txtGokeiTani, txtKohi1Kaisu, txtKohi1Tani,
                txtKohi1GokeiTani, txtKohi2Kaisu, txtKohi2Tani, txtKohi2GokeiTani, txtKohi3Kaisu,
                txtKohi3Tani, txtKohi3GokeiTani, txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }
}
