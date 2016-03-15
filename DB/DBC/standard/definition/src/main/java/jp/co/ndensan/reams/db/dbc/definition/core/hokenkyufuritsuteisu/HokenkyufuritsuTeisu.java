/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hokenkyufuritsuteisu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険給付率定数を表す列挙型です。
 */
public enum HokenkyufuritsuTeisu {

    /**
     * コード:90 名称:定数９０パーセント 略称:９０％
     */
    定数９０パーセント("90", "定数９０パーセント", "９０％"),
    /**
     * コード:80 名称:定数８０パーセント 略称:８０％
     */
    定数８０パーセント("80", "定数８０パーセント", "８０％");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HokenkyufuritsuTeisu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 保険給付率定数のコードを返します。
     *
     * @return 保険給付率定数のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 保険給付率定数の名称を返します。
     *
     * @return 保険給付率定数の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 保険給付率定数の略称を返します。
     *
     * @return 保険給付率定数の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 保険給付率定数のコードと一致する内容を探します。
     *
     * @param code 保険給付率定数のコード
     * @return {@code code} に対応する保険給付率定数
     */
    public static HokenkyufuritsuTeisu toValue(RString code) {

        for (HokenkyufuritsuTeisu hokenkyufuritsuTeisu : HokenkyufuritsuTeisu.values()) {
            if (hokenkyufuritsuTeisu.code.equals(code)) {
                return hokenkyufuritsuTeisu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("保険給付率定数"));
    }
}
