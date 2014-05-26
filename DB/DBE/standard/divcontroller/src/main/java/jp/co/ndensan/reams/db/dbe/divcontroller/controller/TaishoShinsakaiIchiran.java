/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TaishoShinsakaiIchiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsakaiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査結果入力を行う対象審査会を一覧で表示します。
 *
 * @author N1013 松本直樹
 */
public class TaishoShinsakaiIchiran {

    public ResponseData onLoadData(TaishoShinsakaiIchiranDiv div) {
        ResponseData<TaishoShinsakaiIchiranDiv> response = new ResponseData<>();

        div.getDgShinsakaiIchiran().setDataSource(createRowShinsakaiTestData());
        response.data = div;
        return response;
    }


    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShinsakaiIchiran_Row> createRowShinsakaiTestData() {
        List<dgShinsakaiIchiran_Row> arrayData = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.FOR_DBE.loadAsList(new RString("ShinsakaiIchiranList.yml"));
        for (Map info : targetSource) {
            arrayData.add(toDgShinsakaiIchiran_Row(info));
        }

        return arrayData;
    }

    private dgShinsakaiIchiran_Row toDgShinsakaiIchiran_Row(Map map) {
        RString shinsakai = _toRString(map.get("審査会名"));
        RString gogitai = _toRString(map.get("合議体"));
        RString kaijo = _toRString(map.get("審査会会場"));
        TextBoxFlexibleDate kaisaiDate = toTextBoxFlexibleDate(new FlexibleDate(map.get("開催日").toString()));
        RString startTime = _toRString(map.get("開始時間"));
        RString endTime = _toRString(map.get("終了時間"));
        RString taishoNinzu = _toRString(map.get("対象人数"));
        RString jokyo = _toRString(map.get("状況"));
        Button btn = new Button();
        dgShinsakaiIchiran_Row row = new dgShinsakaiIchiran_Row(btn, shinsakai, gogitai, kaijo, kaisaiDate,
                startTime, endTime, taishoNinzu, jokyo);
        return row;
    }

    private RString _toRString(Object obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RString(obj.toString());
    }

    private TextBoxFlexibleDate toTextBoxFlexibleDate(FlexibleDate date) {
        TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
        txtBox.setValue(date);
        return txtBox;
    }

}
