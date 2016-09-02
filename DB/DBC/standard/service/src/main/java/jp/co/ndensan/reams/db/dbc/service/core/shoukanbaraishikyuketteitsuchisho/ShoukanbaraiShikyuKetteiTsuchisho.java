/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shoukanbaraishikyuketteitsuchisho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.KyufuSHurui;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuketteiTsuuchisho;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.HihokenshaJyohoTaishoPSMFuka;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.KozaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shoukanbaraishikyuketteitsuchisho.IShoukanbaraiShikyuKetteiTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4024ShiharaiHohoHenkoSashitomeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.IKozaManager;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN12028_償還払い支給（不支給）決定通知書作成（単）のビジネス
 *
 * @reamsid_L DBC-5310-030 jinge
 */
public class ShoukanbaraiShikyuKetteiTsuchisho {

    private final DbT1001HihokenshaDaichoDac dbT1001dac;
    private final DbT4024ShiharaiHohoHenkoSashitomeDac dbT4024dac;
    private final DbT7130KaigoServiceShuruiDac dbT7130dac;
    private final DbT3053ShokanShukeiDac dbT3053dac;
    private final DbT3045ShokanServicePlan200004Dac dbT3045dac;
    private final DbT3046ShokanServicePlan200604Dac dbT3046dac;
    private final DbT3047ShokanServicePlan200904Dac dbT3047dac;
    private final DbT3043ShokanShokujiHiyoDac dbT3043dac;
    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac dbT3050dac;
    private final MapperProvider mapperProvider;
    private static final RString あり = new RString("0");
    private static final RString なし = new RString("1");
    private static final ServiceShuruiCode 固定 = new ServiceShuruiCode("50");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString 間 = new RString("、");
    private static final RString その他 = new RString("␣その他");
    private static final RString ワークの文言 = new RString("␣滞納保険料への控除が行われました");
    private List<RString> 給付の種類Total;
    private int 償還集計データ件数;

    /**
     * コンストラクタです。
     */
    ShoukanbaraiShikyuKetteiTsuchisho() {
        this.dbT1001dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbT4024dac = InstanceProvider.create(DbT4024ShiharaiHohoHenkoSashitomeDac.class);
        this.dbT7130dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.dbT3053dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.dbT3045dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        this.dbT3046dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        this.dbT3047dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        this.dbT3043dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.dbT3050dac = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link JukyushaTeiseiRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return TokuchoHeijunkaKakutei
     */
    public static ShoukanbaraiShikyuKetteiTsuchisho createInstance() {
        return InstanceProvider.create(ShoukanbaraiShikyuKetteiTsuchisho.class);
    }

    /**
     * 被保険者情報検索のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    private HihokenshaDaicho getShikaku(HihokenshaNo 被保険者番号) {
        DbT1001HihokenshaDaichoEntity hihokenshaEntity
                = dbT1001dac.select被保険者情報(被保険者番号);
        if (hihokenshaEntity == null) {
            return null;
        }
        return new HihokenshaDaicho(hihokenshaEntity);
    }

    /**
     * 支払方法変更差止検索のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     *
     * @return ShiharaiHohoHenkoSashitome
     */
    private SearchResult<ShiharaiHohoHenkoSashitome> getSashitome(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        List<ShiharaiHohoHenkoSashitome> sashitomeEntity = new ArrayList();
        List<DbT4024ShiharaiHohoHenkoSashitomeEntity> entitys = dbT4024dac.select支払方法変更差止(被保険者番号, サービス提供年月, 整理番号);
        if (entitys == null || entitys.isEmpty()) {
            return SearchResult.of(Collections.<ShiharaiHohoHenkoSashitome>emptyList(), 0, false);
        }
        for (DbT4024ShiharaiHohoHenkoSashitomeEntity entity : entitys) {
            sashitomeEntity.add(new ShiharaiHohoHenkoSashitome(entity));
        }
        return SearchResult.of(sashitomeEntity, 0, false);
    }

    /**
     * 口座情報取得です。
     *
     * @param 口座ID 口座ID
     * @return {@link Koza}
     */
    public Koza getKozaJyoho(long 口座ID) {
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).
                build();
        ShoukanbaraiShikyuKetteiTsuchishoParameter param = new ShoukanbaraiShikyuKetteiTsuchishoParameter(searchKey);
        param.set口座ID(口座ID);
        IShoukanbaraiShikyuKetteiTsuchishoMapper mapper = mapperProvider.create(IShoukanbaraiShikyuKetteiTsuchishoMapper.class);
        List<KozaEntity> list = mapper.getKozaJyoho(param);
        if (list.isEmpty()) {
            return null;
        }
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        List<RString> 業務固有キーリスト = new ArrayList<>();
        業務固有キーリスト.add(list.get(0).get業務固有キー());
        builder.setサブ業務コード(list.get(0).getサブ業務コード());
        builder.set業務コード(list.get(0).get業務コード());
        builder.set科目コード(list.get(0).get科目コード());
        builder.set業務固有キーリスト(業務固有キーリスト);
        builder.set用途区分(list.get(0).get用途区分());
        builder.set基準日(null);
        IKozaManager iKozaManager = KozaService.createKozaManager();
        return iKozaManager.get口座(builder.build()).isEmpty() ? null : iKozaManager.get口座(builder.build()).get(0);
    }

    private KyufuSHurui getKyufuSHurui(HihokenshaNo 被保険者番号, RString 整理番号, FlexibleYearMonth サービス提供年月, RString 差額支給対象者区分) {
        List<DbT7130KaigoServiceShuruiEntity> dbt7130entitys = dbT7130dac.getサービス種類名称List(サービス提供年月);
        List<DbT3053ShokanShukeiEntity> dbt3053entitys = dbT3053dac.get給付の種類(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3045ShokanServicePlan200004Entity> dbt3045entitys = dbT3045dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3046ShokanServicePlan200604Entity> dbt3046entitys = dbT3046dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3047ShokanServicePlan200904Entity> dbt3047entitys = dbT3047dac.get償還払請求サービス計画(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3043ShokanShokujiHiyoEntity> dbt3043entitys = dbT3043dac.select償還払請求食事費用(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbt3050entitys = dbT3050dac.select償還払請求特定入所者介護サービス費用(被保険者番号, サービス提供年月, 整理番号);
        償還集計データ件数 = 0;
        給付の種類Total = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        if (!dbt3053entitys.isEmpty()) {
            for (DbT3053ShokanShukeiEntity entity3053 : dbt3053entitys) {
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    if (entity7130.getServiceShuruiCd().equals(entity3053.getServiceShuruiCode())) {
                        builder.append(entity7130.getServiceShuruiRyakusho());
                        builder.append(間);
                        給付の種類Total.add(builder.toRString());
                        償還集計データ件数++;
                    }
                }
            }
        }
        if (!dbt3047entitys.isEmpty()) {
            for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                if (entity7130.getServiceShuruiCd().equals(固定)) {
                    builder.append(entity7130.getServiceShuruiRyakusho());
                    builder.append(間);
                    給付の種類Total.add(builder.toRString());
                    償還集計データ件数++;
                }
            }
        }

        if (!dbt3050entitys.isEmpty()) {
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity3050 : dbt3050entitys) {
                for (DbT7130KaigoServiceShuruiEntity entity7130 : dbt7130entitys) {
                    if (entity7130.getServiceShuruiCd().equals(entity3050.getServiceShuruiCode())) {
                        builder.append(entity7130.getServiceShuruiRyakusho());
                        builder.append(間);
                        給付の種類Total.add(builder.toRString());
                    }
                }
            }
        }
        return null;
    }

    /**
     * 償還払支給決定情報取得です。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 帳票ID 帳票ID
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 文書番号 文書番号
     * @param 発行日 発行日
     * @param 支払予定日 支払予定日
     * @param 口座情報 口座情報
     * @param 支給不支給決定区分
     * @param 差額支給対象者区分
     * @return {@link ShoukanbaraiShikyuketteiTsuuchisho}
     */
    public ShoukanbaraiShikyuketteiTsuuchishoOutputEntity editShoukanbaraiShikyuketteiTsuuchisho(ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号, ReportId 帳票ID, FlexibleYearMonth サービス提供年月, RString 整理番号, RString 文書番号,
            FlexibleDate 発行日, FlexibleDate 支払予定日, Koza 口座情報, RString 支給不支給決定区分, RString 差額支給対象者区分) {
        ShoukanbaraiShikyuketteiTsuuchishoOutputEntity target = new ShoukanbaraiShikyuketteiTsuuchishoOutputEntity();
        RString データ有無 = あり;
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).
                setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード).
                set基準日(発行日).
                build();
        ShoukanbaraiShikyuKetteiTsuchishoParameter param = new ShoukanbaraiShikyuKetteiTsuchishoParameter(searchKey);
        param.setサービス提供年月(サービス提供年月);
        param.set整理番号(整理番号);
        param.set被保険者番号(被保険者番号);
        IShoukanbaraiShikyuKetteiTsuchishoMapper mapper = mapperProvider.create(IShoukanbaraiShikyuKetteiTsuchishoMapper.class);
        ShoukanbaraiShikyuEntity shoukanbaraiShikyuEntity = mapper.select償還払支給(param);
        HihokenshaJyohoTaishoPSMFuka hihokenshaJyohoTaishoPSMFuka = mapper.select被保険者宛名情報(param);
        ShoukanbaraiShikyuketteiTsuuchisho entity = new ShoukanbaraiShikyuketteiTsuuchisho();
        if (shoukanbaraiShikyuEntity == null) {
            target.setデータ有無(なし);
            return target;
        }

        set通知文(entity);
        return null;

    }

    private void set送付物宛先(ShoukanbaraiShikyuketteiTsuuchisho entity, ShikibetsuCode 識別コード, FlexibleDate 発行日) {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        builder.set識別コード(識別コード);
        builder.set基準日(発行日);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());
        ReportAtesakiEditor reportAtesakiEditor = new SofubutsuAtesakiEditorBuilder(宛先).build();
        SofubutsuAtesakiSource 送付物宛先 = new SofubutsuAtesakiSourceBuilder(reportAtesakiEditor).buildSource();
        entity.set送付物宛先(送付物宛先);
    }

    private RString get通知文文章(int パターン番号, int 項目番号) {
        TsuchishoTeikeibunFinder finder = new TsuchishoTeikeibunFinder();
        TsuchishoTeikeibun tsuchishoTeikeibun = finder.get通知書定型文_最新適用開始日(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002.getReportId(),
                KamokuCode.EMPTY, パターン番号, 項目番号);
        if (tsuchishoTeikeibun != null) {
            return tsuchishoTeikeibun.get文章();
        }
        return RString.EMPTY;
    }

    private void set通知文(ShoukanbaraiShikyuketteiTsuuchisho entity) {
        entity.set通知文1(get通知文文章(NUM_1, NUM_2));
        entity.set通知文2(get通知文文章(NUM_1, NUM_3));
        entity.set通知文3(get通知文文章(NUM_2, NUM_3));
        entity.set通知文4(get通知文文章(NUM_3, NUM_3));
        entity.set通知文5(get通知文文章(NUM_3, NUM_4));
        entity.set通知文6(get通知文文章(NUM_4, NUM_3));
        entity.set通知文7(get通知文文章(NUM_4, NUM_4));
    }

}
