/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.yokaigoninteikubunhenkoshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReport;
import jp.co.ndensan.reams.db.dba.definition.core.yokaigoninteikubunhenkoshinseisho.YokaigoNinteikubunHenkoShinseishoParameter;
import jp.co.ndensan.reams.db.dba.entity.report.yokaigoninteikbnhenkoshinseisho.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.yokaigoninteikubunhenkoshinseisho.IYokaigoNinteikubunHenkoShinseishoMapper;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
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
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定区分変更申請書のPrintServiceです。
 *
 * @reamsid_L DBA-0540-640 lishengli
 */
public class YokaigoNinteikubunHenkoShinseisho {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final Code 認定支援申請以外 = new Code("0");
    private static final Code 認定支援申請 = new Code("1");
    private static final RString ハイフン = new RString("-");
    private static final RString 外国人 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法,
            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    private static final int INDEX_3 = 3;
    private static RString 生年月日;
    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac dac;

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     * @param dac {@link DbT4001JukyushaDaichoDac}
     */
    YokaigoNinteikubunHenkoShinseisho(
            MapperProvider mapperProvider,
            DbT4001JukyushaDaichoDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * コンストラクタです。
     */
    public YokaigoNinteikubunHenkoShinseisho() {
        this.dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 要介護認定区分変更申請書を印刷します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void createYokaigoNinteikubunHenkoShinseishoChohyo(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        IYokaigoNinteikubunHenkoShinseishoMapper mapper = mapperProvider.create(IYokaigoNinteikubunHenkoShinseishoMapper.class);
        YokaigoNinteikbnHenkoShinseishoProperty property = new YokaigoNinteikbnHenkoShinseishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<YokaigoNinteikbnHenkoShinseishoReportSource> assembler
                    = createAssembler(property, reportManager)) {
                Ninshosha nishosha = NinshoshaFinderFactory.createInstance().get帳票認証者(
                        GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        nishosha, association, RString.EMPTY, RDate.getNowDate());
                for (YokaigoNinteikbnHenkoShinseishoReport report : toReports(dac, mapper,
                        get被保険者基本情報取得(識別コード, 被保険者番号),
                        識別コード,
                        被保険者番号,
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
        }
    }

    private static List<YokaigoNinteikbnHenkoShinseishoReport> toReports(
            DbT4001JukyushaDaichoDac dac,
            IYokaigoNinteikubunHenkoShinseishoMapper mapper,
            HihokenshaKihonBusiness business,
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            RString ninshoshaYakushokuMei) {
        List<YokaigoNinteikbnHenkoShinseishoReport> list = new ArrayList<>();
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            生年月日 = パターン12(business.get生年月日());
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = get生年月日_外国人(business);
        }

        UaFt200FindShikibetsuTaishoEntity uaft200Entity = getPsm(mapper, 識別コード);
        DbT4001JukyushaDaichoEntity entity = new DbT4001JukyushaDaichoEntity();
        if (uaft200Entity != null) {
            entity = dac.select受給者台帳情報(uaft200Entity.getGenLasdecCode(), 被保険者番号);
        }
        RString 要介護状態区分 = RString.EMPTY;
        RString 要支援状態区分 = RString.EMPTY;
        RString 認定有効期間開始 = RString.EMPTY;
        RString 認定有効期間終了 = RString.EMPTY;
        if (entity != null) {
            Code 要介護認定状態区分コード = entity.getYokaigoJotaiKubunCode();
            if (要介護認定状態区分コード != null && 認定支援申請以外.equals(entity.getShinseishoKubun())) {
                要介護状態区分 = YokaigoJotaiKubun09.toValue(codetoRstring(要介護認定状態区分コード)).get名称();
            }
            if (要介護認定状態区分コード != null && 認定支援申請.equals(entity.getShinseishoKubun())) {
                要支援状態区分 = YokaigoJotaiKubun09.toValue(codetoRstring(要介護認定状態区分コード)).get名称();
            }
            if (entity.getNinteiYukoKikanKaishiYMD() != null) {
                認定有効期間開始 = パターン12(entity.getNinteiYukoKikanKaishiYMD());
            }
            if (entity.getNinteiYukoKikanShuryoYMD() != null) {
                認定有効期間終了 = パターン12(entity.getNinteiYukoKikanShuryoYMD());
            }
        }

        RString 郵便番号 = business.get郵便番号();
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            郵便番号 = set郵便番号(business.get郵便番号());
        } else {
            郵便番号 = RString.EMPTY;
        }

        RString 通知文 = get帳票文言();
        YokaigoNinteikbnHenkoShinseishoItem item = new YokaigoNinteikbnHenkoShinseishoItem(
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                business.getフリガナ(),
                生年月日,
                business.get被保険者氏名(),
                Gender.toValue(business.get性別()).getCommonName(),
                郵便番号,
                business.get電話番号(),
                business.get住所(),
                要介護状態区分,
                要支援状態区分,
                認定有効期間開始,
                認定有効期間終了,
                通知文,
                RString.EMPTY,
                ninshoshaYakushokuMei
        );
        list.add(YokaigoNinteikbnHenkoShinseishoReport.createFrom(item));
        return list;
    }

    private static RString get帳票文言() {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBD介護受給,
                new ReportId("DBD501002_yokaigoNinteikbnHenkoShinseisho"),
                KamokuCode.EMPTY,
                1,
                1,
                new FlexibleDate(RDate.getNowDate().toDateString()));
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            return tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
        }
        return RString.EMPTY;
    }

    private static RString codetoRstring(Code code) {
        return code.value();
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

    private static UaFt200FindShikibetsuTaishoEntity getPsm(
            IYokaigoNinteikubunHenkoShinseishoMapper mapper,
            ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        YokaigoNinteikubunHenkoShinseishoParameter psmParameter = YokaigoNinteikubunHenkoShinseishoParameter.createParam(
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        UaFt200FindShikibetsuTaishoEntity uaft200Entity = mapper.getPsm(psmParameter);
        if (uaft200Entity == null) {
            uaft200Entity = new UaFt200FindShikibetsuTaishoEntity();
        }
        return uaft200Entity;
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

    private static HihokenshaKihonBusiness get被保険者基本情報取得(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
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
