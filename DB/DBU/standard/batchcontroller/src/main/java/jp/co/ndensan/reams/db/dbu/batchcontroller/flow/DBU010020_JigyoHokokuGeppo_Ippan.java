/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoBirthYMDProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.SyotaiJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.YokaigoNinteishaJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010020.DBU010020_JigyoHokokuGeppo_IppanParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppoippan.JigyouHoukokuTokeiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 事業報告月報_一般状況のバッチフロークラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class DBU010020_JigyoHokokuGeppo_Ippan extends BatchFlowBase<DBU010020_JigyoHokokuGeppo_IppanParameter> {

    private static final FlexibleYearMonth 制度改正月 = new FlexibleYearMonth("200510");
    private static final String 世帯情報処理 = "SyotaiJohoSyori";
    private static final String 被保台帳生年月日情報処理 = "HihokenshaDaichoBirthYMDSyori";
    private static final String 利用者負担減額管理情報処理 = "RiyoshaFutangakuGemmenJohoSyori";
    private static final String 特定入所者管理情報処理 = "TokuteiNyushoshaJohoSyori";
    private static final String 受給者台帳情報処理 = "YokaigoNinteishaJohoSyori";
    private static final String 事業報告統計データへ登録 = "JigyouHoukokuTokeiDataToroku";
    private static final String 介護事業状況報告月報_一般状況 = "JigyoHokokuGeppo_IppanSyuturyoku";
    private DBU010020_JigyoHokokuGeppo_IppanParameter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc,
                new EucEntityId("DBU010020"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        if (PrintControlKubun.過去分の印刷.getコード().equals(parameter.getPrintControlKbn())) {
            executeStep(介護事業状況報告月報_一般状況);
        } else {
//            createTempTable(JigyoHokokuHihokenshaTokeiMotoTempEntity.TABLE_NAME, JigyoHokokuHihokenshaTokeiMotoTempEntity.class);
            executeStep(世帯情報処理);
            executeStep(被保台帳生年月日情報処理);
            executeStep(利用者負担減額管理情報処理);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(特定入所者管理情報処理);
            }
            executeStep(受給者台帳情報処理);
            executeStep(事業報告統計データへ登録);
        }
    }

    /**
     * 世帯情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯情報処理)
    protected IBatchFlowCommand exeSyotaiJohoSyori() {
        return loopBatch(SyotaiJohoSyoriProcess.class)
                .arguments(parameter.toSyotaiJohoSyoriProcessParameter()).define();
    }

    /**
     * 被保台帳生年月日情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保台帳生年月日情報処理)
    protected IBatchFlowCommand exeHihokenshaDaichoBirthYMDSyori() {
        return loopBatch(HihokenshaDaichoBirthYMDProcess.class)
                .arguments(parameter.toHihokenshaDaichoBirthYMDProcessParameter()).define();
    }

    /**
     * 利用者負担減額管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担減額管理情報処理)
    protected IBatchFlowCommand exeRiyoshaFutangakuKanriJohoSyori() {
        return loopBatch(RiyoshaFutangakuKanriJohoSyoriProcess.class)
                .arguments(parameter.toRiyoshaFutangakuKanriJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori() {
        return loopBatch(TokuteiNyushoshaJohoSyoriProcess.class)
                .arguments(parameter.toTokuteiNyushoshaJohoSyoriProcessParameter()).define();
    }

    /**
     * 受給者台帳情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳情報処理)
    protected IBatchFlowCommand exeYokaigoNinteishaJohoSyori() {
        return loopBatch(YokaigoNinteishaJohoSyoriProcess.class)
                .arguments(parameter.toYokaigoNinteishaJohoSyoriProcessParameter()).define();
    }

    /**
     * 事業報告統計データへ登録です。
     *
     * @return IBatchFlowCommand
     */
    @Step(事業報告統計データへ登録)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiDataToroku() {
        JigyouHoukokuTokeiProcessParameter processParameter = parameter.toJigyouHoukokuTokeiProcessParameter();
        processParameter.setManager(manager);
        return loopBatch(JigyouHoukokuTokeiProcess.class).arguments(processParameter).define();
    }
}
