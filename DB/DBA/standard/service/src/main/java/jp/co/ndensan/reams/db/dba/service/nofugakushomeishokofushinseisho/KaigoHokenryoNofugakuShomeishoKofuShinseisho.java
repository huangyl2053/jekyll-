/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.nofugakushomeishokofushinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.nofugakushomeishokofushinseisho.NofugakuShomeishoKofuShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
 * 介護保険料納付額証明書交付申請書クラスです。
 *
 * @reamsid_L DBA-0540-280 yaodongsheng
 */
public class KaigoHokenryoNofugakuShomeishoKofuShinseisho {

    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final RString 生年月日不詳区分_FALG = new RString("0");

    /**
     * 介護保険料納付額証明書交付申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険料納付額証明書交付申請書_帳票作成
     */
    public SourceDataCollection createKaigoHokenryoNofugakuShomeishoKofuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        NofugakuShomeishoKofuShinseishoProerty proerty = new NofugakuShomeishoKofuShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<NofugakuShomeishoKofuShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, null);
                for (NofugakuShomeishoKofuShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<NofugakuShomeishoKofuShinseishoReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<NofugakuShomeishoKofuShinseishoReport> toReports(
            HihokenshaKihonBusiness entity, RString ninshoshaYakushokuMei) {
        List<NofugakuShomeishoKofuShinseishoReport> list = new ArrayList<>();
        RString birthYMD = RString.EMPTY;
        RString 住民種別コード = entity.get住民種別コード();
        FlexibleDate 生年月日 = entity.get生年月日();
        if (生年月日 != null && !生年月日.isEmpty()) {
            if (JuminShubetsu.日本人.getCode().equals(住民種別コード)
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
                birthYMD = set生年月日_日本人(生年月日);
            } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード)
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
                birthYMD = set生年月日(生年月日, entity.get生年月日不詳区分());
            }
        }
        RString 郵便番号 = entity.get郵便番号();
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            郵便番号 = set郵便番号(entity.get郵便番号());
        } else {
            郵便番号 = RString.EMPTY;
        }
        NofugakuShomeishoKofuShinseishoItem item
                = new NofugakuShomeishoKofuShinseishoItem(
                        get帳票文言(),
                        entity.get被保険者番号() == null ? RString.EMPTY : entity.get被保険者番号().getColumnValue(),
                        entity.getフリガナ(),
                        entity.get被保険者氏名(),
                        birthYMD,
                        Gender.toValue(entity.get性別()).getCommonName(),
                        郵便番号,
                        entity.get電話番号(),
                        entity.get住所(),
                        null,
                        ninshoshaYakushokuMei);
        list.add(NofugakuShomeishoKofuShinseishoReport.createReport(item));
        return list;
    }

    private static RString get帳票文言() {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBC介護給付,
                new ReportId("DBB800003_NofugakuShomeishoKofuShinseisho"),
                KamokuCode.EMPTY,
                1,
                1,
                new FlexibleDate(RDate.getNowDate().toDateString()));
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            return tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
        }
        return RString.EMPTY;
    }

    private static RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private static RString set生年月日(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, SubGyomuCode.DBU介護統計報告);
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            return 生年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            return set生年月日_和暦表示(生年月日, 生年月日不詳区分);
        }
        return RString.EMPTY;
    }

    private static RString set生年月日_和暦表示(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        if (生年月日不詳区分_FALG.equals(生年月日不詳区分)) {
            return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private static RString set郵便番号(RString 郵便番号) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (INDEX_3 <= 郵便番号.length()) {
            yubinNoSb.append(郵便番号.substring(0, INDEX_3));
            yubinNoSb.append(ハイフン);
            yubinNoSb.append(郵便番号.substring(INDEX_3));
        } else {
            yubinNoSb.append(郵便番号);
        }
        return yubinNoSb.toRString();
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

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }
}
