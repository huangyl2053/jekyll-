/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishukeihyo08;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishukeihyo08.ShinsakaiShukeihyo08ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 介護認定審査会集計表（申請区分別）のプロパティです。
 *
 * @reamsid_L DBE-1450-080 dongyabin
 */
public class Shinsakaishukeihyo08Property extends ReportPropertyBase<ShinsakaiShukeihyo08ReportSource> {

    private static final ReportId ID = ReportIdDBE.DBE701008.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections.
            unmodifiableList(Arrays.asList(new RString(ShinsakaiShukeihyo08ReportSource.ReportSourceFields.shichosonName.name())));

    /**
     * インスタンスを生成します。
     */
    public Shinsakaishukeihyo08Property() {
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
    public Breakers<ShinsakaiShukeihyo08ReportSource> defineBreakers(
            Breakers<ShinsakaiShukeihyo08ReportSource> breakers,
            BreakerCatalog<ShinsakaiShukeihyo08ReportSource> catalog) {
        return breakers.add(catalog.new SimplePageBreaker(



            PAGE_BREAK_KEYS) {
            @Override
            public ReportLineRecord<ShinsakaiShukeihyo08ReportSource> occuredBreak(
                    ReportLineRecord<ShinsakaiShukeihyo08ReportSource> currentRecord,
                    ReportLineRecord<ShinsakaiShukeihyo08ReportSource> nextRecord,
                    ReportDynamicChart dynamicChart) {
                if (nextRecord == ReportLineRecord.LAST_RECORD) {
                    return currentRecord;
                }
                return currentRecord;
            }
        }).fixed();
    }
}
