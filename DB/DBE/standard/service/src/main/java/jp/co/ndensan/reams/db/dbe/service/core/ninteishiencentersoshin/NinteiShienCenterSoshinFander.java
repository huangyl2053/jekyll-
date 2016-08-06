/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishiencentersoshin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishiencentersoshin.NinteiShienCenterSoshinData;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteishiencentersoshin.NinteiShienCenterSoshinParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishiencentersoshin.NinteiShienCenterSoshinEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishiencentersoshin.INinteiShienCenterSoshinMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * センター送信準備のFanderクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public class NinteiShienCenterSoshinFander {

    private final MapperProvider mapperProvider;

    NinteiShienCenterSoshinFander() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    NinteiShienCenterSoshinFander(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShienCenterSoshinFander}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShienCenterSoshinFander}のインスタンス
     */
    public static NinteiShienCenterSoshinFander creatInstance() {
        return InstanceProvider.create(NinteiShienCenterSoshinFander.class);
    }

    /**
     * 対象者一覧情報を取得します。
     *
     * @param param 検索用パラメータです。
     * @return SearchResult<NinteiChosaJissekiShokai>
     */
    @Transaction
    public SearchResult<NinteiShienCenterSoshinData> get対象者一覧情報(NinteiShienCenterSoshinParameter param) {
        INinteiShienCenterSoshinMapper mapper = mapperProvider.create(INinteiShienCenterSoshinMapper.class);
        List<NinteiShienCenterSoshinEntity> entityList = mapper.get対象者一覧情報(param);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteiShienCenterSoshinData>emptyList(), 0, false);
        }
        List<NinteiShienCenterSoshinData> list = new ArrayList<>();
        for (NinteiShienCenterSoshinEntity entity : entityList) {
            list.add(new NinteiShienCenterSoshinData(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}
