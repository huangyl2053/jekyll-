/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.FukaKeisanProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.HonsanteiKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.HonsanteiTokuchoChushishaTuikaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.KeisanTaishoshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.SetaiinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.SystemTimeHonsanteiFukaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb031001.SystemTimeUpdateHonsanteiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB031001.DBB031001_HonsanteiFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB031003.DBB031003_HonsanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku.FukaJohoTorokuBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300.HonsanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定賦課計算クラスです。
 *
 * @reamsid_L DBB-0730-010 yuanzhenxia
 */
public class DBB031001_HonsanteiFuka extends BatchFlowBase<DBB031001_HonsanteiFukaParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 本算定特徴中止者の追加 = "insertHonsanteiTokuchoChushisha";
    private static final String 計算対象者抽出_通知書番号発番 = "selectKeisanTaishosha";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 賦課計算 = "caluculateFuka";
    private static final String 本算定結果一覧表出力 = "spoolHonsanteiKekkaIchiran";
    private static final String 処理日付管理テーブル更新 = "updateSystemTimeProcess";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 世帯員把握フロー = "setaiinBatchFlow";
    private static final String 本算定通知書一括発行フロー = "honsanteiTsuchishoIkkatsuHakkoFlow";
    private static final RString 計算後情報作成BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private static final RString 世帯員把握BATCH_ID = new RString("SetaiShotokuKazeiHanteiFlow");
    private static final RString 本算定通知書一括発行BATCH_ID = new RString("DBB031003_HonsanteiTsuchishoHakko");
    private static final ReportId 帳票分類ID = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private static final RString 賦課の情報登録フローBATCHID = new RString("FukaJohoTorokuFlow");
    private static final String 賦課情報登録 = "callChoteiToroku";

    private DBB031001_HonsanteiFukaParameter parameter;
    private HonsanteiFukaProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票一覧() == null || parameter.get出力帳票一覧().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        YMDHMS システム日時 = getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeHonsanteiFukaProcess.SYSTEM_TIME);
        processParameter = new HonsanteiFukaProcessParameter();
        processParameter.setバッチ起動時処理日時(システム日時);
        processParameter.set賦課年度(parameter.get賦課年度());
        processParameter.set調定年度(parameter.get調定年度());
        executeStep(本算定特徴中止者の追加);
        processParameter.set資格基準日(parameter.get資格基準日());
        executeStep(計算対象者抽出_通知書番号発番);
        executeStep(世帯員把握);
        executeStep(世帯員把握フロー);
        executeStep(賦課計算);
        executeStep(賦課情報登録);
        for (HonsanteifukaBatchTyouhyou entity : parameter.get出力帳票一覧()) {
            if (帳票分類ID.equals(entity.get帳票分類ID())) {
                processParameter.set出力帳票(entity);
                executeStep(計算後情報作成);
                executeStep(本算定結果一覧表出力);
                break;
            }
        }
        executeStep(処理日付管理テーブル更新);
        if (getParameter().is画面移動フラグ()) {
            executeStep(本算定通知書一括発行フロー);
        }

    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeHonsanteiFukaProcess.class).define();
    }

    /**
     * 本算定特徴中止者の追加を行います。
     *
     * @return バッチコマンド
     */
    @Step(本算定特徴中止者の追加)
    protected IBatchFlowCommand insertHonsanteiTokuchoChushisha() {
        return simpleBatch(HonsanteiTokuchoChushishaTuikaProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算対象者抽出_通知書番号発番を行います。
     *
     * @return バッチコマンド
     */
    @Step(計算対象者抽出_通知書番号発番)
    protected IBatchFlowCommand selectKeisanTaishosha() {
        return simpleBatch(KeisanTaishoshaProcess.class).arguments(processParameter).define();
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
    protected IBatchFlowCommand caluculateFuka() {
        return simpleBatch(FukaKeisanProcess.class).arguments(processParameter).define();
    }

    /**
     * 賦課情報登録メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報登録)
    protected IBatchFlowCommand callChoteiToroku() {
        return otherBatchFlow(賦課の情報登録フローBATCHID, SubGyomuCode.DBB介護賦課,
                new FukaJohoTorokuBatchParameter(true)).define();
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
        return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().toDateString(),
                getParameter().get賦課年度().toDateString(),
                new RString(getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeHonsanteiFukaProcess.SYSTEM_TIME).toString()),
                ShoriName.本算定賦課.get名称(), 帳票分類ID);
    }

    /**
     * 本算定結果一覧表出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(本算定結果一覧表出力)
    protected IBatchFlowCommand spoolHonsanteiKekkaIchiran() {
        return simpleBatch(HonsanteiKekkaIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 処理日付管理テーブル更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(処理日付管理テーブル更新)
    protected IBatchFlowCommand updateSystemTimeProcess() {
        return simpleBatch(SystemTimeUpdateHonsanteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 本算定通知書一括発行バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(本算定通知書一括発行フロー)
    protected IBatchFlowCommand honsanteiTsuchishoIkkatsuHakkoFlow() {
        return otherBatchFlow(本算定通知書一括発行BATCH_ID, SubGyomuCode.DBB介護賦課, create本算定通知書パラメータ()).define();
    }

    private DBB031003_HonsanteiTsuchishoHakkoParameter create本算定通知書パラメータ() {
        DBB031003_HonsanteiTsuchishoHakkoParameter para = new DBB031003_HonsanteiTsuchishoHakkoParameter();
        para.set調定年度(parameter.get調定年度());
        para.set賦課年度(parameter.get賦課年度());
        para.set資格基準日(parameter.get資格基準日());
        para.set出力帳票一覧(parameter.get出力帳票一覧());
        para.set特徴_出力対象(parameter.get特徴_出力対象());
        para.set特徴_発行日(parameter.get特徴_発行日());
        para.set決定変更_文書番号(parameter.get決定変更_文書番号());
        para.set決定変更_発行日(parameter.get決定変更_発行日());
        para.set納入_出力方法(parameter.get納入_出力方法());
        para.set納入_出力期(parameter.get納入_出力期());
        para.set納入_対象者(parameter.get納入_対象者());
        para.set納入_発行日(parameter.get納入_発行日());
        para.set納入_生活保護対象者をまとめて先頭に出力(parameter.get納入_生活保護対象者をまとめて先頭に出力());
        para.set納入_ページごとに山分け(parameter.get納入_ページごとに山分け());
        para.set打分け条件情報(parameter.get打分け条件情報());
        para.set処理日時(parameter.get処理日時());
        para.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        para.set画面移動フラグ(parameter.is画面移動フラグ());
        return para;
    }

}
