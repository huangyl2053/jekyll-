/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahanteinohenkojokyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsahanteinohenkojokyo.ShinsahanteinoHenkojokyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 審査判定の変更状況のプロパティです。
 *
 * @reamsid_L DBE-1450-060 dongyabin
 */
public class ShinsahanteinoHenkojokyoProperty extends ReportPropertyBase<ShinsahanteinoHenkojokyoReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE701006.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(new RString(JotaikubumbetsuhanteiReportSource.ReportSourceFields.gogitaiName.name()),
                            new RString(JotaikubumbetsuhanteiReportSource.ReportSourceFields.shichosonNo.name())));

    /**
     * インスタンスを生成します。
     */
    public ShinsahanteinoHenkojokyoProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }

    /**
     * 改ページ処理です。
     *
     * @param breakers breakers
     * @param catalog catalog
     * @return Breakers<ShinsahanteinoHenkojokyoReportSource>
     */
    @Override
    public Breakers<ShinsahanteinoHenkojokyoReportSource> defineBreakers(
            Breakers<ShinsahanteinoHenkojokyoReportSource> breakers,
            BreakerCatalog<ShinsahanteinoHenkojokyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(




            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShinsahanteinoHenkojokyoReportSource> occuredBreak(
                    ReportLineRecord<ShinsahanteinoHenkojokyoReportSource> currentRecord,
                    ReportLineRecord<ShinsahanteinoHenkojokyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
