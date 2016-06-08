/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務Configから取得した値であること表します。
 *
 * @author N3327 三浦 凌
 * @deprecated 不要のため削除する。
 */
@Deprecated
public interface IConfigValue {

    /**
     * 任意の型へ変換して取得します。
     *
     * @param <T> 任意の型
     * @param converter RStringを別の型へ変換するfunction
     * @return 任意の型へ変換された業務Configの値
     */
    <T> T as(IFunction<RString, T> converter);

    /**
     * 業務Configの値をRString型で取得します。
     *
     * @return 業務Configの値
     */
    RString asRString();
}
