/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0230011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0230011.IdoReanrakuhyoEraTeiseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0230011.IdoReanrakuhyoEraTeiseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * IdoReanrakuhyoEraTeisei_1_受給者異動連絡票エラー訂正のクラスです。
 *
 * @reamsid_L DBC-2720-010 liuxiaoyu
 */
public class IdoReanrakuhyoEraTeisei {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData<IdoReanrakuhyoEraTeiseiDiv>
     */
    public ResponseData<IdoReanrakuhyoEraTeiseiDiv> onLoad(IdoReanrakuhyoEraTeiseiDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    private IdoReanrakuhyoEraTeiseiHandler getHandler(IdoReanrakuhyoEraTeiseiDiv div) {
        return IdoReanrakuhyoEraTeiseiHandler.of(div);
    }
}
