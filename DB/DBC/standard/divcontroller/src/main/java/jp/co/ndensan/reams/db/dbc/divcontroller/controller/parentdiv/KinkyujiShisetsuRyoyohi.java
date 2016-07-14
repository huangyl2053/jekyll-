/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KinkyujiShisetsuRyoyohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 *
 * @author N8156 宮本 康
 */
public class KinkyujiShisetsuRyoyohi {

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel KinkyujiShisetsuRyoyohiDiv
     * @return ResponseData
     */
    public ResponseData<KinkyujiShisetsuRyoyohiDiv> onLoad(KinkyujiShisetsuRyoyohiDiv panel) {
        ResponseData<KinkyujiShisetsuRyoyohiDiv> response = new ResponseData<>();

        //緊急時施設療養費データ取得、設定
        List<HashMap> kinkyujiShisetsuRyoyohi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KinkyujiShisetsuRyoyohi.yml"));

        List<dgKinkyujiShisetsuRyoyohi_Row> kinkyujiShisetsuRyoyohiList = new ArrayList<>();
        for (int i = 0; i < kinkyujiShisetsuRyoyohi.size(); i++) {
            HashMap hashMap = kinkyujiShisetsuRyoyohi.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsKinkyuKubun = ymlData.getAsRString("txtKinkyuKubun");
            RString rsShobyoName = ymlData.getAsRString("txtShobyoName");
            RString rsChiryoKaishiYMD = ymlData.getAsRString("txtChiryoKaishiYMD");
            RString rsKettei = ymlData.getAsRString("txtKettei");
            RString rsOshinIryoKikanName = ymlData.getAsRString("txtOshinIryoKikanName");
            RString rsOshinNissu = ymlData.getAsRString("txtOshinNissu");
            RString rsTsuinIryoKikanName = ymlData.getAsRString("txtTsuinIryoKikanName");
            RString rsTsuinNissu = ymlData.getAsRString("txtTsuinNissu");
            RString rsKanriShokei = ymlData.getAsRString("txtKanriShokei");
            RString rsKanriTani = ymlData.getAsRString("txtKanriTani");
            RString rsKanriNissu = ymlData.getAsRString("txtKanriNissu");
            RString rsGokeiTensu = ymlData.getAsRString("txtGokeiTensu");
            RString rsRehabilitationTensu = ymlData.getAsRString("txtRehabilitationTensu");
            RString rsShochiTensu = ymlData.getAsRString("txtShochiTensu");
            RString rsShujutsuTensu = ymlData.getAsRString("txtShujutsuTensu");
            RString rsMahiTensu = ymlData.getAsRString("txtMahiTensu");
            RString rsHoshasenChiryoTensu = ymlData.getAsRString("txtHoshasenChiryoTensu");
            RString rsSaiShinsaKaisu = ymlData.getAsRString("txtSaiShinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            kinkyujiShisetsuRyoyohiList.add(createKinkyujiShisetsuRyoyohiRow(
                    rsKinkyuKubun, rsShobyoName, rsChiryoKaishiYMD, rsKettei, rsOshinIryoKikanName, rsOshinNissu,
                    rsTsuinIryoKikanName, rsTsuinNissu, rsKanriShokei, rsKanriTani, rsKanriNissu, rsGokeiTensu,
                    rsRehabilitationTensu, rsShochiTensu, rsShujutsuTensu, rsMahiTensu, rsHoshasenChiryoTensu,
                    rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgKinkyujiShisetsuRyoyohi().setDataSource(kinkyujiShisetsuRyoyohiList);

//        List<dgKinkyujiShisetsuRyoyohi_Row> list = new ArrayList<>();
//        list.add(createKinkyujiShisetsuRyoyohiRow("緊急１", "病名１", "平26.01.01", "", "電算病院", "1", "電算保険施設", "2", "1,000", "250", "5", "250", "10", "20", "30", "40", "50", "1", "2", "平26.01"));
//        list.add(createKinkyujiShisetsuRyoyohiRow("", "", "", "後", "", "1", "", "2", "", "250", "5", "", "10", "20", "30", "40", "50", "", "", ""));
//        panel.getDgKinkyujiShisetsuRyoyohi().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgKinkyujiShisetsuRyoyohi_Row createKinkyujiShisetsuRyoyohiRow(
            //            String txtKinkyuKubun, String txtShobyoName, String txtChiryoKaishiYMD, String txtKettei, String txtOshinIryoKikanName,
            //            String txtOshinNissu, String txtTsuinIryoKikanName, String txtTsuinNissu, String txtKanriShokei, String txtKanriTani,
            //            String txtKanriNissu, String txtGokeiTensu, String txtRehabilitationTensu, String txtShochiTensu, String txtShujutsuTensu,
            //            String txtMahiTensu, String txtHoshasenChiryoTensu, String txtSaiShinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
            RString txtKinkyuKubun, RString txtShobyoName, RString txtChiryoKaishiYMD, RString txtKettei, RString txtOshinIryoKikanName,
            RString txtOshinNissu, RString txtTsuinIryoKikanName, RString txtTsuinNissu, RString txtKanriShokei, RString txtKanriTani,
            RString txtKanriNissu, RString txtGokeiTensu, RString txtRehabilitationTensu, RString txtShochiTensu, RString txtShujutsuTensu,
            RString txtMahiTensu, RString txtHoshasenChiryoTensu, RString txtSaiShinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgKinkyujiShisetsuRyoyohi_Row(
                //                new RString(txtKinkyuKubun), new RString(txtShobyoName), new RString(txtChiryoKaishiYMD), new Button(), new RString(txtKettei), new RString(txtOshinIryoKikanName),
                //                new RString(txtOshinNissu), new RString(txtTsuinIryoKikanName), new RString(txtTsuinNissu), new RString(txtKanriShokei), new RString(txtKanriTani),
                //                new RString(txtKanriNissu), new RString(txtGokeiTensu), new RString(txtRehabilitationTensu), new RString(txtShochiTensu), new RString(txtShujutsuTensu),
                //                new RString(txtMahiTensu), new RString(txtHoshasenChiryoTensu), new RString(txtSaiShinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
                txtKinkyuKubun, txtShobyoName, txtChiryoKaishiYMD, new Button(), txtKettei, txtOshinIryoKikanName,
                txtOshinNissu, txtTsuinIryoKikanName, txtTsuinNissu, txtKanriShokei, txtKanriTani,
                txtKanriNissu, txtGokeiTensu, txtRehabilitationTensu, txtShochiTensu, txtShujutsuTensu,
                txtMahiTensu, txtHoshasenChiryoTensu, txtSaiShinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }
}
