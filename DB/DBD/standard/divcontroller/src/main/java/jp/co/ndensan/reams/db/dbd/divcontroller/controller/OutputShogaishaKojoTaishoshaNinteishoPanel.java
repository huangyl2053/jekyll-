/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4030011.OutputShogaishaKojoTaishoshaNinteishoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障害者控除対象者認定書の出力設定パネルの制御をします。
 *
 * @author N3317 塚田 萌
 */
public class OutputShogaishaKojoTaishoshaNinteishoPanel {

    /**
     * ロード時の処理です。
     *
     * @param panel OutputShogaishaKojoTaishoshaNinteishoPanelDiv
     * @return response
     */
    public ResponseData<OutputShogaishaKojoTaishoshaNinteishoPanelDiv> onLoad(OutputShogaishaKojoTaishoshaNinteishoPanelDiv panel) {
        ResponseData<OutputShogaishaKojoTaishoshaNinteishoPanelDiv> response = new ResponseData<>();

        setOutputOrder(panel);

        response.data = panel;
        return response;
    }

    private void setOutputOrder(OutputShogaishaKojoTaishoshaNinteishoPanelDiv panel) {
        List<HashMap> targetSource = YamlLoader.FOR_DBD.loadAsList(new RString("OutputOrder.yml"));

        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        panel.getPrintContentsSetting().getTxtIssueDate().setValue(new RDate(cg.getAsRString("発行日").toString()));

        cg = new ControlGenerator(targetSource.get(1));
        panel.getOutputOrder().getTxtSortName().setValue(cg.getAsRString("出力順名"));
        panel.getOutputOrder().getTxtKaiPage().setValue(cg.getAsRString("改頁"));
        panel.getOutputOrder().getTxtSort().setValue(cg.getAsRString("出力順"));
    }
}
