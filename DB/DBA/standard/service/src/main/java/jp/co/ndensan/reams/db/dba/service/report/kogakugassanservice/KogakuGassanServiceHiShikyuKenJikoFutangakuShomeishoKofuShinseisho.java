/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.kogakugassanservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のPrintServiceです。
 *
 * @reamsid_L DBA-0540-620 lishengli
 */
public class KogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseisho {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final RString 外国人 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法,
            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    private static RString 生年月日;

    /**
     * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書を印刷します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection createKogakuGassanServiceHiShikyuKenJikoFutangakuShomeishoKofuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        KogakuGassanKaigoServicehiShikyuKofuShinseishoProperty property = new KogakuGassanKaigoServicehiShikyuKofuShinseishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource> assembler
                    = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, null);
                for (KogakuGassanKaigoServicehiShikyuKofuShinseishoReport report : toReports(get被保険者基本情報取得(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<KogakuGassanKaigoServicehiShikyuKofuShinseishoReport> toReports(
            HihokenshaKihonBusiness business, RString ninshoshaYakushokuMei) {
        List<KogakuGassanKaigoServicehiShikyuKofuShinseishoReport> list = new ArrayList<>();
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            生年月日 = パターン12(business.get生年月日());
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = get生年月日_外国人(business);
        }
        KogakuGassanKaigoServicehiShikyuKofuShinseishoItem item = new KogakuGassanKaigoServicehiShikyuKofuShinseishoItem(
                生年月日,
                business.getフリガナ(),
                business.get被保険者氏名(),
                business.get保険者名称(),
                business.get保険者番号() == null ? RString.EMPTY : business.get保険者番号().value(),
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().value(),
                RString.EMPTY,
                ninshoshaYakushokuMei
        );
        list.add(KogakuGassanKaigoServicehiShikyuKofuShinseishoReport.createFrom(item));
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
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人)) {
            生年月日 = パターン37(business.get生年月日());
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人)) {
            if (生年月日不詳区分_FALG.equals(business.get生年月日不詳区分())) {
                生年月日 = パターン12(business.get生年月日());
            } else {
                生年月日 = RString.EMPTY;
            }
        }
        return 生年月日;
    }

    private static RString パターン12(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString パターン37(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
