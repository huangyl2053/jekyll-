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
     * EMPTY <br />
     * 資格喪失事由がないこと表す。<br />
     * コード : EMPTY
     */
    EMPTY("", ""),
    /**
     * 転出 <br />
     * コード : 01
     */
    転出("01", "転出"),
    /**
     * 死亡 <br />
     * コード : 02
     */
    死亡("02", "死亡"),
    /**
     * 除外者 <br />
     * コード : 03
     */
    除外者("03", "除外者"),
    /**
     * 国籍喪失 <br />
     * コード : 04
     */
    国籍喪失("04", "国籍喪失"),
    /**
     * 他特例者 <br />
     * コード : 05
     */
    他特例者("05", "他特例者"),
    /**
     * 職権喪失 <br />
     * コード : 06
     */
    職権喪失("06", "職権喪失"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99", "その他");
    private final RString code;
    private final RString shortName;

    private ShikakuSoshitsuJiyu(String code, String shortName) {
        this.code = new RString(code);
        this.shortName = new RString(shortName);
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
     * 指定のコードに対応するShikakuSoshitsuJiyuを返します。<br/>
     * 空文字列、もしくはnullを受け取った場合は"EMPTY"を表すShikakuSoshitsuJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuSoshitsuJiyu
     * @throws IllegalArgumentException 指定のコードに対応するShikakuSoshitsuJiyuがないとき。
     */
    public static ShikakuSoshitsuJiyu toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (ShikakuSoshitsuJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する資格喪失事由").evaluate());
    }
}
