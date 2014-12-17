/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時に差し替える。
public enum ChoshuHohoKibetsu {

    特別徴収("1"),
    普通徴収("2");
    private final RString code;

    private ChoshuHohoKibetsu(String code) {
        this.code = new RString(code);
    }

    public RString getCode() {
        return code;
    }

    public static ChoshuHohoKibetsu toValue(RString code) {
        for (ChoshuHohoKibetsu data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("徴収方法"));
    }
}
