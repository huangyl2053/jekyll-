/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者区分を表す列挙型です。
 *
 * @author N2218 村松 優
 * @jpName 受給者区分
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum JukyushaKubun implements IRStringConvertable {

    /**
     * 受給者<br />
     * コード：1<br />
     */
    受給者("1"),
    /**
     * 非受給者<br />
     * コード：無<br />
     */
    非受給者("");
    private final RString コード;

    private JukyushaKubun(String コード) {
        this.コード = new RString(コード);
    }

    /**
     * 指定された受給者区分コードの受給者区分を返します。
     *
     * @param code 受給者区分コード
     * @return 受給者区分
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない受給者区分コードの場合
     */
    public static JukyushaKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {

        requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者区分"));

        for (JukyushaKubun jukyushaKubun : JukyushaKubun.values()) {
            if (jukyushaKubun.コード.equals(code)) {
                return jukyushaKubun;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("受給者区分").evaluate());
    }

    /**
     * 受給者区分を返します。
     *
     * @return 受給者区分コード
     */
    public RString getコード() {
        return コード;
    }

    @Override
    public RString toRString() {
        return new RString(JukyushaKubun.this.toString());
    }
}
