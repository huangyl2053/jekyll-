/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikenshohoshushokai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai.IkenshoHoshuShokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshohoshushokai.IkenshoHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshohoshushokai.IIkenshoHoshuShokaiRelateMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 意見書作成報酬照会のServiceクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoHoshuShokaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    public IkenshoHoshuShokaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * コンストラクタです。
     */
    public IkenshoHoshuShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IkenshoHoshuShokaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IkenshoHoshuShokaiFinder}のインスタンス
     */
    public static IkenshoHoshuShokaiFinder createInstance() {
        return InstanceProvider.create(IkenshoHoshuShokaiFinder.class);
    }

    /**
     * 合計額リストの作成です。
     *
     * @param ikenshoParamter IkenshoHoshuShokaiMapperParameter
     * @return SearchResult<IkenshoHoshuShokaiBusiness>
     */
    public SearchResult<IkenshoHoshuShokaiBusiness> select合計額リスト(IkenshoHoshuShokaiMapperParameter ikenshoParamter) {
        IIkenshoHoshuShokaiRelateMapper mapper = mapperProvider.create(IIkenshoHoshuShokaiRelateMapper.class);
        List<IkenshoHoshuShokaiRelateEntity> entityList = mapper.select合計額リスト(ikenshoParamter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<IkenshoHoshuShokaiBusiness>emptyList(), 0, false);
        }
        List<IkenshoHoshuShokaiBusiness> list = new ArrayList<>();
        for (IkenshoHoshuShokaiRelateEntity entity : entityList) {
            list.add(new IkenshoHoshuShokaiBusiness(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}
