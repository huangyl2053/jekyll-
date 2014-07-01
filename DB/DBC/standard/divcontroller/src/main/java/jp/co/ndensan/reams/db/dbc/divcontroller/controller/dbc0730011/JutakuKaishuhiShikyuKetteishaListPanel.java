/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0730011;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiShikyuKetteishaListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8223
 */
public class JutakuKaishuhiShikyuKetteishaListPanel {

    /**
     * 住宅改修費支給申請決定 償還払支給（不支給）決定者一覧表の初期値をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuhiShikyuKetteishaListPanelDiv> onClick_btnSearchShinsazumi(
            JutakuKaishuhiShikyuKetteishaListPanelDiv panel) {
        ResponseData<JutakuKaishuhiShikyuKetteishaListPanelDiv> response = new ResponseData<>();

        //出力順序・改頁の初期値を設定する。
        setHakkoDateOutputOrderForKetteishaList(panel);

        response.data = panel;
        return response;
    }

    private void setHakkoDateOutputOrderForKetteishaList(JutakuKaishuhiShikyuKetteishaListPanelDiv panel) {

        String ymlDataName = "ReportPublish.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        //　発行日の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteishaListHakkoDate().getTxtIssueDate().setValue(RDate.getNowDate());

        //　出力順序・改頁の情の初期値を設定する。
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder().getKaigoChohyoShutsuryokujun().getTxtSortName()
                .setValue(new RString(ymlData.get(0).get("出力順名").toString()));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder().getKaigoChohyoShutsuryokujun().getTxtKaiPage()
                .setValue(new RString(ymlData.get(0).get("改頁").toString()));
        panel.getJutakuKaishuhiShikyuKetteishaListOutputOrder().getKaigoChohyoShutsuryokujun().getTxtSort()
                .setValue(new RString(ymlData.get(0).get("出力順").toString()));
    }

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.DBZ.loadAsList(new RString(ymlDataName));
    }
}
