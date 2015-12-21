/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.util;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * コンフィグに関連する機能を提供します。
 */
public final class Configs {

    private Configs() {
    }

    /**
     * 指定のEnumで管理される業務コンフィグを、指定の有効日・サブ業務コードより取得してmapで返却します。
     * mapのキーは指定のEnum、値がコンフィグの値になります。
     *
     * @param <E> Enumの型
     * @param configKeys Enumのclass
     * @param rDate 有効日
     * @param subGyomuCode サブ業務コード
     * @return Map … キーはEnum、値はキーに対応するコンフィグの設定値
     */
    public static <E extends Enum<E>> Map<E, RString> loadConfigsByEnum(Class<E> configKeys, RDate rDate, SubGyomuCode subGyomuCode) {
        Map<E, RString> map = new EnumMap<>(configKeys);
        for (E key : configKeys.getEnumConstants()) {
            map.put(key, BusinessConfig.get(key, rDate, subGyomuCode));
        }
        return map;
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
    public static <T extends Enum<T> & IConfigKeys> Map<T, RString> loadConfigsByConfigKeys(Class<T> configKeys, RDate rDate) {
        Map<T, RString> map = new HashMap<>();
        for (T key : configKeys.getEnumConstants()) {
            map.put(key, BusinessConfig.get(key, rDate, key.subGyomuCode()));
        }
        return map;
    }
}
