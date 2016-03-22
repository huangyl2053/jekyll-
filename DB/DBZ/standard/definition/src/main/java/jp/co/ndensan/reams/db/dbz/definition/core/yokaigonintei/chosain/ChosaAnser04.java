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
 * 認定調査項目内容04
 */
public enum ChosaAnser04 {

    /**
     * コード:1 名称:支えなしでできる 略称:支えなしでできる
     */
    支えなしでできる("1", "支えなしでできる"),
    /**
     * コード:2 名称:何か支えがあればできる 略称:何か支えがあればできる
     */
    何か支えがあればできる("2", "何か支えがあればできる"),
    /**
     * コード:4 名称:できない 略称:できない
     */
    できない("3", "できない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser04(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容04のコードを返します。
     *
     * @return 認定調査項目内容04のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容04の名称を返します。
     *
     * @return 認定調査項目内容04の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容04のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容04のコード
     * @return {@code code} に対応する認定調査項目内容04
     */
    public static ChosaAnser04 toValue(Code code) {
        for (ChosaAnser04 anser01 : ChosaAnser04.values()) {
            if (anser01.code.equals(code)) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容04"));
    }
}
