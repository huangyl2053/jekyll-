/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
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
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.KaigoJigyoshaReturnEntity;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ServiceTeikyoShomeishoResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShikibetsuNoKanriResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ServiceTeikyoShomeisho;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3039ShokanMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3040ShokanKinkyuShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3041ShokanTokuteiShinryohiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3043ShokanShokujiHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3052ShokanShoteiShikkanShisetsuRyoyoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraijyokyoshokai.IShokanbaraiJyokyoShokaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い状況照会のクラス
 *
 * @reamsid_L DBC-1010-180 panhe
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
    private final DbT7131KaigoServiceNaiyouDac dbT7131Dac;

    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_サービス提供年月 = new RString("サービス提供年月");
    private static final RString 定数_サービス年月 = new RString("サービス年月");
    private static final RString 定数_事業者番号 = new RString("事業者番号");
    private static final RString 定数_整理番号 = new RString("整理番号");
    private static final RString 定数_様式番号 = new RString("様式番号");
    private static final RString 定数_明細番号 = new RString("明細番号");

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
        this.dbT7131Dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dbT3034Dac DbT3034ShokanShinseiDac
     * @param dbT3053Dac DbT3053ShokanShukeiDac
     * @param dbT3038Dac DbT3053ShokanShukeiDac
     * @param dbT3041Dac DbT3041ShokanTokuteiShinryohiDac
     * @param dbT3042Dac DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac
     * @param dbT3050Dac DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac
     * @param dbT3040Dac DbT3040ShokanKinkyuShisetsuRyoyoDac
     * @param dbT3052Dac DbT3052ShokanShoteiShikkanShisetsuRyoyoDac
     * @param dbT3043Dac DbT3043ShokanShokujiHiyoDac
     * @param dbT3039Dac DbT3039ShokanMeisaiDac
     * @param dbT7131Dac DbT7131KaigoServiceNaiyouDac
     */
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
            DbT3039ShokanMeisaiDac dbT3039Dac,
            DbT7131KaigoServiceNaiyouDac dbT7131Dac) {
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
        this.dbT7131Dac = dbT7131Dac;
    }

    /**
     * 初期化メソッド
     *
     * @return ShokanbaraiJyokyoShokai
     */
    public static ShokanbaraiJyokyoShokai createInstance() {
        return InstanceProvider.create(ShokanbaraiJyokyoShokai.class);
    }

    /**
     * 償還払支給申請詳細データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return List<ShokanShinsei> List
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
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return List<ShokanShukei> List
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
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return List<ServiceTeikyoShomeishoResult> List
     */
    public List<ServiceTeikyoShomeishoResult> getServiceTeikyoShomeishoList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, null, null, null, null, null, null);
        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ServiceTeikyoShomeisho> entityList = mapper.getサービス提供証明書一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ServiceTeikyoShomeishoResult> result = new ArrayList<>();
        for (ServiceTeikyoShomeisho tmp : entityList) {
            ServiceTeikyoShomeishoResult serviceTeikyoShomeishoResult = new ServiceTeikyoShomeishoResult(tmp);
            result.add(serviceTeikyoShomeishoResult);
        }
        return result;
    }

    /**
     * 償還払請求基本詳細データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @return List<ShokanKihon> List
     */
    public ShokanKihon getShokanbarayiSeikyukihonDetail(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {

        DbT3038ShokanKihonEntity entity = dbT3038Dac
                .selectByKey(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entity == null) {
            return null;
        }
        return new ShokanKihon(entity);
    }

    /**
     * 償還払請求明細一覧取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @param サービス種類コード ServiceShuruiCode
     * @return List<ShokanMeisaiResult> List
     */
    public List<ShokanMeisaiResult> getShokanbarayiSeikyuMeisayiList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番,
            ServiceShuruiCode サービス種類コード) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, サービス種類コード, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanMeisaiEntity> entityList = mapper.get償還払請求明細一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanMeisaiResult> result = new ArrayList<>();
        for (ShokanMeisaiEntity tmp : entityList) {
            DbT3039ShokanMeisaiEntity dbT3039ShokanMeisaiEntity = tmp.getEntity().clone();
            dbT3039ShokanMeisaiEntity.setState(EntityDataState.Unchanged);
            ShokanMeisaiResult shokanMeisaiResult = new ShokanMeisaiResult(
                    new ShokanMeisai(dbT3039ShokanMeisaiEntity), tmp.getServiceName());
            result.add(shokanMeisaiResult);
        }
        return result;
    }

    /**
     * 償還払請求明細住特一覧取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanMeisaiJushochiTokureiResult> List
     */
    public List<ShokanMeisaiJushochiTokureiResult> getShokanbarayiSeikyuMeisayiJyutokuList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanMeisaiJushochiTokureiEntity> entityList = mapper.get償還払請求明細住特一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanMeisaiJushochiTokureiResult> result = new ArrayList<>();
        for (ShokanMeisaiJushochiTokureiEntity tmp : entityList) {
            DbT3107ShokanMeisaiJushochiTokureiEntity dbT3107Entity
                    = tmp.getEntity().clone();
            dbT3107Entity.setState(EntityDataState.Unchanged);
            ShokanMeisaiJushochiTokureiResult shokanMeisaiResult
                    = new ShokanMeisaiJushochiTokureiResult(
                            new ShokanMeisaiJushochiTokurei(dbT3107Entity),
                            tmp.getServiceName(),
                            tmp.getHokenshaName());
            result.add(shokanMeisaiResult);
        }
        return result;
    }

    /**
     * 償還払請求特定診療費データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanTokuteiShinryohi> List
     */
    public List<ShokanTokuteiShinryohi> getTokuteiShinryohiData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        List<ShokanTokuteiShinryohi> shokanTokuteiShinryohi = new ArrayList<>();

        if (連番 == null || 連番.isEmpty()) {
            List<DbT3041ShokanTokuteiShinryohiEntity> entityList = dbT3041Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3041ShokanTokuteiShinryohiEntity entity : entityList) {
                shokanTokuteiShinryohi.add(new ShokanTokuteiShinryohi(entity));
            }
        } else {
            DbT3041ShokanTokuteiShinryohiEntity entity = dbT3041Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
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
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanTokuteiShinryoTokubetsuRyoyo> List
     */
    public List<ShokanTokuteiShinryoTokubetsuRyoyo> getTokuteyiShinnryouhiTokubeturyoyohi(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanTokuteiShinryoTokubetsuRyoyo> shokanTokuteiRyoyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> entityList
                    = dbT3042Dac.selectByKeyOrder(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity : entityList) {
                shokanTokuteiRyoyo.add(new ShokanTokuteiShinryoTokubetsuRyoyo(entity));
            }
        } else {
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity = dbT3042Dac
                    .selectByKeyOrder(被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanTokuteiRyoyo.add(new ShokanTokuteiShinryoTokubetsuRyoyo(entity));
        }

        return shokanTokuteiRyoyo;
    }

    /**
     * 償還払請求サービス計画200904データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanServicePlan200904Result> List
     */
    public List<ShokanServicePlan200904Result> getServiceKeikaku200904(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanServicePlan200904Entity> entityList = mapper.get償還払請求サービス計画200904データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanServicePlan200904Result> result = new ArrayList<>();
        for (ShokanServicePlan200904Entity tmp : entityList) {
            DbT3047ShokanServicePlan200904Entity dbT3047Entity = tmp.getEntity().clone();
            dbT3047Entity.setState(EntityDataState.Unchanged);
            ShokanServicePlan200904Result shokanServicePlan200904Result = new ShokanServicePlan200904Result(
                    new ShokanServicePlan200904(dbT3047Entity), tmp.getServiceName());
            result.add(shokanServicePlan200904Result);
        }
        return result;
    }

    /**
     * 償還払請求サービス計画200604データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanServicePlan200604Result> List
     */
    public List<ShokanServicePlan200604Result> getServiceKeikaku200604(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanServicePlan200604Entity> entityList = mapper.get償還払請求サービス計画200604データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanServicePlan200604Result> result = new ArrayList<>();
        for (ShokanServicePlan200604Entity tmp : entityList) {
            DbT3046ShokanServicePlan200604Entity dbT3046Entity = tmp.getEntity().clone();
            dbT3046Entity.setState(EntityDataState.Unchanged);
            ShokanServicePlan200604Result shokanServicePlan200604Result = new ShokanServicePlan200604Result(
                    new ShokanServicePlan200604(dbT3046Entity), tmp.getServiceName());
            result.add(shokanServicePlan200604Result);
        }
        return result;
    }

    /**
     * 償還払請求サービス計画200004データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanServicePlan200004Result> List
     */
    public List<ShokanServicePlan200004Result> getServiceKeikaku200004(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス提供年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanServicePlan200004Entity> entityList = mapper.get償還払請求サービス計画200004データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanServicePlan200004Result> result = new ArrayList<>();
        for (ShokanServicePlan200004Entity tmp : entityList) {
            DbT3045ShokanServicePlan200004Entity dbT3045Entity = tmp.getEntity().clone();
            dbT3045Entity.setState(EntityDataState.Unchanged);
            ShokanServicePlan200004Result shokanServicePlan200004Result = new ShokanServicePlan200004Result(
                    new ShokanServicePlan200004(dbT3045Entity), tmp.getServiceName());
            result.add(shokanServicePlan200004Result);
        }
        return result;
    }

    /**
     * 償還払請求特定入所者介護サービス費用データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanTokuteiNyushoshaKaigoServiceHiyo> List
     */
    public List<ShokanTokuteiNyushoshaKaigoServiceHiyo> getTokuteyiNyushosyaKaigoserviceHiyo(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> shokanTokuteiHiyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> entityList = dbT3050Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity : entityList) {
                shokanTokuteiHiyo.add(new ShokanTokuteiNyushoshaKaigoServiceHiyo(entity));
            }
        } else {
            DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity = dbT3050Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanTokuteiHiyo.add(new ShokanTokuteiNyushoshaKaigoServiceHiyo(entity));
        }

        return shokanTokuteiHiyo;
    }

    /**
     * 償還払請求緊急時施設療養データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanKinkyuShisetsuRyoyo> List
     */
    public List<ShokanKinkyuShisetsuRyoyo> getKinkyujiShisetsuRyoyoData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanKinkyuShisetsuRyoyo> shokanKinkyuShisetsuRyoyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> entityList = dbT3040Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3040ShokanKinkyuShisetsuRyoyoEntity entity : entityList) {
                shokanKinkyuShisetsuRyoyo.add(new ShokanKinkyuShisetsuRyoyo(entity));
            }
        } else {
            DbT3040ShokanKinkyuShisetsuRyoyoEntity entity = dbT3040Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
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
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanShoteiShikkanShisetsuRyoyo> List
     */
    public List<ShokanShoteiShikkanShisetsuRyoyo> getShoteiShikanShisetsuRyoyohiEtcData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanShoteiShikkanShisetsuRyoyo> shokanShoteiRyoyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> entityList = dbT3052Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity : entityList) {
                shokanShoteiRyoyo.add(new ShokanShoteiShikkanShisetsuRyoyo(entity));
            }
        } else {
            DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity = dbT3052Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
            if (entity == null) {
                return new ArrayList<>();
            }
            shokanShoteiRyoyo.add(new ShokanShoteiShikkanShisetsuRyoyo(entity));
        }

        return shokanShoteiRyoyo;
    }

    /**
     * 償還払請求食事費用の単純検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanShokujiHiyo> List
     */
    public List<ShokanShokujiHiyo> getSeikyuShokujiHiyoTanjyunSearch(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanShokujiHiyo> shokanShokujiHiyo = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3043ShokanShokujiHiyoEntity> entityList = dbT3043Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3043ShokanShokujiHiyoEntity entity : entityList) {
                shokanShokujiHiyo.add(new ShokanShokujiHiyo(entity));
            }
        } else {
            DbT3043ShokanShokujiHiyoEntity entity = dbT3043Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
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
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanMeisai> List
     */
    public List<ShokanMeisai> getShokujiHiyoDataList(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        List<ShokanMeisai> shokanMeisai = new ArrayList<>();
        if (連番 == null || 連番.isEmpty()) {
            List<DbT3039ShokanMeisaiEntity> entityList = dbT3039Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList == null || entityList.isEmpty()) {
                return new ArrayList<>();
            }
            for (DbT3039ShokanMeisaiEntity entity : entityList) {
                shokanMeisai.add(new ShokanMeisai(entity));
            }
        } else {
            DbT3039ShokanMeisaiEntity entity = dbT3039Dac.selectByKeyOrder(
                    被保険者番号, サービス年月, 整理番号, 事業者番号, 様式番号, 明細番号, 連番);
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
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanShukeiResult> Result
     */
    public List<ShokanShukeiResult> getSeikyuShukeiData(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanShukeiEntity> entityList = mapper.get償還払請求集計データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanShukeiResult> result = new ArrayList<>();
        for (ShokanShukeiEntity tmp : entityList) {
            DbT3053ShokanShukeiEntity dbT3053ShokanShukeiEntity = tmp.getEntity().clone();
            dbT3053ShokanShukeiEntity.setState(EntityDataState.Unchanged);
            ShokanShukeiResult shokanShukeiResult = new ShokanShukeiResult(
                    new ShokanShukei(dbT3053ShokanShukeiEntity), tmp.getServiceShuruiRyakusho());
            result.add(shokanShukeiResult);
        }
        return result;
    }

    /**
     * 償還払請求社会福祉法人軽減額データ取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     * @param 連番 RString
     * @return List<ShokanShakaiFukushiHojinKeigengakuResult> Result
     */
    public List<ShokanShakaiFukushiHojinKeigengakuResult> getSeikyuShakaifukushiHoujinKeigengaku(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_明細番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                被保険者番号, サービス年月, 整理番号, 様式番号, 事業者番号, 明細番号, 連番, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<ShokanShakaiFukushiHojinKeigengakuEntity> entityList = mapper.get償還払請求社会福祉法人軽減額データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShokanShakaiFukushiHojinKeigengakuResult> result = new ArrayList<>();
        for (ShokanShakaiFukushiHojinKeigengakuEntity tmp : entityList) {
            DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity = tmp.getEntity().clone();
            entity.setState(EntityDataState.Unchanged);
            ShokanShakaiFukushiHojinKeigengakuResult shokanShakaiResult
                    = new ShokanShakaiFukushiHojinKeigengakuResult(
                            new ShokanShakaiFukushiHojinKeigengaku(entity), tmp.getServiceShuruiRyakusho());
            result.add(shokanShakaiResult);
        }
        return result;
    }

    /**
     * 識別番号管理データ取得
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 様式番号 RString
     * @return ShikibetsuNoKanriResult shikibetsuNoKanriResult
     */
    public ShikibetsuNoKanriResult getShikibetsubangoKanri(
            FlexibleYearMonth サービス年月,
            RString 様式番号) {

        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null, サービス年月, null, 様式番号, null, null, null, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<DbT3118ShikibetsuNoKanriEntity> entityList = mapper.get識別番号管理データ(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        DbT3118ShikibetsuNoKanriEntity returnEntity = entityList.get(0).clone();
        returnEntity.setState(EntityDataState.Unchanged);
        ShikibetsuNoKanriResult result = new ShikibetsuNoKanriResult(new ShikibetsuNoKanri(returnEntity));

        return result;
    }

    /**
     * 介護事業者情報取得
     *
     * @param サービス年月 FlexibleYearMonth
     * @param 事業者番号 JigyoshaNo
     * @return KaigoJigyoshaReturnEntity Entity
     */
    public KaigoJigyoshaReturnEntity getKaigoJigyoshaInfo(
            FlexibleYearMonth サービス年月,
            JigyoshaNo 事業者番号) {

        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_事業者番号.toString()));

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null, サービス年月, null, null, 事業者番号, null, null, null, null);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<DbT7060KaigoJigyoshaEntity> entityList = mapper.get介護事業者情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new KaigoJigyoshaReturnEntity();
        }

        DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyoshaEntity = entityList.get(0).clone();
        dbT7060KaigoJigyoshaEntity.setState(EntityDataState.Unchanged);
        KaigoJigyoshaReturnEntity returnEntity = new KaigoJigyoshaReturnEntity();
        returnEntity.setEntity(dbT7060KaigoJigyoshaEntity);

        return returnEntity;
    }

    /**
     * 特定診療サービスコードの取得
     *
     * @param 識別コード ShikibetsuCode
     * @param サービス年月 FlexibleYearMonth
     * @param 様式番号 RString
     * @return DbT7120TokuteiShinryoServiceCodeEntity Entity
     */
    public TokuteiShinryoServiceCode getTokuteiShinryoServiceCodeInfo(
            ShikibetsuCode 識別コード,
            FlexibleYearMonth サービス年月,
            RString 様式番号) {

        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_様式番号.toString()));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        ServiceShuruiCode serviceShuruiCode = null;

        if (new RString("2165").equals(様式番号)
                || new RString("216x").equals(様式番号)
                || new RString("21Ax").equals(様式番号)) {
            serviceShuruiCode = new ServiceShuruiCode("60");
        } else if (new RString("2155").equals(様式番号)
                || new RString("2156").equals(様式番号)
                || new RString("219x").equals(様式番号)) {
            serviceShuruiCode = new ServiceShuruiCode("70");
        }

        ServiceKomokuCode serviceKomokuCode = new ServiceKomokuCode(new RString("00") + 識別コード.toString());

        ShokanbaraiJyokyoShokaiParameter parameter = ShokanbaraiJyokyoShokaiParameter.createMybatisParam(
                null, サービス年月, null, 様式番号, null, null, null, serviceShuruiCode, serviceKomokuCode);

        IShokanbaraiJyokyoShokaiMapper mapper = mapperProvider.create(IShokanbaraiJyokyoShokaiMapper.class);
        List<DbT7120TokuteiShinryoServiceCodeEntity> entityList = mapper.get特定診療サービスコード(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new TokuteiShinryoServiceCode(new DbT7120TokuteiShinryoServiceCodeEntity());
        }

        TokuteiShinryoServiceCode result = new TokuteiShinryoServiceCode(entityList.get(0));

        return result;
    }

    /**
     * サービスコード情報取得
     *
     * @param サービス種類コード KaigoServiceShuruiCode
     * @param サービス項目コード RString
     * @param 基準年月 FlexibleYearMonth
     * @return List<KaigoServiceNaiyou>
     */
    public List<KaigoServiceNaiyou> getServiceCodeInfo(
            KaigoServiceShuruiCode サービス種類コード,
            RString サービス項目コード,
            FlexibleYearMonth 基準年月) {

        List<DbT7131KaigoServiceNaiyouEntity> entityList = dbT7131Dac
                .selectサービスコード情報(サービス種類コード, サービス項目コード, 基準年月);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        List<KaigoServiceNaiyou> resultList = new ArrayList<>();
        for (DbT7131KaigoServiceNaiyouEntity tmp : entityList) {
            resultList.add(new KaigoServiceNaiyou(tmp));
        }
        return resultList;
    }
}
