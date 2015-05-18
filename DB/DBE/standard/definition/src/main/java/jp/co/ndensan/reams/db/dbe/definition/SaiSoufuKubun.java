/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再送付区分の列挙型です。
 *
 * @author n8107 千秋雄
 */
public enum SaiSoufuKubun implements IRStringConvertable {
//TODO N8107千秋雄 コードマスタにて管理されることも考慮する　2014/2/28 まで

    /**
     * 初期値・再送信がない場合 ("00")
     */
    再送信無し(new RString("00")),
    /**
     * 再度送信した場合 ("01")
     */
    再送信(new RString("01")),
    /**
     * 再度送信後、送付済の場合 ("02")
     */
    再送信送付済(new RString("02"));
    private final RString コード;

    private SaiSoufuKubun(RString code) {
        this.コード = code;
    }

    /**
     * 指定された再送付区分に該当する再送付区分情報を返します。
     *
     * @param code 再送付区分
     * @return 名称
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない再送付区分の場合
     */
    public static SaiSoufuKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("再送付区分"));

        for (SaiSoufuKubun item : SaiSoufuKubun.values()) {
            if (item.コード.equals(code)) {
                return item;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する再送付区分").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する再送付区分").getMessage());

    }

    /**
     * 再送付区分を返します。
     *
     * @return 再送付区分
     */
    public RString getCode() {
        return コード;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
