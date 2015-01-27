/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失事由の列挙型です。<br />
 * 被保険者資格を喪失した際の異動事由を扱います。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuSoshitsuJiyu implements IShikakuIdoJiyu {

    /**
     * なし <br />
     * 資格喪失事由がないこと表す。<br />
     * コード : 00
     */
    なし("00"),
    /**
     * 転出 <br />
     * コード : 01
     */
    転出("01"),
    /**
     * 死亡 <br />
     * コード : 02
     */
    死亡("02"),
    /**
     * 除外者 <br />
     * コード : 03
     */
    除外者("03"),
    /**
     * 国籍喪失 <br />
     * コード : 04
     */
    国籍喪失("04"),
    /**
     * 他特例者 <br />
     * コード : 05
     */
    他特例者("05"),
    /**
     * 職権喪失 <br />
     * コード : 06
     */
    職権喪失("06"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99");
    private final RString code;

    private ShikakuSoshitsuJiyu(String code) {
        this.code = new RString(code);
    }

    @Override
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString getName() {
        return new RString(name());
    }

    @Override
    public RString getShortName() {
        return new RString(name());
    }

    /**
     * 指定のコードに対応するShikakuSoshitsuJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuSoshitsuJiyu
     * @throws IllegalArgumentException 指定のコードに対応するShikakuSoshitsuJiyuがないとき。
     */
    public static ShikakuSoshitsuJiyu toValue(RString code) throws IllegalArgumentException {
        for (ShikakuSoshitsuJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する資格喪失事由").evaluate());
    }
}
