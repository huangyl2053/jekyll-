/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataCSVDBU070801Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataCSVDBU070802Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataCSVDBU070803Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataCSVDBU070804Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataCSVDBU070805Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataReportDBU200002Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataReportDBU300020Process;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataSakuSeiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.JigyoHokokuDataTorokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100.TempJigyouJyoukyouHoukokuGassanProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010100.DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter;
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
 * 事業状況報告資料（月報）作成 保険給付決定状況（高額合算分）_バッチフロークラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
public class DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassan extends BatchFlowBase<DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter> {

    private static final String CREATE事業状況報告統計元TEMPテーブル = "CREATE事業状況報告統計元TEMPテーブル";
    private static final String 事業状況報告統計元データ作成 = "事業状況報告統計元データ作成";
    private static final String 帳票出力_処理結果確認リスト = "帳票出力_処理結果確認リスト";
    private static final String CSV作成_ファイル出力_01 = "CSV作成_ファイル出力_01";
    private static final String CSV作成_ファイル出力_02 = "CSV作成_ファイル出力_02";
    private static final String CSV作成_ファイル出力_03 = "CSV作成_ファイル出力_03";
    private static final String CSV作成_ファイル出力_04 = "CSV作成_ファイル出力_04";
    private static final String CSV作成_ファイル出力_05 = "CSV作成_ファイル出力_05";
    private static final String 事業報告統計データ = "事業報告統計データ";
    private static final String 帳票出力_保険給付決定状況_高額合算分 = "帳票出力_保険給付決定状況_高額合算分";
    private static final RString EUCエンティティID = new RString("DBU070801");
    private static final RString 区分_1 = new RString("1");
    private DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter parameter;
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
            if (区分_1.equals(getParameter().get報告区分())) {
                executeStep(CSV作成_ファイル出力_01);
                executeStep(CSV作成_ファイル出力_02);
                executeStep(CSV作成_ファイル出力_03);
                executeStep(CSV作成_ファイル出力_04);
                executeStep(CSV作成_ファイル出力_05);
            }
            executeStep(事業報告統計データ);
            if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
                executeStep(帳票出力_保険給付決定状況_高額合算分);
            }
        }
        if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(帳票出力_保険給付決定状況_高額合算分);
        }
    }

    /**
     * 事業状況報告統計元TEMPテーブルを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(CREATE事業状況報告統計元TEMPテーブル)
    protected IBatchFlowCommand createTempJigyouJyoukyouHoukokuGassan() {
        return simpleBatch(TempJigyouJyoukyouHoukokuGassanProcess.class)
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
     * @return JigyoHokokuDataCSVDBU070801Process
     */
    @Step(CSV作成_ファイル出力_01)
    protected IBatchFlowCommand createファイル出力CSV作成_01プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU070801Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU070802Process
     */
    @Step(CSV作成_ファイル出力_02)
    protected IBatchFlowCommand createファイル出力CSV作成_02プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU070802Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU070803Process
     */
    @Step(CSV作成_ファイル出力_03)
    protected IBatchFlowCommand createファイル出力CSV作成_03プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU070803Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU070804Process
     */
    @Step(CSV作成_ファイル出力_04)
    protected IBatchFlowCommand createファイル出力CSV作成_04プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU070804Process.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * ファイル出力CSV作成の処理です。
     *
     * @return JigyoHokokuDataCSVDBU070805Process
     */
    @Step(CSV作成_ファイル出力_05)
    protected IBatchFlowCommand createファイル出力CSV作成_05プロセス() {
        return loopBatch(JigyoHokokuDataCSVDBU070805Process.class).arguments(getParameter().toProcessParamter()).define();
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
     * (月報)保険給付決定状況【高額合算】の出力処理です。
     *
     * @return JigyoHokokuDataReportDBU300020Process
     */
    @Step(帳票出力_保険給付決定状況_高額合算分)
    protected IBatchFlowCommand create保険給付決定状況_高額合算分帳票出力プロセス() {
        return loopBatch(JigyoHokokuDataReportDBU300020Process.class).arguments(getParameter().toProcessParamter()).define();
    }
}
