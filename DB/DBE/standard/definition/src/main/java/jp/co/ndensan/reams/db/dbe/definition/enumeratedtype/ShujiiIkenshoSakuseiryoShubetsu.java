/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の作成料種別を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ShujiiIkenshoSakuseiryoShubetsu {

    /**
     * 作成料種別が「在宅」であることを表します。
     */
    在宅("1"),
    /**
     * 作成料種別が「施設」であることを表します。
     */
    施設("2");
    private final RString code;

    private ShujiiIkenshoSakuseiryoShubetsu(String code) {
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
    public static ShujiiIkenshoSakuseiryoShubetsu toValue(RString code) {
        for (ShujiiIkenshoSakuseiryoShubetsu data : ShujiiIkenshoSakuseiryoShubetsu.values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する主治医意見書作成料種別").evaluate());
    }
}
