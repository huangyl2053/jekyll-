/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格変更事由の列挙型です。<br />
 * 被保険者資格を変更した際の異動事由を扱います。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuHenkoJiyu implements IShikakuIdoJiyu {

    /**
     * なし <br />
     * 資格変更事由がないこと表す。<br />
     * コード : 00
     */
    なし("00"),
    /**
     * 転居 <br />
     * コード : 01
     */
    転居("01"),
    /**
     * 氏名変更 <br />
     * コード : 02
     */
    氏名変更("02"),
    /**
     * 広域内転居 <br />
     * コード : 03
     */
    広域内転居("03"),
    /**
     * 広住特適用 <br />
     * コード : 04
     */
    広住特適用("04"),
    /**
     * 広住特転入 <br />
     * コード : 05
     */
    広住特転入("05"),
    /**
     * 広住特居住<br />
     * コード : 06
     */
    広住特居住("06"),
    /**
     * 広住特転居<br />
     * コード : 07
     */
    広住特転居("07"),
    /**
     * 合併内転居<br />
     * コード : 08
     */
    合併内転居("08"),
    /**
     * 一本化<br />
     * コード : 09
     */
    一本化("09"),
    /**
     * 第1号到達<br />
     * コード : 10
     */
    第1号到達("10"),
    /**
     * 合併<br />
     * コード : 11
     */
    合併("11"),
    /**
     * 帰化 <br />
     * コード : 12
     */
    帰化("12"),
    /**
     * 国籍取得 <br />
     * コード : 13
     */
    国籍取得("13"),
    /**
     * その他 <br />
     * コード : 99
     */
    その他("99");
    private final RString code;

    private ShikakuHenkoJiyu(String code) {
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
     * 指定のコードに対応するShikakuHenkoJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuHenkoJiyu
     * @throws IllegalArgumentException 指定のコードに対応するShikakuHenkoJiyuがないとき。
     */
    public static ShikakuHenkoJiyu toValue(RString code) throws IllegalArgumentException {
        for (ShikakuHenkoJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("コード:" + code + " に対応する資格変更事由").evaluate());
    }
}
