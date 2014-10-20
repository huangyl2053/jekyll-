/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.model.util.optional.DbOptional;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;

/**
 * 業務Configを取得します。
 *
 * @author N3327 三浦 凌
 */
public final class BusinessConfigLoader implements IBusinessConfigLoader {

    private final IUrBusinessConfig urBusinessConfig;

    /**
     * インスタンスを生成します。
     */
    public BusinessConfigLoader() {
        this.urBusinessConfig = UrBusinessConfigFactory.createInstance();
    }

    /**
     * テスト用のコンストラクタです。
     */
    BusinessConfigLoader(IUrBusinessConfig urBusinessConfig) {
        this.urBusinessConfig = urBusinessConfig;
    }

    @Override
    public IConfigValue load(Enum key) {
        return new _ConfigValue(DbOptional.ofNullable(urBusinessConfig.get(key)));
    }
}
