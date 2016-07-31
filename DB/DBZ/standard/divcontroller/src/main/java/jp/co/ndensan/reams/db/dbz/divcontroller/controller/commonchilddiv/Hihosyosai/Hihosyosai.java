/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.Hihosyosai;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai.HihosyosaiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.Hihosyosai.Hihosyosai.HihosyosaiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 被保詳細のクラス。
 *
 * @reamsid_L DBA-0170-010 linghuhang
 */
public class Hihosyosai {

    /**
     * 所在保険者部品連動処理します。
     *
     * @param div 被保詳細Div
     * @return ResponseData<ShisetsuNyutaishoRirekiKanriDiv>
     */
    public ResponseData<HihosyosaiDiv> onClick_Change(HihosyosaiDiv div) {
        getHandler(div).onClick_Change();
        return ResponseData.of(div).respond();
    }

    private HihosyosaiHandler getHandler(HihosyosaiDiv div) {
        return new HihosyosaiHandler(div);
    }
}
