/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ValueObjectの情報です。
 *
 * @author N3327 三浦 凌
 */
public interface IValueObjectInfo {

    /**
     * 表示名を返します。
     *
     * @return 名前
     */
    RString getDisplayName();

    /**
     * 単位を返します。
     *
     * @return 単位
     */
    Unit getUnit();
}
