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
 * 認定調査項目内容17
 */
public enum ChosaAnser17 {

    /**
     * コード:1 名称:できる（特別な場合でもできる） 略称:できる_特別な場合でもできる
     */
    できる_特別な場合でもできる("1", "できる（特別な場合でもできる）"),
    /**
     * コード:2 名称:特別な場合を除いてできる 略称:特別な場合を除いてできる
     */
    特別な場合を除いてできる("2", "特別な場合を除いてできる"),
    /**
     * コード:3 名称:日常的に困難 略称:日常的に困難
     */
    日常的に困難("3", "日常的に困難"),
    /**
     * コード:4 名称:できない 略称:できない
     */
    できない("4", "できない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser17(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容17のコードを返します。
     *
     * @return 認定調査項目内容17のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容17の名称を返します。
     *
     * @return 認定調査項目内容17の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容17のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容17のコード
     * @return {@code code} に対応する認定調査項目内容17
     */
    public static ChosaAnser17 toValue(Code code) {
        for (ChosaAnser17 anser01 : ChosaAnser17.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容17"));
    }
}
