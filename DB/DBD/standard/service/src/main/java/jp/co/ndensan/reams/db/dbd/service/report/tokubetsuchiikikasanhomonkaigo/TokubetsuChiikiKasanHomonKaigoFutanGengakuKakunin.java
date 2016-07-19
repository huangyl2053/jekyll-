/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.tokubetsuchiikikasanhomonkaigo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800007.TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Printerです。
 *
 * @reamsid_L DBA-0540-400 suguangjun
 */
public class TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final int INDEX_3 = 3;
    private static final RString ハイフン = new RString("-");
    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dac;

    /**
     * コンストラクタです。
     */
    TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin() {
        this.dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac
     */
    TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin}のインスタンス
     */
    public static TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin createInstance() {
        return InstanceProvider.create(TokubetsuChiikiKasanHomonKaigoFutanGengakuKakunin.class);
    }

    /**
     * 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 特別地域加算減免・訪問介護等利用者負担減額対象確認申請書_帳票
     */
    public SourceDataCollection createTokubetsuChiikiKasanHomonKaigoFutanGengakuKakuninChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokubetsuChiikiKasanGenmenTaishoShinseishoProerty proerty = new TokubetsuChiikiKasanGenmenTaishoShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<TokubetsuChiikiKasanGenmenTaishoShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, reportSourceWriter.getImageFolderPath());
                for (TokubetsuChiikiKasanGenmenTaishoShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {

                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<TokubetsuChiikiKasanGenmenTaishoShinseishoReport> toReports(HihokenshaKihonBusiness business,
            RString ninshoshaYakushokuMei) {
        List<TokubetsuChiikiKasanGenmenTaishoShinseishoReport> list = new ArrayList<>();
        RString 確認番号 = get確認番号(business);
        RString 通知文1 = get帳票文言();
        RString birthYMD = RString.EMPTY;
        RString 住民種別コード = business.get住民種別コード();
        FlexibleDate 生年月日 = business.get生年月日();
        if (生年月日 != null && !生年月日.isEmpty()) {
            if (JuminShubetsu.日本人.getCode().equals(住民種別コード)
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
                birthYMD = set生年月日_日本人(生年月日);
            } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード)
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
                birthYMD = set生年月日(生年月日, business.get生年月日不詳区分());
            }
        }
        RString 郵便番号 = business.get郵便番号();
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            郵便番号 = set郵便番号(business.get郵便番号());
        } else {
            郵便番号 = RString.EMPTY;
        }
        TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem item = new TokubetsuChiikiKasanGenmenTaishoShinseishoBodyItem(ninshoshaYakushokuMei,
                business.getフリガナ(),
                business.get被保険者氏名(),
                確認番号,
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                birthYMD,
                Gender.toValue(business.get性別()).getCommonName(),
                郵便番号,
                business.get住所(),
                business.get電話番号(),
                通知文1);
        list.add(TokubetsuChiikiKasanGenmenTaishoShinseishoReport.createReport(item));
        return list;
    }

    private RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set生年月日(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            return 生年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            return set生年月日_和暦表示(生年月日, 生年月日不詳区分);
        }
        return RString.EMPTY;
    }

    private RString set生年月日_和暦表示(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        if (生年月日不詳区分_FALG.equals(生年月日不詳区分)) {
            return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString set郵便番号(RString 郵便番号) {
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

    private RString get帳票文言() {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBD介護受給,
                new ReportId("DBD800007_TokubetsuChiikiKasanGenmenTaishoShinseisho"),
                KamokuCode.EMPTY,
                1,
                1,
                new FlexibleDate(RDate.getNowDate().toString()));
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            return tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
        }
        return RString.EMPTY;
    }

    private RString get確認番号(HihokenshaKihonBusiness business) {
        RString 確認番号 = RString.EMPTY;
        if (business != null) {
            List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> entityList = dac.get確認番号(business.get保険者番号(), business.get被保険者番号());
            if (!entityList.isEmpty()) {
                確認番号 = entityList.get(0).getKakuninNo();
            }
        }
        return 確認番号;
    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
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
