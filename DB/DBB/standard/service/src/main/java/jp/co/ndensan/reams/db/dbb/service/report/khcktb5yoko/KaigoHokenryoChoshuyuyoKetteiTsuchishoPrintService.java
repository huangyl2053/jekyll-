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
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HyojiCodeResearcher;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.IKaigoToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 介護保険料徴収猶予決定通知書帳票PrintServiceです。
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoPrintService {

    private static final int ONE = 1;
    private static final int END_NUMBER = 15;
    private static final RString 種別コード = new RString("DBB100081");

    /**
     * printメソッド
     *
     * @param 発行日 発行日
     * @param 文書番号 文書番号
     * @param 徴収猶予決定通知書情報 徴収猶予決定通知書情報
     * @param 通知書定型文 通知書定型文
     * @param 介護問合せ先ソースビルダー 介護問合せ先ソースビルダー
     * @return SourceDataCollection
     */
    public SourceDataCollection printB5横タイプ(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {

        KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty property
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        徴収猶予決定通知書情報.get地方公共団体(), assembler.getImageFolderPath(), 発行日).buildSource();
                ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                for (int index = ONE; index < END_NUMBER; index++) {
                    HyojiCodes 表示コード = get表示コード(徴収猶予決定通知書情報);

                    KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport report
                            = new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoReport(文書番号, 徴収猶予決定通知書情報,
                                    通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, index);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
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
     * @return SourceDataCollection
     */
    public SourceDataCollection printA4縦タイプ(RDate 発行日, RString 文書番号,
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報,
            RString 通知書定型文, IKaigoToiawasesakiSourceBuilder 介護問合せ先ソースビルダー) {

        KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty property
                = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaManager manager = new _NinshoshaManager();
                Ninshosha 認証者 = manager.get帳票認証者(GyomuCode.DB介護保険, 種別コード);
                NinshoshaSource sourceBuilder = NinshoshaSourceBuilderFactory.createInstance(認証者,
                        徴収猶予決定通知書情報.get地方公共団体(), assembler.getImageFolderPath(), 発行日).buildSource();
                ReportSourceWriter<KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);

                for (int index = ONE; index < END_NUMBER; index++) {
                    HyojiCodes 表示コード = get表示コード(徴収猶予決定通知書情報);

                    KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport report
                            = new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateReport(文書番号, 徴収猶予決定通知書情報,
                                    通知書定型文, 介護問合せ先ソースビルダー, sourceBuilder, 表示コード, index);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }

    }

    private HyojiCodes get表示コード(KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoJoho 徴収猶予決定通知書情報) {

        HyojiCodeResearcher hyojiCodeResearcher = new HyojiCodeResearcher();
        return hyojiCodeResearcher.create表示コード情報(
                徴収猶予決定通知書情報.get帳票制御共通().toEntity(),
                new RString(徴収猶予決定通知書情報.get宛名().get住所().get町域コード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getGyoseiku().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getChiku1().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getChiku2().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get宛名().get行政区画().getChiku3().getコード().toString()),
                new RString(徴収猶予決定通知書情報.get納組情報().getNokumi().getNokumiCode().toString()));
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
