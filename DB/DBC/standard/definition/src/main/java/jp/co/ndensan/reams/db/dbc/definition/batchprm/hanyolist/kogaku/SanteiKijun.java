package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 算定基準を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum SanteiKijun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:１５，０００円 略称:定義なし
     */
    _１５０００円("1", "１５，０００円"),
    /**
     * コード:2 名称:２６，４００円 略称:定義なし
     */
    _２６４００円("2", "２６，４００円"),
    /**
     * コード:3 名称:３７，２００円 略称:定義なし
     */
    _３７２００円("3", "３７，２００円"),
    /**
     * コード:4 名称:４４，４００円 略称:定義なし
     */
    _４４４００円("4", "４４，４００円");

    private final RString code;
    private final RString fullName;

    private SanteiKijun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 算定基準のコードを返します。
     *
     * @return 算定基準のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 算定基準の名称を返します。
     *
     * @return 算定基準の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 算定基準のコードと一致する内容を探します。
     *
     * @param code 算定基準のコード
     * @return {@code code} に対応する算定基準
     */
    public static SanteiKijun toValue(RString code) {
        for (SanteiKijun santeiKijun : SanteiKijun.values()) {
            if (santeiKijun.code.equals(code)) {
                return santeiKijun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("算定基準"));
    }
}
