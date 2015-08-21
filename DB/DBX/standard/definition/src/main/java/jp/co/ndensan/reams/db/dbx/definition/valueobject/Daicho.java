/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.valueobject;

import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappableValue;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 台帳種別を表すドメインクラスです。
 *
 * @author N3317 塚田 萌
 * @jpName 台帳種別
 * @bizDomain 介護
 * @category 台帳種別
 * @subCategory
 * @mainClass
 * @reference
 */
public class Daicho implements IDbColumnMappableValue<DaichoType> {

    private final DaichoType type;

    /**
     * コンストラクタです。
     *
     * @param code コード
     */
    public Daicho(RString code) {
        this.type = DaichoType.toValue(code);
    }

    @Override
    public RString getColumnValue() {
        return type.code();
    }

    @Override
    public DaichoType value() {
        return this.type;
    }

    @Override
    public String toString() {
        return type == null ? "" : type.code().toString();
    }
}
