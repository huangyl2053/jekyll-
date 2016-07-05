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
            processParameter = new KarisanteiIdoFukaProcessParameter(new FlexibleYear(parameter.get調定年度()),
                    new FlexibleYear(parameter.get賦課年度()), 出力帳票一覧, new RDate(parameter.get特徴_発行日().toString()),
                    new RDate(parameter.get仮算定額変更_発行日().toString()), parameter.get文書番号(), parameter.get納入_出力期(),
                    parameter.get納入_出力方式(), new RDate(parameter.get納入_発行日().toString()), parameter.get納入_対象者(),
                    parameter.get納入_生活保護対象者(), parameter.get納入_ページごとに山分け(), parameter.is一括発行起動フラグ(),
                    getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeSyutokuProcess.SYSTEM_TIME));
            if (特別徴収開始通知書仮算定帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    バッチフロー_帳票分類ID = 特別徴収開始通知書仮算定帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(特徴開始通知書仮算定発行);
                executeStep(特徴開始通知書発行後異動者登録);
            } else if (仮算定額変更通知書_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    バッチフロー_帳票分類ID = 仮算定額変更通知書_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(仮算定額変更通知書発行);
                executeStep(仮算定額変更通知書発行後異動者登録);
            } else if (納入通知書仮算定_帳票分類ID.equals(出力帳票一覧.get帳票分類ID())) {
                if (parameter.is一括発行起動フラグ()) {
                    バッチフロー_帳票分類ID = 納入通知書仮算定_帳票分類ID.getColumnValue();
                    executeStep(計算後情報作成);
                }
                executeStep(納入通知書仮算定発行);
                executeStep(納入通知書発行後異動者登録);
            }
            if (parameter.is一括発行起動フラグ()) {
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
                getResult(RString.class, new RString(システム日時の取得), SystemTimeSyutokuProcess.KIJUN_TIME),
                ShoriName.本算定賦課.get名称(), 帳票分類ID);
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
}
