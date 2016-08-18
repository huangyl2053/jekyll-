/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseishojoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoProperty;
import jp.co.ndensan.reams.db.dba.business.report.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tokuteifutangendogakushinseisho.TokuteifutanMybatisParam;
import jp.co.ndensan.reams.db.dba.entity.report.tokuteifutangendogakushinseisho.TokuteiFutangendogakuShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tokuteifutangendogakushinseisho.ITokuteifutanGendogakuShinseishoRelateMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * 介護保険特定負担限度額申請書Printerです。
 *
 * @reamsid_L DBA-0540-688 houtianpeng
 */
public class TokuteifutanGendogakuShinseisho {

    private static final RString 生年月日不詳区分 = new RString("0");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 2;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final RString 連番 = new RString("1");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ。
     *
     */
    TokuteifutanGendogakuShinseisho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     */
    TokuteifutanGendogakuShinseisho(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuteifutanGendogakuShinseisho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuteifutanGendogakuShinseisho}のインスタンス
     */
    public static TokuteifutanGendogakuShinseisho createInstance() {
        return InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
    }

    /**
     * 介護保険特定負担限度額申請書をPrintします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険特定負担限度額申請書_帳票
     */
    public SourceDataCollection createTokuteifutanGendogakuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteiFutangendogakuShinseishoProperty proerty = new TokuteiFutangendogakuShinseishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<TokuteiFutangendogakuShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<TokuteiFutangendogakuShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, reportSourceWriter.getImageFolderPath());
                for (TokuteiFutangendogakuShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei, 識別コード)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<TokuteiFutangendogakuShinseishoReport> toReports(HihokenshaKihonBusiness entity,
            RString ninshoshaYakushokuMei, ShikibetsuCode 識別コード) {
        List<TokuteiFutangendogakuShinseishoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(entity.get住民種別コード())) {
            生年月日 = set生年月日_日本人(entity);
        } else if (JuminShubetsu.外国人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(entity.get住民種別コード())) {
            生年月日 = set生年月日(entity);
        }
        List<RString> 施設情報 = get施設情報(get施設情報の取得(識別コード));
        RString 施設郵便番号 = 施設情報.get(INDEX_0);
        RString 施設電話番号 = 施設情報.get(INDEX_1);
        RString 施設住所 = 施設情報.get(INDEX_2);
        RString 施設名称 = 施設情報.get(INDEX_3);

        TokuteiFutangendogakuShinseishoItem item = new TokuteiFutangendogakuShinseishoItem(
                ninshoshaYakushokuMei,
                entity.getフリガナ(),
                entity.get被保険者氏名().isEmpty() ? RString.EMPTY : entity.get被保険者氏名(),
                entity.get保険者番号().isEmpty() ? RString.EMPTY : entity.get保険者番号().value(),
                entity.get被保険者番号().isEmpty() ? RString.EMPTY : entity.get被保険者番号().getColumnValue(),
                生年月日,
                Gender.toValue(entity.get性別()).getCommonName(),
                set郵便番号(entity.get郵便番号()),
                entity.get住所().isEmpty() ? RString.EMPTY : entity.get住所(),
                entity.get電話番号(),
                set郵便番号(施設郵便番号),
                施設住所,
                施設名称,
                施設電話番号,
                連番);
        list.add(TokuteiFutangendogakuShinseishoReport.createFrom(item));
        return list;
    }

    private static RString getYubinNoValue(YubinNo yubinNo) {
        RString value = RString.EMPTY;
        if (yubinNo != null && yubinNo.value() != null) {
            value = yubinNo.value();
        }
        return value;
    }

    private static RString getTelNoValue(TelNo telNo) {
        RString value = RString.EMPTY;
        if (telNo != null && telNo.value() != null) {
            value = telNo.value();
        }
        return value;
    }

    private static RString getAtenaJushoValue(AtenaJusho atenaJusho) {
        RString value = RString.EMPTY;
        if (atenaJusho != null && atenaJusho.value() != null) {
            value = atenaJusho.value();
        }
        return value;
    }

    private static RString getAtenaMeishoValue(AtenaMeisho atenaMeisho) {
        RString value = RString.EMPTY;
        if (atenaMeisho != null && atenaMeisho.value() != null) {
            value = atenaMeisho.value();
        }
        return value;
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

    private List<RString> get施設情報(DbT1004ShisetsuNyutaishoEntity dbT1004ShisetsuNyutaishoEntity) {
        RString 施設郵便番号 = RString.EMPTY;
        RString 施設電話番号 = RString.EMPTY;
        RString 施設住所 = RString.EMPTY;
        RString 施設名称 = RString.EMPTY;
        List<RString> list = new ArrayList<>();
        if (dbT1004ShisetsuNyutaishoEntity != null) {
            if (ShisetsuType.介護保険施設.getコード().equals(dbT1004ShisetsuNyutaishoEntity.getNyushoShisetsuShurui())) {
                DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity = get介護事業者_事業者情報の取得(dbT1004ShisetsuNyutaishoEntity
                        .getNyushoShisetsuCode().value());
                施設郵便番号 = dbT7060KaigoJigyoshaEntity == null
                        ? RString.EMPTY : getYubinNoValue(dbT7060KaigoJigyoshaEntity.getYubinNo());
                施設電話番号 = dbT7060KaigoJigyoshaEntity == null
                        ? RString.EMPTY : getTelNoValue(dbT7060KaigoJigyoshaEntity.getTelNo());
                施設住所 = dbT7060KaigoJigyoshaEntity == null
                        ? RString.EMPTY : getAtenaJushoValue(dbT7060KaigoJigyoshaEntity.getJigyoshaAddress());
                施設名称 = dbT7060KaigoJigyoshaEntity == null
                        ? RString.EMPTY : getAtenaMeishoValue(dbT7060KaigoJigyoshaEntity.getJigyoshaName());
            }
            if (ShisetsuType.住所地特例対象施設.getコード().equals(dbT1004ShisetsuNyutaishoEntity.getNyushoShisetsuShurui())) {
                DbT1005KaigoJogaiTokureiTaishoShisetsuEntity dbT1005Entity
                        = get介護除外住所地特例対象施設_事業者情報の取得(dbT1004ShisetsuNyutaishoEntity.getNyushoShisetsuCode().value());
                施設郵便番号 = dbT1005Entity == null ? RString.EMPTY : getYubinNoValue(dbT1005Entity.getYubinNo());
                施設電話番号 = dbT1005Entity == null ? RString.EMPTY : getTelNoValue(dbT1005Entity.getTelNo());
                施設住所 = dbT1005Entity == null ? RString.EMPTY : dbT1005Entity.getJigyoshaJusho();
                施設名称 = dbT1005Entity == null ? RString.EMPTY : getAtenaMeishoValue(dbT1005Entity.getJigyoshaMeisho());
            }
        }
        list.add(施設郵便番号);
        list.add(施設電話番号);
        list.add(施設住所);
        list.add(施設名称);
        return list;
    }

    private DbT1004ShisetsuNyutaishoEntity get施設情報の取得(ShikibetsuCode 識別コード) {
        ITokuteifutanGendogakuShinseishoRelateMapper tokuteifutanRelateMapper = mapperProvider
                .create(ITokuteifutanGendogakuShinseishoRelateMapper.class);
        DbT1004ShisetsuNyutaishoEntity entity = tokuteifutanRelateMapper
                .get施設情報(TokuteifutanMybatisParam.create施設情報パラメータ(識別コード.value()));
        return entity;
    }

    private DbT7060KaigoJigyoshaEntity get介護事業者_事業者情報の取得(RString 入所施設コード) {
        ITokuteifutanGendogakuShinseishoRelateMapper tokuteifutanRelateMapper = mapperProvider
                .create(ITokuteifutanGendogakuShinseishoRelateMapper.class);
        DbT7060KaigoJigyoshaEntity entity = tokuteifutanRelateMapper.get事業者情報(TokuteifutanMybatisParam
                .create介護事業者パラメータ(入所施設コード));
        return entity;
    }

    private DbT1005KaigoJogaiTokureiTaishoShisetsuEntity get介護除外住所地特例対象施設_事業者情報の取得(RString 入所施設コード) {
        ITokuteifutanGendogakuShinseishoRelateMapper tokuteifutanRelateMapper = mapperProvider
                .create(ITokuteifutanGendogakuShinseishoRelateMapper.class);
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = tokuteifutanRelateMapper
                .get介護除外住所地特例対象施設情報(TokuteifutanMybatisParam.create介護除外住所地特例対象施設パラメータ(入所施設コード));
        return entity;
    }

    private static RString set生年月日(HihokenshaKihonBusiness entity) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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
        jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider
                .create(jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }
}
