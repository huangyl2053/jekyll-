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
 * 認定調査項目内容11
 */
public enum ChosaAnser11 {

    /**
     * コード:1 名称:できる 略称:できる
     */
    できる("1", "できる"),
    /**
     * コード:2 名称:見守り等 略称:見守り等
     */
    見守り等("2", "見守り等"),
    /**
     * コード:3 名称:できない 略称できない一部介助
     */
    できない("3", "できない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser11(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容11のコードを返します。
     *
     * @return 認定調査項目内容11のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容11の名称を返します。
     *
     * @return 認定調査項目内容11の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容11のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容11のコード
     * @return {@code code} に対応する認定調査項目内容11
     */
    public static ChosaAnser11 toValue(Code code) {
        for (ChosaAnser11 anser01 : ChosaAnser11.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容11"));
    }
}
