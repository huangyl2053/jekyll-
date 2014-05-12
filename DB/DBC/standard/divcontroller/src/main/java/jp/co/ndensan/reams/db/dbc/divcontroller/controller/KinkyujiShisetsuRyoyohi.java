/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KinkyujiShisetsuRyoyohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKinkyujiShisetsuRyoyohi_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 *
 * @author N8156 宮本 康
 */
public class KinkyujiShisetsuRyoyohi {

    public ResponseData<KinkyujiShisetsuRyoyohiDiv> onLoad(KinkyujiShisetsuRyoyohiDiv panel) {
        ResponseData<KinkyujiShisetsuRyoyohiDiv> response = new ResponseData<>();
        List<dgKinkyujiShisetsuRyoyohi_Row> list = new ArrayList<>();
        list.add(createKinkyujiShisetsuRyoyohiRow("緊急１", "病名１", "平26.01.01", "", "電算病院", "1", "電算保険施設", "2", "1,000", "250", "5", "250", "10", "20", "30", "40", "50", "1", "2", "平26.01"));
        list.add(createKinkyujiShisetsuRyoyohiRow("", "", "", "後", "", "1", "", "2", "", "250", "5", "", "10", "20", "30", "40", "50", "", "", ""));
        panel.getDgKinkyujiShisetsuRyoyohi().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgKinkyujiShisetsuRyoyohi_Row createKinkyujiShisetsuRyoyohiRow(
            String txtKinkyuKubun, String txtShobyoName, String txtChiryoKaishiYMD, String txtKettei, String txtOshinIryoKikanName,
            String txtOshinNissu, String txtTsuinIryoKikanName, String txtTsuinNissu, String txtKanriShokei, String txtKanriTani,
            String txtKanriNissu, String txtGokeiTensu, String txtRehabilitationTensu, String txtShochiTensu, String txtShujutsuTensu,
            String txtMahiTensu, String txtHoshasenChiryoTensu, String txtSaiShinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgKinkyujiShisetsuRyoyohi_Row(
                new RString(txtKinkyuKubun), new RString(txtShobyoName), new RString(txtChiryoKaishiYMD), new Button(), new RString(txtKettei), new RString(txtOshinIryoKikanName),
                new RString(txtOshinNissu), new RString(txtTsuinIryoKikanName), new RString(txtTsuinNissu), new RString(txtKanriShokei), new RString(txtKanriTani),
                new RString(txtKanriNissu), new RString(txtGokeiTensu), new RString(txtRehabilitationTensu), new RString(txtShochiTensu), new RString(txtShujutsuTensu),
                new RString(txtMahiTensu), new RString(txtHoshasenChiryoTensu), new RString(txtSaiShinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
