/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
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
     * コード : 51
     */
    転出("51"),
    /**
     * 死亡 <br />
     * コード : 52
     */
    死亡("52"),
    /**
     * 除外者 <br />
     * コード : 53
     */
    除外者("53"),
    /**
     * 帰化 <br />
     * コード : 56
     */
    帰化("56"),
    /**
     * 国籍喪失 <br />
     * コード : 57
     */
    国籍喪失("57"),
    /**
     * 他特例者 <br />
     * コード : 58
     */
    他特例者("58"),
    /**
     * 年齢到達 <br />
     * コード : 59
     */
    年齢到達("59"),
    /**
     * 広域内転出 <br />
     * コード : 61
     */
    広域内転出("61"),
    /**
     * 国籍取得 <br />
     * コード : 62
     */
    国籍取得("62"),
    /**
     * 広住特転入 <br />
     * コード : 64
     */
    広住特転入("64"),
    /**
     * 広住特解除 <br />
     * コード : 65
     */
    広住特解除("65"),
    /**
     * 合併内転居 <br />
     * コード : 66
     */
    合併内転居("66"),
    /**
     * 職権喪失 <br />
     * コード : 67
     */
    職権喪失("67"),
    /**
     * 一本化 <br />
     * コード : 91
     */
    一本化("91"),
    /**
     * 合併 <br />
     * コード : 92
     */
    合併("92"),
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
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する資格喪失事由").getMessage());
    }
}
