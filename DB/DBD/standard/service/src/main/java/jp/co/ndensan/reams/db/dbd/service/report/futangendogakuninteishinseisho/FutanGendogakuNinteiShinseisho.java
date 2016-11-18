/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.futangendogakuninteishinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoBodyItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800001.FutangendogakuNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseishoParamter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseisho.FutanGendogakuNinteiShinseishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800001.FutangendogakuNinteiShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogakuninteishinseisho.IFutanGendogakuNinteiShinseishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
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
 * 介護保険負担限度額認定申請書Printerです。
 *
 * @reamsid_L DBA-0540-200 suguangjun
 */
public class FutanGendogakuNinteiShinseisho {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final int INDEX_3 = 3;
    private static final RString ハイフン = new RString("-");

    /**
     * {@link InstanceProvider#create}にて生成した{@link FutanGendogakuNinteiShinseisho}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link FutanGendogakuNinteiShinseisho}のインスタンス
     */
    public static FutanGendogakuNinteiShinseisho createInstance() {
        return InstanceProvider.create(FutanGendogakuNinteiShinseisho.class);
    }

    /**
     * 介護保険負担限度額認定申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険負担限度額認定申請書作成_帳票
     */
    public SourceDataCollection createFutanGendogakuNinteiShinseishoChohyo(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            createFutanGendogakuNinteiShinseishoChohyo(識別コード, 被保険者番号, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 介護保険負担限度額認定申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param reportManager 帳票発行処理の制御機能
     */
    public void createFutanGendogakuNinteiShinseishoChohyo(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, ReportManager reportManager) {
        FutangendogakuNinteiShinseishoProerty proerty = new FutangendogakuNinteiShinseishoProerty();
        try (ReportAssembler<FutangendogakuNinteiShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
            ReportSourceWriter<FutangendogakuNinteiShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            for (FutangendogakuNinteiShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号), 識別コード)) {
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private List<FutangendogakuNinteiShinseishoReport> toReports(HihokenshaKihonBusiness business, ShikibetsuCode 識別コード) {
        RString 認証者 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        List<FutangendogakuNinteiShinseishoReport> list = new ArrayList<>();
        RString 申請文 = get帳票文言(1);
        RString 注意文 = get帳票文言(2);
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
        RString 施設郵便番号 = RString.EMPTY;
        RString 施設電話番号 = RString.EMPTY;
        RString 施設住所 = RString.EMPTY;
        RString 施設名称 = RString.EMPTY;
        FutanGendogakuNinteiShinseishoEntity 施設情報 = get施設情報(識別コード);
        if (施設情報 != null) {
            施設郵便番号 = 施設情報.get事業者郵便番号();
            施設電話番号 = 施設情報.get事業者電話番号();
            施設住所 = 施設情報.get事業者住所();
            施設名称 = 施設情報.get事業者名称();
        }
        FutangendogakuNinteiShinseishoBodyItem item = new FutangendogakuNinteiShinseishoBodyItem(
                申請文,
                business.getフリガナ(),
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                business.get被保険者氏名(),
                Gender.toValue(business.get性別()).getCommonName(),
                birthYMD,
                business.get電話番号(),
                郵便番号,
                business.get住所(),
                注意文,
                認証者,
                施設郵便番号,
                施設電話番号,
                施設住所,
                施設名称);
        list.add(FutangendogakuNinteiShinseishoReport.createReport(item));
        return list;
    }

    private RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set生年月日(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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

    private RString get帳票文言(int 項目番号) {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBD介護受給,
                new ReportId("DBD800001_FutangendogakuNinteiShinseisho"),
                KamokuCode.EMPTY,
                1,
                項目番号,
                FlexibleDate.getNowDate());
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            return tsuchishoTeikeibunInfo.get文章();
        }
        return RString.EMPTY;
    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }

    private FutanGendogakuNinteiShinseishoEntity get施設情報(ShikibetsuCode 識別コード) {
        MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
        IFutanGendogakuNinteiShinseishoMapper mapper = mapperProvider.create(IFutanGendogakuNinteiShinseishoMapper.class);
        FutanGendogakuNinteiShinseishoEntity 施設入退所情報 = mapper.get施設入退所(FutanGendogakuNinteiShinseishoParamter
                .createParamter(識別コード, RString.EMPTY));
        if (施設入退所情報 != null) {
            FutanGendogakuNinteiShinseishoParamter param = FutanGendogakuNinteiShinseishoParamter.
                    createParamter(識別コード, 施設入退所情報.get入所施設コード());
            if (ShisetsuType.介護保険施設.getコード().equals(施設入退所情報.get入所施設種類())) {
                FutanGendogakuNinteiShinseishoEntity 介護事業者 = mapper.get介護事業者(param);
                return 介護事業者;
            } else if (ShisetsuType.住所地特例対象施設.getコード().equals(施設入退所情報.get入所施設種類())) {
                FutanGendogakuNinteiShinseishoEntity 介護除外住所地特例対象施設 = mapper.get介護除外住所地特例対象施設(param);
                return 介護除外住所地特例対象施設;
            }
        }
        return null;
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
