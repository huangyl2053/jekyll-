/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb051001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.FukaTsujoIdoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.HonsanteiIdoKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.IdoJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.IdoTriggerTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.SetaiinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.SystemTimeGennendoIdoFukaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.SystemTimeUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.TokuchoIraikinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.TokuchoKaishishaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001.TsuchishoNoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.gennendohonsanteiidou.GennendoIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（現年度）クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class GennendoIdoFukaFlow extends BatchFlowBase<GennendoIdoFukaParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 特別徴収開始者抽出 = "selectTokuchoKaishisha";
    private static final String 異動対象者抽出 = "selectIdoJoho";
    private static final String 異動トリガーTEMP作成 = "createIdoTriggerTemp";
    private static final String 通知書番号発番 = "getTsuchishoNo";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 世帯員把握フロー = "setaiinBatchFlow";
    private static final RString 世帯員把握BATCH_ID = new RString("SetaiShotokuKazeiHanteiFlow");
    private static final String 賦課計算 = "calculateFukaTsujoIdo";
    private static final String 特徴依頼金計算_４月開始 = "calculateTokuchoIraikin4gatsuKaishi";
    private static final RString 計算後情報作成BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 本算定異動_現年度_結果一覧表 = "spoolHonsanteiIdoKekkaIchiranData";
    private static final String 処理日付管理テーブル更新 = "updateSystemTimeProcess";

    private GennendoIdoFukaParameter parameter;
    private GennendoIdoFukaProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票一覧() == null || parameter.get出力帳票一覧().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        YMDHMS システム日時 = getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeGennendoIdoFukaProcess.SYSTEM_TIME);
        processParameter = new GennendoIdoFukaProcessParameter();
        processParameter.set賦課年度(new FlexibleYear(parameter.get賦課年度()));
        processParameter.set処理対象(parameter.get処理対象());
        executeStep(特別徴収開始者抽出);
        processParameter.set調定年度(new FlexibleYear(parameter.get調定年度()));
        processParameter.set調定日時(システム日時.getRDateTime());
        processParameter.set抽出開始日時(new YMDHMS(parameter.get抽出開始日時()).getRDateTime());
        processParameter.set抽出終了日時(new YMDHMS(parameter.get抽出終了日時()).getRDateTime());
        executeStep(異動対象者抽出);
        processParameter.set特徴捕捉対象者の依頼金額計算(parameter.get特徴捕捉対象者の依頼金額計算());
        processParameter.set異動賦課で同時に計算する特徴捕捉分(parameter.get異動賦課で同時に計算する特徴捕捉分());
        executeStep(異動トリガーTEMP作成);
        executeStep(通知書番号発番);
        executeStep(世帯員把握);
        executeStep(世帯員把握フロー);
        executeStep(賦課計算);
        executeStep(特徴依頼金計算_４月開始);
        for (TyouhyouEntity entity : parameter.get出力帳票一覧()) {
            processParameter.set出力帳票一覧(entity);
            executeStep(計算後情報作成);
            executeStep(本算定異動_現年度_結果一覧表);
        }
        executeStep(処理日付管理テーブル更新);

    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeGennendoIdoFukaProcess.class).define();
    }

    /**
     * 特別徴収開始者抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(特別徴収開始者抽出)
    protected IBatchFlowCommand selectTokuchoKaishisha() {
        return simpleBatch(TokuchoKaishishaProcess.class).arguments(processParameter).define();
    }

    /**
     * 異動対象者抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(異動対象者抽出)
    protected IBatchFlowCommand selectIdoJoho() {
        return simpleBatch(IdoJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 異動トリガーTEMP作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(異動トリガーTEMP作成)
    protected IBatchFlowCommand createIdoTriggerTemp() {
        return simpleBatch(IdoTriggerTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 通知書番号発番を行います。
     *
     * @return バッチコマンド
     */
    @Step(通知書番号発番)
    protected IBatchFlowCommand getTsuchishoNo() {
        return simpleBatch(TsuchishoNoProcess.class).arguments(processParameter).define();
    }

    /**
     * 世帯員把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand collectSetaiin() {
        return simpleBatch(SetaiinProcess.class).define();
    }

    /**
     * 世帯員把握バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握フロー)
    protected IBatchFlowCommand setaiinBatchFlow() {
        return otherBatchFlow(世帯員把握BATCH_ID, SubGyomuCode.DBB介護賦課,
                new SetaiShotokuKazeiHanteiBatchParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード())).define();
    }

    /**
     * 賦課計算を行います。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算)
    protected IBatchFlowCommand calculateFukaTsujoIdo() {
        return simpleBatch(FukaTsujoIdoProcess.class).arguments(processParameter).define();
    }

    /**
     * 特徴依頼金計算 (４月開始)を行います。
     *
     * @return バッチコマンド
     */
    @Step(特徴依頼金計算_４月開始)
    protected IBatchFlowCommand calculateTokuchoIraikin4gatsuKaishi() {
        return simpleBatch(TokuchoIraikinProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        return otherBatchFlow(計算後情報作成BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(RString.EMPTY)).define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度(),
                getParameter().get賦課年度(),
                new RString(getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeGennendoIdoFukaProcess.SYSTEM_TIME).toString()),
                ShoriName.異動賦課.get名称(), 帳票分類ID);
    }

    /**
     * 特徴依頼金計算 (４月開始)を行います。
     *
     * @return バッチコマンド
     */
    @Step(本算定異動_現年度_結果一覧表)
    protected IBatchFlowCommand spoolHonsanteiIdoKekkaIchiranData() {
        return simpleBatch(HonsanteiIdoKekkaIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 処理日付管理テーブル更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(処理日付管理テーブル更新)
    protected IBatchFlowCommand updateSystemTimeProcess() {
        return simpleBatch(SystemTimeUpdateProcess.class).arguments(processParameter).define();
    }

}
