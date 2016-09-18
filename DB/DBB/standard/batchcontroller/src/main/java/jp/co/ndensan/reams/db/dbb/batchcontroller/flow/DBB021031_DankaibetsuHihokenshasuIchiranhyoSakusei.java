/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.DankaiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.HihokenshaProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.ReportCSVProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.ReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.SystemTimeDankaibetuHihokensyasuIchiranhyoFukaProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.ShotokuDankaibetsuHihokenshaSuIchiran.ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt21004.DankaibetuHihokensyasuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.fuka.SetaiShotokuKazeiHanteiBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SetaiinHaakuKanriShikibetsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT21004_段階別被保険者数一覧表作成クラスです。
 *
 * @reamsid_L DBB-1820-040 dingminghao
 */
public class DBB021031_DankaibetsuHihokenshasuIchiranhyoSakusei extends BatchFlowBase<ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 被保険者対象抽出 = "getHihokensha";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 段階取得 = "getDankai";
    private static final String 帳票の出力 = "getReport";
    private static final String CSVの出力 = "getDankaiCSV";
    private static final RString BATCH_ID = new RString("SetaiShotokuKazeiHanteiFlow");
    private ShotokuDankaibetsuHihokenshaSuIchiranBatchParameter parameter;
    private DankaibetuHihokensyasuIchiranhyoProcessParameter processParameter;
    private static final RString DOUHAO = new RString(",");
    private static final int ZERO = 0;
    private static final int ONE = 1;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        executeStep(システム日時の取得);
        YMDHMS システム日時 = getResult(YMDHMS.class, new RString(システム日時の取得), SystemTimeDankaibetuHihokensyasuIchiranhyoFukaProcess.SYSTEM_TIME);
        processParameter = new DankaibetuHihokensyasuIchiranhyoProcessParameter();
        processParameter.set調定年度(new FlexibleYear(parameter.getSettingnendo()));
        processParameter.set本算定賦課処理日(new FlexibleDate(new RString(parameter.getTreatmentday().toString())));
        processParameter.set広域分市町村分区分(parameter.getRegiondivision());
        RString 市町村コード複数 = null;
        if (parameter.getDantaiCd() != null) {
            市町村コード複数 = get市町村コード複数(parameter.getDantaiCd(), 市町村コード複数);
        }
        if (市町村コード複数 != null) {
            processParameter.set市町村コード複数(市町村コード複数.substringReturnAsPossible(ZERO, 市町村コード複数.length() - ONE));
        }
        processParameter.set資格基準日(new FlexibleDate(new RString(parameter.getQkijund().toString())));
        processParameter.set調定基準日(new FlexibleDate(new RString(parameter.getAdjustedkijund().toString())));
        processParameter.setバッチ起動時処理日時(システム日時);
        executeStep(被保険者対象抽出);
        executeStep(世帯員把握);
        executeStep(段階取得);
        executeStep(CSVの出力);
        executeStep(帳票の出力);
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        return simpleBatch(SystemTimeDankaibetuHihokensyasuIchiranhyoFukaProcess.class).define();
    }

    /**
     * 被保険者対象抽出を行います。
     *
     * @return バッチコマンド
     */
    @Step(被保険者対象抽出)
    protected IBatchFlowCommand getHihokensha() {
        return loopBatch(HihokenshaProcess.class).arguments(processParameter).define();
    }

    /**
     * 世帯員把握を行います。
     *
     * @return バッチコマンド
     */
    @Step(世帯員把握)
    protected IBatchFlowCommand collectSetaiin() {
        return otherBatchFlow(BATCH_ID, SubGyomuCode.DBB介護賦課,
                new SetaiShotokuKazeiHanteiBatchParameter(SetaiinHaakuKanriShikibetsuKubun.賦課.getコード())).define();
    }

    /**
     * 段階取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(段階取得)
    protected IBatchFlowCommand getDankai() {
        return loopBatch(DankaiProcess.class).arguments(processParameter).define();
    }

    /**
     * CSVの出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(CSVの出力)
    protected IBatchFlowCommand getDankaiCSV() {
        return loopBatch(ReportCSVProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票の出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(帳票の出力)
    protected IBatchFlowCommand getReport() {
        return loopBatch(ReportProcess.class).arguments(processParameter).define();
    }

    private RString get市町村コード複数(
            List<RString> dantaiCdLis,
            RString 市町村コード複数) {
        for (RString dantaiCd : dantaiCdLis) {
            if (dantaiCd != null) {
                市町村コード複数 = dantaiCd.concat(DOUHAO);
            }
        }
        return 市町村コード複数;
    }
}
