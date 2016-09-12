/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TokuteiShinryoServiceCode;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuhi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShokanKihonParameter;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraishikyukettekyufujssekihensyu.KyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette.SyokanbaraihiShikyuShinseiKetteParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.ShafukukeigenServiceParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
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
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.ShafukukeigenServiceEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
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
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3107ShokanMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7120TokuteiShinryoServiceCodeDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette.ISyokanbaraihiShikyuShinseiKetteMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
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
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
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
 *
 * @reamsid_L DBC-1030-200 xicongwang
 */
public class SyokanbaraihiShikyuShinseiKetteManager extends SyokanbaraihiShikyuShinseiKetteFath {

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
    private static final RString テーブル区分 = new RString("3");
    private static final RString テーブル区分_6 = new RString("6");
    private static final RString テーブル区分_7 = new RString("7");
    private static final RString テーブル区分_8 = new RString("8");
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
    private static final RString モード_削除 = new RString("削除");
    private static final RString 定値_明細番号 = new RString("0001");
    private static final FlexibleYearMonth 定値_提供購入年月 = new FlexibleYearMonth("200304");
    private static final FlexibleYearMonth 提供購入年月_200509 = new FlexibleYearMonth("200509");
    private static final FlexibleYearMonth サービス年月_200904 = new FlexibleYearMonth("200904");
    private static final RString モード_修正 = new RString("修正");

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

        boolean 給付実績処理フラグ;
        KyufujissekiEntity kyufuentity = null;
        DbT3036ShokanHanteiKekkaEntity entity = 償還払支給判定結果Dac.selectByKey(被保険者番号,
                サービス提供年月, 整理番号);
        if (entity == null) {
            給付実績処理フラグ = false;
        } else {
            kyufuentity = getKyufuJissekiData(被保険者番号, サービス提供年月, 整理番号);
            entity.setHiHokenshaNo(被保険者番号);
            entity.setServiceTeikyoYM(サービス提供年月);
            entity.setSeiriNo(整理番号);
            entity.setState(EntityDataState.Deleted);
            償還払支給判定結果Dac.delete(entity);
            給付実績処理フラグ = true;
        }
        int count = delete証明書(被保険者番号, サービス提供年月, 整理番号, null, null, null);
        DbT3034ShokanShinseiEntity dbt3034entity = 償還払支給申請Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号);
        dbt3034entity.setState(EntityDataState.Deleted);
        count = count + 償還払支給申請Dac.delete(dbt3034entity);

        if (給付実績処理フラグ) {
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(モード_削除, 識別コード, kyufuentity, null);
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
        return 償還払請求食事費用Dac.select件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
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
    @Transaction
    public void delShokanSyomeisyo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        delete証明書(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
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
            明細番号 = 定値_明細番号;
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
                if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
                    住所地特例Dac.delete(entity.toEntity());
                } else {
                    住所地特例Dac.save(entity.toEntity());
                }
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
                if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
                    償還払請求明細Dac.delete(entity.toEntity());
                } else {
                    償還払請求明細Dac.save(entity.toEntity());
                }
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
                if (EntityDataState.Deleted.equals(dbt3041entity.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求特定診療費Dac.delete(dbt3041entity.toEntity());
                } else if (!EntityDataState.Unchanged.equals(dbt3041entity.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求特定診療費Dac.save(dbt3041entity.toEntity());
                }
            }
        } else if (定値_提供購入年月.isBeforeOrEquals(parameter.get提供購入年月())
                && (dbt3042entityList != null && !dbt3042entityList.isEmpty())) {
            for (ShokanTokuteiShinryoTokubetsuRyoyo dbt3042entity : dbt3042entityList) {
                if (!EntityDataState.Deleted.equals(dbt3042entity.toEntity().getState())) {
                    合計金額 = 合計金額 + dbt3042entity.get合計単位数();
                }
                if (EntityDataState.Deleted.equals(dbt3042entity.toEntity().getState())) {
                    変更区分 = true;
                    特別療養費Dac.delete(dbt3042entity.toEntity());
                } else if (!EntityDataState.Unchanged.equals(dbt3042entity.toEntity().getState())) {
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
            明細番号 = 定値_明細番号;
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
                償還払請求サービス計画(dbt3047entity);
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

    private void 償還払請求サービス計画(ShokanServicePlan200904 dbt3047entity) {
        if (EntityDataState.Deleted.equals(dbt3047entity.toEntity().getState())) {
            償還払請求サービス計画200904Dac.delete(dbt3047entity.toEntity());
        } else {
            償還払請求サービス計画200904Dac.save(dbt3047entity.toEntity());
        }
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
                if (EntityDataState.Deleted.equals(特定入所者費用.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求特定入所者介護サービス費用Dac.delete(特定入所者費用.toEntity());
                } else if (!EntityDataState.Unchanged.equals(特定入所者費用.toEntity().getState())) {
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
                if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
                    償還払請求社会福祉法人軽減額Dac.delete(entity.toEntity());
                } else if (!EntityDataState.Unchanged.equals(entity.toEntity().getState())) {
                    償還払請求社会福祉法人軽減額Dac.save(entity.toEntity());
                }
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
                if (EntityDataState.Deleted.equals(緊急時所定疾患.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求所定疾患施設療養費等Dac.delete(緊急時所定疾患.toEntity());
                } else if (!EntityDataState.Unchanged.equals(緊急時所定疾患.toEntity().getState())) {
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
                if (EntityDataState.Deleted.equals(緊急時施設療養費.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求緊急時施設療養Dac.delete(緊急時施設療養費.toEntity());
                } else if (!EntityDataState.Unchanged.equals(緊急時施設療養費.toEntity().getState())) {
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

        Decimal 請求額合計 = Decimal.ZERO;
        int 利用者負担額合計 = 0;
        if (shukeiList != null && !shukeiList.isEmpty()) {
            boolean 変更区分 = false;
            for (ShokanShukei shukei : shukeiList) {
                if (!EntityDataState.Deleted.equals(shukei.toEntity().getState())) {
                    請求額合計 = 請求額合計.add(nullTOEmpty(shukei.get請求額()));
                    利用者負担額合計 = 利用者負担額合計 + shukei.get利用者負担額();
                }
                if (EntityDataState.Deleted.equals(shukei.toEntity().getState())) {
                    変更区分 = true;
                    償還払請求集計Dac.delete(shukei.toEntity());
                } else if (!EntityDataState.Unchanged.equals(shukei.toEntity().getState())) {
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
        if (定値_提供購入年月.isBeforeOrEquals(parameter.get提供購入年月())
                && parameter.get提供購入年月().isBeforeOrEquals(提供購入年月_200509)
                && (dbt3039entityList != null && !dbt3039entityList.isEmpty())) {
            for (ShokanMeisai dbt3039entity : dbt3039entityList) {
                if (EntityDataState.Deleted.equals(dbt3039entity.toEntity().getState())) {
                    償還払請求明細Dac.delete(dbt3039entity.toEntity());
                } else {
                    償還払請求明細Dac.save(dbt3039entity.toEntity());
                }
            }
        }
        if (dbt3043entity != null && !EntityDataState.Unchanged.equals(dbt3043entity.toEntity().getState())) {
            DbT3043ShokanShokujiHiyoEntity entity = dbt3043entity.toEntity();
            if (entityList == null || entityList.isEmpty()) {
                entity.setState(EntityDataState.Added);
                償還払請求食事費用Dac.save(entity);

            } else {
                entity.setState(EntityDataState.Modified);
                償還払請求食事費用Dac.save(entity);
            }
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
                DbT3034ShokanShinseiEntity dbt3034entity = 償還払支給申請Dac.selectByKey(parameter.get被保険者番号(),
                        parameter.getサービス提供年月(), parameter.get整理番号());
                DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
                entity.setHiHokenshaNo(parameter.get被保険者番号());
                entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                entity.setSeiriNo(parameter.get整理番号());
                entity.setShoKisaiHokenshaNo(dbt3034entity == null ? new ShoKisaiHokenshaNo(RString.EMPTY)
                        : dbt3034entity.getShoKisaiHokenshaNo());
                entity.setKetteiYMD(parameter.get決定年月日());
                entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分());
                entity.setShiharaiKingaku(parameter.get支払金額合計());
                entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(entity);
                修正前支給区分 = ShikyuFushikyuKubun.不支給.getコード();

            } else {
                insert償還払支給判定結果(parameter, dbT3036entity);
                修正前支給区分 = parameter.get支給区分();
            }
            List<DbT3053ShokanShukeiEntity> entityList = 償還払請求集計Dac.select住宅改修費(parameter.get被保険者番号(),
                    parameter.getサービス提供年月(), parameter.get整理番号());
            int 更新件数 = 0;
            if (entityList != null && !entityList.isEmpty()) {
                for (DbT3053ShokanShukeiEntity entity : entityList) {
                    更新件数 = 更新件数 + up償還払請求集計(entity, parameter, 決定情報一覧List);
                }
            }
            if (更新件数 == 0 && 決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
                for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                    決定情報登録更新1(parameter, 決定情報一覧);
                }
            }
        }
        if (parameter.is差額金額登録フラグ() && (決定情報一覧List != null && !決定情報一覧List.isEmpty())) {
            for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                決定情報登録更新2(parameter, 決定情報一覧);
            }
        }
        if (parameter.get決定年月日() != null && !parameter.get決定年月日().isEmpty()) {
            KyufujissekiEntity entity = getKyufuJissekiData(parameter.get被保険者番号(),
                    parameter.getサービス提供年月(), parameter.get整理番号());
            SyokanbaraiShikyuKetteKyufuJssekiHensyuManager manager
                    = SyokanbaraiShikyuKetteKyufuJssekiHensyuManager.createInstance();
            manager.dealKyufujisseki(parameter.get画面モード(), parameter.get識別コード(),
                    entity, 修正前支給区分);
        }
    }

    private void insert償還払支給判定結果(SyokanbaraihiShikyuShinseiKetteParameter parameter, DbT3036ShokanHanteiKekkaEntity dbT3036entity) {
        dbT3036entity.setKetteiYMD(parameter.get決定年月日());
        dbT3036entity.setShikyuHushikyuKetteiKubun(parameter.get支給区分());
        dbT3036entity.setShiharaiKingaku(parameter.get支払金額合計());
        if (モード_修正.equals(parameter.get画面モード()) && !parameter.get支払金額合計初期().equals(parameter.get支払金額合計())) {
            dbT3036entity.setZenkaiShiharaiKingaku(parameter.get支払金額合計初期());
        }
        dbT3036entity.setSagakuKingakuGokei(parameter.get差額金額());
        dbT3036entity.setState(EntityDataState.Modified);
        償還払支給判定結果Dac.save(dbT3036entity);
    }

    private int up償還払請求集計(DbT3053ShokanShukeiEntity entity, SyokanbaraihiShikyuShinseiKetteParameter parameter,
            List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List) {

        int 更新件数 = 0;
        if (決定情報一覧List != null && !決定情報一覧List.isEmpty()) {
            for (SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧 : 決定情報一覧List) {
                if (テーブル区分.equals(決定情報一覧.getテーブル区分()) && entity.getJigyoshaNo().equals(決定情報一覧.get事業者番号())
                        && entity.getYoshikiNo().equals(決定情報一覧.get様式番号())
                        && entity.getMeisaiNo().equals(決定情報一覧.get明細番号())
                        && entity.getRenban().equals(決定情報一覧.get連番())) {
                    entity.setHiHokenshaNo(parameter.get被保険者番号());
                    entity.setServiceTeikyoYM(parameter.getサービス提供年月());
                    entity.setSeiriNo(parameter.get整理番号());
                    entity.setShikyuKubunCode(parameter.get支給区分());
                    entity.setSeikyugakuSagakuKingaku(決定情報一覧.get差額金額());
                    entity.setDekidakaSeikyugakuSagaku(決定情報一覧.get差額金額());
                    entity.setZougenRiyu(parameter.get増減理由等());
                    entity.setHushikyuRiyu(parameter.get不支給理由等1());
                    entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                    entity.setState(EntityDataState.Modified);
                    更新件数 = 更新件数 + 償還払請求集計Dac.save(entity);
                }
            }
        }
        return 更新件数;
    }

    private void 決定情報登録更新1(SyokanbaraihiShikyuShinseiKetteParameter parameter,
            SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧) {

        if (!テーブル区分_6.equals(決定情報一覧.getテーブル区分()) && !テーブル区分_7.equals(決定情報一覧.getテーブル区分())
                && !テーブル区分_8.equals(決定情報一覧.getテーブル区分())) {
            return;
        }
        if (サービス年月_200904.isBeforeOrEquals(parameter.getサービス提供年月())
                && テーブル区分_6.equals(決定情報一覧.getテーブル区分())) {
            DbT3047ShokanServicePlan200904Entity dbT3047entity
                    = 償還払請求サービス計画200904Dac.selectByKey(parameter.get被保険者番号(),
                            parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                            決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
            if (dbT3047entity != null) {
                dbT3047entity.setShikyuKubunCode(parameter.get支給区分());
                dbT3047entity.setZougenTen(parameter.get増減単位());
                dbT3047entity.setSagakuKingaku(決定情報一覧.get差額金額());
                dbT3047entity.setZougenRiyu(parameter.get増減理由等());
                dbT3047entity.setFushikyuRiyu(parameter.get不支給理由等1());
                dbT3047entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                dbT3047entity.setState(EntityDataState.Modified);
                償還払請求サービス計画200904Dac.save(dbT3047entity);
            }
        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth(サービス年月3))
                && new FlexibleYearMonth(サービス年月1).isBeforeOrEquals(parameter.getサービス提供年月())
                && テーブル区分_7.equals(決定情報一覧.getテーブル区分())) {
            DbT3046ShokanServicePlan200604Entity dbT3046entity
                    = 償還払請求サービス計画200604Dac.selectByKey(parameter.get被保険者番号(),
                            parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                            決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
            if (dbT3046entity != null) {
                dbT3046entity.setShikyuKubunCode(parameter.get支給区分());
                dbT3046entity.setZougenTen(parameter.get増減単位());
                dbT3046entity.setSagakuKingaku(決定情報一覧.get差額金額());
                dbT3046entity.setZougenRiyu(parameter.get増減理由等());
                dbT3046entity.setFushikyuRiyu(parameter.get不支給理由等1());
                dbT3046entity.setKounyuKaishuRireki(parameter.get不支給理由等2());
                dbT3046entity.setState(EntityDataState.Modified);
                償還払請求サービス計画200604Dac.save(dbT3046entity);
            }
        } else if (parameter.getサービス提供年月().isBeforeOrEquals(new FlexibleYearMonth(サービス年月4))
                && テーブル区分_8.equals(決定情報一覧.getテーブル区分())) {
            DbT3045ShokanServicePlan200004Entity dbT3045entity
                    = 償還払請求サービス計画200004Dac.selectByKey(parameter.get被保険者番号(),
                            parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                            決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
            if (dbT3045entity != null) {
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

    private void 決定情報登録更新2(SyokanbaraihiShikyuShinseiKetteParameter parameter,
            SyokanbaraihiShikyuShinseiKetteEntity 決定情報一覧) {
        switch (Integer.valueOf(決定情報一覧.getテーブル区分().toString())) {
            case テーブル区分3:
                DbT3053ShokanShukeiEntity dbT3053entity = 償還払請求集計Dac.selectByKey(parameter.get被保険者番号(),
                        parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                        決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
                if (dbT3053entity != null) {
                    dbT3053entity.setShikyuKubunCode(parameter.get支給区分());
                    dbT3053entity.setSeikyugakuSagakuKingaku(決定情報一覧.get差額金額());
                    dbT3053entity.setDekidakaSeikyugakuSagaku(決定情報一覧.get差額金額());
                    dbT3053entity.setState(EntityDataState.Modified);
                    償還払請求集計Dac.save(dbT3053entity);
                }
                break;
            case テーブル区分4:
                DbT3043ShokanShokujiHiyoEntity dbT3043entity = 償還払請求食事費用Dac.selectByKey(parameter.get被保険者番号(),
                        parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                        決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
                if (dbT3043entity != null) {
                    dbT3043entity.setSagakuKingaku(決定情報一覧.get差額金額());
                    dbT3043entity.setState(EntityDataState.Modified);
                    償還払請求食事費用Dac.save(dbT3043entity);
                }
                break;
            case テーブル区分5:
                DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbT3050entity
                        = 償還払請求特定入所者介護サービス費用Dac.selectByKey(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                                決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
                if (dbT3050entity != null) {
                    dbT3050entity.setSagakuKingaku(決定情報一覧.get差額金額());
                    dbT3050entity.setState(EntityDataState.Modified);
                    償還払請求特定入所者介護サービス費用Dac.save(dbT3050entity);
                }
                break;
            case テーブル区分6:
                DbT3047ShokanServicePlan200904Entity dbT3047entity
                        = 償還払請求サービス計画200904Dac.selectByKey(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                                決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
                if (dbT3047entity != null) {
                    dbT3047entity.setSagakuKingaku(決定情報一覧.get差額金額());
                    dbT3047entity.setState(EntityDataState.Modified);
                    償還払請求サービス計画200904Dac.save(dbT3047entity);
                }
                break;
            case テーブル区分7:
                DbT3046ShokanServicePlan200604Entity dbT3046entity
                        = 償還払請求サービス計画200604Dac.selectByKey(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                                決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
                if (dbT3046entity != null) {
                    dbT3046entity.setSagakuKingaku(決定情報一覧.get差額金額());
                    dbT3046entity.setState(EntityDataState.Modified);
                    償還払請求サービス計画200604Dac.save(dbT3046entity);
                }
                break;
            case テーブル区分8:
                DbT3045ShokanServicePlan200004Entity dbT3045entity
                        = 償還払請求サービス計画200004Dac.selectByKey(parameter.get被保険者番号(),
                                parameter.getサービス提供年月(), parameter.get整理番号(), 決定情報一覧.get事業者番号(),
                                決定情報一覧.get証明書コード(), 決定情報一覧.get明細番号(), 決定情報一覧.get連番());
                if (dbT3045entity != null) {
                    dbT3045entity.setShikyuKubunCode(parameter.get支給区分());
                    dbT3045entity.setSagakuKingaku(決定情報一覧.get差額金額());
                    dbT3045entity.setState(EntityDataState.Modified);
                    償還払請求サービス計画200004Dac.save(dbT3045entity);
                }
                break;
            default:
                break;
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
            return null;
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = dbT3034entity.getShoKisaiHokenshaNo();

        DbT4012HyojunFutangakuGemmenEntity dbt4012entity
                = 標準負担額減免Dac.selectByKey(証記載保険者番号, 被保険者番号);
        if (dbt4012entity != null) {
            return dbt4012entity.getGengakugoKingaku();
        }
        DbT7131KaigoServiceNaiyouEntity dbt7131entity = 介護サービスDac.select介護サービス(サービス年月);
        if (dbt7131entity == null) {
            return null;
        }
        return new Decimal(dbt7131entity.getTaniSu());

    }

    /**
     * 給付実績データ取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return 給付実績データ
     */
    public KyufujissekiEntity getKyufuJissekiData(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号) {

        ShokanShinsei shinsei = getShokanbaraiShinseiJyohoDetail(被保険者番号, サービス年月, 整理番号);
        DbT3034ShokanShinseiEntity dbT3034ShokanShinsei = null;
        if (shinsei != null) {
            dbT3034ShokanShinsei = shinsei.toEntity();
        }
        ShokanHanteiKekka kekka = getSyokanbaraiketteKekka(被保険者番号, サービス年月, 整理番号);
        DbT3036ShokanHanteiKekkaEntity dbT3036ShokanHanteiKekka;
        if (kekka == null) {
            dbT3036ShokanHanteiKekka = null;
        } else {
            dbT3036ShokanHanteiKekka = kekka.toEntity();
        }
        List<DbT3038ShokanKihonEntity> dbT3038ShokanKihonList = new ArrayList<>();
        List<ShokanKihon> kihonList = getShokanbarayiSeikyukihonDetail(被保険者番号, サービス年月, 整理番号);
        if (kihonList != null && !kihonList.isEmpty()) {
            for (ShokanKihon kihon : kihonList) {
                dbT3038ShokanKihonList.add(kihon.toEntity());
            }
        }
        List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai = get償還払請求明細(被保険者番号, サービス年月, 整理番号);
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisai = get住所地特例(被保険者番号, サービス年月, 整理番号);
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> dbT3040Shokan = get緊急時施設療養(被保険者番号, サービス年月, 整理番号);
        List<DbT3041ShokanTokuteiShinryohiEntity> dbT3041ShokanTokuteiShinryohi = get特定診療費(被保険者番号, サービス年月, 整理番号);
        List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> dbT3042ShokanTokutei = get特別療養費(被保険者番号, サービス年月, 整理番号);
        List<DbT3043ShokanShokujiHiyoEntity> dbT3043ShokanShokujiHiyo = get償還払請求食事費用(被保険者番号, サービス年月, 整理番号);
        List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiRealt = getサービス計画(被保険者番号, サービス年月, 整理番号);
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> dbT3050ShokanTokutei
                = get介護サービス費用(被保険者番号, サービス年月, 整理番号);
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> dbT3051ShokanShakai
                = get法人軽減額(被保険者番号, サービス年月, 整理番号);
        List<ShokanShoteiShikkanShisetsuRyoyo> entityList12 = getShoteiShikanShisetsuRyoyohiEtc(被保険者番号, サービス年月, 整理番号);
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> dbT3052ShokanShotei = new ArrayList<>();
        if (entityList12 != null && !entityList12.isEmpty()) {
            for (ShokanShoteiShikkanShisetsuRyoyo entity : entityList12) {
                dbT3052ShokanShotei.add(entity.toEntity());
            }
        }
        List<ShokanShukei> entityList13 = getShokanShukei(被保険者番号, サービス年月, 整理番号);
        List<DbT3053ShokanShukeiEntity> dbT3053ShokanShukei = new ArrayList<>();
        if (entityList13 != null && !entityList13.isEmpty()) {
            for (ShokanShukei entity : entityList13) {
                dbT3053ShokanShukei.add(entity.toEntity());
            }
        }
        KyufujissekiEntity tmpEntity = new KyufujissekiEntity(dbT3038ShokanKihonList, dbT3034ShokanShinsei,
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
     * @return List<DbT3039ShokanMeisaiEntity>
     */
    public List<DbT3039ShokanMeisaiEntity> get償還払請求明細(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanMeisai> entityList
                = getShokanbarayiSeikyuMeisayiDetail(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3039ShokanMeisaiEntity> dbT3039ShokanMeisai = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanMeisai entity : entityList) {
                dbT3039ShokanMeisai.add(entity.toEntity());
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
     * @return List<DbT3107ShokanMeisaiJushochiTokureiEntity>
     */
    public List<DbT3107ShokanMeisaiJushochiTokureiEntity> get住所地特例(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanMeisaiJushochiTokurei> entityList
                = getShokanbarayiSeikyuMeisayiJyutoku(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> dbT3107ShokanMeisai = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanMeisaiJushochiTokurei entity : entityList) {
                dbT3107ShokanMeisai.add(entity.toEntity());
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
     * @return List<DbT3040ShokanKinkyuShisetsuRyoyoEntity>
     */
    public List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> get緊急時施設療養(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanKinkyuShisetsuRyoyo> entityList = getKinkyujiShisetsuRyoyo(被保険者番号, サービス提供年月, 整理番号);
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
     * @return List<DbT3041ShokanTokuteiShinryohiEntity>
     */
    public List<DbT3041ShokanTokuteiShinryohiEntity> get特定診療費(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanTokuteiShinryohi> entityList = getTokuteiShinryohi(被保険者番号, サービス提供年月, 整理番号);
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
     * @return List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity>
     */
    public List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> get特別療養費(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanTokuteiShinryoTokubetsuRyoyo> entityList
                = getTokuteyiShinnryouhiTokubeturyoyohi(被保険者番号, サービス提供年月, 整理番号);
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
     * @return List<DbT3043ShokanShokujiHiyoEntity>
     */
    public List<DbT3043ShokanShokujiHiyoEntity> get償還払請求食事費用(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanShokujiHiyo> entityList
                = getSeikyuShokujiHiyoTanjyunSearch(被保険者番号, サービス提供年月, 整理番号);
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
     * @return List<ServiceKeikakuHiRealtEntity>
     */
    public List<ServiceKeikakuHiRealtEntity> getサービス計画(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {

        List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiRealt = new ArrayList<>();
        ServiceKeikakuHiRealtEntity serviceEntity;
        List<ShokanServicePlan200904> entityList7 = getServiceKeikaku200904(被保険者番号, サービス提供年月, 整理番号);
        List<ShokanServicePlan200604> entityList8 = getServiceKeikaku200604(被保険者番号, サービス提供年月, 整理番号);
        List<ShokanServicePlan200004> entityList9 = getServiceKeikaku200004(被保険者番号, サービス提供年月, 整理番号);
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)
                && (entityList7 != null && !entityList7.isEmpty())) {
            for (ShokanServicePlan200904 entity : entityList7) {
                serviceEntity = new ServiceKeikakuHiRealtEntity(entity.toEntity(), null, null);
                serviceKeikakuHiRealt.add(serviceEntity);
            }
        } else if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月3.toString()))
                && (entityList8 != null && !entityList8.isEmpty())) {
            for (ShokanServicePlan200604 entity : entityList8) {
                serviceEntity = new ServiceKeikakuHiRealtEntity(null, entity.toEntity(), null);
                serviceKeikakuHiRealt.add(serviceEntity);
            }
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月4.toString()))
                && (entityList9 != null && !entityList9.isEmpty())) {
            for (ShokanServicePlan200004 entity : entityList9) {
                serviceEntity = new ServiceKeikakuHiRealtEntity(null, null, entity.toEntity());
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
     * @return List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity>
     */
    public List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> get介護サービス費用(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> entityList
                = getTokuteyiNyushosyaKaigoserviceHiyo(被保険者番号, サービス提供年月, 整理番号);
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
     * @return List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity>
     */
    public List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> get法人軽減額(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<ShokanShakaiFukushiHojinKeigengaku> entityList
                = getSeikyuShakaifukushiHoujinKeigengaku(被保険者番号, サービス提供年月, 整理番号);
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> dbT3051ShokanShakai = new ArrayList<>();
        if (entityList != null && !entityList.isEmpty()) {
            for (ShokanShakaiFukushiHojinKeigengaku entity : entityList) {
                dbT3051ShokanShakai.add(entity.toEntity());
            }
        }
        return dbT3051ShokanShakai;
    }

    /**
     * 証明書の削除処理を行う
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 削除件数
     */
    @Transaction
    private int delete証明書(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        int count = 0;
        List<DbT3038ShokanKihonEntity> entityList1
                = 償還払請求基本Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList1 != null && !entityList1.isEmpty()) {
            for (DbT3038ShokanKihonEntity dbt3038entity : entityList1) {
                dbt3038entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求基本Dac.delete(dbt3038entity);
            }
        }
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> entityList2
                = 住所地特例Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList2 != null && !entityList2.isEmpty()) {
            for (DbT3107ShokanMeisaiJushochiTokureiEntity dbt3107entity : entityList2) {
                dbt3107entity.setState(EntityDataState.Deleted);
                count = count + 住所地特例Dac.delete(dbt3107entity);
            }
        }
        List<DbT3039ShokanMeisaiEntity> entityList3
                = 償還払請求明細Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList3 != null && !entityList3.isEmpty()) {
            for (DbT3039ShokanMeisaiEntity dbt3039entity : entityList3) {
                dbt3039entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求明細Dac.delete(dbt3039entity);
            }
        }
        count = count + delete証明書_特定診療費(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        count = count + delete証明書_サービス計画(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        count = count + delete証明書_サービス費用(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        count = count + delete証明書_緊急時施設療養(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        return count;
    }

    /**
     * 証明書の削除処理を行う
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 削除件数
     */
    @Transaction
    private int delete証明書_特定診療費(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        int count = 0;
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月2.toString()))) {
            List<DbT3041ShokanTokuteiShinryohiEntity> entityList4
                    = 償還払請求特定診療費Dac.select証明書削除(被保険者番号, サービス提供年月,
                            整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList4 != null && !entityList4.isEmpty()) {
                for (DbT3041ShokanTokuteiShinryohiEntity dbt3041entity : entityList4) {
                    dbt3041entity.setState(EntityDataState.Deleted);
                    count = count + 償還払請求特定診療費Dac.delete(dbt3041entity);
                }
            }
        } else {
            List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> entityList5
                    = 特別療養費Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号,
                            事業者番号, 様式番号, 明細番号);
            if (entityList5 != null && !entityList5.isEmpty()) {
                for (DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity dbt3042entity : entityList5) {
                    dbt3042entity.setState(EntityDataState.Deleted);
                    count = count + 特別療養費Dac.delete(dbt3042entity);
                }
            }
        }
        return count;
    }

    /**
     * 証明書の削除処理を行う
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 削除件数
     */
    @Transaction
    private int delete証明書_サービス計画(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        int count = 0;
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
            List<DbT3047ShokanServicePlan200904Entity> entityList6
                    = 償還払請求サービス計画200904Dac.select証明書削除(被保険者番号, サービス提供年月,
                            整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList6 != null && !entityList6.isEmpty()) {
                for (DbT3047ShokanServicePlan200904Entity dbt3047entity : entityList6) {
                    dbt3047entity.setState(EntityDataState.Deleted);
                    count = count + 償還払請求サービス計画200904Dac.delete(dbt3047entity);
                }
            }
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月3.toString()))
                && new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)) {
            List<DbT3046ShokanServicePlan200604Entity> entityList7
                    = 償還払請求サービス計画200604Dac.select証明書削除(被保険者番号, サービス提供年月,
                            整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList7 != null && !entityList7.isEmpty()) {
                for (DbT3046ShokanServicePlan200604Entity dbt3046entity : entityList7) {
                    dbt3046entity.setState(EntityDataState.Deleted);
                    count = count + 償還払請求サービス計画200604Dac.delete(dbt3046entity);
                }
            }
        } else if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月4.toString()))) {
            List<DbT3045ShokanServicePlan200004Entity> entityList8
                    = 償還払請求サービス計画200004Dac.select証明書削除(被保険者番号, サービス提供年月,
                            整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList8 != null && !entityList8.isEmpty()) {
                for (DbT3045ShokanServicePlan200004Entity dbt3045entity : entityList8) {
                    dbt3045entity.setState(EntityDataState.Deleted);
                    count = count + 償還払請求サービス計画200004Dac.delete(dbt3045entity);
                }
            }
        }
        return count;
    }

    /**
     * 証明書の削除処理を行う
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 削除件数
     */
    @Transaction
    private int delete証明書_サービス費用(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        int count = 0;
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> entityList9
                = 償還払請求特定入所者介護サービス費用Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList9 != null && !entityList9.isEmpty()) {
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbt3050entity : entityList9) {
                dbt3050entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求特定入所者介護サービス費用Dac.delete(dbt3050entity);
            }
        }
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> entityList10
                = 償還払請求社会福祉法人軽減額Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList10 != null && !entityList10.isEmpty()) {
            for (DbT3051ShokanShakaiFukushiHojinKeigengakuEntity dbt3051entity : entityList10) {
                dbt3051entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求社会福祉法人軽減額Dac.delete(dbt3051entity);
            }
        }
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> entityList11
                = 償還払請求所定疾患施設療養費等Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList11 != null && !entityList11.isEmpty()) {
            for (DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity dbt3052entity : entityList11) {
                dbt3052entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求所定疾患施設療養費等Dac.delete(dbt3052entity);
            }
        }
        return count;
    }

    /**
     * 証明書の削除処理を行う
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @return 削除件数
     */
    @Transaction
    private int delete証明書_緊急時施設療養(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号) {
        int count = 0;
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> entityList12
                = 償還払請求緊急時施設療養Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList12 != null && !entityList12.isEmpty()) {
            for (DbT3040ShokanKinkyuShisetsuRyoyoEntity dbt3040entity : entityList12) {
                dbt3040entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求緊急時施設療養Dac.delete(dbt3040entity);
            }
        }
        List<DbT3053ShokanShukeiEntity> entityList13
                = 償還払請求集計Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号);
        if (entityList13 != null && !entityList13.isEmpty()) {
            for (DbT3053ShokanShukeiEntity dbt3053entity : entityList13) {
                dbt3053entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求集計Dac.delete(dbt3053entity);
            }
        }
        List<DbT3043ShokanShokujiHiyoEntity> entityList14
                = 償還払請求食事費用Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号);
        if (entityList14 != null && !entityList14.isEmpty()) {
            for (DbT3043ShokanShokujiHiyoEntity dbt3043entity : entityList14) {
                dbt3043entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求食事費用Dac.delete(dbt3043entity);
            }
        }
        return count;
    }

    /**
     * 空値判断
     *
     * @param 項目 項目
     * @return Decimal
     */
    private Decimal nullTOEmpty(Decimal 項目) {
        if (項目 == null) {
            return Decimal.ZERO;
        }
        return 項目;
    }
}
