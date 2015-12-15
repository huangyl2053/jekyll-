package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文文字サイズを表す列挙型です。
 *
 * @author LDNS
 */
public enum TeikeibunMojiSize {

    /**
     * コード:1 名称:フォント小 略称:定義なし
     */
    フォント小("1", "フォント小"),
    /**
     * コード:2 名称:フォント大 略称:定義なし
     */
    フォント大("2", "フォント大"),
    /**
     * コード:3 名称:フォント上小下大 略称:定義なし
     */
    フォント上小下大("3", "フォント上小下大"),
    /**
     * コード:4 名称:フォント上大下小 略称:定義なし
     */
    フォント上大下小("4", "フォント上大下小");

    private final RString code;
    private final RString fullName;

    private TeikeibunMojiSize(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 定型文文字サイズのコードを返します。
     *
     * @return 定型文文字サイズのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 定型文文字サイズの名称を返します。
     *
     * @return 定型文文字サイズの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 定型文文字サイズのコードと一致する内容を探します。
     *
     * @param code 定型文文字サイズのコード
     * @return {@code code} に対応する定型文文字サイズ
     */
    public static TeikeibunMojiSize toValue(RString code) {

        for (TeikeibunMojiSize teikeibunMojiSize : TeikeibunMojiSize.values()) {
            if (teikeibunMojiSize.code.equals(code)) {
                return teikeibunMojiSize;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("定型文文字サイズ"));
    }
}
