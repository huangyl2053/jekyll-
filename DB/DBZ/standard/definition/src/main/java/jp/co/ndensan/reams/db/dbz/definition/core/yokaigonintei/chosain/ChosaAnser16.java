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
 * 認定調査項目内容16
 */
public enum ChosaAnser16 {

    /**
     * コード:1 名称:ない 略称:ない
     */
    ない("1", "ない"),
    /**
     * コード:2 名称:ときどきある 略称:ときどきある
     */
    ときどきある("2", "ときどきある"),
    /**
     * コード:3 名称:ある 略称:ある
     */
    ある("3", "ある");
    private final Code code;
    private final RString fullName;

    private ChosaAnser16(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容16のコードを返します。
     *
     * @return 認定調査項目内容16のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容16の名称を返します。
     *
     * @return 認定調査項目内容16の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容16のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容16のコード
     * @return {@code code} に対応する認定調査項目内容16
     */
    public static ChosaAnser16 toValue(Code code) {
        for (ChosaAnser16 anser01 : ChosaAnser16.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容16"));
    }
}
