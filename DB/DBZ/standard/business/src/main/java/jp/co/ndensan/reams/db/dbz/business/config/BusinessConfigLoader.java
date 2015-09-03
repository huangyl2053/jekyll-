/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.util.config.IBusinessConfig;

/**
 * 業務Configを取得します。
 *
 * @author N3327 三浦 凌
 */
public final class BusinessConfigLoader implements IBusinessConfigLoader {

    private final IBusinessConfig urBusinessConfig;

    /**
     * インスタンスを生成します。
     */
    public BusinessConfigLoader() {
        this.urBusinessConfig = BusinessConfigFactory.createInstance();
    }

    /**
     * テスト用のコンストラクタです。
     */
    BusinessConfigLoader(IBusinessConfig urBusinessConfig) {
        this.urBusinessConfig = urBusinessConfig;
    }

    @Override
    public IConfigValue load(Enum key) {
        return new _ConfigValue(Optional.ofNullable(urBusinessConfig.get(key)));
    }
}
