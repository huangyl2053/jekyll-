/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容31
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser31 {

    /**
     * コード:1 名称:できる 略称:できる
     */
    できる("1", "できる"),
    /**
     * コード:2 名称:見守り（介護側の指示を含む） 略称:見守り_介護側の指示を含む
     */
    見守り_介護側の指示を含む("2", "見守り（介護側の指示を含む）"),
    /**
     * コード:3 名称:できない 略称:できない
     */
    できない("3", "できない");
    private final RString code;
    private final RString fullName;

    private ChosaAnser31(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容31のコードを返します。
     *
     * @return 認定調査項目内容31のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容31の名称を返します。
     *
     * @return 認定調査項目内容31の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容31のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容31のコード
     * @return {@code code} に対応する認定調査項目内容31
     */
    public static ChosaAnser31 toValue(RString code) {
        for (ChosaAnser31 anser31 : ChosaAnser31.values()) {
            if (anser31.code.equals(code)) {
                return anser31;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容31"));
    }
}
