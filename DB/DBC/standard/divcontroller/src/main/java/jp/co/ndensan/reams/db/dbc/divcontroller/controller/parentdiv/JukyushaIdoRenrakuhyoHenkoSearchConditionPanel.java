/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 受給者異動連絡票変更登録 検索条件のコントローラークラスです。
 *
 * @author n8156 宮本 康
 */
//TODO n3317塚田　Yamlを使わないように変更
public class JukyushaIdoRenrakuhyoHenkoSearchConditionPanel {

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> onLoad(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {

        setJukyushaIdoRenrakuhyoHenkoSearchCondition(panel);

        return ResponseData.of(panel).respond();
    }

    /**
     * 条件クリア時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv> onClick_btnClearSearchCondition(
            JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        setClearSearchCondition(panel);

        return ResponseData.of(panel).respond();
    }

    private void setJukyushaIdoRenrakuhyoHenkoSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        // TODO 未使用のメソッド引数があります。 Checkstyle対応。
        panel.getBtnClearSearchCondition();
//        ControlGenerator cg = new ControlGenerator(getYmlData().get(0));
//        panel.getTxtIdoDateRange().setFromValue(cg.getAsRDate("異動日開始"));
//        panel.getTxtIdoDateRange().setToValue(cg.getAsRDate("異動日終了"));
//        panel.getTxtSearchHihoNo().setValue(cg.getAsRString("被保番号"));
    }

    private void setClearSearchCondition(JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv panel) {
        panel.getTxtIdoDateRange().clearFromValue();
        panel.getTxtIdoDateRange().clearToValue();
        panel.getTxtSearchHihoNo().clearValue();
    }
}
