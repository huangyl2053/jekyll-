/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.KyufuseigenRirekiList;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuseigenRirekiList.KyufuseigenRirekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuseigenRirekiList.KyufuseigenRirekiListHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * KyufuseigenRirekiList_給付制限履歴情報のクラスです。
 *
 * @reamsid_L DBC-4350-050 liuxiaoyu
 */
public class KyufuseigenRirekiList {

    /**
     * 給付制限履歴情報画面のonLoadンメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<KyufuseigenRirekiListDiv> initialize(KyufuseigenRirekiListDiv div) {
        HihokenshaNo 被保険者番号 = DataPassingConverter.deserialize(div.getHihokenshaNo(), HihokenshaNo.class);
        getHandler(div).onLoad(被保険者番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 給付制限履歴情報画面のonCloseンメソッドです。
     *
     * @param div 画面Div
     *
     * @return ResponseData
     */
    public ResponseData<KyufuseigenRirekiListDiv> onClose(KyufuseigenRirekiListDiv div) {
        return ResponseData.of(div).respond();
    }

    private KyufuseigenRirekiListHandler getHandler(KyufuseigenRirekiListDiv div) {
        return new KyufuseigenRirekiListHandler(div);
    }
}
