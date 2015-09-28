/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.HonsanteiChohyoHakko2Div;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N8211 田辺 紘一
 */
public class HonsanteiChohyoHakko2 {

    /**
     * onLoad
     *
     * @param div
     * @return ResponseData
     */
    public ResponseData<HonsanteiChohyoHakko2Div> onLoad(HonsanteiChohyoHakko2Div div) {

        return _createResponseData(div);
    }

    private ResponseData<HonsanteiChohyoHakko2Div> _createResponseData(HonsanteiChohyoHakko2Div div) {
        ResponseData<HonsanteiChohyoHakko2Div> response = new ResponseData<>();
        response.data = div;
        return response;
    }
  
    public ResponseData<HonsanteiChohyoHakko2Div> change_txtKetteiTsuchiYousikiSettei(HonsanteiChohyoHakko2Div div) {
        div.getHonTsuchiKobetsuJoho().getTxtKetteiTsuchiYousikiSettei().setValue(new RString("還付対象者、特徴が中止となった被保険者は変更通知書を出力"));
        return _createResponseData(div);
    }    
}
