/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb055001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.CalculateFukaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.CollectSetaiinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.CreateTsuchishoBangoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.DeleteKeisangoJohoTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.InsShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.SelectKanendoIdoDataProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001.SpoolKanendoIdoKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka.KanendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT45001_本算定異動（過年度）クラスです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class DBB055001_KanendoIdoFukaFlow extends BatchFlowBase<HonSanteiIdoFukaBatchParameter> {

    private HonSanteiIdoFukaBatchParameter parameter;
    private KanendoIdoFukaProcessParameter processParameter;

    private static final String 賦課根拠異動抽出 = "selectKanendoIdoData";
    private static final String 通知書番号発番 = "createTsuchishoBango";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 世帯員把握バッチフロー = "callSetaiShotokuKazeiHanteiFlow";
    private static final String 賦課計算 = "calculateFuka";
    private static final String 過年度賦課_計算後情報を削除 = "deleteKeisangoJohoTemp";
    private static final String 計算後情報作成_イチ = "kiisagoJyohouSakuseiIchi";
    private static final String 計算後情報作成_二 = "kiisagoJyohouSakuseiNi";
    private static final String 結果一覧表出力 = "spoolKanendoIdoKekkaIchiran";
    private static final String 処理日付管理テーブル登録 = "insertShoriDateKanri";
    private static final String 本算定通知書一括発行_過年度 = "callKanendoIdoTsuchishoHakkoFlow";

    private static final int 定値_イチ = 1;
    private static final int 定値_二 = 2;
    private static final RString 二_定値 = new RString("2");
    private static final RString KANENDOIDOTSUCHISHO_FLOW = new RString("DBB055003_KanendoIdoTsuchishoHakko");
    private static final RString SETAISHOTOKUKAZEIHANTEI_FLOW = new RString("SetaiShotokuKazeiHanteiFlow");
    private static final RString KEISANGOJOHOSAKUEEIFLOW_FLOWID = new RString("KeisangoJohoSakuseiFlow");

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null) {
            return;
        }
        processParameter = parameter.toKanendoIdoFukaProcessParameter(YMDHMS.now());
        executeStep(賦課根拠異動抽出);
        executeStep(通知書番号発番);
        executeStep(世帯員把握);
        executeStep(世帯員把握バッチフロー);
        executeStep(賦課計算);
        executeStep(過年度賦課_計算後情報を削除);
        executeStep(計算後情報作成_イチ);
        if (二_定値.equals(processParameter.get日付関連_年度サイクル())) {
            executeStep(計算後情報作成_二);
        }
        executeStep(結果一覧表出力);
        executeStep(処理日付管理テーブル登録);
        executeStep(本算定通知書一括発行_過年度);
    }

    /**
     * 賦課根拠異動抽出メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課根拠異動抽出)
    protected IBatchFlowCommand selectKanendoIdoData() {
        return simpleBatch(SelectKanendoIdoDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 通知書番号発番メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(通知書番号発番)
    protected IBatchFlowCommand createTsuchishoBango() {
        return simpleBatch(CreateTsuchishoBangoProcess.class).arguments(processParameter).define();
    }

    /**
     * 世帯員把握メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand collectSetaiin() {
        return simpleBatch(CollectSetaiinProcess.class).define();
    }

    /**
     * 世帯員把握バッチフローメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握バッチフロー)
    protected IBatchFlowCommand callSetaiShotokuKazeiHanteiFlow() {
        return otherBatchFlow(SETAISHOTOKUKAZEIHANTEI_FLOW, SubGyomuCode.DBB介護賦課,
                getSetaiShotokuKazeiHanteiBatchParameter()).define();
    }

    private SetaiShotokuKazeiHanteiBatchParameter getSetaiShotokuKazeiHanteiBatchParameter() {
        return new SetaiShotokuKazeiHanteiBatchParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード());
    }

    /**
     * 賦課計算メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算)
    protected IBatchFlowCommand calculateFuka() {
        return simpleBatch(CalculateFukaProcess.class).arguments(processParameter).define();
    }

    /**
     * 過年度賦課_計算後情報を削除です。
     *
     * @return バッチコマンド
     */
    @Step(過年度賦課_計算後情報を削除)
    protected IBatchFlowCommand deleteKeisangoJohoTemp() {
        return simpleBatch(DeleteKeisangoJohoTempProcess.class).define();
    }

    /**
     * 計算後情報作成です。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成_イチ)
    protected IBatchFlowCommand kiisagoJyohouSakuseiIchi() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(定値_イチ)).define();
    }

    /**
     * 計算後情報作成です。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成_二)
    protected IBatchFlowCommand kiisagoJyohouSakuseiNi() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(定値_二)).define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(int 年度) {
        return new KeisangoJohoSakuseiBatchParamter(processParameter.get調定年度().toDateString(),
                processParameter.get調定年度().minusYear(年度).toDateString(),
                processParameter.getシステム日時().toDateString(),
                ShoriName.過年度賦課.get名称(), RString.EMPTY);
    }

    /**
     * 本算定異動（過年度）結果一覧表出力です。
     *
     * @return バッチコマンド
     */
    @Step(結果一覧表出力)
    protected IBatchFlowCommand spoolKanendoIdoKekkaIchiran() {
        return simpleBatch(SpoolKanendoIdoKekkaIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 処理日付管理テーブル登録です。
     *
     * @return バッチコマンド
     */
    @Step(処理日付管理テーブル登録)
    protected IBatchFlowCommand insertShoriDateKanri() {
        return simpleBatch(InsShoriDateKanriProcess.class).arguments(processParameter).define();
    }

    /**
     * 本算定通知書一括発行_過年度です。
     *
     * @return バッチコマンド
     */
    @Step(本算定通知書一括発行_過年度)
    protected IBatchFlowCommand callKanendoIdoTsuchishoHakkoFlow() {
        return otherBatchFlow(KANENDOIDOTSUCHISHO_FLOW, SubGyomuCode.DBB介護賦課,
                getHonSanteiIdoKanendoFukaBatchParameter()).define();
    }

    private HonSanteiIdoKanendoFukaBatchParameter getHonSanteiIdoKanendoFukaBatchParameter() {
        HonSanteiIdoKanendoFukaBatchParameter param = new HonSanteiIdoKanendoFukaBatchParameter();
        param.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        param.set出力帳票List(parameter.get出力帳票List());
        param.set変更_チェックボックス(parameter.get変更_チェックボックス());
        param.set変更_対象者(parameter.get変更_対象者());
        param.set変更_対象賦課年度(parameter.get変更_対象賦課年度());
        param.set変更_文書番号(parameter.get変更_文書番号());
        param.set変更_発行日(parameter.get変更_発行日());
        param.set決定_チェックボックス(parameter.get決定_チェックボックス());
        param.set決定_対象賦課年度(parameter.get決定_対象賦課年度());
        param.set決定_文書番号(parameter.get決定_文書番号());
        param.set決定_発行日(parameter.get決定_発行日());
        param.set納入_ページ山分け(parameter.get納入_ページ山分け());
        param.set納入_先頭出力(parameter.get納入_先頭出力());
        param.set納入_出力期(parameter.get納入_出力期());
        param.set納入_口座振替様式(parameter.get納入_口座振替様式());
        param.set納入_対象者(parameter.get納入_対象者());
        param.set納入_対象賦課年度(parameter.get納入_対象賦課年度());
        param.set納入_発行日(parameter.get納入_発行日());
        param.set調定年度(parameter.get調定年度());
        return param;
    }

}
