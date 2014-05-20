/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiKyotsuBtnPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 福祉用具購入費支給申請 (申請を保存するボタンを可能に設定する)パネルです。
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiKyotsuBtnPanel {
    
        public ResponseData<YoguKonyuhiShikyuShinseiKyotsuBtnPanelDiv> onClick_btnAddShinsei(YoguKonyuhiShikyuShinseiKyotsuBtnPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiKyotsuBtnPanelDiv> response = new ResponseData<>();

        panel.getBtnSave().setDisabled(false);
       
        response.data = panel;
        return response;
        }
    
    
}
