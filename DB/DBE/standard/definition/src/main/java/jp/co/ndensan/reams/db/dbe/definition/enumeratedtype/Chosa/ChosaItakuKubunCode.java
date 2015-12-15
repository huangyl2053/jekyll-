package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査委託区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ChosaItakuKubunCode {

    /**
     * コード:1 名称:保険者（市町村等） 略称:定義なし
     */
    保険者_市町村等("1", "保険者（市町村等）"),
    /**
     * コード:2 名称:指定市町村事務受託法人 略称:定義なし
     */
    指定市町村事務受託法人("2", "指定市町村事務受託法人"),
    /**
     * コード:3 名称:指定居宅介護支援事業者 略称:定義なし
     */
    指定居宅介護支援事業者("3", "指定居宅介護支援事業者"),
    /**
     * コード:4 名称:介護保険施設 略称:定義なし
     */
    介護保険施設("4", "介護保険施設"),
    /**
     * コード:5 名称:介護支援専門員 略称:定義なし
     */
    介護支援専門員("5", "介護支援専門員"),
    /**
     * コード:6 名称:他市町村 略称:定義なし
     */
    他市町村("6", "他市町村"),
    /**
     * コード:9 名称:その他 略称:定義なし
     */
    その他("9", "その他");

    private final RString code;
    private final RString fullName;

    private ChosaItakuKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 調査委託区分のコードを返します。
     *
     * @return 調査委託区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 調査委託区分の名称を返します。
     *
     * @return 調査委託区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 調査委託区分のコードと一致する内容を探します。
     *
     * @param code 調査委託区分のコード
     * @return {@code code} に対応する調査委託区分
     */
    public static ChosaItakuKubunCode toValue(RString code) {

        for (ChosaItakuKubunCode chosaItakuKubunCode : ChosaItakuKubunCode.values()) {
            if (chosaItakuKubunCode.code.equals(code)) {
                return chosaItakuKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調査委託区分"));
    }
}
