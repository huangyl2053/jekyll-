/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.kyotakuJutakukaishuhi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem;
import jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiProperty;
import jp.co.ndensan.reams.db.dba.business.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport;
import jp.co.ndensan.reams.db.dba.entity.report.jutakukaishuhishikyu.JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書のPrintServiceです。
 */
public class KyotakuJutakuKaishuhiShikyuShinseisho {

    private static final RString 生年月日不詳区分 = new RString("0");
    private static final int 桁数_7 = 7;
    private static final int 桁数_3 = 3;

    /**
     * 介護保険居宅介護（予防）住宅改修費支給（受領委任払）申請書を印刷します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection getKyotakuJutakuKaishuhiShikyuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        JutakuKaishuhiShikyuShinseishoJuryoIninHaraiProperty property = new JutakuKaishuhiShikyuShinseishoJuryoIninHaraiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource> assembler
                    = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, null);
                for (JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport report : toReports(get被保険者基本情報取得(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport> toReports(
            HihokenshaKihonBusiness business, RString ninshoshaYakushokuMei) {
        List<JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            生年月日 = パターン12(business.get生年月日());
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = get生年月日_外国人(business);
        }
        RString 郵便番号 = RString.EMPTY;
        if (business.get郵便番号() != null && !business.get郵便番号().isEmpty()) {
            StringBuilder builder = new StringBuilder();
            if (business.get郵便番号().length() == 桁数_7) {
                builder.append(business.get郵便番号().substring(桁数_3));
                builder.append(new RString("-"));
                builder.append(business.get郵便番号().substring(桁数_3, 桁数_7));
                郵便番号 = new RString(builder.toString());
            }
        }
        JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem item = new JutakuKaishuhiShikyuShinseishoJuryoIninHaraiItem(
                business.getフリガナ(),
                business.get保険者番号().value(),
                business.get被保険者氏名(),
                business.get被保険者番号().value(),
                生年月日,
                郵便番号,
                business.get電話番号(),
                business.get住所(),
                //TODO: 文言の取得 対応待ち
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                ninshoshaYakushokuMei
        );
        list.add(JutakuKaishuhiShikyuShinseishoJuryoIninHaraiReport.createFrom(item));
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

    private static HihokenshaKihonBusiness get被保険者基本情報取得(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }

    private static RString get生年月日_外国人(HihokenshaKihonBusiness business) {
        RString 生年月日 = RString.EMPTY;
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法))) {
            生年月日 = パターン37(business.get生年月日());
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法))) {
            if (business.get生年月日不詳区分().equals(生年月日不詳区分)) {
                生年月日 = パターン12(business.get生年月日());
            } else {
                生年月日 = RString.EMPTY;
            }
        }
        return 生年月日;
    }

    private static RString パターン12(FlexibleDate date) {
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString パターン37(FlexibleDate date) {
        return date.wareki().separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
