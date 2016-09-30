package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計表_対象年月を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Tokeihyo_TaishoNengetsu {

    /**
     * コード:1 名称:サービス提供年月 略称:定義なし
     */
    サービス提供年月("1", "サービス提供年月"),
    /**
     * コード:2 名称:審査年月 略称:定義なし
     */
    審査年月("2", "審査年月");

    private final RString code;
    private final RString fullName;

    private Tokeihyo_TaishoNengetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 統計表_対象年月のコードを返します。
     *
     * @return 統計表_対象年月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 統計表_対象年月の名称を返します。
     *
     * @return 統計表_対象年月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 統計表_対象年月のコードと一致する内容を探します。
     *
     * @param code 統計表_対象年月のコード
     * @return {@code code} に対応する統計表_対象年月
     */
    public static Tokeihyo_TaishoNengetsu toValue(RString code) {
        for (Tokeihyo_TaishoNengetsu tokeihyo_TaishoNengetsu : Tokeihyo_TaishoNengetsu.values()) {
            if (tokeihyo_TaishoNengetsu.code.equals(code)) {
                return tokeihyo_TaishoNengetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("統計表_対象年月"));
    }
}
