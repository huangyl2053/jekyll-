/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格区分のクラスです。
 *
 * @reamsid_L DBB-9999-022 zhaowei
 */
public enum ShikakuKubun {

    /**
     * コード:1 名称:資格喪失者含むで抽出 略称:定義なし
     */
    資格喪失者含む("1", "資格喪失者含む"),
    /**
     * コード:2 名称:資格取得者のみ 略称:定義なし
     */
    資格取得者のみ("2", "資格取得者のみ"),
    /**
     * コード:3 名称:資格喪失者のみ 略称:定義なし
     */
    資格喪失者のみ("3", "資格喪失者のみ");

    private final RString code;
    private final RString fullName;

    private ShikakuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格区分のコードを返します。
     *
     * @return 資格区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格区分の名称を返します。
     *
     * @return 資格区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格区分のコードと一致する内容を探します。
     *
     * @param code 資格区分のコード
     * @return {@code code} に対応する資格区分
     */
    public static ShikakuKubun toValue(RString code) {
        for (ShikakuKubun shikakuKubun : ShikakuKubun.values()) {
            if (shikakuKubun.code.equals(code)) {
                return shikakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格区分"));
    }
}
