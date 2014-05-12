/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokujiHiyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShokujiHiyoToH1503_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class ShokujiHiyo {

    public ResponseData<ShokujiHiyoDiv> onLoad(ShokujiHiyoDiv panel) {
        ResponseData<ShokujiHiyoDiv> response = new ResponseData<>();
        List<dgShokujiHiyoToH1503_Row> list = new ArrayList<>();
        list.add(createShokujiHiyoToH1503Row("基本", "", "20", "1,500", "110,000", "210,000", "19,000", "3,000", "", "30", "決定前", "", "310,000", "1", "2", "平26.01"));
        list.add(createShokujiHiyoToH1503Row("", "後", "", "5,000", "", "", "", "", "公費１", "31", "", "公費１", "320,000", "", "", ""));
        list.add(createShokujiHiyoToH1503Row("特別", "", "10", "2,000", "130,000", "", "", "", "公費２", "32", "", "公費２", "330,000", "", "", ""));
        list.add(createShokujiHiyoToH1503Row("", "後", "", "1,000", "", "", "", "", "公費３", "33", "", "公費３", "340,000", "", "", ""));
        panel.getDgShokujiHiyoToH1503().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgShokujiHiyoToH1503_Row createShokujiHiyoToH1503Row(
            String txtKihon, String txtZengo, String txtTeikyoNissu, String txtTeikyoTanka, String txtTeikyoKingaku,
            String txtShokujiTeikyohiGokei, String txtHyojunFutangakuTsuki, String txtHyojunFutangakuHi, String txtKohi,
            String txtShokujiTeikyoNobeNissu, String txtSeikyugakuZengo, String txtKohiSeikyu, String txtShokujiTeikyohiSeikyugaku,
            String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgShokujiHiyoToH1503_Row(
                new RString(txtKihon), new RString(txtZengo), new RString(txtTeikyoNissu), new RString(txtTeikyoTanka), new RString(txtTeikyoKingaku),
                new RString(txtShokujiTeikyohiGokei), new RString(txtHyojunFutangakuTsuki), new RString(txtHyojunFutangakuHi), new RString(txtKohi),
                new RString(txtShokujiTeikyoNobeNissu), new RString(txtSeikyugakuZengo), new RString(txtKohiSeikyu), new RString(txtShokujiTeikyohiSeikyugaku),
                new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
