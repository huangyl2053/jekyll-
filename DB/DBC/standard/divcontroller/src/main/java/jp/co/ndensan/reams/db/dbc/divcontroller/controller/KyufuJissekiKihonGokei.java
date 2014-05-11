/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyufuJissekiKihonGokei_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiKihonGokei {

    public ResponseData<KyufuJissekiKihonGokeiDiv> onLoad(KyufuJissekiKihonGokeiDiv panel) {
        ResponseData<KyufuJissekiKihonGokeiDiv> response = new ResponseData<>();
        List<dgKyufuJissekiKihonGokei_Row> list = new ArrayList<>();
        list.add(createKyufuJissekiKihonGokeiRow("保険", "", "1,111", "1,111", "1,111", "1,111", "1,111", "1,111"));
        list.add(createKyufuJissekiKihonGokeiRow("", "後", "2,222", "2,222", "2,222", "2,222", "2,222", "2,222"));
        list.add(createKyufuJissekiKihonGokeiRow("公費１", "", "3,333", "3,333", "3,333", "3,333", "3,333", "3,333"));
        list.add(createKyufuJissekiKihonGokeiRow("", "後", "4,444", "4,444", "4,444", "4,444", "4,444", "4,444"));
        list.add(createKyufuJissekiKihonGokeiRow("公費２", "", "5,555", "5,555", "5,555", "5,555", "5,555", "5,555"));
        list.add(createKyufuJissekiKihonGokeiRow("", "後", "6,666", "6,666", "6,666", "6,666", "6,666", "6,666"));
        list.add(createKyufuJissekiKihonGokeiRow("公費３", "", "7,777", "7,777", "7,777", "7,777", "7,777", "7,777"));
        list.add(createKyufuJissekiKihonGokeiRow("", "後", "8,888", "8,888", "8,888", "8,888", "8,888", "8,888"));
        panel.getDgKyufuJissekiKihonGokei().setDataSource(list);
        response.data = panel;
        return response;
    }

    private dgKyufuJissekiKihonGokei_Row createKyufuJissekiKihonGokeiRow(
            String txtHokenKohi, String txtKettei, String txtServiceTanisu, String txtHokenryoSeikyugaku, String txtRiyoshaFutangaku,
            String txtShisetsuRyoyohi, String txtTokuteiShinryohi, String txtTokuteiNyushoshaKaigo) {
        return new dgKyufuJissekiKihonGokei_Row(
                new RString(txtHokenKohi), new RString(txtKettei), new RString(txtServiceTanisu), new RString(txtHokenryoSeikyugaku), new RString(txtRiyoshaFutangaku),
                new RString(txtShisetsuRyoyohi), new RString(txtTokuteiShinryohi), new RString(txtTokuteiNyushoshaKaigo));
    }

}
