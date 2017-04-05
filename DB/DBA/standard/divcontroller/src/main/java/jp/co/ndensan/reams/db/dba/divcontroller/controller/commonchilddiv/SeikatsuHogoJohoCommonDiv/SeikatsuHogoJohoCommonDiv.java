/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.commonchilddiv.SeikatsuHogoJohoCommonDiv;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv.SeikatsuHogoJohoCommonDivDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.commonchilddiv.seikatsuhogojoho.SeikatsuHogoJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author n8407
 */
public class SeikatsuHogoJohoCommonDiv {

    /**
     * ダイアログを開いた際の初期化処理を行います。
     *
     * @param div 医療保険履歴DialogDiv
     * @return レスポンスデータ
     */
    public ResponseData<SeikatsuHogoJohoCommonDivDiv> onLoad(SeikatsuHogoJohoCommonDivDiv div) {
        getHandler(div).load();

        return ResponseData.of(div).respond();
    }

    
    
    /**
     * 閉じるBTNをクリックした際の処理です。
     *
     * @param div 医療保険履歴DialogDiv
     * @return レスポンスデータ
     */
    public ResponseData<SeikatsuHogoJohoCommonDivDiv> onClick_btnClose(SeikatsuHogoJohoCommonDivDiv div) {

        return ResponseData.of(div).respond();
    }

    private SeikatsuHogoJohoHandler getHandler(SeikatsuHogoJohoCommonDivDiv div) {
        return new SeikatsuHogoJohoHandler(div);
    }

}
