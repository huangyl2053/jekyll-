/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5304ShujiiIkenshoIkenItemMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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

    public List<DbT5304ShujiiIkenshoIkenItemEntity> select主治医意見書(ShinseishoKanriNo shinseishoKanriNo, int iraiRirekiNo) {
        IDbT5304ShujiiIkenshoIkenItemMapper mapper = mapperProvider.create(IDbT5304ShujiiIkenshoIkenItemMapper.class);
        return mapper.select主治医意見書(shinseishoKanriNo, iraiRirekiNo);
    }
}
