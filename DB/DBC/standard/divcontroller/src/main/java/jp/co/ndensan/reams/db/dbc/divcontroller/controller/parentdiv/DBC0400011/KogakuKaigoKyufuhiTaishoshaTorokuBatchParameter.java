/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0400011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020040.DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0400011.KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0400011.KogakuKaigoKyufuhiTaishoshaTorokuHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 高額介護サービス費給付対象者登録のクラスです。
 *
 * @reamsid_L DBC-2010-030 huzongcheng
 */
public class KogakuKaigoKyufuhiTaishoshaTorokuBatchParameter {

    private static final RString 高額介護サービス費給付対象者登録自庁 = new RString("DBCMN41002");
    private static final RString 総合事業高額介護サービス費給付対象者登録自庁 = new RString("DBCMNL1002");
    private static final RString TITLE_ONE = new RString("高額介護サービス費給付対象者登録");
    private static final RString TITLE_TWO = new RString("総合事業高額介護サービス費給付対象者登録");

    /**
     * 初期化のメソッドです。
     *
     * @param div KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv> onLoad(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        RString menuId = ResponseHolder.getMenuID();
        KogakuKaigoKyufuhiTaishoshaTorokuHandler handler = getHandler(div);
        handler.initializeDisplay();
        if (高額介護サービス費給付対象者登録自庁.equals(menuId)) {
            return ResponseData.of(div).rootTitle(TITLE_ONE).respond();
        } else if (総合事業高額介護サービス費給付対象者登録自庁.equals(menuId)) {
            return ResponseData.of(div).rootTitle(TITLE_TWO).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 実行ボタンクリック時のイベントです。
     *
     * @param div KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter> onClick_btnJikko(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        KogakuKaigoKyufuhiTaishoshaTorokuHandler handler = getHandler(div);
        DBC020010_KogakuKaigoServicehiKyufutaishoshaTorokuParameter parameter = handler.getBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private KogakuKaigoKyufuhiTaishoshaTorokuHandler getHandler(KogakuKaigoKyufuhiTaishoshaTorokuBatchParameterDiv div) {
        return KogakuKaigoKyufuhiTaishoshaTorokuHandler.of(div);
    }
}
