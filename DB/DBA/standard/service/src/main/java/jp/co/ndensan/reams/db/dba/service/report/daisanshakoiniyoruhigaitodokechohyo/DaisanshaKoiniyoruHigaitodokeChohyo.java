/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.daisanshakoiniyoruhigaitodokechohyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoItem;
import jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoProerty;
import jp.co.ndensan.reams.db.dba.business.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReport;
import jp.co.ndensan.reams.db.dba.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki.IToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.toiawasesaki.IToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 第三者行為による被害届（介護保険用）Printerです。
 */
public class DaisanshaKoiniyoruHigaitodokeChohyo {

    private static final RString 生年月日不詳区分 = new RString("FALSE");
    private static final RString 帳票ID = new RString("DBC800020");
    private static final RString EM_SPACE = new RString("　");
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;

    /**
     * コンストラクタです。
     */
    DaisanshaKoiniyoruHigaitodokeChohyo() {
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 受給者台帳Dac 受給者台帳Dac
     */
    DaisanshaKoiniyoruHigaitodokeChohyo(DbT4001JukyushaDaichoDac 受給者台帳Dac) {
        this.受給者台帳Dac = 受給者台帳Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link DaisanshaKoiniyoruHigaitodokeChohyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link DaisanshaKoiniyoruHigaitodokeChohyo}のインスタンス
     */
    public static DaisanshaKoiniyoruHigaitodokeChohyo createInstance() {
        return InstanceProvider.create(DaisanshaKoiniyoruHigaitodokeChohyo.class);
    }

    /**
     * 第三者行為による被害届（介護保険用）Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 第三者行為による被害届（介護保険用）_帳票
     */
    public SourceDataCollection createDaisanshaKoiniyoruHigaitodokeChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        DaisanshaKouiHigaitodokeKaigoHokenyoProerty proerty = new DaisanshaKouiHigaitodokeKaigoHokenyoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                RString 被害届通知番号 = get被害届通知番号(被保険者番号);
                List<IAtesaki> tesakiList = get宛先項目(識別コード);
                INinshoshaSourceBuilder sourceBuilder = get役職情報();
                IToiawasesakiSourceBuilder toiawasesakiSourceBuilder = get問合せ情報();
                List<DbT4001JukyushaDaichoEntity> jukyushaDaichoEntityList = this.get受給者台帳情報(get被保険者基本情報(識別コード, 被保険者番号));
                for (DaisanshaKouiHigaitodokeKaigoHokenyoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        // TODO CompNinshoshaの出力項目 技術点NO.46
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei, 被害届通知番号, tesakiList, sourceBuilder,
                        toiawasesakiSourceBuilder, jukyushaDaichoEntityList)) {
                    ReportSourceWriter<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<DaisanshaKouiHigaitodokeKaigoHokenyoReport> toReports(HihokenshaKihonBusiness business,
            RString ninshoshaYakushokuMei, RString 被害届通知番号, List<IAtesaki> tesakiList, INinshoshaSourceBuilder sourceBuilder,
            IToiawasesakiSourceBuilder toiawasesakiSourceBuilder, List<DbT4001JukyushaDaichoEntity> jukyushaDaichoEntityList) {
        List<DaisanshaKouiHigaitodokeKaigoHokenyoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        RString 認定有効期間開始日 = RString.EMPTY;
        RString 認定有効期間終了日 = RString.EMPTY;
        RString 要介護状態区分 = RString.EMPTY;
        RString 郵便番号 = RString.EMPTY;
        RString 住所 = RString.EMPTY;
        RString 氏名 = RString.EMPTY;
        RString 敬称 = RString.EMPTY;
        RString カスタマーバーコード = RString.EMPTY;
        if (!jukyushaDaichoEntityList.isEmpty()) {
            DbT4001JukyushaDaichoEntity jukyushaDaichoEntity = jukyushaDaichoEntityList.get(0);
            認定有効期間開始日 = flexRString(jukyushaDaichoEntity.getNinteiYukoKikanKaishiYMD());
            認定有効期間終了日 = flexRString(jukyushaDaichoEntity.getNinteiYukoKikanShuryoYMD());
            if (jukyushaDaichoEntity.getYokaigoJotaiKubunCode() != null) {
                要介護状態区分 = YokaigoJotaiKubun99.toValue(codeRString(jukyushaDaichoEntity
                        .getYokaigoJotaiKubunCode())).get名称();
            }
        }
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            set生年月日_日本人(business);
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = set生年月日(business);
        }
        if (!tesakiList.isEmpty()) {
            IAtesaki atesaki = tesakiList.get(0);
            郵便番号 = atesaki.get宛先住所().get郵便番号() == null ? RString.EMPTY
                    : atesaki.get宛先住所().get郵便番号().getColumnValue();
            住所 = set住所(atesaki);
            氏名 = atesaki.get宛先名称().getName() == null ? RString.EMPTY : atesaki.get宛先名称().getName().getColumnValue();
            CustomerBarCode code = new CustomerBarCode();
            カスタマーバーコード = code.convertCustomerBarCode(郵便番号, 住所).getCustomerBarCode();
        }

        DaisanshaKouiHigaitodokeKaigoHokenyoItem item = new DaisanshaKouiHigaitodokeKaigoHokenyoItem(ninshoshaYakushokuMei,
                認定有効期間開始日,
                認定有効期間終了日,
                null,
                要介護状態区分,
                business.get保険者番号().isEmpty() ? RString.EMPTY : business.get保険者番号().getColumnValue(),
                business.get被保険者番号().isEmpty() ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                business.getフリガナ(),
                business.get被保険者氏名(),
                生年月日,
                被害届通知番号,
                new RString(RDate.getNowDate().toString()),
                郵便番号,
                住所,
                氏名,
                敬称,
                カスタマーバーコード,
                sourceBuilder.buildSource().ninshoshaYakushokuMei,
                sourceBuilder.buildSource().ninshoshaShimeiKakenai,
                sourceBuilder.buildSource().denshiKoin,
                toiawasesakiSourceBuilder.buildSource().shozaichi,
                toiawasesakiSourceBuilder.buildSource().tantoName,
                toiawasesakiSourceBuilder.buildSource().choshaBushoName,
                toiawasesakiSourceBuilder.buildSource().telNo,
                toiawasesakiSourceBuilder.buildSource().naisenNo);
        list.add(DaisanshaKouiHigaitodokeKaigoHokenyoReport.createReport(item));
        return list;
    }

    private static RString flexRString(FlexibleDate fromDate) {
        RString date = RString.EMPTY;
        if (fromDate != null) {
            date = new RString(fromDate.toString());
        }
        return date;
    }

    private static RString codeRString(Code code) {
        return new RString(code.toString());
    }

    private static RString set住所(IAtesaki atesaki) {
        RString 住所 = RString.EMPTY;
        if (atesaki.get宛先住所() != null) {
            RString 番地 = atesaki.get宛先住所().get番地() == null ? RString.EMPTY
                    : new RString(atesaki.get宛先住所().get番地().toString());
            RString 方書 = atesaki.get宛先住所().get方書() == null ? RString.EMPTY
                    : new RString(atesaki.get宛先住所().get方書().toString());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(atesaki.get宛先住所().get住所());
            stringBuilder.append(番地);
            stringBuilder.append(EM_SPACE);
            stringBuilder.append(方書);
            住所 = new RString(stringBuilder.toString());
        }
        return 住所;
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
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = (business.get生年月日() == null || business.get生年月日().isEmpty()) ? RString.EMPTY : business.get生年月日()
                    .seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = set生年月日_和暦表示(business);
        }
        return 生年月日;
    }

    private static RString set生年月日_和暦表示(HihokenshaKihonBusiness business) {
        RString 生年月日 = RString.EMPTY;
        if (business.get生年月日不詳区分().equals(生年月日不詳区分)) {
            生年月日 = (business.get生年月日() == null || business.get生年月日().isEmpty()) ? RString.EMPTY : business.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 生年月日;
    }

    private List<IAtesaki> get宛先項目(ShikibetsuCode 識別コード) {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set識別コード(識別コード);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用しない);
        builder.set送付先利用区分(SofusakiRiyoKubun.利用しない);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        builder.set基準日(FlexibleDate.getNowDate());
        List<IAtesaki> 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先s(builder.build());
        return 宛先;
    }

    private RString get被害届通知番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        RString 被害届通知番号 = new RString("被害届通知番号");
        return 被害届通知番号;
    }

    private INinshoshaSourceBuilder get役職情報() {
        INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
        INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                RDate.getNowDate(), null);
        return ninshoshaSourceBuilder;
    }

    private IToiawasesakiSourceBuilder get問合せ情報() {
        IToiawasesakiSourceBuilderCreator toiawasesakiSourceBuilderCreator = ReportSourceBuilders.toiawaseSourceBuilder();
        IToiawasesakiSourceBuilder toiawasesakiSourceBuilder = toiawasesakiSourceBuilderCreator.create(GyomuCode.DB介護保険,
                new ReportId(帳票ID), null, null);
        return toiawasesakiSourceBuilder;
    }

    private List<DbT4001JukyushaDaichoEntity> get受給者台帳情報(HihokenshaKihonBusiness business) {
        List<DbT4001JukyushaDaichoEntity> daichoEntityList = 受給者台帳Dac.select受給者台帳情報(HihokenshaNo.EMPTY, Code.EMPTY, Code.EMPTY);
        return daichoEntityList;

    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        HihokenshaKihonBusiness list = shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
        return list;
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
