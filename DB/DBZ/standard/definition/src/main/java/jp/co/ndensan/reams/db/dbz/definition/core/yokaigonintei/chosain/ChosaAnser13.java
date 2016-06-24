/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容13
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser13 {

    /**
     * コード:1 名称:週1回以上 略称:週1回以上
     */
    週1回以上("1", "週1回以上"),
    /**
     * コード:2 名称:月1回以上 略称:月1回以上
     */
    月1回以上("2", "月1回以上"),
    /**
     * コード:3 名称:月1回未満 略称:月1回未満
     */
    月1回未満("3", "月1回未満");
    private final RString code;
    private final RString fullName;

    private ChosaAnser13(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容13のコードを返します。
     *
     * @return 認定調査項目内容13のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容13の名称を返します。
     *
     * @return 認定調査項目内容13の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容13のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容13のコード
     * @return {@code code} に対応する認定調査項目内容13
     */
    public static ChosaAnser13 toValue(RString code) {
        for (ChosaAnser13 anser13 : ChosaAnser13.values()) {
            if (anser13.code.equals(code)) {
                return anser13;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容13"));
    }
}
