/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.configmaintenance;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.configmaintenance.ConfigMaintenance;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.configmaintenance.ConfigMaintenanceRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.configmaintenance.IConfigMaintenanceMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * システム管理汎用クラスです。
 *
 * @reamsid_L DBU-3991-010 wanghui
 */
public class ConfigMaintenanceFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ConfigMaintenanceFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    ConfigMaintenanceFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ConfigMaintenanceFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ConfigMaintenanceFinder}のインスタンス
     */
    public static ConfigMaintenanceFinder createInstance() {
        return InstanceProvider.create(ConfigMaintenanceFinder.class);
    }

    /**
     * 資格帳票管理のデータを取得します。
     *
     * @param subGyomuCode RString
     * @return SearchResult<ConfigMaintenance>
     */
    public SearchResult<ConfigMaintenance> getSyozokuKikan(RString subGyomuCode) {
        List<ConfigMaintenance> ninteichosaItakusakiJohoList = new ArrayList<>();
        IConfigMaintenanceMapper mapper = mapperProvider.create(IConfigMaintenanceMapper.class);
        List<ConfigMaintenanceRelateEntity> syozokuKikanList = mapper.getコンフィグ制御汎用メンテナンス(subGyomuCode);
        for (ConfigMaintenanceRelateEntity syozokuKikan : syozokuKikanList) {
            ninteichosaItakusakiJohoList.add(new ConfigMaintenance(syozokuKikan));
        }
        return SearchResult.of(ninteichosaItakusakiJohoList, 0, false);
    }
}
