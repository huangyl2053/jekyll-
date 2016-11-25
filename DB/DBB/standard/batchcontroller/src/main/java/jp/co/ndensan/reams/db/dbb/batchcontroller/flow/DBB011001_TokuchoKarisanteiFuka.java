/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.CrtIchiranhyoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.DelZennendoFukaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsFukaErrorListProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsFukaTemp1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsFukaTemp2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsFukaTemp3Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsShutsuryokujunProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsTokuchoKariChushutsuTmp1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsTokuchoKariChushutsuTmp2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsTokuchoKarisanteiFUkaJohoTemp1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsTokuchoKarisanteiFUkaJohoTemp2Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.InsZennendoFukaTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.UpdFukaTemp1Process;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001.UpdTokuchoKariChushutsuTmpProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB011001.DBB011001_TokuchoKarisanteiFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB011001.ShuturyokuTyoutuke;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT33001_特徴仮算定賦課クラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class DBB011001_TokuchoKarisanteiFuka extends BatchFlowBase<DBB011001_TokuchoKarisanteiFukaParameter> {

    private static final String 特徴仮算定抽出TEMPに登録_特徴継続_4月開始データ = "InsTokuchoKariChushutsuTmp1";
    private static final String 特徴仮算定抽出TEMPに登録_特徴６月開始データ = "InsTokuchoKariChushutsuTmp2";
    private static final String 前年度賦課TEMPに登録_6期金額ありデータ = "InsZennendoFukaTmp";
    private static final String 前年度賦課TEMP履歴削除_特徴６月開始データ = "DelZennendoFukaTmp";
    private static final String 特徴仮算定抽出TEMP更新_前年度6期 = "UpdTokuchoKariChushutsuTmp";
    private static final String 賦課エラー一覧データに登録 = "InsFukaErrorList";
    private static final String 賦課の情報一時テーブルに登録_4月開始最新化 = "InsFukaTemp1";
    private static final String 賦課の情報一時テーブルを更新_4月開始最新化 = "UpdFukaTemp1";
    private static final String 賦課の情報一時テーブルに登録_継続 = "InsFukaTemp2";
    private static final String 賦課の情報一時テーブルに登録_6月開始 = "InsFukaTemp3";
    private static final String 賦課の情報登録フロー = "call_FukaJohoTorokuFlow";
    private static final String 計算後情報作成 = "call_KeisangoJohoSakuseiFlow";
    private static final String 出力順TEMPに登録 = "InsShutsuryokujun";
    private static final String 特徴仮算定計算後賦課情報TEMPに登録_通常分 = "InsTokuchoKarisanteiFUkaJohoTemp1";
    private static final String 特徴仮算定計算後賦課情報TEMPに登録_特徴停止分 = "InsTokuchoKarisanteiFUkaJohoTemp2";
    private static final String 一覧表作成 = "CrtIchiranhyo";
    private static final String 処理日付管理更新 = "UpdShoriDateKanri";
    private static final RString KEISANGOJOHOSAKUEEIFLOW_FLOWID = new RString("DBB003001_KeisangoJohoSakusei");
    private static final RString FUKAJOHOTOROKUFLOW_FLOWID = new RString("DBB004001_FukaJohoToroku");
    private static final ReportId 特別徴収仮算定結果一覧表_帳票分類ID = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private static final String 仮算定異動通知書一括発行 = "call_TokuchoKarisanteiTsuchishoHakkoFlow";
    private static final RString TOKUCHOKARISANTEITSUSHISHOHAKKO_FLOWID = new RString("DBB011003_TokuchoKarisanteiTsuchishoHakko");

    private YMDHMS システム日時;
    private RString 出力順ID;

    @Override
    protected void initialize() {
        super.initialize();
        システム日時 = YMDHMS.now();
        出力順ID = RString.EMPTY;
    }

    @Override
    protected void defineFlow() {
        システム日時 = YMDHMS.now();
        executeStep(特徴仮算定抽出TEMPに登録_特徴継続_4月開始データ);
        executeStep(特徴仮算定抽出TEMPに登録_特徴６月開始データ);
        executeStep(前年度賦課TEMPに登録_6期金額ありデータ);
        executeStep(前年度賦課TEMP履歴削除_特徴６月開始データ);
        executeStep(特徴仮算定抽出TEMP更新_前年度6期);
        executeStep(賦課エラー一覧データに登録);
        executeStep(賦課の情報一時テーブルに登録_4月開始最新化);
        executeStep(賦課の情報一時テーブルを更新_4月開始最新化);
        executeStep(賦課の情報一時テーブルに登録_継続);
        executeStep(賦課の情報一時テーブルに登録_6月開始);
        executeStep(賦課の情報登録フロー);
        executeStep(計算後情報作成);
        List<ShuturyokuTyoutuke> 出力帳票一覧List = getParameter().get出力帳票一覧();
        for (ShuturyokuTyoutuke 出力帳票一覧 : 出力帳票一覧List) {
            if (特別徴収仮算定結果一覧表_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                出力順ID = 出力帳票一覧.get出力順ID();
                executeStep(出力順TEMPに登録);
                executeStep(特徴仮算定計算後賦課情報TEMPに登録_通常分);
                executeStep(特徴仮算定計算後賦課情報TEMPに登録_特徴停止分);
                executeStep(一覧表作成);
                break;
            }
        }
        executeStep(処理日付管理更新);
        if (getParameter().isFlag()) {
            executeStep(仮算定異動通知書一括発行);
        }
    }

    /**
     * 特徴仮算定抽出Tempに登録_特徴継続_4月開始データ抽出のメソッドです。
     *
     * @return InsTokuchoKariChushutsuTmp1Process
     */
    @Step(特徴仮算定抽出TEMPに登録_特徴継続_4月開始データ)
    protected IBatchFlowCommand insTokuchoKariChushutsuTmp1() {
        return loopBatch(InsTokuchoKariChushutsuTmp1Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定抽出Tempに登録_特徴６月開始データ抽出のメソッドです。
     *
     * @return InsTokuchoKariChushutsuTmp2Process
     */
    @Step(特徴仮算定抽出TEMPに登録_特徴６月開始データ)
    protected IBatchFlowCommand insTokuchoKariChushutsuTmp2() {
        return loopBatch(InsTokuchoKariChushutsuTmp2Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 前年度賦課Tempに登録_6期金額ありデータ抽出のメソッドです。
     *
     * @return InsZennendoFukaTmpProcess
     */
    @Step(前年度賦課TEMPに登録_6期金額ありデータ)
    protected IBatchFlowCommand insZennendoFukaTmp() {
        return loopBatch(InsZennendoFukaTmpProcess.class).
                arguments(setParameter()).define();
    }

    /**
     * 前年度賦課Temp履歴削除_特徴６月開始データのメソッドです。
     *
     * @return DelZennendoFukaTmpProcess
     */
    @Step(前年度賦課TEMP履歴削除_特徴６月開始データ)
    protected IBatchFlowCommand delZennendoFukaTmp() {
        return simpleBatch(DelZennendoFukaTmpProcess.class).
                arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定抽出Temp更新_前年度6期のメソッドです。
     *
     * @return UpdTokuchoKariChushutsuTmpProcess
     */
    @Step(特徴仮算定抽出TEMP更新_前年度6期)
    protected IBatchFlowCommand updTokuchoKariChushutsuTmp() {
        return simpleBatch(UpdTokuchoKariChushutsuTmpProcess.class).
                arguments(setParameter()).define();
    }

    /**
     * 賦課エラー一覧データに登録のメソッドです。
     *
     * @return InsFukaErrorListProcess
     */
    @Step(賦課エラー一覧データに登録)
    protected IBatchFlowCommand insFukaErrorList() {
        return loopBatch(InsFukaErrorListProcess.class).
                arguments(setParameter()).define();
    }

    /**
     * 賦課の情報一時テーブルに登録（4月開始最新化）のメソッドです。
     *
     * @return InsFukaTemp1Process
     */
    @Step(賦課の情報一時テーブルに登録_4月開始最新化)
    protected IBatchFlowCommand insFukaTemp1() {
        return loopBatch(InsFukaTemp1Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 賦課の情報一時テーブルに更新（4月開始最新化）のメソッドです。
     *
     * @return UpdFukaTemp1Process
     */
    @Step(賦課の情報一時テーブルを更新_4月開始最新化)
    protected IBatchFlowCommand updFukaTemp1() {
        return loopBatch(UpdFukaTemp1Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 賦課の情報一時テーブルに登録（継続）のメソッドです。
     *
     * @return InsFukaTemp2Process
     */
    @Step(賦課の情報一時テーブルに登録_継続)
    protected IBatchFlowCommand insFukaTemp2() {
        return loopBatch(InsFukaTemp2Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 賦課の情報一時テーブルに登録（6月開始）のメソッドです。
     *
     * @return InsFukaTemp3Process
     */
    @Step(賦課の情報一時テーブルに登録_6月開始)
    protected IBatchFlowCommand insFukaTemp3() {
        return loopBatch(InsFukaTemp3Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 賦課の情報登録フローのメソッドです。
     *
     * @return 賦課の情報登録フローバッチ
     */
    @Step(賦課の情報登録フロー)
    protected IBatchFlowCommand call_FukaJohoTorokuFlow() {
        return otherBatchFlow(FUKAJOHOTOROKUFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toFukaJohoTorokuBatchParameter()).define();
    }

    /**
     * 計算後情報作成のメソッドです。
     *
     * @return 計算後情報作成バッチ
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand call_KeisangoJohoSakuseiFlow() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toKeisangoJohoSakuseiBatchParamter(システム日時)).define();
    }

    /**
     * 出力順TEMPに登録のメソッドです。
     *
     * @return InsShutsuryokujunProcess
     */
    @Step(出力順TEMPに登録)
    protected IBatchFlowCommand insShutsuryokujun() {
        return loopBatch(InsShutsuryokujunProcess.class).
                arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定計算後賦課情報Tempに登録_通常分のメソッドです。
     *
     * @return InsTokuchoKarisanteiFUkaJohoTemp1Process
     */
    @Step(特徴仮算定計算後賦課情報TEMPに登録_通常分)
    protected IBatchFlowCommand insTokuchoKarisanteiFUkaJohoTemp1() {
        return loopBatch(InsTokuchoKarisanteiFUkaJohoTemp1Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定計算後賦課情報Tempに登録_特徴停止分のメソッドです。
     *
     * @return InsTokuchoKarisanteiFUkaJohoTemp1Process
     */
    @Step(特徴仮算定計算後賦課情報TEMPに登録_特徴停止分)
    protected IBatchFlowCommand insTokuchoKarisanteiFUkaJohoTemp2() {
        return loopBatch(InsTokuchoKarisanteiFUkaJohoTemp2Process.class).
                arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定計算後賦課情報Tempに登録_特徴停止分のメソッドです。
     *
     * @return InsTokuchoKarisanteiFUkaJohoTemp1Process
     */
    @Step(一覧表作成)
    protected IBatchFlowCommand crtIchiranhyo() {
        return loopBatch(CrtIchiranhyoProcess.class).
                arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定計算後賦課情報Tempに登録_特徴停止分のメソッドです。
     *
     * @return InsTokuchoKarisanteiFUkaJohoTemp1Process
     */
    @Step(処理日付管理更新)
    protected IBatchFlowCommand updShoriDateKanri() {
        return simpleBatch(UpdShoriDateKanriProcess.class).arguments(setParameter()).define();
    }

    /**
     * 特徴仮算定通知書一括発行バッチのメソッドです。
     *
     * @return TokuchoKarisanteiTsuchishoHakkoFlow
     */
    @Step(仮算定異動通知書一括発行)
    protected IBatchFlowCommand call_TokuchoKarisanteiTsuchishoHakkoFlow() {
        return otherBatchFlow(TOKUCHOKARISANTEITSUSHISHOHAKKO_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().getParameter()).define();
    }

    private TokuchoKarisanteiFukaProcessParameter setParameter() {
        TokuchoKarisanteiFukaProcessParameter parameter = new TokuchoKarisanteiFukaProcessParameter();
        parameter.set調定年度(getParameter().get調定年度());
        parameter.set賦課年度(getParameter().get賦課年度());
        parameter.set調定日時(システム日時);
        if (!出力順ID.isEmpty()) {
            parameter.set出力順ID(出力順ID);
        }
        return parameter;
    }

}
