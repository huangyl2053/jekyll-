/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
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
    /** 転入 <br />
     * コード : 01
     */
    転入("01"),
    /** 年齢到達 <br />
     * コード : 02
     */
    年齢到達("02"),
    /** 外国人 <br />
     * コード : 03
     */
    外国人("03"),
    /**
     * 二号申請 <br />
     * コード : 04
     */
    二号申請("04"),
    /**
     * 他特例居住 <br />
     * コード : 05
     */
    他特例居住("05"),
    /**
     * 除外者居住<br />
     * コード : 06
     */
    除外者居住("06"),
    /**
     * 帰化 <br />
     * コード : 07
     */
    帰化("07"),
    /**
     * 国籍取得 <br />
     * コード : 08
     */
    国籍取得("08"),
    /**
     * 職権取得 <br />
     * コード : 09
     */
    職権取得("09"),
    /**
     * 施行時取得 <br />
     * コード : 10
     */
    施行時取得("10"),
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
        throw new IllegalArgumentException(Messages.E00006.replace("コード:" + code + " に対応する資格変更事由").getMessage());
    }
}
