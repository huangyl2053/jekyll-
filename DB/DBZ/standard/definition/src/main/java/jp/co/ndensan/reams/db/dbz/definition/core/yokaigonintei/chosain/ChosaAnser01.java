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
 * 認定調査項目内容01
 */
public enum ChosaAnser01 {

    /**
     * コード:1 名称:なし 略称:なし
     */
    なし("1", "なし"),
    /**
     * コード:2 名称:あり 略称:あり
     */
    あり("2", "あり");
    private final Code code;
    private final RString fullName;

    private ChosaAnser01(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容01のコードを返します。
     *
     * @return 認定調査項目内容01のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容01の名称を返します。
     *
     * @return 認定調査項目内容01の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容01のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容01のコード
     * @return {@code code} に対応する認定調査項目内容01
     */
    public static ChosaAnser01 toValue(Code code) {
        for (ChosaAnser01 anser01 : ChosaAnser01.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容01"));
    }
}
