/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1310001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001.JukyushaDaichoPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public class JukyushaDaichoPanel {

    /**
     * 汎用リスト出力(受給者台帳)画面の初期化。
     *
     * @param div ドメインオブジェクトを取り出したい {@link HanyoListParamDiv}
     *
     * @return ResponseData<JukyushaDaichoPanelDiv>
     */
    public ResponseData<JukyushaDaichoPanelDiv> onLoad(JukyushaDaichoPanelDiv div) {
        getHandler(div).onLoad(ResponseHolder.getMenuID());
        return ResponseData.of(div).respond();
    }
}
