/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0030012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030012.KogakuServicehiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030012.KogakuServicehiInfoPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のControllerです。
 *
 * @reamsid_L DBC-3000-030 gongliang
 */
public class KogakuServicehiInfoPanel {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuServicehiInfoPanelDiv
     * @return 画面設計_DBCMN11004_高額介護サービス費照会画面
     */
    public ResponseData<KogakuServicehiInfoPanelDiv> onLoad(KogakuServicehiInfoPanelDiv div) {
        KogakuServiceData 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.該当者一覧キー, KogakuServiceData.class);
        getHandler(div).load共有子Div(引き継ぎ情報);
        return createResponse(div);
    }

    private KogakuServicehiInfoPanelHandler getHandler(KogakuServicehiInfoPanelDiv div) {
        return new KogakuServicehiInfoPanelHandler(div);
    }

    private ResponseData<KogakuServicehiInfoPanelDiv> createResponse(KogakuServicehiInfoPanelDiv div) {
        return ResponseData.of(div).respond();
    }
}
