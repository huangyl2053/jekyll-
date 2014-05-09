/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.JushochiTokureiTaishosaInfoDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例対象者の情報を表示するパネルの、Divコントローラです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiTaishosaInfo {

    public ResponseData onLoad_btnSelectJushochiTokureiTaishosha(JushochiTokureiTaishosaInfoDiv div) {
        ResponseData<JushochiTokureiTaishosaInfo> response = new ResponseData<>();
        div.getAtenaJoho().getTblAtenaSimple().getTxtAtenaKanaMeisho().setValue(new RString("testest"));
        return response;
    }
}
