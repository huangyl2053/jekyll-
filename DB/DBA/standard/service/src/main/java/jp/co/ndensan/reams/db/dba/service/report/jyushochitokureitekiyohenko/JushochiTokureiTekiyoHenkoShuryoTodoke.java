/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.service.report.jyushochitokureitekiyohenko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoItem;
import jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoProerty;
import jp.co.ndensan.reams.db.dba.business.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoReport;
import jp.co.ndensan.reams.db.dba.entity.report.jyushochitokureitekiyohenko.JyushochiTokureiTekiyoHenkoReportSource;
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
 * 介護保険住所地特例適用・変更・終了届のPrintクラスです。
 */
public class JushochiTokureiTekiyoHenkoShuryoTodoke {
    
    private static final RString 生年月日不詳区分 = new RString("0");
    
    /**
     * 介護保険住所地特例適用・変更・終了届をPrintします。
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険住所地特例適用・変更・終了届作成_帳票
     */
    public SourceDataCollection createJushochiTokureiTekiyoHenkoShuryoTodokeChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        JyushochiTokureiTekiyoHenkoProerty proerty = new JyushochiTokureiTekiyoHenkoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JyushochiTokureiTekiyoHenkoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, null);
                for (JyushochiTokureiTekiyoHenkoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<JyushochiTokureiTekiyoHenkoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                        report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }
    
    private static List<JyushochiTokureiTekiyoHenkoReport> toReports(HihokenshaKihonBusiness entity, RString ninshoshaYakushokuMei) {
        List<JyushochiTokureiTekiyoHenkoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(entity.get住民種別コード())) {
            set生年月日_日本人(entity);
        } else if (JuminShubetsu.外国人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(entity.get住民種別コード())) {
            生年月日 = set生年月日(entity);
        }
        JyushochiTokureiTekiyoHenkoItem item = new JyushochiTokureiTekiyoHenkoItem(
                ninshoshaYakushokuMei,
                entity.get被保険者番号() == null ? RString.EMPTY : entity.get被保険者番号().getColumnValue(),
                entity.getフリガナ(),
                entity.get被保険者氏名(),
                生年月日,
                Gender.toValue(entity.get性別()).getCommonName());
        list.add(JyushochiTokureiTekiyoHenkoReport.createReport(item));
        return list;
    }
    
    private static RString set生年月日_日本人(HihokenshaKihonBusiness entity) {
        FlexibleDate entity生年月日 = entity.get生年月日();
        if (entity生年月日 != null && !entity生年月日.isEmpty()) {
            return entity生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
    
    private static RString set生年月日(HihokenshaKihonBusiness entity) {
        FlexibleDate entity生年月日 = entity.get生年月日();
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法);
        RString 生年月日 = RString.EMPTY;
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = (entity生年月日 == null || entity生年月日.isEmpty()) ? RString.EMPTY : entity生年月日
                    .seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = set生年月日_和暦表示(entity);
        }
        return 生年月日;
    }
    
    private static RString set生年月日_和暦表示(HihokenshaKihonBusiness entity) {
        FlexibleDate entity生年月日 = entity.get生年月日();
        RString 生年月日 = RString.EMPTY;
        if (生年月日不詳区分.equals(entity.get生年月日不詳区分())) {
            生年月日 = (entity生年月日 == null || entity生年月日.isEmpty()) ? RString.EMPTY : entity生年月日
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
        HihokenshaKihonBusiness list = shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
        return list;
    }
    
    
}
