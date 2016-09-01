/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.SyotaiJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010020.DBU010020_JigyoHokokuGeppo_IppanParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan.JigyoHokokuHihokenshaTokeiMotoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 事業報告月報_一般状況のバッチフロークラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class DBU010020_JigyoHokokuGeppo_Ippan extends BatchFlowBase<DBU010020_JigyoHokokuGeppo_IppanParameter> {

    private static final String 世帯情報処理 = "SyotaiJohoSyori";
//    private static final String 被保台帳生年月日情報処理 = "HihokenshaDaichoBirthYMDSyori";

    @Override
    protected void defineFlow() {
//        if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getPrintControlKbn())) {
//
//        } else {
        createTempTable(JigyoHokokuHihokenshaTokeiMotoTempEntity.TABLE_NAME, JigyoHokokuHihokenshaTokeiMotoTempEntity.class);
        executeStep(世帯情報処理);
//            executeStep(被保台帳生年月日情報処理);
//        }
    }

    /**
     * 世帯情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯情報処理)
    protected IBatchFlowCommand exeSyotaiJohoSyori() {
        return loopBatch(SyotaiJohoSyoriProcess.class)
                .arguments(getParameter().toSyotaiJohoSyoriProcessParameter()).define();
    }
//
//    /**
//     * 世帯情報処理です。
//     *
//     * @return IBatchFlowCommand
//     */
//    @Step(被保台帳生年月日情報処理)
//    protected IBatchFlowCommand exeHihokenshaDaichoBirthYMDSyori() {
//        return loopBatch(HihokenshaDaichoBirthYMDProcess.class)
//                .arguments(getParameter().toSyotaiJohoSyoriProcessParameter()).define();
//    }
}
