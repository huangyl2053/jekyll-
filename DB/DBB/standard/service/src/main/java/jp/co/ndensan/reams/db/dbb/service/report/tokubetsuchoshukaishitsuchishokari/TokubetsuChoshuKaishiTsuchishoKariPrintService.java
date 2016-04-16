/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchishokari;

import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Report;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 特別徴収開始通知書（仮算定）帳票
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariPrintService {

    /**
     * 帳票項目定義【B5横タイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 宛名連番 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 宛名連番) {

        TokubetsuChoshuKaishiTsuchishoKariB5Property property = new TokubetsuChoshuKaishiTsuchishoKariB5Property();

//        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(),
//                仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後宛先().get地方公共団体(),
//                仮算定特徴開始通知書情報.get編集後仮算定通知書共通情報().get編集後宛先().get帳票制御共通(), null, null, true,
//                null, null, null, null);
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariB5Source> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, new RString("0001"));

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate("20150101")).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariB5Report(new SofubutsuAtesakiSource(), sourceBuilder,
                        仮算定特徴開始通知書情報, 宛名連番).writeBy(reportSourceWriter);
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

    /**
     * 帳票項目定義【B5横タイプ（連帳）】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 宛名連番 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ連帳(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 宛名連番) {
        TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty property = new TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty();
        //        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(),
//                null, null, null, NENDO, true,
//                JushoKangaiEditPattern.space方書,
//                JushoPrefix.市町村名付加,
//                JushoKannaiEditPattern.町域番地,
//                GyoseikuInjiKubun.印字しない);
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = null;

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, new RString("0001"));

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate("20150101")).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(new SofubutsuAtesakiSource(), sourceBuilder,
                        仮算定特徴開始通知書情報, 宛名連番).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * 帳票項目定義【シーラタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection printシーラタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報) {

        TokubetsuChoshuKaishiTsuchishoKariSealerProperty property = new TokubetsuChoshuKaishiTsuchishoKariSealerProperty();
        //        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(),
//                null, null, null, NENDO, true,
//                JushoKangaiEditPattern.space方書,
//                JushoPrefix.市町村名付加,
//                JushoKannaiEditPattern.町域番地,
//                GyoseikuInjiKubun.印字しない);
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = null;

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariSealerSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, new RString("0001"));

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate("20150101")).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariSealerReport(new SofubutsuAtesakiSource(), sourceBuilder,
                        仮算定特徴開始通知書情報).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【シーラタイプ（連帳）】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection printシーラタイプ連帳(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報) {

        TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty property = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty();
        //        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(),
        //                null, null, null, NENDO, true,
        //                JushoKangaiEditPattern.space方書,
        //                JushoPrefix.市町村名付加,
        //                JushoKannaiEditPattern.町域番地,
        //                GyoseikuInjiKubun.印字しない);
        //        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        //        SofubutsuAtesakiSource sofubutsuAtesakiSource = null;

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, new RString("0001"));

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate("20150101")).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(new SofubutsuAtesakiSource(), sourceBuilder,
                        仮算定特徴開始通知書情報).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【A4縦・オーバーレイタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 通知書定型文１ RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printA4縦オーバーレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 通知書定型文１) {

        TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty property = new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty();
        //        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(),
        //                null, null, null, NENDO, true,
        //                JushoKangaiEditPattern.space方書,
        //                JushoPrefix.市町村名付加,
        //                JushoKannaiEditPattern.町域番地,
        //                GyoseikuInjiKubun.印字しない);
        //        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        //        SofubutsuAtesakiSource sofubutsuAtesakiSource = null;

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, new ReportId("000001"));
        CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, new RString("0001"));

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate("20150101")).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(new SofubutsuAtesakiSource(), sourceBuilder, toiawasesakiSource,
                        仮算定特徴開始通知書情報, 通知書定型文１).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【B5横・オーバレイタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 通知書定型文１ RString
     * @param 通知書定型文２ RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横オーバレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            RString 通知書定型文１,
            RString 通知書定型文２) {

        TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty property = new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty();
        //        EditedAtesaki 編集後宛先 = new EditedAtesaki(仮算定特徴開始通知書情報.get宛先情報(),
//                null, null, null, NENDO, true,
//                JushoKangaiEditPattern.space方書,
//                JushoPrefix.市町村名付加,
//                JushoKannaiEditPattern.町域番地,
//                GyoseikuInjiKubun.印字しない);
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
//        SofubutsuAtesakiSource sofubutsuAtesakiSource = null;

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, new ReportId("000001"));
        CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, new RString("0001"));

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate("20150101")).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(new SofubutsuAtesakiSource(), sourceBuilder, toiawasesakiSource,
                        仮算定特徴開始通知書情報, 通知書定型文１, 通知書定型文２).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }
}
