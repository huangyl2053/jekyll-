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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 支払方法変更（償還払い化）終了申請書クラスです。
 */
public class ShiharaiHenkoShokanbaraikaShoryoShinseisho {

    private static final RString FALSE = new RString("false");

    /**
     * 支払方法変更（償還払い化）終了申請書帳票作成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void createShiharaiHohoHenkoShuryoShinseishoChohyo(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty proerty = new ShiharaiHenkoShokanbaraikaShoryoShinseishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, null);
                for (ShiharaiHenkoShokanbaraikaShoryoShinseishoReport report : toReports(get被保険者基本情報(被保険者番号, 識別コード),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<ShiharaiHenkoShokanbaraikaShoryoShinseishoReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    private static List<ShiharaiHenkoShokanbaraikaShoryoShinseishoReport> toReports(
            HihokenshaKihonBusiness business, RString ninshoshaYakushokuMei) {
        List<ShiharaiHenkoShokanbaraikaShoryoShinseishoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            set生年月日_日本人(business);
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = set生年月日(business);
        }
        //TODO 通知文の取得 QA:648
        //TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        //TsuchiBun = tsuchisho.get通知書定形文検索(SubGyomuCode.DBD介護受給, ReportId.EMPTY, KamokuCode.EMPTY, 1, FlexibleDate.MAX);
        ShiharaiHenkoShokanbaraikaShoryoShinseishoItem item = new ShiharaiHenkoShokanbaraikaShoryoShinseishoItem(
                ninshoshaYakushokuMei,
                business.getフリガナ(),
                business.get被保険者氏名(),
                business.get被保険者番号().value(),
                生年月日,
                // TODO QA：643 (「IKojin.get性別.getshortJapaneseを使って名称を取得する」不明)
                Gender.toValue(business.get性別()).getName().getShortJapanese(),
                business.get郵便番号(),
                business.get住所(),
                business.get電話番号(),
                new RString("通知文"));
        list.add(ShiharaiHenkoShokanbaraikaShoryoShinseishoReport.createReport(item));
        return list;
    }

    private static RString set生年月日_日本人(HihokenshaKihonBusiness business) {
        if (business.get生年月日() != null && business.get生年月日().isEmpty()) {
            return business.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private static RString set生年月日(HihokenshaKihonBusiness business) {
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法);
        RString 生年月日 = RString.EMPTY;
        if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = (business.get生年月日() == null || business.get生年月日().isEmpty()) ? RString.EMPTY : business.get生年月日()
                    .seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = set生年月日_和暦表示(business);
        }
        return 生年月日;
    }

    private static RString set生年月日_和暦表示(HihokenshaKihonBusiness business) {
        RString 生年月日 = RString.EMPTY;
        if (FALSE.equals(business.get生年月日不詳区分())) {
            生年月日 = (business.get生年月日() == null || business.get生年月日().isEmpty()) ? RString.EMPTY : business.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 生年月日;
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
