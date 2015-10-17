/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格被保険者区分を表す列挙型です。
 *
 * @author N2218 村松 優
 * @jpName 資格被保険者区分
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護資格
 * @mainClass
 * @reference
 */
public enum ShikakuHihokenshaKubun implements IRStringConvertable {

    /**
     * 第１号被保険者<br />
     * コード：1<br />
     * 名称：１号<br />
     */
    第１号被保険者("1", "１号"),
    /**
     * 第２号被保険者<br />
     * コード：2<br />
     * 名称：２号<br />
     */
    第２号被保険者("2", "２号");
    private final RString コード;
    private final RString 名称;

    private ShikakuHihokenshaKubun(String コード, String 名称) {
        this.コード = new RString(コード);
        this.名称 = new RString(名称);
    }

    /**
     * 指定された資格被保険者区分コードの資格被保険者区分を返します。
     *
     * @param code 資格被保険者区分コード
     * @return 資格被保険者区分
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない資格被保険者区分コードの場合
     */
    public static ShikakuHihokenshaKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {

        requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("資格被保険者区分"));

        for (ShikakuHihokenshaKubun shikakuHihokenshaKubun : ShikakuHihokenshaKubun.values()) {
            if (shikakuHihokenshaKubun.コード.equals(code)) {
                return shikakuHihokenshaKubun;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("資格被保険者区分").evaluate());
    }

    /**
     * 資格被保険者区分を返します。
     *
     * @return 資格被保険者区分コード
     */
    public RString getコード() {
        return コード;
    }

    /**
     * 資格被保険者区分名称を返します。
     *
     * @return 資格被保険者区分名称
     */
    public RString get名称() {
        return 名称;
    }

    @Override
    public RString toRString() {
        return new RString(ShikakuHihokenshaKubun.this.toString());
    }
}
