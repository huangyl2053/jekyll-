/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShakaiFukushiHojinKeigengakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShakaiFukushiHojinKeigengaku_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class ShakaiFukushiHojinKeigengaku {

    public ResponseData<ShakaiFukushiHojinKeigengakuDiv> onLoad(ShakaiFukushiHojinKeigengakuDiv panel) {
        ResponseData<ShakaiFukushiHojinKeigengakuDiv> response = new ResponseData<>();
        List<dgShakaiFukushiHojinKeigengaku_Row> list = new ArrayList<>();
        list.add(createShakaiFukushiHojinKeigengakuRow("55.0", "21:短期入所生活介護", "", "50,000", "5,000", "9,500", "備考１", "1", "2", "平26.01"));
        list.add(createShakaiFukushiHojinKeigengakuRow("", "", "後", "10,015", "1,025", "9,005", "", "", "", ""));
        panel.getDgShakaiFukushiHojinKeigengaku().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgShakaiFukushiHojinKeigengaku_Row createShakaiFukushiHojinKeigengakuRow(
            String txtKeigenritsu, String txtShurui, String txtZengo, String txtJuryoSubekiRiyoshaFutanSogaku,
            String txtKeigengaku, String txtKeigengoRiyoshaFutangaku, String txtBiko, String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgShakaiFukushiHojinKeigengaku_Row(
                new RString(txtKeigenritsu), new RString(txtShurui), new RString(txtZengo), new RString(txtJuryoSubekiRiyoshaFutanSogaku),
                new RString(txtKeigengaku), new RString(txtKeigengoRiyoshaFutangaku), new RString(txtBiko), new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
