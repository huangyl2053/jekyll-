/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.atenapsm;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民状態コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum JuminJotaiCode {

    /**
     * コード:1 名称:住民 略称:定義なし
     */
    住民("1", "住民"),
    /**
     * コード:2 名称:住登外 略称:定義なし
     */
    住登外("2", "住登外"),
    /**
     * コード:3 名称:転出者 略称:定義なし
     */
    転出者("3", "転出"),
    /**
     * コード:4 名称:死亡者 略称:定義なし
     */
    死亡者("4", "喪失"),
    /**
     * コード:9 名称:消除者 略称:定義なし
     */
    消除者("9", "消除者");

    private final RString code;
    private final RString fullName;

    private JuminJotaiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 住民状態コードのコードを返します。
     *
     * @return 住民状態コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 住民状態コードの名称を返します。
     *
     * @return 住民状態コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住民状態コードのコードと一致する内容を探します。
     *
     * @param code 住民状態コードのコード
     * @return {@literal code} に対応する住民状態コード
     */
    public static JuminJotaiCode toValue(RString code) {

        for (JuminJotaiCode value : JuminJotaiCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住民状態コード"));
    }
}
