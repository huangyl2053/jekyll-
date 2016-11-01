/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.CreateTempJigyoHokokuHihokenshaTokeiMotoDataProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoBirthYMD0200Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoBirthYMD0301Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoBirthYMD0302Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.HihokenshaDaichoKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300001Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300002Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300003Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300004Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300005Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.JigyouHoukokuTokeiReportDBU300008Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoSyori0600Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoSyori0702Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoSyori0900Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.RiyoshaFutangakuKanriJohoSyori1002Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.SyotaiJohoSyoriKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.SyotaiJohoSyoriProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyori0710Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyori0720Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyori1010Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyori1020Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyori1030Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010020.TokuteiNyushoshaJohoSyori1040Process;
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
    private static final String 被保台帳生年月日情報処理_0200 = "HihokenshaDaichoBirthYMDSyori_0200";
    private static final String 被保台帳生年月日情報処理_0301 = "HihokenshaDaichoBirthYMDSyori_0301";
    private static final String 被保台帳生年月日情報処理_0302 = "HihokenshaDaichoBirthYMDSyori_0302";
    private static final String 利用者負担減額管理情報処理_0600 = "RiyoshaFutangakuGemmenJohoSyori_0600";
    private static final String 利用者負担減額管理情報処理_0702 = "RiyoshaFutangakuGemmenJohoSyori_0702";
    private static final String 利用者負担減額管理情報処理_0900 = "RiyoshaFutangakuGemmenJohoSyori_0900";
    private static final String 利用者負担減額管理情報処理_1002 = "RiyoshaFutangakuGemmenJohoSyori_1002";
    private static final String 特定入所者管理情報処理_0710 = "TokuteiNyushoshaJohoSyori_0710";
    private static final String 特定入所者管理情報処理_0720 = "TokuteiNyushoshaJohoSyori_0720";
    private static final String 特定入所者管理情報処理_1010 = "TokuteiNyushoshaJohoSyori_1010";
    private static final String 特定入所者管理情報処理_1020 = "TokuteiNyushoshaJohoSyori_1020";
    private static final String 特定入所者管理情報処理_1030 = "TokuteiNyushoshaJohoSyori_1030";
    private static final String 特定入所者管理情報処理_1040 = "TokuteiNyushoshaJohoSyori_1040";
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
            executeStep(CREATE事業報告世帯情報TEMPテーブル);
            executeStep(世帯情報処理);
            executeStep(被保台帳生年月日情報処理_0200);
            executeStep(被保台帳生年月日情報処理_0301);
            executeStep(被保台帳生年月日情報処理_0302);
            executeStep(利用者負担減額管理情報処理_0600);
            executeStep(利用者負担減額管理情報処理_0702);
            executeStep(利用者負担減額管理情報処理_0900);
            executeStep(利用者負担減額管理情報処理_1002);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(特定入所者管理情報処理_0710);
                executeStep(特定入所者管理情報処理_0720);
                executeStep(特定入所者管理情報処理_1010);
                executeStep(特定入所者管理情報処理_1020);
                executeStep(特定入所者管理情報処理_1030);
                executeStep(特定入所者管理情報処理_1040);
            }
            executeStep(受給者台帳情報処理);
            executeStep(事業報告統計データへ登録);
            executeStep(世帯情報処理の確認リスト);
            executeStep(被保台帳生年月日情報の確認リスト);
            executeStep(利用者負担減額管理情報の確認リスト);
            executeStep(特定入所者管理情報または標準負担額減免情報の確認リスト);
            executeStep(受給者台帳情報の確認リスト);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(parameter.getPrintControlKbn())) {
            executeStep(CREATE事業報告世帯情報TEMPテーブル);
            executeStep(世帯情報処理);
            executeStep(被保台帳生年月日情報処理_0200);
            executeStep(被保台帳生年月日情報処理_0301);
            executeStep(被保台帳生年月日情報処理_0302);
            executeStep(利用者負担減額管理情報処理_0600);
            executeStep(利用者負担減額管理情報処理_0702);
            executeStep(利用者負担減額管理情報処理_0900);
            executeStep(利用者負担減額管理情報処理_1002);
            if (制度改正月.isBeforeOrEquals(parameter.getSyukeiYM())) {
                executeStep(特定入所者管理情報処理_0710);
                executeStep(特定入所者管理情報処理_0720);
                executeStep(特定入所者管理情報処理_1010);
                executeStep(特定入所者管理情報処理_1020);
                executeStep(特定入所者管理情報処理_1030);
                executeStep(特定入所者管理情報処理_1040);
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
    @Step(被保台帳生年月日情報処理_0200)
    protected IBatchFlowCommand exeHihokenshaDaichoBirthYMDSyori_0200() {
        return loopBatch(HihokenshaDaichoBirthYMD0200Process.class)
                .arguments(parameter.toHihokenshaDaichoBirthYMDProcessParameter()).define();
    }

    /**
     * 被保台帳生年月日情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保台帳生年月日情報処理_0301)
    protected IBatchFlowCommand exeHihokenshaDaichoBirthYMDSyori_0301() {
        return loopBatch(HihokenshaDaichoBirthYMD0301Process.class)
                .arguments(parameter.toHihokenshaDaichoBirthYMDProcessParameter()).define();
    }

    /**
     * 被保台帳生年月日情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保台帳生年月日情報処理_0302)
    protected IBatchFlowCommand exeHihokenshaDaichoBirthYMDSyori_0302() {
        return loopBatch(HihokenshaDaichoBirthYMD0302Process.class)
                .arguments(parameter.toHihokenshaDaichoBirthYMDProcessParameter()).define();
    }

    /**
     * 利用者負担減額管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担減額管理情報処理_0600)
    protected IBatchFlowCommand exeRiyoshaFutangakuKanriJohoSyori_0600() {
        return loopBatch(RiyoshaFutangakuKanriJohoSyori0600Process.class)
                .arguments(parameter.toRiyoshaFutangakuKanriJohoSyoriProcessParameter()).define();
    }

    /**
     * 利用者負担減額管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担減額管理情報処理_0702)
    protected IBatchFlowCommand exeRiyoshaFutangakuKanriJohoSyori_0702() {
        return loopBatch(RiyoshaFutangakuKanriJohoSyori0702Process.class)
                .arguments(parameter.toRiyoshaFutangakuKanriJohoSyoriProcessParameter()).define();
    }

    /**
     * 利用者負担減額管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担減額管理情報処理_0900)
    protected IBatchFlowCommand exeRiyoshaFutangakuKanriJohoSyori_0900() {
        return loopBatch(RiyoshaFutangakuKanriJohoSyori0900Process.class)
                .arguments(parameter.toRiyoshaFutangakuKanriJohoSyoriProcessParameter()).define();
    }

    /**
     * 利用者負担減額管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担減額管理情報処理_1002)
    protected IBatchFlowCommand exeRiyoshaFutangakuKanriJohoSyori_1002() {
        return loopBatch(RiyoshaFutangakuKanriJohoSyori1002Process.class)
                .arguments(parameter.toRiyoshaFutangakuKanriJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理_0710)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori_0710() {
        return loopBatch(TokuteiNyushoshaJohoSyori0710Process.class)
                .arguments(parameter.toTokuteiNyushoshaJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理_0720)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori_0720() {
        return loopBatch(TokuteiNyushoshaJohoSyori0720Process.class)
                .arguments(parameter.toTokuteiNyushoshaJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理_1010)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori_1010() {
        return loopBatch(TokuteiNyushoshaJohoSyori1010Process.class)
                .arguments(parameter.toTokuteiNyushoshaJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理_1020)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori_1020() {
        return loopBatch(TokuteiNyushoshaJohoSyori1020Process.class)
                .arguments(parameter.toTokuteiNyushoshaJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理_1030)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori_1030() {
        return loopBatch(TokuteiNyushoshaJohoSyori1030Process.class)
                .arguments(parameter.toTokuteiNyushoshaJohoSyoriProcessParameter()).define();
    }

    /**
     * 特定入所者管理情報処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定入所者管理情報処理_1040)
    protected IBatchFlowCommand exeTokuteiNyushoshaJohoSyori_1040() {
        return loopBatch(TokuteiNyushoshaJohoSyori1040Process.class)
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
