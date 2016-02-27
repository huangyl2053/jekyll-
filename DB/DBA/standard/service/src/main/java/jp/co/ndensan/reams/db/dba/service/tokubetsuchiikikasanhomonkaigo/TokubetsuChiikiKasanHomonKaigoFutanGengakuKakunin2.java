/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.tokubetsuchiikikasanhomonkaigo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackProerty;
import jp.co.ndensan.reams.db.dba.business.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport;
import jp.co.ndensan.reams.db.dba.entity.report.tokubetsuchiikikasanhomonkaigoback.TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 *
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Printerです。
 */
public class TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin2 {

    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Printします。
     *
     * @return 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書_帳票
     */
    public SourceDataCollection createTokubetsuChiikiKasanHomonKaigoFutanGengakuKakuninChohyo() {
        TokubetsuChiikiKasanGenmenTaishoShinseishoBackProerty proerty = new TokubetsuChiikiKasanGenmenTaishoShinseishoBackProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource> assembler
                    = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, RString.EMPTY);
                for (TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport report : toReports(
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport> toReports(RString ninshoshaYakushokuMei) {
        List<TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport> list = new ArrayList<>();
        RString 通知文2 = get帳票文言();
        TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem item
                = new TokubetsuChiikiKasanGenmenTaishoShinseishoBackBodyItem(ninshoshaYakushokuMei, 通知文2);
        list.add(TokubetsuChiikiKasanGenmenTaishoShinseishoBackReport.createReport(item));
        return list;
    }

    private static RString get帳票文言() {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBD介護受給,
                new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseishoBack"),
                KamokuCode.EMPTY,
                1,
                1,
                new FlexibleDate(RDate.getNowDate().toDateString()));
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            return tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
        }
        return RString.EMPTY;
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
