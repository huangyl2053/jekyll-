/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容22
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser22 {

    /**
     * コード:1 名称:自立 略称:自立
     */
    自立("1", "自立", "自立"),
    /**
     * コード:2 名称:一部介助 略称:一部介助
     */
    一部介助("2", "一部介助", "一部介助"),
    /**
     * コード:3 名称:全介助 略称:全介助
     */
    全介助("3", "全介助", "全介助");
    private final RString code;
    private final RString fullName;
    private final RString ryakusho;

    private ChosaAnser22(String code, String fullname, String ryakusho) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * 認定調査項目内容22のコードを返します。
     *
     * @return 認定調査項目内容22のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容22の名称を返します。
     *
     * @return 認定調査項目内容22の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容22の略称を返します。
     *
     * @return 認定調査項目内容22の略称
     */
    public RString get略称() {
        return ryakusho;
    }

    /**
     * 認定調査項目内容22のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容22のコード
     * @return {@code code} に対応する認定調査項目内容22
     */
    public static ChosaAnser22 toValue(RString code) {
        for (ChosaAnser22 anser22 : ChosaAnser22.values()) {
            if (anser22.code.equals(code)) {
                return anser22;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容22"));
    }
}
