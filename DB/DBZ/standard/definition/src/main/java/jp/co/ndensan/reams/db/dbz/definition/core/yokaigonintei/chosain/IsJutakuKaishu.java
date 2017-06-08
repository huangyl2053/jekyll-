/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum IsJutakuKaishu {

    /**
     * コード:1 True 名称:あり 略称:定義なし
     */
    あり(true, "あり", "1"),
    /**
     * コード:2 False 名称:なし 略称:定義なし
     */
    なし(false, "なし", "2");

    private final boolean booleanValue;
    private final RString fullName;
    private final RString theCode;

    private IsJutakuKaishu(boolean booleanValue, String fullname, String code) {
        this.booleanValue = booleanValue;
        this.fullName = new RString(fullname);
        this.theCode = new RString(code);
    }

    /**
     * 住宅改修コード（NCIフォーマット）を返します。
     *
     * @return 住宅改修コード（NCIフォーマット）
     */
    public RString code() {
        return this.theCode;
    }

    /**
     * 住宅改修の有無をbooleanで返します。
     *
     * @return 住宅改修の有無
     */
    public boolean isあり() {
        return booleanValue;
    }

    /**
     * 住宅改修の名称を返します。
     *
     * @return 住宅改修の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住宅改修のコードと一致する内容を探します。
     *
     * @param booleanValue 住宅改修のコード
     * @return {@code code} に対応する住宅改修
     */
    public static IsJutakuKaishu toValue(boolean booleanValue) {
        return booleanValue ? あり : なし;
    }

}
