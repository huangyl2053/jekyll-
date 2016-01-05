package jp.co.ndensan.reams.db.dbz.definition.core.teikeibun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum TeikeibunKubun {

    /**
     * コード:0 名称:特記事項 略称:定義なし
     */
    特記事項("0", "特記事項"),
    /**
     * コード:1 名称:特記事項以外 略称:定義なし
     */
    特記事項以外("1", "特記事項以外");

    private final RString code;
    private final RString fullName;

    private TeikeibunKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 定型文区分のコードを返します。
     *
     * @return 定型文区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 定型文区分の名称を返します。
     *
     * @return 定型文区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 定型文区分のコードと一致する内容を探します。
     *
     * @param code 定型文区分のコード
     * @return {@code code} に対応する定型文区分
     */
    public static TeikeibunKubun toValue(RString code) {

        for (TeikeibunKubun teikeibunKubun : TeikeibunKubun.values()) {
            if (teikeibunKubun.code.equals(code)) {
                return teikeibunKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("定型文区分"));
    }
}
