/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.iraisho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraisho.IraishoIkkatsuHakkoResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.iraisho.IraishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraisho.IraishoIkkatsuHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.iraisho.IIraishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 依頼書一括発行のサービスクラスです。
 */
public class IraishoIkkatsuHakkoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    IraishoIkkatsuHakkoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    IraishoIkkatsuHakkoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IraishoIkkatsuHakkoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IraishoIkkatsuHakkoFinder}のインスタンス
     */
    public static IraishoIkkatsuHakkoFinder createInstance() {
        return InstanceProvider.create(IraishoIkkatsuHakkoFinder.class);
    }

    /**
     * 認定調査一覧のデータを取得します。
     *
     * @param param 依頼書一括発行のパラメータ
     * @return SearchResult<IraishoIkkatsuHakkoResult>
     */
    public SearchResult<IraishoIkkatsuHakkoResult> getNinteiChousaIrai(IraishoIkkatsuHakkoParameter param) {

        List<IraishoIkkatsuHakkoResult> resultList = new ArrayList<>();
        List<IraishoIkkatsuHakkoRelateEntity> iraishoRelateEntityList
                = mapperProvider.create(IIraishoIkkatsuHakkoMapper.class).getNinteiChousaIrai(param);
        if (iraishoRelateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<IraishoIkkatsuHakkoResult>emptyList(), 0, false);
        }
        for (IraishoIkkatsuHakkoRelateEntity entity : iraishoRelateEntityList) {
            resultList.add(new IraishoIkkatsuHakkoResult(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 主治医意見書一覧のデータを取得します。
     *
     * @param param 依頼書一括発行のパラメータ
     * @return SearchResult<IraishoIkkatsuHakkoResult>
     */
    public SearchResult<IraishoIkkatsuHakkoResult> getShuziiIkenshoIrai(IraishoIkkatsuHakkoParameter param) {

        List<IraishoIkkatsuHakkoResult> resultList = new ArrayList<>();
        List<IraishoIkkatsuHakkoRelateEntity> iraishoRelateEntityList
                = mapperProvider.create(IIraishoIkkatsuHakkoMapper.class).getShuziiIkenshoIrai(param);
        if (iraishoRelateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<IraishoIkkatsuHakkoResult>emptyList(), 0, false);
        }
        for (IraishoIkkatsuHakkoRelateEntity entity : iraishoRelateEntityList) {
            resultList.add(new IraishoIkkatsuHakkoResult(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

}
