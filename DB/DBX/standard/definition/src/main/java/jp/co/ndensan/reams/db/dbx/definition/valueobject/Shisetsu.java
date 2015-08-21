/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.valueobject;

import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappableValue;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設種類を表すドメインクラスです。
 *
 * @author N3317 塚田 萌
 * @jpName 施設種類
 * @bizDomain 介護
 * @category 施設種類
 * @subCategory
 * @mainClass
 * @reference
 */
public class Shisetsu implements IDbColumnMappableValue<ShisetsuType> {

    private final ShisetsuType type;

    /**
     * コンストラクタです。
     *
     * @param code コード
     */
    public Shisetsu(RString code) {
        this.type = ShisetsuType.toValue(code);
    }

    @Override
    public RString getColumnValue() {
        return type.code();
    }

    @Override
    public ShisetsuType value() {
        return this.type;
    }

    @Override
    public String toString() {
        return type == null ? "" : type.code().toString();
    }
}
