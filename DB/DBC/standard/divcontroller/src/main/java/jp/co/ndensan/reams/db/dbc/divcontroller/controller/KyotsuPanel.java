/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotsuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShinsazumiShikyuShinseiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShinsazumiShikyuShinsei_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 *
 * @author n8223
 */
public class KyotsuPanel {
        /**
     * 住宅改修費支給申請決定 審査済支給申請一覧の選択されたが一つでもあれば、審査内容を保存するボタンを表示する。ない場合に審査内容を保存するボタンを非表示する
     *
     * @param panel JutakuKaishuShinseiListDiv
     * @param panel1
     * @return PanelDivのResponseData
     */
    public ResponseData<KyotsuPanelDiv> onSelect_OnClick(KyotsuPanelDiv panel,  ShinsazumiShikyuShinseiListPanelDiv panel1) {
        ResponseData<KyotsuPanelDiv> response = new ResponseData<>();

        //TO DO 
        setbtnSaveDisabled(panel,panel1);

        response.data = panel;
        return response;

    }

    private void setbtnSaveDisabled(KyotsuPanelDiv panel,ShinsazumiShikyuShinseiListPanelDiv panel1) {

        List<dgShinsazumiShikyuShinsei_Row> arraydata = panel1.getDgShinsazumiShikyuShinsei().getDataSource();
        
        int chk = 1;
        for (int i = 0; i < arraydata.size(); i++) {
           
            if(arraydata.get(i).getSelected().equals(true)) {
              chk = 0;  
            }  
        }
        
        if(chk == 0 ) {
            panel.getBtnSave().setDisabled(false);
        }else {
            panel.getBtnSave().setDisabled(true);
        }
    }
}
