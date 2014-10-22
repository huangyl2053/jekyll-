/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ValueObjectの情報です。
 *
 * @author N3327 三浦 凌
 */
final class ValueObjectInfo {

    private final RString theName;
    private final Unit theUnit;

    /**
     * ValueObjectの名前と、1文字を数える単位から、インスタンスを生成します。
     *
     * @param name 名前
     * @param unit 単位
     */
    ValueObjectInfo(RString name, Unit unit) {
        this.theName = name;
        this.theUnit = unit;
    }

    /**
     * 名前を返します。
     *
     * @return 名前
     */
    RString name() {
        return this.theName;
    }

    /**
     * 単位を返します。
     *
     * @return 単位
     */
    Unit unit() {
        return this.theUnit;
    }
}
