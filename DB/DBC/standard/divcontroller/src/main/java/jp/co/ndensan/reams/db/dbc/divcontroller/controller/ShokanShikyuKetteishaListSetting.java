/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000.ShokanShikyuKetteishaListSettingDiv;
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
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(3);

        panel.getShokanShikyuKetteishaListPrintSetting().getTxtIssueDate().setValue(new RDate(source.get("発効日").toString()));
    }

    private void setPaymentDate(ShokanShikyuKetteishaListSettingDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(4);

        panel.getShokanShikyuKetteishaListPayDate().getTxtKozaPaymentDate().setValue(new RDate(source.get("口座振替予定日").toString()));
        panel.getShokanShikyuKetteishaListPayDate().getTxtMadoguchiPaymentDateRange().setFromValue(new RDate(source.get("窓口支払い期間開始日").toString()));
        panel.getShokanShikyuKetteishaListPayDate().getTxtMadoguchiPaymentDateRange().setToValue(new RDate(source.get("窓口支払い期間終了日").toString()));
    }

    private void setOutputOrder(ShokanShikyuKetteishaListSettingDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYaml().get(5);

        panel.getShokanShikyuKetteishaListSettingOutputOrder().getTxtSortName().setValue(new RString(source.get("出力順名称").toString()));
        panel.getShokanShikyuKetteishaListSettingOutputOrder().getTxtKaiPage().setValue(new RString(source.get("改頁").toString()));
        panel.getShokanShikyuKetteishaListSettingOutputOrder().getTxtSort().setValue(new RString(source.get("出力順").toString()));
    }

}
