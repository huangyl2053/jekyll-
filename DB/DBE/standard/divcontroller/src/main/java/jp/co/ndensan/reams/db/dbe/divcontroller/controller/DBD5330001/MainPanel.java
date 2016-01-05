/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.DBD5330001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBD5330001.MainPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 要介護認定結果通知（主治医）Divを制御クラスです。
 *
 */
public class MainPanel {

    /**
     * 要介護認定結果通知（主治医）の初期処理を表示します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onLoad(MainPanelDiv div) {
        div.getCcdShujiiIryokikanAndShujiiInput().setReadOnly(false);
        return  ResponseData.of(div).respond();
    }

    /**
     * 要介護認定結果通知（主治医）の「検索」ボタンが押下します。
     *
     * @param div MainPanelDiv
     * @return ResponseData
     */
    public ResponseData<MainPanelDiv> onClick_btnSearch(MainPanelDiv div) {
        getHandler(div).二次判定期間の前後順チェック();
        return  ResponseData.of(div).respond();
    }
    
    
    
   

    private MainPanelHandler getHandler(MainPanelDiv div) {
        return new MainPanelHandler(div);
    }
}
