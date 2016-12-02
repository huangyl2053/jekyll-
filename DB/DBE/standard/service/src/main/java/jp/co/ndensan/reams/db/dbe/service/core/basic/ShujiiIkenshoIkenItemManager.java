/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiilenshoitem.ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiikenshoitem.IShujiiIkenshoItemMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author n3509
 */
public class ShujiiIkenshoIkenItemManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIkenItemManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIkenItemManager}のインスタンスを返します。
     *
     * @return JigyoshaInputGuideFinder
     */
    public static ShujiiIkenshoIkenItemManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoIkenItemManager.class);
    }

    @Transaction
    public List<ShujiiIkenshoIkenItemEntity> select主治医意見書(ShinseishoKanriNo shinseishoKanriNo, int iraiRirekiNo) {
        IShujiiIkenshoItemMapper mapper = mapperProvider.create(IShujiiIkenshoItemMapper.class);
        return mapper.select主治医意見書(shinseishoKanriNo.value(), iraiRirekiNo);
    }
}
