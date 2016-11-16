/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.ErarisutoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouDetaToriGaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouDetaTyuushutuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouKihonSofuCsvProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouKihonSofuListProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouKooGakuSofuListProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouKoushinnProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouShouKannSembetsuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.IdouShouKannSofuListProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KokuhorenInterfaceKanrikosinnProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KyodoShoriKihonSofuIttokiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KyodoShoriKihonSofuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KyodoShoriKooGakuIttokiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KyodoShoriKooGakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KyodoShoriShouKannIttokiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.KyodoShoriShouKannProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110030.SofuEraDetaProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110020.DBC110020_JukyushaIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110030.DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110910.DBC110910_SetaiinHaakuSubParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者異動連絡票作成です。
 *
 * @reamsid_L DBC-2770-030 zhangzhiming
 */
public class DBC110030_KyodoJukyushaIdoRenrakuhyoOut extends BatchFlowBase<DBC110030_KyodoJukyushaIdoRenrakuhyoOutParameter> {

    private static final String CALL_FLOW_DBC110020 = "DBC110020_JukyushaIdoRenrakuhyoOut";
    private static final RString DBC110020FLOW_FLOWID = new RString("DBC110020_JukyushaIdoRenrakuhyoOut");
    private static final String CALL_FLOW_DBC110910 = "DBC110910_SetaiinHaakuSub";
    private static final RString DBC110910FLOW_FLOWID = new RString("DBC110910_SetaiinHaakuSub");
    private static final String 共同処理異動基本送付全件 = "共同処理異動基本送付全件";
    private static final String 共同処理異動償還送付全件 = "共同処理異動償還送付全件";
    private static final String 共同処理異動高額送付全件 = "共同処理異動高額送付全件";
    private static final String 共同処理異動基本送付一時 = "共同処理異動基本送付一時";
    private static final String 共同処理異動償還送付一時 = "共同処理異動償還送付一時";
    private static final String 共同処理異動高額送付一時 = "共同処理異動高額送付一時";
    private static final String 世帯員把握トリガ一時 = "世帯員把握トリガ一時";
    private static final String 異動中間送付一時 = "異動中間送付一時";
    private static final String 異動中間更新 = "異動中間更新";
    private static final String 異動データ取得トリガ = "異動データ取得トリガ";
    private static final String 送付エラー一時 = "送付エラー一時";
    private static final String 帳票とCSV作成 = "帳票とCSV作成";
    private static final String 基本送付対象リスト = "基本送付対象リスト";
    private static final String 償還送付対象リスト = "償還送付対象リスト";
    private static final String 高額送付対象リスト = "高額送付対象リスト";
    private static final String 送付対象帳票とCSV = "送付対象帳票とCSV";
    private static final String 国保連管理 = "国保連管理";

    @Override
    protected void defineFlow() {
        executeStep(CALL_FLOW_DBC110020);
        executeStep(共同処理異動基本送付全件);
        executeStep(共同処理異動償還送付全件);
        executeStep(共同処理異動高額送付全件);
        executeStep(共同処理異動基本送付一時);
        executeStep(共同処理異動償還送付一時);
        executeStep(共同処理異動高額送付一時);
        executeStep(世帯員把握トリガ一時);
        executeStep(CALL_FLOW_DBC110910);
        executeStep(異動中間送付一時);
        executeStep(異動中間更新);
        executeStep(異動データ取得トリガ);
        executeStep(送付エラー一時);
        executeStep(帳票とCSV作成);
        executeStep(基本送付対象リスト);
        executeStep(償還送付対象リスト);
        executeStep(高額送付対象リスト);
        executeStep(送付対象帳票とCSV);
        executeStep(国保連管理);
    }

    /**
     * バッチ受給者異動連絡票作成処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(CALL_FLOW_DBC110020)
    protected IBatchFlowCommand callDBC110020FLOW() {
        DBC110020_JukyushaIdoRenrakuhyoOutParameter parameter = new DBC110020_JukyushaIdoRenrakuhyoOutParameter();
        parameter.setファイル名(getParameter().getファイル名());
        parameter.set再処理区分(getParameter().get再処理区分());
        parameter.set処理年月(getParameter().get処理年月());
        parameter.set抽出条件(getParameter().get抽出条件());
        return otherBatchFlow(DBC110020FLOW_FLOWID, SubGyomuCode.DBC介護給付, parameter).define();
    }

    /**
     * 共同処理異動基本送付全件データ作成処理です。
     *
     * @return KyodoShoriKihonSofuProcess
     */
    @Step(共同処理異動基本送付全件)
    protected IBatchFlowCommand create共同処理異動基本送付全件プロセス() {
        return loopBatch(KyodoShoriKihonSofuProcess.class).define();
    }

    /**
     * 共同処理異動償還送付全件データ作成処理です。
     *
     * @return KyodoShoriShouKannProcess
     */
    @Step(共同処理異動償還送付全件)
    protected IBatchFlowCommand create共同処理異動償還送付全件プロセス() {
        return loopBatch(KyodoShoriShouKannProcess.class).define();
    }

    /**
     * 共同処理異動高額送付全件データ作成処理です。
     *
     * @return KyodoShoriKooGakuProcess
     */
    @Step(共同処理異動高額送付全件)
    protected IBatchFlowCommand create共同処理異動高額送付全件プロセス() {
        return loopBatch(KyodoShoriKooGakuProcess.class).define();
    }

    /**
     * 共同処理異動基本送付一時データ作成処理です。
     *
     * @return KyodoShoriKihonSofuIttokiProcess
     */
    @Step(共同処理異動基本送付一時)
    protected IBatchFlowCommand create共同処理異動基本送付一時プロセス() {
        return loopBatch(KyodoShoriKihonSofuIttokiProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 共同処理異動償還送付一時データ作成処理です。
     *
     * @return KyodoShoriShouKannIttokiProcess
     */
    @Step(共同処理異動償還送付一時)
    protected IBatchFlowCommand create共同処理異動償還送付一時プロセス() {
        return loopBatch(KyodoShoriShouKannIttokiProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 共同処理異動高額送付一時データ作成処理です。
     *
     * @return KyodoShoriKooGakuIttokiProcess
     */
    @Step(共同処理異動高額送付一時)
    protected IBatchFlowCommand create共同処理異動高額送付一時プロセス() {
        return loopBatch(KyodoShoriKooGakuIttokiProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 世帯員把握トリガ一時データ作成処理です。
     *
     * @return IdouDetaTyuushutuProcess
     */
    @Step(世帯員把握トリガ一時)
    protected IBatchFlowCommand create世帯員把握トリガ一時プロセス() {
        return loopBatch(IdouDetaTyuushutuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * バッチ世帯員把握作成処理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(CALL_FLOW_DBC110910)
    protected IBatchFlowCommand callDBC110910FLOW() {
        DBC110910_SetaiinHaakuSubParameter parameter = new DBC110910_SetaiinHaakuSubParameter();
        parameter.set管理識別区分(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
        return otherBatchFlow(DBC110910FLOW_FLOWID, SubGyomuCode.DBC介護給付, parameter).define();
    }

    /**
     * 異動中間送付一時データ作成処理です。
     *
     * @return IdouShouKannSembetsuProcess
     */
    @Step(異動中間送付一時)
    protected IBatchFlowCommand create異動中間送付一時プロセス() {
        return loopBatch(IdouShouKannSembetsuProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 異動中間更新データ作成処理です。
     *
     * @return IdouShouKannSembetsuProcess
     */
    @Step(異動中間更新)
    protected IBatchFlowCommand create異動中間更新プロセス() {
        return loopBatch(IdouKoushinnProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 異動データ取得トリガデータ作成処理です。
     *
     * @return IdouDetaToriGaProcess
     */
    @Step(異動データ取得トリガ)
    protected IBatchFlowCommand create異動データ取得トリガプロセス() {
        return loopBatch(IdouDetaToriGaProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 送付エラー一時データ作成処理です。
     *
     * @return SofuEraDetaProcess
     */
    @Step(送付エラー一時)
    protected IBatchFlowCommand create送付エラー一時プロセス() {
        return loopBatch(SofuEraDetaProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 帳票とCSV作成処理です。
     *
     * @return ErarisutoProcess
     */
    @Step(帳票とCSV作成)
    protected IBatchFlowCommand create帳票とCSV作成プロセス() {
        return loopBatch(ErarisutoProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 基本送付対象リスト作成処理です。
     *
     * @return IdouKihonSofuListProcess
     */
    @Step(基本送付対象リスト)
    protected IBatchFlowCommand create基本送付対象リスト() {
        return loopBatch(IdouKihonSofuListProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 償還送付対象リスト作成処理です。
     *
     * @return IdouShouKannSofuListProcess
     */
    @Step(償還送付対象リスト)
    protected IBatchFlowCommand create償還送付対象リスト() {
        return loopBatch(IdouShouKannSofuListProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 高額送付対象リスト作成処理です。
     *
     * @return IdouKooGakuSofuListProcess
     */
    @Step(高額送付対象リスト)
    protected IBatchFlowCommand create高額送付対象リスト() {
        return loopBatch(IdouKooGakuSofuListProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 送付対象帳票とCSV作成処理です。
     *
     * @return IdouKihonSofuCsvProcess
     */
    @Step(送付対象帳票とCSV)
    protected IBatchFlowCommand create送付対象帳票とCSV() {
        return loopBatch(IdouKihonSofuCsvProcess.class).arguments(getParameter().toProcessParamter()).define();
    }

    /**
     * 国保連インターフェース管理です。
     *
     * @return KokuhorenInterfaceKanrikosinnProcess
     */
    @Step(国保連管理)
    protected IBatchFlowCommand create国保連管理() {
        return loopBatch(KokuhorenInterfaceKanrikosinnProcess.class).arguments(getParameter().toProcessParamter()).define();
    }
}
