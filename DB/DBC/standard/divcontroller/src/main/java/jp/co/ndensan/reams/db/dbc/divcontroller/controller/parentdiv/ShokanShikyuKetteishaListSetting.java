/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000000.ShokanShikyuKetteishaListSettingDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還支給（不支給）決定通知書一括作成の償還支給（不支給）決定者一覧表のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteishaListSetting {

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private List<HashMap> getShokanShikyuTorokuShomeishoYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc1000000/ShokanShikyuKetteiTsuchishoJoken.yml"));
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteishaListSettingDiv> onLoad(ShokanShikyuKetteishaListSettingDiv panel) {
        ResponseData<ShokanShikyuKetteishaListSettingDiv> response = new ResponseData<>();

        setPrintSetting(panel);
        setPaymentDate(panel);
        setOutputOrder(panel);

        response.data = panel;
        return response;
    }

    private void setPrintSetting(ShokanShikyuKetteishaListSettingDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(INDEX_3);

        panel.getShokanShikyuKetteishaListPrintSetting().getTxtIssueDate().setValue(new RDate(source.get("発効日").toString()));
    }

    private void setPaymentDate(ShokanShikyuKetteishaListSettingDiv panel) {
//        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(INDEX_4);
    }

    private void setOutputOrder(ShokanShikyuKetteishaListSettingDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(INDEX_5);

        panel.getShokanShikyuKetteishaListSettingOutputOrder().getTxtSortName().setValue(new RString(source.get("出力順名称").toString()));
        panel.getShokanShikyuKetteishaListSettingOutputOrder().getTxtKaiPage().setValue(new RString(source.get("改頁").toString()));
        panel.getShokanShikyuKetteishaListSettingOutputOrder().getTxtSort().setValue(new RString(source.get("出力順").toString()));
    }

}
