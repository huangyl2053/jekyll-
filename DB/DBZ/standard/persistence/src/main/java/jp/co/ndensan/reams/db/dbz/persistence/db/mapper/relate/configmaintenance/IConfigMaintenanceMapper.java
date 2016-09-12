/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.configmaintenance;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.configmaintenance.ConfigMaintenanceRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム管理汎用クラスです。
 *
 * @reamsid_L DBU-3991-010 wanghui
 */
public interface IConfigMaintenanceMapper {

    /**
     * システム管理汎用ｓのデータを取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @return List<ConfigMaintenanceRelateEntity>
     */
    List<ConfigMaintenanceRelateEntity> getコンフィグ制御汎用メンテナンス(RString subGyomuCode);

}
