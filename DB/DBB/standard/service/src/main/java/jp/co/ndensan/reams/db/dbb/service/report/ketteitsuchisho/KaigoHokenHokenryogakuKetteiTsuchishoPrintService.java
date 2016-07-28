/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.ketteitsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoBusiness;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.a4tate.KaigoHokenHokenryogakuKetteiTsuchishoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.a4tate.KaigoHokenHokenryogakuKetteiTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.b5yoko.KaigoHokenHokenryogakuKetteiTsuchishoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.ketteitsuchisho.b5yoko.KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.ketteitsuchisho.KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 介護保険料額決定通知書のPrintServiceです。
 *
 * @reamsid_L DBB-9080-010 sunhaidi
 */
public class KaigoHokenHokenryogakuKetteiTsuchishoPrintService {

    /**
     * printB5Yokoメソッド(単一帳票出力用)
     *
     * @param entities EditedKariSanteiFukaDaichoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5Yoko(List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities) {
        try (ReportManager reportManager = new ReportManager()) {
            printB5Yoko(entities, reportManager);
            return reportManager.publish();
        }
    }

    /**
     * printB5Yokoメソッド(複数帳票出力用)
     *
     * @param entities EditedKariSanteiFukaDaichoJoho
     * @param reportManager ReportManager
     */
    public void printB5Yoko(List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities, ReportManager reportManager) {
        KaigoHokenHokenryogakuKetteiTsuchishoB5YokoProperty property = new KaigoHokenHokenryogakuKetteiTsuchishoB5YokoProperty();
        List<KaigoHokenHokenryogakuKetteiTsuchishoBusiness> targets = new ArrayList<>();
        try (ReportAssembler<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            if (entities != null && !entities.isEmpty()) {
                ReportId 帳票分類ID = entities.get(0).get本算定決定通知書情報().get帳票分類ID();
                FlexibleDate 発行日 = new FlexibleDate(entities.get(0).get本算定決定通知書情報().get発行日().toDateString());

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課,
                        property.reportId(),
                        発行日,
                        NinshoshaDenshikoinshubetsuCode.保険者印,
                        reportSourceWriter);
                CompKaigoToiawasesakiSource compKaigoToiawasesakiSource = getCompKaigoToiawasesakiSource(帳票分類ID);
                for (KaigoHokenHokenryogakuKetteiTsuchishoJoho joho : entities) {
                    KaigoHokenHokenryogakuKetteiTsuchishoBusiness business = new KaigoHokenHokenryogakuKetteiTsuchishoBusiness();
                    business.set文書番号(joho.get文書番号());
                    business.set本算定決定通知書情報(joho.get本算定決定通知書情報());
                    business.set調定事由リスト(joho.get調定事由リスト());
                    business.set通知書定型文(joho.get通知書定型文());
                    business.setNinshoshaSource(ninshoshaSource);
                    business.setCompKaigoToiawasesakiSource(compKaigoToiawasesakiSource);
                    targets.add(business);
                }
                for (KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReport report : toReportsB5Yoko(targets)) {
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    /**
     * printA4Tateメソッド(単一帳票出力用)
     *
     * @param entities EditedKariSanteiFukaDaichoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection printA4Tate(List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities) {
        try (ReportManager reportManager = new ReportManager()) {
            printA4Tate(entities, reportManager);
            return reportManager.publish();
        }
    }

    /**
     * printA4Tateメソッド
     *
     * @param entities EditedKariSanteiFukaDaichoJoho
     * @param reportManager ReportManager
     */
    public void printA4Tate(List<KaigoHokenHokenryogakuKetteiTsuchishoJoho> entities, ReportManager reportManager) {
        KaigoHokenHokenryogakuKetteiTsuchishoA4TateProperty property = new KaigoHokenHokenryogakuKetteiTsuchishoA4TateProperty();
        List<KaigoHokenHokenryogakuKetteiTsuchishoBusiness> targets = new ArrayList<>();
        try (ReportAssembler<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            if (entities != null && !entities.isEmpty()) {
                ReportId 帳票分類ID = entities.get(0).get本算定決定通知書情報().get帳票分類ID();
                FlexibleDate 発行日 = new FlexibleDate(entities.get(0).get本算定決定通知書情報().get発行日().toDateString());

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課,
                        property.reportId(),
                        発行日,
                        NinshoshaDenshikoinshubetsuCode.保険者印,
                        reportSourceWriter);
                CompKaigoToiawasesakiSource compKaigoToiawasesakiSource = getCompKaigoToiawasesakiSource(帳票分類ID);
                for (KaigoHokenHokenryogakuKetteiTsuchishoJoho joho : entities) {
                    KaigoHokenHokenryogakuKetteiTsuchishoBusiness business = new KaigoHokenHokenryogakuKetteiTsuchishoBusiness();
                    business.set文書番号(joho.get文書番号());
                    business.set本算定決定通知書情報(joho.get本算定決定通知書情報());
                    business.set調定事由リスト(joho.get調定事由リスト());
                    business.set通知書定型文(joho.get通知書定型文());
                    business.setNinshoshaSource(ninshoshaSource);
                    business.setCompKaigoToiawasesakiSource(compKaigoToiawasesakiSource);
                    targets.add(business);
                }
                for (KaigoHokenHokenryogakuKetteiTsuchishoA4TateReport report : toReportsA4Tate(targets)) {
                    report.writeBy(reportSourceWriter);
                }
            }
        }

    }

    private CompKaigoToiawasesakiSource getCompKaigoToiawasesakiSource(ReportId 帳票分類ID) {
        KaigoToiawasesakiManager kaigoToiawasesakiManager = new KaigoToiawasesakiManager();
        KaigoToiawasesaki kaigoToiawasesaki = kaigoToiawasesakiManager.get介護問合せ先(SubGyomuCode.DBB介護賦課, 帳票分類ID);
        KaigoToiawasesakiSourceBuilder builder = new KaigoToiawasesakiSourceBuilder(kaigoToiawasesaki);
        return builder.buildSource();
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

    /**
     * toReportsメソッド
     *
     * @param targets (List<KaigoHokenHokenryogakuKetteiTsuchishoBusiness>
     * @return List<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReport>
     */
    private static List<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReport> toReportsB5Yoko(
            List<KaigoHokenHokenryogakuKetteiTsuchishoBusiness> targets) {
        List<KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReport> list = new ArrayList<>();
        list.add(new KaigoHokenHokenryogakuKetteiTsuchishoB5YokoReport(targets));
        return list;
    }

    /**
     * toReportsメソッド
     *
     * @param targets (List<KaigoHokenHokenryogakuKetteiTsuchishoBusiness>
     * @return List<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReport>
     */
    private static List<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReport> toReportsA4Tate(
            List<KaigoHokenHokenryogakuKetteiTsuchishoBusiness> targets) {
        List<KaigoHokenHokenryogakuKetteiTsuchishoA4TateReport> list = new ArrayList<>();
        list.add(new KaigoHokenHokenryogakuKetteiTsuchishoA4TateReport(targets));
        return list;
    }
}
