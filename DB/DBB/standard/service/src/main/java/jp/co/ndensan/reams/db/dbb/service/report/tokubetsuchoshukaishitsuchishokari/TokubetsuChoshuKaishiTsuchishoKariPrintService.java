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
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariB5Source;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokari.TokubetsuChoshuKaishiTsuchishoKariSealerSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.service.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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

    private final RString 帳票分類ID = new RString("DBB100004");

    /**
     * 帳票項目定義【B5横タイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 宛名連番) {

        TokubetsuChoshuKaishiTsuchishoKariB5Property property = new TokubetsuChoshuKaishiTsuchishoKariB5Property();
        // TODO 仮算定通知書情報がない QA647
        JushoHenshu jushoHenshu = JushoHenshu.createInstance();
        EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariB5Source> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate(仮算定特徴開始通知書情報.get発行日().toString())).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, sourceBuilder,
                        仮算定特徴開始通知書情報, 宛名連番).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【B5横タイプ（連帳）】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ連帳(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 宛名連番) {
        TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty property = new TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty();

        // TODO 仮算定通知書情報がない QA647
        JushoHenshu jushoHenshu = JushoHenshu.createInstance();
        EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate(仮算定特徴開始通知書情報.get発行日().toString())).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, sourceBuilder,
                        仮算定特徴開始通知書情報, 宛名連番).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }

    }

    /**
     * 帳票項目定義【シーラタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @return SourceDataCollection
     */
    public SourceDataCollection printシーラタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {

        TokubetsuChoshuKaishiTsuchishoKariSealerProperty property = new TokubetsuChoshuKaishiTsuchishoKariSealerProperty();

        // TODO 仮算定通知書情報がない QA647
        JushoHenshu jushoHenshu = JushoHenshu.createInstance();
        EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariSealerSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate(仮算定特徴開始通知書情報.get発行日().toString())).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, sourceBuilder,
                        仮算定特徴開始通知書情報).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【シーラタイプ（連帳）】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @return SourceDataCollection
     */
    public SourceDataCollection printシーラタイプ連帳(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報) {

        TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty property = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty();

        // TODO 仮算定通知書情報がない QA647
        JushoHenshu jushoHenshu = JushoHenshu.createInstance();
        EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate(仮算定特徴開始通知書情報.get発行日().toString())).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, sourceBuilder,
                        仮算定特徴開始通知書情報).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【A4縦・オーバーレイタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 通知書定型文１ RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printA4縦オーバーレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 通知書定型文１) {

        TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty property = new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty();

        // TODO 仮算定通知書情報がない QA647
        JushoHenshu jushoHenshu = JushoHenshu.createInstance();
        EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, 仮算定特徴開始通知書情報.get帳票分類ID());
        CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate(仮算定特徴開始通知書情報.get発行日().toString())).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, sourceBuilder, toiawasesakiSource,
                        仮算定特徴開始通知書情報, 通知書定型文１).writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票項目定義【B5横・オーバレイタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 通知書定型文１ RString
     * @param 通知書定型文２ RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横オーバレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 通知書定型文１,
            RString 通知書定型文２) {

        TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty property = new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty();

        // TODO 仮算定通知書情報がない QA647
        JushoHenshu jushoHenshu = JushoHenshu.createInstance();
        EditedAtesaki 編集後宛先 = jushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, 仮算定特徴開始通知書情報.get帳票分類ID());
        CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> assembler = createAssembler(property, reportManager);) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 帳票分類ID);

                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        AssociationFinderFactory.createInstance().getAssociation(),
                        assembler.getImageFolderPath(), new RDate(仮算定特徴開始通知書情報.get発行日().toString())).buildSource();

                ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, sourceBuilder, toiawasesakiSource,
                        仮算定特徴開始通知書情報, 通知書定型文１, 通知書定型文２).writeBy(reportSourceWriter);
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
