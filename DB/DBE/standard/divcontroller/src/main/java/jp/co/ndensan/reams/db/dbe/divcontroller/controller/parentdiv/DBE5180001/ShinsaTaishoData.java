/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5180001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsataishodataoutput.ShinsaTaishoDataOutPutBatchParammeter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5180001.ShinsaTaishoDataDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5180001.ShinsaTaishoDataValidationHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会審査対象データ出力（モバイル）クラスです。
 *
 * @reamsid_L DBE-1840-010 yaoyahui
 */
public class ShinsaTaishoData {

    private static final RString モード = new RString("dataShutsuryoku");

    /**
     * 介護認定審査会審査対象データ出力（モバイル）Divを初期化します。
     *
     * @param div 介護認定審査会審査対象データ出力（モバイル）Div
     * @return ResponseData<ShinsaTaishoDataDiv> 介護認定審査会審査対象データ出力（モバイル）Div
     */
    public ResponseData<ShinsaTaishoDataDiv> onLoad(ShinsaTaishoDataDiv div) {
        div.getCcdShinsakaiIchiranList().initialize(モード);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会データ空チェックを実施します。
     *
     * @param div 介護認定審査会審査対象データ出力（モバイル）Div
     * @return ResponseData<ShinsaTaishoDataDiv>
     */
    public ResponseData<ShinsaTaishoDataDiv> onClick_Check(ShinsaTaishoDataDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).データの選択チェック();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * パラメーターを作成します。
     *
     * @param div バッチパラメータ情報Div
     * @return ResponseData<ShinsaTaishoDataOutPutBatchParammeter>
     */
    public ResponseData<ShinsaTaishoDataOutPutBatchParammeter> onClick_btnAction(ShinsaTaishoDataDiv div) {
        ShinsaTaishoDataOutPutBatchParammeter parameter = new ShinsaTaishoDataOutPutBatchParammeter();
        parameter.setKaisaiBangou(div.getCcdShinsakaiIchiranList().get開催番号List().get(0));
        return ResponseData.of(parameter).respond();
    }

    private ShinsaTaishoDataValidationHandler getValidationHandler(ShinsaTaishoDataDiv div) {
        return new ShinsaTaishoDataValidationHandler(div);
    }
}
