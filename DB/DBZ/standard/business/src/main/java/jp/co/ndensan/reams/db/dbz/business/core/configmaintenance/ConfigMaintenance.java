/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.configmaintenance;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.configmaintenance.ConfigMaintenanceRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム管理汎用クラスです。
 *
 * @reamsid_L DBU-3991-010 wanghui
 */
public class ConfigMaintenance {

    private final ConfigMaintenanceRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity システム管理汎用Entity
     */
    public ConfigMaintenance(ConfigMaintenanceRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * ConfigNameを取得します。
     *
     * @return ConfigName
     */
    public RString getConfigName() {
        return entity.getConfigName();
    }

    /**
     * ConfigValueを取得します。
     *
     * @return ConfigValue
     */
    public RString getConfigValue() {
        return entity.getConfigValue();
    }

    /**
     * ConfigDescを取得します。
     *
     * @return ConfigDesc
     */
    public RString getConfigDesc() {
        return entity.getConfigDesc();
    }
}
