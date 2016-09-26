/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 日常生活自立度を表す列挙型です。
 * 
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public enum NichijoSeikatsuJiritsudo {
    
    /**
     * コード:1 名称:Ｂ１ 略称:定義なし
     */
    Ｂ１("1", "Ｂ１"),
    
    /**
     * コード:2 名称:Ｂ２ 略称:定義なし
     */
    Ｂ２("2", "Ｂ２"),
    /**
     * コード:3 名称:Ｃ１ 略称:定義なし
     */
    Ｃ１("3", "Ｃ１"),
    /**
     * コード:4 名称:Ｃ２ 略称:定義なし
     */
    Ｃ２("4", "Ｃ２"),
    /**
     * コード:5 名称:その他 略称:定義なし
     */
    その他("5", "その他");
    
    private final RString code;
    private final RString fullName;

    private NichijoSeikatsuJiritsudo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 日常生活自立度のコードを返します。
     *
     * @return 日常生活自立度のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 日常生活自立度の名称を返します。
     *
     * @return 日常生活自立度の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 日常生活自立度のコードと一致する内容を探します。
     *
     * @param code 日常生活自立度のコード
     * @return {@code code} に対応する対象リスト
     */
    public static NichijoSeikatsuJiritsudo toValue(RString code) {
        for (NichijoSeikatsuJiritsudo nichijoSeikatsuJiritsudo : NichijoSeikatsuJiritsudo.values()) {
            if (nichijoSeikatsuJiritsudo.code.equals(code)) {
                return nichijoSeikatsuJiritsudo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("日常生活自立度"));
    }
}
