/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4030011.ShogaishaKojoNinteishoOutputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoChohyoShutsuryokujun.KaigoChohyoShutsuryokujunDiv;
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
public class ShogaishaKojoNinteishoOutput {

    private static final RString YML = new RString("dbd4030011/OutputOrder.yml");

    /**
     * ロード時の処理です。
     *
     * @param panel ShogaishaKojoNinteishoOutputDiv
     * @return response
     */
    public ResponseData<ShogaishaKojoNinteishoOutputDiv> onLoad(ShogaishaKojoNinteishoOutputDiv panel) {
        ResponseData<ShogaishaKojoNinteishoOutputDiv> response = new ResponseData<>();

        setOutputOrder(panel);

        response.data = panel;
        return response;
    }

    private List<HashMap> getYamlData(RString yamlName) {
        return YamlLoader.DBD.loadAsList(yamlName);
    }

    private void setOutputOrder(ShogaishaKojoNinteishoOutputDiv panel) {
        List<HashMap> targetSource = getYamlData(YML);

        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        panel.getPrintContentsSetting().getTxtIssueDate().setValue(new RDate(cg.getAsRString("発行日").toString()));

        cg = new ControlGenerator(targetSource.get(1));
        panel.getOutputOrder().getKaigoChohyoShutsuryokujun().getTxtSortName().setValue(cg.getAsRString("出力順名"));
        panel.getOutputOrder().getKaigoChohyoShutsuryokujun().getTxtKaiPage().setValue(cg.getAsRString("改頁"));
        panel.getOutputOrder().getKaigoChohyoShutsuryokujun().getTxtSort().setValue(cg.getAsRString("出力順"));
    }
}
