/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容33
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser33 {

    /**
     * コード:1 名称:自立 略称:自立
     */
    できる("1", "できる"),
    /**
     * コード:2 名称:見守り（介護側の指示を含む） 略称:見守り_介護側の指示を含む
     */
    見守り_介護側の指示を含む("2", "見守り（介護側の指示を含む）"),
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

    private ChosaAnser33(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容33のコードを返します。
     *
     * @return 認定調査項目内容33のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容33の名称を返します。
     *
     * @return 認定調査項目内容33の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容33のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容33のコード
     * @return {@code code} に対応する認定調査項目内容33
     */
    public static ChosaAnser33 toValue(RString code) {
        for (ChosaAnser33 anser33 : ChosaAnser33.values()) {
            if (anser33.code.equals(code)) {
                return anser33;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容33"));
    }
}
