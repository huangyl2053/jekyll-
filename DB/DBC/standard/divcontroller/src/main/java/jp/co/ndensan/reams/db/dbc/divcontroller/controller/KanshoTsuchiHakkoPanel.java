/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.KanshoTsuchiHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SearchKogakuServicehiPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費照会
 *
 * @author n8223
 */
public class KanshoTsuchiHakkoPanel {

    /**
     * 高額介護サービス費照会 勧奨通知発行の初期表示する。
     *
     * @author n8223
     * @param panel
     * @return 
     */
    public ResponseData<KanshoTsuchiHakkoPanelDiv> onLoad(KanshoTsuchiHakkoPanelDiv panel) {
        ResponseData<KanshoTsuchiHakkoPanelDiv> response = new ResponseData<>();

        setKanshoTsuchiHakko(panel);

        response.data = panel;
        return response;
    }

    private void setKanshoTsuchiHakko(KanshoTsuchiHakkoPanelDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiInfo.yml");
        
        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        panel.getTxtHakkoDate().setValue(ymlDt.getAsRDate("hakkoDate"));

    }

    private List<HashMap> ymlData(String ymlData) {
        return YamlLoader.DBC.loadAsList(new RString(ymlData));
    }
}
