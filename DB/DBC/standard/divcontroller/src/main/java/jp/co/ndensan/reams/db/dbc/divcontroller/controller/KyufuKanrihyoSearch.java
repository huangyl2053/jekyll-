/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0060000.KyufuKanrihyoSearchDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票情報照会の検索Panelのコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyufuKanrihyoSearch {

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0060000/KyufuKanrihyoSearch.yml"));
    }

    /**
     * 画面ロード時の処理。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(KyufuKanrihyoSearchDiv panel) {
        ResponseData<KyufuKanrihyoSearchDiv> response = new ResponseData<>();
        setDemoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * クリアボタン押下時の処理。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickClear(KyufuKanrihyoSearchDiv panel) {
        ResponseData<KyufuKanrihyoSearchDiv> response = new ResponseData<>();
        initSearchData(panel);
        response.data = panel;
        return response;
    }

    private void setDemoData(KyufuKanrihyoSearchDiv panel) {
        ControlGenerator cg = new ControlGenerator(getYaml().get(0));
        panel.getTxtHihokenshaNo().setValue(cg.getAsRString("保険者番号"));
        panel.getTxtHihokenshaName().setValue(cg.getAsRString("保険者名"));
        panel.getTxtJigyoshaNo().setValue(cg.getAsRString("事業者番号"));
        panel.getTxtJigyoshaName().setValue(cg.getAsRString("事業者名"));
        panel.getTxtSearchKyufuTaishoKikan().setFromValue(cg.getAsRDate("給付対象期間開始"));
        panel.getTxtSearchKyufuTaishoKikan().setToValue(cg.getAsRDate("給付対象期間終了"));
    }

    private void initSearchData(KyufuKanrihyoSearchDiv panel) {
        panel.getTxtHihokenshaNo().clearValue();
        panel.getTxtHihokenshaName().clearValue();
        panel.getTxtJigyoshaNo().clearValue();
        panel.getTxtJigyoshaName().clearValue();
        panel.getTxtSearchKyufuTaishoKikan().clearFromValue();
        panel.getTxtSearchKyufuTaishoKikan().clearToValue();
    }
}
