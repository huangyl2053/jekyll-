/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0220011.JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者異動連絡票変更登録 検索条件のコントローラークラスです。
 *
 * @author n8156 宮本 康
 */
public class JukyushaIdoRenrakuhyoHenkoSearchConditionPanel {

    private static final RString YML_NAME = new RString("dbc0220011/JukyushaIdoRenrakuhyoHenko.yml");

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> onLoad(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> response = new ResponseData<>();

        setJukyushaIdoRenrakuhyoHenkoSearchCondition(panel);

        response.data = panel;
        return response;
    }

    /**
     * 条件クリア時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> onClick_btnClearSearchCondition(
            JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> response = new ResponseData<>();

        setClearSearchCondition(panel);

        response.data = panel;
        return response;
    }

    private void setJukyushaIdoRenrakuhyoHenkoSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        HashMap map = getYmlData().get(0);
        panel.getTxtIdoDateRange().setFromValue(new RDate(map.get("異動日開始").toString()));
        panel.getTxtIdoDateRange().setToValue(new RDate(map.get("異動日終了").toString()));
        panel.getTxtSearchHihoNo().setValue(new RString(map.get("被保番号").toString()));
    }

    private void setClearSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        panel.getTxtIdoDateRange().clearFromValue();
        panel.getTxtIdoDateRange().clearToValue();
        panel.getTxtSearchHihoNo().clearValue();
    }

    private List<HashMap> getYmlData() {
        return YamlLoader.DBC.loadAsList(YML_NAME);
    }
}
