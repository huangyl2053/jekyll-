/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務コンフィグの表示有無の定義値を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum ShikakushashoItakudaikoHyoji {

    /**
     * 資格者証表示方法_委託代行業者の表示有無が「非表示」であることを表します。<br />
     * コード : 0
     */
    非表示("0"),
    /**
     * 資格者証表示方法_委託代行業者の表示有無が「表示」であることを表します。<br />
     * コード : 1
     */
    表示("1");

    private final RString theCode;

    private ShikakushashoItakudaikoHyoji(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return 表示有無
     */
    public RString code() {
        return theCode;
    }

    /**
     * 引数のコードに対応する{@link ShikakushashoItakudaikoHyoji}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link ShikakushashoItakudaikoHyoji}
     * @throws IllegalArgumentException
     * コードに対応する{@link ShikakushashoItakudaikoHyoji}が無い時
     */
    public static ShikakushashoItakudaikoHyoji toValue(RString code) {
        for (ShikakushashoItakudaikoHyoji data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(ShikakushashoItakudaikoHyoji.class.getSimpleName()));
    }

}
