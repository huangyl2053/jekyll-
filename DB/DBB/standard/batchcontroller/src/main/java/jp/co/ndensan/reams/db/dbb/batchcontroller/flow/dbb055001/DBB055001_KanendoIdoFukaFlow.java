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
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka.KanendoIdoFukaProcessParameter;
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
public class DBB055001_KanendoIdoFukaFlow extends BatchFlowBase<HonSanteiIdoKanendoFukaBatchParameter> {

    private HonSanteiIdoKanendoFukaBatchParameter parameter;
    private KanendoIdoFukaProcessParameter processParameter;

    private static final String 賦課根拠異動抽出 = "selectKanendoIdoData";
    private static final String 通知書番号発番 = "createTsuchishoBango";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 賦課計算 = "caluculateFuka";
    private static final String 過年度賦課_計算後情報を削除 = "deleteDbT2015KeisangoJohoTemp";
    private static final String 計算後情報作成_イチ = "kiisagoJyohouSakuseiIchi";
    private static final String 計算後情報作成_二 = "kiisagoJyohouSakuseiNi";
    private static final String 結果一覧表出力 = "spoolKanendoIdoKekkaIchiran";
    private static final String 処理日付管理テーブル登録 = "insertShoriDateKanri";

    private static final int 定値_イチ = 1;
    private static final int 定値_二 = 2;
    private static final RString 二_定値 = new RString("2");
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
        executeStep(賦課計算);
        executeStep(過年度賦課_計算後情報を削除);
        executeStep(計算後情報作成_イチ);
        if (二_定値.equals(processParameter.get日付関連_年度サイクル())) {
            executeStep(計算後情報作成_二);
        }
        executeStep(結果一覧表出力);
        executeStep(処理日付管理テーブル登録);
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
     * 賦課計算メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算)
    protected IBatchFlowCommand calculateFuka() {
        return simpleBatch(CalculateFukaProcess.class).define();
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
    protected IBatchFlowCommand keisangoJohoSakuseiFlow_Ichi() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(定値_イチ)).define();
    }

    /**
     * 計算後情報作成です。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成_二)
    protected IBatchFlowCommand keisangoJohoSakuseiFlow_Ni() {
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
    protected IBatchFlowCommand insShoriDateKanri() {
        return simpleBatch(InsShoriDateKanriProcess.class).arguments(processParameter).define();
    }

}
