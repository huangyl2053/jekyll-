/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3039ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3040ShokanKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ServiceTeikyoShomeisho;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3039ShokanMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3041ShokanTokuteiShinryohiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraijyokyoshokai.IShokanbaraiJyokyoShokaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い状況照会のクラス
 *
 * @author PANHE
 */
public class ShokanbaraiJyokyoShokai {

    private final MapperProvider mapperProvider;
    private final DbT3034ShokanShinseiDac dbT3034Dac;
    private final DbT3053ShokanShukeiDac dbT3053Dac;
    private final DbT3038ShokanKihonDac dbT3038Dac;
    private final DbT3041ShokanTokuteiShinryohiDac dbT3041Dac;
    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac dbT3042Dac;
    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac dbT3050Dac;
    private final DbT3040ShokanKinkyuShisetsuRyoyoDac dbT3040Dac;
    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoDac dbT3052Dac;
    private final DbT3043ShokanShokujiHiyoDac dbT3043Dac;
    private final DbT3039ShokanMeisaiDac dbT3039Dac;

    /**
     * コンストラクタです。
     */
    public ShokanbaraiJyokyoShokai() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT3034Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        this.dbT3053Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.dbT3038Dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
        this.dbT3041Dac = InstanceProvider.create(DbT3041ShokanTokuteiShinryohiDac.class);
        this.dbT3042Dac = InstanceProvider.create(DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac.class);
        this.dbT3050Dac = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.dbT3040Dac = InstanceProvider.create(DbT3040ShokanKinkyuShisetsuRyoyoDac.class);
        this.dbT3052Dac = InstanceProvider.create(DbT3052ShokanShoteiShikkanShisetsuRyoyoDac.class);
        this.dbT3043Dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.dbT3039Dac = InstanceProvider.create(DbT3039ShokanMeisaiDac.class);
    }

    public ShokanbaraiJyokyoShokai(MapperProvider mapperProvider,
            DbT3034ShokanShinseiDac dbT3034Dac,
            DbT3053ShokanShukeiDac dbT3053Dac,
            DbT3038ShokanKihonDac dbT3038Dac,
            DbT3041ShokanTokuteiShinryohiDac dbT3041Dac,
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac dbT3042Dac,
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac dbT3050Dac,
            DbT3040ShokanKinkyuShisetsuRyoyoDac dbT3040Dac,
            DbT3052ShokanShoteiShikkanShisetsuRyoyoDac dbT3052Dac,
            DbT3043ShokanShokujiHiyoDac dbT3043Dac,
            DbT3039ShokanMeisaiDac dbT3039Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT3034Dac = dbT3034Dac;
        this.dbT3053Dac = dbT3053Dac;
        this.dbT3038Dac = dbT3038Dac;
        this.dbT3041Dac = dbT3041Dac;
        this.dbT3042Dac = dbT3042Dac;
        this.dbT3050Dac = dbT3050Dac;
        this.dbT3040Dac = dbT3040Dac;
        this.dbT3052Dac = dbT3052Dac;
        this.dbT3043Dac = dbT3043Dac;
        this.dbT3039Dac = dbT3039Dac;

    }

    public static ShokanbaraiJyokyoShokai createInstance() {
        return InstanceProvider.create(ShokanbaraiJyokyoShokai.class);
    }

    /**
     * 償還払支給申請詳細データ取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @return List<ShokanShinsei>
     */
    @Transaction
    public List<ShokanShinsei> getShokanbaraiShinseiJyohoDetail(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        DbT3034ShokanShinseiEntity entity = dbT3034Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        if (entity == null) {
            return new ArrayList<>();
        }
        List<ShokanShinsei> shokanShinseiList = new ArrayList<>();
        shokanShinseiList.add(new ShokanShinsei(entity));

        return shokanShinseiList;
    }

    /**
     * 償還払請求集計一覧取得
     *
     * @param 被保険者番号
     * @param サービス年月
     * @param 整理番号
     * @return List<ShokanShukei>
     */
    public List<ShokanShukei> getShokanbaraiShinseiJyohoList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {
        List<DbT3053ShokanShukeiEntity> entityList = dbT3053Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }

        List<ShokanShukei> shokanShukeiList = new ArrayList<>();
        for (DbT3053ShokanShukeiEntity entity : entityList) {
            shokanShukeiList.add(new ShokanShukei(entity));
        }
        return shokanShukeiList;
    }

    /**
     * サービス提供証明書一覧取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 様式番号
     * @return List<ServiceTeikyoShomeisho>
     */
    public List<ServiceTeikyoShomeisho> getServiceTeikyoShomeishoList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 様式番号) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, null, null, null, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ServiceTeikyoShomeisho> entityList = mapper.getサービス提供証明書一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 償還払請求基本詳細データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @return List<ShokanKihon>
     */
    public List<ShokanKihon> getShokanbarayiSeikyukihonDetail(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {

        DbT3038ShokanKihonEntity entity = dbT3038Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entity == null) {
            return new ArrayList<>();
        }
        List<ShokanKihon> shokanKihon = new ArrayList<>();
        shokanKihon.add(new ShokanKihon(entity));
        return shokanKihon;
    }

    /**
     * 償還払請求明細一覧取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @param サービス種類コード
     * @return List<ShokanMeisaiEntity>
     */
    public List<ShokanMeisaiEntity> getShokanbarayiSeikyuMeisayiList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceShuruiCode サービス種類コード) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, サービス種類コード, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanMeisaiEntity> entityList = mapper.get償還払請求明細一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 償還払請求明細住特一覧取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @param サービス種類コード
     * @return List<ShokanMeisaiJushochiTokureiEntity>
     */
    public List<ShokanMeisaiJushochiTokureiEntity> getShokanbarayiSeikyuMeisayiJyutokuList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceShuruiCode サービス種類コード) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, サービス種類コード, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanMeisaiJushochiTokureiEntity> entityList = mapper.get償還払請求明細住特一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 償還払請求特定診療費データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanTokuteiShinryohi>
     */
    public List<ShokanTokuteiShinryohi> getTokuteiShinryohiData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        List<ShokanTokuteiShinryohi> shokanTokuteiShinryohi = new ArrayList<>();

        if (連番 == null || 連番.isEmpty()) {
            List<DbT3041ShokanTokuteiShinryohiEntity> entityList = dbT3041Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3041ShokanTokuteiShinryohiEntity entity : entityList) {
                shokanTokuteiShinryohi.add(new ShokanTokuteiShinryohi(entity));
            }
        } else {
            DbT3041ShokanTokuteiShinryohiEntity entity = dbT3041Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanTokuteiShinryohi.add(new ShokanTokuteiShinryohi(entity));
        }

        return shokanTokuteiShinryohi;
    }

    /**
     * 償還払請求特定診療費・特別療養費一覧取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanTokuteiShinryoTokubetsuRyoyo>
     */
    public List<ShokanTokuteiShinryoTokubetsuRyoyo> getTokuteyiShinnryouhiTokubeturyoyohi(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiShinryoTokubetsuRyoyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> entityList = dbT3042Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity : entityList) {
                shokanTokuteiShinryoTokubetsuRyoyo.add(new ShokanTokuteiShinryoTokubetsuRyoyo(entity));
            }
        } else {
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity = dbT3042Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanTokuteiShinryoTokubetsuRyoyo.add(new ShokanTokuteiShinryoTokubetsuRyoyo(entity));
        }

        return shokanTokuteiShinryoTokubetsuRyoyo;
    }

    /**
     * 償還払請求サービス計画200904データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanServicePlan200904Entity>
     */
    public List<ShokanServicePlan200904Entity> getServiceKeikaku200904(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanServicePlan200904Entity> entityList = mapper.get償還払請求サービス計画200904データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 償還払請求サービス計画200604データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanServicePlan200604Entity>
     */
    public List<ShokanServicePlan200604Entity> getServiceKeikaku200604(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanServicePlan200604Entity> entityList = mapper.get償還払請求サービス計画200604データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 償還払請求特定入所者介護サービス費用データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanTokuteiNyushoshaKaigoServiceHiyo>
     */
    public List<ShokanTokuteiNyushoshaKaigoServiceHiyo> getTokuteyiNyushosyaKaigoserviceHiyo(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> shokanTokuteiNyushoshaKaigoServiceHiyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> entityList = dbT3050Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity : entityList) {
                shokanTokuteiNyushoshaKaigoServiceHiyo.add(new ShokanTokuteiNyushoshaKaigoServiceHiyo(entity));
            }
        } else {
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity = dbT3050Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanTokuteiNyushoshaKaigoServiceHiyo.add(new ShokanTokuteiNyushoshaKaigoServiceHiyo(entity));
        }

        return shokanTokuteiNyushoshaKaigoServiceHiyo;
    }

    /**
     * 償還払請求緊急時施設療養データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanKinkyuShisetsuRyoyo>
     */
    public List<ShokanKinkyuShisetsuRyoyo> getKinkyujiShisetsuRyoyoData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanKinkyuShisetsuRyoyo> shokanKinkyuShisetsuRyoyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> entityList = dbT3040Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3040ShokanKinkyuShisetsuRyoyoEntity entity : entityList) {
                shokanKinkyuShisetsuRyoyo.add(new ShokanKinkyuShisetsuRyoyo(entity));
            }
        } else {
            DbT3040ShokanKinkyuShisetsuRyoyoEntity entity = dbT3040Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanKinkyuShisetsuRyoyo.add(new ShokanKinkyuShisetsuRyoyo(entity));
        }

        return shokanKinkyuShisetsuRyoyo;
    }

    /**
     * 償還払請求所定疾患施設療養費等データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanShoteiShikkanShisetsuRyoyo>
     */
    public List<ShokanShoteiShikkanShisetsuRyoyo> getKinkyujiShisetsuRyoyoData1(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanShoteiShikkanShisetsuRyoyo> shokanShoteiShikkanShisetsuRyoyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> entityList = dbT3052Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity : entityList) {
                shokanShoteiShikkanShisetsuRyoyo.add(new ShokanShoteiShikkanShisetsuRyoyo(entity));
            }
        } else {
            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = dbT3052Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanShoteiShikkanShisetsuRyoyo.add(new ShokanShoteiShikkanShisetsuRyoyo(entity));
        }

        return shokanShoteiShikkanShisetsuRyoyo;
    }

    /**
     * 償還払請求食事費用の単純検索
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanShokujiHiyo>
     */
    public List<ShokanShokujiHiyo> getSeikyuShokujiHiyoTanjyunSearch(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanShokujiHiyo> shokanShokujiHiyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3043ShokanShokujiHiyoEntity> entityList = dbT3043Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3043ShokanShokujiHiyoEntity entity : entityList) {
                shokanShokujiHiyo.add(new ShokanShokujiHiyo(entity));
            }
        } else {
            DbT3043ShokanShokujiHiyoEntity entity = dbT3043Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanShokujiHiyo.add(new ShokanShokujiHiyo(entity));
        }

        return shokanShokujiHiyo;
    }

    /**
     * 食事費用データ一覧取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanMeisai>
     */
    public List<ShokanMeisai> getShokujiHiyoDataList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanMeisai> shokanMeisai = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3039ShokanMeisaiEntity> entityList = dbT3039Dac.selectByKeyOrder(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3039ShokanMeisaiEntity entity : entityList) {
                shokanMeisai.add(new ShokanMeisai(entity));
            }
        } else {
            DbT3039ShokanMeisaiEntity entity = dbT3039Dac.selectByKey(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanMeisai.add(new ShokanMeisai(entity));
        }

        return shokanMeisai;
    }

    /**
     * 償還払請求集計データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanShukeiEntity>
     */
    public List<ShokanShukeiEntity> getSeikyuShukeiData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanShukeiEntity> entityList = mapper.get償還払請求集計データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 償還払請求社会福祉法人軽減額データ取得
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 事業者番号
     * @param 様式番号
     * @param 明細番号
     * @param 連番
     * @return List<ShokanShakaiFukushiHojinKeigengakuEntity>
     */
    public List<ShokanShakaiFukushiHojinKeigengakuEntity> getSeikyuShakaifukushiHoujinKeigengaku(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス提供年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanShakaiFukushiHojinKeigengakuEntity> entityList = mapper.get償還払請求社会福祉法人軽減額データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        return entityList;
    }

    /**
     * 識別番号管理データ取得
     *
     * @param サービス提供年月
     * @param 様式番号
     * @return ShikibetsuNoKanriEntity
     */
    public ShikibetsuNoKanriEntity getShikibetsubangoKanri(
            FlexibleYearMonth サービス提供年月,
            RString 様式番号) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null, サービス提供年月, null, 様式番号, null, null, null, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<DbT3118ShikibetsuNoKanriEntity> entityList = mapper.get識別番号管理データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ShikibetsuNoKanriEntity();
        }
        ShikibetsuNoKanriEntity returnEntity = new ShikibetsuNoKanriEntity();
        returnEntity.setEntity(entityList.get(0));
        return returnEntity;
    }

    /**
     * 介護事業者情報取得
     *
     * @param サービス提供年月
     * @param 事業者番号
     * @return KaigoJigyoshaReturnEntity
     */
    public KaigoJigyoshaReturnEntity getKaigoJigyoshaInfo(
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号) {
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null, サービス提供年月, null, null, 事業者番号, null, null, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<DbT7060KaigoJigyoshaEntity> entityList = mapper.get介護事業者情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new KaigoJigyoshaReturnEntity();
        }

        KaigoJigyoshaReturnEntity returnEntity = new KaigoJigyoshaReturnEntity();
        returnEntity.setEntity(entityList.get(0));

        return returnEntity;
    }

    /**
     * 特定診療サービスコードの取得
     *
     * @param サービス提供年月
     * @param 様式番号
     * @param 識別コード
     * @return DbT7120TokuteiShinryoServiceCodeEntity
     */
    public DbT7120TokuteiShinryoServiceCodeEntity getTokuteiShinryoServiceCodeInfo(
            FlexibleYearMonth サービス提供年月,
            RString 様式番号,
            ShikibetsuCode 識別コード) {

        ServiceShuruiCode serviceShuruiCode = null;

        if (new RString("2165").equals(様式番号)
                || new RString("216x").equals(様式番号)
                || new RString("21Ax").equals(様式番号)) {
            serviceShuruiCode = new ServiceShuruiCode("60");
        } else if (new RString("2155").equals(様式番号)
                || new RString("2156").equals(様式番号)
                || new RString("219x").equals(様式番号)) {
            serviceShuruiCode = new ServiceShuruiCode("60");
        }

        ServiceKomokuCode serviceKomokuCode = new ServiceKomokuCode(new RString("00") + 識別コード.toString());

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null, サービス提供年月, null, 様式番号, null, null, null, serviceShuruiCode, serviceKomokuCode);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<DbT7120TokuteiShinryoServiceCodeEntity> entityList = mapper.get特定診療サービスコード(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new DbT7120TokuteiShinryoServiceCodeEntity();
        }

        return entityList.get(0);
    }
}
