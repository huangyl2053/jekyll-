/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失者選択を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ShikakuSoshitsushaSentaku {

    /**
     * コード:1 名称:出力する 略称:定義なし
     */
    出力する("1", "出力する"),
    /**
     * コード:2 名称:出力しない 略称:定義なし
     */
    出力しない("2", "出力しない");
    private final RString code;
    private final RString fullName;

    private ShikakuSoshitsushaSentaku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格喪失者選択のコードを返します。
     *
     * @return 資格喪失者選択のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格喪失者選択の名称を返します。
     *
     * @return 資格喪失者選択の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格喪失者選択のコードと一致する内容を探します。
     *
     * @param code 資格喪失者選択のコード
     * @return {@code code} に対応する対象リスト
     */
    public static ShikakuSoshitsushaSentaku toValue(RString code) {
        for (ShikakuSoshitsushaSentaku shikakusoshitsushaSentaku : ShikakuSoshitsushaSentaku.values()) {
            if (shikakusoshitsushaSentaku.code.equals(code)) {
                return shikakusoshitsushaSentaku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格喪失者選択"));
    }
}
