/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 徴収方法（期別）の列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ChoshuHohoKibetsu {

    /**
     * 徴収方法が「特別徴収」であることを表します。 <br />
     * コード：1
     */
    特別徴収("1"),
    /**
     * 徴収方法が「普通徴収」であることを表します。 <br />
     * コード：2
     */
    普通徴収("2");
    private final RString code;

    private ChoshuHohoKibetsu(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return code;
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static ChoshuHohoKibetsu toValue(RString code) {
        for (ChoshuHohoKibetsu data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("徴収方法"));
    }
}
