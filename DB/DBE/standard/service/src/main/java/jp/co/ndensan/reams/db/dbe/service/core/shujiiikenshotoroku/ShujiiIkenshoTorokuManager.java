/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshotoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshotoroku.ShujiiIkenshoTorokuResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiikenshotoroku.ShujiiIkenshoTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshotoroku.ShujiiIkenshoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshotoroku.IShujiiIkenshoTorokuMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医意見書登録のサービスクラスです。
 */
public class ShujiiIkenshoTorokuManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ShujiiIkenshoTorokuManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoTorokuManager}のインスタンス
     */
    public static ShujiiIkenshoTorokuManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoTorokuManager.class);
    }

    /**
     * 主治医意見書登録画面初期検索
     *
     * @param param 主治医意見書登録のパラメータ
     * @return SearchResult<ShujiiIkenshoTorokuResult>
     */
    public SearchResult<ShujiiIkenshoTorokuResult> getDataForLoad(ShujiiIkenshoTorokuMapperParameter param) {
        List<ShujiiIkenshoTorokuResult> resultList = new ArrayList<>();
        ShujiiIkenshoTorokuRelateEntity entity
                = mapperProvider.create(IShujiiIkenshoTorokuMapper.class).getShujiiIkenshoForLoad(param);
        if (entity == null) {
            return SearchResult.of(Collections.<ShujiiIkenshoTorokuResult>emptyList(), 0, false);
        }
        resultList.add(new ShujiiIkenshoTorokuResult(entity));
        return SearchResult.of(resultList, 0, false);
    }
}
