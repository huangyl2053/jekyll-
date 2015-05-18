/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の作成回数を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShujiiIkenshoSakuseiKaisu {

    /**
     * 作成回数が「初回」であることを表します。
     */
    初回("1"),
    /**
     * 作成回数が「２回目以上」であることを表します。
     */
    二回目以上("2");
    private final RString code;

    private ShujiiIkenshoSakuseiKaisu(String code) {
        this.code = new RString(code);
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
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static ShujiiIkenshoSakuseiKaisu toValue(RString code) {
        for (ShujiiIkenshoSakuseiKaisu data : ShujiiIkenshoSakuseiKaisu.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する主治医意見書作成回数").evaluate());
    }
}
