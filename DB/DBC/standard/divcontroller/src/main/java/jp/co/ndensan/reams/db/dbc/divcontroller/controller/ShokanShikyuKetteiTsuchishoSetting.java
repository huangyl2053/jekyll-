/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000.ShokanShikyuKetteiTsuchishoSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還支給（不支給）決定通知書一括作成の償還支給（不支給）決定通知書のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiTsuchishoSetting {

    private List<HashMap> getShokanShikyuTorokuShomeishoYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc1000000/ShokanShikyuKetteiTsuchishoJoken.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiTsuchishoSettingDiv> onLoad(ShokanShikyuKetteiTsuchishoSettingDiv panel) {
        ResponseData<ShokanShikyuKetteiTsuchishoSettingDiv> response = new ResponseData<>();

        setPrintSetting(panel);
        setOutputOrder(panel);

        response.data = panel;
        return response;
    }

    private void setPrintSetting(ShokanShikyuKetteiTsuchishoSettingDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(1);

        panel.getShokanShikyuKetteiTsuchishoPrintSetting().getTxtIssueDate().setValue(new RDate(source.get("発効日").toString()));
    }

    private void setOutputOrder(ShokanShikyuKetteiTsuchishoSettingDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(2);

        panel.getShokanShikyuKetteiTsuchishoSettingOuputOrder().getTxtSortName().setValue(new RString(source.get("出力順名称").toString()));
        panel.getShokanShikyuKetteiTsuchishoSettingOuputOrder().getTxtKaiPage().setValue(new RString(source.get("改頁").toString()));
        panel.getShokanShikyuKetteiTsuchishoSettingOuputOrder().getTxtSort().setValue(new RString(source.get("出力順").toString()));
    }
}
