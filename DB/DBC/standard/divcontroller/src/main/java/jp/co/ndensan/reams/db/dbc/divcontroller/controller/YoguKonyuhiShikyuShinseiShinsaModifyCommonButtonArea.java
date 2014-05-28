/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsaModifyCommonButtonAreaDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiShinsaModifyCommonButtonArea {
        
        public ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyCommonButtonAreaDiv> onClick_btnIkkatsuShinsa(YoguKonyuhiShikyuShinseiShinsaModifyCommonButtonAreaDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyCommonButtonAreaDiv> response = new ResponseData<>();

        panel.getBtnSaveShinsaContents().setDisabled(false);
       
       
        response.data = panel;
        return response;
        }
    
}
