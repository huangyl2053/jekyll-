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
 * 認定調査項目内容21
 */
public enum ChosaAnser21 {

    /**
     * コード:1 名称:自立 略称:自立
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:一部介助 略称:一部介助
     */
    一部介助("2", "一部介助"),
    /**
     * コード:3 名称:全介助 略称:全介助
     */
    全介助("3", "全介助"),
    /**
     * コード:4 名称:行っていない 略称:行っていない
     */
    行っていない("4", "行っていない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser21(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容21のコードを返します。
     *
     * @return 認定調査項目内容21のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容21の名称を返します。
     *
     * @return 認定調査項目内容21の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容21のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容21のコード
     * @return {@code code} に対応する認定調査項目内容21
     */
    public static ChosaAnser21 toValue(Code code) {
        for (ChosaAnser21 anser01 : ChosaAnser21.values()) {
            if (anser01.code.equals(code)) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容21"));
    }
}
