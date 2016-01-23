/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shujiiikenshoiraishokai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshoirai.ShujiiIkenshoIraiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoirai.ShujiiIkenshoIraiEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.shujiiikenshoiraishokai.IShujiiIkenshoIraiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 *
 */
public class ShujiiIkenshoIraiShokaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoIraiShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShujiiIkenshoIraiShokaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIraiShokaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIraiShokaiFinder}のインスタンス
     */
    public static ShujiiIkenshoIraiShokaiFinder createInstance() {
        return InstanceProvider.create(ShujiiIkenshoIraiShokaiFinder.class);
    }

    /**
     * 認定調査情報を返します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return SearchResult<ShujiiIkenshoIraiBusiness> 認定調査情報
     */
    @Transaction
    public SearchResult<ShujiiIkenshoIraiBusiness> getNinnteiChousa(HihokenshaNo hihokenshaNo) {
        IShujiiIkenshoIraiMapper mapper = mapperProvider.create(IShujiiIkenshoIraiMapper.class);
        List<ShujiiIkenshoIraiEntity> relateEntityList = mapper.selectNinnteiChousa(hihokenshaNo);
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiIkenshoIraiBusiness>emptyList(), 0, false);
        }
        List<ShujiiIkenshoIraiBusiness> 認定調査情報List = new ArrayList<>();
        for (ShujiiIkenshoIraiEntity relateEntity : relateEntityList) {
            認定調査情報List.add(new ShujiiIkenshoIraiBusiness(relateEntity));
        }
        return SearchResult.of(認定調査情報List, 0, false);
    }
}
