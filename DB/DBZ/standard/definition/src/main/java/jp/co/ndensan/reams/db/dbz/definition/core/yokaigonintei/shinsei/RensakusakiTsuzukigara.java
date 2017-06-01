/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護連絡先続柄を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum RensakusakiTsuzukigara implements IRenrakusakiTsuzukigara {

    /**
     * コード:01 名称:父 略称:定義なし
     */
    父("01", "父"),
    /**
     * コード:02 名称:母 略称:定義なし
     */
    母("02", "母"),
    /**
     * コード:03 名称:子 略称:定義なし
     */
    子("03", "子"),
    /**
     * コード:04 名称:祖父 略称:定義なし
     */
    祖父("04", "祖父"),
    /**
     * コード:05 名称:祖母 略称:定義なし
     */
    祖母("05", "祖母"),
    /**
     * コード:06 名称:従兄妹 略称:定義なし
     */
    従兄妹("06", "従兄妹"),
    /**
     * コード:99 名称:父 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private RensakusakiTsuzukigara(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護連絡先続柄のコードを返します。
     *
     * @return 介護連絡先続柄のコード
     */
    @Override
    public RString getコード() {
        return code;
    }

    /**
     * 介護連絡先続柄の名称を返します。
     *
     * @return 介護連絡先続柄の名称
     */
    @Override
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護連絡先続柄のコードと一致する内容を探します。
     *
     * @param code 介護連絡先続柄のコード
     * @return {@code code} に対応する介護連絡先続柄
     */
    public static IRenrakusakiTsuzukigara toValue(RString code) {
        for (RensakusakiTsuzukigara v : RensakusakiTsuzukigara.values()) {
            if (v.code.equals(code)) {
                return v;
            }
            if (v.fullName.equals(code)) {
                return v;
            }
        }
        return new _Empty();
    }

    private static class _Empty implements IRenrakusakiTsuzukigara {

        @Override
        public RString getコード() {
            return RString.EMPTY;
        }

        @Override
        public RString get名称() {
            return RString.EMPTY;
        }

    }

}
