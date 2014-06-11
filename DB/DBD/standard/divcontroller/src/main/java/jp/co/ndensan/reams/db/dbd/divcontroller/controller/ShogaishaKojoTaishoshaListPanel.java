/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4030011.ShogaishaKojoTaishoshaListPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4030011.dgShogaishaKojoTahishosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 * 障害者控除対象者一覧Divを制御します。
 *
 * @author N3317 塚田 萌
 */
public class ShogaishaKojoTaishoshaListPanel {

    /**
     * ロード時の処理です。
     *
     * @param panel ShogaishaKojoTaishoshaListPanelDiv
     * @return response
     */
    public ResponseData<ShogaishaKojoTaishoshaListPanelDiv> onLoad(ShogaishaKojoTaishoshaListPanelDiv panel) {
        ResponseData<ShogaishaKojoTaishoshaListPanelDiv> response = new ResponseData<>();

        set把握情報(panel);
        set障害者控除対象者List(panel);

        response.data = panel;
        return response;
    }

    private void set把握情報(ShogaishaKojoTaishoshaListPanelDiv panel) {
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4030011/HaakuJoho.yml"));

        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        panel.getTxtKijunDate().setValue(new RDate(cg.getAsRString("基準日").toString()));
        panel.getTxtHaakuCondition().setValue(cg.getAsRString("把握条件"));
        panel.getTxtHaakuDate().setValue(new RDate(cg.getAsRString("把握日").toString()));
    }

    private void set障害者控除対象者List(ShogaishaKojoTaishoshaListPanelDiv panel) {
        panel.getDgShogaishaKojoTahishosha().setDataSource(get障害者控除対象者List());
    }

    private List<dgShogaishaKojoTahishosha_Row> get障害者控除対象者List() {
        List<dgShogaishaKojoTahishosha_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBD.loadAsList(new RString("dbd4030011/ShogaishaKojoTaishoshaList.yml"));
        for (Map info : targetSource) {
            list.add(toDgShogaishaKojoTahishosha_Row(info));
        }
        return list;
    }

    private static dgShogaishaKojoTahishosha_Row toDgShogaishaKojoTahishosha_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);

        dgShogaishaKojoTahishosha_Row row = new dgShogaishaKojoTahishosha_Row(
                cg.getAsRString("被保番号"),
                cg.getAsRString("氏名"),
                cg.getAsRString("認定区分"),
                cg.getAsRString("認定内容"),
                cg.getAsRString("自立度"),
                cg.getAsBooleanValue("has障害者手帳"),
                cg.getAsBooleanValue("is前回非該当"),
                cg.getAsRString("資格喪失事由"),
                cg.getAsRString("資格喪失日"),
                new Button());
        return row;
    }
}
