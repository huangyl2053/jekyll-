/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jotaikubumbetsuhantei;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 要介護状態区分別判定件数のプロパティです。
 *
 * @reamsid_L DBE-1450-040 dongyabin
 */
public class JotaikubumbetsuhanteiProperty extends ReportPropertyBase<JotaikubumbetsuhanteiReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE701005.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(new RString(JotaikubumbetsuhanteiReportSource.ReportSourceFields.gogitaiName.name()),
                            new RString(JotaikubumbetsuhanteiReportSource.ReportSourceFields.shichosonNo.name())));

    /**
     * インスタンスを生成します。
     */
    public JotaikubumbetsuhanteiProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    @Override
    public Breakers<JotaikubumbetsuhanteiReportSource> defineBreakers(
            Breakers<JotaikubumbetsuhanteiReportSource> breakers,
            BreakerCatalog<JotaikubumbetsuhanteiReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<JotaikubumbetsuhanteiReportSource> occuredBreak(
                    ReportLineRecord<JotaikubumbetsuhanteiReportSource> currentRecord,
                    ReportLineRecord<JotaikubumbetsuhanteiReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
