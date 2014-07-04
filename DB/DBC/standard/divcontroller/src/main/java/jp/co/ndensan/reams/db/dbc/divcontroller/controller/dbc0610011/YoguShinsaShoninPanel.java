/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0610011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaResultDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguShinsaShoninPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public class YoguShinsaShoninPanel {

    /**
     * 申請一覧から修正ボタンを押したときの処理です。
     *
     * @param panel panel
     * @return response
     */
    public ResponseData<YoguShinsaShoninPanelDiv> onClick_btnModifyShinsei(YoguShinsaShoninPanelDiv panel) {
        ResponseData<YoguShinsaShoninPanelDiv> response = new ResponseData<>();

        set承認区分(panel);
        response.data = panel;
        return response;
    }

    private void set承認区分(YoguShinsaShoninPanelDiv div) {
        div.getRadShonin().setSelectedItem(new RString("kyakka"));
    }
}
