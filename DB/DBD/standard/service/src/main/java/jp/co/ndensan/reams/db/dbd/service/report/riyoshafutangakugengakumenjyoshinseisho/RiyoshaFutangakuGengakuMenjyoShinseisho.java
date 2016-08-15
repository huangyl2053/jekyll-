/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.riyoshafutangakugengakumenjyoshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd800002.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 介護保険利用者負担額減額・免除申請書Printerです。
 *
 * @reamsid_L DBA-0540-220 suguangjun
 */
public class RiyoshaFutangakuGengakuMenjyoShinseisho {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final int INDEX_3 = 3;
    private static final RString ハイフン = new RString("-");
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;

    /**
     * コンストラクタです。
     */
    RiyoshaFutangakuGengakuMenjyoShinseisho() {
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 受給者台帳Dac 受給者台帳Dac
     */
    RiyoshaFutangakuGengakuMenjyoShinseisho(DbT4001JukyushaDaichoDac 受給者台帳Dac) {
        this.受給者台帳Dac = 受給者台帳Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutangakuGengakuMenjyoShinseisho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RiyoshaFutangakuGengakuMenjyoShinseisho}のインスタンス
     */
    public static RiyoshaFutangakuGengakuMenjyoShinseisho createInstance() {
        return InstanceProvider.create(RiyoshaFutangakuGengakuMenjyoShinseisho.class);
    }

    /**
     * 介護保険利用者負担額減額・免除申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険利用者負担額減額・免除申請書_帳票
     */
    public SourceDataCollection createKaigoHokenRiyoshaFutangakuGengakuMenjyoShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RiyoshaFutangakuGengakuMenjyoShinseishoProerty proerty = new RiyoshaFutangakuGengakuMenjyoShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                Ninshosha nishosha = NinshoshaFinderFactory.createInstance().get帳票認証者(
                        GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        nishosha, association, reportSourceWriter.getImageFolderPath(), RDate.getNowDate());
                List<UaFt200FindShikibetsuTaishoEntity> psmJoho = getPsmJoho(識別コード);
                RString title = this.getタイトル(被保険者番号, psmJoho);
                for (RiyoshaFutangakuGengakuMenjyoShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei, title)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<RiyoshaFutangakuGengakuMenjyoShinseishoReport> toReports(HihokenshaKihonBusiness business,
            RString ninshoshaYakushokuMei,
            RString title) {
        List<RiyoshaFutangakuGengakuMenjyoShinseishoReport> list = new ArrayList<>();
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
        RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem item = new RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem(ninshoshaYakushokuMei,
                title,
                business.getフリガナ(),
                business.get被保険者氏名(),
                business.get保険者番号() == null ? RString.EMPTY : business.get保険者番号().getColumnValue(),
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                birthYMD,
                Gender.toValue(business.get性別()).getCommonName(),
                郵便番号,
                business.get住所(),
                business.get電話番号());
        list.add(RiyoshaFutangakuGengakuMenjyoShinseishoReport.createReport(item));
        return list;
    }

    private static RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private static RString set生年月日(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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

    private static List<UaFt200FindShikibetsuTaishoEntity> getPsmJoho(ShikibetsuCode 識別コード) {
        UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(
                UaFt200FindShikibetsuTaishoFunctionDac.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険,
                        KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        return dac.select(psm);
    }

    private RString getタイトル(HihokenshaNo 被保険者番号, List<UaFt200FindShikibetsuTaishoEntity> entityList) {
        if (entityList.isEmpty()) {
            return RString.EMPTY;
        }
        IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entityList.get(0));
        DbT4001JukyushaDaichoEntity 受給者台帳情報 = 受給者台帳Dac.select受給者台帳情報(shikibetsuTaisho.get現全国地方公共団体コード(),
                被保険者番号,
                new Code(YukoMukoKubun.有効.getコード()));
        if (受給者台帳情報 != null && 受給者台帳情報.getKyuSochishaFlag()) {
            return new RString("（特別療養老人ホームの要介護旧措置入所者に関する認定申請）");
        }
        return RString.EMPTY;
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
