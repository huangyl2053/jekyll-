/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shisetsutaishotsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoItem;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 介護保険住所地特例施設退所通知書Printerです。
 *
 * @reamsid_L DBA-0380-060 duanzhanli
 *
 */
public class ShisetsuTaishoTsuchishoPrintService {

    /**
     * 介護保険住所地特例施設退所通知書を印刷します。
     *
     * @param item 介護保険住所地特例施設退所通知書_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ShisetsuTaishoTsuchishoItem item) {
        ShisetsuTaishoTsuchishoProperty property = new ShisetsuTaishoTsuchishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShisetsuTaishoTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<ShisetsuTaishoTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(property.subGyomuCode(),
                        property.reportId(),
                        FlexibleDate.getNowDate(),
                        reportSourceWriter);
                item.setDenshiKoin(ninshoshaSource.denshiKoin);
                item.setHakkoYMD1(ninshoshaSource.hakkoYMD);
                item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
                item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
                item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
                item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
                item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
                item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
                item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
            }
        }
        return new Printer<ShisetsuTaishoTsuchishoReportSource>().spool(property, toReports(item));
    }

    private static List<ShisetsuTaishoTsuchishoReport> toReports(ShisetsuTaishoTsuchishoItem item) {
        List<ShisetsuTaishoTsuchishoReport> list = new ArrayList<>();
        list.add(ShisetsuTaishoTsuchishoReport.createFrom(item));
        return list;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
