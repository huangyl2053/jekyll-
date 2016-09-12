/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyuikkatushinsa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntityResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyuikkatushinsa.HihokenshaNoParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyuikkatushinsa.ShokanFukushiYoguHanbaihiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyuikkatushinsa.IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費支給申請一括審査・決定
 *
 * @reamsid_L DBC-1021-100 chenaoqi
 */
public class FukushiyoguKonyuhiShikyuIkkatuShinsa {

    private final MapperProvider mapperProvider;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3053ShokanShukeiDac 償還払集計Dac;
    private final FukushiyoguKonyuhiShikyuShinsei sut;
    private final FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu manager;
    private static final RString モード_審査 = new RString("審査");

    /**
     * コンストラクタです。
     */
    FukushiyoguKonyuhiShikyuIkkatuShinsa() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        償還払集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.sut = InstanceProvider.create(FukushiyoguKonyuhiShikyuShinsei.class);
        this.manager = InstanceProvider.create(FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 償還払支給申請Dac 償還払支給申請Dac
     * @param 償還払支給判定結果Dac 償還払支給判定結果Dac
     * @param 償還払集計Dac
     * @param sut sut
     * @param manager manager
     */
    FukushiyoguKonyuhiShikyuIkkatuShinsa(MapperProvider mapperProvider,
            DbT3034ShokanShinseiDac 償還払支給申請Dac,
            DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac,
            DbT3053ShokanShukeiDac 償還払集計Dac,
            FukushiyoguKonyuhiShikyuShinsei sut,
            FukushiyoguKonyuhiShikyuKetteiKyufuJissekiHenshu manager) {
        this.mapperProvider = mapperProvider;
        this.償還払支給申請Dac = 償還払支給申請Dac;
        this.償還払支給判定結果Dac = 償還払支給判定結果Dac;
        this.償還払集計Dac = 償還払集計Dac;
        this.sut = sut;
        this.manager = manager;

    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link FukushiyoguKonyuhiShikyuIkkatuShinsa}
     */
    public static FukushiyoguKonyuhiShikyuIkkatuShinsa createInstance() {
        return InstanceProvider.create(FukushiyoguKonyuhiShikyuIkkatuShinsa.class);
    }

    /**
     * 未審査申請一覧取得
     *
     * @param 支給申請日From 支給申請日From
     * @param 支給申請日To 支給申請日To
     * @return List<ShokanShinseiEntityResult> 未審査申請一覧
     */
    public List<ShokanShinseiEntityResult> getMiShinsaShinseiList(FlexibleDate 支給申請日From,
            FlexibleDate 支給申請日To) {

        IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);

        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        ShokanFukushiYoguHanbaihiParameter parameter = ShokanFukushiYoguHanbaihiParameter
                .createSelectByKeyParam(searchKey, 支給申請日From, 支給申請日To);

        List<ShokanShinseiEntity> resultList = mapper.select未審査申請(parameter);
        if (resultList == null || resultList.isEmpty()) {
            resultList = new ArrayList<>();
        }
        List<ShokanShinseiEntityResult> result = new ArrayList<>();
        for (ShokanShinseiEntity shokanShinseiEntity : resultList) {
            ShokanShinseiEntityResult entity = new ShokanShinseiEntityResult(shokanShinseiEntity);
            result.add(entity);
        }
        return result;
    }

    /**
     * 更新処理
     *
     * @param 決定日 決定日
     * @param 支給申請一括審査List 支給申請一括審査List
     */
    public void updShikyuShinsei(FlexibleDate 決定日, List<ShokanShinseiEntityResult> 支給申請一括審査List) {
        if (支給申請一括審査List != null && !支給申請一括審査List.isEmpty()) {
            for (ShokanShinseiEntityResult result : 支給申請一括審査List) {
                if (result.getEntity().get償還払請求基本Entity() == null || result.getEntity().get償還払支給申請Entity() == null) {
                    continue;
                }
                HihokenshaNoParameter parameter = new HihokenshaNoParameter(result.getEntity()
                        .get償還払請求基本Entity().getHiHokenshaNo());
                IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper mapper
                        = mapperProvider.create(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
                DbT1001HihokenshaDaichoEntity 被保険者Entity = mapper.select識別コード(parameter);
                DbT3034ShokanShinseiEntity dbT3034entity = result.getEntity().get償還払支給申請Entity();
                dbT3034entity.setShikyuShinseiShinsaKubun(ShikyushinseiShinsaKubun.審査済.getコード());
                dbT3034entity.setShinsaYMD(FlexibleDate.getNowDate());
                dbT3034entity.setState(EntityDataState.Modified);
                償還払支給申請Dac.save(dbT3034entity);

                RString 審査結果 = ShinsaNaiyoKubun.承認する.getコード();
                RString 支給区分 = ShikyuFushikyuKubun.不支給.getコード();
                if (審査結果.equals(result.getEntity().get償還払支給申請Entity().getShinsaKekka())) {
                    支給区分 = ShikyuFushikyuKubun.支給.getコード();
                }

                DbT3036ShokanHanteiKekkaEntity dbT3036entity = new DbT3036ShokanHanteiKekkaEntity();
                dbT3036entity.setHiHokenshaNo(result.getEntity().get償還払請求基本Entity().getHiHokenshaNo());
                dbT3036entity.setServiceTeikyoYM(result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM());
                dbT3036entity.setSeiriNo(result.getEntity().get償還払請求基本Entity().getSeiriNo());
                dbT3036entity.setShoKisaiHokenshaNo(result.getEntity().get償還払支給申請Entity().getShoKisaiHokenshaNo());
                dbT3036entity.setKetteiYMD(決定日);
                dbT3036entity.setShikyuHushikyuKetteiKubun(支給区分);
                dbT3036entity.setShiharaiKingaku(new Decimal(result.getEntity().
                        get償還払支給申請Entity().getHokenKyufugaku()));
                dbT3036entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(dbT3036entity);

                List<DbT3053ShokanShukeiEntity> dbT3053entityList = 償還払集計Dac.selectByKey(
                        result.getEntity().get償還払請求基本Entity().getHiHokenshaNo(),
                        result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM(),
                        result.getEntity().get償還払請求基本Entity().getSeiriNo(),
                        result.getEntity().get償還払請求基本Entity().getJigyoshaNo(),
                        result.getEntity().get償還払請求基本Entity().getYoshikiNo(),
                        result.getEntity().get償還払請求基本Entity().getMeisaiNo());
                for (DbT3053ShokanShukeiEntity dbT3053entity : dbT3053entityList) {
                    dbT3053entity.setShinsaYM(決定日.getYearMonth());
                    dbT3053entity.setShikyuKubunCode(支給区分);
                    dbT3053entity.setShikyuKingaku(result.getEntity().get償還払支給申請Entity().getHokenKyufugaku());
                    dbT3053entity.setState(EntityDataState.Modified);
                    償還払集計Dac.save(dbT3053entity);
                }

                ShokanKihon 償還払請求基本情報entity = sut.getShokanSeikyuKihon(
                        result.getEntity().get償還払請求基本Entity().getHiHokenshaNo(),
                        result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM(),
                        result.getEntity().get償還払請求基本Entity().getSeiriNo(),
                        result.getEntity().get償還払請求基本Entity().getJigyoshaNo(),
                        result.getEntity().get償還払請求基本Entity().getYoshikiNo(),
                        result.getEntity().get償還払請求基本Entity().getMeisaiNo()
                );
                DbT3038ShokanKihonEntity dbt3038Entity = null;
                if (償還払請求基本情報entity != null) {
                    dbt3038Entity = 償還払請求基本情報entity.toEntity();
                }

                List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト = sut.getShokanFukushiYoguHanbaihi(
                        result.getEntity().get償還払請求基本Entity().getHiHokenshaNo(),
                        result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM(),
                        result.getEntity().get償還払請求基本Entity().getSeiriNo(),
                        result.getEntity().get償還払請求基本Entity().getJigyoshaNo(),
                        result.getEntity().get償還払請求基本Entity().getYoshikiNo(),
                        result.getEntity().get償還払請求基本Entity().getMeisaiNo());
                List<DbT3048ShokanFukushiYoguHanbaihiEntity> dbT3048EntityList = new ArrayList<>();
                for (ShokanFukushiYoguHanbaihi entity : 償還払請求福祉用具販売費リスト) {
                    dbT3048EntityList.add(entity.toEntity());
                }

                ShokanShinsei 償還払支給申請情報entity = sut.getShokanShinsei(
                        result.getEntity().get償還払請求基本Entity().getHiHokenshaNo(),
                        result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM(),
                        result.getEntity().get償還払請求基本Entity().getSeiriNo());
                DbT3034ShokanShinseiEntity dbt3034Entity = null;
                if (償還払支給申請情報entity != null) {
                    dbt3034Entity = 償還払支給申請情報entity.toEntity();
                }

                ShokanHanteiKekka 償還払支給判定結果entity = sut.getShokanHanteiKekka(
                        result.getEntity().get償還払請求基本Entity().getHiHokenshaNo(),
                        result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM(),
                        result.getEntity().get償還払請求基本Entity().getSeiriNo());
                DbT3036ShokanHanteiKekkaEntity dbt3036Entity = null;
                if (償還払支給判定結果entity != null) {
                    dbt3036Entity = 償還払支給判定結果entity.toEntity();
                }

                ShokanShukei 償還払請求集計entity = sut.getShokanShukei(
                        result.getEntity().get償還払請求基本Entity().getHiHokenshaNo(),
                        result.getEntity().get償還払請求基本Entity().getServiceTeikyoYM(),
                        result.getEntity().get償還払請求基本Entity().getSeiriNo());
                DbT3053ShokanShukeiEntity dbt3053Entity = null;
                if (償還払請求集計entity != null) {
                    dbt3053Entity = 償還払請求集計entity.toEntity();
                }
                if (被保険者Entity != null) {
                    manager.dealKyufujisseki(モード_審査,
                            被保険者Entity.getShikibetsuCode(),
                            dbt3038Entity,
                            dbT3048EntityList,
                            dbt3034Entity,
                            dbt3036Entity,
                            dbt3053Entity,
                            null);
                }
            }
        }
    }
}
