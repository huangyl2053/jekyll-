/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容06
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser06 {

    /**
     * コード:1 名称:介助されていない 略称:介助されていない
     */
    介助されていない("1", "介助されていない"),
    /**
     * コード:2 名称:一部介助 略称:一部介助
     */
    一部介助("2", "一部介助"),
    /**
     * コード:4 名称:全介助 略称:全介助
     */
    全介助("3", "全介助"),
    /**
     * コード:4 名称:行っていない 略称:行っていない
     */
    行っていない("4", "行っていない");
    private final RString code;
    private final RString fullName;

    private ChosaAnser06(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容06のコードを返します。
     *
     * @return 認定調査項目内容06のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容06の名称を返します。
     *
     * @return 認定調査項目内容06の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容06のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容06のコード
     * @return {@code code} に対応する認定調査項目内容06
     */
    public static ChosaAnser06 toValue(RString code) {
        for (ChosaAnser06 anser06 : ChosaAnser06.values()) {
            if (anser06.code.equals(code)) {
                return anser06;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容06"));
    }
}
