/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.shinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjohogogitai.ShinsakaiIinJohoGoitaiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjohogogitai.ShinsakaiIinJohoGoitaiEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho.IShinsakaiiinJohoGogitaiMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 印刷対象介護認定審査会委員の取得処理です。
 */
public class ShinsakaiiinJohoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiiinJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiiinJohoManager}のインスタンスを返します。
     *
     * @return ShinsakaiiinJohoManager
     */
    public static ShinsakaiiinJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiiinJohoManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    ShinsakaiiinJohoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 審査会委員情報の取得処理です。
     *
     * @return SearchResult<ShinsakaiIinJohoGoitaiBusiness>
     */
    public SearchResult<ShinsakaiIinJohoGoitaiBusiness> search審査会委員情報() {
        List<ShinsakaiIinJohoGoitaiBusiness> 審査会委員情報 = new ArrayList<>();
        IShinsakaiiinJohoGogitaiMapper mapper = mapperProvider.create(IShinsakaiiinJohoGogitaiMapper.class);
        List<ShinsakaiIinJohoGoitaiEntity> entityList = mapper.search審査会委員情報();
        for (ShinsakaiIinJohoGoitaiEntity entity : entityList) {
            審査会委員情報.add(new ShinsakaiIinJohoGoitaiBusiness(entity));
        }
        return SearchResult.of(審査会委員情報, 0, false);
    }
}
