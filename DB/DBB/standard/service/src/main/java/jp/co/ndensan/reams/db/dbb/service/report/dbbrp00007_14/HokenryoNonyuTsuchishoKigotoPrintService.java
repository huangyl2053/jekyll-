/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.dbbrp00007_14;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.INonyuTsuchisho;
import jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_14.HokenryoNonyuTsuchishoKigotoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_14.HokenryoNonyuTsuchishoKigotoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_14.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
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
 * 帳票設計_DBBRP00007_14_保険料納入通知書（本算定過年度）【期毎タイプ】のプリントサービスです。
 *
 * @reamsid_L DBB-9110-140 wangjie2
 */
public class HokenryoNonyuTsuchishoKigotoPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoKigotoProperty property = new HokenryoNonyuTsuchishoKigotoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoKigotoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                        SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし,
                        reportSourceWriter);
                HokenryoNonyuTsuchishoKigotoReport report
                        = HokenryoNonyuTsuchishoKigotoReport.createFrom(本算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {
        HokenryoNonyuTsuchishoKigotoProperty property = new HokenryoNonyuTsuchishoKigotoProperty();
        try (ReportAssembler<HokenryoNonyuTsuchishoKigotoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                    SubGyomuCode.DBB介護賦課,
                    帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                    KenmeiFuyoKubunType.付与なし,
                    reportSourceWriter);
            HokenryoNonyuTsuchishoKigotoReport report
                    = HokenryoNonyuTsuchishoKigotoReport.createFrom(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection
     */
    public SourceDataCollection printDevidedByPage(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        HokenryoNonyuTsuchishoKigotoProperty property = new HokenryoNonyuTsuchishoKigotoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HokenryoNonyuTsuchishoKigotoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<HokenryoNonyuTsuchishoKigotoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                        SubGyomuCode.DBB介護賦課, 帳票分類ID,
                        new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        KenmeiFuyoKubunType.付与なし,
                        reportSourceWriter);
                List<INonyuTsuchisho> reportList
                        = HokenryoNonyuTsuchishoKigotoReport.createFrom(本算定納入通知書情報, ninshoshaSource).devidedByPage();
                for (INonyuTsuchisho report : reportList) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}
