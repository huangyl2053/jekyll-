/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.TokuteiNyushoshaKaigoServicehiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgTokuteiNyushoshaKaigoServicehi_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class TokuteiNyushoshaKaigoServicehi {

    public ResponseData<TokuteiNyushoshaKaigoServicehiDiv> onLoad(TokuteiNyushoshaKaigoServicehiDiv panel) {
        ResponseData<TokuteiNyushoshaKaigoServicehiDiv> response = new ResponseData<>();
        List<dgTokuteiNyushoshaKaigoServicehi_Row> list = new ArrayList<>();
        list.add(createTokuteiNyushoshaKaigoServicehiRow("592111:短期生活食費", "1,000", "", "明細", "976", "5", "101", "102", "106", "1", "103", "", "", "2", "104", "", "", "3", "105", "", "", "40", "41", "平26.01"));
        list.add(createTokuteiNyushoshaKaigoServicehiRow("592121:短期生活ユニット型個室", "1,000", "", "明細", "976", "5", "101", "102", "106", "1", "103", "", "", "2", "104", "", "", "3", "105", "", "", "40", "41", "平26.01"));
        list.add(createTokuteiNyushoshaKaigoServicehiRow("", "", "", "合計", "", "", "107", "103", "109", "", "41,110", "110", "111", "", "112", "113", "114", "", "115", "116", "111", "", "", ""));
        list.add(createTokuteiNyushoshaKaigoServicehiRow("592111:短期生活食費", "1,000", "", "明細", "118", "19", "123", "123", "127", "20", "124", "", "", "21", "125", "", "", "22", "126", "", "", "", "", ""));
        list.add(createTokuteiNyushoshaKaigoServicehiRow("592121:短期生活ユニット型個室", "1,000", "", "明細", "118", "19", "123", "123", "127", "20", "124", "", "", "21", "125", "", "", "22", "126", "", "", "", "", ""));
        list.add(createTokuteiNyushoshaKaigoServicehiRow("", "", "", "合計", "", "", "128", "108", "130", "", "131", "132", "133", "", "134", "135", "136", "", "137", "138", "133", "", "", ""));
        panel.getDgTokuteiNyushoshaKaigoServicehi().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgTokuteiNyushoshaKaigoServicehi_Row createTokuteiNyushoshaKaigoServicehiRow(
            String txtService, String txtFutanGendogaku, String txtKettei, String txtMeisaiGokei,
            String txtHiyoTanka, String txtNissu, String txtHiyogaku, String txtSeikyugaku, String txtRiyoshaFutangaku,
            String txtKohi1Nissu, String txtKohi1Futangaku, String txtKohi1Seikyugaku, String txtKohi1HonninFutangaku,
            String txtKohi2Nissu, String txtKohi2Futangaku, String txtKohi2Seikyugaku, String txtKohi2HonninFutangaku,
            String txtKohi3Nissu, String txtKohi3Futangaku, String txtKohi3Seikyugaku, String txtKohi3HonninFutangaku,
            String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgTokuteiNyushoshaKaigoServicehi_Row(
                new RString(txtService), new RString(txtFutanGendogaku), new RString(txtKettei), new RString(txtMeisaiGokei),
                new RString(txtHiyoTanka), new RString(txtNissu), new RString(txtHiyogaku), new RString(txtSeikyugaku), new RString(txtRiyoshaFutangaku),
                new RString(txtKohi1Nissu), new RString(txtKohi1Futangaku), new RString(txtKohi1Seikyugaku), new RString(txtKohi1HonninFutangaku),
                new RString(txtKohi2Nissu), new RString(txtKohi2Futangaku), new RString(txtKohi2Seikyugaku), new RString(txtKohi2HonninFutangaku),
                new RString(txtKohi3Nissu), new RString(txtKohi3Futangaku), new RString(txtKohi3Seikyugaku), new RString(txtKohi3HonninFutangaku),
                new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }
}
