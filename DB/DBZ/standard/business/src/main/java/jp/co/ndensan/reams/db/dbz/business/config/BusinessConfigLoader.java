/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 業務Configを取得します。
 *
 * @author N3327 三浦 凌
 */
@Deprecated
public final class BusinessConfigLoader implements IBusinessConfigLoader {

    private final BusinessConfig urBusinessConfig;

    /**
     * テスト用のコンストラクタです。
     */
    BusinessConfigLoader(BusinessConfig urBusinessConfig) {
        this.urBusinessConfig = urBusinessConfig;
    }

    @Override
    public IConfigValue load(Enum key) {
        return new _ConfigValue(Optional.ofNullable(urBusinessConfig.get(key)));
    }
}
