package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_費用総額集計パターンを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum RiyojokyoTokeihyo_HiyoSogakuShukeiPattern {

    /**
     * コード:1 名称:計算 略称:定義なし
     */
    計算("1", "計算"),
    /**
     * コード:2 名称:保険請求額 略称:定義なし
     */
    保険請求額("2", "保険請求額"),
    /**
     * コード:3 名称:保険請求額_利用者負担額 略称:定義なし
     */
    保険請求額_利用者負担額("3", "保険請求額_利用者負担額"),
    /**
     * コード:"" 名称:加算対象外 略称:定義なし
     */
    加算対象外("", "加算対象外");

    private final RString code;
    private final RString fullName;

    private RiyojokyoTokeihyo_HiyoSogakuShukeiPattern(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用状況統計表_費用総額集計パターンのコードを返します。
     *
     * @return 利用状況統計表_費用総額集計パターンのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_費用総額集計パターンの名称を返します。
     *
     * @return 利用状況統計表_費用総額集計パターンの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_費用総額集計パターンのコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_費用総額集計パターンのコード
     * @return {@code code} に対応する利用状況統計表_費用総額集計パターン
     */
    public static RiyojokyoTokeihyo_HiyoSogakuShukeiPattern toValue(RString code) {
        for (RiyojokyoTokeihyo_HiyoSogakuShukeiPattern value : RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
