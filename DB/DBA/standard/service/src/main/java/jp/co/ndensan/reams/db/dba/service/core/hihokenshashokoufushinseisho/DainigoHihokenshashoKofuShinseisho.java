/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshashokoufushinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashokoufushinseisho.HihokenshashokoufuShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
 * 介護保険被保険者証交付申請書（第2号被保険者）Printerです。
 *
 * @reamsid_L DBA-0540-140 houtianpeng
 */
public class DainigoHihokenshashoKofuShinseisho {

    private static final RString 生年月日不詳区分 = new RString("0");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;

    /**
     * 介護保険被保険者証交付申請書（第2号被保険者）をPrintします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険被保険者証交付申請書（第2号被保険者）_帳票
     */
    public SourceDataCollection createDainigoHihokenshashoKofuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        HihokenshashokoufuShinseishoProperty proerty = new HihokenshashokoufuShinseishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<HihokenshashokoufuShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<HihokenshashokoufuShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                Ninshosha nishosha = NinshoshaFinderFactory.createInstance().get帳票認証者(
                        GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        nishosha, association, reportSourceWriter.getImageFolderPath(), RDate.getNowDate());
                for (HihokenshashokoufuShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<HihokenshashokoufuShinseishoReport> toReports(HihokenshaKihonBusiness entity, RString ninshoshaYakushokuMei) {
        List<HihokenshashokoufuShinseishoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(entity.get住民種別コード())) {
            生年月日 = set生年月日_日本人(entity);
        } else if (JuminShubetsu.外国人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(entity.get住民種別コード())) {
            生年月日 = set生年月日(entity);
        }
        HihokenshashokoufuShinseishoItem item = new HihokenshashokoufuShinseishoItem(
                ninshoshaYakushokuMei,
                entity.getフリガナ(),
                entity.get被保険者氏名().isEmpty() ? RString.EMPTY : entity.get被保険者氏名(),
                Gender.toValue(entity.get性別()).getCommonName(),
                生年月日,
                set郵便番号(entity.get郵便番号()),
                entity.get住所().isEmpty() ? RString.EMPTY : entity.get住所(),
                entity.get電話番号()
        );
        list.add(HihokenshashokoufuShinseishoReport.createFrom(item));
        return list;
    }

    private static RString set生年月日_日本人(HihokenshaKihonBusiness entity) {
        FlexibleDate 生年月日 = entity.get生年月日();
        if (生年月日 != null && !生年月日.isEmpty()) {
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

    private static RString set生年月日(HihokenshaKihonBusiness entity) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告
                );
        RString 生年月日 = RString.EMPTY;
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = (entity.get生年月日() == null || entity.get生年月日().isEmpty()) ? RString.EMPTY : entity.get生年月日()
                    .seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = set生年月日_和暦表示(entity);
        }
        return 生年月日;
    }

    private static RString set生年月日_和暦表示(HihokenshaKihonBusiness entity) {
        RString 生年月日 = RString.EMPTY;
        if (生年月日不詳区分.equals(entity.get生年月日不詳区分())) {
            生年月日 = (entity.get生年月日() == null || entity.get生年月日().isEmpty()) ? RString.EMPTY : entity.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 生年月日;
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
