/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kagoketteihokenshain.KagoKetteiHokenshaInOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.core.kagoketteihokenshain.KagoKetteiHokenshaInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kagoketteihokenshain.KagoKetteiHokenshaInMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteitsuchishojohotorikomiichiranhyo.KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票用Entityリスト作成と作成したdataを帳票に出力する。
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public class KagoKetteiHokenshaInWriteReportProcess extends BatchKeyBreakBase<KagoKetteiHokenshaInEntity> {

    /**
     * 処理年月
     */
    public static final RString PARAMETER_IN_SHORIYM;
    /**
     * 出力順ID
     */
    public static final RString PARAMETER_IN_SHUTSURYOKUJUNID;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private KagoKetteiHokenshaInMybatisParameter parameter;
    private static final RString ORDER_BY = new RString("order by");

    static {
        PARAMETER_IN_SHORIYM = new RString("shoriYM");
        PARAMETER_IN_SHUTSURYOKUJUNID = new RString("shutsuryokujunID");
    }

    InputParameter<FlexibleYearMonth> shoriYM;
    InputParameter<Long> shutsuryokujunID;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kagoketteihokenshain.IKagoKetteiHokenshaInMapper.select一時テーブル");

    @BatchWriter
    private BatchReportWriter<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> batchReportWriter;
    private ReportSourceWriter<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> reportSourceWriter;

    List<KagoKetteiHokenshaInEntity> entityList;

    /**
     * コンストラクタです
     *
     * @param shoriYM 処理年月
     * @param shutsuryokujunID 出力順ID
     */
    public KagoKetteiHokenshaInWriteReportProcess(
            InputParameter<FlexibleYearMonth> shoriYM, InputParameter<Long> shutsuryokujunID) {
        this.shoriYM = shoriYM;
        this.shutsuryokujunID = shutsuryokujunID;
    }

    /**
     * コンストラクタです
     */
    public KagoKetteiHokenshaInWriteReportProcess() {
    }

    @Override
    protected void initialize() {
        super.initialize();
        entityList = new ArrayList<>();
        parameter = new KagoKetteiHokenshaInMybatisParameter();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200050.getReportId(), shutsuryokujunID.getValue());
        if (並び順 != null) {
            parameter.setOutputOrderBy(MyBatisOrderByClauseCreator.create(
                    KagoKetteiHokenshaInOutPutOrder.class, 並び順).replace(ORDER_BY, RString.EMPTY));
        } else {
            parameter.setOutputOrderBy(null);
        }
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目ID());
                }
            }
        }
        PageBreaker<KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource> breaker
                = new KagoKetteiHokenshaInPageBreak(改頁項目リスト);

        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200050.getReportId().value(), SubGyomuCode.DBC介護給付).
                addBreak(breaker).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(KagoKetteiHokenshaInEntity t) {
    }

    @Override
    protected void usualProcess(KagoKetteiHokenshaInEntity t) {
        entityList.add(t);
    }

    @Override
    protected void afterExecute() {
        KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun business
                = new KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun();
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200050.getReportId(), shutsuryokujunID.getValue());
        RString 並び順の1件目 = RString.EMPTY;
        RString 並び順の2件目 = RString.EMPTY;
        RString 並び順の3件目 = RString.EMPTY;
        RString 並び順の4件目 = RString.EMPTY;
        RString 並び順の5件目 = RString.EMPTY;
        List<RString> 改頁項目リスト = new ArrayList<>();
        int i = 0;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }

                if (i == 0) {
                    並び順の1件目 = item.get項目名();
                } else if (i == INDEX_1) {
                    並び順の2件目 = item.get項目名();
                } else if (i == INDEX_2) {
                    並び順の3件目 = item.get項目名();
                } else if (i == INDEX_3) {
                    並び順の4件目 = item.get項目名();
                } else if (i == INDEX_4) {
                    並び順の5件目 = item.get項目名();
                }
                i = i + 1;
            }
        }

        List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> targetList
                = business.createKagoKetteiTsuchishoTorikomiIchiranhyoHokenshabunData(
                        shoriYM.getValue(), 並び順の1件目, 並び順の2件目, 並び順の3件目,
                        並び順の4件目, 並び順の5件目, 改頁項目リスト, entityList);
        KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport report
                = KagoKetteitsuchishoTorikomiIchiranHokenshaBunReport.createForm(targetList);
        report.writeBy(reportSourceWriter);

    }
}
