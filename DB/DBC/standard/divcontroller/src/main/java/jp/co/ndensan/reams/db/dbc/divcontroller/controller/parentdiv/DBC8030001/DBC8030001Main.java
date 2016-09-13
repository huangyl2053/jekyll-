/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8030001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8030001.DBC8030001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8030001.DBC8030001MainHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBC8030001_振込データ媒体書き込みのDivControllerです。
 *
 * @reamsid_L DBC-2180-080 x_liuwei
 */
public class DBC8030001Main {

    /**
     * 画面初期化です。
     *
     * @param div DBC8030001MainDiv
     * @return ResponseData<DBC8030001MainDiv>
     */
    public ResponseData<DBC8030001MainDiv> onLoad(DBC8030001MainDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    private DBC8030001MainHandler getHandler(DBC8030001MainDiv div) {
        return new DBC8030001MainHandler(div);
    }
}
