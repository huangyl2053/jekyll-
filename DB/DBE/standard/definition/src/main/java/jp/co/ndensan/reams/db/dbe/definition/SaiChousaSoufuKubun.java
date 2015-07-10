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
 * 再調査送付区分の列挙型です。
 *
 * @author n8107 千秋雄
 */
public enum SaiChousaSoufuKubun implements IRStringConvertable {
//TODO N8107千秋雄 コードマスタにて管理されることも考慮する　2014/2/28 まで

    /**
     * 再送信の場合 ("1")
     */
    再送信(new RString("1")),
    /**
     * 再度認定調査を依頼する場合 ("2")
     */
    再調査(new RString("2")),
    /**
     * 再調査後 送付済の場合 ("3")
     */
    再調査送付済(new RString("3")),
    /**
     * この再調査送付区分自体未使用の場合 ("0")
     */
    未使用(new RString("0"));
    private final RString コード;

    private SaiChousaSoufuKubun(RString code) {
        this.コード = code;
    }

    /**
     * 指定された再調査送付区分に該当する再調査送付区分情報を返します。
     *
     * @param code 再調査送付区分
     * @return 名称
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない再調査送付区分の場合
     */
    public static SaiChousaSoufuKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {
        Objects.requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("再調査送付区分"));

        for (SaiChousaSoufuKubun item : SaiChousaSoufuKubun.values()) {
            if (item.コード.equals(code)) {
                return item;
            }
        }
//        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する再調査送付区分").evaluate());
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("該当する再調査送付区分").getMessage());

    }

    /**
     * 再調査送付区分を返します。
     *
     * @return 再調査送付区分
     */
    public RString getCode() {
        return コード;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
