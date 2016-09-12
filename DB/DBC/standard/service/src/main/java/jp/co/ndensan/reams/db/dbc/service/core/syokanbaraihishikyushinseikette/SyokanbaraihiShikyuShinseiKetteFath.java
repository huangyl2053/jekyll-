/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.syokanbaraihishikyushinseikette;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
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
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.KyufujissekiKihonResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.KyufujissekiKihonParameter;
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
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraihishikyushinseikette.KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
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
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette.ISyokanbaraihiShikyuShinseiKetteMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_サービス年月 = new RString("サービス年月");
    private static final RString 定数_整理番号 = new RString("定数_整理番号");

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
}
