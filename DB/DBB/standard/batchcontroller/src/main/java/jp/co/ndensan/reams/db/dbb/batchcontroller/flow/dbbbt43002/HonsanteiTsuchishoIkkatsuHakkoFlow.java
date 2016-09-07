/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbbbt43002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.HonsanteiTsuchishoTempTableCreatProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.HonsanteiTsuchishoTempTableDropProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.InsTsuchishoHakkogoIdoshaHenkoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.InsTsuchishoHakkogoIdoshaKetteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.InsTsuchishoHakkogoIdoshaNonyuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.InsTsuchishoHakkogoIdoshaTokuchoKaishiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.PrtHenkoTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.PrtKetteiTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.PrtNonyuTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.PrtTokuchoKaishiTsuchishoHonsanteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002.SystemTimeSakuseiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
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
public class HonsanteiTsuchishoIkkatsuHakkoFlow extends BatchFlowBase<HonsanteifukaBatchParameter> {

    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final String システム日時の取得 = "getSystemDate";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 計算後情報一時テーブル削除 = "dropKeisangoJohoTempProcess";
    private static final String CREAT_PROCESS = "creatTmpProcess";
    private static final String 特徴開始通知書の発行 = "prtTokuchoKaishiTsuchishoHonsanteiProcess";
    private static final String 特徴開始通知書発行後異動者登録 = "insTsuchishoHakkogoIdoshaTokuchoKaishiProcess";
    private static final String PRINT_KETTEITSUCHISHO_PROCESS = "prtKetteiTsuchishoProcess";
    private static final String INSERT_KETTEITSUCHISHO_PROCESS = "insTsuchishoHakkogoIdoshaKetteiProcess";
    private static final String PRINT_HENKOTSUCHISHO_PROCESS = "prtHenkoTsuchishoProcess";
    private static final String INSERT_HENKOTSUCHISHO_PROCESS = "insTsuchishoHakkogoIdoshaHenkoProcess";
    private static final String PRINT_NONYUTSUCHISHO_PROCESS = "prtNonyuTsuchishoProcess";
    private static final String INSERT_NONYUTSUCHISHO_PROCESS = "insTsuchishoHakkogoIdoshaNonyuProcess";

    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private HonsanteifukaBatchParameter parameter;
    private RString バッチフロー_帳票分類ID;
    private HonsanteifukaProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票一覧() == null || parameter.get出力帳票一覧().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        executeStep(CREAT_PROCESS);
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
                    getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeSakuseiProcess.SYSTEM_TIME),
                    parameter.get納入_生活保護対象者をまとめて先頭に出力());
            if (特別徴収開始通知書本算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                計算後情報作成区分 = true;
                バッチフロー_帳票分類ID = 特別徴収開始通知書本算定_帳票分類ID.getColumnValue();
                executeStep(計算後情報作成);
                executeStep(特徴開始通知書の発行);
                executeStep(特徴開始通知書発行後異動者登録);
            } else if (決定変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID()) && is決定通知書(出力帳票一覧.get帳票ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 決定変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(PRINT_KETTEITSUCHISHO_PROCESS);
                executeStep(INSERT_KETTEITSUCHISHO_PROCESS);
            } else if (決定変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID()) && is変更通知書(出力帳票一覧.get帳票ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 決定変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(PRINT_HENKOTSUCHISHO_PROCESS);
                executeStep(INSERT_HENKOTSUCHISHO_PROCESS);
            } else if (納入通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 納入通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(PRINT_NONYUTSUCHISHO_PROCESS);
                executeStep(INSERT_NONYUTSUCHISHO_PROCESS);
            }
            if (計算後情報作成区分) {
                executeStep(計算後情報一時テーブル削除);
            }
        }
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        HonsanteifukaProcessParameter para = new HonsanteifukaProcessParameter(parameter.get調定年度(), parameter.get賦課年度(),
                parameter.get資格基準日(), null, parameter.get特徴_出力対象(), parameter.get特徴_発行日(),
                parameter.get決定変更_文書番号(), parameter.get決定変更_発行日(), parameter.get納入_出力方法(),
                parameter.get納入_出力期(), parameter.get納入_対象者(),
                parameter.get納入_発行日(), parameter.get納入_ページごとに山分け(),
                parameter.get打分け条件情報(), parameter.get処理日時(), parameter.is一括発行起動フラグ(), null,
                parameter.get納入_生活保護対象者をまとめて先頭に出力());
        return simpleBatch(SystemTimeSakuseiProcess.class).arguments(para).define();
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
     * 本算定通知書一時テーブル作成するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(CREAT_PROCESS)
    protected IBatchFlowCommand creatTmpProcess() {
        return simpleBatch(HonsanteiTsuchishoTempTableCreatProcess.class).define();
    }

    /**
     * 特徴開始通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(特徴開始通知書の発行)
    protected IBatchFlowCommand prtTokuchoKaishiTsuchishoHonsanteiProcess() {
        return simpleBatch(PrtTokuchoKaishiTsuchishoHonsanteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 特徴開始通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(特徴開始通知書発行後異動者登録)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaTokuchoKaishiProcess() {
        return simpleBatch(InsTsuchishoHakkogoIdoshaTokuchoKaishiProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRINT_KETTEITSUCHISHO_PROCESS)
    protected IBatchFlowCommand prtKetteiTsuchishoProcess() {
        return simpleBatch(PrtKetteiTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_KETTEITSUCHISHO_PROCESS)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaKetteiProcess() {
        return simpleBatch(InsTsuchishoHakkogoIdoshaKetteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRINT_HENKOTSUCHISHO_PROCESS)
    protected IBatchFlowCommand prtHenkoTsuchishoProcess() {
        return simpleBatch(PrtHenkoTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_HENKOTSUCHISHO_PROCESS)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaHenkoProcess() {
        return simpleBatch(InsTsuchishoHakkogoIdoshaHenkoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRINT_NONYUTSUCHISHO_PROCESS)
    protected IBatchFlowCommand prtNonyuTsuchishoProcess() {
        return simpleBatch(PrtNonyuTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_NONYUTSUCHISHO_PROCESS)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaNonyuProcess() {
        return simpleBatch(InsTsuchishoHakkogoIdoshaNonyuProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakusei() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(バッチフロー_帳票分類ID)).define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().toDateString(),
                getParameter().get賦課年度().toDateString(), null, ShoriName.本算定賦課.get名称(), 帳票分類ID);
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
