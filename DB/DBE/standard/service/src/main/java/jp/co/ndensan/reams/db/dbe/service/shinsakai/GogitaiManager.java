/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.shinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohoshinsakai.GogitaiJohoShinsaRelateBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohoshinsakai.GogitaiJohoShinsaRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohoshinsakai.IGogitaiJohoShinsaMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 合議体情報の取得処理クラスです
 */
public class GogitaiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    GogitaiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GogitaiManager}のインスタンスを返します。
     *
     * @return GogitaiManager
     */
    public static GogitaiManager createInstance() {

        return InstanceProvider.create(GogitaiManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    GogitaiManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 合議体情報のリストを取得処理です。
     *
     * @return 合議体情報
     */
    public SearchResult<GogitaiJohoShinsaRelateBusiness> get合議体情報() {
        List<GogitaiJohoShinsaRelateBusiness> 合議体情報 = new ArrayList<>();
        IGogitaiJohoShinsaMapper mapper = mapperProvider.create(IGogitaiJohoShinsaMapper.class);
        List<GogitaiJohoShinsaRelateEntity> entityList = mapper.get合議体情報();
        for (GogitaiJohoShinsaRelateEntity entity : entityList) {
            合議体情報.add(new GogitaiJohoShinsaRelateBusiness(entity));
        }
        return SearchResult.of(合議体情報, 0, false);
    }
}
