/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容02
 *
 * @reamsid_L DBZ-9999-023 wangchao
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
    private final RString code;
    private final RString fullName;

    private ChosaAnser02(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容02のコードを返します。
     *
     * @return 認定調査項目内容02のコード
     */
    public RString getコード() {
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
    public static ChosaAnser02 toValue(RString code) {
        for (ChosaAnser02 anser02 : ChosaAnser02.values()) {
            if (anser02.code.equals(code)) {
                return anser02;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容02"));
    }
}
