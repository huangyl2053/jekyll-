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
 * 認定調査項目内容23
 */
public enum ChosaAnser23 {

    /**
     * コード:1 名称:介護者の指示が通じる 略称:介護者の指示が通じる
     */
    介護者の指示が通じる("1", "介護者の指示が通じる"),
    /**
     * コード:2 名称:介護者の指示がときどき通じる 略称:介護者の指示がときどき通じる
     */
    介護者の指示がときどき通じる("2", "介護者の指示がときどき通じる"),
    /**
     * コード:3 名称:介護者の指示が通じない 略称:介護者の指示が通じない
     */
    介護者の指示が通じない("3", "介護者の指示が通じない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser23(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容23のコードを返します。
     *
     * @return 認定調査項目内容23のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容23の名称を返します。
     *
     * @return 認定調査項目内容23の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容23のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容23のコード
     * @return {@code code} に対応する認定調査項目内容23
     */
    public static ChosaAnser23 toValue(Code code) {
        for (ChosaAnser23 anser01 : ChosaAnser23.values()) {
            if (anser01.code.equals(code)) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容23"));
    }
}
