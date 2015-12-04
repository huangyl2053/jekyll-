/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5410001;

import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 *
 * @author soft863
 */
public class KojinJokyoShokaiDiv {

    /**
     * 要介護認定個人状況照会Divの初期化を表します。
     *
     * @param div 要介護認定個人状況照会Div
     * @return ResponseData
     */
    public ResponseData onLoad(KojinJokyoShokaiDiv div) {
	ResponseData<KojinJokyoShokaiDiv> response = new ResponseData<>();

	response.data = div;
	return response;
    }

}
