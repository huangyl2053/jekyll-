/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容20
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser20 {

    /**
     * コード:1 名称:自立 略称:自立
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:見守り等 略称:見守り等
     */
    見守り等("2", "見守り等"),
    /**
     * コード:3 名称:一部介助 略称:一部介助
     */
    一部介助("3", "一部介助"),
    /**
     * コード:4 名称:全介助 略称:全介助
     */
    全介助("4", "全介助");
    private final RString code;
    private final RString fullName;

    private ChosaAnser20(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容20のコードを返します。
     *
     * @return 認定調査項目内容20のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容20の名称を返します。
     *
     * @return 認定調査項目内容20の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容20のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容20のコード
     * @return {@code code} に対応する認定調査項目内容20
     */
    public static ChosaAnser20 toValue(RString code) {
        for (ChosaAnser20 anser20 : ChosaAnser20.values()) {
            if (anser20.code.equals(code)) {
                return anser20;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容20"));
    }
}
