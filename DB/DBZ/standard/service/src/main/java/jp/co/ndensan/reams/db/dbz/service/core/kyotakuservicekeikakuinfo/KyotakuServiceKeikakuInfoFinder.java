/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kyotakuservicekeikakuinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.kyotakuservicekeikakuinfo.KyotakuServiceKeikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoRelateParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kyotakuservicekeikakuinfo.IKyotakuServiceKeikakuInfoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定申請連絡先のクラスです。
 *
 * @reamsid_L DBE-3000-170 suguangjun
 */
public class KyotakuServiceKeikakuInfoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ。
     *
     */
    public KyotakuServiceKeikakuInfoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KyotakuServiceKeikakuInfoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyotakuServiceKeikakuInfoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyotakuServiceKeikakuInfoFinder}のインスタンス
     */
    public static KyotakuServiceKeikakuInfoFinder createInstance() {
        return InstanceProvider.create(KyotakuServiceKeikakuInfoFinder.class);
    }

    /**
     * 介護連絡先情報を取得します。
     *
     * @param parameter 居宅サービス計画情報
     * @return SearchResult<KyotakuServiceKeikaku> 居宅サービス計画情報
     */
    @Transaction
    public SearchResult<KyotakuServiceKeikaku> getKyotakuServiceKeikaku(KyotakuServiceKeikakuInfoRelateParameter parameter) {
        IKyotakuServiceKeikakuInfoMapper keikakuInfoMapper = mapperProvider.create(IKyotakuServiceKeikakuInfoMapper.class);
        List<KyotakuServiceKeikakuInfoRelateEntity> entityList = keikakuInfoMapper.getKyotakuServiceKeikaku(parameter);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<KyotakuServiceKeikaku>emptyList(), 0, false);
        }
        List<KyotakuServiceKeikaku> 計画情報 = new ArrayList<>();
        for (KyotakuServiceKeikakuInfoRelateEntity entity : entityList) {
            計画情報.add(new KyotakuServiceKeikaku(entity));
        }
        return SearchResult.of(計画情報, 0, false);
    }
}
