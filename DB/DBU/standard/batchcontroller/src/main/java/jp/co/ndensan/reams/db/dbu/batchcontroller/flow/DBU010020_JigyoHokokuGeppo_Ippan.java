/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.CreateTempJigyoHokokuHihokenshaTokeiMotoDataProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoBirthYMDProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300001Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300002Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300003Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300004Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300005Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300008Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.SyotaiJohoSyoriKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.SyotaiJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.YokaigoNinteishaJohoKekkaKakuninProcess;
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
    private static final String CREATE事業報告世帯情報TEMPテーブル = "CreateTempTable";
    private static final String 世帯情報処理 = "SyotaiJohoSyori";
    private static final String 被保台帳生年月日情報処理 = "HihokenshaDaichoBirthYMDSyori";
    private static final String 利用者負担減額管理情報処理 = "RiyoshaFutangakuGemmenJohoSyori";
    private static final String 特定入所者管理情報処理 = "TokuteiNyushoshaJohoSyori";
    private static final String 受給者台帳情報処理 = "YokaigoNinteishaJohoSyori";
    private static final String 事業報告統計データへ登録 = "JigyouHoukokuTokeiDataToroku";
    private static final String 介護事業状況報告月報一般状況_別紙 = "JigyoHokokuGeppo_IppanSyuturyoku_DBU300008";
    private static final String 介護事業状況報告月報一般状況_様式1 = "JigyoHokokuGeppo_IppanSyuturyoku_DBU300001";
    private static final String 介護事業状況報告月報一般状況_様式1_2 = "JigyoHokokuGeppo_IppanSyuturyoku_DBU300002";
    private static final String 介護事業状況報告月報一般状況_様式1_3 = "JigyoHokokuGeppo_IppanSyuturyoku_DBU300003";
    private static final String 介護事業状況報告月報一般状況_様式1_4 = "JigyoHokokuGeppo_IppanSyuturyoku_DBU300004";
    private static final String 介護事業状況報告月報一般状況_様式1_5 = "JigyoHokokuGeppo_IppanSyuturyoku_DBU300005";
    private static final String 世帯情報処理の確認リスト = "HihokenshaDaichoSyoriKakuninRisuto";
    private static final String 被保台帳生年月日情報の確認リスト = "IchigoHihokenshaSyoriKakuninRisuto";
    private static final String 利用者負担減額管理情報の確認リスト = "RiyoshaFutangakuGemmenHihokenshaDaichoSyoriKakuninRisuto";
    private static final String 特定入所者管理情報または標準負担額減免情報の確認リスト = "TokuteiNyushoshaGengakuNinteiSyoriKakuninRisuto";
    private static final String 受給者台帳情報の確認リスト = "YokaigoNinteishaSyoriKakuninRisuto";
    private DBU010020_JigyoHokokuGeppo_IppanParameter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId("DBU010020"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        executeStep(CREATE事業報告世帯情報TEMPテーブル);
        if (PrintControlKubun.過去分の印刷.getコード().equals(parameter.getPrintControlKbn())) {
            executeStep(介護事業状況報告月報一般状況_別紙);
            executeStep(介護事業状況報告月報一般状況_様式1);
            executeStep(介護事業状況報告月報一般状況_様式1_2);
            executeStep(介護事業状況報告月報一般状況_様式1_3);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(介護事業状況報告月報一般状況_様式1_4);
            }
            executeStep(介護事業状況報告月報一般状況_様式1_5);
        } else if (PrintControlKubun.集計のみ.getコード().equals(parameter.getPrintControlKbn())) {
            executeStep(世帯情報処理);
            executeStep(被保台帳生年月日情報処理);
            executeStep(利用者負担減額管理情報処理);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(特定入所者管理情報処理);
            }
            executeStep(受給者台帳情報処理);
            executeStep(事業報告統計データへ登録);
            executeStep(世帯情報処理の確認リスト);
            executeStep(被保台帳生年月日情報の確認リスト);
            executeStep(利用者負担減額管理情報の確認リスト);
            executeStep(特定入所者管理情報または標準負担額減免情報の確認リスト);
            executeStep(受給者台帳情報の確認リスト);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(parameter.getPrintControlKbn())) {
            executeStep(世帯情報処理);
            executeStep(被保台帳生年月日情報処理);
            executeStep(利用者負担減額管理情報処理);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(特定入所者管理情報処理);
            }
            executeStep(受給者台帳情報処理);
            executeStep(事業報告統計データへ登録);
            executeStep(介護事業状況報告月報一般状況_別紙);
            executeStep(介護事業状況報告月報一般状況_様式1);
            executeStep(介護事業状況報告月報一般状況_様式1_2);
            executeStep(介護事業状況報告月報一般状況_様式1_3);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(介護事業状況報告月報一般状況_様式1_4);
            }
            executeStep(介護事業状況報告月報一般状況_様式1_5);
            executeStep(世帯情報処理の確認リスト);
            executeStep(被保台帳生年月日情報の確認リスト);
            executeStep(利用者負担減額管理情報の確認リスト);
            executeStep(特定入所者管理情報または標準負担額減免情報の確認リスト);
            executeStep(受給者台帳情報の確認リスト);
        }
    }

    /**
     * 事業報告世帯情報TEMPテーブルを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CREATE事業報告世帯情報TEMPテーブル)
    protected IBatchFlowCommand createTempJigyoHokokuHihokenshaTokeiMotoData() {
        return simpleBatch(CreateTempJigyoHokokuHihokenshaTokeiMotoDataProcess.class).define();
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

    /**
     * 介護事業状況報告月報・一般状況（別紙）帳票出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護事業状況報告月報一般状況_別紙)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiReportDBU300008() {
        return loopBatch(JigyouHoukokuTokeiReportDBU300008Process.class)
                .arguments(parameter.toJigyoHokokuGeppoIppanReportProcessParameter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（様式1）帳票出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護事業状況報告月報一般状況_様式1)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiReportDBU300001() {
        return loopBatch(JigyouHoukokuTokeiReportDBU300001Process.class)
                .arguments(parameter.toJigyoHokokuGeppoIppanReportProcessParameter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（様式1-2）帳票出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護事業状況報告月報一般状況_様式1_2)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiReportDBU300002() {
        return loopBatch(JigyouHoukokuTokeiReportDBU300002Process.class)
                .arguments(parameter.toJigyoHokokuGeppoIppanReportProcessParameter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（様式1-3）帳票出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護事業状況報告月報一般状況_様式1_3)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiReportDBU300003() {
        return loopBatch(JigyouHoukokuTokeiReportDBU300003Process.class)
                .arguments(parameter.toJigyoHokokuGeppoIppanReportProcessParameter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（様式1-4）帳票出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護事業状況報告月報一般状況_様式1_4)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiReportDBU300004() {
        return loopBatch(JigyouHoukokuTokeiReportDBU300004Process.class)
                .arguments(parameter.toJigyoHokokuGeppoIppanReportProcessParameter()).define();
    }

    /**
     * 介護事業状況報告月報・一般状況（様式1-4）帳票出力します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護事業状況報告月報一般状況_様式1_5)
    protected IBatchFlowCommand exeJigyouHoukokuTokeiReportDBU300005() {
        return loopBatch(JigyouHoukokuTokeiReportDBU300005Process.class)
                .arguments(parameter.toJigyoHokokuGeppoIppanReportProcessParameter()).define();
    }

    /**
     * 世帯情報処理の確認リスト取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(世帯情報処理の確認リスト)
    protected IBatchFlowCommand exeSyotaiJohoSyoriKekkaKakunin() {
        return loopBatch(SyotaiJohoSyoriKekkaKakuninProcess.class)
                .arguments(parameter.toJigyoHokokuGeppoShoriKekkaKakuninListProcessParameter()).define();
    }

    /**
     * 被保台帳生年月日情報の確認リスト取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保台帳生年月日情報の確認リスト)
    protected IBatchFlowCommand exeHihokenshaDaichoKekkaKakunin() {
        return loopBatch(HihokenshaDaichoKekkaKakuninProcess.class)
                .arguments(parameter.toJigyoHokokuGeppoShoriKekkaKakuninListProcessParameter()).define();
    }

    /**
     * 利用者負担減額管理情報の確認リスト取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担減額管理情報の確認リスト)
    protected IBatchFlowCommand exeRiyoshaFutangakuKanriJohoKekkaKakunin() {
        return loopBatch(RiyoshaFutangakuKanriJohoKekkaKakuninProcess.class)
                .arguments(parameter.toJigyoHokokuGeppoShoriKekkaKakuninListProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報または標準負担額減免情報の確認リスト取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報または標準負担額減免情報の確認リスト)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoKekkaKakunin() {
        return loopBatch(TokuteiNyushoshaJohoKekkaKakuninProcess.class)
                .arguments(parameter.toJigyoHokokuGeppoShoriKekkaKakuninListProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報または標準負担額減免情報の確認リスト取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳情報の確認リスト)
    protected IBatchFlowCommand exeYokaigoNinteishaJohoKekkaKakunin() {
        return loopBatch(YokaigoNinteishaJohoKekkaKakuninProcess.class)
                .arguments(parameter.toJigyoHokokuGeppoShoriKekkaKakuninListProcessParameter()).define();
    }
}
