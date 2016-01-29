/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kyokaisokanrimasterlist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * {@link KyokaisoKanriMasterListReport}のプロパティです。
 */
public class KyokaisoKanriMasterListProperty extends ReportPropertyBase<KyokaisoKanriMasterListReportSource> {

    private static final ReportId ID = new ReportId("DBA200005");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString("listUpper_1")));

    /**
     * インスタンスを生成します。
     */
    public KyokaisoKanriMasterListProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }

    @Override
    public Breakers<KyokaisoKanriMasterListReportSource> defineBreakers(
            Breakers<KyokaisoKanriMasterListReportSource> breakers,
            BreakerCatalog<KyokaisoKanriMasterListReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(

            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<KyokaisoKanriMasterListReportSource> occuredBreak(
                    ReportLineRecord<KyokaisoKanriMasterListReportSource> currentRecord,
                    ReportLineRecord<KyokaisoKanriMasterListReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
