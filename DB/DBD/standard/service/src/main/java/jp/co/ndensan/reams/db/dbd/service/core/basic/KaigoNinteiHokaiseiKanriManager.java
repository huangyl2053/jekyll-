/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.dbt7202kaigoninteihokaiseikanri.DbT7202KaigoNinteiHokaiseiKanriBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7202KaigoNinteiHokaiseiKanriDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護認定法改正管理するクラスです。
 *
 * @reamsid_L DBD_1510-010 liuyl
 */
public class KaigoNinteiHokaiseiKanriManager {

    private DbT7202KaigoNinteiHokaiseiKanriDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoNinteiHokaiseiKanriManager() {
        this.dac = InstanceProvider.create(DbT7202KaigoNinteiHokaiseiKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dac DbT7202KaigoNinteiHokaiseiKanriDac
     */
    KaigoNinteiHokaiseiKanriManager(DbT7202KaigoNinteiHokaiseiKanriDac dac) {
        this.dac = dac;
    }

    /**
     * すべての介護認定法改正管理情報取得
     *
     * @return すべての介護認定法改正管理情報
     */
    public List<DbT7202KaigoNinteiHokaiseiKanriBusiness> get介護認定法改正管理情報() {
        List<DbT7202KaigoNinteiHokaiseiKanriBusiness> businessList = new ArrayList<>();
        List<DbT7202KaigoNinteiHokaiseiKanriEntity> 介護認定法改正管理情報 = dac.get介護認定法改正管理情報();
        if (介護認定法改正管理情報 != null && !介護認定法改正管理情報.isEmpty()) {
            for (DbT7202KaigoNinteiHokaiseiKanriEntity entity : 介護認定法改正管理情報) {
                DbT7202KaigoNinteiHokaiseiKanriBusiness business = new DbT7202KaigoNinteiHokaiseiKanriBusiness(entity);
                businessList.add(business);
            }
        }
        return businessList;
    }
}
