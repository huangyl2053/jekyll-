/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分の列挙型です。（厚労省認定ソフト2009版）
 *
 * @author N8156 宮本 康
 * @jpName
 * @bizDomain
 * @category
 * @subCategory
 * @mainClass
 * @reference
 */
public enum YokaigoJotaiKubun09A implements IYokaigoJotaiKubun {

    /**
     * 要介護状態区分が「非該当」であることを表します。<br />
     * コード：01
     */
    非該当("01"),
    /**
     * 要介護状態区分が「要支援１」であることを表します。<br />
     * コード：12
     */
    要支援１("12"),
    /**
     * 要介護状態区分が「要支援２」であることを表します。<br />
     * コード：13
     */
    要支援２("13"),
    /**
     * 要介護状態区分が「要介護１」であることを表します。<br />
     * コード：21
     */
    要介護１("21"),
    /**
     * 要介護状態区分が「要介護２」であることを表します。<br />
     * コード：22
     */
    要介護２("22"),
    /**
     * 要介護状態区分が「要介護３」であることを表します。<br />
     * コード：23
     */
    要介護３("23"),
    /**
     * 要介護状態区分が「要介護４」であることを表します。<br />
     * コード：24
     */
    要介護４("24"),
    /**
     * 要介護状態区分が「要介護５」であることを表します。<br />
     * コード：25
     */
    要介護５("25"),
    /**
     * 要介護状態区分が「再調査」であることを表します。<br />
     * コード：31
     */
    再調査("31"),
    /**
     * 要介護状態区分が「取消」であることを表します。<br />
     * コード：88
     */
    取消("88"),
    /**
     * 要介護状態区分が「なし」であることを表します。<br />
     * コード：99
     */
    なし("99");

    private final RString code;
    private final RString name;

    private YokaigoJotaiKubun09A(String code) {
        this.code = new RString(code);
        this.name = new RString(this.name());
    }

    @Override
    public RString getCode() {
        return code;
    }

    @Override
    public RString getName() {
        return name;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     * @throws IllegalArgumentException 変換不可の場合
     */
    public static YokaigoJotaiKubun09A toValue(RString code) throws IllegalArgumentException {
        for (YokaigoJotaiKubun09A data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分"));
    }
}
