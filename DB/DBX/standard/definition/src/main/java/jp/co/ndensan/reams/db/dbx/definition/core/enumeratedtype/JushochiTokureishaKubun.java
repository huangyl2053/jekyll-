package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 住所地特例者区分を表す列挙型です。
 *
 * @author N2218 村松 優
 * @jpName 住所地特例者区分
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護資格
 * @mainClass
 * @reference
 */
public enum JushochiTokureishaKubun implements IRStringConvertable {

    /**
     * 住所地特例者<br />
     * コード：1<br />
     * 名称：住所地特例者（特例中）。<br />
     */
    住所地特例者("1", "住所地特例者（特例中）"),
    /**
     * 通常資格者<br />
     * コード：無<br />
     * 名称：通常資格者。<br />
     */
    通常資格者("", "通常資格者");
    private final RString コード;
    private final RString 名称;

    private JushochiTokureishaKubun(String コード, String 名称) {
        this.コード = new RString(コード);
        this.名称 = new RString(名称);
    }

    /**
     * 指定された住所地特例者区分コードの住所地特例者区分を返します。
     *
     * @param code 住所地特例者区分コード
     * @return 住所地特例者区分
     * @throws NullPointerException {@code code}がnullの場合
     * @throws IllegalArgumentException {@code code}が実在しない住所地特例者区分コードの場合
     */
    public static JushochiTokureishaKubun toValue(RString code) throws NullPointerException, IllegalArgumentException {

        requireNonNull(code, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例者区分"));

        for (JushochiTokureishaKubun jushochiTokureishaKubun : JushochiTokureishaKubun.values()) {
            if (jushochiTokureishaKubun.コード.equals(code)) {
                return jushochiTokureishaKubun;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("住所地特例者区分").evaluate());
    }

    /**
     * 受給年金区分を返します。
     *
     * @return 住所地特例者区分コード
     */
    public RString getコード() {
        return コード;
    }

    /**
     * 年金資格種別名称を返します。
     *
     * @return 住所地特例者区分名称
     */
    public RString get名称() {
        return 名称;
    }

    @Override
    public RString toRString() {
        return new RString(JushochiTokureishaKubun.this.toString());
    }
}
