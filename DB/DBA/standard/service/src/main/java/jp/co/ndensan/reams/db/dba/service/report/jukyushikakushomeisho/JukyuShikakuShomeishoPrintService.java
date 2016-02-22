/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.jukyushikakushomeisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoJoho;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeisho.JukyuShikakuShomeishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 受給資格証明書Printerです。
 */
public class JukyuShikakuShomeishoPrintService {

    /**
     * 受給資格証明書を印刷します。
     *
     * @param bodyItemList 受給資格証明書ヘッダのITEMリストです
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<JukyuShikakuShomeishoBodyItem> bodyItemList) {
        JukyuShikakuShomeishoProerty property = new JukyuShikakuShomeishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JukyuShikakuShomeishoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, RString.EMPTY);
                for (JukyuShikakuShomeishoBodyItem bodyItem : bodyItemList) {
                    bodyItem = new JukyuShikakuShomeishoBodyItem(
                            bodyItem.getHihokenshaNo(),
                            bodyItem.getHihokenshaNameKana(),
                            bodyItem.getHihokenshaName(),
                            bodyItem.getBirthYMD(),
                            bodyItem.getSeibetsu(),
                            bodyItem.getTenshutsusakiYoteiJusho(),
                            bodyItem.getIdoYoteiYMD(),
                            bodyItem.getHokenshaNo(),
                            bodyItem.getDate(),
                            bodyItem.getShuchoMei(),
                            bodyItem.getRecognizedName(),
                            ninshoshaSourceBuilder.buildSource().denshiKoin,
                            ninshoshaSourceBuilder.buildSource().koinShoryaku,
                            bodyItem.getShichosonMei(),
                            bodyItem.getShinseichu(),
                            bodyItem.getShinseiYMD(),
                            bodyItem.getYokaigoKubun(),
                            bodyItem.getNinteiYMD(),
                            bodyItem.getYukoKaishiYMD(),
                            bodyItem.getYukoShuryoYMD(),
                            bodyItem.getShinsakaiIken(),
                            bodyItem.getBiko(),
                            bodyItem.getRemban(),
                            ninshoshaSourceBuilder.buildSource().hakkoYMD);
                    for (JukyuShikakuShomeishoReport report : toReports(new JukyuShikakuShomeishoJoho(bodyItem))) {
                        ReportSourceWriter<JukyuShikakuShomeishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static List<JukyuShikakuShomeishoReport> toReports(JukyuShikakuShomeishoJoho reportJoho) {
        List<JukyuShikakuShomeishoReport> list = new ArrayList<>();
        list.add(JukyuShikakuShomeishoReport.createReport(reportJoho.getBodyItem()));
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
