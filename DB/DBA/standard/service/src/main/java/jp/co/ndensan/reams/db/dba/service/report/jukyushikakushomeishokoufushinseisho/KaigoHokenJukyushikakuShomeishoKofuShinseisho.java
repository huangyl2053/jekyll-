/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.jukyushikakushomeishokoufushinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.jukyushikakushomeishokoufushinseisho.JukyuShikakuShomeishokoufuShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
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
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護保険受給資格証明書交付申請書Printクラスです。
 *
 * @reamsid_L DBA-0540-040 dongyabin
 */
public class KaigoHokenJukyushikakuShomeishoKofuShinseisho {

    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final RString 生年月日不詳区分_FALG = new RString("0");

    /**
     * 介護保険資格取得・異動・喪失届Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険資格取得・異動・喪失届作成_帳票
     */
    public SourceDataCollection createKaigoHokenJukyushikakuShomeishoKofuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        JukyuShikakuShomeishokoufuShinseishoProerty proerty = new JukyuShikakuShomeishokoufuShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShikakushutokuIdoSoshitsuReportSource> assembler = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<JukyuShikakuShomeishokoufuShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, reportSourceWriter.getImageFolderPath());
                List<UaFt200FindShikibetsuTaishoEntity> psmJoho = getPsmJoho(識別コード);
                for (JukyuShikakuShomeishokoufuShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei, psmJoho)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<JukyuShikakuShomeishokoufuShinseishoReport> toReports(HihokenshaKihonBusiness entity,
            RString ninshoshaYakushokuMei,
            List<UaFt200FindShikibetsuTaishoEntity> psmJoho) {
        List<JukyuShikakuShomeishokoufuShinseishoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        RString 住民種別コード = entity.get住民種別コード();
        if (JuminShubetsu.日本人.getCode().equals(住民種別コード)
                || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
            生年月日 = set生年月日_日本人(entity);
        } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード)
                || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
            生年月日 = set生年月日(entity);
        }
        RString 異動前郵便番号 = psmJoho.isEmpty() ? RString.EMPTY : ShikibetsuTaishoFactory.createKojin(psmJoho.get(0)).to個人()
                .get最終住登地().get郵便番号().getColumnValue();
        JukyuShikakuShomeishokoufuShinseishoItem item = new JukyuShikakuShomeishokoufuShinseishoItem(ninshoshaYakushokuMei,
                entity.get被保険者番号() == null ? RString.EMPTY : entity.get被保険者番号().getColumnValue(),
                entity.getフリガナ(),
                entity.get被保険者氏名(),
                生年月日,
                Gender.toValue(entity.get性別()).getCommonName(),
                set郵便番号(entity.get郵便番号()),
                entity.get電話番号(),
                entity.get住所(),
                set郵便番号(異動前郵便番号),
                entity.get電話番号(),
                get異動前住所(psmJoho),
                get異動後住所と異動後郵便番号(psmJoho).get(0),
                RString.EMPTY,
                set郵便番号(get異動後住所と異動後郵便番号(psmJoho).get(1)));
        list.add(JukyuShikakuShomeishokoufuShinseishoReport.createReport(item));
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

    private static RString set生年月日(HihokenshaKihonBusiness entity) {
        FlexibleDate entity生年月日 = entity.get生年月日();
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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
        if (生年月日不詳区分_FALG.equals(entity.get生年月日不詳区分())) {
            生年月日 = (entity生年月日 == null || entity生年月日.isEmpty()) ? RString.EMPTY : entity生年月日
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 生年月日;
    }

    private static RString set郵便番号(RString 郵便番号) {
        if (郵便番号 == null || 郵便番号.isEmpty()) {
            return RString.EMPTY;
        }
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

    private static List<UaFt200FindShikibetsuTaishoEntity> getPsmJoho(ShikibetsuCode 識別コード) {
        UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(
                UaFt200FindShikibetsuTaishoFunctionDac.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(SubGyomuCode.DBA介護資格.getGyomuCode(),
                        KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        return dac.select(psm);
    }

    private static RString get異動前住所(List<UaFt200FindShikibetsuTaishoEntity> psmJoho) {
        if (psmJoho.isEmpty()) {
            return RString.EMPTY;
        }
        IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(psmJoho.get(0));
        RStringBuilder 異動前住所 = new RStringBuilder();
        異動前住所.append(shikibetsuTaisho.to個人().get最終住登地().get住所());
        異動前住所.append(shikibetsuTaisho.to個人().get最終住登地().get番地().getBanchi().getColumnValue());
        異動前住所.append(RString.FULL_SPACE);
        異動前住所.append(shikibetsuTaisho.to個人().get最終住登地().get方書().getColumnValue());
        return 異動前住所.toRString();
    }

    private static List<RString> get異動後住所と異動後郵便番号(List<UaFt200FindShikibetsuTaishoEntity> psmJoho) {
        List<RString> 住所と郵便番号 = new ArrayList<>();
        if (psmJoho.isEmpty()) {
            住所と郵便番号.add(RString.EMPTY);
            住所と郵便番号.add(RString.EMPTY);
            return 住所と郵便番号;
        }
        IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(psmJoho.get(0));
        if (!shikibetsuTaisho.to個人().get転出確定().get住所().isEmpty()) {
            RStringBuilder 異動後住所 = new RStringBuilder();
            異動後住所.append(shikibetsuTaisho.to個人().get転出確定().get住所());
            異動後住所.append(shikibetsuTaisho.to個人().get転出確定().get番地().getBanchi().getColumnValue());
            異動後住所.append(RString.FULL_SPACE);
            異動後住所.append(shikibetsuTaisho.to個人().get転出確定().get方書().getColumnValue());
            住所と郵便番号.add(異動後住所.toRString());
            住所と郵便番号.add(shikibetsuTaisho.to個人().get転出確定().get郵便番号().getColumnValue());
        } else if (!shikibetsuTaisho.to個人().get転出予定().get住所().isEmpty()) {
            RStringBuilder 異動後住所 = new RStringBuilder();
            異動後住所.append(shikibetsuTaisho.to個人().get転出予定().get住所());
            異動後住所.append(shikibetsuTaisho.to個人().get転出予定().get番地().getBanchi().getColumnValue());
            異動後住所.append(RString.FULL_SPACE);
            異動後住所.append(shikibetsuTaisho.to個人().get転出予定().get方書().getColumnValue());
            住所と郵便番号.add(異動後住所.toRString());
            住所と郵便番号.add(shikibetsuTaisho.to個人().get転出予定().get郵便番号().getColumnValue());
        } else {
            住所と郵便番号.add(RString.EMPTY);
            住所と郵便番号.add(RString.EMPTY);
        }

        return 住所と郵便番号;
    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }

}
