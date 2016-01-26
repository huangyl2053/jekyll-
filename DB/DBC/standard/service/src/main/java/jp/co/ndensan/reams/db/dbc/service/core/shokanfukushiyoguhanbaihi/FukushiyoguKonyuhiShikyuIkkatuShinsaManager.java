/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanfukushiyoguhanbaihi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.shokanfukushiyoguhanbaihi.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyugendogaku.ShikyuShiseiJohoKensakuKey;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.fukushiyogukonyuhishikyuikkatushinsa.IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 福祉用具購入費支給申請一括審査・決定
 *
 * @author chenaoqi
 */
public class FukushiyoguKonyuhiShikyuIkkatuShinsaManager {

    private final MapperProvider mapperProvider;
    private final DbT3034ShokanShinseiDac 償還払支給申請Dac;
    private final DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac;
    private final DbT3053ShokanShukeiDac 償還払集計Dac;

    /**
     * コンストラクタです。
     */
    FukushiyoguKonyuhiShikyuIkkatuShinsaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        償還払支給申請Dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
        償還払支給判定結果Dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
        償還払集計Dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider
     */
    FukushiyoguKonyuhiShikyuIkkatuShinsaManager(MapperProvider mapperProvider, DbT3034ShokanShinseiDac 償還払支給申請Dac,
            DbT3036ShokanHanteiKekkaDac 償還払支給判定結果Dac, DbT3053ShokanShukeiDac 償還払集計Dac) {
        this.mapperProvider = mapperProvider;
        this.償還払支給申請Dac = 償還払支給申請Dac;
        this.償還払支給判定結果Dac = 償還払支給判定結果Dac;
        this.償還払集計Dac = 償還払集計Dac;

    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link FukushiyoguKonyuhiShikyuIkkatuShinsaManager}
     */
    public static FukushiyoguKonyuhiShikyuIkkatuShinsaManager createInstance() {
        return InstanceProvider.create(FukushiyoguKonyuhiShikyuIkkatuShinsaManager.class);
    }

    /**
     * 未審査申請一覧取得
     *
     * @param 支給申請日From
     * @param 支給申請日To
     * @return List<ShokanShinseiEntity>
     */
    public List<ShokanShinseiEntity> getMiShinsaShinseiList(FlexibleDate 支給申請日From, FlexibleDate 支給申請日To) {

        Map<String, Object> 未審査申請取得検索条件 = new HashMap<>();
        未審査申請取得検索条件.put("支給申請日From", 支給申請日From);
        未審査申請取得検索条件.put("支給申請日To", 支給申請日To);
        IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper mapper
                = mapperProvider.create(IFukushiyoguKonyuhiShikyuIkkatuShinsaMapper.class);
        List<ShokanShinseiEntity> resultList = mapper.select未審査申請(未審査申請取得検索条件);
        if (null == resultList || resultList.isEmpty()) {
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

                ShikyuShiseiJohoKensakuKey 支給申請情報検索キー = ShikyuShiseiJohoKensakuKey.createShikyuShiseiJohoKensakuKey(shokanShinseiEntity.getHiHokenshaNo(), shokanShinseiEntity.getServiceTeikyoYM(),
                        shokanShinseiEntity.getSeiriNp(), shokanShinseiEntity.getJigyoshaNo(), shokanShinseiEntity.getYoshikiNo(), shokanShinseiEntity.getMeisaiNo());
                // TODO
                // FukushiyoguKonyuhiShikyuGendogaku sut = new FukushiyoguKonyuhiShikyuGendogaku();

                //FukushiyoguKonyuhiShikyuGendogakuManager manager = new FukushiyoguKonyuhiShikyuGendogakuManager();
            }
        }
    }
}
