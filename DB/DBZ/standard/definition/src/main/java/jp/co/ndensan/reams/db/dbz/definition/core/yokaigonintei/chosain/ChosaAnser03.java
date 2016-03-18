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
 * 認定調査項目内容03
 */
public enum ChosaAnser03 {

    /**
     * コード:1 名称:できる 略称:できる
     */
    できる("1", "できる"),
    /**
     * コード:2 名称:自分で支えれば可 略称:自分で支えれば可
     */
    自分で支えれば可("2", "自分で支えれば可"),
    /**
     * コード:4 名称:支えが必要 略称:支えが必要
     */
    支えが必要("3", "支えが必要"),
    /**
     * コード:4 名称:できない 略称:できない
     */
    できない("4", "できない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser03(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容03のコードを返します。
     *
     * @return 認定調査項目内容03のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容03の名称を返します。
     *
     * @return 認定調査項目内容03の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容03のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容03のコード
     * @return {@code code} に対応する認定調査項目内容03
     */
    public static ChosaAnser03 toValue(Code code) {
        for (ChosaAnser03 anser01 : ChosaAnser03.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容03"));
    }
}
