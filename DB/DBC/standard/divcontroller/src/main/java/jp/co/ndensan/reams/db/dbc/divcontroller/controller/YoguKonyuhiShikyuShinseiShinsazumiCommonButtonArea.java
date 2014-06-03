/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsazumiCommonButtonAreaDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiShinsazumiCommonButtonArea {
    
        public ResponseData<YoguKonyuhiShikyuShinseiShinsazumiCommonButtonAreaDiv> onClick_btnIkkatsuShinsa(YoguKonyuhiShikyuShinseiShinsazumiCommonButtonAreaDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsazumiCommonButtonAreaDiv> response = new ResponseData<>();

        panel.getBtnIkkatsuKetteiSave().setDisabled(false);
       
       
        response.data = panel;
        return response;
        }
    
    
}
