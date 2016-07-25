/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0220002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolistshotokujoho.HanyoListShotokuJohoBatchParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220002.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220002.HanyoListParamHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 画面設計_DBBGM22002_汎用リスト 所得情報のクラス
 *
 * @reamsid_L DBB-1901-010 surun
 */
public class HanyoListParam {

    /**
     * 初期化イベント。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamDiv>
     */
    public ResponseData<HanyoListParamDiv> onLoad(HanyoListParamDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンイベント。
     *
     * @param div HanyoListParamDiv
     * @return ResponseData<HanyoListParamBatchParameter>
     */
    public ResponseData<HanyoListShotokuJohoBatchParameter> onClick_btnExecute(HanyoListParamDiv div) {
        HanyoListShotokuJohoBatchParameter parameter = getHandler(div).onClick_btnExecute();
        return ResponseData.of(parameter).respond();
    }

    private HanyoListParamHandler getHandler(HanyoListParamDiv div) {
        return new HanyoListParamHandler(div);
    }

}
