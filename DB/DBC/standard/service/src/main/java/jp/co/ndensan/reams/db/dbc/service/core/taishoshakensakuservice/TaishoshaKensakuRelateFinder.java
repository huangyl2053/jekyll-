/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.taishoshakensakuservice;

import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensakubusiness.TaishoshaKensakuRelateBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensakumybatisprm.TaishoshaKensakuMybitisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishoshakensaku.TaishoshaKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishoshakensakumapper.ITaishoshaKensakuRelateMapper;

/**
 * 過誤申立決定情報照会を検索するクラスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
public class TaishoshaKensakuRelateFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TaishoshaKensakuRelateFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TaishoshaKensakuRelateFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaishoshaKensakuRelateFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TaishoshaKensakuRelateFinder}のインスタンス
     */
    public static TaishoshaKensakuRelateFinder createInstance() {
        return InstanceProvider.create(TaishoshaKensakuRelateFinder.class);
    }

    /**
     * 検索条件より、過誤申立決定情報照会情報を取得します。
     *
     * @param parameter 検索条件
     * @return SearchResult<TaishoshaKensakuRelateBusiness> 過誤申立決定情報照会情報リスト
     */
    @Transaction
    public SearchResult<TaishoshaKensakuRelateBusiness> saiSinsaKeteiJyohouList(TaishoshaKensakuMybitisParamter parameter) {
        ITaishoshaKensakuRelateMapper mapper = mapperProvider.create(ITaishoshaKensakuRelateMapper.class);
        List<TaishoshaKensakuRelateBusiness> businessList = new ArrayList<>();
        List<TaishoshaKensakuRelateEntity> entityList = mapper.get過誤決定情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<TaishoshaKensakuRelateBusiness>emptyList(), 0, false);
        }
        for (TaishoshaKensakuRelateEntity entity : entityList) {
            businessList.add(new TaishoshaKensakuRelateBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件より、履歴番号情報を取得します。
     *
     * @param parameter 検索条件
     * @return SearchResult<TaishoshaKensakuRelateBusiness> 履歴番号情報
     */
    @Transaction
    public SearchResult<TaishoshaKensakuRelateBusiness> get履歴番号(TaishoshaKensakuMybitisParamter parameter) {
        ITaishoshaKensakuRelateMapper mapper = mapperProvider.create(ITaishoshaKensakuRelateMapper.class);
        List<TaishoshaKensakuRelateBusiness> businessList = new ArrayList<>();
        List<TaishoshaKensakuRelateEntity> entityList = mapper.select履歴番号情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<TaishoshaKensakuRelateBusiness>emptyList(), 0, false);
        }
        for (TaishoshaKensakuRelateEntity entity : entityList) {
            businessList.add(new TaishoshaKensakuRelateBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
