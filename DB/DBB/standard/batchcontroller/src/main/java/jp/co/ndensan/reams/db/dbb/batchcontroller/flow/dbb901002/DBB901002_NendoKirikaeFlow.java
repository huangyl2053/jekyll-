/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb901002;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002.InsetDbT2001ChoshuHohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002.InsetDbT7022ShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002.UpdateDbT7022ShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002.UpdateUzT0001StandardConfigProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nendokirikae.NendoKirikaeBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 年度切替バッチのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class DBB901002_NendoKirikaeFlow extends BatchFlowBase<NendoKirikaeBatchParameter> {

    private static final String 処理日付管理マスタ年度切替 = "inset処理日付管理マスタ";
    private static final String 徴収方法マスタ年度切替 = "inset徴収方法マスタ";
    private static final String 業務コンフィグ年度切替 = "update業務コンフィグ";
    private static final String 処理日付管理マスタ更新 = "update処理日付管理マスタ";

    @Override
    protected void defineFlow() {
        executeStep(処理日付管理マスタ年度切替);
        executeStep(徴収方法マスタ年度切替);
        executeStep(業務コンフィグ年度切替);
        executeStep(処理日付管理マスタ更新);
    }

    /**
     * 処理日付管理マスタ年度切替
     *
     * @return InsetDbT7022ShoriDateKanriProcess
     */
    @Step(処理日付管理マスタ年度切替)
    protected IBatchFlowCommand insetDbT7022ShoriDateKanriProcess() {
        return loopBatch(InsetDbT7022ShoriDateKanriProcess.class).
                arguments(createProcessParameter()).define();
    }

    /**
     * 徴収方法マスタ年度切替
     *
     * @return InsetDbT2001ChoshuHohoProcess
     */
    @Step(徴収方法マスタ年度切替)
    protected IBatchFlowCommand insetDbT2001ChoshuHohoProcess() {
        return loopBatch(InsetDbT2001ChoshuHohoProcess.class).
                arguments(createProcessParameter()).define();
    }

    /**
     * 業務コンフィグ年度切替
     *
     * @return UpdateUzT0001StandardConfigProcess
     */
    @Step(業務コンフィグ年度切替)
    protected IBatchFlowCommand updateUzT0001StandardConfigProcess() {
        return loopBatch(UpdateUzT0001StandardConfigProcess.class)
                .arguments(createProcessParameter()).define();
    }

    /**
     * 処理日付管理マスタ更新
     *
     * @return UpdateDbT7022ShoriDateKanriProcess
     */
    @Step(処理日付管理マスタ更新)
    protected IBatchFlowCommand updateDbT7022ShoriDateKanriProcess() {
        return loopBatch(UpdateDbT7022ShoriDateKanriProcess.class).
                arguments(createProcessParameter()).define();
    }

    private NendoKirikaeProcessParameter createProcessParameter() {
        NendoKirikaeProcessParameter parameter = new NendoKirikaeProcessParameter();
        parameter.set調定年度(getParameter().get調定年度());
        return parameter;
    }

}
