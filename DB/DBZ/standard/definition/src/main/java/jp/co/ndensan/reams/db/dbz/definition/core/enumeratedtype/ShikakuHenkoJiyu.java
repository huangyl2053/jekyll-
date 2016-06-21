/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.definition.core.IShikakuIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格変更事由の列挙型クラスです。<br />
 * 被保険者資格を変更した際の異動事由を扱います。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuHenkoJiyu implements IShikakuIdoJiyu {

    /**
     * EMPTY <br />
     * 資格変更事由がないこと表す。<br />
     * コード : EMPTY
     */
    EMPTY("", ""),
    /**
     * 転居 <br />
     * コード : 01。
     */
    転居("01", "転居"),
    /**
     * 氏名変更 <br />
     * コード : 02。
     */
    氏名変更("02", "氏名変更"),
    /**
     * 広域内転居 <br />
     * コード : 03。
     */
    広域内転居("03", "広域内転居"),
    /**
     * 広住特適用 <br />
     * コード : 04。
     */
    広住特適用("04", "広住特適用"),
    /**
     * 広住特転入 <br />
     * コード : 05。
     */
    広住特転入("05", "広住特転入"),
    /**
     * 広住特居住<br />
     * コード : 06。
     */
    広住特居住("06", "広住特居住"),
    /**
     * 広住特転居<br />
     * コード : 07。
     */
    広住特転居("07", "広住特転居"),
    /**
     * 合併内転居<br />
     * コード : 08。
     */
    合併内転居("08", "合併内転居"),
    /**
     * 一本化<br />
     * コード : 09。
     */
    一本化("09", "一本化"),
    /**
     * 第1号到達<br />
     * コード : 10。
     */
    第1号到達("10", "第1号到達"),
    /**
     * 合併<br />
     * コード : 11。
     */
    合併("11", "合併"),
    /**
     * 帰化 <br />
     * コード : 12。
     */
    帰化("12", "帰化"),
    /**
     * 国籍取得 <br />
     * コード : 13。
     */
    国籍取得("13", "国籍取得"),
    /**
     * その他 <br />
     * コード : 99。
     */
    その他("99", "その他");
    private final RString code;
    private final RString shortName;

    private ShikakuHenkoJiyu(String code, String shortName) {
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
     * 指定のコードに対応するShikakuHenkoJiyuを返します。
     * 空文字列、もしくはnullを受け取った場合は"EMPTY"を表すShikakuHenkoJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuHenkoJiyu
     * @throws IllegalArgumentException 指定のコードに対応するShikakuHenkoJiyuがないとき。
     */
    public static ShikakuHenkoJiyu toValue(RString code) throws IllegalArgumentException {
        if (code == null || code.isEmpty()) {
            return EMPTY;
        }

        for (ShikakuHenkoJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する資格変更事由").evaluate());
    }
}
