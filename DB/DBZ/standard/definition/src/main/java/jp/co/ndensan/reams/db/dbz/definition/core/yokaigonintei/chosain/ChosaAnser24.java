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
 * 認定調査項目内容24
 */
public enum ChosaAnser24 {

    /**
     * コード:1 名称:良く動いている 略称:良く動いている
     */
    良く動いている("1", "良く動いている"),
    /**
     * コード:2 名称:座っていることが多い 略称:座っていることが多い
     */
    座っていることが多い("2", "座っていることが多い"),
    /**
     * コード:3 名称:横になっていることが多い 略称:横になっていることが多い
     */
    横になっていることが多い("3", "横になっていることが多い");
    private final Code code;
    private final RString fullName;

    private ChosaAnser24(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容24のコードを返します。
     *
     * @return 認定調査項目内容24のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容24の名称を返します。
     *
     * @return 認定調査項目内容24の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容24のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容24のコード
     * @return {@code code} に対応する認定調査項目内容24
     */
    public static ChosaAnser24 toValue(Code code) {
        for (ChosaAnser24 anser01 : ChosaAnser24.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容24"));
    }
}
