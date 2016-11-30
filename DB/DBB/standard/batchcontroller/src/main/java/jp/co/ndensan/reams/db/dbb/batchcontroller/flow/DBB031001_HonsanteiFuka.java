/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.CaluculateFukaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.HonsanteiKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.HonsanteiTokuchoChushishaTuikaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.InsFukaKeisanTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.InsSetaiTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.InsShuturyokuTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.KeisanTaishoshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.SetaiinHaakuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001.SystemTimeUpdateHonsanteiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB031001.DBB031001_HonsanteiFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB031003.DBB031003_HonsanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300.HonsanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
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
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class DBB031001_HonsanteiFuka extends BatchFlowBase<DBB031001_HonsanteiFukaParameter> {

    private static final String 本算定特徴中止者の追加 = "insertHonsanteiTokuchoChushisha";
    private static final String 計算対象者抽出_通知書番号発番 = "selectKeisanTaishosha";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 賦課計算_賦課 = "insFukaKeisanTemp";
    private static final String 賦課計算_世帯員 = "insSetaiTempProcess";
    private static final String 賦課計算 = "caluculateFuka";
    private static final String 出力順登録 = "insShuturyokuTempProcess";
    private static final String 本算定結果一覧表出力 = "spoolHonsanteiKekkaIchiran";
    private static final String 処理日付管理テーブル更新 = "updateSystemTimeProcess";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 世帯員把握フロー = "setaiinBatchFlow";
    private static final String 本算定通知書一括発行フロー = "honsanteiTsuchishoIkkatsuHakkoFlow";
    private static final RString 計算後情報作成BATCH_ID = new RString("DBB003001_KeisangoJohoSakusei");
    private static final RString 世帯員把握BATCH_ID = new RString("DBB002001_SetaiinHaaku");
    private static final RString 本算定通知書一括発行BATCH_ID = new RString("DBB031003_HonsanteiTsuchishoHakko");
    private static final ReportId 帳票分類ID = new ReportId("DBB200009_HonsanteiKekkaIcihiran");
    private static final RString 賦課の情報登録フローBATCHID = new RString("DBB004001_FukaJohoToroku");
    private static final String 賦課情報登録 = "callChoteiToroku";
    private static final RString 徴収方法R = new RString("徴収方法");

    private YMDHMS システム日時;
    private DBB031001_HonsanteiFukaParameter parameter;
    private HonsanteiFukaProcessParameter processParameter;

    @Override
    protected void initialize() {
        システム日時 = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票一覧() == null || parameter.get出力帳票一覧().isEmpty()) {
            return;
        }
        processParameter = new HonsanteiFukaProcessParameter();
        processParameter.setバッチ起動時処理日時(システム日時);
        processParameter.set賦課年度(parameter.get賦課年度());
        processParameter.set調定年度(parameter.get調定年度());
        executeStep(本算定特徴中止者の追加);
        processParameter.set資格基準日(parameter.get資格基準日());
        executeStep(計算対象者抽出_通知書番号発番);
        executeStep(世帯員把握);
        executeStep(世帯員把握フロー);
        executeStep(賦課計算_賦課);
        executeStep(賦課計算_世帯員);
        executeStep(賦課計算);
        executeStep(賦課情報登録);
        for (HonsanteifukaBatchTyouhyou entity : parameter.get出力帳票一覧()) {
            if (帳票分類ID.equals(entity.get帳票分類ID())) {
                processParameter.set出力帳票(entity);
                executeStep(計算後情報作成);
                executeStep出力順登録();
                executeStep(本算定結果一覧表出力);
                break;
            }
        }
        executeStep(処理日付管理テーブル更新);
        if (getParameter().is画面移動フラグ()) {
            executeStep(本算定通知書一括発行フロー);
        }
    }

    private void executeStep出力順登録() {
        boolean contains徴収方法 = 出力順contains徴収方法();
        processParameter.setContains徴収方法(contains徴収方法);
        if (contains徴収方法) {
            executeStep(出力順登録);
        }
    }

    /**
     * 本算定特徴中止者の追加のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(本算定特徴中止者の追加)
    protected IBatchFlowCommand insertHonsanteiTokuchoChushisha() {
        return loopBatch(HonsanteiTokuchoChushishaTuikaProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算対象者抽出_通知書番号発番のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算対象者抽出_通知書番号発番)
    protected IBatchFlowCommand selectKeisanTaishosha() {
        return loopBatch(KeisanTaishoshaProcess.class).arguments(processParameter).define();
    }

    /**
     * 世帯員把握のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand collectSetaiin() {
        return loopBatch(SetaiinHaakuProcess.class).define();
    }

    /**
     * 世帯員把握バッチを呼び出です。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握フロー)
    protected IBatchFlowCommand setaiinBatchFlow() {
        return otherBatchFlow(世帯員把握BATCH_ID, SubGyomuCode.DBB介護賦課,
                new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード())).define();
    }

    /**
     * 賦課計算中間一時テーブルに登録のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_賦課)
    protected IBatchFlowCommand insFukaKeisanTemp() {
        return loopBatch(InsFukaKeisanTempProcess.class).define();
    }

    /**
     * 賦課計算中間一時テーブルに登録のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算_世帯員)
    protected IBatchFlowCommand insSetaiTemp() {
        return loopBatch(InsSetaiTempProcess.class).define();
    }

    /**
     * 賦課計算_賦課のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課計算)
    protected IBatchFlowCommand caluculateFuka() {
        return loopBatch(CaluculateFukaProcess.class).arguments(processParameter).define();
    }

    /**
     * 賦課情報登録メソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報登録)
    protected IBatchFlowCommand callChoteiToroku() {
        return otherBatchFlow(賦課の情報登録フローBATCHID, SubGyomuCode.DBB介護賦課,
                new DBB004001_FukaJohoTorokuParameter()).define();
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

    private DBB003001_KeisangoJohoSakuseiParameter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        return new DBB003001_KeisangoJohoSakuseiParameter(getParameter().get調定年度().toDateString(),
                getParameter().get賦課年度().toDateString(),
                new RString(システム日時.toString()),
                ShoriName.本算定賦課.get名称(), 帳票分類ID);
    }

    /**
     * 出力順に登録のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(出力順登録)
    protected IBatchFlowCommand insShuturyokuTempProcess() {
        return loopBatch(InsShuturyokuTempProcess.class).arguments(processParameter).define();
    }

    /**
     * 本算定結果一覧表出力のメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(本算定結果一覧表出力)
    protected IBatchFlowCommand spoolHonsanteiKekkaIchiran() {
        return loopBatch(HonsanteiKekkaIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 処理日付管理テーブル更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(処理日付管理テーブル更新)
    protected IBatchFlowCommand updateSystemTimeProcess() {
        return loopBatch(SystemTimeUpdateHonsanteiProcess.class).arguments(processParameter).define();
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

    private boolean 出力順contains徴収方法() {
        IOutputOrder 出力順情報;
        if (RString.isNullOrEmpty(processParameter.get出力帳票().get出力順ID())) {
            return false;
        } else {
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順情報 = finder.get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200009.getReportId(),
                    Long.parseLong(processParameter.get出力帳票().get出力順ID().toString()));
        }
        if (出力順情報 == null) {
            return false;
        }
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            if (徴収方法R.equals(item.get項目名())) {
                return true;
            }
        }
        return false;
    }

}
