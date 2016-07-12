/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbbbt44002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.HonsanteiIdoGennendoTempTableCreatProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.HonsanteiIdoGennendoTempTableDropProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.IdoSystemTimeSakuseiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.InsIdoTsuchishoHakkogoIdoshaHenkoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.InsIdoTsuchishoHakkogoIdoshaKetteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.InsIdoTsuchishoHakkogoIdoshaNonyuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.InsIdoTsuchishoHakkogoIdoshaTokuchoKaishiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.PrtIdoHenkoTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.PrtIdoKetteTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.PrtIdoNonyuTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.PrtIdoTokuchoKaishiTsuchishoHonsanteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44002.PrtIdoTokuchoKaishiTsuchishoKarisanteiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.CreateHonsanteiIdoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoHoniOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44002.HonsanteiIdoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（現年度）通知書一括発行するクラスです。
 *
 * @reamsid_L DBB-0880-030 xicongwang
 */
public class HonsanteiIdoGennendoTsuchisyoIkatsuHakoFlow extends BatchFlowBase<CreateHonsanteiIdoBatchParameter> {

    private static final RString 帳票タイプ_期毎 = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振型4 = new RString("銀振型4期タイプ");
    private static final RString 帳票タイプ_銀振型5 = new RString("銀振型5期タイプ");
    private static final RString 帳票タイプ_ブック = new RString("ブックタイプ");
    private static final RString 帳票タイプ_コンビニ = new RString("コンビニ収納タイプ");
    private static final RString 全件対象 = new RString("1");
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_14 = 14;
    private static final ReportId 特徴開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final ReportId 特別徴収開始通知書仮算定_帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final String システム日時の取得 = "getSystemDate";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 計算後情報一時テーブル削除 = "dropKeisangoJohoTempProcess";
    private static final String CREAT_PROCESS = "creatTmpProcess";
    private static final String 特徴開始通知書本算定の発行 = "prtIdoTokuchoKaishiTsuchishoHonsanteiProcess";
    private static final String 特徴開始通知書仮算定の発行 = "prtIdoTokuchoKaishiTsuchishoKarisanteiProcess";
    private static final String 特徴開始通知書発行後異動者登録 = "insIdoTsuchishoHakkogoIdoshaTokuchoKaishiProcess";
    private static final String 決定通知書の発行 = "prtIdoKetteTsuchishoProcess";
    private static final String 決定通知書発行後異動者登録 = "insIdoTsuchishoHakkogoIdoshaKetteiProcess";
    private static final String 変更通知書の発行 = "prtIdoHenkoTsuchishoProcess";
    private static final String 変更通知書発行後異動者登録 = "insIdoTsuchishoHakkogoIdoshaHenkoProcess";
    private static final String 納入通知書の発行 = "prtIdoNonyuTsuchishoProcess";
    private static final String 納入通知書発行後異動者登録 = "insIdoTsuchishoHakkogoIdoshaNonyuProcess";

    private static final RString チェックボックス_出力 = new RString("1");
    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private CreateHonsanteiIdoBatchParameter parameter;
    private RString バッチフロー_帳票分類ID;
    private HonsanteiIdoProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票List() == null || parameter.get出力帳票List().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        executeStep(CREAT_PROCESS);
        List<ChohyoResult> 出力帳票一覧List = parameter.get出力帳票List();
        for (ChohyoResult 出力帳票一覧 : 出力帳票一覧List) {
            if (RString.isNullOrEmpty(出力帳票一覧.get帳票ID())) {
                continue;
            }
            boolean 計算後情報作成区分;
            processParameter = new HonsanteiIdoProcessParameter(parameter.getChoteiNendo(), parameter.get賦課年度(),
                    parameter.get処理対象(), 出力帳票一覧, parameter.get特徴_出力対象(), parameter.get特徴_発行日(),
                    parameter.get決定_チェックボックス(), parameter.get決定_文書番号(), parameter.get決定_発行日(),
                    parameter.get変更_チェックボックス(), parameter.get変更_対象者(), parameter.get変更_文書番号(), parameter.get変更_発行日(),
                    parameter.get納入_出力方法(), parameter.get納入_出力期(), parameter.get納入_対象者(),
                    parameter.get納入_発行日(), parameter.get納入_口座振替者(),
                    parameter.get納入_ページごとに山分け(), parameter.is随時フラグ(), parameter.is一括発行起動フラグ(),
                    getResult(YMDHMS.class, new RString(システム日時の取得), IdoSystemTimeSakuseiProcess.SYSTEM_TIME),
                    parameter.get納入_生活保護対象者());
            計算後情報作成区分 = publish特徴開始通知書(出力帳票一覧);
            if (決定変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())
                    && チェックボックス_出力.equals(parameter.get決定_チェックボックス()) && is決定通知書(出力帳票一覧.get帳票ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 決定変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(決定通知書の発行);
                executeStep(決定通知書発行後異動者登録);
            } else if (決定変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())
                    && チェックボックス_出力.equals(parameter.get変更_チェックボックス()) && is変更通知書(出力帳票一覧.get帳票ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 決定変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(変更通知書の発行);
                executeStep(変更通知書発行後異動者登録);
            } else if (納入通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                RString 帳票タイプ = get帳票タイプBy通知書帳票ID(new ReportId(出力帳票一覧.get帳票ID()));
                RString 普徴期情報_処理対象 = get普徴期情報(parameter.get納入_出力期());
                if (帳票タイプ_期毎.equals(帳票タイプ) || 全件対象.equals(普徴期情報_処理対象)) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 納入通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                } else if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 納入通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(納入通知書の発行);
                executeStep(納入通知書発行後異動者登録);
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
        HonsanteiIdoProcessParameter para = new HonsanteiIdoProcessParameter(parameter.getChoteiNendo(), parameter.get賦課年度(),
                parameter.get処理対象(), null, parameter.get特徴_出力対象(), parameter.get特徴_発行日(),
                parameter.get決定_チェックボックス(), parameter.get決定_文書番号(), parameter.get決定_発行日(),
                parameter.get変更_チェックボックス(), parameter.get変更_対象者(), parameter.get変更_文書番号(), parameter.get変更_発行日(),
                parameter.get納入_出力方法(), parameter.get納入_出力期(), parameter.get納入_対象者(),
                parameter.get納入_発行日(), parameter.get納入_口座振替者(),
                parameter.get納入_ページごとに山分け(), parameter.is随時フラグ(), parameter.is一括発行起動フラグ(),
                null, parameter.get納入_生活保護対象者());
        return simpleBatch(IdoSystemTimeSakuseiProcess.class).arguments(para).define();
    }

    /**
     * 一時テーブル作成するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(CREAT_PROCESS)
    protected IBatchFlowCommand creatTmpProcess() {
        return simpleBatch(HonsanteiIdoGennendoTempTableCreatProcess.class).define();
    }

    /**
     * 計算後情報一時テーブル削除するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報一時テーブル削除)
    protected IBatchFlowCommand dropKeisangoJohoTempProcess() {
        return simpleBatch(HonsanteiIdoGennendoTempTableDropProcess.class).define();
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
        return new KeisangoJohoSakuseiBatchParamter(getParameter().getChoteiNendo().toDateString(),
                getParameter().get賦課年度().toDateString(),
                getResult(RString.class, new RString(システム日時の取得), IdoSystemTimeSakuseiProcess.KIJUN_TIME),
                ShoriName.異動賦課.get名称(), 帳票分類ID);
    }

    /**
     * 特徴開始通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴開始通知書本算定の発行)
    protected IBatchFlowCommand prtIdoTokuchoKaishiTsuchishoHonsanteiProcess() {
        return simpleBatch(PrtIdoTokuchoKaishiTsuchishoHonsanteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 特徴開始通知書仮算定の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴開始通知書仮算定の発行)
    protected IBatchFlowCommand prtIdoTokuchoKaishiTsuchishoKarisanteiProcess() {
        return simpleBatch(PrtIdoTokuchoKaishiTsuchishoKarisanteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 特徴開始通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴開始通知書発行後異動者登録)
    protected IBatchFlowCommand insIdoTsuchishoHakkogoIdoshaTokuchoKaishiProcess() {
        return simpleBatch(InsIdoTsuchishoHakkogoIdoshaTokuchoKaishiProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(決定通知書の発行)
    protected IBatchFlowCommand prtIdoKetteTsuchishoProcess() {
        return simpleBatch(PrtIdoKetteTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(決定通知書発行後異動者登録)
    protected IBatchFlowCommand insIdoTsuchishoHakkogoIdoshaKetteiProcess() {
        return simpleBatch(InsIdoTsuchishoHakkogoIdoshaKetteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(変更通知書の発行)
    protected IBatchFlowCommand prtIdoHenkoTsuchishoProcess() {
        return simpleBatch(PrtIdoHenkoTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(変更通知書発行後異動者登録)
    protected IBatchFlowCommand insIdoTsuchishoHakkogoIdoshaHenkoProcess() {
        return simpleBatch(InsIdoTsuchishoHakkogoIdoshaHenkoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(納入通知書の発行)
    protected IBatchFlowCommand prtIdoNonyuTsuchishoProcess() {
        return simpleBatch(PrtIdoNonyuTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(納入通知書発行後異動者登録)
    protected IBatchFlowCommand insIdoTsuchishoHakkogoIdoshaNonyuProcess() {
        return simpleBatch(InsIdoTsuchishoHakkogoIdoshaNonyuProcess.class).arguments(processParameter).define();
    }

    private boolean publish特徴開始通知書(ChohyoResult 出力帳票一覧) {
        boolean 計算後情報作成区分 = false;
        if (特徴開始通知書本算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())
                && (TokuchoKaishiTsuhishoHoniOutputJoken._12月特徴開始者のみ.getコード().equals(parameter.get特徴_出力対象())
                || TokuchoKaishiTsuhishoHoniOutputJoken._2月特徴開始者のみ.getコード().equals(parameter.get特徴_出力対象()))) {
            計算後情報作成区分 = true;
            バッチフロー_帳票分類ID = 特徴開始通知書本算定_帳票分類ID.getColumnValue();
            executeStep(計算後情報作成);
            executeStep(特徴開始通知書本算定の発行);
            executeStep(特徴開始通知書発行後異動者登録);
        } else if (特別徴収開始通知書仮算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())
                && TokuchoKaishiTsuhishoHoniOutputJoken._4月特徴開始者のみ.getコード().equals(parameter.get特徴_出力対象())) {
            executeStep(特徴開始通知書仮算定の発行);
            executeStep(特徴開始通知書発行後異動者登録);
        }
        return 計算後情報作成区分;
    }

    private boolean is決定通知書(RString 帳票ID) {

        if (ReportIdDBB.DBB100039.getReportId().getColumnValue().equals(帳票ID)) {
            return true;
        } else if (ReportIdDBB.DBB100040.getReportId().getColumnValue().equals(帳票ID)) {
            return true;
        }
        return false;
    }

    private boolean is変更通知書(RString 帳票ID) {

        if (ReportIdDBB.DBB100042.getReportId().getColumnValue().equals(帳票ID)) {
            return true;
        } else if (ReportIdDBB.DBB100043.getReportId().getColumnValue().equals(帳票ID)) {
            return true;
        }
        return false;
    }

    private RString get帳票タイプBy通知書帳票ID(ReportId 帳票ID) {

        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100045.getReportId().equals(帳票ID) || ReportIdDBB.DBB100046.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100063.getReportId().equals(帳票ID) || ReportIdDBB.DBB100064.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎;
        } else if (ReportIdDBB.DBB100053.getReportId().equals(帳票ID) || ReportIdDBB.DBB100054.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型5;
        } else if (ReportIdDBB.DBB100051.getReportId().equals(帳票ID) || ReportIdDBB.DBB100052.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型4;
        } else if (ReportIdDBB.DBB100055.getReportId().equals(帳票ID) || ReportIdDBB.DBB100056.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100057.getReportId().equals(帳票ID) || ReportIdDBB.DBB100058.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブック;
        } else if (ReportIdDBB.DBB100059.getReportId().equals(帳票ID) || ReportIdDBB.DBB100060.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100061.getReportId().equals(帳票ID) || ReportIdDBB.DBB100062.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_コンビニ;
        }
        return 帳票タイプ;
    }

    private RString get普徴期情報(RString 出力期) {

        RString 普徴期情報_処理対象;
        RDate 運用日 = RDate.getNowDate();
        switch (Integer.parseInt(出力期.toString())) {
            case INT_1:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象1, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_2:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象2, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_3:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象3, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_4:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象4, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_5:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象5, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_6:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象6, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_7:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象7, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_8:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象8, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_9:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象9, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_10:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象10, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_11:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象11, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_12:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象12, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_13:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象13, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            case INT_14:
                普徴期情報_処理対象 = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_処理対象14, 運用日, SubGyomuCode.DBB介護賦課);
                break;
            default:
                普徴期情報_処理対象 = RString.EMPTY;
                break;
        }
        return 普徴期情報_処理対象;
    }
}
