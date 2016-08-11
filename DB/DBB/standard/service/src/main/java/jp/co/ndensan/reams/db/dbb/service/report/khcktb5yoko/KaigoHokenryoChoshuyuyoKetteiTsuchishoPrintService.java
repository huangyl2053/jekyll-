/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.entity.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 介護保険料徴収猶予決定通知書帳票PrintServiceです。
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoPrintService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 15;
    private static final RString 種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
    private static final RString RSTRING_1 = new RString("1");

    /**
     * printメソッド
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @param reportManager ReportManager
     */
    public void printB5横タイプ(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        if (徴収猶予決定通知書情報 != null) {
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty property
                    = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty();
            try (ReportAssembler<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> assembler = createAssembler(property, reportManager)) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null ? FlexibleDate.getNowDate() : new FlexibleDate(発行日.toDateString()));
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 徴収猶予決定通知書情報.get帳票制御共通();
                boolean is公印に掛ける = false;
                boolean is公印を省略 = false;
                if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        地方公共団体,
                        assembler.getImageFolderPath(),
                        発行日 == null ? RDate.getNowDate() : 発行日,
                        is公印に掛ける,
                        is公印を省略,
                        KenmeiFuyoKubunType.付与なし).buildSource();
                ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                EditedAtesaki 編集後宛先 = get編集後宛先(徴収猶予決定通知書情報);

                for (int index = START_NUMBER; index < END_NUMBER; index++) {
                    HyojiCodes 表示コード = get表示コード(徴収猶予決定通知書情報);

                    KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport report
                            = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport(文書番号, 徴収猶予決定通知書情報,
                                    通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, index, 編集後宛先);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    /**
     * printメソッド
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @param reportManager ReportManager
     */
    public void printA4縦タイプ(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー, ReportManager reportManager) {
        if (徴収猶予決定通知書情報 != null) {
            KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty property
                    = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty();
            try (ReportAssembler<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> assembler = createAssembler(property, reportManager)) {
                Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 種別コード,
                        発行日 == null ? FlexibleDate.getNowDate() : new FlexibleDate(発行日.toDateString()));
                Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
                ChohyoSeigyoKyotsu 帳票制御共通 = 徴収猶予決定通知書情報.get帳票制御共通();
                boolean is公印に掛ける = false;
                boolean is公印を省略 = false;
                if (帳票制御共通 != null && RSTRING_1.equals(帳票制御共通.get首長名印字位置())) {
                    is公印に掛ける = true;
                }
                if (帳票制御共通 != null && !帳票制御共通.is電子公印印字有無()) {
                    is公印を省略 = true;
                }
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        地方公共団体,
                        assembler.getImageFolderPath(),
                        発行日 == null ? RDate.getNowDate() : 発行日,
                        is公印に掛ける,
                        is公印を省略,
                        KenmeiFuyoKubunType.付与なし).buildSource();
                ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                EditedAtesaki 編集後宛先 = get編集後宛先(徴収猶予決定通知書情報);
                for (int index = START_NUMBER; index < END_NUMBER; index++) {
                    HyojiCodes 表示コード = get表示コード(徴収猶予決定通知書情報);

                    KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport report
                            = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport(文書番号, 徴収猶予決定通知書情報,
                                    通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, index, 編集後宛先);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    private HyojiCodes get表示コード(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報) {

        HyojiCodeResearcher hyojiCodeResearcher = new HyojiCodeResearcher();
        if (isNotNull(徴収猶予決定通知書情報.get帳票制御共通()) && isNotNull(徴収猶予決定通知書情報.get宛名())
                && isNotNull(徴収猶予決定通知書情報.get納組情報())) {
            return hyojiCodeResearcher.create表示コード情報(
                    徴収猶予決定通知書情報.get帳票制御共通().toEntity(),
                    徴収猶予決定通知書情報.get宛名().get住所().get町域コード().value(),
                    徴収猶予決定通知書情報.get宛名().get行政区画().getGyoseiku().getコード().value(),
                    徴収猶予決定通知書情報.get宛名().get行政区画().getChiku1().getコード().value(),
                    徴収猶予決定通知書情報.get宛名().get行政区画().getChiku2().getコード().value(),
                    徴収猶予決定通知書情報.get宛名().get行政区画().getChiku3().getコード().value(),
                    徴収猶予決定通知書情報.get納組情報().getNokumi().getNokumiCode());
        } else {
            return null;
        }
    }

    private EditedAtesaki get編集後宛先(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報) {

        EditedAtesaki 編集後宛先 = new EditedAtesaki(徴収猶予決定通知書情報.get宛先(),
                徴収猶予決定通知書情報.get地方公共団体(), 徴収猶予決定通知書情報.get帳票制御共通());
        if (isNotNull(徴収猶予決定通知書情報.get宛先()) && isNotNull(徴収猶予決定通知書情報.get地方公共団体())
                && isNotNull(徴収猶予決定通知書情報.get帳票制御共通())) {
            編集後宛先 = JushoHenshu.create編集後宛先(徴収猶予決定通知書情報.get宛先(),
                    徴収猶予決定通知書情報.get地方公共団体(), 徴収猶予決定通知書情報.get帳票制御共通());
        }
        return 編集後宛先;
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

    private boolean isNotNull(Object object) {
        return object != null;
    }
}
