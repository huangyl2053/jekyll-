/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbbbt36002;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.InsKarisanteigakuHenkoTsuchishoHakkogoIdoshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.InsNonyuTsuchishoHakkogoIdoshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.InsTokuchouKaishiTutishoHakkougoIdoushaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.KarisanteiIdoTsuchishoTempCreatProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.KarisanteiIdoTsuchishoTempDropProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.PntKarisanteiNonyuTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.PntKarisanteigakuHenkoTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.PntTokuchouKaishiTutishoKarisanteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36002.SystemTimeSyutokuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.KarisanteiIdoFukaParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka.TyouhyouEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定異動通知書一括発行するクラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class KarisanteiIdoTsuchishoIkkatsuHakkoFlow extends BatchFlowBase<KarisanteiIdoFukaParameter> {

    private static final RString 帳票タイプ_期毎 = new RString("期毎タイプ");
    private static final RString 帳票タイプ_銀振型4 = new RString("銀振型4期タイプ");
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
    private static final ReportId 特別徴収開始通知書仮算定帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 仮算定額変更通知書_帳票分類ID = new ReportId("DBB100010_KarisanteiHenkoTsuchishoDaihyo");
    private static final ReportId 納入通知書仮算定_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final String システム日時の取得 = "getSystemDate";
    private static final String CREAT_PROCESS = "creatTmpProcess";
    private static final String 計算後情報一時テーブル削除 = "dropKeisangoJohoTempProcess";
    private static final String 計算後情報作成 = "keisangoJohoSakuseiProcess";
    private static final String 特徴開始通知書仮算定発行 = "pntTokuchouKaishiTutishoKarisanteiProcess";
    private static final String 特徴開始通知書発行後異動者登録 = "insTokuchouKaishiTutishoHakkougoIdoushaProcess";
    private static final String 仮算定額変更通知書発行 = "pntKarisanteigakuHenkoTsuchishoProcess";
    private static final String 仮算定額変更通知書発行後異動者登録 = "insKarisanteigakuHenkoTsuchishoHakkogoIdoshaProcess";
    private static final String 納入通知書仮算定発行 = "pntKarisanteiNonyuTsuchishoProcess";
    private static final String 納入通知書発行後異動者登録 = "insNonyuTsuchishoHakkogoIdoshaProcess";

    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private RString バッチフロー_帳票分類ID;
    private KarisanteiIdoFukaProcessParameter processParameter;

    private KarisanteiIdoFukaParameter parameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票一覧List() == null || parameter.get出力帳票一覧List().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        executeStep(CREAT_PROCESS);
        List<TyouhyouEntity> 出力帳票一覧List = parameter.get出力帳票一覧List();
        for (TyouhyouEntity 出力帳票一覧 : 出力帳票一覧List) {
            if (出力帳票一覧.get帳票ID() == null) {
                continue;
            }
            boolean 計算後情報作成区分 = false;
            processParameter = new KarisanteiIdoFukaProcessParameter(new FlexibleYear(parameter.get調定年度()),
                    new FlexibleYear(parameter.get賦課年度()), 出力帳票一覧, new RDate(parameter.get特徴_発行日().toString()),
                    new RDate(parameter.get仮算定額変更_発行日().toString()), parameter.get文書番号(), parameter.get納入_出力期(),
                    parameter.get納入_出力方式(), new RDate(parameter.get納入_発行日().toString()), parameter.get納入_対象者(),
                    parameter.get納入_生活保護対象者(), parameter.get納入_ページごとに山分け(), parameter.is一括発行起動フラグ(),
                    getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeSyutokuProcess.SYSTEM_TIME));
            if (特別徴収開始通知書仮算定帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                計算後情報作成区分 = true;
                バッチフロー_帳票分類ID = 特別徴収開始通知書仮算定帳票分類ID.getColumnValue();
                executeStep(計算後情報作成);
                executeStep(特徴開始通知書仮算定発行);
                executeStep(特徴開始通知書発行後異動者登録);
            } else if (仮算定額変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 仮算定額変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(仮算定額変更通知書発行);
                executeStep(仮算定額変更通知書発行後異動者登録);
            } else if (納入通知書仮算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                RString 帳票タイプ = get帳票タイプBy通知書帳票ID(出力帳票一覧.get帳票ID());
                RString 普徴期情報_処理対象 = get普徴期情報(parameter.get納入_出力期());
                if (帳票タイプ_期毎.equals(帳票タイプ) || 全件対象.equals(普徴期情報_処理対象)) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 納入通知書仮算定_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                } else if (parameter.is一括発行起動フラグ()) {
                    計算後情報作成区分 = true;
                    バッチフロー_帳票分類ID = 納入通知書仮算定_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(納入通知書仮算定発行);
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
        KarisanteiIdoFukaProcessParameter para = new KarisanteiIdoFukaProcessParameter(new FlexibleYear(parameter.get調定年度()),
                new FlexibleYear(parameter.get賦課年度()), null, new RDate(parameter.get特徴_発行日().toString()),
                new RDate(parameter.get仮算定額変更_発行日().toString()), parameter.get文書番号(), parameter.get納入_出力期(),
                parameter.get納入_出力方式(), new RDate(parameter.get納入_発行日().toString()), parameter.get納入_対象者(),
                parameter.get納入_生活保護対象者(), parameter.get納入_ページごとに山分け(), parameter.is一括発行起動フラグ(), null);
        return simpleBatch(SystemTimeSyutokuProcess.class).arguments(para).define();
    }

    /**
     * 全件賦課情報一時テーブル/異動賦課情報一時テーブル作成するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(CREAT_PROCESS)
    protected IBatchFlowCommand creatTmpProcess() {
        return simpleBatch(KarisanteiIdoTsuchishoTempCreatProcess.class).define();
    }

    /**
     * 計算後情報一時テーブル削除するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報一時テーブル削除)
    protected IBatchFlowCommand dropKeisangoJohoTempProcess() {
        return simpleBatch(KarisanteiIdoTsuchishoTempDropProcess.class).define();
    }

    /**
     * 計算後情報作成バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand keisangoJohoSakuseiProcess() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課, getKeisangoJohoSakuseiBatchParamter(バッチフロー_帳票分類ID)).define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID) {
        return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度(), getParameter().get賦課年度(),
                null, ShoriName.仮算定異動賦課.get名称(), 帳票分類ID);
    }

    /**
     * 特徴開始通知書(仮算定）の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴開始通知書仮算定発行)
    protected IBatchFlowCommand prtTokuchoKaishiTsuchishoHonsanteiProcess() {
        return simpleBatch(PntTokuchouKaishiTutishoKarisanteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 特徴開始通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(特徴開始通知書発行後異動者登録)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaTokuchoKaishiProcess() {
        return simpleBatch(InsTokuchouKaishiTutishoHakkougoIdoushaProcess.class).arguments(processParameter).define();
    }

    /**
     * 仮算定額変更通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(仮算定額変更通知書発行)
    protected IBatchFlowCommand pntKarisanteigakuHenkoTsuchishoProcess() {
        return simpleBatch(PntKarisanteigakuHenkoTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 仮算定額変更通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(仮算定額変更通知書発行後異動者登録)
    protected IBatchFlowCommand insKarisanteigakuHenkoTsuchishoHakkogoIdoshaProcess() {
        return simpleBatch(InsKarisanteigakuHenkoTsuchishoHakkogoIdoshaProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書仮算定発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(納入通知書仮算定発行)
    protected IBatchFlowCommand pntKarisanteiNonyuTsuchishoProcess() {
        return simpleBatch(PntKarisanteiNonyuTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書発行後異動者登録するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(納入通知書発行後異動者登録)
    protected IBatchFlowCommand insNonyuTsuchishoHakkogoIdoshaProcess() {
        return simpleBatch(InsNonyuTsuchishoHakkogoIdoshaProcess.class).arguments(processParameter).define();
    }

    private RString get帳票タイプBy通知書帳票ID(ReportId 帳票ID) {

        RString 帳票タイプ = RString.EMPTY;
        if (ReportIdDBB.DBB100014.getReportId().equals(帳票ID) || ReportIdDBB.DBB100015.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100028.getReportId().equals(帳票ID) || ReportIdDBB.DBB100029.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_期毎;
        } else if (ReportIdDBB.DBB100018.getReportId().equals(帳票ID) || ReportIdDBB.DBB100019.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_銀振型4;
        } else if (ReportIdDBB.DBB100020.getReportId().equals(帳票ID) || ReportIdDBB.DBB100021.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100022.getReportId().equals(帳票ID) || ReportIdDBB.DBB100023.getReportId().equals(帳票ID)) {
            帳票タイプ = 帳票タイプ_ブック;
        } else if (ReportIdDBB.DBB100024.getReportId().equals(帳票ID) || ReportIdDBB.DBB100025.getReportId().equals(帳票ID)
                || ReportIdDBB.DBB100026.getReportId().equals(帳票ID) || ReportIdDBB.DBB100027.getReportId().equals(帳票ID)) {
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
