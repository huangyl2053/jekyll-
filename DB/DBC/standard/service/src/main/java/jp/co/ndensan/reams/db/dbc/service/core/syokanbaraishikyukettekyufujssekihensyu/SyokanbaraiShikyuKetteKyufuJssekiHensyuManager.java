/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraishikyukettekyufujssekihensyu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu.KyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.shikibetsunokubon.ShikibetsuNoKubon;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3106KyufujissekiMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraishikyukettekyufujssekihensyu.DealKyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3018KyufujissekiMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3019KyufujissekiKinkyuShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3020KyufujissekiTokuteiSinryohiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3022KyufujissekiShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3025KyufujissekiKyotakuServiceDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3033KyufujissekiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3106KyufujissekiMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraishikyukettekyufujssekihensyu.ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払支給決定給付実績編集クラスです。
 */
public class SyokanbaraiShikyuKetteKyufuJssekiHensyuManager {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private final DbT3017KyufujissekiKihonDac 給付実績基本Dac;
    private final DbT3018KyufujissekiMeisaiDac 給付実績明細Dac;
    private final DbT3106KyufujissekiMeisaiJushochiTokureiDac 住所地特例Dac;
    private final DbT3019KyufujissekiKinkyuShisetsuRyoyoDac 給付実績緊急時施設療養Dac;
    private final DbT3020KyufujissekiTokuteiSinryohiDac 給付実績特定診療費Dac;
    private final DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac 特別療養費Dac;
    private final DbT3022KyufujissekiShokujiHiyoDac 給付実績食事費用Dac;
    private final DbT3025KyufujissekiKyotakuServiceDac 給付実績居宅サービス計画費Dac;
    private final DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac 給付実績特定入所者介護サービス費用Dac;
    private final DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac 給付実績社会福祉法人軽減額Dac;
    private final DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac 給付実績所定疾患施設療養費等Dac;
    private final DbT3033KyufujissekiShukeiDac 給付実績集計Dac;
    private static final RString モード_登録 = new RString("登録");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_差額登録 = new RString("差額登録");
    private static final RString モード_削除 = new RString("削除");
    private static final RString モード_審査 = new RString("審査");

    /**
     * コンストラクタです。
     */
    SyokanbaraiShikyuKetteKyufuJssekiHensyuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
        this.給付実績基本Dac = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);
        this.給付実績明細Dac = InstanceProvider.create(DbT3018KyufujissekiMeisaiDac.class);
        this.住所地特例Dac = InstanceProvider.create(DbT3106KyufujissekiMeisaiJushochiTokureiDac.class);
        this.給付実績緊急時施設療養Dac = InstanceProvider.create(DbT3019KyufujissekiKinkyuShisetsuRyoyoDac.class);
        this.給付実績特定診療費Dac = InstanceProvider.create(DbT3020KyufujissekiTokuteiSinryohiDac.class);
        this.特別療養費Dac = InstanceProvider.create(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac.class);
        this.給付実績食事費用Dac = InstanceProvider.create(DbT3022KyufujissekiShokujiHiyoDac.class);
        this.給付実績居宅サービス計画費Dac = InstanceProvider.create(DbT3025KyufujissekiKyotakuServiceDac.class);
        this.給付実績特定入所者介護サービス費用Dac
                = InstanceProvider.create(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac.class);
        this.給付実績社会福祉法人軽減額Dac
                = InstanceProvider.create(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac.class);
        this.給付実績所定疾患施設療養費等Dac
                = InstanceProvider.create(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac.class);
        this.給付実績集計Dac = InstanceProvider.create(DbT3033KyufujissekiShukeiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SyokanbaraiShikyuKetteKyufuJssekiHensyuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SyokanbaraiShikyuKetteKyufuJssekiHensyuManager}のインスタンス
     */
    public static SyokanbaraiShikyuKetteKyufuJssekiHensyuManager createInstance() {

        return InstanceProvider.create(SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 受給者台帳Dac
     * @param 識別番号管理Dac
     * @param 給付実績基本Dac
     * @param 給付実績明細Dac
     * @param 住所地特例Dac
     * @param 給付実績緊急時施設療養Dac
     * @param 給付実績特定診療費Dac
     * @param 特別療養費Dac
     * @param 給付実績食事費用Dac
     * @param 給付実績居宅サービス計画費Dac
     * @param 給付実績集計Dac
     * @param 給付実績特定入所者介護サービス費用Dac
     * @param 給付実績所定疾患施設療養費等Dac
     * @param 給付実績社会福祉法人軽減額Dac
     */
    SyokanbaraiShikyuKetteKyufuJssekiHensyuManager(MapperProvider mapperProvider,
            DbT4001JukyushaDaichoDac 受給者台帳Dac,
            DbT3118ShikibetsuNoKanriDac 識別番号管理Dac,
            DbT3017KyufujissekiKihonDac 給付実績基本Dac,
            DbT3018KyufujissekiMeisaiDac 給付実績明細Dac,
            DbT3106KyufujissekiMeisaiJushochiTokureiDac 住所地特例Dac,
            DbT3019KyufujissekiKinkyuShisetsuRyoyoDac 給付実績緊急時施設療養Dac,
            DbT3020KyufujissekiTokuteiSinryohiDac 給付実績特定診療費Dac,
            DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac 特別療養費Dac,
            DbT3022KyufujissekiShokujiHiyoDac 給付実績食事費用Dac,
            DbT3025KyufujissekiKyotakuServiceDac 給付実績居宅サービス計画費Dac,
            DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoDac 給付実績特定入所者介護サービス費用Dac,
            DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuDac 給付実績社会福祉法人軽減額Dac,
            DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoDac 給付実績所定疾患施設療養費等Dac,
            DbT3033KyufujissekiShukeiDac 給付実績集計Dac
    ) {
        this.mapperProvider = mapperProvider;
        this.受給者台帳Dac = 受給者台帳Dac;
        this.識別番号管理Dac = 識別番号管理Dac;
        this.給付実績基本Dac = 給付実績基本Dac;
        this.給付実績明細Dac = 給付実績明細Dac;
        this.住所地特例Dac = 住所地特例Dac;
        this.給付実績緊急時施設療養Dac = 給付実績緊急時施設療養Dac;
        this.給付実績特定診療費Dac = 給付実績特定診療費Dac;
        this.特別療養費Dac = 特別療養費Dac;
        this.給付実績食事費用Dac = 給付実績食事費用Dac;
        this.給付実績居宅サービス計画費Dac = 給付実績居宅サービス計画費Dac;
        this.給付実績特定入所者介護サービス費用Dac = 給付実績特定入所者介護サービス費用Dac;
        this.給付実績社会福祉法人軽減額Dac = 給付実績社会福祉法人軽減額Dac;
        this.給付実績所定疾患施設療養費等Dac = 給付実績所定疾患施設療養費等Dac;
        this.給付実績集計Dac = 給付実績集計Dac;
    }

    /**
     * 給付実績処理
     *
     * @param 画面モード
     * @param 識別コード
     * @param entity
     * @param 修正前支給区分
     */
    public void dealKyufujisseki(RString 画面モード, ShikibetsuCode 識別コード, KyufujissekiEntity entity,
            RString 修正前支給区分) throws ApplicationException {

        RString 給付実績情報作成区分コード;
        if (モード_登録.equals(画面モード)
                && ShikyuFushikyuKubun.支給.getコード().equals(entity.get支給区分())) {
            給付実績情報作成区分コード = new RString("1");
            給付実績追加(識別コード, 給付実績情報作成区分コード, entity);
        } else if (モード_修正.equals(画面モード) || モード_差額登録.equals(画面モード)) {
            if (ShikyuFushikyuKubun.不支給.getコード().equals(修正前支給区分)
                    && ShikyuFushikyuKubun.支給.getコード().equals(entity.get支給区分())) {
                給付実績情報作成区分コード = new RString("1");
                給付実績追加(識別コード, 給付実績情報作成区分コード, entity);
            } else if (ShikyuFushikyuKubun.支給.getコード().equals(修正前支給区分)
                    && ShikyuFushikyuKubun.支給.getコード().equals(entity.get支給区分())) {
                給付実績情報作成区分コード = new RString("2");
                給付実績追加(識別コード, 給付実績情報作成区分コード, entity);
            } else if (ShikyuFushikyuKubun.支給.getコード().equals(修正前支給区分)
                    && ShikyuFushikyuKubun.不支給.getコード().equals(entity.get支給区分())) {
                給付実績情報作成区分コード = new RString("3");
                給付実績追加(識別コード, 給付実績情報作成区分コード, entity);
            }
        } else if (モード_削除.equals(画面モード)
                && ShikyuFushikyuKubun.支給.getコード().equals(entity.get支給区分())) {
            給付実績情報作成区分コード = new RString("3");
            給付実績追加(識別コード, 給付実績情報作成区分コード, entity);
        } else if (モード_審査.equals(画面モード)) {
            給付実績情報作成区分コード = new RString("1");
            給付実績追加(識別コード, 給付実績情報作成区分コード, entity);
        }
    }

    /**
     * 給付実績追加
     *
     * @param 識別コード
     * @param 給付実績情報作成区分コード
     * @param entity
     */
    private void 給付実績追加(ShikibetsuCode 識別コード, RString 給付実績情報作成区分コード,
            KyufujissekiEntity entity) throws ApplicationException {

        RString 通し番号 = Saiban.get(SubGyomuCode.DBC介護給付,
                SaibanHanyokeyName.実績管理番号.getコード()).nextString();
        if (通し番号 == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace("最新番号").evaluate());
        }

        ShikibetsuTaishoPSMSearchKeyBuilder builder
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        builder.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey key = builder.build();
        SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter parameter
                = new SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter(key);
        ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper mapper
                = mapperProvider.create(ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper.class);
        DealKyufujissekiEntity 宛名 = mapper.get宛名(parameter);
        FlexibleDate 生年月日YND = null;
        RString 性別コード = null;
        if (宛名 != null) {
            生年月日YND = 宛名.get生年月日();
            性別コード = 宛名.get性別コード();
        }

        DbT4001JukyushaDaichoEntity dbT4001entity = 受給者台帳Dac.select認定有効期間(entity.get被保険者番号());
        if (dbT4001entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace("認定有効期間").evaluate());
        }

        RString 識別番号区分 = ShikibetsuNoKubon.交換情報識別番号.getコード();
        FlexibleYearMonth 適用年月 = entity.getサービス提供年月();
        DbT3118ShikibetsuNoKanriEntity dbT3118entity
                = 識別番号管理Dac.select交換情報識別番号(識別番号区分, 適用年月);
        if (dbT3118entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace("交換情報識別番号").evaluate());
        }

        KokanShikibetsuNo 交換情報識別番号 = new KokanShikibetsuNo(dbT3118entity.getShikibetsuNo());

        save給付実績基本(給付実績情報作成区分コード, 交換情報識別番号, 通し番号, 生年月日YND, 性別コード,
                dbT4001entity, entity);
        save給付実績明細(交換情報識別番号, 通し番号, entity);
        save住所地特例(交換情報識別番号, 通し番号, entity);
        save給付実績緊急時施設療養(交換情報識別番号, 通し番号, entity);
        save給付実績特定診療費(交換情報識別番号, 通し番号, entity);
        save特別療養費(交換情報識別番号, 通し番号, entity);
        save給付実績食事費用(交換情報識別番号, 通し番号, entity);
        save給付実績居宅サービス計画費(交換情報識別番号, 通し番号, entity);
        save給付実績特定入所者介護サービス費用(交換情報識別番号, 通し番号, entity);
        save給付実績社会福祉法人軽減額(交換情報識別番号, 通し番号, entity);
        save給付実績所定疾患施設療養費等(交換情報識別番号, 通し番号, entity);
        save給付実績集計(交換情報識別番号, 通し番号, entity);

    }

    /**
     * 給付実績基本テーブルにデータを追加する
     *
     * @param 給付実績情報作成区分コード
     * @param 交換情報識別番号
     * @param 通し番号
     * @param 生年月日YND
     * @param 性別コード
     * @param DbT4001entity
     * @param entity
     */
    private void save給付実績基本(RString 給付実績情報作成区分コード, KokanShikibetsuNo 交換情報識別番号,
            RString 通し番号, FlexibleDate 生年月日YND, RString 性別コード,
            DbT4001JukyushaDaichoEntity DbT4001entity, KyufujissekiEntity entity) {

        DbT3017KyufujissekiKihonEntity dbT3017entity = new DbT3017KyufujissekiKihonEntity();

        dbT3017entity.setKokanShikibetsuNo(交換情報識別番号);
        dbT3017entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(entity.get入力識別番号()));
        dbT3017entity.setRecodeShubetsuCode(new RString("01"));
        dbT3017entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        dbT3017entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
        dbT3017entity.setHiHokenshaNo(entity.get請求基本被保険者番号());
        dbT3017entity.setServiceTeikyoYM(entity.get請求基本サービス提供年月());
        dbT3017entity.setKyufuJissekiKubunCode(new RString("2"));
        dbT3017entity.setJigyoshoNo(entity.get事業所番号());
        dbT3017entity.setToshiNo(通し番号);
        dbT3017entity.setUmareYMD(生年月日YND);
        dbT3017entity.setSeibetsuCode(性別コード);
        dbT3017entity.setNinteiYukoKaishiYMD(DbT4001entity.getNinteiYukoKikanKaishiYMD());
        dbT3017entity.setNinteiYukoShuryoYMD(DbT4001entity.getNinteiYukoKikanShuryoYMD());
        dbT3017entity.setKaishiYMD(entity.get開始年月日());
        dbT3017entity.setChushiYMD(entity.get中止年月日());
        dbT3017entity.setChushiRiyuNyushomaeJyokyoCode(entity.get中止理由());
        dbT3017entity.setNyushoYMD(entity.get入所院年月日());
        dbT3017entity.setTaishoYMD(entity.get退所院年月日());
        dbT3017entity.setNyushoJitsunissu(entity.get入所院実日数());
        dbT3017entity.setGaihakuNissu(entity.get外泊日数());
        dbT3017entity.setTaishogoJotaiCode(entity.get退所院後の状態コード());
        dbT3017entity.setHokenKyufuritsu(entity.get保険給付率());
        dbT3017entity.setMaeHokenServiceTanisu(new Decimal(entity.get前保険サービス単位数()));
        dbT3017entity.setMaeHokenSeikyugaku(new Decimal(entity.get前保険請求額()));
        dbT3017entity.setMaeHokenRiyoshaFutangaku(new Decimal(entity.get前保険負担額()));
        dbT3017entity.setAtoHokenServiceTanisu(new Decimal(entity.get後保険サービス単位数()));
        dbT3017entity.setAtoHokenSeikyugaku(new Decimal(entity.get後保険請求額()));
        dbT3017entity.setAtoHokenRiyoshaFutangaku(new Decimal(entity.get後保険負担額()));
        dbT3017entity.setShinsaYM(entity.get審査年月().getYearMonth());
        dbT3017entity.setSeiriNo(entity.get整理番号());
        dbT3017entity.setSofuYM(entity.get審査年月().getYearMonth());
        dbT3017entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(false);
        dbT3017entity.setState(EntityDataState.Added);
        給付実績基本Dac.save(dbT3017entity);
    }

    /**
     * 給付実績明細テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績明細(KokanShikibetsuNo 交換情報識別番号, RString 通し番号, KyufujissekiEntity entity) {

        DbT3018KyufujissekiMeisaiEntity dbT3018entity = new DbT3018KyufujissekiMeisaiEntity();
        List<DbT3039ShokanMeisaiEntity> 償還払請求明細List = entity.get償還払請求明細List();
        if (償還払請求明細List != null && !償還払請求明細List.isEmpty()) {
            for (DbT3039ShokanMeisaiEntity 償還払請求明細 : 償還払請求明細List) {
                dbT3018entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3018entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(償還払請求明細.getYoshikiNo()));
                dbT3018entity.setRecodeShubetsuCode(new RString("02"));
                dbT3018entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3018entity.setHiHokenshaNo(償還払請求明細.getHiHokenshaNo());
                dbT3018entity.setServiceTeikyoYM(償還払請求明細.getServiceTeikyoYM());
                dbT3018entity.setJigyoshoNo(償還払請求明細.getJigyoshaNo());
                dbT3018entity.setToshiNo(通し番号);
                dbT3018entity.setServiceShuruiCode(償還払請求明細.getServiceShuruiCode());
                dbT3018entity.setServiceKomokuCode(償還払請求明細.getServiceKomokuCode());
                dbT3018entity.setTanisu(償還払請求明細.getTanisu());
                dbT3018entity.setNissuKaisu(償還払請求明細.getNissuKaisu());
                dbT3018entity.setServiceTanisu(new Decimal(償還払請求明細.getServiceTanisu()));
                dbT3018entity.setTekiyo(償還払請求明細.getTekiyo());
                dbT3018entity.setAtoTanisu(償還払請求明細.getTanisu());
                dbT3018entity.setAtoNissuKaisu(償還払請求明細.getNissuKaisu());
                dbT3018entity.setAtoServiceTanisu(new Decimal(償還払請求明細.getServiceTanisu()));
                dbT3018entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3018entity.setSeiriNo(償還払請求明細.getSeiriNp());
                dbT3018entity.setState(EntityDataState.Added);
                給付実績明細Dac.save(dbT3018entity);
            }
        }
    }

    /**
     * 給付実績明細・住所地特例テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save住所地特例(KokanShikibetsuNo 交換情報識別番号, RString 通し番号, KyufujissekiEntity entity) {

        DbT3106KyufujissekiMeisaiJushochiTokureiEntity dbT3106entity
                = new DbT3106KyufujissekiMeisaiJushochiTokureiEntity();
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> 住所地特例List = entity.get住所地特例List();
        if (住所地特例List != null && !住所地特例List.isEmpty()) {
            for (DbT3107ShokanMeisaiJushochiTokureiEntity 住所地特例 : 住所地特例List) {
                dbT3106entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3106entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(住所地特例.getYoshikiNo()));
                dbT3106entity.setRecodeShubetsuCode(new RString("14"));
                dbT3106entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3106entity.setHiHokenshaNo(住所地特例.getHiHokenshaNo());
                dbT3106entity.setServiceTeikyoYM(住所地特例.getServiceTeikyoYM());
                dbT3106entity.setJigyoshoNo(住所地特例.getJigyoshaNo());
                dbT3106entity.setToshiNo(通し番号);
                dbT3106entity.setServiceShuruiCode(住所地特例.getServiceShuruiCode());
                dbT3106entity.setServiceKomokuCode(住所地特例.getServiceKomokuCode());
                dbT3106entity.setTanisu(住所地特例.getTanisu());
                dbT3106entity.setNissuKaisu(住所地特例.getNissuKaisu());
                dbT3106entity.setServiceTanisu(住所地特例.getServiceTanisu());
                dbT3106entity.setShisetsuShozaiHokenshaNo(住所地特例.getShisetsuShozaiHokenshaNo());
                dbT3106entity.setTekiyo(住所地特例.getTekiyo());
                dbT3106entity.setAtoTanisu(住所地特例.getTanisu());
                dbT3106entity.setAtoNissuKaisu(住所地特例.getNissuKaisu());
                dbT3106entity.setAtoServiceTanisu(住所地特例.getServiceTanisu());
                dbT3106entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3106entity.setSeiriNo(住所地特例.getSeiriNp());
                dbT3106entity.setState(EntityDataState.Added);
                住所地特例Dac.save(dbT3106entity);
            }
        }
    }

    /**
     * 給付実績緊急時施設療養テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績緊急時施設療養(KokanShikibetsuNo 交換情報識別番号, RString 通し番号,
            KyufujissekiEntity entity) {

        int 連番 = 0;
        DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity dbT3019entity
                = new DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity();
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> 償還払請求緊急時施設療養List
                = entity.get償還払請求緊急時施設療養List();
        if (償還払請求緊急時施設療養List != null && !償還払請求緊急時施設療養List.isEmpty()) {
            for (DbT3040ShokanKinkyuShisetsuRyoyoEntity 償還払請求緊急時施設療養 : 償還払請求緊急時施設療養List) {
                連番 = 連番 + 1;
                dbT3019entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3019entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(償還払請求緊急時施設療養.getYoshikiNo()));
                dbT3019entity.setRecodeShubetsuCode(new RString("03"));
                dbT3019entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3019entity.setHiHokenshaNo(償還払請求緊急時施設療養.getHiHokenshaNo());
                dbT3019entity.setServiceTeikyoYM(償還払請求緊急時施設療養.getServiceTeikyoYM());
                dbT3019entity.setJigyoshoNo(償還払請求緊急時施設療養.getJigyoshaNo());
                dbT3019entity.setToshiNo(通し番号);
                dbT3019entity.setRecodeJunjiNo(new RString(String.valueOf(new RString(String.valueOf(連番)))));
                dbT3019entity.setKinkyuShobyoName1(償還払請求緊急時施設療養.getKinkyuShobyoName1());
                dbT3019entity.setKinkyuShobyoName2(償還払請求緊急時施設療養.getKinkyuShobyoName2());
                dbT3019entity.setKinkyuShobyoName3(償還払請求緊急時施設療養.getKinkyuShobyoName3());
                dbT3019entity.setKinkyuChiryoKaishiYMD1(償還払請求緊急時施設療養.getKinkyuChiryoKaishiYMD1());
                dbT3019entity.setKinkyuChiryoKaishiYMD2(償還払請求緊急時施設療養.getKinkyuChiryoKaishiYMD2());
                dbT3019entity.setKinkyuChiryoKaishiYMD3(償還払請求緊急時施設療養.getKinkyuChiryoKaishiYMD3());
                dbT3019entity.setOshinNissu(償還払請求緊急時施設療養.getOshinNissu());
                dbT3019entity.setOshinIryoKikanName(償還払請求緊急時施設療養.getOshinIryoKikanName());
                dbT3019entity.setTsuinNissu(償還払請求緊急時施設療養.getTsuinNissu());
                dbT3019entity.setTsuinIryoKikanName(償還払請求緊急時施設療養.getTsuinKikanName());
                dbT3019entity.setKinkyuChiryoKanriTanisu(償還払請求緊急時施設療養.getKinkyuChiryoKanriTanisu());
                dbT3019entity.setKinkyuChiryoKanriNissu(償還払請求緊急時施設療養.getKinkyuChiryoKanriNissu());
                dbT3019entity.setKinkyuChiryoKanriSubTotal(償還払請求緊急時施設療養.getKinkyuChiryoKanriSubTotal());
                dbT3019entity.setRehabilitationTensu(償還払請求緊急時施設療養.getRehabilitationTanisu());
                dbT3019entity.setShochiTensu(償還払請求緊急時施設療養.getShochiTanisu());
                dbT3019entity.setShujutsuTensu(償還払請求緊急時施設療養.getShujutsuTanisu());
                dbT3019entity.setMasuiTensu(償還払請求緊急時施設療養.getMasuiTanisu());
                dbT3019entity.setHoshasenChiryoTensu(償還払請求緊急時施設療養.getHoshasenChiryoTanisu());
                dbT3019entity.setTekiyo1(償還払請求緊急時施設療養.getTekiyo1());
                dbT3019entity.setTekiyo2(償還払請求緊急時施設療養.getTekiyo2());
                dbT3019entity.setTekiyo3(償還払請求緊急時施設療養.getTekiyo3());
                dbT3019entity.setTekiyo4(償還払請求緊急時施設療養.getTekiyo4());
                dbT3019entity.setTekiyo5(償還払請求緊急時施設療養.getTekiyo5());
                dbT3019entity.setTekiyo6(償還払請求緊急時施設療養.getTekiyo6());
                dbT3019entity.setTekiyo7(償還払請求緊急時施設療養.getTekiyo7());
                dbT3019entity.setTekiyo8(償還払請求緊急時施設療養.getTekiyo8());
                dbT3019entity.setTekiyo9(償還払請求緊急時施設療養.getTekiyo9());
                dbT3019entity.setTekiyo10(償還払請求緊急時施設療養.getTekiyo10());
                dbT3019entity.setTekiyo11(償還払請求緊急時施設療養.getTekiyo11());
                dbT3019entity.setTekiyo12(償還払請求緊急時施設療養.getTekiyo12());
                dbT3019entity.setTekiyo13(償還払請求緊急時施設療養.getTekiyo13());
                dbT3019entity.setTekiyo14(償還払請求緊急時施設療養.getTekiyo14());
                dbT3019entity.setTekiyo15(償還払請求緊急時施設療養.getTekiyo15());
                dbT3019entity.setTekiyo16(償還払請求緊急時施設療養.getTekiyo16());
                dbT3019entity.setTekiyo17(償還払請求緊急時施設療養.getTekiyo17());
                dbT3019entity.setTekiyo18(償還払請求緊急時施設療養.getTekiyo18());
                dbT3019entity.setTekiyo19(償還払請求緊急時施設療養.getTekiyo19());
                dbT3019entity.setTekiyo20(償還払請求緊急時施設療養.getTekiyo20());
                dbT3019entity.setKinkyuShisetsuRyoyoHiTotalTensu(
                        償還払請求緊急時施設療養.getKinkyuShisetsuRyoyohiTotalTanisu());
                dbT3019entity.setAtoOshinNissu(償還払請求緊急時施設療養.getOshinNissu());
                dbT3019entity.setAtoTsuinNissu(償還払請求緊急時施設療養.getTsuinNissu());
                dbT3019entity.setAtoKinkyuChiryoKanriTanisu(償還払請求緊急時施設療養.getKinkyuChiryoKanriTanisu());
                dbT3019entity.setAtoKinkyuChiryoKanriNissu(償還払請求緊急時施設療養.getKinkyuChiryoKanriNissu());
                dbT3019entity.setAtoRehabilitationTensu(償還払請求緊急時施設療養.getRehabilitationTanisu());
                dbT3019entity.setAtoShochiTensu(償還払請求緊急時施設療養.getShochiTanisu());
                dbT3019entity.setAtoShujutsuTensu(償還払請求緊急時施設療養.getShujutsuTanisu());
                dbT3019entity.setAtoMasuiTensu(償還払請求緊急時施設療養.getMasuiTanisu());
                dbT3019entity.setAtoHoshasenChiryoTensu(償還払請求緊急時施設療養.getHoshasenChiryoTanisu());
                dbT3019entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3019entity.setSeiriNo(償還払請求緊急時施設療養.getSeiriNo());
                dbT3019entity.setSaishinsaKaisu(Decimal.ZERO);
                dbT3019entity.setState(EntityDataState.Added);
                給付実績緊急時施設療養Dac.save(dbT3019entity);
            }
        }
    }

    /**
     * 給付実績特定診療費テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績特定診療費(KokanShikibetsuNo 交換情報識別番号,
            RString 通し番号, KyufujissekiEntity entity) {

        int 連番 = 0;
        DbT3020KyufujissekiTokuteiSinryohiEntity dbT3020entity = new DbT3020KyufujissekiTokuteiSinryohiEntity();
        List<DbT3041ShokanTokuteiShinryohiEntity> 償還払請求特定診療費List = entity.get償還払請求特定診療費List();
        if (償還払請求特定診療費List != null && !償還払請求特定診療費List.isEmpty()) {
            for (DbT3041ShokanTokuteiShinryohiEntity 償還払請求特定診療費 : 償還払請求特定診療費List) {
                連番 = 連番 + 1;
                dbT3020entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3020entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(償還払請求特定診療費.getYoshikiNo()));
                dbT3020entity.setRecodeShubetsuCode(new RString("04"));
                dbT3020entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3020entity.setHiHokenshaNo(償還払請求特定診療費.getHiHokenshaNo());
                dbT3020entity.setServiceTeikyoYM(償還払請求特定診療費.getServiceTeikyoYM());
                dbT3020entity.setJigyoshoNo(償還払請求特定診療費.getJigyoshaNo());
                dbT3020entity.setToshiNo(通し番号);
                dbT3020entity.setRecodeJunjiNo(new RString(String.valueOf(連番)));
                dbT3020entity.setShobyoName(償還払請求特定診療費.getShobyoName());
                dbT3020entity.setHokenShidoKanriryo(償還払請求特定診療費.getShidoKanriryoTanisu());
                dbT3020entity.setHokenTanjunXsen(償還払請求特定診療費.getTanjunXsenTanisu());
                dbT3020entity.setHokenRehabilitation(償還払請求特定診療費.getRehabilitationTanisu());
                dbT3020entity.setHokenSeishinkaSemmonRyoho(償還払請求特定診療費.getSeishinkaSemmonRyoyohouTanisu());
                dbT3020entity.setHokenTotalTanisu(償還払請求特定診療費.getTotalTanisu());
                dbT3020entity.setTekiyo1(償還払請求特定診療費.getTekiyo1());
                dbT3020entity.setTekiyo2(償還払請求特定診療費.getTekiyo2());
                dbT3020entity.setTekiyo3(償還払請求特定診療費.getTekiyo3());
                dbT3020entity.setTekiyo4(償還払請求特定診療費.getTekiyo4());
                dbT3020entity.setTekiyo5(償還払請求特定診療費.getTekiyo5());
                dbT3020entity.setTekiyo6(償還払請求特定診療費.getTekiyo6());
                dbT3020entity.setTekiyo7(償還払請求特定診療費.getTekiyo7());
                dbT3020entity.setTekiyo8(償還払請求特定診療費.getTekiyo8());
                dbT3020entity.setTekiyo9(償還払請求特定診療費.getTekiyo9());
                dbT3020entity.setTekiyo10(償還払請求特定診療費.getTekiyo10());
                dbT3020entity.setTekiyo11(償還払請求特定診療費.getTekiyo11());
                dbT3020entity.setTekiyo12(償還払請求特定診療費.getTekiyo12());
                dbT3020entity.setTekiyo13(償還払請求特定診療費.getTekiyo13());
                dbT3020entity.setTekiyo14(償還払請求特定診療費.getTekiyo14());
                dbT3020entity.setTekiyo15(償還払請求特定診療費.getTekiyo15());
                dbT3020entity.setTekiyo16(償還払請求特定診療費.getTekiyo16());
                dbT3020entity.setTekiyo17(償還払請求特定診療費.getTekiyo17());
                dbT3020entity.setTekiyo18(償還払請求特定診療費.getTekiyo18());
                dbT3020entity.setTekiyo19(償還払請求特定診療費.getTekiyo19());
                dbT3020entity.setTekiyo20(償還払請求特定診療費.getTekiyo20());
                dbT3020entity.setAtoHokenShidoKanriryo(償還払請求特定診療費.getShidoKanriryoTanisu());
                dbT3020entity.setAtoHokenTanjunXsen(償還払請求特定診療費.getTanjunXsenTanisu());
                dbT3020entity.setAtoHokenRehabilitation(償還払請求特定診療費.getRehabilitationTanisu());
                dbT3020entity.setAtoHokenSeishinkaSemmonRyoho(償還払請求特定診療費.getSeishinkaSemmonRyoyohouTanisu());
                dbT3020entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3020entity.setSeiriNo(償還払請求特定診療費.getSeiriNo());
                dbT3020entity.setState(EntityDataState.Added);
                給付実績特定診療費Dac.save(dbT3020entity);
            }
        }
    }

    /**
     * 給付実績特定診療費・特別療養費テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save特別療養費(KokanShikibetsuNo 交換情報識別番号, RString 通し番号, KyufujissekiEntity entity) {

        int 連番 = 0;
        DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity dbT3021entity
                = new DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity();
        List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> 特別療養費List = entity.get特別療養費List();
        if (特別療養費List != null && !特別療養費List.isEmpty()) {
            for (DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity 特別療養費 : 特別療養費List) {
                連番 = 連番 + 1;
                dbT3021entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3021entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(特別療養費.getYoshikiNo()));
                dbT3021entity.setRecodeShubetsuCode(new RString("04"));
                dbT3021entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3021entity.setHiHokenshaNo(特別療養費.getHiHokenshaNo());
                dbT3021entity.setServiceTeikyoYM(特別療養費.getServiceTeikyoYM());
                dbT3021entity.setJigyoshoNo(特別療養費.getJigyoshaNo());
                dbT3021entity.setToshiNo(通し番号);
                dbT3021entity.setRecodeJunjiNo(new RString(String.valueOf(連番)));
                dbT3021entity.setShobyoName(特別療養費.getShobyoName());
                dbT3021entity.setShikibetsuNo(特別療養費.getShikibetsuNo());
                dbT3021entity.setTanisu(特別療養費.getTanisu());
                dbT3021entity.setHokenKaisu(特別療養費.getKaisu());
                dbT3021entity.setHokenServiceTanisu(特別療養費.getServiceTanisu());
                dbT3021entity.setHokenTotalTanisu(特別療養費.getTotalTanisu());
                dbT3021entity.setTekiyo(特別療養費.getTekiyo());
                dbT3021entity.setAtoTanisu(特別療養費.getTanisu());
                dbT3021entity.setAtoHokenKaisu(特別療養費.getKaisu());
                dbT3021entity.setAtoHokenServiceTanisu(特別療養費.getServiceTanisu());
                dbT3021entity.setAtoHokenTotalTanisu(特別療養費.getTotalTanisu());
                dbT3021entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3021entity.setSeiriNo(特別療養費.getSeiriNo());
                dbT3021entity.setState(EntityDataState.Added);
                特別療養費Dac.save(dbT3021entity);
            }
        }
    }

    /**
     * 給付実績食事費用テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績食事費用(KokanShikibetsuNo 交換情報識別番号, RString 通し番号,
            KyufujissekiEntity entity) {

        DbT3022KyufujissekiShokujiHiyoEntity dbT3022entity = new DbT3022KyufujissekiShokujiHiyoEntity();
        List<DbT3043ShokanShokujiHiyoEntity> 償還払請求食事費用List = entity.get給付実績食事費用List();
        if (償還払請求食事費用List != null && !償還払請求食事費用List.isEmpty()) {
            for (DbT3043ShokanShokujiHiyoEntity 償還払請求食事費用 : 償還払請求食事費用List) {
                dbT3022entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3022entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(償還払請求食事費用.getYoshikiNo()));
                dbT3022entity.setRecodeShubetsuCode(new RString("05"));
                dbT3022entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3022entity.setHiHokenshaNo(償還払請求食事費用.getHiHokenshaNo());
                dbT3022entity.setServiceTeikyoYM(償還払請求食事費用.getServiceTeikyoYM());
                dbT3022entity.setJigyoshoNo(償還払請求食事費用.getJigyoshaNo());
                dbT3022entity.setToshiNo(通し番号);
                dbT3022entity.setKihonTeikyoNissu(償還払請求食事費用.getKihonTeikyoNissu());
                dbT3022entity.setKihonTeikyoTanka(償還払請求食事費用.getKihonTeikyoTanka());
                dbT3022entity.setKihonTeikyoKingaku(new Decimal(償還払請求食事費用.getKihonTeikyoKingaku()));
                dbT3022entity.setTokubestuTeikyoNissu(償還払請求食事費用.getTokubetsuTeikyoNissu());
                dbT3022entity.setTokubestuTeikyoTanka(償還払請求食事費用.getTokubetsuTeikyoTanka());
                dbT3022entity.setTokubestuTeikyoKingaku(new Decimal(償還払請求食事費用.getTokubetsuTeikyoKingaku()));
                dbT3022entity.setSyokujiTeikyoNissu(償還払請求食事費用.getShokujiTeikyoTotalNissu());
                dbT3022entity.setSyokujiTeikyohiTotal(new Decimal(償還払請求食事費用.getShokujiTeikyohiTotal()));
                dbT3022entity.setGetsugakuHyojunFutanGaku(
                        new Decimal(償還払請求食事費用.getGetsugakuHyojunFutangaku()));
                dbT3022entity.setSyokujiTeikyohiSeikyugaku(
                        new Decimal(償還払請求食事費用.getShokujiTeikyohiSeikyugaku()));
                dbT3022entity.setNichigakuHyojunFutanGaku(償還払請求食事費用.getNichigakuHyojunFutangaku());
                dbT3022entity.setAtoKihonTeikyoTanka(償還払請求食事費用.getKihonTeikyoTanka());
                dbT3022entity.setAtoTokubestuTeikyoTanka(償還払請求食事費用.getTokubetsuTeikyoTanka());
                dbT3022entity.setAtoSyokujiTeikyohiSeikyugaku(
                        new Decimal(償還払請求食事費用.getShokujiTeikyohiSeikyugaku()));
                dbT3022entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3022entity.setSeiriNo(償還払請求食事費用.getSeiriNp());
                dbT3022entity.setState(EntityDataState.Added);
                給付実績食事費用Dac.save(dbT3022entity);
            }
        }
    }

    /**
     * 給付実績居宅サービス計画費テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績居宅サービス計画費(KokanShikibetsuNo 交換情報識別番号, RString 通し番号,
            KyufujissekiEntity entity) {

        int 連番 = 0;
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth("198801");
        DbT3025KyufujissekiKyotakuServiceEntity dbT3025entity = new DbT3025KyufujissekiKyotakuServiceEntity();
        List<ServiceKeikakuHiRealtEntity> 給付実績居宅サービス計画費List = entity.get償還払請求サービス計画List();
        if (給付実績居宅サービス計画費List != null && !給付実績居宅サービス計画費List.isEmpty()) {
            if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
                for (ServiceKeikakuHiRealtEntity 給付実績居宅サービス計画費 : 給付実績居宅サービス計画費List) {
                    if (給付実績居宅サービス計画費.get償還払請求サービス計画200004() != null) {
                        連番 = 連番 + 1;
                        dbT3025entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                        dbT3025entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getYoshikiNo()));
                        dbT3025entity.setRecodeShubetsuCode(new RString("06"));
                        dbT3025entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                        dbT3025entity.setHiHokenshaNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getHiHokenshaNo());
                        dbT3025entity.setServiceTeikyoYM(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getServiceTeikyoYM());
                        dbT3025entity.setJigyoshoNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getJigyoshaNo());
                        dbT3025entity.setToshiNo(通し番号);
                        dbT3025entity.setServicePlanhiMeisaiLineNo(new RString(String.valueOf(連番)));
                        dbT3025entity.setShiteiKijunGaitoJigyoshaKubunCode(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200004().getShiteiKijunGaitoJigyoshaKubunCode());
                        dbT3025entity.setTanisuTanka(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200004().getTanisuTanka());
                        dbT3025entity.setKyotakuServiceSakuseiIraiYMD(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200004().getKyotakuServiceSakuseiIraiYMD());
                        dbT3025entity.setServiceCode(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200004().getServiceCode());
                        dbT3025entity.setTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200004().getTanisu()));
                        dbT3025entity.setSeikyuKingaku(new Decimal(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getSeikyuKingaku()));
                        dbT3025entity.setAtoTanisu(new Decimal(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getTanisu()));
                        dbT3025entity.setAtoSeikyuKingaku(new Decimal(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200004().getSeikyuKingaku()));
                        dbT3025entity.setShinsaYM(entity.get審査年月().getYearMonth());
                        dbT3025entity.setSeiriNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200004().getSeiriNo());
                        給付実績居宅サービス計画費Dac.save(dbT3025entity);
                    }
                }
            }
            if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200903"))
                    && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
                for (ServiceKeikakuHiRealtEntity 給付実績居宅サービス計画費 : 給付実績居宅サービス計画費List) {
                    if (給付実績居宅サービス計画費.get償還払請求サービス計画200604() != null) {
                        連番 = 連番 + 1;
                        dbT3025entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                        dbT3025entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200604().getYoshikiNo()));
                        dbT3025entity.setRecodeShubetsuCode(new RString("06"));
                        dbT3025entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                        dbT3025entity.setHiHokenshaNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200604().getHiHokenshaNo());
                        dbT3025entity.setServiceTeikyoYM(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200604().getServiceTeikyoYM());
                        dbT3025entity.setJigyoshoNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200604().getJigyoshaNo());
                        dbT3025entity.setToshiNo(通し番号);
                        dbT3025entity.setServicePlanhiMeisaiLineNo(new RString(String.valueOf(連番)));
                        dbT3025entity.setShiteiKijunGaitoJigyoshaKubunCode(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getShiteiKijunGaitoJigyoshaKubunCode());
                        dbT3025entity.setTanisuTanka(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getTanisuTanka());
                        dbT3025entity.setKyotakuServiceSakuseiIraiYMD(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getKyotakuServiceSakuseiIraiYMD());
                        dbT3025entity.setServiceCode(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getServiceCode());
                        dbT3025entity.setTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getTanisu()));
                        dbT3025entity.setSeikyuKingaku(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getSeikyuKingaku()));
                        dbT3025entity.setTantouKaigoShienSemmoninNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getTantokangoshienSemmoninNo());
                        dbT3025entity.setTekiyo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getTekiyo());
                        dbT3025entity.setAtoTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getTanisu()));
                        dbT3025entity.setAtoSeikyuKingaku(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getSeikyuKingaku()));
                        dbT3025entity.setShinsaYM(entity.get審査年月().getYearMonth());
                        dbT3025entity.setSeiriNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200604().getSeiriNo());
                        給付実績居宅サービス計画費Dac.save(dbT3025entity);
                    }
                }
            }
            if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
                for (ServiceKeikakuHiRealtEntity 給付実績居宅サービス計画費 : 給付実績居宅サービス計画費List) {
                    if (給付実績居宅サービス計画費.get償還払請求サービス計画200904() != null) {
                        連番 = 連番 + 1;
                        dbT3025entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                        dbT3025entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(
                                給付実績居宅サービス計画費.get償還払請求サービス計画200904().getYoshikiNo()));
                        dbT3025entity.setRecodeShubetsuCode(new RString("06"));
                        dbT3025entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                        dbT3025entity.setHiHokenshaNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getHiHokenshaNo());
                        dbT3025entity.setServiceTeikyoYM(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getServiceTeikyoYM());
                        dbT3025entity.setJigyoshoNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getJigyoshaNo());
                        dbT3025entity.setToshiNo(通し番号);
                        dbT3025entity.setServicePlanhiMeisaiLineNo(new RString(String.valueOf(連番)));
                        dbT3025entity.setShiteiKijunGaitoJigyoshaKubunCode(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getShiteiKijunGaitoJigyoshaKubunCode());
                        dbT3025entity.setTanisuTanka(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getTanisuTanka());
                        dbT3025entity.setKyotakuServiceSakuseiIraiYMD(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getKyotakuServiceSakuseiIraiYMD());
                        dbT3025entity.setServiceCode(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getServiceCode());
                        dbT3025entity.setTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getTanisu()));
                        dbT3025entity.setKaisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getKaisu()));
                        dbT3025entity.setServiceTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getServiceTanisu()));
                        dbT3025entity.setServiceTanisuTotal(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getServiceTanisuTotal()));
                        dbT3025entity.setSeikyuKingaku(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getSeikyuKingaku()));
                        dbT3025entity.setTantouKaigoShienSemmoninNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getTantokangoshienSemmoninNo());
                        dbT3025entity.setTekiyo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getTekiyo());
                        dbT3025entity.setAtoTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getTanisu()));
                        dbT3025entity.setAtoKaisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getKaisu()));
                        dbT3025entity.setAtoServiceTanisu(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getServiceTanisu()));
                        dbT3025entity.setAtoServiceTanisuTotal(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getServiceTanisuTotal()));
                        dbT3025entity.setAtoSeikyuKingaku(new Decimal(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getSeikyuKingaku()));
                        dbT3025entity.setShinsaYM(entity.get審査年月().getYearMonth());
                        dbT3025entity.setSeiriNo(給付実績居宅サービス計画費.
                                get償還払請求サービス計画200904().getSeiriNo());
                        給付実績居宅サービス計画費Dac.save(dbT3025entity);
                    }
                }
            }
        }
    }

    /**
     * 給付実績特定入所者介護サービス費用テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績特定入所者介護サービス費用(KokanShikibetsuNo 交換情報識別番号,
            RString 通し番号, KyufujissekiEntity entity) {

        int 連番 = 0;
        DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity dbT3029entity
                = new DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity();
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> 償還払請求特定入所者介護サービス費用List
                = entity.get償還払請求特定入所者介護サービス費用List();
        if (償還払請求特定入所者介護サービス費用List != null && !償還払請求特定入所者介護サービス費用List.isEmpty()) {
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity 償還払請求特定入所者介護サービス費用
                    : 償還払請求特定入所者介護サービス費用List) {
                連番 = 連番 + 1;
                dbT3029entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3029entity.setInputShikibetsuNo(
                        new NyuryokuShikibetsuNo(償還払請求特定入所者介護サービス費用.getYoshikiNo()));
                dbT3029entity.setRecodeShubetsuCode(new RString("11"));
                dbT3029entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3029entity.setHiHokenshaNo(償還払請求特定入所者介護サービス費用.getHiHokenshaNo());
                dbT3029entity.setServiceTeikyoYM(償還払請求特定入所者介護サービス費用.getServiceTeikyoYM());
                dbT3029entity.setJigyoshoNo(償還払請求特定入所者介護サービス費用.getJigyoshaNo());
                dbT3029entity.setToshiNo(通し番号);
                dbT3029entity.setRecodeJunjiNo(new RString(String.valueOf(連番)));
                dbT3029entity.setServiceSyuruiCode(償還払請求特定入所者介護サービス費用.getServiceShuruiCode());
                dbT3029entity.setServiceKomokuCode(償還払請求特定入所者介護サービス費用.getServiceKomokuCode());
                dbT3029entity.setHiyoTanka(償還払請求特定入所者介護サービス費用.getHiyoTanka());
                dbT3029entity.setFutanGendogaku(償還払請求特定入所者介護サービス費用.getFutanGendogaku());
                dbT3029entity.setNissu(償還払請求特定入所者介護サービス費用.getNissu());
                dbT3029entity.setHiyogaku(new Decimal(償還払請求特定入所者介護サービス費用.getHiyogaku()));
                dbT3029entity.setHokenbunSeikyugaku(
                        new Decimal(償還払請求特定入所者介護サービス費用.getHokenbunSeikyugaku()));
                dbT3029entity.setRiyoshaFutangaku(
                        new Decimal(償還払請求特定入所者介護サービス費用.getRiyoshaFutangaku()));
                dbT3029entity.setHiyogakuTotal(new Decimal(償還払請求特定入所者介護サービス費用.getHiyogakuTotal()));
                dbT3029entity.setHokenbunSeikyugakuTotal(
                        new Decimal(償還払請求特定入所者介護サービス費用.getHokenbunSeikyugakuTotal()));
                dbT3029entity.setRiyoshaFutangakuTotal(
                        new Decimal(償還払請求特定入所者介護サービス費用.getRiyoshaFutangakuTotal()));
                dbT3029entity.setAtoHiyoTanka(償還払請求特定入所者介護サービス費用.getHiyoTanka());
                dbT3029entity.setAtoNissu(償還払請求特定入所者介護サービス費用.getNissu());
                dbT3029entity.setAtoHiyogaku(new Decimal(償還払請求特定入所者介護サービス費用.getHiyogaku()));
                dbT3029entity.setAtoHokenbunSeikyugaku(
                        new Decimal(償還払請求特定入所者介護サービス費用.getHokenbunSeikyugaku()));
                dbT3029entity.setAtoRiyoshaFutangaku(
                        new Decimal(償還払請求特定入所者介護サービス費用.getRiyoshaFutangaku()));
                dbT3029entity.setAtoHiyogakuTotal(
                        new Decimal(償還払請求特定入所者介護サービス費用.getHiyogakuTotal()));
                dbT3029entity.setAtoHokenbunSeikyugakuTotal(
                        new Decimal(償還払請求特定入所者介護サービス費用.getHokenbunSeikyugakuTotal()));
                dbT3029entity.setAtoRiyoshaFutangakuTotal(
                        new Decimal(償還払請求特定入所者介護サービス費用.getRiyoshaFutangakuTotal()));
                dbT3029entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3029entity.setSeiriNo(償還払請求特定入所者介護サービス費用.getSeiriNo());
                dbT3029entity.setState(EntityDataState.Added);
                給付実績特定入所者介護サービス費用Dac.save(dbT3029entity);
            }
        }
    }

    /**
     * 給付実績社会福祉法人軽減額テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績社会福祉法人軽減額(KokanShikibetsuNo 交換情報識別番号,
            RString 通し番号, KyufujissekiEntity entity) {

        DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity dbT3030entity
                = new DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> 償還払請求社会福祉法人軽減額List
                = entity.get償還払請求社会福祉法人軽減額List();
        if (償還払請求社会福祉法人軽減額List != null && !償還払請求社会福祉法人軽減額List.isEmpty()) {
            for (DbT3051ShokanShakaiFukushiHojinKeigengakuEntity 償還払請求社会福祉法人軽減額
                    : 償還払請求社会福祉法人軽減額List) {
                dbT3030entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3030entity.setInputShikibetsuNo(
                        new NyuryokuShikibetsuNo(償還払請求社会福祉法人軽減額.getYoshikiNo()));
                dbT3030entity.setRecodeShubetsuCode(new RString("12"));
                dbT3030entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3030entity.setHiHokenshaNo(償還払請求社会福祉法人軽減額.getHiHokenshaNo());
                dbT3030entity.setServiceTeikyoYM(償還払請求社会福祉法人軽減額.getServiceTeikyoYM());
                dbT3030entity.setJigyoshoNo(償還払請求社会福祉法人軽減額.getJigyoshaNo());
                dbT3030entity.setToshiNo(通し番号);
                dbT3030entity.setServiceSyuruiCode(償還払請求社会福祉法人軽減額.getServiceShuruiCode());
                dbT3030entity.setKeigenritsu(償還払請求社会福祉法人軽減額.getKeigenritsu());
                dbT3030entity.setRiyoshaFutanTotal(
                        new Decimal(償還払請求社会福祉法人軽減額.getRiyoshaFutangakuTotal()));
                dbT3030entity.setKeigengaku(new Decimal(償還払請求社会福祉法人軽減額.getKeigengaku()));
                dbT3030entity.setKeigengoRiyoshaFutangaku(
                        new Decimal(償還払請求社会福祉法人軽減額.getKeigengoRiyoshaFutangaku()));
                dbT3030entity.setBiko(償還払請求社会福祉法人軽減額.getBiko());
                dbT3030entity.setAtoRiyoshaFutanTotal(
                        new Decimal(償還払請求社会福祉法人軽減額.getRiyoshaFutangakuTotal()));
                dbT3030entity.setAtoKeigengaku(new Decimal(償還払請求社会福祉法人軽減額.getKeigengaku()));
                dbT3030entity.setAtoKeigengoRiyoshaFutangaku(
                        new Decimal(償還払請求社会福祉法人軽減額.getKeigengoRiyoshaFutangaku()));
                dbT3030entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3030entity.setSeiriNo(償還払請求社会福祉法人軽減額.getSeiriNo());
                dbT3030entity.setState(EntityDataState.Added);
                給付実績社会福祉法人軽減額Dac.save(dbT3030entity);
            }
        }
    }

    /**
     * 給付実績所定疾患施設療養費等テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績所定疾患施設療養費等(KokanShikibetsuNo 交換情報識別番号,
            RString 通し番号, KyufujissekiEntity entity) {

        int 連番 = 0;
        DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity dbT3032entity
                = new DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity();
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> 償還払請求所定疾患施設療養費等List
                = entity.get償還払請求所定疾患施設療養費等List();
        if (償還払請求所定疾患施設療養費等List != null && !償還払請求所定疾患施設療養費等List.isEmpty()) {
            for (DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity 償還払請求所定疾患施設療養費等
                    : 償還払請求所定疾患施設療養費等List) {
                連番 = 連番 + 1;
                dbT3032entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3032entity.setInputShikibetsuNo(
                        new NyuryokuShikibetsuNo(償還払請求所定疾患施設療養費等.getYoshikiNo()));
                dbT3032entity.setRecodeShubetsuCode(new RString("13"));
                dbT3032entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3032entity.setHiHokenshaNo(償還払請求所定疾患施設療養費等.getHiHokenshaNo());
                dbT3032entity.setServiceTeikyoYM(償還払請求所定疾患施設療養費等.getServiceTeikyoYM());
                dbT3032entity.setJigyoshoNo(償還払請求所定疾患施設療養費等.getJigyoshaNo());
                dbT3032entity.setToshiNo(通し番号);
                dbT3032entity.setRecodeJunjiNo(new RString(String.valueOf(連番)));
                dbT3032entity.setKinkyuShobyoName1(償還払請求所定疾患施設療養費等.getKinkyuShobyoName1());
                dbT3032entity.setKinkyuShobyoName2(償還払請求所定疾患施設療養費等.getKinkyuShobyoName2());
                dbT3032entity.setKinkyuShobyoName3(償還払請求所定疾患施設療養費等.getKinkyuShobyoName3());
                dbT3032entity.setKinkyuChiryoKaishiYMD1(償還払請求所定疾患施設療養費等.getKinkyuChiryoKaishiYMD1());
                dbT3032entity.setKinkyuChiryoKaishiYMD2(償還払請求所定疾患施設療養費等.getKinkyuChiryoKaishiYMD2());
                dbT3032entity.setKinkyuChiryoKaishiYMD3(償還払請求所定疾患施設療養費等.getKinkyuChiryoKaishiYMD3());
                dbT3032entity.setOshinNissu(償還払請求所定疾患施設療養費等.getOshinNissu());
                dbT3032entity.setOshinIryoKikanName(償還払請求所定疾患施設療養費等.getOshinIryoKikanName());
                dbT3032entity.setTsuinNissu(償還払請求所定疾患施設療養費等.getTsuinNissu());
                dbT3032entity.setTsuinIryoKikanName(償還払請求所定疾患施設療養費等.getTsuinKikanName());
                dbT3032entity.setKinkyuChiryoKanriTanisu(償還払請求所定疾患施設療養費等.getKinkyuChiryoKanriTanisu());
                dbT3032entity.setKinkyuChiryoKanriNissu(償還払請求所定疾患施設療養費等.getKinkyuChiryoKanriNissu());
                dbT3032entity.setKinkyuChiryoKanriSubTotal(
                        償還払請求所定疾患施設療養費等.getKinkyuChiryoKanriSubTotal());
                dbT3032entity.setRehabilitationTensu(償還払請求所定疾患施設療養費等.getRehabilitationTanisu());
                dbT3032entity.setShochiTensu(償還払請求所定疾患施設療養費等.getShochiTanisu());
                dbT3032entity.setShujutsuTensu(償還払請求所定疾患施設療養費等.getShujutsuTanisu());
                dbT3032entity.setMasuiTensu(償還払請求所定疾患施設療養費等.getMasuiTanisu());
                dbT3032entity.setHoshasenChiryoTensu(償還払請求所定疾患施設療養費等.getHoshasenChiryoTanisu());
                dbT3032entity.setTekiyo1(償還払請求所定疾患施設療養費等.getTekiyo1());
                dbT3032entity.setTekiyo2(償還払請求所定疾患施設療養費等.getTekiyo2());
                dbT3032entity.setTekiyo3(償還払請求所定疾患施設療養費等.getTekiyo3());
                dbT3032entity.setTekiyo4(償還払請求所定疾患施設療養費等.getTekiyo4());
                dbT3032entity.setTekiyo5(償還払請求所定疾患施設療養費等.getTekiyo5());
                dbT3032entity.setTekiyo6(償還払請求所定疾患施設療養費等.getTekiyo6());
                dbT3032entity.setTekiyo7(償還払請求所定疾患施設療養費等.getTekiyo7());
                dbT3032entity.setTekiyo8(償還払請求所定疾患施設療養費等.getTekiyo8());
                dbT3032entity.setTekiyo9(償還払請求所定疾患施設療養費等.getTekiyo9());
                dbT3032entity.setTekiyo10(償還払請求所定疾患施設療養費等.getTekiyo10());
                dbT3032entity.setTekiyo11(償還払請求所定疾患施設療養費等.getTekiyo11());
                dbT3032entity.setTekiyo12(償還払請求所定疾患施設療養費等.getTekiyo12());
                dbT3032entity.setTekiyo13(償還払請求所定疾患施設療養費等.getTekiyo13());
                dbT3032entity.setTekiyo14(償還払請求所定疾患施設療養費等.getTekiyo14());
                dbT3032entity.setTekiyo15(償還払請求所定疾患施設療養費等.getTekiyo15());
                dbT3032entity.setTekiyo16(償還払請求所定疾患施設療養費等.getTekiyo16());
                dbT3032entity.setTekiyo17(償還払請求所定疾患施設療養費等.getTekiyo17());
                dbT3032entity.setTekiyo18(償還払請求所定疾患施設療養費等.getTekiyo18());
                dbT3032entity.setTekiyo19(償還払請求所定疾患施設療養費等.getTekiyo19());
                dbT3032entity.setTekiyo20(償還払請求所定疾患施設療養費等.getTekiyo20());
                dbT3032entity.setKinkyuShisetsuRyoyohiTotalTensu(
                        償還払請求所定疾患施設療養費等.getKinkyuShisetsuRyoyohiTotalTanisu());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiShobyoName1(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanShobyoName1());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiShobyoName2(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanShobyoName2());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiShobyoName3(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanShobyoName3());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD1(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanShobyoKaishiYMD1());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD2(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanShobyoKaishiYMD2());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiKaishiYMD3(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanShobyoKaishiYMD3());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiTanisu(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanTanisu());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiNissu(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanNissu());
                dbT3032entity.setShoteiShikkanShisetsuRyoyohiSubTotal(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanSubTotal());
                dbT3032entity.setAtoOshinNissu(償還払請求所定疾患施設療養費等.getOshinNissu());
                dbT3032entity.setAtoTsuinNissu(償還払請求所定疾患施設療養費等.getTsuinNissu());
                dbT3032entity.setAtoKinkyuChiryoKanriTanisu(
                        償還払請求所定疾患施設療養費等.getKinkyuChiryoKanriTanisu());
                dbT3032entity.setAtoKinkyuChiryoKanriNissu(償還払請求所定疾患施設療養費等.getKinkyuChiryoKanriNissu());
                dbT3032entity.setAtoRehabilitationTensu(償還払請求所定疾患施設療養費等.getRehabilitationTanisu());
                dbT3032entity.setAtoShochiTensu(償還払請求所定疾患施設療養費等.getShochiTanisu());
                dbT3032entity.setAtoShujutsuTensu(償還払請求所定疾患施設療養費等.getShujutsuTanisu());
                dbT3032entity.setAtoMasuiTensu(償還払請求所定疾患施設療養費等.getMasuiTanisu());
                dbT3032entity.setAtoHoshasenChiryoTensu(償還払請求所定疾患施設療養費等.getHoshasenChiryoTanisu());
                dbT3032entity.setAtoShoteiShikkanShisetsuRyoyoHiTanisu(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanTanisu());
                dbT3032entity.setAtoShoteiShikkanShisetsuRyoyoHiNissu(
                        償還払請求所定疾患施設療養費等.getShoteiShikkanNissu());
                dbT3032entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3032entity.setSeiriNo(償還払請求所定疾患施設療養費等.getSeiriNo());
                dbT3032entity.setState(EntityDataState.Added);
                給付実績所定疾患施設療養費等Dac.save(dbT3032entity);
            }
        }
    }

    /**
     * 給付実績集計テーブルにデータを追加する
     *
     * @param 交換情報識別番号
     * @param 通し番号
     * @param entity
     */
    private void save給付実績集計(KokanShikibetsuNo 交換情報識別番号, RString 通し番号, KyufujissekiEntity entity) {
        DbT3033KyufujissekiShukeiEntity dbT3033entity = new DbT3033KyufujissekiShukeiEntity();
        List<DbT3053ShokanShukeiEntity> 償還払請求集計List = entity.get償還払請求集計List();
        if (償還払請求集計List != null && !償還払請求集計List.isEmpty()) {
            for (DbT3053ShokanShukeiEntity 償還払請求集計 : 償還払請求集計List) {
                dbT3033entity.setKokanJohoShikibetsuNo(交換情報識別番号);
                dbT3033entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(entity.get入力識別番号()));
                dbT3033entity.setRecodeShubetsuCode(new RString("10"));
                dbT3033entity.setShokisaiHokenshaNo(entity.get証記載保険者番号());
                dbT3033entity.setHiHokenshaNo(entity.get請求基本被保険者番号());
                dbT3033entity.setServiceTeikyoYM(entity.get請求基本サービス提供年月());
                dbT3033entity.setJigyoshoNo(entity.get事業所番号());
                dbT3033entity.setToshiNo(通し番号);
                dbT3033entity.setServiceSyuruiCode(償還払請求集計.getServiceShuruiCode());
                dbT3033entity.setPlanTanisu(new Decimal(償還払請求集計.getPlanTanisu()));
                dbT3033entity.setGendogakuKanriTaishoTanisu(
                        new Decimal(償還払請求集計.getGendogakuKanriTaishoTanisu()));
                dbT3033entity.setGendogakuKanritaishogaiTanisu(
                        new Decimal(償還払請求集計.getGendogakuKanriTaishogaiTanisu()));
                dbT3033entity.setTankiNyushoPlanNissu(new Decimal(償還払請求集計.getTankiNyushoPlanNissu()));
                dbT3033entity.setTankiNyushoJitsunissu(new Decimal(償還払請求集計.getTankiNyushoJitsunissu()));
                dbT3033entity.setHokenTanisuTotal(new Decimal(償還払請求集計.getTanisuTotal()));
                dbT3033entity.setHokenTanisuTani(償還払請求集計.getTanisuTanka());
                dbT3033entity.setHokenSeikyugaku(償還払請求集計.getSeikyugaku());
                dbT3033entity.setHokenRiyoshaFutangaku(new Decimal(償還払請求集計.getRiyoshaFutangaku()));
                dbT3033entity.setHokenDekidakaTanisuTotal(new Decimal(償還払請求集計.getDekidakaIryohiTanisuTotal()));
                dbT3033entity.setHokenDekidakaSeikyugaku(償還払請求集計.getDekidakaIryohiSeikyugaku());
                dbT3033entity.setHokenDekidakaIryohiRiyoshaFutangaku(
                        償還払請求集計.getDekidakaIryohiRiyoshaFutangaku());
                dbT3033entity.setAtoTankiNyushoJitsunissu(new Decimal(償還払請求集計.getTankiNyushoJitsunissu()));
                dbT3033entity.setAtoHokenTanisuTotal(new Decimal(償還払請求集計.getTanisuTotal()));
                dbT3033entity.setAtoHokenSeikyugaku(償還払請求集計.getSeikyugaku());
                dbT3033entity.setAtoHokenDekidakaTanisuTotal(
                        new Decimal(償還払請求集計.getDekidakaIryohiTanisuTotal()));
                dbT3033entity.setAtoHokenDekidakaSeikyugaku(償還払請求集計.getDekidakaIryohiSeikyugaku());
                dbT3033entity.setShinsaYM(entity.get審査年月().getYearMonth());
                dbT3033entity.setSeiriNo(entity.get整理番号());
                dbT3033entity.setTorikomiYM(entity.get審査年月().getYearMonth());
                dbT3033entity.setState(EntityDataState.Added);
                給付実績集計Dac.save(dbT3033entity);
            }
        }
    }
}
