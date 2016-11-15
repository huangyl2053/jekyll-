/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.DecideKetteiHenkoTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.HonsanteiTsuchishoTempTableDropProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.InitPrtKetteiTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.InsHonsanteiTsuchishoTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.InsZenkenFukaInfoTmpProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.PrtHenkoTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.PrtKetteiTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.PrtNonyuTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.PrtTokuchoKaishiTsuchishoHonsanteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdHonsanteiTsuchishoTmpKouseiMaeDataProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdHonsanteiTsuchishoTmpSeikahoboKubunProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdHonsanteiTsuchishoTmpTaisyoshaDataProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdHonsanteiTsuchishoTmpTokuchoAugProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdHonsanteiTsuchishoTmpTokuchoDecProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdZenkenFukaInfoTmpKouseiMaeDataProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdZenkenFukaInfoTmpSeikahoboKubunProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031003.UpdZenkenFukaInfoTmpTaisyoshaDataProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB031003.DBB031003_HonsanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定通知書一括発行するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class DBB031003_HonsanteiTsuchishoHakko extends BatchFlowBase<DBB031003_HonsanteiTsuchishoHakkoParameter> {

    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final String 最新調定日時の取得 = "getkijunTimestamp";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 計算後情報一時テーブル削除 = "dropKeisangoJohoTempProcess";

    private static final String 全件対象賦課情報取得 = "insZenkenFukaInfoTmpProcess";
    private static final String 計算後情報_更正前情報を更新_全件 = "updZenkenFukaInfoTmpKouseiMaeDataProcess";
    private static final String 対象者追加含む情報_更正前情報を更新_全件 = "updZenkenFukaInfoTmpTaisyoshaDataProcess";
    private static final String 生活保護区分を更新_全件 = "updZenkenFukaInfoTmpSeikahoboKubunProcess";

    private static final String 賦課情報の取得 = "insHonsanteiTsuchishoTmpProcess";
    private static final String 計算後情報_更正前情報を更新 = "updHonsanteiTsuchishoTmpKouseiMaeDataProcess";
    private static final String 対象者追加含む情報_更正前情報を更新 = "updHonsanteiTsuchishoTmpTaisyoshaDataProcess";
    private static final String 生活保護区分を更新 = "updHonsanteiTsuchishoTmpSeikahoboKubunProcess";

    private static final String 特徴8月開始者区分を更新 = "updHonsanteiTsuchishoTmpTokuchoAugProcess";
    private static final String 特徴10月開始者区分を更新 = "updHonsanteiTsuchishoTmpTokuchoDecProcess";

    private static final String 特徴開始通知書の発行 = "prtTokuchoKaishiTsuchishoHonsanteiProcess";

    private static final String 決定変更通知書出力判定 = "decideKetteiHenkoTsuchishoProcess";
    private static final String 決定通知書の発行 = "prtKetteiTsuchishoProcess";
    private static final String 変更通知書の発行 = "prtHenkoTsuchishoProcess";

    private static final String 納入通知書の発行 = "prtNonyuTsuchishoProcess";

    private static final RString BATCH_ID = new RString("DBB003001_KeisangoJohoSakusei");
    private DBB031003_HonsanteiTsuchishoHakkoParameter parameter;
    private RString バッチフロー_帳票分類ID;
    private HonsanteifukaProcessParameter processParameter;
    private YMDHMS システム日時;

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
        executeStep(最新調定日時の取得);
        List<HonsanteifukaBatchTyouhyou> 出力帳票一覧List = parameter.get出力帳票一覧();
        for (HonsanteifukaBatchTyouhyou 出力帳票一覧 : 出力帳票一覧List) {
            if (出力帳票一覧.get帳票ID() == null) {
                continue;
            }
            boolean 計算後情報作成区分 = false;
            processParameter = new HonsanteifukaProcessParameter(parameter.get調定年度(), parameter.get賦課年度(),
                    parameter.get資格基準日(), 出力帳票一覧, parameter.get特徴_出力対象(), parameter.get特徴_発行日(),
                    parameter.get決定変更_文書番号(), parameter.get決定変更_発行日(), parameter.get納入_出力方法(),
                    parameter.get納入_出力期(), parameter.get納入_対象者(),
                    parameter.get納入_発行日(), parameter.get納入_ページごとに山分け(),
                    parameter.get打分け条件情報(), parameter.get処理日時(), parameter.is一括発行起動フラグ(),
                    システム日時, parameter.get納入_生活保護対象者をまとめて先頭に出力(),
                    getResult(YMDHMS.class, new RString(最新調定日時の取得), InitPrtKetteiTsuchishoProcess.KIJUN_TIME));
            if (特別徴収開始通知書本算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                計算後情報作成区分 = true;
                バッチフロー_帳票分類ID = 特別徴収開始通知書本算定_帳票分類ID.getColumnValue();
                executeStep(計算後情報作成);
                executeStep(全件対象賦課情報取得);
                executeStep(計算後情報_更正前情報を更新_全件);
                executeStep(対象者追加含む情報_更正前情報を更新_全件);
                executeStep(生活保護区分を更新_全件);
                executeStep(特徴8月開始者区分を更新);
                executeStep(特徴10月開始者区分を更新);
                executeStep(特徴開始通知書の発行);
            } else if (決定変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID()) && is決定通知書(出力帳票一覧.get帳票ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 決定変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                    executeStep(全件対象賦課情報取得);
                } else {
                    executeStep(賦課情報の取得);
                }
                executeStep(計算後情報_更正前情報を更新);
                executeStep(対象者追加含む情報_更正前情報を更新);
                executeStep(生活保護区分を更新);
                executeStep(特徴8月開始者区分を更新);
                executeStep(特徴10月開始者区分を更新);
                executeStep(決定変更通知書出力判定);
                executeStep(決定通知書の発行);
            } else if (決定変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID()) && is変更通知書(出力帳票一覧.get帳票ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 決定変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                    executeStep(全件対象賦課情報取得);
                } else {
                    executeStep(賦課情報の取得);
                }
                executeStep(計算後情報_更正前情報を更新);
                executeStep(対象者追加含む情報_更正前情報を更新);
                executeStep(生活保護区分を更新);
                executeStep(特徴8月開始者区分を更新);
                executeStep(特徴10月開始者区分を更新);
                executeStep(決定変更通知書出力判定);
                executeStep(変更通知書の発行);
            } else if (納入通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 納入通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                    executeStep(全件対象賦課情報取得);
                } else {
                    executeStep(賦課情報の取得);
                }
                executeStep(計算後情報_更正前情報を更新);
                executeStep(対象者追加含む情報_更正前情報を更新);
                executeStep(生活保護区分を更新);
                executeStep(特徴8月開始者区分を更新);
                executeStep(特徴10月開始者区分を更新);
                executeStep(納入通知書の発行);
            }
            if (計算後情報作成区分) {
                executeStep(計算後情報一時テーブル削除);
            }
        }
    }

    /**
     * 最新調定日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(最新調定日時の取得)
    protected IBatchFlowCommand getkijunTimestamp() {
        HonsanteifukaProcessParameter para = new HonsanteifukaProcessParameter(parameter.get調定年度(), parameter.get賦課年度(),
                parameter.get資格基準日(), null, parameter.get特徴_出力対象(), parameter.get特徴_発行日(),
                parameter.get決定変更_文書番号(), parameter.get決定変更_発行日(), parameter.get納入_出力方法(),
                parameter.get納入_出力期(), parameter.get納入_対象者(),
                parameter.get納入_発行日(), parameter.get納入_ページごとに山分け(),
                parameter.get打分け条件情報(), parameter.get処理日時(), parameter.is一括発行起動フラグ(), null,
                parameter.get納入_生活保護対象者をまとめて先頭に出力(), null);
        return simpleBatch(InitPrtKetteiTsuchishoProcess.class).arguments(para).define();
    }

    /**
     * 計算後情報一時テーブル削除するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報一時テーブル削除)
    protected IBatchFlowCommand dropKeisangoJohoTempProcess() {
        return simpleBatch(HonsanteiTsuchishoTempTableDropProcess.class).define();
    }

    /**
     * 全件対象賦課情報取得するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(全件対象賦課情報取得)
    protected IBatchFlowCommand insZenkenFukaInfoTmpProcess() {
        HonsanteifukaProcessParameter tempParameter = processParameter;
        tempParameter.set賦課年度(processParameter.get調定年度());
        return loopBatch(InsZenkenFukaInfoTmpProcess.class).arguments(tempParameter).define();
    }

    /**
     * 賦課情報の取得するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(賦課情報の取得)
    protected IBatchFlowCommand insHonsanteiTsuchishoTmpProcess() {
        HonsanteifukaProcessParameter tempParameter = processParameter;
        tempParameter.set賦課年度(processParameter.get調定年度());
        return loopBatch(InsHonsanteiTsuchishoTmpProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算後情報「更正前」情報を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報_更正前情報を更新_全件)
    protected IBatchFlowCommand updZenkenFukaInfoTmpKouseiMaeDataProcess() {
        return simpleBatch(UpdZenkenFukaInfoTmpKouseiMaeDataProcess.class).define();
    }

    /**
     * 更正前の対象者（追加含む）情報を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(対象者追加含む情報_更正前情報を更新_全件)
    protected IBatchFlowCommand updZenkenFukaInfoTmpTaisyoshaDataProcess() {
        return simpleBatch(UpdZenkenFukaInfoTmpTaisyoshaDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 生活保護区分を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(生活保護区分を更新_全件)
    protected IBatchFlowCommand updZenkenFukaInfoTmpSeikahoboKubunProcess() {
        return simpleBatch(UpdZenkenFukaInfoTmpSeikahoboKubunProcess.class).define();
    }

    /**
     * 特徴8月開始者区分を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴8月開始者区分を更新)
    protected IBatchFlowCommand updHonsanteiTsuchishoTmpTokuchoAugProcess() {
        return simpleBatch(UpdHonsanteiTsuchishoTmpTokuchoAugProcess.class).define();
    }

    /**
     * 特徴10月開始者区分を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴10月開始者区分を更新)
    protected IBatchFlowCommand updHonsanteiTsuchishoTmpTokuchoDecProcess() {
        return simpleBatch(UpdHonsanteiTsuchishoTmpTokuchoDecProcess.class).define();
    }

    /**
     * 計算後情報「更正前」情報を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報_更正前情報を更新)
    protected IBatchFlowCommand updHonsanteiTsuchishoTmpKouseiMaeDataProcess() {
        return simpleBatch(UpdHonsanteiTsuchishoTmpKouseiMaeDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 更正前の対象者（追加含む）情報を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(対象者追加含む情報_更正前情報を更新)
    protected IBatchFlowCommand updHonsanteiTsuchishoTmpTaisyoshaDataProcess() {
        return simpleBatch(UpdHonsanteiTsuchishoTmpTaisyoshaDataProcess.class).arguments(processParameter).define();
    }

    /**
     * 生活保護区分を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(生活保護区分を更新)
    protected IBatchFlowCommand updHonsanteiTsuchishoTmpSeikahoboKubunProcess() {
        return simpleBatch(UpdHonsanteiTsuchishoTmpSeikahoboKubunProcess.class).define();
    }

    /**
     * 特徴開始通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴開始通知書の発行)
    protected IBatchFlowCommand prtTokuchoKaishiTsuchishoHonsanteiProcess() {
        return loopBatch(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定変更通知書出力判定するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(決定変更通知書出力判定)
    protected IBatchFlowCommand decideKetteiHenkoTsuchishoProcess() {
        return loopBatch(DecideKetteiHenkoTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(決定通知書の発行)
    protected IBatchFlowCommand prtKetteiTsuchishoProcess() {
        return loopBatch(PrtKetteiTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(変更通知書の発行)
    protected IBatchFlowCommand prtHenkoTsuchishoProcess() {
        return loopBatch(PrtHenkoTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(納入通知書の発行)
    protected IBatchFlowCommand prtNonyuTsuchishoProcess() {
        return loopBatch(PrtNonyuTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, getKeisangoJohoSakuseiBatchParamter(バッチフロー_帳票分類ID)).define();
    }

    private DBB003001_KeisangoJohoSakuseiParameter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        if (バッチフロー_帳票分類ID.equals(特別徴収開始通知書本算定_帳票分類ID.getColumnValue())) {
            return new DBB003001_KeisangoJohoSakuseiParameter(getParameter().get調定年度().toDateString(),
                    getParameter().get賦課年度().toDateString(), null, ShoriName.本算定賦課.get名称(), 帳票分類ID);
        }
        return new DBB003001_KeisangoJohoSakuseiParameter(getParameter().get調定年度().toDateString(),
                getParameter().get賦課年度().toDateString(),
                getResult(YMDHMS.class, new RString(最新調定日時の取得), InitPrtKetteiTsuchishoProcess.KIJUN_TIME).toDateString(),
                ShoriName.本算定賦課.get名称(), 帳票分類ID);
    }

    private boolean is決定通知書(ReportId 帳票ID) {

        if (ReportIdDBB.DBB100039.getReportId().equals(帳票ID)) {
            return true;
        } else if (ReportIdDBB.DBB100040.getReportId().equals(帳票ID)) {
            return true;
        }
        return false;
    }

    private boolean is変更通知書(ReportId 帳票ID) {

        if (ReportIdDBB.DBB100042.getReportId().equals(帳票ID)) {
            return true;
        } else if (ReportIdDBB.DBB100043.getReportId().equals(帳票ID)) {
            return true;
        }
        return false;
    }
}
