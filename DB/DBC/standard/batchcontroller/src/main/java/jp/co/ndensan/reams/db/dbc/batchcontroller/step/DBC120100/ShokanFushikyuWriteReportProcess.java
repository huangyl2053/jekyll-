/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120100;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin.ShokanBaraiFushikyuKetteishaIchiranhyo;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin.ShokanFushikyuKetteiInPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin.ShokanFushikyuKetteiInItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanfushikyuketteiin.ShokanFushikyuKetteiInReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanfushikyuketteiin.ShokanFushikyuKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanfushikyuketteiin.ShokanbaraiFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;

/**
 * 帳票に引き渡す
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public class ShokanFushikyuWriteReportProcess extends BatchKeyBreakBase<ShokanFushikyuKetteiInEntity> {

    /**
     * 出力順ID
     */
    public static final RString PARAMETER_IN_SHUTSURYOKUJUNID;

    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    static {
        PARAMETER_IN_SHUTSURYOKUJUNID = new RString("shutsuryokujunID");
    }

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.shokanfushikyuketteiin."
            + "IShokanFushikyuKetteiInMapper.select一時テーブル");

    private static final RString KAI_PAGE_HOKENSHANO = new RString("hokenshaNo");

    @BatchWriter
    private BatchReportWriter<ShokanbaraiFushikyuKetteishaIchiranSource> batchReportWriter;
    private ReportSourceWriter<ShokanbaraiFushikyuKetteishaIchiranSource> reportSourceWriter;

    List<ShokanFushikyuKetteiInEntity> entityList;

    InputParameter<Long> shutsuryokujunID;

    @Override
    protected void initialize() {
        super.initialize();
        entityList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {

    }

    @Override
    protected void createWriter() {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200022.getReportId(), shutsuryokujunID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        改頁項目リスト.add(KAI_PAGE_HOKENSHANO);
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目ID());
                }
            }
        }
        PageBreaker<ShokanbaraiFushikyuKetteishaIchiranSource> breaker = new ShokanFushikyuKetteiInPageBreak(改頁項目リスト);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200022.getReportId().value(), SubGyomuCode.DBC介護給付)
                .addBreak(breaker).create();
        this.reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void keyBreakProcess(ShokanFushikyuKetteiInEntity t) {
    }

    @Override
    protected void usualProcess(ShokanFushikyuKetteiInEntity t) {
        entityList.add(t);
    }

    @Override
    protected void afterExecute() {
        ShokanBaraiFushikyuKetteishaIchiranhyo business = new ShokanBaraiFushikyuKetteishaIchiranhyo();
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200022.getReportId(), shutsuryokujunID.getValue());
        List<RString> 改頁項目リスト = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    改頁項目リスト.add(item.get項目名());
                }
            }
        }
        RString 改頁 = null == 並び順 ? RString.EMPTY : 並び順.getFormated改頁項目();
        RString 並び順の１件目 = 改頁項目リスト.size() <= INDEX_0 ? RString.EMPTY : 改頁項目リスト.get(INDEX_0);
        RString 並び順の２件目 = 改頁項目リスト.size() <= INDEX_1 ? RString.EMPTY : 改頁項目リスト.get(INDEX_1);
        RString 並び順の３件目 = 改頁項目リスト.size() <= INDEX_2 ? RString.EMPTY : 改頁項目リスト.get(INDEX_2);
        RString 並び順の４件目 = 改頁項目リスト.size() <= INDEX_3 ? RString.EMPTY : 改頁項目リスト.get(INDEX_3);
        RString 並び順の５件目 = 改頁項目リスト.size() <= INDEX_4 ? RString.EMPTY : 改頁項目リスト.get(INDEX_4);
        List<ShokanFushikyuKetteiInItem> targetList = business.getShokanBaraiFushikyuKetteishaIchiranhyo(並び順の１件目, 並び順の２件目,
                並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁, entityList);
        ShokanFushikyuKetteiInReport report
                = ShokanFushikyuKetteiInReport.createForm(targetList);
        report.writeBy(reportSourceWriter);
    }
}
