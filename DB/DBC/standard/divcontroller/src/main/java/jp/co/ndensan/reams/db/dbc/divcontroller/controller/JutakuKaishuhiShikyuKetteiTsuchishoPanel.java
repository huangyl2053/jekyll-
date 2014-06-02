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

        String ymlDataName = "ShinsazumiShikyuShinseiJutakuKaishuhiShikyuKetteiTsuchisho.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        //　発行日の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoHakkoDate().getTxtIssueDate().setValue(new RDate(
                ymlData.get(0).get("issueDate").toString()
        ));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getTxtKozaPaymentDate().setValue(new RDate(
                ymlData.get(0).get("kozaPaymentDate").toString()
        ));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getTxtMadoguchiPaymentDateRange().setFromPlaceHolder(new RString(
                ymlData.get(0).get("fromPlaceHolder").toString()
        ));

        panel.getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod().getTxtMadoguchiPaymentDateRange().setToPlaceHolder(new RString(
                ymlData.get(0).get("toPlaceHolder").toString()
        ));

        //　出力順序・改頁の情の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder()
                .getTxtNewPageItem().setValue(new RString(
                                ymlData.get(0).get("newPageItem").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder()
                .getTxt1().setValue(new RString(
                                ymlData.get(0).get("txt1").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder()
                .getTxt2().setValue(new RString(
                                ymlData.get(0).get("txt2").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder()
                .getTxt3().setValue(new RString(
                                ymlData.get(0).get("txt3").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder()
                .getTxt4().setValue(new RString(
                                ymlData.get(0).get("txt4").toString()
                        ));
        panel.getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder()
                .getTxt5().setValue(new RString(
                                ymlData.get(0).get("txt5").toString()
                        ));
    }

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }
}
