/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteihenkotsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100010.KarisanteiHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100011.KarisanteiHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 帳票「帳票設計_DBBRP35003_1_仮算定額変更通知書（平準化＋仮算定異動）」のプリントサービスです。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
public class KarisanteiHenkoTsuchishoPrintService {

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 文書番号 文書番号
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号) {

        RString 帳票ID = 仮算定納入通知書情報.get帳票ID().getColumnValue();

        if (ReportIdDBB.DBB100010.getReportId().getColumnValue().equals(帳票ID)) {
            return print仮算定額変更B5横(仮算定納入通知書情報, 文書番号);

        } else if (ReportIdDBB.DBB100011.getReportId().getColumnValue().equals(帳票ID)) {
            return print仮算定額変更A4縦(仮算定納入通知書情報, 文書番号);

        } else if (ReportIdDBB.DBB100012.getReportId().getColumnValue().equals(帳票ID)) {
            return print特別徴収平準化B5横(仮算定納入通知書情報, 文書番号);

        } else if (ReportIdDBB.DBB100013.getReportId().getColumnValue().equals(帳票ID)) {
            return print特別徴収平準化A4縦(仮算定納入通知書情報, 文書番号);

        }
        return null;
    }

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 文書番号 文書番号
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号, ReportManager reportManager) {

        RString 帳票ID = 仮算定納入通知書情報.get帳票ID().getColumnValue();

        if (ReportIdDBB.DBB100010.getReportId().getColumnValue().equals(帳票ID)) {
            print仮算定額変更B5横(仮算定納入通知書情報, 文書番号, reportManager);

        } else if (ReportIdDBB.DBB100011.getReportId().getColumnValue().equals(帳票ID)) {
            print仮算定額変更A4縦(仮算定納入通知書情報, 文書番号, reportManager);

        } else if (ReportIdDBB.DBB100012.getReportId().getColumnValue().equals(帳票ID)) {
            print特別徴収平準化B5横(仮算定納入通知書情報, 文書番号, reportManager);

        } else if (ReportIdDBB.DBB100013.getReportId().getColumnValue().equals(帳票ID)) {
            print特別徴収平準化A4縦(仮算定納入通知書情報, 文書番号, reportManager);

        }
    }

    private SourceDataCollection print仮算定額変更B5横(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print仮算定額変更B5横(仮算定納入通知書情報, 文書番号, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private void print仮算定額変更B5横(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号, ReportManager reportManager) {

        CompKaigoToiawasesakiSource kaigoToiawasesakiSource = KaigoToiawasesakiSourceBuilderCreator
                .create(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID()).buildSource();

        KarisanteiHenkoTsuchishoB5YokoProperty property = new KarisanteiHenkoTsuchishoB5YokoProperty();
        try (ReportAssembler<KarisanteiHenkoTsuchishoB5YokoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHenkoTsuchishoB5YokoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID(),
                    仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHenkoTsuchishoB5YokoReport report
                    = new KarisanteiHenkoTsuchishoB5YokoReport(仮算定納入通知書情報, 文書番号, ninshoshaSource, kaigoToiawasesakiSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print仮算定額変更A4縦(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print仮算定額変更A4縦(仮算定納入通知書情報, 文書番号, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private void print仮算定額変更A4縦(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号, ReportManager reportManager) {

        CompKaigoToiawasesakiSource kaigoToiawasesakiSource = KaigoToiawasesakiSourceBuilderCreator
                .create(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID()).buildSource();

        KarisanteiHenkoTsuchishoA4TateProperty property = new KarisanteiHenkoTsuchishoA4TateProperty();
        try (ReportAssembler<KarisanteiHenkoTsuchishoA4TateReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHenkoTsuchishoA4TateReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID(),
                    仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHenkoTsuchishoA4TateReport report
                    = new KarisanteiHenkoTsuchishoA4TateReport(仮算定納入通知書情報, 文書番号, ninshoshaSource, kaigoToiawasesakiSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print特別徴収平準化B5横(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print特別徴収平準化B5横(仮算定納入通知書情報, 文書番号, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private void print特別徴収平準化B5横(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号, ReportManager reportManager) {

        CompKaigoToiawasesakiSource kaigoToiawasesakiSource = KaigoToiawasesakiSourceBuilderCreator
                .create(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID()).buildSource();

        KarisanteiHenjunkaHenkoTsuchishoB5YokoProperty property = new KarisanteiHenjunkaHenkoTsuchishoB5YokoProperty();
        try (ReportAssembler<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID(),
                    仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHenjunkaHenkoTsuchishoB5YokoReport report
                    = new KarisanteiHenjunkaHenkoTsuchishoB5YokoReport(仮算定納入通知書情報, 文書番号, ninshoshaSource, kaigoToiawasesakiSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private SourceDataCollection print特別徴収平準化A4縦(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print特別徴収平準化A4縦(仮算定納入通知書情報, 文書番号, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private void print特別徴収平準化A4縦(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, RString 文書番号, ReportManager reportManager) {

        CompKaigoToiawasesakiSource kaigoToiawasesakiSource = KaigoToiawasesakiSourceBuilderCreator
                .create(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID()).buildSource();

        KarisanteiHenjunkaHenkoTsuchishoA4TateProperty property = new KarisanteiHenjunkaHenkoTsuchishoA4TateProperty();
        try (ReportAssembler<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 仮算定納入通知書情報.get帳票分類ID(),
                    仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHenjunkaHenkoTsuchishoA4TateReport report = new KarisanteiHenjunkaHenkoTsuchishoA4TateReport(仮算定納入通知書情報, 文書番号,
                    ninshoshaSource, kaigoToiawasesakiSource);
            report.writeBy(reportSourceWriter);
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
