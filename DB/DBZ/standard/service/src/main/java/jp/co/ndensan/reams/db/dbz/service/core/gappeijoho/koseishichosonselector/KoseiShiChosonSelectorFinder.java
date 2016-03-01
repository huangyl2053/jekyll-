/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.koseishichosonselector;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichosonselector.KoseiShiChosonSelectorParamter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT7051KoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 構成市町村の検索処理クラスです。
 */
public class KoseiShiChosonSelectorFinder {
    
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KoseiShiChosonSelectorFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    
    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7131KaigoServiceNaiyouDac}
     */
    KoseiShiChosonSelectorFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShiChosonSelectorFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoseiShiChosonSelectorFinder}のインスタンス
     */
    public static KoseiShiChosonSelectorFinder createInstance() {
        return InstanceProvider.create(KoseiShiChosonSelectorFinder.class);
    }
    
    /**
     * 構成市町村を検索します。
     * @param param 成市町村の検索のパラメータ
     * @return SearchResult<KoseiShichoson>
     */
    public SearchResult<KoseiShichoson> getKoseiShichoson(KoseiShiChosonSelectorParamter param) {
        List<KoseiShichoson> koseiShichoson = new ArrayList<>();
        IDbT7051KoseiShichosonMasterMapper mapper = mapperProvider.create(IDbT7051KoseiShichosonMasterMapper.class);
        List<DbT7051KoseiShichosonMasterEntity> entityList = mapper.getKoseishichosonList(param);
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            koseiShichoson.add(new KoseiShichoson(entity));
        }
        return SearchResult.of(koseiShichoson, 0, false);
    }
}
