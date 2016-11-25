/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.business.core.dbjoho.DbJohoViewState;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiJushochiTokureiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanMeisaiResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200004Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200604Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanServicePlan200904Result;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShakaiFukushiHojinKeigengakuResult;
import jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai.ShokanShukeiResult;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.KyufujissekiKihonResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.KyufujissekiKihonParameter;
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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.KyufujissekiKihonEntity;
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
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3107ShokanMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette.ISyokanbaraihiShikyuShinseiKetteMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払い費支給申請決定クラスです。
 *
 * @reamsid_L DBC-1030-200 xicongwang
 */
public class SyokanbaraihiShikyuShinseiKetteFath {

    private final MapperProvider mapperProvider;
    private final DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac 償還払請求特定入所者介護サービス費用Dac;
    private final DbT3047ShokanServicePlan200904Dac 償還払請求サービス計画200904Dac;
    private final DbT3046ShokanServicePlan200604Dac 償還払請求サービス計画200604Dac;
    private final DbT3045ShokanServicePlan200004Dac 償還払請求サービス計画200004Dac;
    private final DbT3043ShokanShokujiHiyoDac 償還払請求食事費用Dac;
    private final DbT3053ShokanShukeiDac 償還払請求集計Dac;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3038ShokanKihonDac 償還払請求基本Dac;
    private final DbT3107ShokanMeisaiJushochiTokureiDac 住所地特例Dac;
    private final DbT3039ShokanMeisaiDac 償還払請求明細Dac;
    private final DbT3041ShokanTokuteiShinryohiDac 償還払請求特定診療費Dac;
    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoDac 特別療養費Dac;
    private final DbT3051ShokanShakaiFukushiHojinKeigengakuDac 償還払請求社会福祉法人軽減額Dac;
    private final DbT3052ShokanShoteiShikkanShisetsuRyoyoDac 償還払請求所定疾患施設療養費等Dac;
    private final DbT3040ShokanKinkyuShisetsuRyoyoDac 償還払請求緊急時施設療養Dac;
    private final DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_サービス年月 = new RString("サービス年月");
    private static final RString 定数_整理番号 = new RString("定数_整理番号");
    private static final RString チェック区分_2 = new RString("2");
    private static final RString サービス年月 = new RString("200904");
    private static final RString サービス年月1 = new RString("200604");
    private static final RString サービス年月2 = new RString("200303");
    private static final RString サービス年月3 = new RString("200903");
    private static final RString サービス年月4 = new RString("200603");

    /**
     * コンストラクタです。
     */
    SyokanbaraihiShikyuShinseiKetteFath() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.償還払請求特定入所者介護サービス費用Dac
                = InstanceProvider.create(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoDac.class);
        this.償還払請求サービス計画200904Dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
        this.償還払請求サービス計画200604Dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
        this.償還払請求サービス計画200004Dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
        this.償還払請求食事費用Dac = InstanceProvider.create(DbT3043ShokanShokujiHiyoDac.class);
        this.償還払請求集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
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
        this.介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteFath}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SyokanbaraihiShikyuShinseiKetteFath}のインスタンス
     */
    public static SyokanbaraihiShikyuShinseiKetteFath createInstance() {

        return InstanceProvider.create(SyokanbaraihiShikyuShinseiKetteFath.class);
    }

    /**
     * 給付実績基本情報リスト取得メソッドです。
     *
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @param 給付実績区分コード 給付実績区分コード
     * @return List<KyufujissekiKihonResult>
     */
    public List<KyufujissekiKihonResult> getKyufuJissekiKihonJohoList(HokenshaNo 保険者番号, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 整理番号, RString 給付実績区分コード) {

        List<KyufujissekiKihonResult> kyufujissekiKihonResultList = new ArrayList<>();
        ISyokanbaraihiShikyuShinseiKetteMapper mapper
                = mapperProvider.create(ISyokanbaraihiShikyuShinseiKetteMapper.class);
        KyufujissekiKihonParameter parameter
                = KyufujissekiKihonParameter.createSelectByKeyParam(保険者番号, 被保険者番号, サービス年月, 整理番号, 給付実績区分コード);
        List<KyufujissekiKihonEntity> entityList = mapper.get給付実績基本情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        for (KyufujissekiKihonEntity entity : entityList) {
            kyufujissekiKihonResultList.add(new KyufujissekiKihonResult(entity));
        }
        return kyufujissekiKihonResultList;
    }

    /**
     * 償還払支給申請詳細データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return DbT3034ShokanShinseiEntity
     */
    public ShokanShinsei getShokanbaraiShinseiJyohoDetail(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        DbT3034ShokanShinseiEntity entity = 償還払支給申請Dac.selectByKey(被保険者番号, サービス年月, 整理番号);
        if (entity == null) {
            return null;
        }
        return new ShokanShinsei(entity);
    }

    /**
     * 償還払請求基本詳細データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanKihon>
     */
    public List<ShokanKihon> getShokanbarayiSeikyukihonDetail(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanKihon> resultList = new ArrayList<>();
        List<DbT3038ShokanKihonEntity> entityList
                = 償還払請求基本Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3038ShokanKihonEntity entity : entityList) {
            resultList.add(new ShokanKihon(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求明細データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanMeisai>
     */
    public List<ShokanMeisai> getShokanbarayiSeikyuMeisayiDetail(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanMeisai> resultList = new ArrayList<>();
        List<DbT3039ShokanMeisaiEntity> entityList
                = 償還払請求明細Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3039ShokanMeisaiEntity entity : entityList) {
            resultList.add(new ShokanMeisai(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求明細住特データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanMeisaiJushochiTokurei>
     */
    public List<ShokanMeisaiJushochiTokurei> getShokanbarayiSeikyuMeisayiJyutoku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanMeisaiJushochiTokurei> resultList = new ArrayList<>();
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> entityList
                = 住所地特例Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3107ShokanMeisaiJushochiTokureiEntity entity : entityList) {
            resultList.add(new ShokanMeisaiJushochiTokurei(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求緊急時施設療養データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanKinkyuShisetsuRyoyo>
     */
    public List<ShokanKinkyuShisetsuRyoyo> getKinkyujiShisetsuRyoyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanKinkyuShisetsuRyoyo> resultList = new ArrayList<>();
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> entityList
                = 償還払請求緊急時施設療養Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3040ShokanKinkyuShisetsuRyoyoEntity entity : entityList) {
            resultList.add(new ShokanKinkyuShisetsuRyoyo(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求特定診療費データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanTokuteiShinryohi>
     */
    public List<ShokanTokuteiShinryohi> getTokuteiShinryohi(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanTokuteiShinryohi> resultList = new ArrayList<>();
        List<DbT3041ShokanTokuteiShinryohiEntity> entityList
                = 償還払請求特定診療費Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3041ShokanTokuteiShinryohiEntity entity : entityList) {
            resultList.add(new ShokanTokuteiShinryohi(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求特定診療費・特別療養費データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanTokuteiShinryoTokubetsuRyoyo>
     */
    public List<ShokanTokuteiShinryoTokubetsuRyoyo> getTokuteyiShinnryouhiTokubeturyoyohi(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanTokuteiShinryoTokubetsuRyoyo> resultList = new ArrayList<>();
        List<DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity> entityList
                = 特別療養費Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity : entityList) {
            resultList.add(new ShokanTokuteiShinryoTokubetsuRyoyo(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求食事費用の単純検索メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanTokuteiShinryohi>
     */
    public List<ShokanShokujiHiyo> getSeikyuShokujiHiyoTanjyunSearch(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanShokujiHiyo> resultList = new ArrayList<>();
        List<DbT3043ShokanShokujiHiyoEntity> entityList
                = 償還払請求食事費用Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3043ShokanShokujiHiyoEntity entity : entityList) {
            resultList.add(new ShokanShokujiHiyo(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求サービス計画200904データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanServicePlan200904>
     */
    public List<ShokanServicePlan200904> getServiceKeikaku200904(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanServicePlan200904> resultList = new ArrayList<>();
        List<DbT3047ShokanServicePlan200904Entity> entityList
                = 償還払請求サービス計画200904Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3047ShokanServicePlan200904Entity entity : entityList) {
            resultList.add(new ShokanServicePlan200904(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求サービス計画200604データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanServicePlan200604>
     */
    public List<ShokanServicePlan200604> getServiceKeikaku200604(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanServicePlan200604> resultList = new ArrayList<>();
        List<DbT3046ShokanServicePlan200604Entity> entityList
                = 償還払請求サービス計画200604Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3046ShokanServicePlan200604Entity entity : entityList) {
            resultList.add(new ShokanServicePlan200604(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求サービス計画200004データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanServicePlan200004>
     */
    public List<ShokanServicePlan200004> getServiceKeikaku200004(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanServicePlan200004> resultList = new ArrayList<>();
        List<DbT3045ShokanServicePlan200004Entity> entityList
                = 償還払請求サービス計画200004Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3045ShokanServicePlan200004Entity entity : entityList) {
            resultList.add(new ShokanServicePlan200004(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求特定入所者介護サービス費用データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanTokuteiNyushoshaKaigoServiceHiyo>
     */
    public List<ShokanTokuteiNyushoshaKaigoServiceHiyo> getTokuteyiNyushosyaKaigoserviceHiyo(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> resultList = new ArrayList<>();
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> entityList
                = 償還払請求特定入所者介護サービス費用Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity : entityList) {
            resultList.add(new ShokanTokuteiNyushoshaKaigoServiceHiyo(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求社会福祉法人軽減額データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanShakaiFukushiHojinKeigengaku>
     */
    public List<ShokanShakaiFukushiHojinKeigengaku> getSeikyuShakaifukushiHoujinKeigengaku(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanShakaiFukushiHojinKeigengaku> resultList = new ArrayList<>();
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> entityList
                = 償還払請求社会福祉法人軽減額Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity : entityList) {
            resultList.add(new ShokanShakaiFukushiHojinKeigengaku(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求所定疾患施設療養費等データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanShoteiShikkanShisetsuRyoyo>
     */
    public List<ShokanShoteiShikkanShisetsuRyoyo> getShoteiShikanShisetsuRyoyohiEtc(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanShoteiShikkanShisetsuRyoyo> resultList = new ArrayList<>();
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> entityList
                = 償還払請求所定疾患施設療養費等Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity : entityList) {
            resultList.add(new ShokanShoteiShikkanShisetsuRyoyo(entity));
        }
        return resultList;
    }

    /**
     * 償還払請求集計データ取得メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス年月 サービス年月
     * @param 整理番号 整理番号
     * @return List<ShokanShukei>
     */
    public List<ShokanShukei> getShokanShukei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RString 整理番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_被保険者番号.toString()));
        requireNonNull(サービス年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_サービス年月.toString()));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定数_整理番号.toString()));

        List<ShokanShukei> resultList = new ArrayList<>();
        List<DbT3053ShokanShukeiEntity> entityList
                = 償還払請求集計Dac.select証明書削除(被保険者番号, サービス年月, 整理番号, null, null, null);
        if (entityList == null || entityList.isEmpty()) {
            return resultList;
        }
        for (DbT3053ShokanShukeiEntity entity : entityList) {
            resultList.add(new ShokanShukei(entity));
        }
        return resultList;
    }

    /**
     * 証明書件数取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param チェック区分 チェック区分
     * @return 取得件数
     */
    public int getShikibetsuNoKanri(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString チェック区分) {
        int 件数;
        int 件数2;
        if (チェック区分_2.equals(チェック区分)) {
            件数2 = 償還払請求基本Dac.selectデータ件数2(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
            if (件数2 > 0) {
                return 件数2;
            }
            if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
                return 償還払請求サービス計画200904Dac.selectデータ件数2(被保険者番号,
                        サービス提供年月, 整理番号, 事業者番号, 様式番号);
            }
            if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)) {
                return 償還払請求サービス計画200604Dac.selectデータ件数2(被保険者番号,
                        サービス提供年月, 整理番号, 事業者番号, 様式番号);
            }
            return 償還払請求サービス計画200004Dac.selectデータ件数2(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号);
        } else {
            件数 = 償還払請求基本Dac.selectデータ件数(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
            件数2 = 償還払請求基本Dac.selectデータ件数2(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号);
            if (件数 + 件数2 > 0) {
                return 件数 + 件数2;
            }
            if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
                return 償還払請求サービス計画200904Dac.selectデータ件数(被保険者番号,
                        サービス提供年月, 整理番号, 事業者番号, 様式番号)
                        + 償還払請求サービス計画200904Dac.selectデータ件数2(被保険者番号,
                                サービス提供年月, 整理番号, 事業者番号, 様式番号);
            }
            if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)) {
                return 償還払請求サービス計画200604Dac.selectデータ件数(被保険者番号,
                        サービス提供年月, 整理番号, 事業者番号, 様式番号)
                        + 償還払請求サービス計画200604Dac.selectデータ件数2(被保険者番号,
                                サービス提供年月, 整理番号, 事業者番号, 様式番号);
            }
            return 償還払請求サービス計画200004Dac.selectデータ件数(被保険者番号,
                    サービス提供年月, 整理番号, 事業者番号, 様式番号)
                    + 償還払請求サービス計画200004Dac.selectデータ件数2(被保険者番号,
                            サービス提供年月, 整理番号, 事業者番号, 様式番号);
        }

    }

    /**
     * 証明書（ViewState）件数取得する。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param チェック区分 RString
     * @param 償還払請求基本データList List<ShokanKihon>
     * @param 償還払請求サービス計画200904データList List<ShokanServicePlan200904Result>
     * @param 償還払請求サービス計画200604データList List<ShokanServicePlan200604Result>
     * @param 償還払請求サービス計画200004データList List<ShokanServicePlan200004Result>
     * @return 取得件数
     */
    public int getShomeishoKensu(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString チェック区分,
            List<ShokanKihon> 償還払請求基本データList,
            List<ShokanServicePlan200904Result> 償還払請求サービス計画200904データList,
            List<ShokanServicePlan200604Result> 償還払請求サービス計画200604データList,
            List<ShokanServicePlan200004Result> 償還払請求サービス計画200004データList
    ) {
        int 取得件数 = 0;
        if (チェック区分_2.equals(チェック区分)) {
            return 取得件数;
        }
        for (ShokanKihon 償還払請求基本データ : 償還払請求基本データList) {
            if (被保険者番号.equals(償還払請求基本データ.toEntity().getHiHokenshaNo())
                    && サービス提供年月.equals(償還払請求基本データ.toEntity().getServiceTeikyoYM())
                    && 整理番号.equals(償還払請求基本データ.toEntity().getSeiriNo())
                    && 事業者番号.equals(償還払請求基本データ.toEntity().getJigyoshaNo())
                    && 様式番号.equals(償還払請求基本データ.toEntity().getYoshikiNo())) {
                取得件数++;
            }
        }
        if (取得件数 > 0) {
            return 取得件数;
        }
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
            for (ShokanServicePlan200904Result 償還払請求サービス計画200904データ : 償還払請求サービス計画200904データList) {
                if (被保険者番号.equals(償還払請求サービス計画200904データ.getEntity().toEntity().getHiHokenshaNo())
                        && サービス提供年月.equals(償還払請求サービス計画200904データ.getEntity().toEntity().getServiceTeikyoYM())
                        && 整理番号.equals(償還払請求サービス計画200904データ.getEntity().toEntity().getSeiriNo())
                        && 事業者番号.equals(償還払請求サービス計画200904データ.getEntity().toEntity().getJigyoshaNo())
                        && 様式番号.equals(償還払請求サービス計画200904データ.getEntity().toEntity().getYoshikiNo())) {
                    取得件数++;
                }
            }
            return 取得件数;
        }
        return getKeikakuData(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号,
                償還払請求サービス計画200604データList,
                償還払請求サービス計画200004データList,
                取得件数);
    }

    private int getKeikakuData(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            List<ShokanServicePlan200604Result> 償還払請求サービス計画200604データList,
            List<ShokanServicePlan200004Result> 償還払請求サービス計画200004データList,
            int 取得件数) {
        if (new FlexibleYearMonth(サービス年月1.toString()).isBeforeOrEquals(サービス提供年月)) {
            for (ShokanServicePlan200604Result 償還払請求サービス計画200604データ : 償還払請求サービス計画200604データList) {
                if (被保険者番号.equals(償還払請求サービス計画200604データ.getEntity().toEntity().getHiHokenshaNo())
                        && サービス提供年月.equals(償還払請求サービス計画200604データ.getEntity().toEntity().getServiceTeikyoYM())
                        && 整理番号.equals(償還払請求サービス計画200604データ.getEntity().toEntity().getSeiriNo())
                        && 事業者番号.equals(償還払請求サービス計画200604データ.getEntity().toEntity().getJigyoshaNo())
                        && 様式番号.equals(償還払請求サービス計画200604データ.getEntity().toEntity().getYoshikiNo())) {
                    取得件数++;
                }
            }
            return 取得件数;
        }
        for (ShokanServicePlan200004Result 償還払請求サービス計画200004データ : 償還払請求サービス計画200004データList) {
            if (被保険者番号.equals(償還払請求サービス計画200004データ.getEntity().toEntity().getHiHokenshaNo())
                    && サービス提供年月.equals(償還払請求サービス計画200004データ.getEntity().toEntity().getServiceTeikyoYM())
                    && 整理番号.equals(償還払請求サービス計画200004データ.getEntity().toEntity().getSeiriNo())
                    && 事業者番号.equals(償還払請求サービス計画200004データ.getEntity().toEntity().getJigyoshaNo())
                    && 様式番号.equals(償還払請求サービス計画200004データ.getEntity().toEntity().getYoshikiNo())) {
                取得件数++;
            }
        }
        return 取得件数;
    }

    /**
     * 介護事業者名を取得する
     *
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始日 FlexibleDate
     * @return 介護事業者
     */
    public RString get介護事業者(JigyoshaNo 事業者番号, FlexibleDate 有効開始日) {
        DbT7060KaigoJigyoshaEntity entity = 介護事業者Dac.selectByKey(事業者番号, 有効開始日);
        if (null != entity && null != entity.getJigyoshaName()) {
            return entity.getJigyoshaName().value();
        }
        return RString.EMPTY;
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
     * @param 償還払ViewStateDB情報 償還払ViewStateDB情報
     * @return DbJohoViewState
     */
    @Transaction
    public DbJohoViewState delShokanSyomeisyo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState 償還払ViewStateDB情報) {
        delete証明書明細(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 償還払ViewStateDB情報);
        return 償還払ViewStateDB情報;
    }

    @Transaction
    private DbJohoViewState delete証明書明細(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState 償還払ViewStateDB情報) {
        償還払ViewStateDB情報 = 償還払情報非空判断(償還払ViewStateDB情報);
        int count = 0;
        List<DbT3038ShokanKihonEntity> entityList1
                = 償還払請求基本Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList1 != null && !entityList1.isEmpty()) {
            for (DbT3038ShokanKihonEntity dbt3038entity : entityList1) {
                dbt3038entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求基本Dac.delete(dbt3038entity);
                償還払ViewStateDB情報.get償還払請求基本データList().add(new ShokanKihon(dbt3038entity));
            }
        }
        List<DbT3107ShokanMeisaiJushochiTokureiEntity> entityList2
                = 住所地特例Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList2 != null && !entityList2.isEmpty()) {
            for (DbT3107ShokanMeisaiJushochiTokureiEntity dbt3107entity : entityList2) {
                dbt3107entity.setState(EntityDataState.Deleted);
                count = count + 住所地特例Dac.delete(dbt3107entity);
                償還払ViewStateDB情報.get住所地特例データList().add(new ShokanMeisaiJushochiTokureiResult(
                        new ShokanMeisaiJushochiTokurei(dbt3107entity), RString.EMPTY, RString.EMPTY));
            }
        }
        List<DbT3039ShokanMeisaiEntity> entityList3
                = 償還払請求明細Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList3 != null && !entityList3.isEmpty()) {
            for (DbT3039ShokanMeisaiEntity dbt3039entity : entityList3) {
                dbt3039entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求明細Dac.delete(dbt3039entity);
                償還払ViewStateDB情報.get償還払請求明細データList().add(new ShokanMeisaiResult(new ShokanMeisai(dbt3039entity), RString.EMPTY));
            }
        }
        償還払ViewStateDB情報 = delete証明書_特定診療費明細(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 償還払ViewStateDB情報);
        償還払ViewStateDB情報 = delete証明書_サービス計画明細(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 償還払ViewStateDB情報);
        償還払ViewStateDB情報 = delete証明書_サービス費用明細(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 償還払ViewStateDB情報);
        償還払ViewStateDB情報 = delete証明書_緊急時施設療養明細(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 償還払ViewStateDB情報);
        return 償還払ViewStateDB情報;
    }

    private DbJohoViewState 償還払情報非空判断(DbJohoViewState 償還払ViewStateDB情報) {
        if (null == 償還払ViewStateDB情報.get住所地特例データList()) {
            ArrayList<ShokanMeisaiJushochiTokureiResult> 住所地特例データList = new ArrayList<>();
            償還払ViewStateDB情報.set住所地特例データList(住所地特例データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求明細データList()) {
            ArrayList<ShokanMeisaiResult> 償還払請求明細データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求明細データList(償還払請求明細データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求特定診療費データList()) {
            ArrayList<ShokanTokuteiShinryohi> 償還払請求特定診療費データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求特定診療費データList(償還払請求特定診療費データList);
        }
        if (null == 償還払ViewStateDB情報.get特別療養費データList()) {
            ArrayList<ShokanTokuteiShinryoTokubetsuRyoyo> 特別療養費データList = new ArrayList<>();
            償還払ViewStateDB情報.set特別療養費データList(特別療養費データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList()) {
            ArrayList<ShokanServicePlan200904Result> 償還払請求サービス計画200904データResultList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求サービス計画200904データResultList(償還払請求サービス計画200904データResultList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList()) {
            ArrayList<ShokanServicePlan200604Result> 償還払請求サービス計画200604データResultList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求サービス計画200604データResultList(償還払請求サービス計画200604データResultList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList()) {
            ArrayList<ShokanServicePlan200004Result> 償還払請求サービス計画200004データResultList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求サービス計画200004データResultList(償還払請求サービス計画200004データResultList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求特定入所者介護サービス費用データList()) {
            ArrayList<ShokanTokuteiNyushoshaKaigoServiceHiyo> 償還払請求特定入所者介護サービス費用データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求特定入所者介護サービス費用データList(償還払請求特定入所者介護サービス費用データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求社会福祉法人軽減額データList()) {
            ArrayList<ShokanShakaiFukushiHojinKeigengakuResult> 償還払請求社会福祉法人軽減額データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求社会福祉法人軽減額データList(償還払請求社会福祉法人軽減額データList);

        }
        if (null == 償還払ViewStateDB情報.get償還払請求所定疾患施設療養費等データList()) {
            ArrayList<ShokanShoteiShikkanShisetsuRyoyo> 償還払請求所定疾患施設療養費等データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求所定疾患施設療養費等データList(償還払請求所定疾患施設療養費等データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求緊急時施設療養データList()) {
            ArrayList<ShokanKinkyuShisetsuRyoyo> 償還払請求緊急時施設療養データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求緊急時施設療養データList(償還払請求緊急時施設療養データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求集計データList()) {
            ArrayList<ShokanShukeiResult> 償還払請求集計データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求集計データList(償還払請求集計データList);
        }
        if (null == 償還払ViewStateDB情報.get償還払請求食事費用データList()) {
            ArrayList<ShokanShokujiHiyo> 償還払請求食事費用データList = new ArrayList<>();
            償還払ViewStateDB情報.set償還払請求食事費用データList(償還払請求食事費用データList);
        }
        return 償還払ViewStateDB情報;
    }

    @Transaction
    private DbJohoViewState delete証明書_特定診療費明細(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState 償還払ViewStateDB情報) {
        int count = 0;
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth(サービス年月2.toString()))) {
            List<DbT3041ShokanTokuteiShinryohiEntity> entityList4
                    = 償還払請求特定診療費Dac.select証明書削除(被保険者番号, サービス提供年月,
                            整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList4 != null && !entityList4.isEmpty()) {
                for (DbT3041ShokanTokuteiShinryohiEntity dbt3041entity : entityList4) {
                    dbt3041entity.setState(EntityDataState.Deleted);
                    count = count + 償還払請求特定診療費Dac.delete(dbt3041entity);
                    償還払ViewStateDB情報.get償還払請求特定診療費データList().add(new ShokanTokuteiShinryohi(dbt3041entity));
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
                    償還払ViewStateDB情報.get特別療養費データList().add(new ShokanTokuteiShinryoTokubetsuRyoyo(dbt3042entity));
                }
            }
        }
        return 償還払ViewStateDB情報;
    }

    @Transaction
    private DbJohoViewState delete証明書_サービス計画明細(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState 償還払ViewStateDB情報) {
        int count = 0;
        if (new FlexibleYearMonth(サービス年月.toString()).isBeforeOrEquals(サービス提供年月)) {
            List<DbT3047ShokanServicePlan200904Entity> entityList6
                    = 償還払請求サービス計画200904Dac.select証明書削除(被保険者番号, サービス提供年月,
                            整理番号, 事業者番号, 様式番号, 明細番号);
            if (entityList6 != null && !entityList6.isEmpty()) {
                for (DbT3047ShokanServicePlan200904Entity dbt3047entity : entityList6) {
                    dbt3047entity.setState(EntityDataState.Deleted);
                    count = count + 償還払請求サービス計画200904Dac.delete(dbt3047entity);
                    償還払ViewStateDB情報.get償還払請求サービス計画200904データResultList().add(new ShokanServicePlan200904Result(
                            new ShokanServicePlan200904(dbt3047entity), RString.EMPTY));
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
                    償還払ViewStateDB情報.get償還払請求サービス計画200604データResultList().add(new ShokanServicePlan200604Result(
                            new ShokanServicePlan200604(dbt3046entity), RString.EMPTY));
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
                    償還払ViewStateDB情報.get償還払請求サービス計画200004データResultList().add(new ShokanServicePlan200004Result(
                            new ShokanServicePlan200004(dbt3045entity), RString.EMPTY));
                }
            }
        }
        return 償還払ViewStateDB情報;
    }

    @Transaction
    private DbJohoViewState delete証明書_サービス費用明細(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState 償還払ViewStateDB情報) {
        int count = 0;
        List<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> entityList9
                = 償還払請求特定入所者介護サービス費用Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList9 != null && !entityList9.isEmpty()) {
            for (DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity dbt3050entity : entityList9) {
                dbt3050entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求特定入所者介護サービス費用Dac.delete(dbt3050entity);
                償還払ViewStateDB情報.get償還払請求特定入所者介護サービス費用データList().add(new ShokanTokuteiNyushoshaKaigoServiceHiyo(dbt3050entity));
            }
        }
        List<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> entityList10
                = 償還払請求社会福祉法人軽減額Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList10 != null && !entityList10.isEmpty()) {
            for (DbT3051ShokanShakaiFukushiHojinKeigengakuEntity dbt3051entity : entityList10) {
                dbt3051entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求社会福祉法人軽減額Dac.delete(dbt3051entity);
                償還払ViewStateDB情報.get償還払請求社会福祉法人軽減額データList().add(new ShokanShakaiFukushiHojinKeigengakuResult(
                        new ShokanShakaiFukushiHojinKeigengaku(dbt3051entity), RString.EMPTY));
            }
        }
        List<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> entityList11
                = 償還払請求所定疾患施設療養費等Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList11 != null && !entityList11.isEmpty()) {
            for (DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity dbt3052entity : entityList11) {
                dbt3052entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求所定疾患施設療養費等Dac.delete(dbt3052entity);
                償還払ViewStateDB情報.get償還払請求所定疾患施設療養費等データList().add(new ShokanShoteiShikkanShisetsuRyoyo(dbt3052entity));
            }
        }
        return 償還払ViewStateDB情報;
    }

    @Transaction
    private DbJohoViewState delete証明書_緊急時施設療養明細(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, JigyoshaNo 事業者番号, RString 様式番号, RString 明細番号, DbJohoViewState 償還払ViewStateDB情報) {
        int count = 0;
        List<DbT3040ShokanKinkyuShisetsuRyoyoEntity> entityList12
                = 償還払請求緊急時施設療養Dac.select証明書削除(被保険者番号, サービス提供年月,
                        整理番号, 事業者番号, 様式番号, 明細番号);
        if (entityList12 != null && !entityList12.isEmpty()) {
            for (DbT3040ShokanKinkyuShisetsuRyoyoEntity dbt3040entity : entityList12) {
                dbt3040entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求緊急時施設療養Dac.delete(dbt3040entity);
                償還払ViewStateDB情報.get償還払請求緊急時施設療養データList().add(new ShokanKinkyuShisetsuRyoyo(dbt3040entity));
            }
        }
        List<DbT3053ShokanShukeiEntity> entityList13
                = 償還払請求集計Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号);
        if (entityList13 != null && !entityList13.isEmpty()) {
            for (DbT3053ShokanShukeiEntity dbt3053entity : entityList13) {
                dbt3053entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求集計Dac.delete(dbt3053entity);
                償還払ViewStateDB情報.get償還払請求集計データList().add(new ShokanShukeiResult(new ShokanShukei(dbt3053entity), RString.EMPTY));
            }
        }
        List<DbT3043ShokanShokujiHiyoEntity> entityList14
                = 償還払請求食事費用Dac.select証明書削除(被保険者番号, サービス提供年月, 整理番号,
                        事業者番号, 様式番号, 明細番号);
        if (entityList14 != null && !entityList14.isEmpty()) {
            for (DbT3043ShokanShokujiHiyoEntity dbt3043entity : entityList14) {
                dbt3043entity.setState(EntityDataState.Deleted);
                count = count + 償還払請求食事費用Dac.delete(dbt3043entity);
                償還払ViewStateDB情報.get償還払請求食事費用データList().add(new ShokanShokujiHiyo(dbt3043entity));
            }
        }
        return 償還払ViewStateDB情報;
    }
}
