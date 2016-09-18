/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110130.HokenshaKyufujissekiOutListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc110810.SouhuFilesakuseiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110810.DBC110810_JukyushaTotsugoIraiOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujissekiout.HokenshaKyufujissekiOutListSakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者突合依頼情報作成のバッチ処理フロー
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
public class DBC110810_JukyushaTotsugoIraiOut extends BatchFlowBase<DBC110810_JukyushaTotsugoIraiOutParameter> {

    private static final String SOUHUFILESAKUSEI_PROCESS = "SouhuFilesakuseiProcess";
    private static final String 処理結果リスト作成 = "doShoriKekkaListSakusei";

    @Override
    protected void defineFlow() {
        executeStep(SOUHUFILESAKUSEI_PROCESS);
        boolean hasError = getResult(Boolean.class, new RString(SOUHUFILESAKUSEI_PROCESS), SouhuFilesakuseiProcess.HAS_ERROR);
        if (hasError) {
            executeStep(処理結果リスト作成);
        }

    }

    /**
     * 送付ファイル作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(SOUHUFILESAKUSEI_PROCESS)
    protected IBatchFlowCommand createShinsainShiharaiMeisaishoData() {
        return loopBatch(SouhuFilesakuseiProcess.class).arguments(
                getParameter().toJukyushaTotsugoIraiOutProcessParameter()).define();
    }

    /**
     * 処理結果リスト作成です。
     *
     * @return HokenshaKyufujissekiOutListSakuseiProcess
     */
    @Step(処理結果リスト作成)
    protected IBatchFlowCommand doShoriKekkaListSakusei() {
        HokenshaKyufujissekiOutListSakuseiProcessParameter parameter
                = new HokenshaKyufujissekiOutListSakuseiProcessParameter();
        parameter.setエラーリストタイプ(KokuhorenJoho_SakuseiErrorListType.リストタイプ0);
        return loopBatch(HokenshaKyufujissekiOutListSakuseiProcess.class).arguments(parameter).define();
    }

}
