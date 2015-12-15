package jp.co.ndensan.reams.db.dbz.definition.core.jyushochitokureisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内住所地特例者区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KoikinaiJushochitokureishaKubun {

    /**
     * コード:1 名称:広域内住所地特例者 略称:定義なし
     */
    広域内住所地特例者("1", "広域内住所地特例者"),
    /**
     * コード:2 名称:通常資格者 略称:定義なし
     */
    通常資格者("2", "通常資格者");

    private final RString code;
    private final RString fullName;

    private KoikinaiJushochitokureishaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域内住所地特例者区分のコードを返します。
     *
     * @return 広域内住所地特例者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域内住所地特例者区分の名称を返します。
     *
     * @return 広域内住所地特例者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域内住所地特例者区分のコードと一致する内容を探します。
     *
     * @param code 広域内住所地特例者区分のコード
     * @return {@code code} に対応する広域内住所地特例者区分
     */
    public static KoikinaiJushochitokureishaKubun toValue(RString code) {

        for (KoikinaiJushochitokureishaKubun value : KoikinaiJushochitokureishaKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("広域内住所地特例者区分"));
    }
}
