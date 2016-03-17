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
 * 認定調査項目内容14
 */
public enum ChosaAnser14 {

    /**
     * コード:1 名称:調査対象者が意思を他者に伝達できる 略称:調査対象者が意思を他者に伝達できる
     */
    調査対象者が意思を他者に伝達できる("1", "調査対象者が意思を他者に伝達できる"),
    /**
     * コード:2 名称:ときどき伝達できる 略称:ときどき伝達できる
     */
    ときどき伝達できる("2", "ときどき伝達できる"),
    /**
     * コード:3 名称:ほとんど伝達できない 略称:ほとんど伝達できない
     */
    ほとんど伝達できない("3", "ほとんど伝達できない"),
    /**
     * コード:4 名称:できない 略称:できない
     */
    できない("4", "できない");
    private final Code code;
    private final RString fullName;

    private ChosaAnser14(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査項目内容14のコードを返します。
     *
     * @return 認定調査項目内容14のコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * 認定調査項目内容14の名称を返します。
     *
     * @return 認定調査項目内容14の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容14のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容14のコード
     * @return {@code code} に対応する認定調査項目内容14
     */
    public static ChosaAnser14 toValue(Code code) {
        for (ChosaAnser14 anser01 : ChosaAnser14.values()) {
            if (anser01.code == code) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容14"));
    }
}
