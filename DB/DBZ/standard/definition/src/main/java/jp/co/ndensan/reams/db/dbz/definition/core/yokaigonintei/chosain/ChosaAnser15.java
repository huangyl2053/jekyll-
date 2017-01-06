/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容15
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser15 {

    /**
     * コード:1 名称:できる 略称:できる
     */
    できる("1", "できる", "できる"),
    /**
     * コード:2 名称:できない 略称:できない
     */
    できない("2", "できない", "できない");
    private final RString code;
    private final RString fullName;
    private final RString ryakusho;

    private ChosaAnser15(String code, String fullname, String ryakusho) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * 認定調査項目内容15のコードを返します。
     *
     * @return 認定調査項目内容15のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容15の名称を返します。
     *
     * @return 認定調査項目内容15の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容15の略称を返します。
     *
     * @return 認定調査項目内容15の略称
     */
    public RString get略称() {
        return ryakusho;
    }

    /**
     * 認定調査項目内容15のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容15のコード
     * @return {@code code} に対応する認定調査項目内容15
     */
    public static ChosaAnser15 toValue(RString code) {
        for (ChosaAnser15 anser15 : ChosaAnser15.values()) {
            if (anser15.code.equals(code)) {
                return anser15;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容15"));
    }
}
