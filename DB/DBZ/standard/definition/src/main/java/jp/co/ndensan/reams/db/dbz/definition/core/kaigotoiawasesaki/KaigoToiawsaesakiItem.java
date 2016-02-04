/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kaigotoiawasesaki;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護問合せ先項目列挙型です。
 *
 */
public enum KaigoToiawsaesakiItem {

    /**
     * コード:1 名称:郵便番号 略称:定義なし
     */
    郵便番号("1", "郵便番号"),
    /**
     * コード:2 名称:所在地 略称:定義なし
     */
    所在地("2", "所在地"),
    /**
     * コード:3 名称:庁舎名 略称:定義なし
     */
    庁舎名("3", "庁舎名"),
    /**
     * コード:4 名称:電話番号 略称:定義なし
     */
    電話番号("4", "電話番号"),
    /**
     * コード:5 名称:内線番号 略称:定義なし
     */
    内線番号("5", "内線番号"),
    /**
     * コード:6 名称:部署名 略称:定義なし
     */
    部署名("6", "部署名"),
    /**
     * コード:7 名称:担当者名 略称:定義なし
     */
    担当者名("7", "担当者名");

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
     * 介護問合せ先項目の名称を返します。
     *
     * @return 介護問合せ先項目の名称
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
