/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0610011;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguShinsaKufugakuSummaryPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費給付額集計パネルです。
 *
 * @author N3317 塚田 萌
 */
public class YoguShinsaKufugakuSummaryPanel {

    /**
     * 申請一覧から編集ボタンを押したときの処理です。
     *
     * @param panel YoguShinsaKufugakuSummaryPanelDiv
     * @param searchPanel YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     * @return response
     */
    public ResponseData<YoguShinsaKufugakuSummaryPanelDiv> onClick_btnModifyShinsei(YoguShinsaKufugakuSummaryPanelDiv panel,
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv searchPanel) {
        ResponseData<YoguShinsaKufugakuSummaryPanelDiv> response = new ResponseData<>();

        setSummary(panel, searchPanel);

        response.data = panel;
        return response;
    }

    private void setSummary(YoguShinsaKufugakuSummaryPanelDiv panel,
            YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv searchPanel) {

        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("dbc0610011/YoguShinseiShinsa.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtHiyoTotalMae().setValue(cg.getAsDecimal("費用額前"));
        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoMae().setValue(cg.getAsDecimal("保険対象額前"));
        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountMae().setValue(cg.getAsDecimal("給付額前"));
        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(cg.getAsDecimal("利用者負担額前"));

        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtHiyoTotalNow().setValue(
                searchPanel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList()
                .getClickedItem().getTxtHiyoTotal().getValue());

        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoNow().setValue(
                searchPanel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().
                getClickedItem().getTxtHokenKyufuAmount().getValue());

        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountNow().setValue(
                searchPanel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().
                getClickedItem().getTxtHokenKyufuAmount().getValue());

        panel.getKyufugakuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(
                searchPanel.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().
                getClickedItem().getTxtRiyoshaFutanAmount().getValue());
    }
}
