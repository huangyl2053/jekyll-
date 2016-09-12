/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合の 判定区分を定義した列挙型です。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
public enum HanteiKubunType {

    /**
     * 対象外を表します。
     */
    対象外("0", "対象外"),
    /**
     * 第２号被保険者を表します。
     */
    第２号被保険者("1", "第２号被保険者"),
    /**
     * 生活保護を表します。
     */
    生活保護("2", "生活保護"),
    /**
     * 旧措置を表します。
     */
    旧措置("3", "旧措置"),
    /**
     * 非課税を表します。
     */
    非課税("4", "非課税"),
    /**
     * 負担割合判定を表します。
     */
    負担割合判定("5", "負担割合判定"),
    /**
     * EMPTY
     */
    EMPTY;

    private final RString code;
    private final RString name;

    private HanteiKubunType() {
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
    }

    private HanteiKubunType(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return code;
    }

    /**
     * displayNameを返します。
     *
     * @return displayName
     */
    public RString displayName() {
        return this.name;
    }

    /**
     * 対応する列挙型を返します。
     * <p/>
     * @param codeOrName codeOrName
     * @return 列挙型
     * @throws IllegalArgumentException 対応する列挙型がない場合
     */
    public static HanteiKubunType toValue(RString codeOrName) throws IllegalArgumentException {
        if (RString.isNullOrEmpty(codeOrName)) {
            return EMPTY;
        }
        for (HanteiKubunType data : values()) {
            if (data.displayName().equals(codeOrName) || data.code().equals(codeOrName)) {
                return data;
            }
        }
        return EMPTY;
    }
}
