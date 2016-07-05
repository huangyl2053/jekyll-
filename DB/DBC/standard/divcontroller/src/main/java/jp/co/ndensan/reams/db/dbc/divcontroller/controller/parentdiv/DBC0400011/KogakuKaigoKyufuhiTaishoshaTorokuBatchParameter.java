/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0400011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0400011.KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0400011.KogakuKaigoKyufuhiTaishoshaTorokuHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 高額介護サービス費給付対象者登録のクラスです。
 *
 * @reamsid_L DBC-2010-030 huzongcheng
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuBatchParameter {

    /**
     * 初期化のメソッドです。
     *
     * @param div KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv> onLoad(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        KogakuKaigoKyufuhiTaishoshaTorokuHandler handler = getHandler(div);
        handler.initializeDisplay();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンクリック時のイベントです。
     *
     * @param div KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv> onClick_btnJikko(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        //TODO
        return ResponseData.of(div).respond();
    }

    private KogakuKaigoKyufuhiTaishoshaTorokuHandler getHandler(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        return KogakuKaigoKyufuhiTaishoshaTorokuHandler.of(div);
    }
}
