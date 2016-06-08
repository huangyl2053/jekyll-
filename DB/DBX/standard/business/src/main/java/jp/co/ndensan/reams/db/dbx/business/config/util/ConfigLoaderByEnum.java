/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.util;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * キーがEnumで管理されるコンフィグを扱います。
 *
 * @param <E> コンフィグのキーを管理するEnumの型
 */
public abstract class ConfigLoaderByEnum<E extends Enum<E>> extends ConfigLoader<E> {

    /**
     * コンフィグのキーを管理するEnumの型、有効日、サブ業務コードを指定して、
     * 該当のコンフィグを一括取得して管理します。
     *
     * @param clazz コンフィグのキ―を管理するEnumの型
     * @param rDate 有効日
     * @param subGyomuCode サブ業務コード
     */
    protected ConfigLoaderByEnum(Class<E> clazz, RDate rDate, SubGyomuCode subGyomuCode) {
        super(loadConfigsByEnum(clazz, rDate, subGyomuCode));
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
    private static <E extends Enum<E>> Map<E, RString> loadConfigsByEnum(Class<E> configKeys, RDate rDate, SubGyomuCode subGyomuCode) {
        Map<E, RString> map = new EnumMap<>(configKeys);
        for (E key : configKeys.getEnumConstants()) {
            map.put(key, BusinessConfig.get(key, rDate, subGyomuCode));
        }
        return map;
    }
}
