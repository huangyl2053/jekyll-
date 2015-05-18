/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医師区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum IshiKubun {

    /**
     * 医師区分が「主治医」であることを表します。<br />
     * コード : 1
     */
    主治医(new RString("1")),
    /**
     * 医師区分が「指定医」であることを表します。<br />
     * コード : 2
     */
    指定医(new RString("2"));
    private RString code;

    private IshiKubun(RString code) {
        this.code = code;
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 引数のコードに対応する医師区分を返します。
     *
     * @param code コード
     * @return 医師区分
     */
    public static IshiKubun toValue(RString code) {
        for (IshiKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する医師区分").evaluate());
    }
}
