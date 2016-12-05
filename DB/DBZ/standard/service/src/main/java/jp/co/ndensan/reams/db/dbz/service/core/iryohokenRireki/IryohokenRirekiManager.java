/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.iryohokenRireki;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.iryohokenRireki.IryohokenRirekiShubetsuCodeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.iryohokenRireki.IIryohokenRirekiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 医療保険種別情報を取得します。
 *
 * @author n8429
 */
public class IryohokenRirekiManager {

    private final MapperProvider mapperProvider;

    public static IryohokenRirekiManager createInstance() {
        return InstanceProvider.create(IryohokenRirekiManager.class);
    }

    /**
     * コンストラクタです。
     */
    IryohokenRirekiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 医療保険種別情報を取得します。
     *
     * @return List<IryohokenRirekiShubetsuCodeEntity> 医療保険種別情報
     */
    @Transaction
    public List<IryohokenRirekiShubetsuCodeEntity> getIryouHokenRirekiCode() {
        IIryohokenRirekiMapper mapper = this.mapperProvider.create(IIryohokenRirekiMapper.class);
        List<IryohokenRirekiShubetsuCodeEntity> 医療保険種別Entity = mapper.select医療保険種別();
        return 医療保険種別Entity;
    }

}
