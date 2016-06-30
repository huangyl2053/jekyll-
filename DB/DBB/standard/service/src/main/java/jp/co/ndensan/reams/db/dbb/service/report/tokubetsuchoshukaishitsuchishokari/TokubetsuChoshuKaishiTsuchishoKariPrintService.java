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
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 特別徴収開始通知書（仮算定）帳票
 *
 * @reamsid_L DBB-0790-050 lijunjun
 */
public class TokubetsuChoshuKaishiTsuchishoKariPrintService {

    private static final RString RSTRING_1 = new RString("1");

    /**
     * 帳票項目定義【B5横タイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param reportManager ReportManager
     */
    public void printB5横タイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 宛名連番, ReportManager reportManager) {

        TokubetsuChoshuKaishiTsuchishoKariB5Property property = new TokubetsuChoshuKaishiTsuchishoKariB5Property();
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariB5Source> assembler = createAssembler(property, reportManager);) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
            boolean is公印に掛ける = false;
            if (帳票制御共通.get首長名印字位置() != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                is公印に掛ける = true;
            }
            boolean is公印を省略 = false;
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            FlexibleDate 発行日 = 仮算定通知書情報.get発行日();
            発行日 = (null == 発行日 || 発行日.isEmpty()) ? new FlexibleDate(RDate.getNowDate().toString()) : 仮算定通知書情報.get発行日();
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    new RDate(発行日.toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5Source> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoKariB5Report(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報, 宛名連番).writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票項目定義【B5横タイプ（連帳）】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 宛名連番 RString
     * @param reportManager ReportManager
     */
    public void printB5横タイプ連帳(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 宛名連番, ReportManager reportManager) {
        TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty property = new TokubetsuChoshuKaishiTsuchishoKariB5RenchoProperty();

        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> assembler = createAssembler(property, reportManager);) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
            boolean is公印に掛ける = false;
            if (帳票制御共通.get首長名印字位置() != null && 帳票制御共通.get首長名印字位置().equals(RSTRING_1)) {
                is公印に掛ける = true;
            }
            boolean is公印を省略 = false;
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariB5RenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoKariB5RenchoReport(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報, 宛名連番).writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票項目定義【シーラタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printシーラタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報, ReportManager reportManager) {

        TokubetsuChoshuKaishiTsuchishoKariSealerProperty property = new TokubetsuChoshuKaishiTsuchishoKariSealerProperty();

        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariSealerSource> assembler = createAssembler(property, reportManager);) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
            boolean is公印に掛ける = false;
            if (帳票制御共通.get首長名印字位置() != null && 帳票制御共通.get首長名印字位置().equals(RSTRING_1)) {
                is公印に掛ける = true;
            }
            boolean is公印を省略 = false;
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoKariSealerReport(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報).writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票項目定義【シーラタイプ（連帳）】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param reportManager ReportManager
     */
    public void printシーラタイプ連帳(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報, ReportManager reportManager) {

        TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty property = new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoProperty();

        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> assembler = createAssembler(property, reportManager);) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
            boolean is公印に掛ける = false;
            if (帳票制御共通.get首長名印字位置() != null && 帳票制御共通.get首長名印字位置().equals(RSTRING_1)) {
                is公印に掛ける = true;
            }
            boolean is公印を省略 = false;
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariSealerRenchoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoKariSealerRenchoReport(編集後宛先, sourceBuilder,
                    仮算定特徴開始通知書情報).writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票項目定義【A4縦・オーバーレイタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 通知書定型文１ RString
     * @param reportManager ReportManager
     */
    public void printA4縦オーバーレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 通知書定型文１, ReportManager reportManager) {

        TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty property = new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateProperty();

        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, 仮算定通知書情報.get帳票分類ID());
        CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();

        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> assembler = createAssembler(property, reportManager);) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
            boolean is公印に掛ける = false;
            if (帳票制御共通.get首長名印字位置() != null && 帳票制御共通.get首長名印字位置().equals(RSTRING_1)) {
                is公印に掛ける = true;
            }
            boolean is公印を省略 = false;
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoKariOverlayA4TateReport(編集後宛先, sourceBuilder, toiawasesakiSource,
                    仮算定特徴開始通知書情報, 通知書定型文１).writeBy(reportSourceWriter);
        }
    }

    /**
     * 帳票項目定義【B5横・オーバレイタイプ】printメソッドです。
     *
     * @param 仮算定特徴開始通知書情報 KariTokuchoKaishiTsuchisyoJoho
     * @param 仮算定通知書情報 KariSanteiTsuchiShoKyotsu
     * @param 通知書定型文１ RString
     * @param 通知書定型文２ RString
     * @param reportManager ReportManager
     */
    public void printB5横オーバレイタイプ(KariTokuchoKaishiTsuchisyoJoho 仮算定特徴開始通知書情報,
            KariSanteiTsuchiShoKyotsu 仮算定通知書情報,
            RString 通知書定型文１,
            RString 通知書定型文２, ReportManager reportManager) {

        TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty property = new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoProperty();

        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(仮算定通知書情報.get宛先情報(),
                仮算定通知書情報.get地方公共団体(), 仮算定通知書情報.get帳票制御共通());

        IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー = KaigoToiawasesakiSourceBuilderCreator.create(
                SubGyomuCode.DBB介護賦課, 仮算定特徴開始通知書情報.get帳票分類ID());
        CompKaigoToiawasesakiSource toiawasesakiSource = 介護問合せ先ソースビルダー.buildSource();

        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> assembler = createAssembler(property, reportManager);) {
            Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().
                    get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            ChohyoSeigyoKyotsu 帳票制御共通 = 仮算定通知書情報.get帳票制御共通();
            boolean is公印に掛ける = false;
            if (帳票制御共通.get首長名印字位置() != null && 帳票制御共通.get首長名印字位置().equals(RSTRING_1)) {
                is公印に掛ける = true;
            }
            boolean is公印を省略 = false;
            if (!帳票制御共通.is電子公印印字有無()) {
                is公印を省略 = true;
            }
            NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                    認証者,
                    地方公共団体,
                    assembler.getImageFolderPath(),
                    new RDate(仮算定通知書情報.get発行日().toString()),
                    is公印に掛ける,
                    is公印を省略,
                    KenmeiFuyoKubunType.付与なし).buildSource();

            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuKaishiTsuchishoKariOverlayB5YokoReport(編集後宛先, sourceBuilder, toiawasesakiSource,
                    仮算定特徴開始通知書情報, 通知書定型文１, 通知書定型文２).writeBy(reportSourceWriter);
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
