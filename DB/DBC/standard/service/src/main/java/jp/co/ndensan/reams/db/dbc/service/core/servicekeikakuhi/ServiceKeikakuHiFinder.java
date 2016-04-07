/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.servicekeikakuhi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.servicekeikakuhi.ServiceKeikakuHiRealtEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceKeikakuHiFinder {

    private final DbT3047ShokanServicePlan200904Dac dac;
    private static final int NUMBER413 = 413;
    private static final int NUMBER4564 = 4564;
    private static final int NUMBER9876 = 9876;
    private static final int NUMBER2589 = 2589;
    private static final int NUMBER54897 = 54897;
    private static final int NUMBER984564 = 984564;
    private static final int NUMBER789798 = 789798;
    private static final int NUMBER45416 = 45416;
    private static final int NUMBER1156456 = 1156456;
    private static final int NUMBER478784 = 478784;

    /**
     * コンストラクタです。
     */
    ServiceKeikakuHiFinder() {
        dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HijihatsuKojinShitsugyoshaFinder}のインスタンスを返します。
     *
     * @return ServiceKeikakuHiFinder
     */
    public static ServiceKeikakuHiFinder createInstance() {

        return InstanceProvider.create(ServiceKeikakuHiFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3047ShokanServicePlan200904Dac}
     */
    ServiceKeikakuHiFinder(DbT3047ShokanServicePlan200904Dac dac) {
        this.dac = dac;
    }

    /**
     * selectShokanServicePlan200904
     *
     * @param サービス年月 サービス年月
     * @param 被保険者番号 被保険者番号
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @return List<ServiceKeikakuHiRealtEntity>
     */
    public List<ServiceKeikakuHiRealtEntity> selectShokanServicePlan200904(
            FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) {
        List<DbT3047ShokanServicePlan200904Entity> entity200904List = new ArrayList<>();
        DbT3047ShokanServicePlan200904Entity entity200904
                = new DbT3047ShokanServicePlan200904Entity();
        DbT3047ShokanServicePlan200904Entity entity2009042
                = new DbT3047ShokanServicePlan200904Entity();
        entity2009042.setRenban(new RString("13"));
        entity2009042.setHiHokenshaNo(new HihokenshaNo("1"));
        entity2009042.setServiceTeikyoYM(new FlexibleYearMonth(new RString("200904")));
        entity2009042.setSeiriNo(new RString("12"));
        entity2009042.setJigyoshaNo(new JigyoshaNo("1"));
        entity2009042.setYoshikiNo(new RString("34"));
        entity2009042.setShiteiKijunGaitoJigyoshaKubunCode(new RString("654"));
        entity2009042.setMeisaiNo(new RString("56"));
        entity2009042.setKyotakuServiceSakuseiIraiYMD(new FlexibleDate(new RString("20000101")));
        entity2009042.setServiceCode(new ServiceCode(new RString("21")));
        entity2009042.setTanisu(NUMBER413);
        entity2009042.setKaisu(NUMBER4564);
        entity2009042.setServiceTanisu(NUMBER9876);
        entity2009042.setTanisuTanka(new Decimal(NUMBER2589));
        entity2009042.setServiceTanisuTotal(NUMBER54897);
        entity2009042.setSeikyuKingaku(NUMBER984564);
        entity2009042.setTantokangoshienSemmoninNo(new RString("963"));
        entity2009042.setTekiyo(new RString("摘要123311"));
        entity2009042.setShinsaHohoKubunCode(new RString("1"));
        entity2009042.setShinsaYM(new FlexibleYearMonth(new RString("200101")));
        entity2009042.setShikyuKubunCode(new RString("1"));
        entity2009042.setTensuKingaku(NUMBER789798);
        entity2009042.setShikyuKingaku(NUMBER45416);
        entity2009042.setZougenTen(NUMBER1156456);
        entity2009042.setSagakuKingaku(NUMBER478784);
        entity2009042.setZougenRiyu(new RString("DEFAULT_増減理由等"));
        entity2009042.setFushikyuRiyu(new RString("DEFAULT_不支給理由等"));
        entity2009042.setKounyuKaishuRireki(new RString("購入_改修履歴等"));
        entity200904List.add(entity2009042);
        entity200904List.add(entity200904);
        List<ServiceKeikakuHiRealtEntity> serviceKeikakuHiList = new ArrayList<>();
        for (DbT3047ShokanServicePlan200904Entity entity : entity200904List) {
            serviceKeikakuHiList.add(new ServiceKeikakuHiRealtEntity(entity, null, null));
        }
        return serviceKeikakuHiList;
    }

    /**
     * selectShokanServicePlan200604
     *
     * @param サービス年月 サービス年月
     * @param 被保険者番号 被保険者番号
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @return ServiceKeikakuHiRealtEntity
     */
    public ServiceKeikakuHiRealtEntity selectShokanServicePlan200604(
            FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) {
        DbT3046ShokanServicePlan200604Entity entity200604
                = new DbT3046ShokanServicePlan200604Entity();
        return new ServiceKeikakuHiRealtEntity(null, entity200604, null);
    }

    /**
     * selectShokanServicePlan200004
     *
     * @param サービス年月 サービス年月
     * @param 被保険者番号 被保険者番号
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @return ServiceKeikakuHiRealtEntity
     */
    public ServiceKeikakuHiRealtEntity selectShokanServicePlan200004(
            FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) {
        DbT3045ShokanServicePlan200004Entity entity200004
                = new DbT3045ShokanServicePlan200004Entity();
        return new ServiceKeikakuHiRealtEntity(null, null, entity200004);
    }

    /**
     * selectByKey
     *
     * @param サービス年月 サービス年月
     * @param 被保険者番号 被保険者番号
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 明細番号 明細番号
     * @param 連番 連番
     * @return ServiceKeikakuHiRealtEntity
     */
    public ServiceKeikakuHiRealtEntity selectByKey(
            FlexibleYearMonth サービス年月,
            HihokenshaNo 被保険者番号,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        DbT3047ShokanServicePlan200904Entity entity200904
                = new DbT3047ShokanServicePlan200904Entity();
        entity200904.setRenban(new RString("13"));
        entity200904.setHiHokenshaNo(new HihokenshaNo("1"));
        entity200904.setServiceTeikyoYM(new FlexibleYearMonth(new RString("200904")));
        entity200904.setSeiriNo(new RString("12"));
        entity200904.setJigyoshaNo(new JigyoshaNo("1"));
        entity200904.setYoshikiNo(new RString("34"));
        entity200904.setShiteiKijunGaitoJigyoshaKubunCode(new RString("654"));
        entity200904.setMeisaiNo(new RString("56"));
        entity200904.setKyotakuServiceSakuseiIraiYMD(new FlexibleDate(new RString("20000101")));
        entity200904.setServiceCode(new ServiceCode(new RString("21")));
        entity200904.setTanisu(NUMBER413);
        entity200904.setKaisu(NUMBER4564);
        entity200904.setServiceTanisu(NUMBER9876);
        entity200904.setTanisuTanka(new Decimal(NUMBER2589));
        entity200904.setServiceTanisuTotal(NUMBER54897);
        entity200904.setSeikyuKingaku(NUMBER984564);
        entity200904.setTantokangoshienSemmoninNo(new RString("963"));
        entity200904.setTekiyo(new RString("摘要123311"));
        entity200904.setShinsaHohoKubunCode(new RString("1"));
        entity200904.setShinsaYM(new FlexibleYearMonth(new RString("200101")));
        entity200904.setShikyuKubunCode(new RString("1"));
        entity200904.setTensuKingaku(NUMBER789798);
        entity200904.setShikyuKingaku(NUMBER45416);
        entity200904.setZougenTen(NUMBER1156456);
        entity200904.setSagakuKingaku(NUMBER478784);
        entity200904.setZougenRiyu(new RString("DEFAULT_増減理由等"));
        entity200904.setFushikyuRiyu(new RString("DEFAULT_不支給理由等"));
        entity200904.setKounyuKaishuRireki(new RString("購入_改修履歴等"));
        return new ServiceKeikakuHiRealtEntity(entity200904, null, null);
    }
}
