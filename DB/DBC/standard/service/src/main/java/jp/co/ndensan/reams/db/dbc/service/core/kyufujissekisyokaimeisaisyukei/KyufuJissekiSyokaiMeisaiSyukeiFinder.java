/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufujissekisyokaimeisaisyukei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekisyokaimeisaisyukei.KyufuJissekiSyokaiMeisaiSyukeiBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekisyokaimeisaisyukei.KyufuJissekiSyokaiMeisaiSyukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyufujissekisyokaimeisaisyukei.IKyufuJissekiSyokaiMeisaiSyukeiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付実績照会_明細集計画面処理情報の取得クラスです。
 *
 * @reamsid_L DBC-2970-040 zhaoyao
 */
public class KyufuJissekiSyokaiMeisaiSyukeiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KyufuJissekiSyokaiMeisaiSyukeiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac dac
     * @param MapperProvider mapperProvider
     */
    KyufuJissekiSyokaiMeisaiSyukeiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuJissekiSyokaiMeisaiSyukeiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyufuJissekiSyokaiMeisaiSyukeiFinder}のインスタンス
     */
    public static KyufuJissekiSyokaiMeisaiSyukeiFinder createInstance() {
        return InstanceProvider.create(KyufuJissekiSyokaiMeisaiSyukeiFinder.class);
    }

    /**
     * 保険者情報を取得します。
     *
     * @return List<KyufuJissekiSyokaiMeisaiSyukeiEntity>
     */
    public SearchResult<KyufuJissekiSyokaiMeisaiSyukeiBusiness> get保険者情報() {
        IKyufuJissekiSyokaiMeisaiSyukeiMapper mapper = mapperProvider.create(IKyufuJissekiSyokaiMeisaiSyukeiMapper.class);
        List<KyufuJissekiSyokaiMeisaiSyukeiEntity> entityList = mapper.get保険者情報();
        List<KyufuJissekiSyokaiMeisaiSyukeiBusiness> businessList = new ArrayList<>();
        if (entityList != null) {
            for (KyufuJissekiSyokaiMeisaiSyukeiEntity entity : entityList) {
                businessList.add(new KyufuJissekiSyokaiMeisaiSyukeiBusiness(entity));
            }
        }
        return SearchResult.of(businessList, 0, false);
    }
}
