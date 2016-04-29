/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchisho;

import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB52Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchisho.TokubetsuChoshuKaishiTsuchishoSealerSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 帳票設計_DBBRP43002_1_特別徴収開始通知書（本算定）PrintService
 *
 * @reamsid_L DBB-0780-070 xuhao
 */
public class TokubetsuChoshuKaishiTsuchishoPrintService {

    private static final RString 帳票分類ID = new RString("DBB100032");

    /**
     * B5横タイプ printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printB5横タイプ(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoB5Property property
                = new TokubetsuChoshuKaishiTsuchishoB5Property();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB5Source> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5Source> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoB5Report(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * B5横タイプ連帳 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printB5横タイプ連帳(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoB5RenchoProperty property
                = new TokubetsuChoshuKaishiTsuchishoB5RenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB5RenchoSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB5RenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoB5RenchoReport(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * シーラタイプ printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printシーラタイプ(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoSealerProperty property
                = new TokubetsuChoshuKaishiTsuchishoSealerProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoSealerSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoSealerReport(編集後本算定通知書共通情報, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * printシーラタイプ連帳 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printシーラタイプ連帳(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty property
                = new TokubetsuChoshuKaishiTsuchishoSealerRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoSealerRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoSealerRenchoReport(編集後本算定通知書共通情報, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * B5横タイプ2 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printB5横タイプ2(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoB52Property property
                = new TokubetsuChoshuKaishiTsuchishoB52Property();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB52Source> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52Source> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoB52Report(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * B5横タイプ2連帳 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printB5横タイプ2連帳(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 宛名連番,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoB52RenchoProperty property
                = new TokubetsuChoshuKaishiTsuchishoB52RenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoB52RenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoB52RenchoReport(編集後本算定通知書共通情報, 宛名連番, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * printA4縦 printメソッド
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsu
     * @param 通知書定型文 RString
     * @param 本算定通知書情報 HonSanteiTsuchiShoKyotsu
     * @return 特別徴収開始通知書帳票
     */
    public SourceDataCollection printA4縦(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 通知書定型文,
            HonSanteiTsuchiShoKyotsu 本算定通知書情報) {
        TokubetsuChoshuKaishiTsuchishoOverlayA4TateProperty property
                = new TokubetsuChoshuKaishiTsuchishoOverlayA4TateProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        認証者,
                        本算定通知書情報.get地方公共団体(),
                        assembler.getImageFolderPath(),
                        本算定通知書情報.get発行日()).buildSource();
                IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー
                        = KaigoToiawasesakiSourceBuilderCreator.create(SubGyomuCode.DBB介護賦課, 本算定通知書情報.get帳票分類ID());
                CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();
                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoOverlayA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoOverlayA4TateReport(編集後本算定通知書共通情報, 通知書定型文, toiawasesakiSource, sourceBuilder).
                        writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

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
