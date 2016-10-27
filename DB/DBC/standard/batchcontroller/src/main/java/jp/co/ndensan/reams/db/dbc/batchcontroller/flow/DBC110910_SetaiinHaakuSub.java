/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiShotoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiinHaakuSubBProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiinHaakuSubCProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiinHaakuSubProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiinHaakuSubTempBProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiinHaakuSubTempCProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910.SetaiinHaakuSubTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910.DBC110910_SetaiinHaakuSubParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910.SetaiinHaakuSubTempProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 2_世帯員把握のバッチフロークラスです。
 *
 * @reamsid_L DBC-2770-040 jinjue
 */
public class DBC110910_SetaiinHaakuSub extends BatchFlowBase<DBC110910_SetaiinHaakuSubParameter> {

    private static final String 一時ファイル作成 = "一時ファイル";
    private static final String 住所地特例該当 = "特例該当";
    private static final String 住所地特例該当以外 = "特例該当以外";
    private static final String 住所地特例以外の以外 = "特例以外の以外";
    private static final String 生保区分 = "各住民生保区分";
    private static final String 老齢福祉区分 = "各住民老齢福祉区分";
    private static final String 介護所得 = "各住民介護所得";

    @Override
    protected void defineFlow() {
        executeStep(一時ファイル作成);
        executeStep(住所地特例該当);
        executeStep(住所地特例該当以外);
        executeStep(住所地特例以外の以外);
        executeStep(生保区分);
        executeStep(老齢福祉区分);
        executeStep(介護所得);
    }

    /**
     * 一時ファイルを行います。
     *
     * @return バッチコマンド
     */
    @Step(一時ファイル作成)
    protected IBatchFlowCommand 一時ファイル() {
        return loopBatch(SetaiShotoProcess.class).define();
    }

    /**
     * 世帯員住民の把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(住所地特例該当)
    protected IBatchFlowCommand 特例該当() {
        SetaiinHaakuSubTempProcessParameter parameter = new SetaiinHaakuSubTempProcessParameter(getParameter().get管理識別区分(),
                RString.EMPTY, RString.EMPTY);
        return loopBatch(SetaiinHaakuSubTempProcess.class)
                .arguments(parameter).define();
    }

    /**
     * 世帯員住民の把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(住所地特例該当以外)
    protected IBatchFlowCommand 特例該当以外() {
        SetaiinHaakuSubTempProcessParameter parameter = new SetaiinHaakuSubTempProcessParameter(getParameter().get管理識別区分(),
                RString.EMPTY, RString.EMPTY);
        return loopBatch(SetaiinHaakuSubTempBProcess.class)
                .arguments(parameter).define();
    }

    /**
     * 世帯員住民の把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(住所地特例以外の以外)
    protected IBatchFlowCommand 特例以外の以外() {
        return loopBatch(SetaiinHaakuSubTempCProcess.class).define();
    }

    /**
     * 各住民の所得情報の取得の把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(生保区分)
    protected IBatchFlowCommand 各住民生保区分() {
        return loopBatch(SetaiinHaakuSubProcess.class).define();
    }

    /**
     * 各住民の所得情報の取得の把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(老齢福祉区分)
    protected IBatchFlowCommand 各住民老齢福祉区分() {
        return loopBatch(SetaiinHaakuSubCProcess.class).define();
    }

    /**
     * 各住民の所得情報の取得の把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(介護所得)
    protected IBatchFlowCommand 各住民介護所得() {
        return loopBatch(SetaiinHaakuSubBProcess.class).define();
    }
}
