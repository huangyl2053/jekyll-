/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.itizihanteishori;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori.ItziHanteiShoriBatchParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * バッチ設計_DBE309000_一次判定処理のバッチ処理クラスです。
 *
 * @reamsid_L DBE-1470-020 wanghui
 */
public class ItziHanteiShoriFlow extends BatchFlowBase<ItziHanteiShoriBatchParamter> {

    private static final RString ITAKUSAKICHOSAINICHIRAN_FLOWID = new RString("ItakusakiChosainIchiranFlow");
    private static final String ITAKUSAKICHOSAINICHIRAN_FLOW = "IchijiHanteizumIfOutputFlow";
    private static final RString SHINCHOKUDATAOUTPUT_FLOWID = new RString("ShinchokuDataOutputFlow");
    private static final String SHINCHOKUDATAOUTPUT_FLOW = "ShinchokuDataOutputFlow";
    private static final RString バッチ出力区分 = new RString("1");
    private static final RString 一次判定IF取込 = new RString("2");

    @Override
    protected void defineFlow() {
        if (バッチ出力区分.equals(getParameter().getBattishuturyokukubun())) {
            executeStep(SHINCHOKUDATAOUTPUT_FLOW);
        } else if (一次判定IF取込.equals(getParameter().getBattishuturyokukubun())) {
            executeStep(ITAKUSAKICHOSAINICHIRAN_FLOW);
        }
    }

    /**
     * 一次判定IF取込バッチのです。
     *
     * @return ItakusakiChosainIchiranFlow
     */
    @Step(ITAKUSAKICHOSAINICHIRAN_FLOW)
    protected IBatchFlowCommand callNinteiChosaIraiFlow() {
        return otherBatchFlow(ITAKUSAKICHOSAINICHIRAN_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }

    /**
     * 一次判定IF作成のです。
     *
     * @return ShinchokuDataOutputFlow
     */
    @Step(SHINCHOKUDATAOUTPUT_FLOW)
    protected IBatchFlowCommand callShinchokuDataOutputFlow() {
        return otherBatchFlow(SHINCHOKUDATAOUTPUT_FLOWID, SubGyomuCode.DBE認定支援, getParameter()).define();
    }
}
