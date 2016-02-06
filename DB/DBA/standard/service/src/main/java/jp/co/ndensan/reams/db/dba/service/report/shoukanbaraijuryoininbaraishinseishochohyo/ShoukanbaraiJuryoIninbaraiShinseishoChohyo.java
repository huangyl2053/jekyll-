/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shoukanbaraijuryoininbaraishinseishochohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.shoukanbaraijuryoininbaraishinseishochohyo.ShokanharaiJuryoIninShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
 * 介護保険償還払受領委任払申請書のPrintクラスです。
 */
public class ShoukanbaraiJuryoIninbaraiShinseishoChohyo {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final RString ハイフン = new RString("-");
    private static final int ハイフンINDEX = 3;

    /**
     * 介護保険償還払受領委任払申請書を印刷します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection getShoukanbaraiJuryoIninbaraiShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ShokanharaiJuryoIninShinseishoProerty property = new ShokanharaiJuryoIninShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShokanharaiJuryoIninShinseishoReportSource> assembler
                    = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder builder = builderCreator.create(
                        GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null,
                        null);
                for (ShokanharaiJuryoIninShinseishoReport report
                        : toReports(get被保険者基本情報(識別コード, 被保険者番号), builder.buildSource())) {
                    ReportSourceWriter<ShokanharaiJuryoIninShinseishoReportSource> reportWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShokanharaiJuryoIninShinseishoReport> toReports(
            HihokenshaKihonBusiness business, NinshoshaSource ninshoshaSource) {
        List<ShokanharaiJuryoIninShinseishoReport> list = new ArrayList<>();
        RString birthYMD = RString.EMPTY;
        RString 住民種別コード = business.get住民種別コード();
        FlexibleDate 生年月日 = business.get生年月日();
        if (生年月日 != null && 生年月日.isEmpty()) {
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
            郵便番号 = set郵便番号(郵便番号);
        } else {
            郵便番号 = RString.EMPTY;
        }
        ShokanharaiJuryoIninShinseishoItem item = new ShokanharaiJuryoIninShinseishoItem(
                ninshoshaSource.ninshoshaYakushokuMei,
                birthYMD,
                // TODO 内部QA：689 (介護保険保険者名称を設定する必要がありません。)
                // TODO 内部QA：648 (文言の取得不明です)
                new RString("注意文"),
                business.get住所(),
                business.get被保険者氏名(),
                business.getフリガナ(),
                business.get被保険者番号().isEmpty() ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                business.get保険者番号().value(),
                new RString(String.valueOf(1)),
                // TODO 内部QA：643 (性別の設定不明です)
                business.get性別(),
                // TODO 内部QA：648 (文言の取得不明です)
                new RString("申請文"),
                business.get電話番号(),
                郵便番号);
        list.add(ShokanharaiJuryoIninShinseishoReport.createFrom(item));
        return list;
    }

    private static RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private static RString set生年月日(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法);
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
        if (ハイフンINDEX <= 郵便番号.length()) {
            郵便番号 = 郵便番号.insert(ハイフンINDEX, ハイフン.toString());
        }
        return 郵便番号;
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
