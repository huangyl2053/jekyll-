/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.JukyuIdoKeikakuRirekiList;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyuIdoKeikakuRirekiList.JukyuIdoKeikakuRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyuIdoKeikakuRirekiList.JukyuIdoKeikakuRirekiListHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBCKD00002_計画履歴一覧です。
 *
 * @reamsid_L DBC-4350-020 liuxiaoyu
 */
public class JukyuIdoKeikakuRirekiList {

    /**
     * 初期化のメソッドです。
     *
     * @param div JukyuIdoKeikakuRirekiListDiv
     * @return ResponseData
     */
    public ResponseData<JukyuIdoKeikakuRirekiListDiv> onLoad(JukyuIdoKeikakuRirekiListDiv div) {

        HihokenshaNo 被保険者番号 = DataPassingConverter.deserialize(div.getHihokenshaNo(), HihokenshaNo.class);
        getHandler(div).onLoad(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * データグリッドの閉じるボタン
     *
     * @param div JukyuIdoKeikakuRirekiListDiv
     * @return ResponseData
     */
    public ResponseData<JukyuIdoKeikakuRirekiListDiv> onClick_btnClose(JukyuIdoKeikakuRirekiListDiv div) {
        return ResponseData.of(div).respond();
    }

    private JukyuIdoKeikakuRirekiListHandler getHandler(JukyuIdoKeikakuRirekiListDiv div) {
        return new JukyuIdoKeikakuRirekiListHandler(div);
    }
}
