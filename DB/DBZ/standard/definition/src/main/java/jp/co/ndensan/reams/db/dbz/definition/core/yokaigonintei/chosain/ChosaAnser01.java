/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目内容01
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaAnser01 {

    /**
     * コード:1 名称:ない 略称:ない
     */
    ない("1", "ない", "ない"),
    /**
     * コード:2 名称:ある 略称:ある
     */
    ある("2", "ある", "ある");
    private final RString code;
    private final RString fullName;
    private final RString ryakusho;

    private ChosaAnser01(String code, String fullname, String ryakusho) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * 認定調査項目内容01のコードを返します。
     *
     * @return 認定調査項目内容01のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査項目内容01の名称を返します。
     *
     * @return 認定調査項目内容01の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査項目内容01の略称を返します。
     *
     * @return 認定調査項目内容01の略称
     */
    public RString get略称() {
        return ryakusho;
    }

    /**
     * 認定調査項目内容01のコードと一致する内容を探します。
     *
     * @param code 認定調査項目内容01のコード
     * @return {@code code} に対応する認定調査項目内容01
     */
    public static ChosaAnser01 toValue(RString code) {
        for (ChosaAnser01 anser01 : ChosaAnser01.values()) {
            if (anser01.code.equals(code)) {
                return anser01;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査項目内容01"));
    }
}
