/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
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
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuhi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
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
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShakaiFukushiHojinRiyoshaFutanKeigen;
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
    private static final int テーブル区分3 = 3;
    private static final int テーブル区分4 = 4;
    private static final int テーブル区分5 = 5;
    private static final int テーブル区分6 = 6;
    private static final int テーブル区分7 = 7;
    private static final int テーブル区分8 = 8;
    private static final RString サービス年月 = new RString("200904");
    private static final RString サービス年月1 = new RString("200604");
    private static final RString サービス年月2 = new RString("200303");
    private static final RString サービス年月3 = new RString("200903");
    private static final RString サービス年月4 = new RString("200603");

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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return ShokanHanteiKekka
     */
    public ShokanHanteiKekka getSyokanbaraiketteKekka(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        DbT3036ShokanHanteiKekkaEntity entity
                = 償還払支給判定結果Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号);
        if (entity == null) {
            return null;
        }
        return new ShokanHanteiKekka(entity);
    }

    /**
     * 証明書件数取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
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
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200904Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }
        if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200604Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }
        return 償還払請求サービス計画200004Dac.selectデータ件数(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号);
    }

    /**
     * 識別番号管理情報取得する。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 識別番号 識別番号
     * @return ShikibetsuNoKanri
     */
    public ShikibetsuNoKanri getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月,
            RString 識別番号) {
        DbT3118ShikibetsuNoKanriEntity entity = 識別番号管理Dac.select識別番号管理(識別番号, サービス提供年月);
        if (entity == null) {
            return null;
        }
        return new ShikibetsuNoKanri(entity);
    }

    /**
     * 支給申請登録
     *
     * @param shinsei shinsei
     * @return 整理番号
     */
    public RString insDbT3034ShokanShinsei(ShokanShinsei shinsei) {

        RString 整理番号
                = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString();

        DbT3034ShokanShinseiEntity entity = shinsei.toEntity();
        entity.setSeiriNo(整理番号);
        entity.setState(EntityDataState.Added);
        償還払支給申請Dac.save(entity);
        return 整理番号;
    }

    /**
     * 支給申請更新
     *
     * @param shinsei shinsei
     * @return 更新件数
     */
    public int updDbT3034ShokanShinsei(ShokanShinsei shinsei) {

        DbT3034ShokanShinseiEntity entity = shinsei.toEntity();
        entity.setState(EntityDataState.Modified);
        return 償還払支給申請Dac.save(entity);
    }

    /**
     * 支給申請削除
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 識別コード 識別コード
     * @return 削除件数
     */
    @Transaction
    public int delDbT3034ShokanShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, ShikibetsuCode 識別コード) {

        int count = 0;
        boolean 給付実績処理フラグ;
        KyufujissekiEntity kyufuentity = null;
        DbT3036ShokanHanteiKekkaEntity entity = 償還払支給判定結果Dac.selectByKey(被保険者番号,
                サービス提供年月, 整理番号);
        if (entity == null) {
            給付実績処理フラグ = false;
        } else {
//            kyufuentity = getKyufujisseki(被保険者番号, サービス提供年月, 整理番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setSeiriNo(整理番号);
            entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.save(entity);
            給付実績処理フラグ = true;
        }
        ShafukukeigenServiceParameter parameter
                = ShafukukeigenServiceParameter.createSelectByKeyParam(被保険者番号, サービス提供年月, 整理番号, null, null, null);
        ISyokanbaraihiShikyuShinseiKetteMapper mapper
                = mapperProvider.create(ISyokanbaraihiShikyuShinseiKetteMapper.class);
        count = count + delete証明書(parameter, サービス提供年月);
        count = count + mapper.delete償還払支給申請(parameter);

        if (給付実績処理フラグ) {
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(new RString("削除"), 識別コード, kyufuentity, null);
        }
        return count;
    }

    /**
     * 証明書管理一覧取得
     *
     * @param サービス提供年月 サービス提供年月
     * @return List<ShikibetsuNoKanri>
     */
    public List<ShikibetsuNoKanri> getShikibetsuNoKanri(FlexibleYearMonth サービス提供年月) {

        List<DbT3118ShikibetsuNoKanriEntity> entityList
                = 識別番号管理Dac.select識別番号管理(サービス提供年月);
        if (entityList == null) {
            return new ArrayList<>();
        }
        List<ShikibetsuNoKanri> kanriList = new ArrayList<>();
        for (DbT3118ShikibetsuNoKanriEntity entity : entityList) {
            kanriList.add(new ShikibetsuNoKanri(entity));
        }
        return kanriList;
    }

    /**
     * 基本情報件数を取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 特定診療費情報件数
     */
    public int updShokanTokuteiShinryohi(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月2.toString()))) {
            return 償還払請求特定診療費Dac.select件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        return 特別療養費Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 特定入所者費用情報件数取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
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
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     */
    public void delShokanSyomeisyo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        ShafukukeigenServiceParameter parameter
                = ShafukukeigenServiceParameter.createSelectByKeyParam(被保険者番号,
                        サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        delete証明書(parameter, サービス提供年月);

    }

    /**
     * 基本情報登録更新処理
     *
     * @param 明細番号 明細番号
     * @param kihon kihon
     * @return 明細番号
     */
    public RString updShokanKihon(RString 明細番号, ShokanKihon kihon) {

        DbT3038ShokanKihonEntity entity = kihon.toEntity();
        if (明細番号 == null || 明細番号.isEmpty()) {
            明細番号 = new RString("0001");
            entity.setState(EntityDataState.Added);
            償還払請求基本Dac.save(entity);
            return 明細番号;
        } else {
            entity.setState(EntityDataState.Modified);
            償還払請求基本Dac.save(entity);
            return 明細番号;
        }
    }

    /**
     * 給付費明細（住特）登録更新処理
     *
     * @param entityList entityList
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
     * @param entityList entityList
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
     * @param dbt3041entityList dbt3041entityList
     * @param dbt3042entityList dbt3042entityList
     * @param parameter parameter
     */
    @Transaction
    public void updShokanTokuteiShinryohi(List<ShokanTokuteiShinryohi> dbt3041entityList,
            List<ShokanTokuteiShinryoTokubetsuRyoyo> dbt3042entityList,
            ShokanKihonParameter parameter) {

        int 合計金額 = 0;
        boolean 変更区分 = false;
        if (parameter.get提供購入年月().isBeforeOrEquals(new FlexibleYearMonth(サービス年月2.toString()))
                && (dbt3041entityList != null && !dbt3041entityList.isEmpty())) {
            for (ShokanTokuteiShinryohi dbt3041entity : dbt3041entityList) {
                if (!EntityDataState.Deleted.equals(dbt3041entity.toEntity().getState())) {
                    合計金額 = 合計金額 + dbt3041entity.get合計単位数();
                }
                if (!EntityDataState.Unchanged.equals(dbt3041entity.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求特定診療費Dac.save(dbt3041entity.toEntity());
                }
            }
        } else if (new FlexibleYearMonth("200304").isBeforeOrEquals(parameter.get提供購入年月())
                && (dbt3042entityList != null && !dbt3042entityList.isEmpty())) {
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
     * @param dbt3047entityList dbt3047entityList
     * @param dbt3046entity dbt3046entity
     * @param dbt3045entity dbt3045entity
     * @param サービス提供年月 サービス提供年月
     * @param 明細番号 明細番号
     * @return 明細番号
     */
    @Transaction
    public RString updShokanServicePlan(List<ShokanServicePlan200904> dbt3047entityList,
            ShokanServicePlan200604 dbt3046entity,
            ShokanServicePlan200004 dbt3045entity,
            FlexibleYearMonth サービス提供年月, RString 明細番号) {

        boolean 明細番号区分 = false;
        if (明細番号 == null || 明細番号.isEmpty()) {
            明細番号 = new RString("0001");
            明細番号区分 = true;
        }
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)
                && (dbt3047entityList != null && !dbt3047entityList.isEmpty())
                && 明細番号区分) {
            for (ShokanServicePlan200904 dbt3047entity : dbt3047entityList) {
                DbT3047ShokanServicePlan200904Entity entity;
                if (!EntityDataState.Deleted.equals(dbt3047entity.toEntity().getState())) {
                    entity = dbt3047entity.toEntity();
                    entity.setState(EntityDataState.Added);
                    償還払請求サービス計画200904Dac.save(entity);
                }
            }
        } else if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)
                && (dbt3047entityList != null && !dbt3047entityList.isEmpty())
                && !明細番号区分) {
            for (ShokanServicePlan200904 dbt3047entity : dbt3047entityList) {
                償還払請求サービス計画200904Dac.save(dbt3047entity.toEntity());
            }
        } else if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)
                && (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月3.toString())))) {
            DbT3046ShokanServicePlan200604Entity entity = dbt3046entity.toEntity();
            if (明細番号区分) {
                entity.setState(EntityDataState.Added);
                償還払請求サービス計画200604Dac.save(entity);
            } else {
                entity.setState(EntityDataState.Modified);
                償還払請求サービス計画200604Dac.save(entity);
            }
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月4.toString()))) {
            DbT3045ShokanServicePlan200004Entity entity = dbt3045entity.toEntity();
            if (明細番号区分) {
                entity.setState(EntityDataState.Added);
                償還払請求サービス計画200004Dac.save(entity);
            } else {
                entity.setState(EntityDataState.Modified);
                償還払請求サービス計画200004Dac.save(entity);
            }
        }
        return 明細番号;
    }

    /**
     * 特定入所者費用登録更新処理
     *
     * @param parameter parameter
     * @param 特定入所者費用List 特定入所者費用List
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
     * @param entityList entityList
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
     * @param parameter parameter
     * @param 緊急時所定疾患List 緊急時所定疾患List
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
     * @param parameter parameter
     * @param 緊急時施設療養費List 緊急時施設療養費List
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
     * @param shukeiList shukeiList
     * @param parameter parameter
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
     * @param dbt3043entity dbt3043entity
     * @param dbt3039entityList dbt3039entityList
     * @param parameter parameter
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
                && parameter.get提供購入年月().isBeforeOrEquals(new FlexibleYearMonth("200509"))
                && (dbt3039entityList != null && !dbt3039entityList.isEmpty())) {
            for (ShokanMeisai dbt3039entity : dbt3039entityList) {
                償還払請求明細Dac.save(dbt3039entity.toEntity());
            }
        }
        DbT3043ShokanShokujiHiyoEntity entity = dbt3043entity.toEntity();
        if (entityList == null || entityList.isEmpty()) {
            entity.setState(EntityDataState.Added);
            償還払請求食事費用Dac.save(entity);

        } else {
            entity.setState(EntityDataState.Modified);
            償還払請求食事費用Dac.save(entity);
        }
    }

    /**
     * 決定情報登録更新
     *
     * @param parameter parameter
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
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
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
                entity.setState(EntityDataState.Modified);
                償還払支給判定結果Dac.save(entity);
                修正前支給区分 = dbT3036entity.getShikyuHushikyuKetteiKubun();
            }
            DbT3053ShokanShukeiEntity dbT3053entity = new DbT3053ShokanShukeiEntity();
            dbT3053entity.setHiHokenshaNo(parameter.get被保険者番号());
            dbT3053entity.setServiceTeikyoYM(parameter.getサービス提供年月());
            dbT3053entity.setState(EntityDataState.Modified);
            償還払請求集計Dac.save(dbT3053entity);
        }
        if (parameter.is差額金額登録フラグ() && (決定情報一覧List != null && !決定情報一覧List.isEmpty())) {
            for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
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
                    case テーブル区分3:
                        dbT3053entity.setHiHokenshaNo(parameter.get被保険者番号());
                        dbT3053entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                        dbT3053entity.setSeiriNo(parameter.get整理番号());
                        dbT3053entity.setState(EntityDataState.Modified);
                        償還払請求集計Dac.save(dbT3053entity);
                        break;
                    case テーブル区分4:
                        dbT3043entity.setHiHokenshaNo(parameter.get被保険者番号());
                        dbT3043entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                        dbT3043entity.setSeiriNp(parameter.get整理番号());
                        dbT3043entity.setState(EntityDataState.Modified);
                        償還払請求食事費用Dac.save(dbT3043entity);
                        break;
                    case テーブル区分5:
                        dbT3050entity.setHiHokenshaNo(parameter.get被保険者番号());
                        dbT3050entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                        dbT3050entity.setState(EntityDataState.Modified);
                        償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity);
                        break;
                    case テーブル区分6:
                        dbT3047entity.setHiHokenshaNo(parameter.get被保険者番号());
                        dbT3047entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                        dbT3047entity.setState(EntityDataState.Modified);
                        償還払請求サービス計画200904Dac.save(dbT3047entity);
                        break;
                    case テーブル区分7:
                        dbT3046entity.setHiHokenshaNo(parameter.get被保険者番号());
                        dbT3046entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                        dbT3046entity.setState(EntityDataState.Modified);
                        償還払請求サービス計画200604Dac.save(dbT3046entity);
                        break;
                    case テーブル区分8:
                        dbT3045entity.setHiHokenshaNo(parameter.get被保険者番号());
                        dbT3045entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                        dbT3045entity.setState(EntityDataState.Modified);
                        償還払請求サービス計画200004Dac.save(dbT3045entity);
                        break;
                    default:
                        throw new IllegalArgumentException(
                                UrErrorMessages.不正.getMessage().replace("テーブル区分").evaluate());
                }
            }
        }
        if (parameter.get決定年月日() != null && !parameter.get決定年月日().isEmpty()
                && (決定情報一覧List != null && !決定情報一覧List.isEmpty())) {
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

    /**
     * 社福軽減額サービス種類取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<ShafukukeigenServiceResult>
     */
    public List<ShafukukeigenServiceResult> getShafukukeigenServiceList(HihokenshaNo 被保険者番号,
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
        List<ShafukukeigenServiceResult> resultList = new ArrayList<>();
        for (ShafukukeigenServiceEntity entity : entityList) {
            resultList.add(new ShafukukeigenServiceResult(entity));
        }
        return resultList;
    }

    /**
     * 社福軽減額軽減率取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<ShakaiFukushiHojinRiyoshaFutanKeigen>
     */
    public List<ShakaiFukushiHojinRiyoshaFutanKeigen> getShafukukeigenKeigenrichiList(
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
        List<ShakaiFukushiHojinRiyoshaFutanKeigen> 社福軽減額軽減率List = new ArrayList<>();
        for (DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity : entityList) {
            社福軽減額軽減率List.add(new ShakaiFukushiHojinRiyoshaFutanKeigen(entity));
        }
        return 社福軽減額軽減率List;
    }

    /**
     * 標準負担額（日額）取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 標準負担額（日額）
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
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 給付実績データ
     */
    public KyufujissekiEntity getKyufujisseki(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShinsei> shokanShinseiList
                = shokai.getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        DbT3034ShokanShinseiEntity dbT3034ShokanShinsei = shokanShinseiList.get(0).toEntity();
        ShokanHanteiKekka kekka = getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
        DbT3036ShokanHanteiKekkaEntity dbT3036ShokanHanteiKekka;
        if (kekka == null) {
            dbT3036ShokanHanteiKekka = null;
        } else {
            dbT3036ShokanHanteiKekka = kekka.toEntity();
        }
        DbT3038ShokanKihonEntity dbT3038ShokanKihon;
        ShokanKihon kihon = shokai.getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
        if (kihon == null) {
            dbT3038ShokanKihon = null;
        } else {
            dbT3038ShokanKihon = kihon.toEntity();
        }
        List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai
                = get償還払請求明細(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisai
                = get住所地特例(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> dbT3040Shokan
                = get緊急時施設療養(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3041ShokanTokuteiShinryohiEntity> dbT3041ShokanTokuteiShinryohi
                = get特定診療費(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> dbT3042ShokanTokutei
                = get特別療養費(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3043ShokanShokujiHiyoEntity> dbT3043ShokanShokujiHiyo
                = get償還払請求食事費用(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiRealt
                = getサービス計画(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbT3050ShokanTokutei
                = get介護サービス費用(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> dbT3051ShokanShakai
                = get法人軽減額(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        List<ShokanShoteiShikkanShisetsuRyoyo> entityList12
                = shokai.getShoteiShikanShisetsuRyoyohiEtcData(被保険者番号, サービス年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> dbT3052ShokanShotei = new ArrayList<>();
        if (entityList12 != null && !entityList12.isEmpty()) {
            for (ShokanShoteiShikkanShisetsuRyoyo entity : entityList12) {
                dbT3052ShokanShotei.add(entity.toEntity());
            }
        }
        List<ShokanShukeiResult> entityList13 = shokai.getSeikyuShukeiData(被保険者番号,
                サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3053ShokanShukeiEntity> dbT3053ShokanShukei = new ArrayList<>();
        if (entityList13 != null && !entityList13.isEmpty()) {
            for (ShokanShukeiResult entity : entityList13) {
                dbT3053ShokanShukei.add(entity.getShukei().toEntity());
            }
        }
        KyufujissekiEntity tmpEntity = new KyufujissekiEntity(dbT3038ShokanKihon, dbT3034ShokanShinsei,
                dbT3036ShokanHanteiKekka, dbT3039ShokanMeisai, dbT3107ShokanMeisai,
                dbT3040Shokan, dbT3041ShokanTokuteiShinryohi,
                dbT3042ShokanTokutei, dbT3043ShokanShokujiHiyo, serviceKeikakuHiRealt,
                dbT3050ShokanTokutei, dbT3051ShokanShakai,
                dbT3052ShokanShotei, dbT3053ShokanShukei);
        return tmpEntity;
    }

    /**
     * 識別番号一覧データ取得
     *
     * @param 特定診療のサービス種類コード 特定診療のサービス種類コード
     * @param 識別コード2 識別コード2
     * @param 基準年月 基準年月
     * @return List<TokuteiShinryoServiceCode>
     */
    public List<TokuteiShinryoServiceCode> getShikibetsuBangoIchiran(
            ServiceShuruiCode 特定診療のサービス種類コード,
            ServiceKomokuCode 識別コード2, FlexibleYearMonth 基準年月) {
        List<DbT7120TokuteiShinryoServiceCodeEntity> entityList
                = 特定診療サービスコードDac.selectAllByKey(特定診療のサービス種類コード, 識別コード2, 基準年月);
        List<TokuteiShinryoServiceCode> 識別番号List = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        for (DbT7120TokuteiShinryoServiceCodeEntity entity : entityList) {
            識別番号List.add(new TokuteiShinryoServiceCode(entity));
        }
        return 識別番号List;
    }

    /**
     *
     * サービス計画費情報件数取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return データ件数
     */
    public int updShokanServicePlan(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
            return 償還払請求サービス計画200904Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月4.toString()))) {
            return 償還払請求サービス計画200004Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                    整理番号, 事業者番号, 様式番号, 明細番号);
        }
        return 償還払請求サービス計画200604Dac.selectサービス計画費情報件数(被保険者番号, サービス提供年月,
                整理番号, 事業者番号, 様式番号, 明細番号);
    }

    /**
     * 償還払請求明細取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3039ShokanMeisaiEntity>
     */
    public List<DbT3039ShokanMeisaiEntity> get償還払請求明細(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanMeisaiResult> entityList = shokai.getShokanbarayiSeikyuMeisayiList(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, null, null);
        List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanMeisaiResult entity : entityList) {
                dbT3039ShokanMeisai.add(entity.getEntity().toEntity());
            }
        }
        return dbT3039ShokanMeisai;
    }

    /**
     * 償還払請求明細・住所地特例取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3107ShokanMeisaiJushochiTokureiEntity>
     */
    public List<DbT3107ShokanMeisaiJushochiTokureiEntity> get住所地特例(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanMeisaiJushochiTokureiResult> entityList
                = shokai.getShokanbarayiSeikyuMeisayiJyutokuList(被保険者番号,
                        サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisai = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanMeisaiJushochiTokureiResult entity : entityList) {
                dbT3107ShokanMeisai.add(entity.getEntity().toEntity());
            }
        }
        return dbT3107ShokanMeisai;
    }

    /**
     * 償還払請求緊急時施設療養取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3040ShokanKinkyuShisetsuRyoyoEntity>
     */
    public List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> get緊急時施設療養(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanKinkyuShisetsuRyoyo> entityList
                = shokai.getKinkyujiShisetsuRyoyoData(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> dbT3040Shokan = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanKinkyuShisetsuRyoyo entity : entityList) {
                dbT3040Shokan.add(entity.toEntity());
            }
        }
        return dbT3040Shokan;
    }

    /**
     * 償還払請求特定診療費取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3041ShokanTokuteiShinryohiEntity>
     */
    public List<DbT3041ShokanTokuteiShinryohiEntity> get特定診療費(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanTokuteiShinryohi> entityList
                = shokai.getTokuteiShinryohiData(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3041ShokanTokuteiShinryohiEntity> dbT3041ShokanTokuteiShinryohi = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanTokuteiShinryohi entity : entityList) {
                dbT3041ShokanTokuteiShinryohi.add(entity.toEntity());
            }
        }
        return dbT3041ShokanTokuteiShinryohi;
    }

    /**
     * 償還払請求特定診療費・特別療養費取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity>
     */
    public List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> get特別療養費(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> entityList
                = shokai.getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> dbT3042ShokanTokutei = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanTokuteiShinryoTokubetsuRyoyo entity : entityList) {
                dbT3042ShokanTokutei.add(entity.toEntity());
            }
        }
        return dbT3042ShokanTokutei;
    }

    /**
     * 償還払請求食事費用取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     */
    public List<DbT3043ShokanShokujiHiyoEntity> get償還払請求食事費用(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShokujiHiyo> entityList
                = shokai.getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号, null);
        List<DbT3043ShokanShokujiHiyoEntity> dbT3043ShokanShokujiHiyo = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanShokujiHiyo entity : entityList) {
                dbT3043ShokanShokujiHiyo.add(entity.toEntity());
            }
        }
        return dbT3043ShokanShokujiHiyo;
    }

    /**
     * 償還払請求サービス計画取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<ServiceKeikakuHiRealtEntity>
     */
    public List<ServiceKeikakuHiRealtEntity> getサービス計画(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiRealt = new ArrayList<>();
        ServiceKeikakuHiRealtEntity serviceEntity;
        List<ShokanServicePlan200904Result> entityList7
                = shokai.getServiceKeikaku200904(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<ShokanServicePlan200604Result> entityList8
                = shokai.getServiceKeikaku200604(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<ShokanServicePlan200004Result> entityList9
                = shokai.getServiceKeikaku200004(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)
                && (entityList7 != null && !entityList7.isEmpty())) {
            for (ShokanServicePlan200904Result entity : entityList7) {
                serviceEntity = new ServiceKeikakuHiRealtEntity(entity.getEntity().toEntity(), null, null);
                serviceKeikakuHiRealt.add(serviceEntity);
            }
        } else if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月3.toString()))
                && (entityList8 != null && !entityList8.isEmpty())) {
            for (ShokanServicePlan200604Result entity : entityList8) {
                serviceEntity = new ServiceKeikakuHiRealtEntity(null, entity.getEntity().toEntity(), null);
                serviceKeikakuHiRealt.add(serviceEntity);
            }
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月4.toString()))
                && (entityList9 != null && !entityList9.isEmpty())) {
            for (ShokanServicePlan200004Result entity : entityList9) {
                serviceEntity = new ServiceKeikakuHiRealtEntity(null, null, entity.getEntity().toEntity());
                serviceKeikakuHiRealt.add(serviceEntity);
            }
        }
        return serviceKeikakuHiRealt;
    }

    /**
     * 償還払請求特定入所者介護サービス費用取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     */
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> get介護サービス費用(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> entityList
                = shokai.getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbT3050ShokanTokutei = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanTokuteiNyushoshaKaigoServiceHiyo entity : entityList) {
                dbT3050ShokanTokutei.add(entity.toEntity());
            }
        }
        return dbT3050ShokanTokutei;
    }

    /**
     * 償還払請求社会福祉法人軽減額取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity>
     */
    public List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> get法人軽減額(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, JigyoshaNo 事業者番号,
            RString 様式番号, RString 明細番号) {
        ShokanbaraiJyokyoShokai shokai = ShokanbaraiJyokyoShokai.createInstance();
        List<ShokanShakaiFukushiHojinKeigengakuResult> entityList
                = shokai.getSeikyuShakaifukushiHoujinKeigengaku(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号, null);
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> dbT3051ShokanShakai = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanShakaiFukushiHojinKeigengakuResult entity : entityList) {
                dbT3051ShokanShakai.add(
                        entity.getShokanShakai().toEntity());
            }
        }
        return dbT3051ShokanShakai;
    }

    /**
     * 証明書の削除処理を行う
     *
     * @param parameter parameter
     * @param サービス提供年月 サービス提供年月
     * @return 削除件数
     */
    private int delete証明書(ShafukukeigenServiceParameter parameter, FlexibleYearMonth サービス提供年月) {
        int count = 0;
        ISyokanbaraihiShikyuShinseiKetteMapper mapper
                = mapperProvider.create(ISyokanbaraihiShikyuShinseiKetteMapper.class);
        count = count + mapper.delete償還払請求基本(parameter);
        count = count + mapper.delete住所地特例(parameter);
        count = count + mapper.delete償還払請求明細(parameter);
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月2.toString()))) {
            count = count + mapper.delete償還払請求特定診療費(parameter);
        } else {
            count = count + mapper.delete特別療養費(parameter);
        }
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
            count = count + mapper.deleteサービス計画200904(parameter);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月3.toString()))
                && new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)) {
            count = count + mapper.deleteサービス計画200604(parameter);
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月4.toString()))) {
            count = count + mapper.deleteサービス計画200004(parameter);
        }
        count = count + mapper.delete特定入所者介護サービス費用(parameter);
        count = count + mapper.delete社会福祉法人軽減額(parameter);
        count = count + mapper.delete所定疾患施設療養費等(parameter);
        count = count + mapper.delete償還払請求緊急時施設療養(parameter);
        count = count + mapper.delete償還払請求集計(parameter);
        count = count + mapper.delete償還払請求食事費用(parameter);
        return count;
    }
}
