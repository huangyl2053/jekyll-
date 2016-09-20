/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.DankaiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.DankaibetsuHihokenshasuReportCSVProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.DankaibetsuHihokenshasuReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbt21004.HihokenshaProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021031.DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter;
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
public class DBB021031_DankaibetsuHihokenshasuIchiranhyoSakusei extends BatchFlowBase<DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter> {

    private static final String 被保険者対象抽出 = "getHihokensha";
    private static final String 世帯員把握 = "collectSetaiin";
    private static final String 段階取得 = "getDankai";
    private static final String 帳票の出力 = "getReport";
    private static final String CSVの出力 = "getDankaiCSV";
    private static final RString BATCH_ID = new RString("SetaiShotokuKazeiHanteiFlow");
    private DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter parameter;
    private DankaibetuHihokensyasuIchiranhyoProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        YMDHMS システム日時 = YMDHMS.now();
        processParameter = new DankaibetuHihokensyasuIchiranhyoProcessParameter();
        processParameter.set調定年度(new FlexibleYear(parameter.getSettingnendo()));
        processParameter.set本算定賦課処理日(new FlexibleDate(new RString(parameter.getTreatmentday().toString())));
        processParameter.set広域分市町村分区分(parameter.getRegiondivision());
        if (parameter.getDantaiCd() != null && !parameter.getDantaiCd().isEmpty()) {
            processParameter.set市町村コード複数(parameter.getDantaiCd());
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
        return loopBatch(DankaibetsuHihokenshasuReportCSVProcess.class).arguments(processParameter).define();
    }

    /**
     * 帳票の出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(帳票の出力)
    protected IBatchFlowCommand getReport() {
        return loopBatch(DankaibetsuHihokenshasuReportProcess.class).arguments(processParameter).define();
    }
}
