/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0700011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiRireki.JutakuKaishuhiRirekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiRireki.dgJutakuKaishuRireki_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public class JutakuKaishuhiRireki {

    /**
     * 住宅改修費履歴ダイアログ画面ロード時の処理です。
     *
     * @param panel JutakuKaishuhiRirekiDiv
     * @return response
     */
    public ResponseData<JutakuKaishuhiRirekiDiv> onLoad(JutakuKaishuhiRirekiDiv panel) {
        ResponseData<JutakuKaishuhiRirekiDiv> response = new ResponseData<>();

        set履歴(panel);

        response.data = panel;
        return response;
    }

    private void set履歴(JutakuKaishuhiRirekiDiv panel) {
        panel.getDgJutakuKaishuRireki().setDataSource(get履歴List());

    }

    private List<dgJutakuKaishuRireki_Row> get履歴List() {
        List<dgJutakuKaishuRireki_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("JutakuKaishuhiRirekiList.yml"));
        for (Map info : targetSource) {
            list.add(toDgJutakuKaishuRirekiRow(info));
        }
        return list;
    }

    private static dgJutakuKaishuRireki_Row toDgJutakuKaishuRirekiRow(Map map) {
        ControlGenerator cg = new ControlGenerator(map);

        dgJutakuKaishuRireki_Row row = new dgJutakuKaishuRireki_Row(
                cg.getAsTextBoxDate("提供年月"),
                cg.getAsTextBoxDate("申請日"),
                cg.getAsTextBoxDate("決定日"),
                cg.getAsRString("審査結果"),
                cg.getAsTextBoxNum("費用額合計"),
                cg.getAsTextBoxNum("保険対象費用額"),
                cg.getAsTextBoxNum("保険給付額"),
                cg.getAsTextBoxNum("利用者負担額"),
                cg.getAsBooleanValue("is転居"),
                cg.getAsBooleanValue("is３段階"),
                cg.getAsRString("対象住宅住所"));
        return row;
    }
}
