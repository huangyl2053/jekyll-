/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShokanFukushiYoguHanbaihiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3048ShokanFukushiYoguHanbaihiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyushisei.IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費支給申請一括審査・決定
 *
 * @author chenaoqi
 */
public class FukushiyoguKonyuhiShikyuIkkatuShinsa {

    private final MapperProvider mapperProvider;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3053ShokanShukeiDac 償還払集計Dac;
    private final FukushiyoguKonyuhiShikyuGendogaku sut;
    private final FukushiyoguKonyuhiShikyuGendogakuManager manager;
    private static final RString モード_審査 = new RString("審査");

    /**
     * コンストラクタです。
     */
    FukushiyoguKonyuhiShikyuIkkatuShinsa() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        償還払集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
        this.sut = InstanceProvider.create(FukushiyoguKonyuhiShikyuGendogaku.class);
        this.manager = InstanceProvider.create(FukushiyoguKonyuhiShikyuGendogakuManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider
     */
    FukushiyoguKonyuhiShikyuIkkatuShinsa(MapperProvider mapperProvider,
            DbT3034ShokanShinseiDac 償還払支給申請Dac,
            DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac,
            DbT3053ShokanShukeiDac 償還払集計Dac,
            FukushiyoguKonyuhiShikyuGendogaku sut,
            FukushiyoguKonyuhiShikyuGendogakuManager manager) {
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
     * @param 支給申請日From
     * @param 支給申請日To
     * @return List<ShokanShinseiEntity>
     */
    public List<ShokanShinseiEntity> getMiShinsaShinseiList(RDate 支給申請日From, RDate 支給申請日To) {

        IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
        List<ShokanShinseiEntity> resultList = mapper.select未審査申請(ShokanFukushiYoguHanbaihiParameter
                .createSelectByKeyParam(支給申請日From, 支給申請日To));
        if (resultList == null || resultList.isEmpty()) {
            resultList = new ArrayList<>();
        }
        return resultList;
    }

    /**
     * 更新処理
     *
     * @param 決定日
     * @param 支給申請一括審査List
     */
    public void updShikyuShinsei(FlexibleDate 決定日, List<ShokanShinseiEntity> 支給申請一括審査List) {
        if (支給申請一括審査List != null && !支給申請一括審査List.isEmpty()) {
            for (ShokanShinseiEntity shokanShinseiEntity : 支給申請一括審査List) {
                DbT3034ShokanShinseiEntity DbT3034entity = new DbT3034ShokanShinseiEntity();
                DbT3034entity.setHiHokenshaNo(shokanShinseiEntity.getHiHokenshaNo());
                DbT3034entity.setServiceTeikyoYM(shokanShinseiEntity.getServiceTeikyoYM());
                DbT3034entity.setSeiriNo(shokanShinseiEntity.getSeiriNp());
                DbT3034entity.setShikyuShinseiShinsaKubun(ShikyushinseiShinsaKubun.審査済.getコード());
                DbT3034entity.setShinsaKekka(shokanShinseiEntity.getShinsaKekka());
                DbT3034entity.setState(EntityDataState.Modified);
                償還払支給申請Dac.save(DbT3034entity);

                RString 審査結果 = ShinsaNaiyoKubun.承認する.getコード();
                RString 支給区分 = ShikyuFushikyuKubun.不支給.getコード();
                if (審査結果.equals(shokanShinseiEntity.getShinsaKekka())) {
                    支給区分 = ShikyuFushikyuKubun.支給.getコード();
                }

                DbT3036ShokanHanteiKekkaEntity DbT3036entity = new DbT3036ShokanHanteiKekkaEntity();
                DbT3036entity.setHiHokenshaNo(shokanShinseiEntity.getHiHokenshaNo());
                DbT3036entity.setServiceTeikyoYM(shokanShinseiEntity.getServiceTeikyoYM());
                DbT3036entity.setSeiriNo(shokanShinseiEntity.getSeiriNp());
                DbT3036entity.setShoKisaiHokenshaNo(shokanShinseiEntity.getShoKisaiHokenshaNo());
                DbT3036entity.setKetteiYMD(決定日);
                DbT3036entity.setShikyuHushikyuKetteiKubun(支給区分);
                DbT3036entity.setShiharaiKingaku(shokanShinseiEntity.getHokenKyufugaku());
                DbT3036entity.setState(EntityDataState.Added);
                償還払支給判定結果Dac.save(DbT3036entity);

                DbT3053ShokanShukeiEntity DbT3053entity = new DbT3053ShokanShukeiEntity();
                DbT3053entity.setHiHokenshaNo(shokanShinseiEntity.getHiHokenshaNo());
                DbT3053entity.setServiceTeikyoYM(shokanShinseiEntity.getServiceTeikyoYM());
                DbT3053entity.setSeiriNo(shokanShinseiEntity.getSeiriNp());
                DbT3053entity.setJigyoshaNo(shokanShinseiEntity.getJigyoshaNo());
                DbT3053entity.setYoshikiNo(shokanShinseiEntity.getYoshikiNo());
                DbT3053entity.setMeisaiNo(shokanShinseiEntity.getMeisaiNo());
                DbT3053entity.setShinsaYM(決定日.getYearMonth());
                DbT3053entity.setShikyuKubunCode(支給区分);
                DbT3053entity.setShikyuKingaku(shokanShinseiEntity.getHokenKyufugaku().intValue());
                DbT3053entity.setState(EntityDataState.Modified);
                償還払集計Dac.save(DbT3053entity);

                // 償還払請求基本情報を取得
                ShokanKihon 償還払請求基本情報entity = sut.getShokanSeikyuKihon(shokanShinseiEntity.getHiHokenshaNo(),
                        shokanShinseiEntity.getServiceTeikyoYM(),
                        shokanShinseiEntity.getSeiriNp(),
                        shokanShinseiEntity.getJigyoshaNo(),
                        shokanShinseiEntity.getYoshikiNo(),
                        shokanShinseiEntity.getMeisaiNo());

                // 償還払請求福祉用具販売費情報を取得
                List<ShokanFukushiYoguHanbaihi> 償還払請求福祉用具販売費リスト = sut.getShokanFukushiYoguHanbaihi(shokanShinseiEntity.getHiHokenshaNo(),
                        shokanShinseiEntity.getServiceTeikyoYM(),
                        shokanShinseiEntity.getSeiriNp(),
                        shokanShinseiEntity.getJigyoshaNo(),
                        shokanShinseiEntity.getYoshikiNo(),
                        shokanShinseiEntity.getMeisaiNo());
                List<DbT3048ShokanFukushiYoguHanbaihiEntity> DbT3048EntityList = new ArrayList<>();
                for (ShokanFukushiYoguHanbaihi entity : 償還払請求福祉用具販売費リスト) {
                    DbT3048EntityList.add(entity.toEntity());
                }
                // 償還払支給申請情報を取得
                ShokanShinsei 償還払支給申請情報entity = sut.getShokanShinsei(shokanShinseiEntity.getHiHokenshaNo(),
                        shokanShinseiEntity.getServiceTeikyoYM(),
                        shokanShinseiEntity.getSeiriNp());
                // 償還払支給判定結果を取得
                ShokanHanteiKekka 償還払支給判定結果entity = sut.getShokanHanteiKekka(shokanShinseiEntity.getHiHokenshaNo(),
                        shokanShinseiEntity.getServiceTeikyoYM(),
                        shokanShinseiEntity.getSeiriNp());
                // 償還払請求集計を取得
                ShokanShukei 償還払請求集計entity = sut.getShokanShukei(shokanShinseiEntity.getHiHokenshaNo(),
                        shokanShinseiEntity.getServiceTeikyoYM(),
                        shokanShinseiEntity.getSeiriNp(),
                        shokanShinseiEntity.getJigyoshaNo(),
                        shokanShinseiEntity.getYoshikiNo(),
                        shokanShinseiEntity.getMeisaiNo());
                // 給付実績処理メソッド
                manager.dealKyufujisseki(モード_審査, null,
                        償還払請求基本情報entity.toEntity(),
                        DbT3048EntityList,
                        償還払支給申請情報entity.toEntity(),
                        償還払支給判定結果entity.toEntity(),
                        償還払請求集計entity.toEntity(),
                        null);
            }
        }
    }
}
