/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060700Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060701Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060702Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060703Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060704Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060705Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060706Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataCSVDBU060707Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataReportDBU200002Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataReportDBU300019Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataSakuSeiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.JigyoHokokuDataTorokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090.TempJigyouJyoukyouHoukokuKougakuProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010090.DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 事業状況報告資料（月報）作成 保険給付決定情報（高額介護サービス費）_バッチフロークラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
public class DBU010090_JigyoHokokuGeppo_HokenkyufuKogaku extends BatchFlowBase<DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter> {

    private static final String 事業状況報告統計元データ作成 = "事業状況報告統計元データ作成";
    private static final String CREATE事業状況報告統計元TEMPテーブル = "CREATE事業状況報告統計元TEMPテーブル";
    private static final String 帳票出力_処理結果確認リスト = "帳票出力_処理結果確認リスト";
    private static final String CSV作成_ファイル出力_00 = "CSV作成_ファイル出力_00";
    private static final String CSV作成_ファイル出力_01 = "CSV作成_ファイル出力_01";
    private static final String CSV作成_ファイル出力_02 = "CSV作成_ファイル出力_02";
    private static final String CSV作成_ファイル出力_03 = "CSV作成_ファイル出力_03";
    private static final String CSV作成_ファイル出力_04 = "CSV作成_ファイル出力_04";
    private static final String CSV作成_ファイル出力_05 = "CSV作成_ファイル出力_05";
    private static final String CSV作成_ファイル出力_06 = "CSV作成_ファイル出力_06";
    private static final String CSV作成_ファイル出力_07 = "CSV作成_ファイル出力_07";
    private static final String 事業報告統計データ = "事業報告統計データ";
    private static final String 帳票出力_保険給付決定状況_高額介護サービス費分 = "帳票出力_保険給付決定状況_高額介護サービス費分";
    private static final RString EUCエンティティID = new RString("DBU060700");
    private DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId(EUCエンティティID), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        parameter.setManager(manager);
        executeStep(CREATE事業状況報告統計元TEMPテーブル);
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())
                || PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業状況報告統計元データ作成);
            executeStep(帳票出力_処理結果確認リスト);
            executeStep(CSV作成_ファイル出力_00);
            executeStep(CSV作成_ファイル出力_01);
            executeStep(CSV作成_ファイル出力_02);
            executeStep(CSV作成_ファイル出力_03);
            executeStep(CSV作成_ファイル出力_04);
            executeStep(CSV作成_ファイル出力_05);
            executeStep(CSV作成_ファイル出力_06);
            executeStep(CSV作成_ファイル出力_07);
            executeStep(事業報告統計データ);
            if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
                executeStep(帳票出力_保険給付決定状況_高額介護サービス費分);
            }
        }
        if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(帳票出力_保険給付決定状況_高額介護サービス費分);
        }
    }

    /**
     * 事業状況報告統計元TEMPテーブルを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CREATE事業状況報告統計元TEMPテーブル)
    protected IBatchFlowCommand createTempJigyouJyoukyouHoukokuKougaku() {
        return simpleBatch(TempJigyouJyoukyouHoukokuKougakuProcess.class)
                .arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告統計元データ作成処理です。
     *
     * @return JigyoHokokuDataSakuSeiProcess
     */
    @Step(事業状況報告統計元データ作成)
    protected IBatchFlowCommand create事業状況報告統計元データ作成プロセス() {
        return loopBatch(JigyoHokokuDataSakuSeiProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 事業状況報告統計データ登録処理です。
     *
     * @return JigyoHokokuDataSakuSeiProcess
     */
    @Step(事業報告統計データ)
    protected IBatchFlowCommand create事業状況報告統計データ登録プロセス() {
        return loopBatch(JigyoHokokuDataTorokuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 処理結果確認リスト帳票の出力処理です。
     *
     * @return JigyoHokokuDataReportDBU200002Process
     */
    @Step(帳票出力_処理結果確認リスト)
    protected IBatchFlowCommand create処理結果確認リスト帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU200002Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060700Process
     */
    @Step(CSV作成_ファイル出力_00)
    protected IBatchFlowCommand createファイル出力CSV作成_00プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060700Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060701Process
     */
    @Step(CSV作成_ファイル出力_01)
    protected IBatchFlowCommand createファイル出力CSV作成_01プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060701Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060702Process
     */
    @Step(CSV作成_ファイル出力_02)
    protected IBatchFlowCommand createファイル出力CSV作成_02プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060702Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060703Process
     */
    @Step(CSV作成_ファイル出力_03)
    protected IBatchFlowCommand createファイル出力CSV作成_03プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060703Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060704Process
     */
    @Step(CSV作成_ファイル出力_04)
    protected IBatchFlowCommand createファイル出力CSV作成_04プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060704Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060705Process
     */
    @Step(CSV作成_ファイル出力_05)
    protected IBatchFlowCommand createファイル出力CSV作成_05プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060705Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060706Process
     */
    @Step(CSV作成_ファイル出力_06)
    protected IBatchFlowCommand createファイル出力CSV作成_06プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060706Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU060707Process
     */
    @Step(CSV作成_ファイル出力_07)
    protected IBatchFlowCommand createファイル出力CSV作成_07プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU060707Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 保険給付決定状況_高額介護サービス費分帳票の出力処理です。
     *
     * @return JigyoHokokuDataReportDBU300019Process
     */
    @Step(帳票出力_保険給付決定状況_高額介護サービス費分)
    protected IBatchFlowCommand create保険給付決定状況_高額介護サービス費分帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300019Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
