/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shinsakaikaisai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaikaisai.IShinsakaiKaisaiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会共有一覧の検索クラスです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class ShinsakaiKaisaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaiKaisaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiFinder}のインスタンス
     */
    public static ShinsakaiKaisaiFinder createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiFinder.class);
    }

    /**
     * 審査会一覧を検索します。
     *
     * @param 審査会一覧検索Parameter ShinsakaiKaisaiParameter
     * @return SearchResult<ShinsakaiKaisai> 審査会一覧情報
     */
    @Transaction
    public SearchResult<ShinsakaiKaisai> get審査会一覧(ShinsakaiKaisaiParameter 審査会一覧検索Parameter) {
        IShinsakaiKaisaiMapper mapper = mapperProvider.create(IShinsakaiKaisaiMapper.class);
        List<ShinsakaiKaisaiRelateEntity> relateEntityList = mapper.get審査会一覧(審査会一覧検索Parameter);

        int totalcount = 0;
        if (relateEntityList == null || relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiKaisai>emptyList(), totalcount, false);
        } else {
            totalcount = relateEntityList.get(0).getTotalCount();
        }
        List<ShinsakaiKaisai> 審査会情報List = new ArrayList<>();
        for (ShinsakaiKaisaiRelateEntity relateEntity : relateEntityList) {
            審査会情報List.add(new ShinsakaiKaisai(relateEntity));
        }
        return SearchResult.of(審査会情報List, totalcount, 審査会一覧検索Parameter.getSaidaiHyojiKensu().intValue() < totalcount);
    }

    /**
     * 審査会開催番号で審査会を検索します。
     *
     * @param 審査会検索Parameter ShinsakaiKaisaiParameter
     * @return ShinsakaiKaisai 審査会情報 nullが返る可能性があります。
     */
    @Transaction
    public ShinsakaiKaisai get審査会(ShinsakaiKaisaiParameter 審査会検索Parameter) {
        IShinsakaiKaisaiMapper mapper = mapperProvider.create(IShinsakaiKaisaiMapper.class);
        ShinsakaiKaisaiRelateEntity relateEntity = mapper.get審査会(審査会検索Parameter);
        return relateEntity == null ? null : new ShinsakaiKaisai(relateEntity);
    }
}
