/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.CommonButtonAreaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n8223
 */
public class CommonButtonArea {
        
        public ResponseData<CommonButtonAreaDiv> onClick_btnIkkatsuShinsa(CommonButtonAreaDiv panel) {
        ResponseData<CommonButtonAreaDiv> response = new ResponseData<>();

        panel.getBtnSaveShinsaContents().setDisabled(false);
       
        response.data = panel;
        return response;
        }
    
}
