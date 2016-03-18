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
 * 認定調査項目内容02
 */
public enum ChosaAnser02 {

    /**
     * コード:1 名称:つかまらないでできる 略称:つかまらないでできる
     */
    つかまらないでできる("1", "つかまらないでできる"),
    /**
     * コード:2 名称:何かにつかまればできる 略称:何かにつかまればできる
     */
    何かにつかまればできる("2", "何かにつかまればできる"),
    /**
     * コード:3 名称:できない 略称:できない
     */
    できない("3", "できない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser02(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容02のコードを返します。
     *
     * @return 認定調査項目内容02のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容02の名称を返します。
     *
     * @return 認定調査項目内容02の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容02のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容02のコード
     * @return {@code code} に対応する認定調査項目内容02
     */
    public static ChosaAnser02 toValue(Code code) {
        for (ChosaAnser02 anser01 : ChosaAnser02.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容02"));
    }
}
