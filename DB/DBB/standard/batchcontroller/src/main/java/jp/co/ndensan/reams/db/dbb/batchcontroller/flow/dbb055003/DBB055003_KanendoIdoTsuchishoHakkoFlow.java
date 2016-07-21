/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb055003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.HonsanteiIdoTsuchishoKanendoTempCreatProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.HonsanteiTsuchishoKanendoTempDeleteProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.IdoFukaJohoFlgFalseProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.IdoFukaJohoFlgTrueProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.InsHenkoTsuchishoHakkogoIdoshaKetteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.InsKetteiTsuchishoHakkogoIdoshaKetteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.InsNonyuTsuchishoHakkogoIdoshaKetteiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.PntHenkoTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.PntKetteiTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.PntNonyuTsuchishoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003.SystemTimeSakuseiKanendoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.keisangojoho.KeisangoJohoSakuseiBatchParamter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka.IdoFukaJohoFlgTrueProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka.KanendoHonsanteifukaProcessParameter;
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
 * 本算定通知書一括発行（過年度）するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class DBB055003_KanendoIdoTsuchishoHakkoFlow extends BatchFlowBase<HonSanteiIdoKanendoFukaBatchParameter> {

    private static final ReportId 介護保険料額決定通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書本算定_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final String システム日時の取得 = "getSystemDate";
    private static final String 計算後情報作成_ONE = "keisangoJohoSakuseiOne";
    private static final String 計算後情報作成_TWO = "keisangoJohoSakuseiTwo";
    private static final String 計算後情報作成_THREE = "keisangoJohoSakuseiThree";
    private static final String 異動賦課情報一時テーブルクリア = "deleteIdoFukaJohoTempProcess";
    private static final String CREAT_PROCESS = "creatTmpProcess";
    private static final String INSERT_IDOFUKAJOHOFLGTRUE_ONEPROCESS = "insIdoFukaJohoTsuchishoFlgTrueOneProcess";
    private static final String INSERT_IDOFUKAJOHOFLGTRUE_TWOPROCESS = "insIdoFukaJohoTsuchishoFlgTrueTwoProcess";
    private static final String INSERT_IDOFUKAJOHOFLGTRUE_THREEPROCESS = "insIdoFukaJohoTsuchishoFlgTrueThreeProcess";
    private static final String INSERT_IDOFUKAJOHOFLGFALSE_PROCESS = "insIdoFukaJohoTsuchishoFlgFalseProcess";
    private static final String PRINT_KETTEITSUCHISHO_PROCESS = "prtKetteiTsuchishoProcess";
    private static final String INSERT_KETTEITSUCHISHO_PROCESS = "insTsuchishoHakkogoIdoshaKetteiProcess";
    private static final String PRINT_HENKOTSUCHISHO_PROCESS = "prtHenkoTsuchishoProcess";
    private static final String INSERT_HENKOTSUCHISHO_PROCESS = "insTsuchishoHakkogoIdoshaHenkoProcess";
    private static final String PRINT_NONYUTSUCHISHO_PROCESS = "prtNonyuTsuchishoProcess";
    private static final String INSERT_NONYUTSUCHISHO_PROCESS = "insTsuchishoHakkogoIdoshaNonyuProcess";

    private static final RString BATCH_ID = new RString("KeisangoJohoSakuseiFlow");
    private static final RString チェックする = new RString("1");
    private static final RString 回目１ = new RString("1");
    private static final RString 回目２ = new RString("2");
    private static final RString 回目３ = new RString("3");
    private HonSanteiIdoKanendoFukaBatchParameter parameter;
    private RString バッチフロー_帳票分類ID;
    private KanendoHonsanteifukaProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get出力帳票List() == null || parameter.get出力帳票List().isEmpty()) {
            return;
        }
        executeStep(システム日時の取得);
        executeStep(CREAT_PROCESS);
        List<ChohyoResult> 出力帳票一覧List = parameter.get出力帳票List();
        for (ChohyoResult 出力帳票 : 出力帳票一覧List) {
            if (出力帳票.get帳票ID() == null) {
                continue;
            }
            processParameter = new KanendoHonsanteifukaProcessParameter(parameter.get調定年度(), 出力帳票,
                    parameter.get決定_対象賦課年度(), parameter.get変更_対象賦課年度(), parameter.get納入_対象賦課年度(),
                    parameter.get決定_発行日(), parameter.get決定_文書番号(), parameter.get変更_発行日(), parameter.get変更_文書番号(),
                    parameter.get変更_対象者(), parameter.get納入_発行日(), parameter.get納入_出力期(), parameter.get納入_対象者(),
                    parameter.get納入_口座振替様式(), parameter.get納入_先頭出力(), parameter.get納入_ページ山分け(),
                    parameter.is一括発行起動フラグ(), getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeSakuseiKanendoProcess.SYSTEM_TIME));

            if (介護保険料額決定通知書_帳票分類ID.equals(出力帳票.get帳票分類ID()) && チェックする.equals(parameter.get決定_チェックボックス())
                    && (ReportIdDBB.DBB100039.getReportId().getColumnValue().equals(出力帳票.get帳票ID())
                    || ReportIdDBB.DBB100040.getReportId().getColumnValue().equals(出力帳票.get帳票ID()))) {
                バッチフロー_帳票分類ID = 介護保険料額決定通知書_帳票分類ID.getColumnValue();
                executeStep(異動賦課情報一時テーブルクリア);
                if (parameter.is一括発行起動フラグ()) {
                    executeStep(計算後情報作成_ONE);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_ONEPROCESS);
                    executeStep(計算後情報作成_TWO);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_TWOPROCESS);
                    executeStep(計算後情報作成_THREE);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_THREEPROCESS);
                }
                executeStep(INSERT_IDOFUKAJOHOFLGFALSE_PROCESS);

                executeStep(PRINT_KETTEITSUCHISHO_PROCESS);
                executeStep(INSERT_KETTEITSUCHISHO_PROCESS);
            } else if (介護保険料額決定通知書_帳票分類ID.equals(出力帳票.get帳票分類ID()) && チェックする.equals(parameter.get変更_チェックボックス())
                    && (ReportIdDBB.DBB100042.getReportId().getColumnValue().equals(出力帳票.get帳票ID())
                    || ReportIdDBB.DBB100043.getReportId().getColumnValue().equals(出力帳票.get帳票ID()))) {
                バッチフロー_帳票分類ID = 介護保険料額決定通知書_帳票分類ID.getColumnValue();
                executeStep(異動賦課情報一時テーブルクリア);
                if (parameter.is一括発行起動フラグ()) {
                    executeStep(計算後情報作成_ONE);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_ONEPROCESS);
                    executeStep(計算後情報作成_TWO);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_TWOPROCESS);
                    executeStep(計算後情報作成_THREE);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_THREEPROCESS);
                }
                executeStep(INSERT_IDOFUKAJOHOFLGFALSE_PROCESS);
                executeStep(PRINT_HENKOTSUCHISHO_PROCESS);
                executeStep(INSERT_HENKOTSUCHISHO_PROCESS);
            } else if (納入通知書本算定_帳票分類ID.equals(出力帳票.get帳票分類ID())) {
                バッチフロー_帳票分類ID = 納入通知書本算定_帳票分類ID.getColumnValue();
                executeStep(異動賦課情報一時テーブルクリア);
                if (parameter.is一括発行起動フラグ()) {
                    executeStep(計算後情報作成_ONE);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_ONEPROCESS);
                    executeStep(計算後情報作成_TWO);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_TWOPROCESS);
                    executeStep(計算後情報作成_THREE);
                    executeStep(INSERT_IDOFUKAJOHOFLGTRUE_THREEPROCESS);
                }
                executeStep(INSERT_IDOFUKAJOHOFLGFALSE_PROCESS);
                executeStep(PRINT_NONYUTSUCHISHO_PROCESS);
                executeStep(INSERT_NONYUTSUCHISHO_PROCESS);
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
        KanendoHonsanteifukaProcessParameter para = new KanendoHonsanteifukaProcessParameter(parameter.get調定年度(), parameter.get出力帳票List().get(0),
                parameter.get決定_対象賦課年度(), parameter.get変更_対象賦課年度(), parameter.get納入_対象賦課年度(),
                parameter.get決定_発行日(), parameter.get決定_文書番号(), parameter.get変更_発行日(), parameter.get変更_文書番号(),
                parameter.get変更_対象者(), parameter.get納入_発行日(), parameter.get納入_出力期(), parameter.get納入_対象者(),
                parameter.get納入_口座振替様式(), parameter.get納入_先頭出力(), parameter.get納入_ページ山分け(),
                parameter.is一括発行起動フラグ(), YMDHMS.now());
        return simpleBatch(SystemTimeSakuseiKanendoProcess.class).arguments(para).define();
    }

    /**
     * 異動賦課情報一時テーブルクリアするメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(異動賦課情報一時テーブルクリア)
    protected IBatchFlowCommand deleteIdoFukaJohoTempProcess() {
        return simpleBatch(HonsanteiTsuchishoKanendoTempDeleteProcess.class).define();
    }

    /**
     * 異動賦課情報一時テーブル作成するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(CREAT_PROCESS)
    protected IBatchFlowCommand creatTmpProcess() {
        return simpleBatch(HonsanteiIdoTsuchishoKanendoTempCreatProcess.class).define();
    }

    /**
     * 異動賦課情報一時テーブルFlagTrue１回目場合のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_IDOFUKAJOHOFLGTRUE_ONEPROCESS)
    protected IBatchFlowCommand insIdoFukaJohoTsuchishoFlgTrueOneProcess() {
        return simpleBatch(IdoFukaJohoFlgTrueProcess.class).arguments(getIdoFukaJohoFlgTrueProcessParameter(回目１)).define();
    }

    /**
     * 異動賦課情報一時テーブルFlagTrue２回目場合のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_IDOFUKAJOHOFLGTRUE_TWOPROCESS)
    protected IBatchFlowCommand insIdoFukaJohoTsuchishoFlgTrueTwoProcess() {
        return simpleBatch(IdoFukaJohoFlgTrueProcess.class).arguments(getIdoFukaJohoFlgTrueProcessParameter(回目２)).define();
    }

    /**
     * 異動賦課情報一時テーブルFlagTrue３回目場合のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_IDOFUKAJOHOFLGTRUE_THREEPROCESS)
    protected IBatchFlowCommand insIdoFukaJohoTsuchishoFlgTrueThreeProcess() {
        return simpleBatch(IdoFukaJohoFlgTrueProcess.class).arguments(getIdoFukaJohoFlgTrueProcessParameter(回目３)).define();
    }

    /**
     * 異動賦課情報一時テーブルFlagFalse場合のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_IDOFUKAJOHOFLGFALSE_PROCESS)
    protected IBatchFlowCommand insIdoFukaJohoTsuchishoFlgFalseProcess() {
        return simpleBatch(IdoFukaJohoFlgFalseProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRINT_KETTEITSUCHISHO_PROCESS)
    protected IBatchFlowCommand pntKetteiTsuchishoProcess() {
        return simpleBatch(PntKetteiTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 決定通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_KETTEITSUCHISHO_PROCESS)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaKetteiProcess() {
        return simpleBatch(InsKetteiTsuchishoHakkogoIdoshaKetteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRINT_HENKOTSUCHISHO_PROCESS)
    protected IBatchFlowCommand pntHenkoTsuchishoProcess() {
        return simpleBatch(PntHenkoTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 変更通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_HENKOTSUCHISHO_PROCESS)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaHenkoProcess() {
        return simpleBatch(InsHenkoTsuchishoHakkogoIdoshaKetteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書の発行するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(PRINT_NONYUTSUCHISHO_PROCESS)
    protected IBatchFlowCommand prtNonyuTsuchishoProcess() {
        return simpleBatch(PntNonyuTsuchishoProcess.class).arguments(processParameter).define();
    }

    /**
     * 納入通知書発行後異動者登録するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(INSERT_NONYUTSUCHISHO_PROCESS)
    protected IBatchFlowCommand insTsuchishoHakkogoIdoshaNonyuProcess() {
        return simpleBatch(InsNonyuTsuchishoHakkogoIdoshaKetteiProcess.class).arguments(processParameter).define();
    }

    /**
     * 計算後情報作成１回目バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成_ONE)
    protected IBatchFlowCommand keisangoJohoSakuseiOne() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(バッチフロー_帳票分類ID, 回目１)).define();
    }

    /**
     * 計算後情報作成２回目バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成_TWO)
    protected IBatchFlowCommand keisangoJohoSakuseiTwo() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(バッチフロー_帳票分類ID, 回目２)).define();
    }

    /**
     * 計算後情報作成３回目バッチを呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成_THREE)
    protected IBatchFlowCommand keisangoJohoSakuseiThree() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter(バッチフロー_帳票分類ID, 回目３)).define();
    }

    private KeisangoJohoSakuseiBatchParamter getKeisangoJohoSakuseiBatchParamter(RString 帳票分類ID, RString 回目) {
        if (回目１.equals(回目)) {
            return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().minusYear(1).toDateString(),
                    getParameter().get調定年度().minusYear(1).toDateString(),
                    getResult(RString.class, new RString(システム日時の取得), SystemTimeSakuseiKanendoProcess.KIJUN_TIME),
                    ShoriName.本算定賦課.get名称(), 帳票分類ID);
        }
        if (回目２.equals(回目)) {
            return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().toDateString(),
                    getParameter().get調定年度().minusYear(1).toDateString(),
                    getResult(RString.class, new RString(システム日時の取得), SystemTimeSakuseiKanendoProcess.KIJUN_TIME),
                    ShoriName.本算定賦課.get名称(), 帳票分類ID);
        }
        if (回目３.equals(回目)) {
            return new KeisangoJohoSakuseiBatchParamter(getParameter().get調定年度().toDateString(),
                    getParameter().get調定年度().minusYear(2).toDateString(),
                    getResult(RString.class, new RString(システム日時の取得), SystemTimeSakuseiKanendoProcess.KIJUN_TIME),
                    ShoriName.本算定賦課.get名称(), 帳票分類ID);
        }
        return null;
    }

    private IdoFukaJohoFlgTrueProcessParameter getIdoFukaJohoFlgTrueProcessParameter(RString 回目) {
        if (回目１.equals(回目)) {
            return new IdoFukaJohoFlgTrueProcessParameter(getParameter().get調定年度(), 回目１);
        }
        if (回目２.equals(回目)) {
            return new IdoFukaJohoFlgTrueProcessParameter(getParameter().get調定年度(), 回目２);
        }
        if (回目３.equals(回目)) {
            return new IdoFukaJohoFlgTrueProcessParameter(getParameter().get調定年度(), 回目３);
        }
        return null;
    }
}
