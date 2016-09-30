/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0030013;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.DBC0030013StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013.KogakuServicehiShokaiMainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030013.KogakuServicehiShokaiMainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011.KogakuServiceData;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 世帯合算並列表示です。
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class KogakuServicehiShokaiMain {

    /**
     * 画面の初期化メソッドです。
     *
     * @param div KogakuServicehiShokaiMainDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<KogakuServicehiShokaiMainDiv> onLoad(KogakuServicehiShokaiMainDiv div) {
        KogakuServiceData 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.該当者一覧キー, KogakuServiceData.class);
        getHandler(div).load共有子Div(引き継ぎ情報);
        getHandler(div).loadRadioButton();
        return createResponse(div);
    }

    /**
     * 「並べて表示する」ボタンを押下、世帯所得一覧Divから、世帯一覧Gridのマルチ選択された行の情報（list）を取得する。
     *
     * @param div KogakuServicehiShokaiMainDiv
     * @return 世帯合算並列表示画面
     */
    public ResponseData<KogakuServicehiShokaiMainDiv> onClick_Hikaku(KogakuServicehiShokaiMainDiv div) {
        KogakuServiceData 引き継ぎ情報 = ViewStateHolder.get(ViewStateKeys.該当者一覧キー, KogakuServiceData.class);
        getHandler(div).onClick_並べて表示する(引き継ぎ情報);
        return ResponseData.of(div).setState(DBC0030013StateName.並べて表示);
    }

    private KogakuServicehiShokaiMainHandler getHandler(KogakuServicehiShokaiMainDiv div) {
        return new KogakuServicehiShokaiMainHandler(div);
    }

    private ResponseData<KogakuServicehiShokaiMainDiv> createResponse(KogakuServicehiShokaiMainDiv div) {
        return ResponseData.of(div).respond();
    }
}
