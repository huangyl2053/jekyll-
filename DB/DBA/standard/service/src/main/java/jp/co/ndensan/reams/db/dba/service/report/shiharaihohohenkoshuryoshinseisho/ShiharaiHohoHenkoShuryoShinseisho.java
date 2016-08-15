/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.shiharaihohohenkoshuryoshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.shiharaihohohenkoshuryoshinseisho.ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource;
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
 *
 * 支払方法変更（償還払い化）終了申請書クラスです。
 *
 * @reamsid_L DBA-0540-340 zhangguopeng
 */
public class ShiharaiHohoHenkoShuryoShinseisho {

    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final RString 生年月日不詳区分_FALG = new RString("0");

    /**
     * 支払方法変更（償還払い化）終了申請書帳票作成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @return SourceDataCollection
     */
    public SourceDataCollection createShiharaiHohoHenkoShuryoShinseishoChohyo(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty proerty = new ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                Ninshosha nishosha = NinshoshaFinderFactory.createInstance().get帳票認証者(
                        GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        nishosha, association, reportSourceWriter.getImageFolderPath(), RDate.getNowDate());
                for (ShiharaiHenkoShokanbaraikaShoryoShinseishoReport report : toReports(get被保険者基本情報(被保険者番号, 識別コード),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShiharaiHenkoShokanbaraikaShoryoShinseishoReport> toReports(
            HihokenshaKihonBusiness business, RString ninshoshaYakushokuMei) {
        List<ShiharaiHenkoShokanbaraikaShoryoShinseishoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        FlexibleDate get生年月日 = business.get生年月日();
        if (get生年月日 != null && !get生年月日.isEmpty()) {
            if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
                生年月日 = set生年月日_日本人(get生年月日);
            } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
                生年月日 = set生年月日(get生年月日, business.get生年月日不詳区分());
            }
        }
        RString 郵便番号 = business.get郵便番号();
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            郵便番号 = set郵便番号(business.get郵便番号());
        } else {
            郵便番号 = RString.EMPTY;
        }
        ShiharaiHenkoShokanbaraikaShoryoShinseishoItem item = new ShiharaiHenkoShokanbaraikaShoryoShinseishoItem(
                ninshoshaYakushokuMei,
                business.getフリガナ(),
                business.get被保険者氏名(),
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                生年月日,
                Gender.toValue(business.get性別()).getCommonName(),
                郵便番号,
                business.get住所(),
                business.get電話番号(),
                get帳票文言());
        list.add(ShiharaiHenkoShokanbaraikaShoryoShinseishoReport.createReport(item));
        return list;
    }

    private static RString get帳票文言() {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBD介護受給,
                new ReportId("DBD800009_ShiharaiHenkoShokanbaraikaShoryoShinseisho"),
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
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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

    private HihokenshaKihonBusiness get被保険者基本情報(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
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
