/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuHi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu.KyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.ShafukukeigenServiceParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.ShafukukeigenServiceEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3039ShokanMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3041ShokanTokuteiShinryohiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3107ShokanMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7120TokuteiShinryoServiceCodeDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette.ISyokanbaraihiShikyuShinseiKetteMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbc.service.core.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuManager;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4012HyojunFutangakuGemmenDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い費支給申請決定クラスです。
 */
public class SyokanbaraihiShikyuShinseiKetteManager {

    private final MapperProvider mapperProvider;
    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 償還払請求特定入所者介護サービス費用Dac;
    private final DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac;
    private final DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac;
    private final DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac;
    private final DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT7120TokuteiShinryoServiceCodeDac 特定診療サービスコードDac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3107ShokanMeisaiJushochiTokureiDac 住所地特例Dac;
    private final DbT3039ShokanMeisaiDac 償還払請求明細Dac;
    private final DbT3041ShokanTokuteiShinryohiDac 償還払請求特定診療費Dac;
    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac 特別療養費Dac;
    private final DbT3051ShokanShakaiFukushiHojinKeigengakuDac 償還払請求社会福祉法人軽減額Dac;
    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoDac 償還払請求所定疾患施設療養費等Dac;
    private final DbT3040ShokanKinkyuShisetsuRyoyoDac 償還払請求緊急時施設療養Dac;
    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;
    private final DbT7131KaigoServiceNaiyouDac 介護サービスDac;
    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac 軽減率Dac;
    private final DbT4012HyojunFutangakuGemmenDac 標準負担額減免Dac;
    private static final RString モード_登録 = new RString("登録");
    private static final RString モード_修正 = new RString("修正");
    private static final RString モード_削除 = new RString("削除");

    /**
     * コンストラクタです。
     */
    SyokanbaraihiShikyuShinseiKetteManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.償還払請求特定入所者介護サービス費用Dac
                = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.償還払請求サービス計画200904Dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        this.償還払請求サービス計画200604Dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        this.償還払請求サービス計画200004Dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        this.償還払請求食事費用Dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.特定診療サービスコードDac = InstanceProvider.create(DbT7120TokuteiShinryoServiceCodeDac.class);
        this.償還払請求基本Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.住所地特例Dac = InstanceProvider.create(DbT3107ShokanMeisaiJushochiTokureiDac.class);
        this.償還払請求明細Dac = InstanceProvider.create(DbT3039ShokanMeisaiDac.class);
        this.償還払請求特定診療費Dac = InstanceProvider.create(DbT3041ShokanTokuteiShinryohiDac.class);
        this.特別療養費Dac = InstanceProvider.create(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac.class);
        this.償還払請求社会福祉法人軽減額Dac
                = InstanceProvider.create(DbT3051ShokanShakaiFukushiHojinKeigengakuDac.class);
        this.償還払請求所定疾患施設療養費等Dac
                = InstanceProvider.create(DbT3052ShokanShoteiShikkanShisetsuRyoyoDac.class);
        this.償還払請求緊急時施設療養Dac = InstanceProvider.create(DbT3040ShokanKinkyuShisetsuRyoyoDac.class);
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
        this.介護サービスDac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
        this.軽減率Dac = InstanceProvider.create(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac.class);
        this.標準負担額減免Dac = InstanceProvider.create(DbT4012HyojunFutangakuGemmenDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteManager}のインスタンス
     */
    public static SyokanbaraihiShikyuShinseiKetteManager createInstance() {

        return InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteManager.class);
    }

    /**
     * 償還払支給判定結果取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return DbT3036ShokanHanteiKekkaEntity
     */
    public DbT3036ShokanHanteiKekkaEntity getSyokanbaraiketteKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        DbT3036ShokanHanteiKekkaEntity entity
                = 償還払支給判定結果Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号);
        return entity;
    }

    /**
     * 証明書件数取得する。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @return 取得件数
     */
    public int getShikibetsuNoKanri(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) {
        int 件数 = 償還払請求基本Dac.selectデータ件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
        if (件数 > 0) {
            return 件数;
        }
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200904Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }
        if (new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200604Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }
        return 償還払請求サービス計画200004Dac.selectデータ件数(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号);
    }

    /**
     * 識別番号管理情報取得する。
     *
     * @param サービス提供年月
     * @param 識別番号
     * @return DbT3118ShikibetsuNoKanriEntity
     */
    public DbT3118ShikibetsuNoKanriEntity getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月,
            RString 識別番号) {
        DbT3118ShikibetsuNoKanriEntity entity = 識別番号管理Dac.select識別番号管理(識別番号, サービス提供年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return entity;
    }

    /**
     * 支給申請登録
     *
     * @param shinsei
     * @return 整理番号
     */
    public RString insDbT3034ShokanShinsei(ShokanShinsei shinsei) {

        RString 整理番号
                = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString();

        shinsei.toEntity().setSeiriNo(整理番号);
        shinsei.toEntity().setState(EntityDataState.Added);
        償還払支給申請Dac.save(shinsei.toEntity());
        return 整理番号;
    }

    /**
     * 支給申請更新
     *
     * @param shinsei
     * @return 更新件数
     */
    public int updDbT3034ShokanShinsei(ShokanShinsei shinsei) {

        shinsei.toEntity().setState(EntityDataState.Modified);
        return 償還払支給申請Dac.save(shinsei.toEntity());
    }

    /**
     * 支給申請削除
     *
     * @param shinsei
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 識別コード
     */
    @Transaction
    public void delDbT3034ShokanShinsei(ShokanShinsei shinsei, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, ShikibetsuCode 識別コード) {
        boolean 給付実績処理フラグ;
        KyufujissekiEntity Kyufuentity = null;
        DbT3036ShokanHanteiKekkaEntity entity = 償還払支給判定結果Dac.selectByKey(被保険者番号,
                サービス提供年月, 整理番号);
        if (entity == null) {
            給付実績処理フラグ = false;
        } else {
//            Kyufuentity = getKyufujisseki(被保険者番号, サービス提供年月, 整理番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setSeiriNo(整理番号);
            entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.save(entity);
            給付実績処理フラグ = true;
        }
        DbT3038ShokanKihonEntity DbT3038entity = new DbT3038ShokanKihonEntity();
        DbT3038entity.setHiHokenshaNo(被保険者番号);
        DbT3038entity.setServiceTeikyoYM(サービス提供年月);
        DbT3038entity.setSeiriNp(整理番号);
        DbT3038entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.save(DbT3038entity);

        DbT3107ShokanMeisaiJushochiTokureiEntity DbT3107entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
        DbT3107entity.setHiHokenshaNo(被保険者番号);
        DbT3107entity.setServiceTeikyoYM(サービス提供年月);
        DbT3107entity.setSeiriNp(整理番号);
        DbT3107entity.setState(EntityDataState.Deleted);
        住所地特例Dac.save(DbT3107entity);

        DbT3039ShokanMeisaiEntity DbT3039entity = new DbT3039ShokanMeisaiEntity();
        DbT3039entity.setHiHokenshaNo(被保険者番号);
        DbT3039entity.setServiceTeikyoYM(サービス提供年月);
        DbT3039entity.setSeiriNp(整理番号);
        DbT3039entity.setState(EntityDataState.Deleted);
        償還払請求明細Dac.save(DbT3039entity);

        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            DbT3041ShokanTokuteiShinryohiEntity DbT3041entity = new DbT3041ShokanTokuteiShinryohiEntity();
            DbT3041entity.setHiHokenshaNo(被保険者番号);
            DbT3041entity.setServiceTeikyoYM(サービス提供年月);
            DbT3041entity.setSeiriNo(整理番号);
            DbT3041entity.setState(EntityDataState.Deleted);
            償還払請求特定診療費Dac.save(DbT3041entity);
        } else {
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity DbT3042entity
                    = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            DbT3042entity.setHiHokenshaNo(被保険者番号);
            DbT3042entity.setServiceTeikyoYM(サービス提供年月);
            DbT3042entity.setSeiriNo(整理番号);
            DbT3042entity.setState(EntityDataState.Deleted);
            特別療養費Dac.save(DbT3042entity);
        }

        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            DbT3047ShokanServicePlan200904Entity DbT3047entity = new DbT3047ShokanServicePlan200904Entity();
            DbT3047entity.setHiHokenshaNo(被保険者番号);
            DbT3047entity.setServiceTeikyoYM(サービス提供年月);
            DbT3047entity.setSeiriNo(整理番号);
            DbT3047entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200904Dac.save(DbT3047entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200903"))
                && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            DbT3046ShokanServicePlan200604Entity DbT3046entity = new DbT3046ShokanServicePlan200604Entity();
            DbT3046entity.setHiHokenshaNo(被保険者番号);
            DbT3046entity.setServiceTeikyoYM(サービス提供年月);
            DbT3046entity.setSeiriNo(整理番号);
            DbT3046entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200604Dac.save(DbT3046entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            DbT3045ShokanServicePlan200004Entity DbT3045entity = new DbT3045ShokanServicePlan200004Entity();
            DbT3045entity.setHiHokenshaNo(被保険者番号);
            DbT3045entity.setServiceTeikyoYM(サービス提供年月);
            DbT3045entity.setSeiriNo(整理番号);
            DbT3045entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200004Dac.save(DbT3045entity);
        }

        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity DbT3050entity
                = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
        DbT3050entity.setHiHokenshaNo(被保険者番号);
        DbT3050entity.setServiceTeikyoYM(サービス提供年月);
        DbT3050entity.setSeiriNo(整理番号);
        DbT3050entity.setState(EntityDataState.Deleted);
        償還払請求特定入所者介護サービス費用Dac.save(DbT3050entity);

        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity DbT3051ntity
                = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
        DbT3051ntity.setHiHokenshaNo(被保険者番号);
        DbT3051ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3051ntity.setSeiriNo(整理番号);
        DbT3051ntity.setState(EntityDataState.Deleted);
        償還払請求社会福祉法人軽減額Dac.save(DbT3051ntity);

        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity DbT3052ntity
                = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
        DbT3052ntity.setHiHokenshaNo(被保険者番号);
        DbT3052ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3052ntity.setSeiriNo(整理番号);
        DbT3052ntity.setState(EntityDataState.Deleted);
        償還払請求所定疾患施設療養費等Dac.save(DbT3052ntity);

        DbT3040ShokanKinkyuShisetsuRyoyoEntity DbT3040ntity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
        DbT3040ntity.setHiHokenshaNo(被保険者番号);
        DbT3040ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3040ntity.setSeiriNo(整理番号);
        DbT3040ntity.setState(EntityDataState.Deleted);
        償還払請求緊急時施設療養Dac.save(DbT3040ntity);

        DbT3053ShokanShukeiEntity DbT3053entity = new DbT3053ShokanShukeiEntity();
        DbT3053entity.setHiHokenshaNo(被保険者番号);
        DbT3053entity.setServiceTeikyoYM(サービス提供年月);
        DbT3053entity.setSeiriNo(整理番号);
        DbT3053entity.setState(EntityDataState.Deleted);
        償還払請求集計Dac.save(DbT3053entity);

        DbT3043ShokanShokujiHiyoEntity DbT3043ntity = new DbT3043ShokanShokujiHiyoEntity();
        DbT3043ntity.setHiHokenshaNo(被保険者番号);
        DbT3043ntity.setServiceTeikyoYM(サービス提供年月);
        DbT3043ntity.setSeiriNp(整理番号);
        DbT3043ntity.setState(EntityDataState.Deleted);
        償還払請求食事費用Dac.save(DbT3043ntity);

        shinsei.toEntity().setState(EntityDataState.Deleted);
        償還払支給申請Dac.save(shinsei.toEntity());

        if (給付実績処理フラグ) {
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(new RString("削除"), 識別コード, Kyufuentity, null);
        }
    }

    /**
     * 証明書管理一覧取得
     *
     * @param サービス提供年月
     * @return List<DbT3118ShikibetsuNoKanri>
     */
    public List<DbT3118ShikibetsuNoKanriEntity> getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月) {

        List<DbT3118ShikibetsuNoKanriEntity> entityList
                = 識別番号管理Dac.select識別番号管理(サービス提供年月);
        if (entityList == null) {
            return new ArrayList<>();
        }
        for (DbT3118ShikibetsuNoKanriEntity entity : entityList) {
            entity.initializeMd5();
        }
        return entityList;
    }

    /**
     * 基本情報件数を取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 基本情報件数
     */
    public int getShokanKihonCount(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        DbT3038ShokanKihonEntity entity = 償還払請求基本Dac.selectByKey(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
        if (entity == null) {
            return 0;
        }
        return 1;
    }

    /**
     * 給付費明細（住特）情報件数します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 給付費明細（住特）情報件数
     */
    public int getShokanMeisaiJushochiTokureiCount(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 住所地特例Dac.selectデータ件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 給付費明細情報件数します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 給付費明細情報件数
     */
    public int delShokanMeisaiCount(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求明細Dac.selectデータ件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 特定診療費情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 特定診療費情報件数
     */
    public int updShokanTokuteiShinryohi(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            return 償還払請求特定診療費Dac.select件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        return 特別療養費Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 特定入所者費用情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 特定入所者費用情報件数
     */
    public int updShokanTokuteiNyushoshaKaigoServiceHiyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求特定入所者介護サービス費用Dac.select件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 社福軽減額情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 社福軽減額情報件数
     */
    public int updShokanShakaiFukushiHojinKeigengaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求社会福祉法人軽減額Dac.select件数(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    /**
     * 緊急時・所定疾患情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 緊急時・所定疾患情報件数
     */
    public int updShokanShoteiShikkanShisetsuRyoyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求所定疾患施設療養費等Dac.select件数(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    /**
     * 緊急時施設療養費情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 緊急時施設療養費情報件数
     */
    public int updShokanKinkyuShisetsuRyoyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求緊急時施設療養Dac.select件数(被保険者番号, サービス提供年月, 整理番号,
                事業者番号, 様式番号, 明細番号);
    }

    /**
     * 請求額集計情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 請求額集計情報件数
     */
    public int updShokanShukei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求集計Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 食事費用情報件数取得します。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 食事費用情報件数
     */
    public int updShokanShokujiHiyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        return 償還払請求食事費用Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 明細番号);
    }

    /**
     * 証明書削除処理
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     */
    public void delShokanSyomeisyo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {

        DbT3038ShokanKihonEntity dbT3038entity = new DbT3038ShokanKihonEntity();
        dbT3038entity.setHiHokenshaNo(被保険者番号);
        dbT3038entity.setServiceTeikyoYM(サービス提供年月);
        dbT3038entity.setSeiriNp(整理番号);
        dbT3038entity.setJigyoshaNo(事業者番号);
        dbT3038entity.setYoshikiNo(様式番号);
        dbT3038entity.setMeisaiNo(明細番号);
        dbT3038entity.setState(EntityDataState.Deleted);
        償還払請求基本Dac.save(dbT3038entity);

        DbT3107ShokanMeisaiJushochiTokureiEntity dbT3107entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
        dbT3107entity.setHiHokenshaNo(被保険者番号);
        dbT3107entity.setServiceTeikyoYM(サービス提供年月);
        dbT3107entity.setSeiriNp(整理番号);
        dbT3107entity.setJigyoshaNo(事業者番号);
        dbT3107entity.setYoshikiNo(様式番号);
        dbT3107entity.setMeisaiNo(明細番号);
        dbT3107entity.setState(EntityDataState.Deleted);
        住所地特例Dac.save(dbT3107entity);

        DbT3039ShokanMeisaiEntity dbT3039entity = new DbT3039ShokanMeisaiEntity();
        dbT3039entity.setHiHokenshaNo(被保険者番号);
        dbT3039entity.setServiceTeikyoYM(サービス提供年月);
        dbT3039entity.setSeiriNp(整理番号);
        dbT3039entity.setJigyoshaNo(事業者番号);
        dbT3039entity.setYoshikiNo(様式番号);
        dbT3039entity.setMeisaiNo(明細番号);
        dbT3039entity.setState(EntityDataState.Deleted);
        償還払請求明細Dac.save(dbT3039entity);

        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            DbT3041ShokanTokuteiShinryohiEntity dbT3041entity = new DbT3041ShokanTokuteiShinryohiEntity();
            dbT3041entity.setHiHokenshaNo(被保険者番号);
            dbT3041entity.setServiceTeikyoYM(サービス提供年月);
            dbT3041entity.setSeiriNo(整理番号);
            dbT3041entity.setJigyoshaNo(事業者番号);
            dbT3041entity.setYoshikiNo(様式番号);
            dbT3041entity.setMeisaiNo(明細番号);
            dbT3041entity.setState(EntityDataState.Deleted);
            償還払請求特定診療費Dac.save(dbT3041entity);
        } else {
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity dbT3042entity
                    = new DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity();
            dbT3042entity.setHiHokenshaNo(被保険者番号);
            dbT3042entity.setServiceTeikyoYM(サービス提供年月);
            dbT3042entity.setSeiriNo(整理番号);
            dbT3042entity.setJigyoshaNo(事業者番号);
            dbT3042entity.setYoshikiNo(様式番号);
            dbT3042entity.setMeisaiNo(明細番号);
            dbT3042entity.setState(EntityDataState.Deleted);
            特別療養費Dac.save(dbT3042entity);
        }

        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            DbT3047ShokanServicePlan200904Entity dbT3047entity = new DbT3047ShokanServicePlan200904Entity();
            dbT3047entity.setHiHokenshaNo(被保険者番号);
            dbT3047entity.setServiceTeikyoYM(サービス提供年月);
            dbT3047entity.setSeiriNo(整理番号);
            dbT3047entity.setJigyoshaNo(事業者番号);
            dbT3047entity.setYoshikiNo(様式番号);
            dbT3047entity.setMeisaiNo(明細番号);
            dbT3047entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200904Dac.save(dbT3047entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200903"))
                && new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)) {
            DbT3046ShokanServicePlan200604Entity dbT3046entity = new DbT3046ShokanServicePlan200604Entity();
            dbT3046entity.setHiHokenshaNo(被保険者番号);
            dbT3046entity.setServiceTeikyoYM(サービス提供年月);
            dbT3046entity.setSeiriNo(整理番号);
            dbT3046entity.setJigyoshaNo(事業者番号);
            dbT3046entity.setYoshikiNo(様式番号);
            dbT3046entity.setMeisaiNo(明細番号);
            dbT3046entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200604Dac.save(dbT3046entity);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            DbT3045ShokanServicePlan200004Entity dbT3045entity = new DbT3045ShokanServicePlan200004Entity();
            dbT3045entity.setHiHokenshaNo(被保険者番号);
            dbT3045entity.setServiceTeikyoYM(サービス提供年月);
            dbT3045entity.setSeiriNo(整理番号);
            dbT3045entity.setJigyoshaNo(事業者番号);
            dbT3045entity.setYoshikiNo(様式番号);
            dbT3045entity.setMeisaiNo(明細番号);
            dbT3045entity.setState(EntityDataState.Deleted);
            償還払請求サービス計画200004Dac.save(dbT3045entity);
        }
        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbT3050entity
                = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
        dbT3050entity.setHiHokenshaNo(被保険者番号);
        dbT3050entity.setServiceTeikyoYM(サービス提供年月);
        dbT3050entity.setSeiriNo(整理番号);
        dbT3050entity.setJigyoshaNo(事業者番号);
        dbT3050entity.setYoshikiNo(様式番号);
        dbT3050entity.setMeisaiNo(明細番号);
        dbT3050entity.setState(EntityDataState.Deleted);
        償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity);

        DbT3051ShokanShakaiFukushiHojinKeigengakuEntity dbT3051entity
                = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
        dbT3051entity.setHiHokenshaNo(被保険者番号);
        dbT3051entity.setServiceTeikyoYM(サービス提供年月);
        dbT3051entity.setSeiriNo(整理番号);
        dbT3051entity.setJigyoshaNo(事業者番号);
        dbT3051entity.setYoshikiNo(様式番号);
        dbT3051entity.setMeisaiNo(明細番号);
        dbT3051entity.setState(EntityDataState.Deleted);
        償還払請求社会福祉法人軽減額Dac.save(dbT3051entity);

        DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity dbT3052entity
                = new DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity();
        dbT3052entity.setHiHokenshaNo(被保険者番号);
        dbT3052entity.setServiceTeikyoYM(サービス提供年月);
        dbT3052entity.setSeiriNo(整理番号);
        dbT3052entity.setJigyoshaNo(事業者番号);
        dbT3052entity.setYoshikiNo(様式番号);
        dbT3052entity.setMeisaiNo(明細番号);
        dbT3052entity.setState(EntityDataState.Deleted);
        償還払請求所定疾患施設療養費等Dac.save(dbT3052entity);

        DbT3040ShokanKinkyuShisetsuRyoyoEntity dbT3040entity = new DbT3040ShokanKinkyuShisetsuRyoyoEntity();
        dbT3040entity.setHiHokenshaNo(被保険者番号);
        dbT3040entity.setServiceTeikyoYM(サービス提供年月);
        dbT3040entity.setSeiriNo(整理番号);
        dbT3040entity.setJigyoshaNo(事業者番号);
        dbT3040entity.setYoshikiNo(様式番号);
        dbT3040entity.setMeisaiNo(明細番号);
        dbT3040entity.setState(EntityDataState.Deleted);
        償還払請求緊急時施設療養Dac.save(dbT3040entity);

        DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
        dbT3053entity.setHiHokenshaNo(被保険者番号);
        dbT3053entity.setServiceTeikyoYM(サービス提供年月);
        dbT3053entity.setSeiriNo(整理番号);
        dbT3053entity.setJigyoshaNo(事業者番号);
        dbT3053entity.setYoshikiNo(様式番号);
        dbT3053entity.setMeisaiNo(明細番号);
        dbT3053entity.setState(EntityDataState.Deleted);
        償還払請求集計Dac.save(dbT3053entity);

        DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
        dbT3043entity.setHiHokenshaNo(被保険者番号);
        dbT3043entity.setServiceTeikyoYM(サービス提供年月);
        dbT3043entity.setSeiriNp(整理番号);
        dbT3043entity.setJigyoshaNo(事業者番号);
        dbT3043entity.setYoshikiNo(様式番号);
        dbT3043entity.setMeisaiNo(明細番号);
        dbT3043entity.setState(EntityDataState.Deleted);
        償還払請求食事費用Dac.save(dbT3043entity);
    }

    /**
     * 基本情報登録更新処理
     *
     * @param 明細番号
     * @param kihon
     * @return 明細番号
     */
    public RString updShokanKihon(RString 明細番号, ShokanKihon kihon) {

        if (明細番号 == null || 明細番号.isEmpty()) {
            明細番号 = new RString("0001");
            kihon.toEntity().setState(EntityDataState.Added);
            償還払請求基本Dac.save(kihon.toEntity());
            return 明細番号;
        } else {
            kihon.toEntity().setState(EntityDataState.Modified);
            償還払請求基本Dac.save(kihon.toEntity());
            return 明細番号;
        }
    }

    /**
     * 給付費明細（住特）登録更新処理
     *
     * @param entityList
     */
    public void updShokanMeisaiJushochiTokurei(List<ShokanMeisaiJushochiTokurei> entityList) {

        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanMeisaiJushochiTokurei entity : entityList) {
                住所地特例Dac.save(entity.toEntity());
            }
        }
    }

    /**
     * 給付費明細登録更新処理
     *
     * @param entityList
     */
    public void updShokanMeisai(List<ShokanMeisai> entityList) {

        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanMeisai entity : entityList) {
                償還払請求明細Dac.save(entity.toEntity());
            }
        }
    }

    /**
     * 特定診療費登録更新処理
     *
     * @param dbt3041entityList
     * @param dbt3042entityList
     * @param parameter
     */
    @Transaction
    public void updShokanTokuteiShinryohi(List<ShokanTokuteiShinryohi> dbt3041entityList,
            List<ShokanTokuteiShinryoTokubetsuRyoyo> dbt3042entityList,
            ShokanKihonParameter parameter) {

        int 合計金額 = 0;
        boolean 変更区分 = false;
        if (parameter.get提供購入年月().isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            if (dbt3041entityList != null && !dbt3041entityList.isEmpty()) {
                for (ShokanTokuteiShinryohi dbt3041entity : dbt3041entityList) {
                    if (!EntityDataState.Deleted.equals(dbt3041entity.toEntity().getState())) {
                        合計金額 = 合計金額 + dbt3041entity.get合計単位数();
                    }
                    if (!EntityDataState.Unchanged.equals(dbt3041entity.toEntity().getState())) {
                        変更区分 = true;
                        償還払請求特定診療費Dac.save(dbt3041entity.toEntity());
                    }
                }
            }
        } else {
            if (dbt3042entityList != null && !dbt3042entityList.isEmpty()) {
                for (ShokanTokuteiShinryoTokubetsuRyoyo dbt3042entity : dbt3042entityList) {
                    if (!EntityDataState.Deleted.equals(dbt3042entity.toEntity().getState())) {
                        合計金額 = 合計金額 + dbt3042entity.get合計単位数();
                    }
                    if (!EntityDataState.Unchanged.equals(dbt3042entity.toEntity().getState())) {
                        変更区分 = true;
                        特別療養費Dac.save(dbt3042entity.toEntity());
                    }
                }
            }
        }
        if (変更区分) {
            DbT3038ShokanKihonEntity dbT3038entity
                    = 償還払請求基本Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                            parameter.get整理番号(), parameter.get事業者番号(),
                            parameter.get証明書コード(), parameter.get明細番号());
            dbT3038entity.setTokuteiShinryoSeikyugaku(new Decimal(合計金額));
            dbT3038entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(dbT3038entity);
        }

    }

    /**
     * サービス計画費登録更新処理
     *
     * @param dbt3047entityList
     * @param dbt3046entity
     * @param dbt3045entity
     * @param サービス提供年月
     * @param 明細番号
     * @return 明細番号
     */
    @Transaction
    public RString updShokanServicePlan(List<ShokanServicePlan200904> dbt3047entityList,
            ShokanServicePlan200604 dbt3046entity,
            ShokanServicePlan200004 dbt3045entity,
            FlexibleYearMonth サービス提供年月, RString 明細番号) {

        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            if (dbt3047entityList != null && !dbt3047entityList.isEmpty()) {
                if (明細番号 == null || 明細番号.isEmpty()) {
                    明細番号 = new RString("0001");
                    for (ShokanServicePlan200904 dbt3047entity : dbt3047entityList) {
                        if (!EntityDataState.Deleted.equals(dbt3047entity.toEntity().getState())) {
                            dbt3047entity.toEntity().setState(EntityDataState.Added);
                            償還払請求サービス計画200904Dac.save(dbt3047entity.toEntity());
                        }
                    }
                } else {
                    for (ShokanServicePlan200904 dbt3047entity : dbt3047entityList) {
                        償還払請求サービス計画200904Dac.save(dbt3047entity.toEntity());
                    }
                }
            }
        } else if (new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)
                && (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200903")))) {
            if (明細番号 == null || 明細番号.isEmpty()) {
                明細番号 = new RString("0001");
                dbt3046entity.toEntity().setState(EntityDataState.Added);
                償還払請求サービス計画200604Dac.save(dbt3046entity.toEntity());
            } else {
                dbt3046entity.toEntity().setState(EntityDataState.Modified);
                償還払請求サービス計画200604Dac.save(dbt3046entity.toEntity());
            }
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            if (明細番号 == null || 明細番号.isEmpty()) {
                明細番号 = new RString("0001");
                dbt3045entity.toEntity().setState(EntityDataState.Added);
                償還払請求サービス計画200004Dac.save(dbt3045entity.toEntity());
            } else {
                dbt3045entity.toEntity().setState(EntityDataState.Modified);
                償還払請求サービス計画200004Dac.save(dbt3045entity.toEntity());
            }
        }
        return 明細番号;
    }

    /**
     * 特定入所者費用登録更新処理
     *
     * @param parameter
     * @param 特定入所者費用List
     */
    @Transaction
    public void updShokanTokuteiNyushoshaKaigoServiceHiyo(ShokanKihonParameter parameter,
            List<ShokanTokuteiNyushoshaKaigoServiceHiyo> 特定入所者費用List) {

        if (特定入所者費用List != null && !特定入所者費用List.isEmpty()) {
            boolean 変更区分 = false;
            for (ShokanTokuteiNyushoshaKaigoServiceHiyo 特定入所者費用 : 特定入所者費用List) {
                if (!EntityDataState.Unchanged.equals(特定入所者費用.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求特定入所者介護サービス費用Dac.save(特定入所者費用.toEntity());
                }
            }
            if (変更区分) {
                DbT3038ShokanKihonEntity dbT3038entity
                        = 償還払請求基本Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                                parameter.get整理番号(), parameter.get事業者番号(),
                                parameter.get証明書コード(), parameter.get明細番号());
                dbT3038entity.setTokuteiNyushoshaKaigoServiceSeikyugaku(parameter.get合計());
                dbT3038entity.setState(EntityDataState.Modified);
                償還払請求基本Dac.save(dbT3038entity);
            }
        }
    }

    /**
     * 社福軽減額登録更新処理
     *
     * @param entityList
     */
    @Transaction
    public void updShokanShakaiFukushiHojinKeigengaku(
            List<ShokanShakaiFukushiHojinKeigengaku> entityList) {

        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanShakaiFukushiHojinKeigengaku entity : entityList) {
                償還払請求社会福祉法人軽減額Dac.save(entity.toEntity());
            }
        }
    }

    /**
     * 緊急時・所定疾患登録更新処理
     *
     * @param parameter
     * @param 緊急時所定疾患List
     */
    @Transaction
    public void updShokanShoteiShikkanShisetsuRyoyo(ShokanKihonParameter parameter,
            List<ShokanShoteiShikkanShisetsuRyoyo> 緊急時所定疾患List) {
        int 金額合計 = 0;
        if (緊急時所定疾患List != null && !緊急時所定疾患List.isEmpty()) {
            boolean 変更区分 = false;
            for (ShokanShoteiShikkanShisetsuRyoyo 緊急時所定疾患 : 緊急時所定疾患List) {
                if (!EntityDataState.Deleted.equals(緊急時所定疾患.toEntity().getState())) {
                    金額合計 = 金額合計 + 緊急時所定疾患.get緊急時施設療養費合計単位数()
                            + 緊急時所定疾患.get所定疾患施設療養費小計();
                }
                if (!EntityDataState.Unchanged.equals(緊急時所定疾患.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求所定疾患施設療養費等Dac.save(緊急時所定疾患.toEntity());
                }
            }
            if (変更区分) {
                DbT3038ShokanKihonEntity dbT3038entity
                        = 償還払請求基本Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                                parameter.get整理番号(), parameter.get事業者番号(),
                                parameter.get証明書コード(), parameter.get明細番号());
                dbT3038entity.setKinkyuShisetsuRyoyoSeikyugaku(new Decimal(金額合計));
                dbT3038entity.setState(EntityDataState.Modified);
                償還払請求基本Dac.save(dbT3038entity);
            }
        }
    }

    /**
     * 緊急時施設療養費登録更新処理
     *
     * @param parameter
     * @param 緊急時施設療養費List
     */
    @Transaction
    public void updShokanKinkyuShisetsuRyoyo(ShokanKihonParameter parameter,
            List<ShokanKinkyuShisetsuRyoyo> 緊急時施設療養費List) {

        int 金額合計 = 0;
        if (緊急時施設療養費List != null && !緊急時施設療養費List.isEmpty()) {
            boolean 変更区分 = false;
            for (ShokanKinkyuShisetsuRyoyo 緊急時施設療養費 : 緊急時施設療養費List) {
                if (!EntityDataState.Deleted.equals(緊急時施設療養費.toEntity().getState())) {
                    金額合計 = 金額合計 + 緊急時施設療養費.get緊急時施設療養費合計単位数();
                }
                if (!EntityDataState.Unchanged.equals(緊急時施設療養費.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求緊急時施設療養Dac.save(緊急時施設療養費.toEntity());
                }
            }
            if (変更区分) {
                DbT3038ShokanKihonEntity dbT3038entity
                        = 償還払請求基本Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                                parameter.get整理番号(), parameter.get事業者番号(),
                                parameter.get証明書コード(), parameter.get明細番号());
                dbT3038entity.setKinkyuShisetsuRyoyoSeikyugaku(new Decimal(金額合計));
                dbT3038entity.setState(EntityDataState.Modified);
                償還払請求基本Dac.save(dbT3038entity);
            }
        }
    }

    /**
     * 請求額集計登録更新処理
     *
     * @param shukeiList
     * @param parameter
     */
    @Transaction
    public void updShokanShukei(List<ShokanShukei> shukeiList, ShokanKihonParameter parameter) {

        Decimal 請求額合計 = new Decimal("0");
        int 利用者負担額合計 = 0;
        if (shukeiList != null && !shukeiList.isEmpty()) {
            boolean 変更区分 = false;
            for (ShokanShukei shukei : shukeiList) {
                if (!EntityDataState.Deleted.equals(shukei.toEntity().getState())) {
                    請求額合計 = 請求額合計.add(shukei.get請求額());
                    利用者負担額合計 = 利用者負担額合計 + shukei.get利用者負担額();
                }
                if (!EntityDataState.Unchanged.equals(shukei.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求集計Dac.save(shukei.toEntity());
                }
            }
            if (変更区分) {
                DbT3038ShokanKihonEntity dbT3038entity
                        = 償還払請求基本Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                                parameter.get整理番号(), parameter.get事業者番号(),
                                parameter.get証明書コード(), parameter.get明細番号());
                dbT3038entity.setHokenSeikyugaku(請求額合計);
                dbT3038entity.setRiyoshaFutangaku(利用者負担額合計);
                dbT3038entity.setState(EntityDataState.Modified);
                償還払請求基本Dac.save(dbT3038entity);
            }
        }
    }

    /**
     * 食事費用登録更新処理
     *
     * @param dbt3043entity
     * @param dbt3039entityList
     * @param parameter
     */
    @Transaction
    public void updShokanShokujiHiyo(ShokanShokujiHiyo dbt3043entity,
            List<ShokanMeisai> dbt3039entityList,
            ShokanKihonParameter parameter) {

        List<DbT3043ShokanShokujiHiyoEntity> entityList
                = 償還払請求食事費用Dac.selectByKey(parameter.get被保険者番号(), parameter.get提供購入年月(),
                        parameter.get整理番号(), parameter.get事業者番号(),
                        parameter.get証明書コード(), parameter.get明細番号());
        if (new FlexibleYearMonth("200304").isBeforeOrEquals(parameter.get提供購入年月())
                && parameter.get提供購入年月().isBeforeOrEquals(new FlexibleYearMonth("200509"))) {
            if (dbt3039entityList != null && !dbt3039entityList.isEmpty()) {
                for (ShokanMeisai dbt3039entity : dbt3039entityList) {
                    償還払請求明細Dac.save(dbt3039entity.toEntity());
                }
            }
        }
        if (entityList == null || entityList.isEmpty()) {
            dbt3043entity.toEntity().setState(EntityDataState.Added);
            償還払請求食事費用Dac.save(dbt3043entity.toEntity());

        } else {
            dbt3043entity.toEntity().setState(EntityDataState.Modified);
            償還払請求食事費用Dac.save(dbt3043entity.toEntity());
        }
    }

    /**
     * 決定情報登録更新
     *
     * @param parameter
     */
    @Transaction
    public void updKetteJoho(SyokanbaraihiShikyuShinseiKetteParameter parameter) {

        RString 修正前支給区分 = null;
        List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List = parameter.get決定情報一覧List();
        if (parameter.get決定年月日() != null && !parameter.get決定年月日().isEmpty()) {
            DbT3036ShokanHanteiKekkaEntity dbT3036entity
                    = 償還払支給判定結果Dac.selectByKey(parameter.get被保険者番号(),
                            parameter.getサービス提供年月(), parameter.get整理番号());
            if (dbT3036entity == null) {
                DbT3034ShokanShinseiEntity dbT3034entity
                        = 償還払支給申請Dac.selectByKey(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号());
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
                if (dbT3034entity != null) {
                    entity.setShoKisaiHokenshaNo(dbT3034entity.getShoKisaiHokenshaNo());
                }
                entity.setKetteiYMD(parameter.get決定年月日());
                entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分());
                entity.setShiharaiKingaku(parameter.get支払金額合計());
                entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(entity);
                修正前支給区分 = ShikyuFushikyuKubun.不支給.getコード();

            } else {
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
                entity.setKetteiYMD(parameter.get決定年月日());
                entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分());
                entity.setShiharaiKingaku(parameter.get支払金額合計());
                entity.setState(EntityDataState.Modified);
                償還払支給判定結果Dac.save(entity);
                修正前支給区分 = dbT3036entity.getShikyuHushikyuKetteiKubun();
            }
            DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
            dbT3053entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3053entity.setServiceTeikyoYM(parameter.getサービス提供年月());
            dbT3053entity.setSeiriNo(parameter.get整理番号());
            dbT3053entity.setShikyuKubunCode(parameter.get支給区分());
            dbT3053entity.setSeikyugakuSagakuKingaku(parameter.get差額金額());
            dbT3053entity.setDekidakaSeikyugakuSagaku(parameter.get差額金額());
            dbT3053entity.setZougenRiyu(parameter.get増減理由等());
            dbT3053entity.setHushikyuRiyu(parameter.get不支給理由等1());
            dbT3053entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
            dbT3053entity.setState(EntityDataState.Modified);
            int 更新件数 = 償還払請求集計Dac.save(dbT3053entity);
            if (更新件数 == 0) {
                if (決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
                    for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                        if (new FlexibleYearMonth("200904").isBeforeOrEquals(parameter.getサービス提供年月())) {
                            DbT3047ShokanServicePlan200904Entity dbT3047entity
                                    = new DbT3047ShokanServicePlan200904Entity();
                            dbT3047entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3047entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            dbT3047entity.setSeiriNo(parameter.get整理番号());
                            dbT3047entity.setShikyuKubunCode(parameter.get支給区分());
                            dbT3047entity.setZougenTen(parameter.get増減単位());
                            dbT3047entity.setSagakuKingaku(決定情報一覧.get差額金額());
                            dbT3047entity.setZougenRiyu(parameter.get増減理由等());
                            dbT3047entity.setFushikyuRiyu(parameter.get不支給理由等1());
                            dbT3047entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                            dbT3047entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200904Dac.save(dbT3047entity);
                        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth("200903"))
                                && new FlexibleYearMonth("200604").isBeforeOrEquals(parameter.getサービス提供年月())) {
                            DbT3046ShokanServicePlan200604Entity dbT3046entity
                                    = new DbT3046ShokanServicePlan200604Entity();
                            dbT3046entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3046entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            dbT3046entity.setSeiriNo(parameter.get整理番号());
                            dbT3046entity.setShikyuKubunCode(parameter.get支給区分());
                            dbT3046entity.setZougenTen(parameter.get増減単位());
                            dbT3046entity.setSagakuKingaku(決定情報一覧.get差額金額());
                            dbT3046entity.setZougenRiyu(parameter.get増減理由等());
                            dbT3046entity.setFushikyuRiyu(parameter.get不支給理由等1());
                            dbT3046entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                            dbT3046entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200604Dac.save(dbT3046entity);
                        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
                            DbT3045ShokanServicePlan200004Entity dbT3045entity
                                    = new DbT3045ShokanServicePlan200004Entity();
                            dbT3045entity.setHiHokenshaNo(parameter.get被保険者番号());
                            dbT3045entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                            dbT3045entity.setSeiriNo(parameter.get整理番号());
                            dbT3045entity.setShikyuKubunCode(parameter.get支給区分());
                            dbT3045entity.setZougenTen(parameter.get増減単位());
                            dbT3045entity.setSagakuKingaku(決定情報一覧.get差額金額());
                            dbT3045entity.setZougenRiyu(parameter.get増減理由等());
                            dbT3045entity.setFushikyuRiyu(parameter.get不支給理由等1());
                            dbT3045entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                            dbT3045entity.setState(EntityDataState.Modified);
                            償還払請求サービス計画200004Dac.save(dbT3045entity);
                        }
                    }
                }
            }
        }
        if (parameter.is差額金額登録フラグ()) {
            if (決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
                for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                    if (決定情報一覧.getテーブル区分() != null && !決定情報一覧.getテーブル区分().isEmpty()) {
                        DbT3043ShokanShokujiHiyoEntity dbT3043entity = new DbT3043ShokanShokujiHiyoEntity();
                        DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
                        DbT3047ShokanServicePlan200904Entity dbT3047entity
                                = new DbT3047ShokanServicePlan200904Entity();
                        DbT3046ShokanServicePlan200604Entity dbT3046entity
                                = new DbT3046ShokanServicePlan200604Entity();
                        DbT3045ShokanServicePlan200004Entity dbT3045entity
                                = new DbT3045ShokanServicePlan200004Entity();
                        DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbT3050entity
                                = new DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity();
                        switch (Integer.valueOf(決定情報一覧.getテーブル区分().toString())) {
                            case 3:
                                dbT3053entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3053entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3053entity.setSeiriNo(parameter.get整理番号());
                                dbT3053entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3053entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3053entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3053entity.setRenban(決定情報一覧.get連番());
                                dbT3053entity.setShikyuKubunCode(parameter.get支給区分());
                                dbT3053entity.setSeikyugakuSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3053entity.setDekidakaSeikyugakuSagaku(決定情報一覧.get差額金額());
                                dbT3053entity.setState(EntityDataState.Modified);
                                償還払請求集計Dac.save(dbT3053entity);
                                break;
                            case 4:
                                dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3043entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3043entity.setSeiriNp(parameter.get整理番号());
                                dbT3043entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3043entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3043entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3043entity.setRenban(決定情報一覧.get連番());
                                dbT3043entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3043entity.setState(EntityDataState.Modified);
                                償還払請求食事費用Dac.save(dbT3043entity);
                                break;
                            case 5:
                                dbT3050entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3050entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3050entity.setSeiriNo(parameter.get整理番号());
                                dbT3050entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3050entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3050entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3050entity.setRenban(決定情報一覧.get連番());
                                dbT3050entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3050entity.setState(EntityDataState.Modified);
                                償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity);
                                break;
                            case 6:
                                dbT3047entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3047entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3047entity.setSeiriNo(parameter.get整理番号());
                                dbT3047entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3047entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3047entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3047entity.setRenban(決定情報一覧.get連番());
                                dbT3047entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3047entity.setState(EntityDataState.Modified);
                                償還払請求サービス計画200904Dac.save(dbT3047entity);
                                break;
                            case 7:
                                dbT3046entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3046entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3046entity.setSeiriNo(parameter.get整理番号());
                                dbT3046entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3046entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3046entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3046entity.setRenban(決定情報一覧.get連番());
                                dbT3046entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3046entity.setState(EntityDataState.Modified);
                                償還払請求サービス計画200604Dac.save(dbT3046entity);
                                break;
                            case 8:
                                dbT3045entity.setHiHokenshaNo(parameter.get被保険者番号());
                                dbT3045entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                                dbT3045entity.setSeiriNo(parameter.get整理番号());
                                dbT3045entity.setJigyoshaNo(決定情報一覧.get事業者番号());
                                dbT3045entity.setYoshikiNo(決定情報一覧.get証明書コード());
                                dbT3045entity.setMeisaiNo(決定情報一覧.get明細番号());
                                dbT3045entity.setRenban(決定情報一覧.get連番());
                                dbT3045entity.setShikyuKubunCode(parameter.get支給区分());
                                dbT3045entity.setSagakuKingaku(決定情報一覧.get差額金額());
                                dbT3045entity.setState(EntityDataState.Modified);
                                償還払請求サービス計画200004Dac.save(dbT3045entity);
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        UrErrorMessages.不正.getMessage().replace("テーブル区分").evaluate());
                        }
                    }
                }
            }
        }
        if (parameter.get決定年月日() != null && !parameter.get決定年月日().isEmpty()) {
            if (決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
                for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                    KyufujissekiEntity entity = getKyufujisseki(parameter.get被保険者番号(),
                            parameter.getサービス提供年月(), parameter.get整理番号(),
                            決定情報一覧.get事業者番号(), 決定情報一覧.get証明書コード(),
                            決定情報一覧.get明細番号());
                    SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                            = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
                    manager.dealKyufujisseki(parameter.get画面モード(), parameter.get識別コード(),
                            entity, 修正前支給区分);
                }
            }
        }
    }

    /**
     * 社福軽減額サービス種類取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public List<ShafukukeigenServiceEntity> getShafukukeigenServiceList(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShafukukeigenServiceParameter parameter
                = ShafukukeigenServiceParameter.createSelectByKeyParam(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        ISyokanbaraihiShikyuShinseiKetteMapper mapper
                = mapperProvider.create(ISyokanbaraihiShikyuShinseiKetteMapper.class);
        List<ShafukukeigenServiceEntity> entityList = mapper.get社福軽減額サービス種類(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 社福軽減額軽減率取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> getShafukukeigenKeigenrichiList(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        DbT3034ShokanShinseiEntity dbT3034entity = 償還払支給申請Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        if (dbT3034entity == null) {
            return new ArrayList<>();
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = dbT3034entity.getShoKisaiHokenshaNo();

        List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> entityList
                = 軽減率Dac.selectByKey(証記載保険者番号, 被保険者番号);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 標準負担額（日額）取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return
     */
    public Decimal getHyojyunfutangaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        DbT3034ShokanShinseiEntity dbT3034entity = 償還払支給申請Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        if (dbT3034entity == null) {
            return new Decimal(0);
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = dbT3034entity.getShoKisaiHokenshaNo();

        DbT4012HyojunFutangakuGemmenEntity dbt4012entity
                = 標準負担額減免Dac.selectByKey(証記載保険者番号, 被保険者番号);
        if (dbt4012entity != null) {
            return dbt4012entity.getGengakugoKingaku();
        }
        DbT7131KaigoServiceNaiyouEntity dbt7131entity = 介護サービスDac.select介護サービス(サービス年月);
        if (dbt7131entity == null) {
            return new Decimal(0);
        }
        return new Decimal(dbt7131entity.getTaniSu());

    }

    /**
     * 給付実績データ取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return 給付実績データ
     */
    public KyufujissekiEntity getKyufujisseki(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShinsei> shokanShinseiList
                = shokai.getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        DbT3034ShokanShinseiEntity dbT3034ShokanShinsei = shokanShinseiList.get(0).toEntity();
        DbT3036ShokanHanteiKekkaEntity dbT3036ShokanHanteiKekka
                = getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
        DbT3038ShokanKihonEntity dbT3038ShokanKihon
                = shokai.getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月,
                        整理番号, 事業者番号, 様式番号, 明細番号).toEntity();
        List<ShokanMeisaiResult> entityList1 = shokai.getShokanbarayiSeikyuMeisayiList(被保険者番号,
                サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null, null);
        List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai = new ArrayList<>();
        if (entityList1 != null && !entityList1.isEmpty()) {
            for (ShokanMeisaiResult entity : entityList1) {
                dbT3039ShokanMeisai.add(entity.getEntity().toEntity());
            }
        }
        List<ShokanMeisaiJushochiTokureiEntity> entityList2
                = shokai.getShokanbarayiSeikyuMeisayiJyutokuList(被保険者番号,
                        サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisaiJushochiTokurei = new ArrayList<>();
        if (entityList2 != null && !entityList2.isEmpty()) {
            for (ShokanMeisaiJushochiTokureiEntity entity : entityList2) {
                dbT3107ShokanMeisaiJushochiTokurei.add(entity.getEntity());
            }
        }
        List<ShokanKinkyuShisetsuRyoyo> entityList3
                = shokai.getKinkyujiShisetsuRyoyoData(被保険者番号, サービス年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> DbT3040ShokanKinkyuShisetsuRyoyo = new ArrayList<>();
        if (entityList3 != null && !entityList3.isEmpty()) {
            for (ShokanKinkyuShisetsuRyoyo entity : entityList3) {
                DbT3040ShokanKinkyuShisetsuRyoyo.add(entity.toEntity());
            }
        }
        List<ShokanTokuteiShinryohi> entityList4
                = shokai.getTokuteiShinryohiData(被保険者番号, サービス年月,
                        整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3041ShokanTokuteiShinryohiEntity> DbT3041ShokanTokuteiShinryohi = new ArrayList<>();
        if (entityList4 != null && !entityList4.isEmpty()) {
            for (ShokanTokuteiShinryohi entity : entityList4) {
                DbT3041ShokanTokuteiShinryohi.add(entity.toEntity());
            }
        }
        List<ShokanTokuteiShinryoTokubetsuRyoyo> entityList5
                = shokai.getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス年月,
                        整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> DbT3042ShokanTokuteiShinryoTokubetsuRyoyo
                = new ArrayList<>();
        if (entityList5 != null && !entityList5.isEmpty()) {
            for (ShokanTokuteiShinryoTokubetsuRyoyo entity : entityList5) {
                DbT3042ShokanTokuteiShinryoTokubetsuRyoyo.add(entity.toEntity());
            }
        }
        List<ShokanShokujiHiyo> entityList6
                = shokai.getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス年月,
                        整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3043ShokanShokujiHiyoEntity> DbT3043ShokanShokujiHiyo = new ArrayList<>();
        if (entityList6 != null && !entityList6.isEmpty()) {
            for (ShokanShokujiHiyo entity : entityList6) {
                DbT3043ShokanShokujiHiyo.add(entity.toEntity());
            }
        }
        List<ServiceKeikakuHiRealtEntity> ServiceKeikakuHiRealt = new ArrayList<>();
        ServiceKeikakuHiRealtEntity serviceEntity;
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス年月)) {
            List<ShokanServicePlan200904Result> entityList7
                    = shokai.getServiceKeikaku200904(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号, null);
            if (entityList7 != null && !entityList7.isEmpty()) {
                for (ShokanServicePlan200904Result entity : entityList7) {
                    serviceEntity = new ServiceKeikakuHiRealtEntity(entity.getEntity().toEntity(), null, null);
                    ServiceKeikakuHiRealt.add(serviceEntity);
                }
            }
        } else if (new FlexibleYearMonth("200604").isBeforeOrEquals(サービス年月)
                && サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200903"))) {
            List<ShokanServicePlan200604Result> entityList8
                    = shokai.getServiceKeikaku200604(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号, null);
            if (entityList8 != null && !entityList8.isEmpty()) {
                for (ShokanServicePlan200604Result entity : entityList8) {
                    serviceEntity = new ServiceKeikakuHiRealtEntity(null, entity.getEntity().toEntity(), null);
                    ServiceKeikakuHiRealt.add(serviceEntity);
                }
            }
        } else if (サービス年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            List<ShokanServicePlan200004Result> entityList9
                    = shokai.getServiceKeikaku200004(被保険者番号, サービス年月, 整理番号,
                            事業者番号, 様式番号, 明細番号, null);
            if (entityList9 != null && !entityList9.isEmpty()) {
                for (ShokanServicePlan200004Result entity : entityList9) {
                    serviceEntity = new ServiceKeikakuHiRealtEntity(null, null, entity.getEntity().toEntity());
                    ServiceKeikakuHiRealt.add(serviceEntity);
                }
            }
        }
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> entityList10
                = shokai.getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo
                = new ArrayList<>();
        if (entityList10 != null && !entityList10.isEmpty()) {
            for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : entityList10) {
                DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo.add(entity.toEntity());
            }
        }
        List<ShokanShakaiFukushiHojinKeigengakuEntity> entityList11
                = shokai.getSeikyuShakaifukushiHoujinKeigengaku(被保険者番号, サービス年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> DbT3051ShokanShakaiFukushiHojinKeigengaku
                = new ArrayList<>();
        if (entityList11 != null && !entityList11.isEmpty()) {
            for (ShokanShakaiFukushiHojinKeigengakuEntity entity : entityList11) {
                DbT3051ShokanShakaiFukushiHojinKeigengaku.add(entity.getEntity());
            }
        }
        List<ShokanShoteiShikkanShisetsuRyoyo> entityList12
                = shokai.getShoteiShikanShisetsuRyoyohiEtcData(被保険者番号, サービス年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> DbT3052ShokanShoteiShikkanShisetsuRyoyo
                = new ArrayList<>();
        if (entityList12 != null && !entityList12.isEmpty()) {
            for (ShokanShoteiShikkanShisetsuRyoyo entity : entityList12) {
                DbT3052ShokanShoteiShikkanShisetsuRyoyo.add(entity.toEntity());
            }
        }
        List<ShokanShukeiResult> entityList13 = shokai.getSeikyuShukeiData(被保険者番号,
                サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3053ShokanShukeiEntity> DbT3053ShokanShukei = new ArrayList<>();
        if (entityList13 != null && !entityList13.isEmpty()) {
            for (ShokanShukeiResult entity : entityList13) {
                DbT3053ShokanShukei.add(entity.getShukei().toEntity());
            }
        }
        KyufujissekiEntity tmpEntity = new KyufujissekiEntity(dbT3038ShokanKihon, dbT3034ShokanShinsei,
                dbT3036ShokanHanteiKekka, dbT3039ShokanMeisai, dbT3107ShokanMeisaiJushochiTokurei,
                DbT3040ShokanKinkyuShisetsuRyoyo, DbT3041ShokanTokuteiShinryohi,
                DbT3042ShokanTokuteiShinryoTokubetsuRyoyo, DbT3043ShokanShokujiHiyo, ServiceKeikakuHiRealt,
                DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo, DbT3051ShokanShakaiFukushiHojinKeigengaku,
                DbT3052ShokanShoteiShikkanShisetsuRyoyo, DbT3053ShokanShukei);
        return tmpEntity;
    }

    /**
     * 識別番号一覧データ取得
     *
     * @param 特定診療のサービス種類コード
     * @param 識別コード2
     * @param 基準年月
     * @return List<DbT7120TokuteiShinryoServiceCodeEntity>
     */
    public List<DbT7120TokuteiShinryoServiceCodeEntity> getShikibetsuBangoIchiran(
            ServiceShuruiCode 特定診療のサービス種類コード,
            ServiceKomokuCode 識別コード2, FlexibleYearMonth 基準年月) {
        List<DbT7120TokuteiShinryoServiceCodeEntity> entityList
                = 特定診療サービスコードDac.selectAllByKey(特定診療のサービス種類コード, 識別コード2, 基準年月);
        return entityList;
    }

    /**
     *
     * サービス計画費情報件数取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return データ件数
     */
    public int updShokanServicePlan(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200904Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200603"))) {
            return 償還払請求サービス計画200004Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        return 償還払請求サービス計画200604Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }
}
