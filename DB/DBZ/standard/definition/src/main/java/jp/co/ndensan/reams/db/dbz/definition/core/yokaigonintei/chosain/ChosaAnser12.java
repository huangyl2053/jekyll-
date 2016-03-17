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
 * 認定調査項目内容12
 */
public enum ChosaAnser12 {

    /**
     * コード:1 名称:介助されていない 略称:介助されていない
     */
    介助されていない("1", "介助されていない"),
    /**
     * コード:2 名称:一部介助 略称:一部介助
     */
    一部介助("2", "一部介助"),
    /**
     * コード:3 名称:全介助 略称:全介助
     */
    全介助("3", "全介助");
    private final Code code;
    private final RString fullName;

    private ChosaAnser12(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容12のコードを返します。
     *
     * @return 認定調査項目内容12のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容12の名称を返します。
     *
     * @return 認定調査項目内容12の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容12のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容12のコード
     * @return {@code code} に対応する認定調査項目内容12
     */
    public static ChosaAnser12 toValue(Code code) {
        for (ChosaAnser12 anser01 : ChosaAnser12.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容12"));
    }
}
