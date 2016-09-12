/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hoshushiharaijunbipanel;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbipanel.HoshushiharaiJumbiChousaCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbipanel.HoshushiharaiJumbiIkenCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbipanel.HoshushiharaiJumbiShinsaCsvProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hoshushiharaijunbipanel.HoshushiharaiJumbiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払いデータ作成バッチフロークラスです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
public class HoshushiharaiJumbiFlow extends BatchFlowBase<HoshushiharaiJumbiBatchParameter> {

    private static final String HOSHUSHIHARAIJUMBICHOUSA = "hoshushiharaijumbichousa";
    private static final String HOSHUSHIHARAIJUMBIIKEN = "hoshushiharaijumbiiken";
    private static final String HOSHUSHIHARAIJUMBISHINSA = "hoshushiharaijumbishinsa";

    @Override
    protected void defineFlow() {
        if (new RString("True").equals(getParameter().getSakusedate())) {
            executeStep(HOSHUSHIHARAIJUMBICHOUSA);
        }
        if (new RString("True").equals(getParameter().getChkshujii())) {
            executeStep(HOSHUSHIHARAIJUMBIIKEN);
        }
        if (new RString("True").equals(getParameter().getChkshinsakai())) {
            executeStep(HOSHUSHIHARAIJUMBISHINSA);
        }
    }

    /**
     * 支払いデータ作成のCSV出力Processです。
     *
     * @return 支払いデータ作成
     */
    @Step(HOSHUSHIHARAIJUMBICHOUSA)
    protected IBatchFlowCommand callHoshushiharaiJumbiChousa() {
        return loopBatch(HoshushiharaiJumbiChousaCsvProcess.class)
                .arguments(getParameter().toHoshushiharaiJumbiPanelProcessParamter()).define();
    }

    /**
     * 支払いデータ作成のCSV出力Processです。
     *
     * @return 支払いデータ作成
     */
    @Step(HOSHUSHIHARAIJUMBIIKEN)
    protected IBatchFlowCommand callHoshushiharaiJumbiIken() {
        return loopBatch(HoshushiharaiJumbiIkenCsvProcess.class)
                .arguments(getParameter().toHoshushiharaiJumbiPanelProcessParamter()).define();
    }

    /**
     * 支払いデータ作成のCSV出力Processです。
     *
     * @return 支払いデータ作成
     */
    @Step(HOSHUSHIHARAIJUMBISHINSA)
    protected IBatchFlowCommand callHoshushiharaiJumbiShinsa() {
        return loopBatch(HoshushiharaiJumbiShinsaCsvProcess.class)
                .arguments(getParameter().toHoshushiharaiJumbiPanelProcessParamter()).define();
    }
}
