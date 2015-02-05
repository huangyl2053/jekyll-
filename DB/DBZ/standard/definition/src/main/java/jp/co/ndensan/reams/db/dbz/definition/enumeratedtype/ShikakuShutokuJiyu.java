/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得事由の列挙型です。<br />
 * 被保険者資格を取得した際の異動事由を扱います。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuShutokuJiyu implements IShikakuIdoJiyu {

    /**
     * EMPTY <br />
     * 資格取得事由がないこと表す。<br />
     * コード : EMPTY
     */
    EMPTY("", ""),
    /**
     * 転入 <br />
     * コード : 01
     */
    転入("01", "転入"),
    /**
     * 年齢到達 <br />
     * コード : 02
     */
    年齢到達("02", "年齢到達"),
    /**
     * 外国人 <br />
     * コード : 03
     */
    外国人("03", "外国人"),
    /**
     * ２号申請 <br />
     * コード : 04
     */
    第２号申請("04", "第２号申請"),
    /**
     * 他特例居住 <br />
     * コード : 05
     */
    他特例居住("05", "他特例居住"),
    /**
     * 除外者居住 <br />
     * コード : 06
     */
    除外者居住("06", "除外者居住"),
    /**
     * 帰化 <br />
     * コード : 07
     */
    帰化("07", "帰化"),
    /**
     * 国籍取得 <br />
     * コード : 08
     */
    国籍取得("08", "国籍取得"),
    /**
     * 職権取得 <br />
     * コード : 09
     */
    職権取得("09", "職権取得"),
    /**
     * 施行時取得 <br />
     * コード : 10
     */
    施行時取得("10", "施行時取得"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99", "その他");
    private final RString code;
    private final RString shortName;

    private ShikakuShutokuJiyu(String code, String shortName) {
        this.code = new RString(code);
        this.shortName = new RString(shortName);
    }

    @Override
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString getName() {
        return shortName;
    }

    @Override
    public RString getShortName() {
        return shortName;
    }

    /**
     * 指定のコードに対応するShikakuShutokuJiyuを返します。<br/>
     * 空文字列、もしくはnullを受け取った場合は"EMPTY"を表すShikakuShutokuJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuShutokuJiyu
     * @throws IllegalArgumentException 指定のコードに対応するShikakuShutokuJiyuがないとき。
     */
    public static ShikakuShutokuJiyu toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (ShikakuShutokuJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する資格取得事由").evaluate());
    }
}
