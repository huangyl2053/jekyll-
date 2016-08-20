/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sofujoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sofujoho.SofujohoBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sofujoho.SofujohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sofujoho.SofujohoRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sofujoho.ISofujohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤申立送付情報照会のクラスです。
 *
 * @reamsid_L DBC-2950-010 jinjue
 */
public class KagoMousitatesyoSouhuJyohouFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KagoMousitatesyoSouhuJyohouFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    KagoMousitatesyoSouhuJyohouFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KagoMousitatesyoSouhuJyohouFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KagoMousitatesyoSouhuJyohouFinder}のインスタンス
     */
    public static KagoMousitatesyoSouhuJyohouFinder createInstance() {
        return InstanceProvider.create(KagoMousitatesyoSouhuJyohouFinder.class);
    }

    /**
     * 検索条件より、過誤申立送付情報照会を取得します。
     *
     * @param parameter 過誤申立送付情報照会検索条件
     * @return 過誤申立送付情報照会リスト
     */
    @Transaction
    public SearchResult<SofujohoBusiness> get過誤申立送付情報照会(SofujohoMybatisParameter parameter) {
        ISofujohoMapper mapper = mapperProvider.create(ISofujohoMapper.class);
        List<SofujohoBusiness> businessList = new ArrayList<>();
        List<SofujohoRelateEntity> entityList = mapper.select過誤申立送付情報照会(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<SofujohoBusiness>emptyList(), 0, false);
        }
        for (SofujohoRelateEntity entity : entityList) {
            //   businessList.add(new SofujohoBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
