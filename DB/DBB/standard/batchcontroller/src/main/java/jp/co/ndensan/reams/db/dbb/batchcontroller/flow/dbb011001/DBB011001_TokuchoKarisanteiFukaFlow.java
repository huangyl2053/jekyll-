/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb011001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001.CreateFukaJohoJuneProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001.CreateFukaJohoKeizokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001.ReflectShikakuToSaishinAprilProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001.SelectKarisateiTaishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001.SelectShikakuFuseigoDataProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001.SpoolTokuchoKarisanteiKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteifuka.ShuturyokuTyoutuke;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT33001_特徴仮算定賦課
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class DBB011001_TokuchoKarisanteiFukaFlow extends BatchFlowBase<TokuchoKarisanteiFukaBatchParameter> {

    private static final String 特徴仮算定対象抽出 = "selectKarisateiTaishoProcess";
    private static final String 資格不整合データ抽出 = "selectShikakuFuseigoData";
    private static final String 資格等最新化_４月開始 = "reflectShikakuToSaishinApril";
    private static final String 賦課の情報登録フロー_４月開始 = "call_FukaJohoTorokuFlow_April";
    private static final String 賦課計算_継続 = "createFukaJohoKeizoku";
    private static final String 賦課の情報登録フロー_継続 = "call_FukaJohoTorokuFlow_Keizoku";
    private static final String 賦課情報の計算登録_6月開始 = "createFukaJohoJune";
    private static final String 賦課の情報登録フロー_6月開始 = "call_FukaJohoTorokuFlow_June";
    private static final String 計算後情報作成 = "call_KeisangoJohoSakuseiFlow";
    private static final String 特徴仮算定結果一覧表出力 = "spoolTokuchoKarisanteiKekkaIchiran";
    private static final String 仮算定異動通知書一括発行 = "call_TokuchoKarisanteiTsuchishoHakkoFlow";
    private static final RString KEISANGOJOHOSAKUEEIFLOW_FLOWID = new RString("KeisangoJohoSakuseiFlow");
    private static final RString FUKAJOHOTOROKUFLOW_FLOWID = new RString("FukaJohoTorokuFlow");
    private static final RString TOKUCHOKARISANTEITSUSHISHOHAKKO_FLOWID = new RString("DBB011003_TokuchoKarisanteiTsuchishoHakko");
    private static final ReportId 特別徴収仮算定結果一覧表_帳票分類ID = new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");

    private YMDHMS システム日時;

    @Override
    protected void defineFlow() {
        システム日時 = YMDHMS.now();
        executeStep(特徴仮算定対象抽出);
        executeStep(資格不整合データ抽出);
        executeStep(資格等最新化_４月開始);
        // 呼び出しのbatchに問題がある
        // executeStep(賦課の情報登録フロー_４月開始);
        executeStep(賦課計算_継続);
        // 呼び出しのbatchに問題がある
        // executeStep(賦課の情報登録フロー_継続);
        executeStep(賦課情報の計算登録_6月開始);
        // 呼び出しのbatchに問題がある
        // executeStep(賦課の情報登録フロー_6月開始);
        executeStep(計算後情報作成);
        List<ShuturyokuTyoutuke> 出力帳票一覧List = getParameter().get出力帳票一覧();
        for (ShuturyokuTyoutuke 出力帳票一覧 : 出力帳票一覧List) {
            if (特別徴収仮算定結果一覧表_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                executeStep(特徴仮算定結果一覧表出力);
                break;
            }
        }
        if (getParameter().isFlag()) {
            executeStep(仮算定異動通知書一括発行);
        }
    }

    /**
     * 特徴仮算定対象抽出
     *
     * @return SelectKarisateiTaishoProcess
     */
    @Step(特徴仮算定対象抽出)
    protected IBatchFlowCommand selectKarisateiTaishoProcess() {
        return simpleBatch(SelectKarisateiTaishoProcess.class).
                arguments(getParameter().toSelectKarisateiTaishoProcessParameter()).define();
    }

    /**
     * 資格不整合データ抽出
     *
     * @return SelectShikakuFuseigoDataProcess
     */
    @Step(資格不整合データ抽出)
    protected IBatchFlowCommand selectShikakuFuseigoData() {
        return simpleBatch(SelectShikakuFuseigoDataProcess.class).
                arguments(getParameter().toSelectShikakuFuseigoDataProcessParameter(システム日時)).define();
    }

    /**
     * 資格等最新化_４月開始
     *
     * @return ReflectShikakuToSaishinAprilProcess
     */
    @Step(資格等最新化_４月開始)
    protected IBatchFlowCommand reflectShikakuToSaishinApril() {
        return simpleBatch(ReflectShikakuToSaishinAprilProcess.class).
                arguments(getParameter().toReflectShikakuToSaishinAprilProcessParameter(システム日時)).define();
    }

    /**
     * 賦課の情報登録フロー_４月開始
     *
     * @return 賦課の情報登録フロー
     */
    @Step(賦課の情報登録フロー_４月開始)
    protected IBatchFlowCommand call_FukaJohoTorokuFlow_April() {
        return otherBatchFlow(FUKAJOHOTOROKUFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toFukaJohoTorokuBatchParameter()).define();
    }

    /**
     * 賦課計算_継続
     *
     * @return CreateFukaJohoKeizokuProcess
     */
    @Step(賦課計算_継続)
    protected IBatchFlowCommand createFukaJohoKeizoku() {
        return simpleBatch(CreateFukaJohoKeizokuProcess.class).
                arguments(getParameter().toCreateFukaJohoKeizokuProcessParameter(システム日時)).define();
    }

    /**
     * 賦課の情報登録フロー_継続
     *
     * @return 賦課の情報登録フロー
     */
    @Step(賦課の情報登録フロー_継続)
    protected IBatchFlowCommand call_FukaJohoTorokuFlow_Keizoku() {
        return otherBatchFlow(FUKAJOHOTOROKUFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toFukaJohoTorokuBatchParameter()).define();
    }

    /**
     * 賦課情報の計算登録_6月開始
     *
     * @return CreateFukaJohoJuneProcess
     */
    @Step(賦課情報の計算登録_6月開始)
    protected IBatchFlowCommand createFukaJohoJune() {
        return simpleBatch(CreateFukaJohoJuneProcess.class).
                arguments(getParameter().toCreateFukaJohoJuneProcessParameter(システム日時)).define();
    }

    /**
     * 賦課情報の計算登録_6月開始
     *
     * @return CreateFukaJohoJuneProcess
     */
    @Step(賦課の情報登録フロー_6月開始)
    protected IBatchFlowCommand call_FukaJohoTorokuFlow_June() {
        return otherBatchFlow(FUKAJOHOTOROKUFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toFukaJohoTorokuBatchParameter()).define();
    }

    /**
     * 認定調査依頼発行一覧表バッチのです。
     *
     * @return NinteiChosaIraiFlow
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand call_KeisangoJohoSakuseiFlow() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().toKeisangoJohoSakuseiBatchParamter(システム日時)).define();
    }

    /**
     * 特徴仮算定結果一覧表出力
     *
     * @return SpoolTokuchoKarisanteiKekkaIchiranProcess
     */
    @Step(特徴仮算定結果一覧表出力)
    protected IBatchFlowCommand spoolTokuchoKarisanteiKekkaIchiran() {
        return simpleBatch(SpoolTokuchoKarisanteiKekkaIchiranProcess.class).
                arguments(getParameter().toSpoolTokuchoKarisanteiKekkaIchiranProcessParameter(システム日時)).define();
    }

    /**
     * 特徴仮算定通知書一括発行バッチ
     *
     * @return TokuchoKarisanteiTsuchishoHakkoFlow
     */
    @Step(仮算定異動通知書一括発行)
    protected IBatchFlowCommand call_TokuchoKarisanteiTsuchishoHakkoFlow() {
        return otherBatchFlow(TOKUCHOKARISANTEITSUSHISHOHAKKO_FLOWID, SubGyomuCode.DBB介護賦課,
                getParameter().getParameter()).define();
    }

}
