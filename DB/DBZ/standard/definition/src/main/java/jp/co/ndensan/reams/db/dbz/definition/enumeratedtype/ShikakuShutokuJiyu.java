/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得事由の列挙型です。<br />
 * 被保険者資格を取得した際の異動事由を扱います。
 *
 * @author N3327 三浦 凌
 */
public enum ShikakuShutokuJiyu implements IShikakuIdoJiyu {

    /**
     * なし <br />
     * 資格取得事由がないこと表す。<br />
     * コード : 00
     */
    なし("00"),
    /**
     * 転入 <br />
     * コード : 01
     */
    転入("01"),
    /**
     * 年齢到達 <br />
     * コード : 02
     */
    年齢到達("02"),
    /**
     * 外国人 <br />
     * コード : 03
     */
    外国人("03"),
    /**
     * ２号申請 <br />
     * コード : 04
     */
    第２号申請("04"),
    /**
     * 他特例居住 <br />
     * コード : 07
     */
    他特例居住("07"),
    /**
     * 除外者居住 <br />
     * コード : 08
     */
    除外者居住("08"),
    /**
     * 帰化 <br />
     * コード : 09
     */
    帰化("09"),
    /**
     * 広域内転入 <br />
     * コード : 11
     */
    広域内転入("11"),
    /**
     * 国籍取得 <br />
     * コード : 12
     */
    国籍取得("12"),
    /**
     * 広住特適用 <br />
     * コード : 13
     */
    広住特適用("13"),
    /**
     * 広住特転入 <br />
     * コード : 14
     */
    広住特転入("14"),
    /**
     * 広住特居住 <br />
     * コード : 15
     */
    広住特居住("15"),
    /**
     * 合併内転居 <br />
     * コード : 16
     */
    合併内転居("16"),
    /**
     * 職権取得 <br />
     * コード : 17
     */
    職権取得("17"),
    /**
     * 一本化 <br />
     * コード : 41
     */
    一本化("41"),
    /**
     * 合併 <br />
     * コード : 42
     */
    合併("42"),
    /**
     * 施工時取得 <br />
     * コード : 46
     */
    施工時取得("46"),
    /**
     * その他 <br />
     * コード : 49
     */
    その他("49");
    private final RString code;

    private ShikakuShutokuJiyu(String code) {
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
     * 指定のコードに対応するShikakuShutokuJiyuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShikakuShutokuJiyu
     * @throws IllegalArgumentException 指定のコードに対応するShikakuShutokuJiyuがないとき。
     */
    public static ShikakuShutokuJiyu toValue(RString code) throws IllegalArgumentException {
        for (ShikakuShutokuJiyu target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する資格取得事由").getMessage());
    }
}
