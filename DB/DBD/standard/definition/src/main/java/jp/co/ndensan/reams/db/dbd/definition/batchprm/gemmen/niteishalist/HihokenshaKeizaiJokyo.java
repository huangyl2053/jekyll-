package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保権者経済状況を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HihokenshaKeizaiJokyo {

    /**
     * コード:1 名称:市町村民税非課税世帯 略称:定義なし
     */
    市町村民税非課税世帯("1", "市町村民税非課税世帯"),
    /**
     * コード:2 名称:所得税非課税世帯 略称:定義なし
     */
    所得税非課税世帯("2", "所得税非課税世帯"),
    /**
     * コード:3 名称:市町村民税本人非課税者 略称:定義なし
     */
    市町村民税本人非課税者("3", "市町村民税本人非課税者"),
    /**
     * コード:4 名称:老齢福祉年金受給者 略称:定義なし
     */
    老齢福祉年金受給者("4", "老齢福祉年金受給者"),
    /**
     * コード:5 名称:生活保護受給者 略称:定義なし
     */
    生活保護受給者("5", "生活保護受給者");

    private final RString code;
    private final RString fullName;

    private HihokenshaKeizaiJokyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保権者経済状況のコードを返します。
     *
     * @return 被保権者経済状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保権者経済状況の名称を返します。
     *
     * @return 被保権者経済状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保権者経済状況のコードと一致する内容を探します。
     *
     * @param code 被保権者経済状況のコード
     * @return {@code code} に対応する被保権者経済状況
     */
    public static HihokenshaKeizaiJokyo toValue(RString code) {
        for (HihokenshaKeizaiJokyo hihokenshaKeizaiJokyo : HihokenshaKeizaiJokyo.values()) {
            if (hihokenshaKeizaiJokyo.code.equals(code)) {
                return hihokenshaKeizaiJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保権者経済状況"));
    }
}
