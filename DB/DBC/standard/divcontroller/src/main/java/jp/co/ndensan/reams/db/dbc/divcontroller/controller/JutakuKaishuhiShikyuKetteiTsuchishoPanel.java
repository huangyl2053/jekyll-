/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費支給申請決定 審査済支給申請検索条件
 *
 * @author n8223
 */
public class JutakuKaishuhiShikyuKetteiTsuchishoPanel {

    public ResponseData<JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv> onLoad(JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv panel) {
        ResponseData<JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv> response = new ResponseData<>();

        //TO DO ヘッダーに配置された出力チェックボックスが選択されているかどうかの確認や設定が行えます。
        panel.setIsOpen(false);
        panel.setIsPublish(false);

        setPaymentDateOutputOrderForTsuchisho(panel);
        response.data = panel;
        return response;

    }

    private void setPaymentDateOutputOrderForTsuchisho(JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv panel) {

        String ymlDataName = "ReportPublish.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        //　発行日の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoHakkoDate().getTxtIssueDate().setValue(new RDate(
                ymlData.get(0).get("発行日").toString()
        ));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getTxtKozaPaymentDate().setValue(new RDate(
                ymlData.get(0).get("口座払い日").toString()
        ));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getTxtMadoguchiPaymentDateRange().setFromPlaceHolder(new RString(
                ymlData.get(0).get("窓口払い開始日").toString()
        ));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getTxtMadoguchiPaymentDateRange().setToPlaceHolder(new RString(
                ymlData.get(0).get("窓口払い終了日").toString()
        ));

//        //　出力順序・改頁の情の初期値を設定する。
//        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder().getCcdChohyoShutsuryokujun().getTxtSortName()
//                .setValue(new RString(ymlData.get(0).get("出力順名").toString()));
//        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder().getCcdChohyoShutsuryokujun().getTxtKaiPage()
//                .setValue(new RString(ymlData.get(0).get("改頁").toString()));
//        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder().getCcdChohyoShutsuryokujun().getTxtSort()
//                .setValue(new RString(ymlData.get(0).get("出力順").toString()));
    }

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.DBZ.loadAsList(new RString(ymlDataName));
    }
}
