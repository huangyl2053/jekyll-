/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.FukaTsujoIdoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.HonsanteiIdoKekkaIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.IdoJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.IdoTriggerTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.KeisangoJohoDelete;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.PrtMeisaiIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.SetaiinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.SystemTimeGennendoIdoFukaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.SystemTimeUpdateProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.TokuchoIraikinProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.TokuchoKaishishaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB051001.TsuchishoNoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001.DBB004001_FukaJohoTorokuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB051001.DBB051001_GennendoIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.PrtMeisaiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.DBB002001.DBB002001_SetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（現年度）クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class DBB051001_GennendoIdoFuka extends BatchFlowBase<DBB051001_GennendoIdoFukaParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 特別徴収開始者抽出 = "selectTokuchoKaishisha";
    private static final String 異動対象者抽出 = "selectIdoJoho";
    private static final String 異動トリガーTEMP作成 = "createIdoTriggerTemp";
    private static final String 通知書番号発番 = "getTsuchishoNo";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 世帯員把握フロー = "setaiinBatchFlow";
    private static final String 本算定異動_現年度_通知書一括発行 = "honsanteiIdoGennendoTsuchisyoIkatsuHakoFlow";
    private static final RString 世帯員把握BATCH_ID = new RString("DBB002001_SetaiinHaaku");
    private static final RString 本算定異動_現年度_通知書一括発行BATCH_ID = new RString("DBB051003_GennendoIdoTsuchishoHakko");
    private static final String 賦課計算 = "calculateFukaTsujoIdo";
    private static final String 特徴依頼金計算_４月開始 = "calculateTokuchoIraikin4gatsuKaishi";
    private static final String 賦課の情報登録フロー = "choteiToroku";
    private static final RString 賦課の情報登録フローBATCHID = new RString("DBB004001_FukaJohoToroku");
    private static final RString 計算後情報作成BATCH_ID = new RString("DBB003001_KeisangoJohoSakusei");
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 計算後情報テーブル削除 = "keisangoJohoDelete";
    private static final String 本算定異動_現年度_結果一覧表 = "spoolHonsanteiIdoKekkaIchiranData";
    private static final String 特別徴収依頼金額明細一覧表 = "prtMeisaiIchiranProcess";
    private static final String 処理日付管理テーブル更新 = "updateSystemTimeProcess";
    private static final ReportId 帳票分類ID = new ReportId("DBB200015_HonsanteiIdouKekkaIchiran");
    private static final ReportId 帳票ID = ReportIdDBB.DBB200023.getReportId();
    
    private static final RString 依頼金額計算_1 = new RString("1");
    private static final RString 特徴開始月_4 = new RString("特徴開始月：4月（捕捉月：10月）");
    
    private DBB051001_GennendoIdoFukaParameter parameter;
    private GennendoIdoFukaProcessParameter processParameter;
    private PrtMeisaiIchiranProcessParameter prtMeisaiIchiranProcessParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票List() == null || parameter.get出力帳票List().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        YMDHMS システム日時 = getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeGennendoIdoFukaProcess.SYSTEM_TIME);
        processParameter = new GennendoIdoFukaProcessParameter();
        prtMeisaiIchiranProcessParameter = new PrtMeisaiIchiranProcessParameter();
        processParameter.set賦課年度(parameter.get賦課年度());
        processParameter.set処理対象(parameter.get処理対象());
        executeStep(特別徴収開始者抽出);
        processParameter.set調定年度(parameter.getChoteiNendo());
        processParameter.set調定日時(システム日時.getRDateTime());
        processParameter.set抽出開始日時(parameter.get抽出開始日時().getRDateTime());
        processParameter.set抽出終了日時(parameter.get抽出終了日時().getRDateTime());
        executeStep(異動対象者抽出);
        processParameter.set特徴捕捉対象者の依頼金額計算(parameter.get依頼金額計算());
        processParameter.set異動賦課で同時に計算する特徴捕捉分(parameter.get特徴捕捉分());
        executeStep(異動トリガーTEMP作成);
        executeStep(通知書番号発番);
        executeStep(世帯員把握);
        executeStep(世帯員把握フロー);
        
        if(依頼金額計算_1.equals(parameter.get依頼金額計算())&&特徴開始月_4.equals(parameter.get特徴捕捉分())){
            executeStep(特徴依頼金計算_４月開始);
        }else{
            executeStep(賦課計算);
            executeStep(特徴依頼金計算_４月開始);
            
        }
        executeStep(賦課の情報登録フロー);
        executeStep(計算後情報テーブル削除);
        executeStep(計算後情報作成);
        for (ChohyoResult entity : parameter.get出力帳票List()) {
            if (帳票分類ID.equals(entity.get帳票分類ID())) {
                processParameter.set出力帳票一覧(entity);
                if (Tsuki._2月.getコード().equals(parameter.get処理対象())) {
                    processParameter.set調定年度(parameter.getChoteiNendo().plusYear(1));
                    processParameter.set賦課年度(parameter.get賦課年度().plusYear(1));
                }
                executeStep(本算定異動_現年度_結果一覧表);
                continue;
            }
            if (帳票ID.equals(entity.get帳票分類ID())) {
                prtMeisaiIchiranProcessParameter.set出力帳票一覧(entity);
                prtMeisaiIchiranProcessParameter.set調定日時(システム日時.getRDateTime());
                executeStep(特別徴収依頼金額明細一覧表);
            }
        }

        executeStep(処理日付管理テーブル更新);
        if (!getParameter().is画面移動フラグ()) {
            executeStep(本算定異動_現年度_通知書一括発行);
        }

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
                new DBB002001_SetaiinHaakuParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード())).define();
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
     * 賦課の情報登録フローを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(賦課の情報登録フロー)
    protected IBatchFlowCommand choteiToroku() {
        return otherBatchFlow(賦課の情報登録フローBATCHID, SubGyomuCode.DBB介護賦課,
                new DBB004001_FukaJohoTorokuParameter()).define();
    }

    /**
     * 計算後情報テーブル削除を行います。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報テーブル削除)
    protected IBatchFlowCommand keisangoJohoDelete() {
        return simpleBatch(KeisangoJohoDelete.class).define();
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
        FlexibleYear 調定年度 = getParameter().getChoteiNendo();
        FlexibleYear 賦課年度 = getParameter().get賦課年度();
        if (parameter != null && Tsuki._2月.getコード().equals(parameter.get処理対象())) {
            調定年度 = 調定年度.plusYear(1);
            賦課年度 = 賦課年度.plusYear(1);
        }
        return new DBB003001_KeisangoJohoSakuseiParameter(調定年度.toDateString(),
                賦課年度.toDateString(),
                new RString(getResult(YMDHMS.class, new RString(システム日時の取得),
                        SystemTimeGennendoIdoFukaProcess.SYSTEM_TIME).toString()),
                ShoriName.異動賦課.get名称(), 帳票分類ID);
    }

    /**
     * 本算定異動（現年度）結果一覧表出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(本算定異動_現年度_結果一覧表)
    protected IBatchFlowCommand spoolHonsanteiIdoKekkaIchiranData() {
        return simpleBatch(HonsanteiIdoKekkaIchiranProcess.class).arguments(processParameter).define();
    }

    /**
     * 特別徴収依頼金額明細一覧表出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(特別徴収依頼金額明細一覧表)
    protected IBatchFlowCommand prtMeisaiIchiranProcess() {
        return loopBatch(PrtMeisaiIchiranProcess.class).arguments(prtMeisaiIchiranProcessParameter).define();
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

    /**
     * 本算定異動（現年度）通知書一括発行を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(本算定異動_現年度_通知書一括発行)
    protected IBatchFlowCommand honsanteiIdoGennendoTsuchisyoIkatsuHakoFlow() {
        return otherBatchFlow(本算定異動_現年度_通知書一括発行BATCH_ID, SubGyomuCode.DBB介護賦課,
                getParameter().toDBB051003_GennendoIdoTsuchishoHakkoParameter()).define();
    }

}
