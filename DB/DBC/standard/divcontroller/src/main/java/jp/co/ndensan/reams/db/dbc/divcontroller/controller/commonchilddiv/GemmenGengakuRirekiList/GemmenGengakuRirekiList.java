/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.GemmenGengakuRirekiList;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList.GemmenGengakuRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList.GemmenGengakuRirekiListHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * GemmenGengakuRirekiList_減免・減額履歴情報のクラスです。
 *
 * @reamsid_L DBC-4350-030 liuxiaoyu
 */
public class GemmenGengakuRirekiList {

    /**
     * 減免・減額履歴情報画面のonLoadンメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<GemmenGengakuRirekiListDiv> initialize(GemmenGengakuRirekiListDiv div) {
        HihokenshaNo 被保険者番号 = DataPassingConverter.deserialize(div.getHihokenshaNo(), HihokenshaNo.class);
        getHandler(div).onLoad(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 減免・減額履歴情報画面のonCloseンメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<GemmenGengakuRirekiListDiv> onClose(GemmenGengakuRirekiListDiv div) {
        return ResponseData.of(div).respond();
    }

    private GemmenGengakuRirekiListHandler getHandler(GemmenGengakuRirekiListDiv div) {
        return new GemmenGengakuRirekiListHandler(div);
    }
}
