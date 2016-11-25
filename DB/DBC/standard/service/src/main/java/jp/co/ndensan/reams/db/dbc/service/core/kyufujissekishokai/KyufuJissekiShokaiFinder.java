/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiNyushosyaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiTokuteiSinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiCareManagementHiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekkaDataBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiJutakuKaishuhiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiRelate;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiHeaderJohoMapperParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufujissekishokai.KyufuJissekiKensakuDataMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiCareManagementHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiKihonShukeiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiShukeiKekkaData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiFukushiYoguHanbaihiBusinessRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiJutakuKaishuhiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiKogakuKaigoServicehiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiKyotakuServiceRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiMeisaiJushochiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiMeisaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekishokai.IKyufuJissekiShokaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績照会情報の取得クラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
public class KyufuJissekiShokaiFinder {

    private final MapperProvider mapperProvider;
    private final DbV1001HihokenshaDaichoAliveDac dbV1001;
    private final DbV4001JukyushaDaichoAliveDac dbV4001;
    private final DbT3118ShikibetsuNoKanriDac dbT3118;
    private static final RString 準拠する = new RString("1");
    private static final RString 準拠しない = new RString("0");
    private static final RString 被保険者番号文字列 = new RString("被保険者番号");
    private static final RString サービス提供年月_開始文字列 = new RString("サービス提供年月（開始）");
    private static final RString サービス提供年月_終了文字列 = new RString("サービス提供年月（終了）");
    private static final RString 事業所番号文字列 = new RString("事業所番号");
    private static final RString 整理番号文字列 = new RString("整理番号");
    private static final RString サービス提供年月文字列 = new RString("サービス提供年月");
    private static final RString 識別番号文字列 = new RString("識別番号");
    private static final RString 宛名情報KEY = new RString("psmShikibetsuTaisho");
    private static final RString サービス提供年月_文字列 = new RString("サービス提供年月");
    private static final RString 通し番号文字列 = new RString("通し番号");

    /**
     * コンストラクタです。
     */
    KyufuJissekiShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbV1001 = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        this.dbV4001 = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        this.dbT3118 = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dbV1001 dbV1001
     * @param dbV4001 dbV4001
     * @param dbT3118 dbT3118
     */
    KyufuJissekiShokaiFinder(MapperProvider mapperProvider, DbV1001HihokenshaDaichoAliveDac dbV1001,
            DbV4001JukyushaDaichoAliveDac dbV4001, DbT3118ShikibetsuNoKanriDac dbT3118) {
        this.mapperProvider = mapperProvider;
        this.dbV1001 = dbV1001;
        this.dbV4001 = dbV4001;
        this.dbT3118 = dbT3118;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuJissekiShokaiFinder}のインスタンスを返します。
     *
     * @return KyufuJissekiShokaiFinder
     */
    public static KyufuJissekiShokaiFinder createInstance() {
        return InstanceProvider.create(KyufuJissekiShokaiFinder.class);
    }

    /**
     * 給付実績ヘッダ情報１の取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1
     */
    @Transaction
    public SearchResult<KyufuJissekiHedajyoho1> getKyufuJissekiHeaderJoho1(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        List<KyufuJissekiHedajyoho1> 給付実績ヘッダ情報1 = new ArrayList<>();
        DbV1001HihokenshaDaichoEntity 最新の被保険者台帳情報 = dbV1001.get最新の被保険者台帳情報(被保険者番号);
        if (最新の被保険者台帳情報 == null) {
            return SearchResult.of(給付実績ヘッダ情報1, 0, false);
        }
        KyufuJissekiHedajyoho1 給付実績ヘッダ情報 = new KyufuJissekiHedajyoho1();
        給付実績ヘッダ情報.set被保険者番号(被保険者番号);
        給付実績ヘッダ情報.set資格取得事由コード(最新の被保険者台帳情報.getShikakuShutokuJiyuCode());
        DbV4001JukyushaDaichoEntity 受給者情報 = dbV4001.selectBy被保険者番号And識別コード(
                最新の被保険者台帳情報.getHihokenshaNo(), 最新の被保険者台帳情報.getShikibetsuCode());
        if (受給者情報 != null) {
            給付実績ヘッダ情報.set要介護認定状態区分コード(受給者情報.getYokaigoJotaiKubunCode().value());
            給付実績ヘッダ情報.set認定有効期間開始年月日(受給者情報.getNinteiYukoKikanKaishiYMD());
            給付実績ヘッダ情報.set認定有効期間終了年月日(受給者情報.getNinteiYukoKikanShuryoYMD());
            給付実績ヘッダ情報.set認定年月日(受給者情報.getNinteiYMD());
            ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                    ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
            key.setデータ取得区分(DataShutokuKubun.直近レコード);
            key.set識別コード(最新の被保険者台帳情報.getShikibetsuCode());
            UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
            IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
            UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.get宛名情報(
                    KyufuJissekiHeaderJohoMapperParameter.createParameter_宛名情報(
                            new RString(uaFt200Psm.getParameterMap().get(宛名情報KEY.toString()).toString())));
            if (宛名情報 != null) {
                IKojin 個人情報 = ShikibetsuTaishoFactory.createKojin(宛名情報);
                給付実績ヘッダ情報.set名称(個人情報.get名称().getName().value());
                給付実績ヘッダ情報.set性別コード(個人情報.get性別().getCode());
                給付実績ヘッダ情報.set生年月日(個人情報.get生年月日().toFlexibleDate());
                給付実績ヘッダ情報.set住民種別(個人情報.get住民種別().toRString());
            }
        }
        給付実績ヘッダ情報1.add(給付実績ヘッダ情報);
        return SearchResult.of(給付実績ヘッダ情報1, 0, false);
    }

    /**
     * 給付実績ヘッダ情報２の取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 識別番号 識別番号
     * @return SearchResult<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報２
     */
    @Transaction
    public SearchResult<KyufuJissekiHedajyoho2> getKyufuJissekiHeaderJoho2(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, NyuryokuShikibetsuNo 識別番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufuJissekiHedajyoho2> 給付実績ヘッダ情報2リスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufuJissekiJyohoRelateEntity> 給付実績情報リスト = mapper.get給付実績情報(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_給付実績情報(
                        被保険者番号, サービス提供年月, 整理番号, 識別番号.value()));
        for (KyufuJissekiJyohoRelateEntity 給付実績情報 : 給付実績情報リスト) {
            KyufuJissekiHedajyoho2 給付実績ヘッダ情報2 = new KyufuJissekiHedajyoho2();
            給付実績ヘッダ情報2.setサービス提供年月(給付実績情報.getServiceTeikyoYM());
            給付実績ヘッダ情報2.set整理番号(給付実績情報.getSeiriNo());
            給付実績ヘッダ情報2.set給付実績区分コード(給付実績情報.getKyufuSakuseiKubunCode());
            給付実績ヘッダ情報2.set識別番号(給付実績情報.getShikibetsuNo());
            給付実績ヘッダ情報2.set識別番号名称(給付実績情報.getShikibetsuMeisho());
            給付実績ヘッダ情報2.set事業所番号(給付実績情報.getJigyoshoNo());
            給付実績ヘッダ情報2.set事業者名称(getJikyoshaName(給付実績情報.getJigyoshoNo(), サービス提供年月));
            給付実績ヘッダ情報2リスト.add(給付実績ヘッダ情報2);
        }
        return SearchResult.of(給付実績ヘッダ情報2リスト, 0, false);
    }

    /**
     * 事業者名称の取得処理です。
     *
     * @param 事業所番号 事業所番号
     * @param 基準年月 基準年月
     * @return 事業者名称
     */
    @Transaction
    public RString getJikyoshaName(JigyoshaNo 事業所番号, FlexibleYearMonth 基準年月) {
        if (事業所番号 == null || 事業所番号.isEmpty()) {
            return RString.EMPTY;
        }
        RString 事業者名称_介護事業者 = RString.EMPTY;
        RString 事業者名称_介護事業者指定サービス = RString.EMPTY;
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        DbT7060KaigoJigyoshaEntity 介護事業者情報 = mapper.get介護事業者情報(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_事業者名称(事業所番号, 基準年月));
        if (介護事業者情報 != null && 介護事業者情報.getJigyoshaName() != null
                && !介護事業者情報.getJigyoshaName().isEmpty()) {
            事業者名称_介護事業者 = 介護事業者情報.getJigyoshaName().value();
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定サービス情報 = mapper.get介護事業者指定サービス情報(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_事業者名称(事業所番号, 基準年月));
        if (介護事業者指定サービス情報 != null) {
            if (介護事業者指定サービス情報.getJigyoshaName() != null
                    && !介護事業者指定サービス情報.getJigyoshaName().isEmpty()) {
                事業者名称_介護事業者指定サービス = 介護事業者指定サービス情報.getJigyoshaName().value();
            }
            RString 基本情報準拠区分 = 介護事業者指定サービス情報.getKihonJohoJunkyoKubun();
            if (準拠する.equals(基本情報準拠区分)) {
                return 事業者名称_介護事業者;
            } else if (準拠しない.equals(基本情報準拠区分)) {
                return 事業者名称_介護事業者指定サービス;
            }
        } else {
            return 事業者名称_介護事業者;
        }
        return RString.EMPTY;
    }

    /**
     * 識別番号管理データの取得処理です。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @return 識別番号管理データ
     */
    @Transaction
    public SearchResult<ShikibetsuNoKanri> getShikibetsuBangoKanri(FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月文字列.toString()));
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<ShikibetsuNoKanri> 識別番号管理データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3118ShikibetsuNoKanriEntity> 識別番号管理データ = mapper.get識別番号管理データ(
                KyufuJissekiHeaderJohoMapperParameter.createParameter_識別番号管理データ(サービス提供年月, 識別番号.value()));
        if (識別番号管理データ != null && !識別番号管理データ.isEmpty()) {
            ShikibetsuNoKanri 識別番号管理データ1件目 = new ShikibetsuNoKanri(識別番号管理データ.get(0));
            識別番号管理データリスト.add(識別番号管理データ1件目);
        }
        return SearchResult.of(識別番号管理データリスト, 0, false);
    }

    /**
     * 給付実績情報照会用データの取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param isKey0検索対象 isKey0検索対象
     * @param 検索条件番目 検索条件番目
     * @param サービス種類コードList サービス種類コードList
     * @return 給付実績基本データ
     */
    @Transaction
    public List<KyufuJissekiKihonShukeiRelate> get給付実績基本データ(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            boolean isKey0検索対象, RString 検索条件番目, List<RString> サービス種類コードList) {
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufuJissekiKihonShukeiRelateEntity> 給付実績基本データ
                = mapper.get給付実績基本データ(
                        KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                                NyuryokuShikibetsuNo.EMPTY, 被保険者番号, サービス提供年月_開始,
                                サービス提供年月_終了, JigyoshaNo.EMPTY, RString.EMPTY,
                                FlexibleYearMonth.EMPTY, isKey0検索対象, 検索条件番目, サービス種類コードList));
        List<KyufuJissekiKihonShukeiRelate> 給付実績基本データList = new ArrayList<>();
        for (KyufuJissekiKihonShukeiRelateEntity 給付実績基本 : 給付実績基本データ) {
            給付実績基本データList.add(new KyufuJissekiKihonShukeiRelate(給付実績基本));
        }
        return 給付実績基本データList;
    }

    /**
     * 給付実績集計データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績集計データ
     */
    public List<KyufujissekiShukei> get給付実績集計データ(NyuryokuShikibetsuNo 入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        List<KyufujissekiShukei> 給付実績集計データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3033KyufujissekiShukeiEntity> entityList = mapper.get給付実績集計データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月_開始,
                        サービス提供年月_終了, 事業所番号, 整理番号, FlexibleYearMonth.EMPTY));
        for (DbT3033KyufujissekiShukeiEntity entity : entityList) {
            KyufujissekiShukei 給付実績集計データ = new KyufujissekiShukei(entity);
            給付実績集計データリスト.add(給付実績集計データ);
        }
        return 給付実績集計データリスト;
    }

    /**
     * 給付実績明細データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param サービス提供年月 サービス提供年月
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績明細データ
     */
    public List<KyufujissekiMeisaiBusiness> get給付実績明細データ(NyuryokuShikibetsuNo 入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了, JigyoshaNo 事業所番号, RString 整理番号,
            FlexibleYearMonth サービス提供年月, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月文字列.toString()));
        List<KyufujissekiMeisaiBusiness> 給付実績明細データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiMeisaiRelateEntity> entityList = mapper.get給付実績明細データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月_開始, サービス提供年月_終了,
                        事業所番号, 整理番号, サービス提供年月));
        for (KyufujissekiMeisaiRelateEntity entity : entityList) {
            KyufujissekiMeisaiBusiness 給付実績明細データ = new KyufujissekiMeisaiBusiness();
            給付実績明細データ.set給付実績明細(new KyufujissekiMeisai(entity.get給付実績明細データ()));
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績明細データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績明細データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績明細データリスト.add(給付実績明細データ);
        }
        return 給付実績明細データリスト;
    }

    /**
     * 給付実績緊急時施設療養データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績緊急時施設療養データ
     */
    public List<KyufujissekiKinkyuShisetsuRyoyo> get給付実績緊急時施設療養データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月_開始,
            FlexibleYearMonth サービス提供年月_終了, JigyoshaNo 事業所番号, RString 整理番号, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity> entityList = mapper.get給付実績緊急時施設療養データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月_開始, サービス提供年月_終了,
                        事業所番号, 整理番号, FlexibleYearMonth.EMPTY));
        for (DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity entity : entityList) {
            KyufujissekiKinkyuShisetsuRyoyo 給付実績緊急時施設療養データ = new KyufujissekiKinkyuShisetsuRyoyo(entity);
            給付実績緊急時施設療養データリスト.add(給付実績緊急時施設療養データ);
        }
        return 給付実績緊急時施設療養データリスト;
    }

    /**
     * 給付実績所定疾患施設療養費等データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績所定疾患施設療養費等データ
     */
    public List<KyufujissekiShoteiShikkanShisetsuRyoyo> ge給付実績所定疾患施設療養費等データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月_開始,
            FlexibleYearMonth サービス提供年月_終了, JigyoshaNo 事業所番号, RString 整理番号, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 給付実績所定疾患施設療養費等データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity> entityList = mapper.get給付実績所定疾患施設療養費等データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月_開始, サービス提供年月_終了,
                        事業所番号, 整理番号, FlexibleYearMonth.EMPTY));
        for (DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity : entityList) {
            KyufujissekiShoteiShikkanShisetsuRyoyo 給付実績所定疾患施設療養費等データ = new KyufujissekiShoteiShikkanShisetsuRyoyo(entity);
            給付実績所定疾患施設療養費等データリスト.add(給付実績所定疾患施設療養費等データ);
        }
        return 給付実績所定疾患施設療養費等データリスト;
    }

    /**
     * 給付実績特定診療費データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績特定診療費データ
     */
    public List<KyufujissekiTokuteiSinryohi> get給付実績特定診療費データ(NyuryokuShikibetsuNo 入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        List<KyufujissekiTokuteiSinryohi> 給付実績特定診療費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3020KyufujissekiTokuteiSinryohiEntity> entityList = mapper.get給付実績特定診療費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月_開始, サービス提供年月_終了,
                        事業所番号, 整理番号, FlexibleYearMonth.EMPTY));
        for (DbT3020KyufujissekiTokuteiSinryohiEntity entity : entityList) {
            KyufujissekiTokuteiSinryohi 給付実績特定診療費データ = new KyufujissekiTokuteiSinryohi(entity);
            給付実績特定診療費データリスト.add(給付実績特定診療費データ);
        }
        return 給付実績特定診療費データリスト;
    }

    /**
     * 給付実績特定診療費データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績特定診療費_特別療養費データ
     */
    public List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> get給付実績特定診療費_特別療養費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月_開始,
            FlexibleYearMonth サービス提供年月_終了, JigyoshaNo 事業所番号, RString 整理番号, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> 給付実績特定診療費_特別療養費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> entityList = mapper.get給付実績特定診療費_特別療養費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月_開始, サービス提供年月_終了,
                        事業所番号, 整理番号, FlexibleYearMonth.EMPTY));
        for (DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity : entityList) {
            KyufujissekiTokuteiSinryoTokubetsuRyoyo 給付実績特定診療費_特別療養費データ = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(entity);
            給付実績特定診療費_特別療養費データリスト.add(給付実績特定診療費_特別療養費データ);
        }
        return 給付実績特定診療費_特別療養費データリスト;
    }

    /**
     * 給付実績食事費用データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 事業所番号 事業所番号
     * @param 整理番号 整理番号
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績食事費用データ
     */
    public List<KyufujissekiShokujiHiyo> get給付実績食事費用データ(NyuryokuShikibetsuNo 入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            JigyoshaNo 事業所番号, RString 整理番号, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(整理番号文字列.toString()));
        List<KyufujissekiShokujiHiyo> 給付実績食事費用データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3022KyufujissekiShokujiHiyoEntity> entityList = mapper.get給付実績食事費用データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月_開始,
                        サービス提供年月_終了, 事業所番号, 整理番号, FlexibleYearMonth.EMPTY));
        for (DbT3022KyufujissekiShokujiHiyoEntity entity : entityList) {
            KyufujissekiShokujiHiyo 給付実績食事費用データ = new KyufujissekiShokujiHiyo(entity);
            給付実績食事費用データリスト.add(給付実績食事費用データ);
        }
        return 給付実績食事費用データリスト;
    }

    /**
     * 給付実績居宅サービス計画費データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param サービス提供年月 サービス提供年月
     * @param 通し番号 通し番号
     * @return 給付実績居宅サービス計画費データ
     */
    @Transaction
    public List<KyufujissekiKyotakuServiceBusiness> get給付実績居宅サービス計画費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiKyotakuServiceBusiness> 給付実績居宅サービス計画費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiKyotakuServiceRelateEntity> entityList = mapper.get給付実績居宅サービス計画費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufujissekiKyotakuServiceRelateEntity entity : entityList) {
            KyufujissekiKyotakuServiceBusiness 給付実績居宅サービス計画費データ = new KyufujissekiKyotakuServiceBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績居宅サービス計画費データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績居宅サービス計画費データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績居宅サービス計画費データ.set居宅サービス計画費(
                    new KyufujissekiKyotakuService(entity.get給付実績居宅サービス計画費データ()));
            給付実績居宅サービス計画費データリスト.add(給付実績居宅サービス計画費データ);
        }
        return 給付実績居宅サービス計画費データリスト;
    }

    /**
     * 給付実績住宅改修費データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param サービス提供年月 サービス提供年月
     * @param 通し番号 通し番号
     * @return 給付実績住宅改修費データ
     */
    @Transaction
    public List<KyufujissekiJutakuKaishuhiBusiness> get給付実績住宅改修費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiJutakuKaishuhiRelateEntity> entityList = mapper.get給付実績住宅改修費データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufujissekiJutakuKaishuhiRelateEntity entity : entityList) {
            KyufujissekiJutakuKaishuhiBusiness 給付実績住宅改修費データ = new KyufujissekiJutakuKaishuhiBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績住宅改修費データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績住宅改修費データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績住宅改修費データ.set給付実績住宅改修費情報(new KyufujissekiJutakuKaishuhi(entity.get給付実績住宅改修費データ()));
            給付実績住宅改修費データリスト.add(給付実績住宅改修費データ);
        }
        return 給付実績住宅改修費データリスト;
    }

    /**
     * 給付実績高額介護サービス費データの取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param isKey0検索対象 isKey0検索対象
     * @return 給付実績高額介護サービス費データ
     */
    @Transaction
    public List<KyufujissekiKogakuKaigoServicehiRelate> get給付実績高額介護サービス費データ(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了, boolean isKey0検索対象) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月_開始, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_開始文字列.toString()));
        requireNonNull(サービス提供年月_終了, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_終了文字列.toString()));
        List<KyufujissekiKogakuKaigoServicehiRelate> 給付実績高額介護サービス費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiKogakuKaigoServicehiRelateEntity> entityList = mapper.get給付実績高額介護サービス費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        NyuryokuShikibetsuNo.EMPTY, 被保険者番号, サービス提供年月_開始, サービス提供年月_終了,
                        JigyoshaNo.EMPTY, RString.EMPTY, FlexibleYearMonth.EMPTY));
        for (KyufujissekiKogakuKaigoServicehiRelateEntity entity : entityList) {
            給付実績高額介護サービス費データリスト.add(new KyufujissekiKogakuKaigoServicehiRelate(entity));
        }
        return 給付実績高額介護サービス費データリスト;
    }

    /**
     * 給付実績特定入所者介護サービス費用データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param サービス提供年月 サービス提供年月
     * @param 通し番号 通し番号
     * @return 給付実績特定入所者介護サービス費用データ
     */
    @Transaction
    public List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> get給付実績特定入所者介護サービス費用データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 給付実績特定入所者介護サービス費用データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity> entityList = mapper.get給付実績特定入所者介護サービス費用データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity entity : entityList) {
            KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 給付実績特定入所者介護サービス費用データ
                    = new KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績特定入所者介護サービス費用データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績特定入所者介護サービス費用データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績特定入所者介護サービス費用データ.set特定入所者費用(
                    new KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(entity.get給付実績特定入所者介護サービス費用データ()));
            給付実績特定入所者介護サービス費用データリスト.add(給付実績特定入所者介護サービス費用データ);
        }
        return 給付実績特定入所者介護サービス費用データリスト;
    }

    /**
     * 給付実績社会福祉法人軽減額データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param サービス提供年月 サービス提供年月
     * @param 通し番号 通し番号
     * @return 給付実績社会福祉法人軽減額データ
     */
    @Transaction
    public List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> get給付実績社会福祉法人軽減額データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufuJissekiShakaiFukushiHojinKeigengakuBusiness> 給付実績社会福祉法人軽減額データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity> entityList = mapper.get給付実績社会福祉法人軽減額データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity entity : entityList) {
            KyufuJissekiShakaiFukushiHojinKeigengakuBusiness 給付実績集計データ = new KyufuJissekiShakaiFukushiHojinKeigengakuBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績集計データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績集計データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績集計データ.set給付実績社会福祉法人軽減額情報(new KyufuJissekiShakaiFukushiHojinKeigengaku(
                    entity.get給付実績社会福祉法人軽減額データ()));
            給付実績社会福祉法人軽減額データリスト.add(給付実績集計データ);
        }
        return 給付実績社会福祉法人軽減額データリスト;
    }

    /**
     * 給付実績ケアマネジメント費データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param サービス提供年月 サービス提供年月
     * @param 通し番号 通し番号
     * @return 給付実績ケアマネジメント費データ
     */
    @Transaction
    public List<KyufuJissekiCareManagementHiBusiness> get給付実績ケアマネジメント費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufuJissekiCareManagementHiBusiness> 給付実績ケアマネジメント費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufuJissekiCareManagementHiRelateEntity> entityList = mapper.get給付実績ケアマネジメント費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufuJissekiCareManagementHiRelateEntity entity : entityList) {
            KyufuJissekiCareManagementHiBusiness 給付実績ケアマネジメント費データ = new KyufuJissekiCareManagementHiBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績ケアマネジメント費データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績ケアマネジメント費データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績ケアマネジメント費データ.set給付実績ケアマネジメント費基本情報(
                    new KyufuJissekiCareManagementHi(entity.get給付実績ケアマネジメント費データ()));
            給付実績ケアマネジメント費データリスト.add(給付実績ケアマネジメント費データ);
        }
        return 給付実績ケアマネジメント費データリスト;
    }

    /**
     * 給付分類区分を取得します。
     *
     * @param 識別番号 識別番号
     * @param サービス提供年月 サービス提供年月
     * @return 給付分類区分
     */
    @Transaction
    public RString get給付分類区分(NyuryokuShikibetsuNo 識別番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月文字列.toString()));
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        DbT3118ShikibetsuNoKanriEntity 識別番号管理データ = dbT3118.selectByKey(識別番号.value(), サービス提供年月);
        if (識別番号管理データ != null && !RString.isNullOrEmpty(識別番号管理データ.getKyufuBunruiKubun())) {
            return 識別番号管理データ.getKyufuBunruiKubun();
        }
        return RString.EMPTY;
    }

    /**
     * 給付実績明細住所地特例データの取得処理です。
     *
     * @param is経過措置 is経過措置
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 被保険者番号 被保険者番号
     * @return 給付実績集計データ
     */
    @Transaction
    public List<KyufuJissekiShukeiKekkaDataBusiness> get集計データ(boolean is経過措置,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了, HihokenshaNo 被保険者番号) {
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        KyufuJissekiKensakuDataMapperParameter para
                = KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        NyuryokuShikibetsuNo.EMPTY, 被保険者番号, サービス提供年月_開始,
                        サービス提供年月_終了, JigyoshaNo.EMPTY, RString.EMPTY, FlexibleYearMonth.EMPTY, !is経過措置, null, null);
        List<KyufuJissekiShukeiKekkaData> entityList;
        List<KyufuJissekiShukeiKekkaDataBusiness> 集計データList = new ArrayList<>();
        if (!is経過措置) {
            entityList = mapper.get集計データ(para);
        } else {
            entityList = mapper.get集計データ_経過措置(para);
        }
        for (KyufuJissekiShukeiKekkaData entity : entityList) {
            集計データList.add(new KyufuJissekiShukeiKekkaDataBusiness(entity));
        }
        return 集計データList;
    }

    /**
     * 給付実績情報照会用データの取得処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 FlexibleYearMonth
     * @param 入力識別番号 NyuryokuShikibetsuNo
     * @param 事業所番号 JigyoshaNo
     * @param 通し番号 RString
     * @return 給付実績情報照会用データ
     */
    @Transaction
    public KyufuJissekiPrmBusiness get検索集計と明細と住所地データ(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 入力識別番号, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        KyufuJissekiPrmBusiness 給付実績情報照会用データ = new KyufuJissekiPrmBusiness();
        List<KyufujissekiShukei> 給付実績集計データリスト;
        List<KyufujissekiMeisaiBusiness> 給付実績明細データリスト;
        List<KyufujissekiMeisaiJushochiTokureiBusiness> 給付実績明細住所地特例データリスト;

        給付実績集計データリスト = get給付実績集計データ(入力識別番号, 被保険者番号, サービス提供年月,
                事業所番号, 通し番号);
        給付実績明細データリスト = get給付実績明細データ(入力識別番号, 被保険者番号, サービス提供年月,
                事業所番号, 通し番号);
        給付実績明細住所地特例データリスト = get給付実績明細住所地特例データ(入力識別番号, 被保険者番号, サービス提供年月,
                事業所番号, 通し番号);
        給付実績情報照会用データ.setCsData_Z(給付実績集計データリスト);
        給付実績情報照会用データ.setCsData_B(給付実績明細データリスト);
        給付実績情報照会用データ.setCsData_N(給付実績明細住所地特例データリスト);
        return 給付実績情報照会用データ;
    }

    /**
     * 給付実績集計データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 FlexibleYearMonth
     * @param 事業所番号 事業所番号
     * @param 通し番号 整理番号
     * @return 給付実績集計データ
     */
    public List<KyufujissekiShukei> get給付実績集計データ(NyuryokuShikibetsuNo 入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        List<KyufujissekiShukei> 給付実績集計データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3033KyufujissekiShukeiEntity> entityList = mapper.get給付実績集計データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月,
                        事業所番号, 通し番号));
        for (DbT3033KyufujissekiShukeiEntity entity : entityList) {
            KyufujissekiShukei 給付実績集計データ = new KyufujissekiShukei(entity);
            給付実績集計データリスト.add(給付実績集計データ);
        }
        return 給付実績集計データリスト;
    }

    /**
     * 給付実績明細データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param 通し番号 整理番号
     * @param サービス提供年月 サービス提供年月
     * @return 給付実績明細データ
     */
    public List<KyufujissekiMeisaiBusiness> get給付実績明細データ(NyuryokuShikibetsuNo 入力識別番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        List<KyufujissekiMeisaiBusiness> 給付実績明細データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiMeisaiRelateEntity> entityList = mapper.get給付実績明細データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月,
                        事業所番号, 通し番号));
        for (KyufujissekiMeisaiRelateEntity entity : entityList) {
            KyufujissekiMeisaiBusiness 給付実績明細データ = new KyufujissekiMeisaiBusiness();
            給付実績明細データ.set給付実績明細(new KyufujissekiMeisai(entity.get給付実績明細データ()));
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績明細データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績明細データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績明細データリスト.add(給付実績明細データ);
        }
        return 給付実績明細データリスト;
    }

    /**
     * 給付実績明細住所地特例データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param 通し番号 整理番号
     * @param サービス提供年月 サービス提供年月
     * @return 給付実績明細住所地特例データ
     */
    public List<KyufujissekiMeisaiJushochiTokureiBusiness> get給付実績明細住所地特例データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        List<KyufujissekiMeisaiJushochiTokureiBusiness> 給付実績明細住所地特例データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiMeisaiJushochiTokureiRelateEntity> entityList = mapper.get給付実績明細住所地特例データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufujissekiMeisaiJushochiTokureiRelateEntity entity : entityList) {
            KyufujissekiMeisaiJushochiTokureiBusiness 給付実績明細住所地特例データ = new KyufujissekiMeisaiJushochiTokureiBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績明細住所地特例データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績明細住所地特例データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績明細住所地特例データ.set給付実績明細住所地特例情報(new KyufujissekiMeisaiJushochiTokurei(
                    entity.get給付実績明細住所地特例データ()));
            給付実績明細住所地特例データリスト.add(給付実績明細住所地特例データ);
        }
        return 給付実績明細住所地特例データリスト;
    }

    /**
     * 給付実績福祉用具販売費データの取得処理です。
     *
     * @param 入力識別番号 入力識別番号
     * @param 被保険者番号 被保険者番号
     * @param 事業所番号 事業所番号
     * @param 通し番号 RString
     * @param サービス提供年月 サービス提供年月
     * @return 給付実績福祉用具販売費データ
     */
    public List<KyufujissekiFukushiYoguHanbaihiBusiness> get給付実績福祉用具販売費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiFukushiYoguHanbaihiBusiness> 給付実績福祉用具販売費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<KyufujissekiFukushiYoguHanbaihiBusinessRelateEntity> entityList = mapper.get給付実績福祉用具販売費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (KyufujissekiFukushiYoguHanbaihiBusinessRelateEntity entity : entityList) {
            KyufujissekiFukushiYoguHanbaihiBusiness 給付実績福祉用具販売費データ = new KyufujissekiFukushiYoguHanbaihiBusiness();
            if (entity.getServiceShuruiRyakusho() != null) {
                給付実績福祉用具販売費データ.setサービス種類略称(entity.getServiceShuruiRyakusho().getServiceShuruiRyakusho());
            } else {
                給付実績福祉用具販売費データ.setサービス種類略称(RString.EMPTY);
            }
            給付実績福祉用具販売費データ.set給付実績福祉用具販売費基本情報(
                    new KyufujissekiFukushiYoguHanbaihi(entity.get給付実績福祉用具販売費データ()));
            給付実績福祉用具販売費データリスト.add(給付実績福祉用具販売費データ);
        }
        return 給付実績福祉用具販売費データリスト;
    }

    /**
     * 給付実績緊急時施設療養データの取得処理です。
     *
     * @param 入力識別番号 NyuryokuShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 事業所番号 JigyoshaNo
     * @param 通し番号 RString
     * @return 給付実績緊急時施設療養データ
     */
    public List<KyufujissekiKinkyuShisetsuRyoyo> get給付実績緊急時施設療養データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiKinkyuShisetsuRyoyo> 給付実績緊急時施設療養データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity> entityList = mapper.get給付実績緊急時施設療養データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity entity : entityList) {
            KyufujissekiKinkyuShisetsuRyoyo 給付実績緊急時施設療養データ = new KyufujissekiKinkyuShisetsuRyoyo(entity);
            給付実績緊急時施設療養データリスト.add(給付実績緊急時施設療養データ);
        }
        return 給付実績緊急時施設療養データリスト;
    }

    /**
     * 給付実績所定疾患施設療養費等データの取得処理です。
     *
     * @param 入力識別番号 NyuryokuShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 事業所番号 JigyoshaNo
     * @param 通し番号 RString
     * @return 給付実績所定疾患施設療養費等データ
     */
    public List<KyufujissekiShoteiShikkanShisetsuRyoyo> ge給付実績所定疾患施設療養費等データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiShoteiShikkanShisetsuRyoyo> 給付実績所定疾患施設療養費等データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity> entityList = mapper.get給付実績所定疾患施設療養費等データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity : entityList) {
            KyufujissekiShoteiShikkanShisetsuRyoyo 給付実績所定疾患施設療養費等データ = new KyufujissekiShoteiShikkanShisetsuRyoyo(entity);
            給付実績所定疾患施設療養費等データリスト.add(給付実績所定疾患施設療養費等データ);
        }
        return 給付実績所定疾患施設療養費等データリスト;
    }

    /**
     * 給付実績特定診療費データの取得処理です。
     *
     * @param 入力識別番号 NyuryokuShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 事業所番号 JigyoshaNo
     * @param 通し番号 toString
     * @return 給付実績特定診療費データ
     */
    public List<KyufujissekiTokuteiSinryohi> get給付実績特定診療費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiTokuteiSinryohi> 給付実績特定診療費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3020KyufujissekiTokuteiSinryohiEntity> entityList = mapper.get給付実績特定診療費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (DbT3020KyufujissekiTokuteiSinryohiEntity entity : entityList) {
            KyufujissekiTokuteiSinryohi 給付実績特定診療費データ = new KyufujissekiTokuteiSinryohi(entity);
            給付実績特定診療費データリスト.add(給付実績特定診療費データ);
        }
        return 給付実績特定診療費データリスト;
    }

    /**
     * 給付実績特定診療費データの取得処理です。
     *
     * @param 入力識別番号 NyuryokuShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 事業所番号 JigyoshaNo
     * @param 通し番号 toString
     * @return 給付実績特定診療費_特別療養費データ
     */
    public List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> get給付実績特定診療費_特別療養費データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiTokuteiSinryoTokubetsuRyoyo> 給付実績特定診療費_特別療養費データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> entityList = mapper.get給付実績特定診療費_特別療養費データ(
                KyufuJissekiKensakuDataMapperParameter.createParameter_給付実績検索データ(
                        入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity : entityList) {
            KyufujissekiTokuteiSinryoTokubetsuRyoyo 給付実績特定診療費_特別療養費データ = new KyufujissekiTokuteiSinryoTokubetsuRyoyo(entity);
            給付実績特定診療費_特別療養費データリスト.add(給付実績特定診療費_特別療養費データ);
        }
        return 給付実績特定診療費_特別療養費データリスト;
    }

    /**
     * 給付実績食事費用データの取得処理です。
     *
     * @param 入力識別番号 NyuryokuShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 事業所番号 JigyoshaNo
     * @param 通し番号 toString
     * @return 給付実績食事費用データ
     */
    public List<KyufujissekiShokujiHiyo> get給付実績食事費用データ(NyuryokuShikibetsuNo 入力識別番号,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, JigyoshaNo 事業所番号, RString 通し番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号文字列.toString()));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage(サービス提供年月_文字列.toString()));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage(事業所番号文字列.toString()));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage(通し番号文字列.toString()));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage(識別番号文字列.toString()));
        List<KyufujissekiShokujiHiyo> 給付実績食事費用データリスト = new ArrayList<>();
        IKyufuJissekiShokaiMapper mapper = mapperProvider.create(IKyufuJissekiShokaiMapper.class);
        List<DbT3022KyufujissekiShokujiHiyoEntity> entityList = mapper.get給付実績食事費用データ(KyufuJissekiKensakuDataMapperParameter.
                createParameter_給付実績検索データ(入力識別番号, 被保険者番号, サービス提供年月, 事業所番号, 通し番号));
        for (DbT3022KyufujissekiShokujiHiyoEntity entity : entityList) {
            KyufujissekiShokujiHiyo 給付実績食事費用データ = new KyufujissekiShokujiHiyo(entity);
            給付実績食事費用データリスト.add(給付実績食事費用データ);
        }
        return 給付実績食事費用データリスト;
    }
}
