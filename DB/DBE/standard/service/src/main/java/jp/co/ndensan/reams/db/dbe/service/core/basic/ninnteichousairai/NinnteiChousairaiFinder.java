/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninnteichousairai.NinnteiChousairaiEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ininnteichousairai.INinnteiChousairaiMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するクラスです。
 */
public class NinnteiChousairaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinnteiChousairaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    NinnteiChousairaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinnteiChousairaiFinder}のインスタンス
     */
    public static NinnteiChousairaiFinder createInstance() {
        return InstanceProvider.create(NinnteiChousairaiFinder.class);
    }

    /**
     * 認定調査委託先情報を取得する。
     *
     * @param parametere 要介護認定結果情報パラメータ
     * @return ShujiiMaster 認定調査委託先情報
     */
    @Transaction
    public SearchResult<NinnteiChousairaiBusiness> getNinnteiChousaItaku(NinnteiChousairaiParameter parametere) {
        INinnteiChousairaiMapper mapper = mapperProvider.create(INinnteiChousairaiMapper.class);
        List<NinnteiChousairaiEntity> entityList = mapper.selectNinnteiChousaItaku(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinnteiChousairaiBusiness>emptyList(), 0, false);
        }
        List<NinnteiChousairaiBusiness> 認定調査委託先List = new ArrayList<>();
        for (NinnteiChousairaiEntity entity : entityList) {
            認定調査委託先List.add(new NinnteiChousairaiBusiness(entity));
        }
        return SearchResult.of(認定調査委託先List, 0, false);
    }
}
