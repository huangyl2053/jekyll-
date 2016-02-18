/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kaigotoiawasesaki;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護問合せ先項目を表す列挙型です。
 */
public enum KaigoToiawsaesakiItem {

    /**
     * コード:1 表示名称:<郵便番号>
     */
    郵便番号("1", "<郵便番号>"),
    /**
     * コード:2 表示名称:<所在地>
     */
    所在地("2", "<所在地>"),
    /**
     * コード:3 表示名称:<庁舎名>
     */
    庁舎名("3", "<庁舎名>"),
    /**
     * コード:4 表示名称:<電話番号>
     */
    電話番号("4", "<電話番号>"),
    /**
     * コード:5 表示名称:<内線番号>
     */
    内線番号("5", "<内線番号>"),
    /**
     * コード:6 表示名称:<部署名>
     */
    部署名("6", "<部署名>"),
    /**
     * コード:7 表示名称:<担当者名>
     */
    担当者名("7", "<担当者名>"),
    /**
     * コード:8 表示名称:<当年度>
     */
    当年度("8", "<当年度>"),
    /**
     * コード:9 表示名称:<翌年度>
     */
    翌年度("9", "<翌年度>");

    private final RString code;
    private final RString fullName;

    private KaigoToiawsaesakiItem(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護問合せ先項目のコードを返します。
     *
     * @return 介護問合せ先項目のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護問合せ先項目の表示名称を返します。
     *
     * @return 介護問合せ先項目の表示名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護問合せ先項目のコードと一致する内容を探します。
     *
     * @param code 介護問合せ先項目のコード
     * @return {@code code} に対応する介護問合せ先項目
     */
    public static KaigoToiawsaesakiItem toValue(RString code) {

        for (KaigoToiawsaesakiItem value : KaigoToiawsaesakiItem.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護問合せ先項目"));
    }
}
