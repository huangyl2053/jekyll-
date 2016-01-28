/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0210001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001.ChoteiboSakuseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 調定簿作成Divです。
 *
 * @author cuilin
 */
public class ChoteiboSakusei {

    public ResponseData<ChoteiboSakuseiDiv> onLoad(ChoteiboSakuseiDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    private ChoteiboSakuseiHandler getHandler(ChoteiboSakuseiDiv div) {
        return ChoteiboSakuseiHandler.of(div);
    }
}
