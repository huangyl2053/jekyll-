/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容34
 */
public enum ChosaAnser34 {

    /**
     * コード:1 名称:自立 略称:自立
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:見守り（介護側の指示を含む） 略称:見守り_介護側の指示を含む
     */
    見守り_介護側の指示を含む("2", "見守り（介護側の指示を含む）"),
    /**
     * コード:3 名称:一部介助 略称:一部介助
     */
    一部介助("3", "一部介助"),
    /**
     * コード:4 名称:全介助 略称:全介助
     */
    全介助("4", "全介助");
    private final Code code;
    private final RString fullName;

    private ChosaAnser34(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容25のコードを返します。
     *
     * @return 認定調査項目内容25のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容25の名称を返します。
     *
     * @return 認定調査項目内容25の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容25のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容25のコード
     * @return {@code code} に対応する認定調査項目内容25
     */
    public static ChosaAnser34 toValue(Code code) {
        for (ChosaAnser34 anser01 : ChosaAnser34.values()) {
            if (anser01.code.equals(code)) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容25"));
    }
}
