/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo.ShinsakaishukeihyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 介護認定審査会集計表（判定別）のプロパティです。
 *
 * @reamsid_L DBE-1450-070 dongyabin
 */
public class ShinsakaishukeihyoProperty extends ReportPropertyBase<ShinsakaishukeihyoReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE701007.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(new RString(ShinsakaishukeihyoReportSource.ReportSourceFields.shichosonNo.name())));

    /**
     * インスタンスを生成します。
     */
    public ShinsakaishukeihyoProperty() {
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
    public Breakers<ShinsakaishukeihyoReportSource> defineBreakers(
            Breakers<ShinsakaishukeihyoReportSource> breakers,
            BreakerCatalog<ShinsakaishukeihyoReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(


            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShinsakaishukeihyoReportSource> occuredBreak(
                    ReportLineRecord<ShinsakaishukeihyoReportSource> currentRecord,
                    ReportLineRecord<ShinsakaishukeihyoReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
