/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.util;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link IConfigKeys}を実装したEnumによりキーが管理されるコンフィグを扱います。
 *
 * @param <T> IConfigKeysを実装したEnumの型(コンフィグのキーを管理する物)
 */
public abstract class ConfigLoaderByConfigKeys<T extends Enum<T> & IConfigKeys> extends ConfigLoader<T> {

    /**
     * コンフィグのキーを管理するEnumの型、有効日を指定して、
     * 該当のコンフィグを一括取得して管理します。
     *
     * @param clazz コンフィグのキ―を管理するEnumの型
     * @param rDate 有効日
     */
    protected ConfigLoaderByConfigKeys(Class<T> clazz, RDate rDate) {
        super(loadConfigsByConfigKeys(clazz, rDate));
    }

    /**
     * 指定のEnum({@link IConfigKeys}を実装する)で管理される業務コンフィグを、指定の有効日より取得してmapで返却します。
     * mapのキーは指定のEnum、値がコンフィグの値になります。
     *
     * @param <T> Enumの型
     * @param configKeys Enumのclass
     * @param rDate 有効日
     * @return Map … キーはEnum、値はキーに対応するコンフィグの設定値
     */
    private static <T extends Enum<T> & IConfigKeys> Map<T, RString> loadConfigsByConfigKeys(Class<T> configKeys, RDate rDate) {
        Map<T, RString> map = new HashMap<>();
        for (T key : configKeys.getEnumConstants()) {
            map.put(key, BusinessConfig.get(key, rDate, key.subGyomuCode()));
        }
        return map;
    }
}
