/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの資格者証表示方法_委託代行業者_表示有無の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ConfigValuesShikakushashoItakudaikoHyoji {

    /**
     * 資格者証表示方法_委託代行業者の表示有無が「非表示」であることを表します。<br />
     * コード : 0
     */
    資格者証表示方法_委託代行業者_非表示("0"),
    /**
     * 資格者証表示方法_委託代行業者の表示有無が「表示」であることを表します。<br />
     * コード : 1
     */
    資格者証表示方法_委託代行業者_表示("1");

    private final RString code;

    private ConfigValuesShikakushashoItakudaikoHyoji(String code) {
        this.code = new RString(code);
    }

    public RString getCode() {
        return code;
    }

    /**
     * コードに対応するenumを返します。
     *
     * @param code 定義値
     * @return 引数のコードに対応するenum
     */
    public static ConfigValuesShikakushashoItakudaikoHyoji toValue(RString code) {
        for (ConfigValuesShikakushashoItakudaikoHyoji data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(DbzErrorMessages.データが存在しない.getMessage().toString());
    }

}
