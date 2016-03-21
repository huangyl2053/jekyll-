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
 * 認定調査項目内容32
 */
public enum ChosaAnser32 {

    /**
     * コード:1 名称:自立 略称:自立
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:間接的援助のみ 略称:間接的援助のみ
     */
    間接的援助のみ("2", "間接的援助のみ"),
    /**
     * コード:3 名称:直接的援助 略称:直接的援助
     */
    直接的援助("3", "直接的援助"),
    /**
     * コード:4 名称:全介助 略称:全介助
     */
    全介助("4", "全介助");
    private final Code code;
    private final RString fullName;

    private ChosaAnser32(String code, String fullname) {
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
    public static ChosaAnser32 toValue(Code code) {
        for (ChosaAnser32 anser01 : ChosaAnser32.values()) {
            if (anser01.code.equals(code)) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容25"));
    }
}
