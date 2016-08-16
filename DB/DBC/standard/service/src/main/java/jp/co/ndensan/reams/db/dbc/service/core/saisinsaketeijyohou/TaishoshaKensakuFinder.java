/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saisinsaketeijyohou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.saisinsaketeijyohou.TaishoshaKensakuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saisinsaketeijyohou.TaishoshaKensakuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saisinsaketeijyohou.TaishoshaKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saisinsaketeijyohou.ITaishoshaKensakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 画面設計_DBCMN11004_高額介護サービス費照会のクラスです。
 *
 * @reamsid_L DBC-3040-010 zhangzhiming
 */
public class TaishoshaKensakuFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TaishoshaKensakuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TaishoshaKensakuFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TaishoshaKensakuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TaishoshaKensakuFinder}のインスタンス
     */
    public static TaishoshaKensakuFinder createInstance() {
        return InstanceProvider.create(TaishoshaKensakuFinder.class);
    }

    /**
     * 検索条件より、再審査決定情報を取得します。
     *
     * @param parameter 再審査決定検索条件
     * @return SearchResult<TaishoshaKensakuBusiness> 再審査決定情報リスト
     */
    @Transaction
    public SearchResult<TaishoshaKensakuBusiness> saiSinsaKeteiJyohouList(TaishoshaKensakuParameter parameter) {
        ITaishoshaKensakuMapper mapper = mapperProvider.create(ITaishoshaKensakuMapper.class);
        List<TaishoshaKensakuBusiness> businessList = new ArrayList<>();
        List<TaishoshaKensakuRelateEntity> entityList = mapper.select再審査決定情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<TaishoshaKensakuBusiness>emptyList(), 0, false);
        }
        for (TaishoshaKensakuRelateEntity entity : entityList) {
            businessList.add(new TaishoshaKensakuBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件より、履歴番号情報を取得します。
     *
     * @param parameter 再審査決定検索条件
     * @return SearchResult<TaishoshaKensakuBusiness> 履歴番号情報
     */
    @Transaction
    public SearchResult<TaishoshaKensakuBusiness> get履歴番号(TaishoshaKensakuParameter parameter) {
        ITaishoshaKensakuMapper mapper = mapperProvider.create(ITaishoshaKensakuMapper.class);
        List<TaishoshaKensakuBusiness> businessList = new ArrayList<>();
        List<TaishoshaKensakuRelateEntity> entityList = mapper.select履歴番号情報(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<TaishoshaKensakuBusiness>emptyList(), 0, false);
        }
        for (TaishoshaKensakuRelateEntity entity : entityList) {
            businessList.add(new TaishoshaKensakuBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
