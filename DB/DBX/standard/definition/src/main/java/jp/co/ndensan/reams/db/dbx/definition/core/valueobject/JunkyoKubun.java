/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.valueobject;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JunkyoKubunType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappableValue;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 準拠区分を表すドメインクラスです。
 *
 * @author N3317 塚田 萌
 * @jpName 準拠区分
 * @bizDomain 介護
 * @category 介護事業者指定サービス
 * @subCategory
 * @mainClass
 * @reference
 */
public class JunkyoKubun implements IDbColumnMappableValue<JunkyoKubunType> {

    private final JunkyoKubunType type;

    /**
     * コンストラクタです。
     *
     * @param code コード
     */
    public JunkyoKubun(RString code) {
        this.type = JunkyoKubunType.toValue(code);
    }

    @Override
    public RString getColumnValue() {
        return type.code();
    }

    @Override
    public JunkyoKubunType value() {
        return this.type;
    }

    @Override
    public String toString() {
        return type == null ? "" : type.code().toString();
    }
}
