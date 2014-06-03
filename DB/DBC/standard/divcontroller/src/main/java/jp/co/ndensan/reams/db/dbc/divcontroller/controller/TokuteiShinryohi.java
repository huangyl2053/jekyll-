/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TokuteiShinryohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgTokuteiShinryohiFromH1504_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 *
 * @author N8156 宮本 康
 */
public class TokuteiShinryohi {

    public ResponseData<TokuteiShinryohiDiv> onLoad(TokuteiShinryohiDiv panel) {
        ResponseData<TokuteiShinryohiDiv> response = new ResponseData<>();
        List<dgTokuteiShinryohiFromH1504_Row> list = new ArrayList<>();
        list.add(createTokuteiShinryohiFromH1504Row("傷病名", "10:医学情報提供(Ⅱ)", "", "100", "1", "200", "300", "1", "1", "1,000", "2", "2", "2,000", "3", "3", "3,000", "1", "2", "平26.01"));
        list.add(createTokuteiShinryohiFromH1504Row("", "", "後", "100", "1", "200", "300", "1", "1", "1,000", "2", "2", "2,000", "3", "3", "3,000", "", "", ""));
        panel.getDgTokuteiShinryohiFromH1504().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgTokuteiShinryohiFromH1504_Row createTokuteiShinryohiFromH1504Row(
            String txtShobyoName, String txtShikibetsu, String txtKettei, String txtTanisu,
            String txtKaisu, String txtServiceTani, String txtGokeiTani, String txtKohi1Kaisu, String txtKohi1Tani,
            String txtKohi1GokeiTani, String txtKohi2Kaisu, String txtKohi2Tani, String txtKohi2GokeiTani, String txtKohi3Kaisu,
            String txtKohi3Tani, String txtKohi3GokeiTani, String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgTokuteiShinryohiFromH1504_Row(
                new RString(txtShobyoName), new RString(txtShikibetsu), new Button(), new RString(txtKettei), new RString(txtTanisu),
                new RString(txtKaisu), new RString(txtServiceTani), new RString(txtGokeiTani), new RString(txtKohi1Kaisu), new RString(txtKohi1Tani),
                new RString(txtKohi1GokeiTani), new RString(txtKohi2Kaisu), new RString(txtKohi2Tani), new RString(txtKohi2GokeiTani), new RString(txtKohi3Kaisu),
                new RString(txtKohi3Tani), new RString(txtKohi3GokeiTani), new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
