package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠CSV_高額を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum KonkyoCsv_Kougaku {

    /**
     * コード:DBU060700 名称:利用者負担第五段階 略称:定義なし
     */
    利用者負担第五段階("DBU060700", "利用者負担第五段階"),
    /**
     * コード:DBU060701 名称:利用者負担第四段階 略称:定義なし
     */
    利用者負担第四段階("DBU060701", "利用者負担第四段階"),
    /**
     * コード:DBU060702 名称:利用者負担第三段階 略称:定義なし
     */
    利用者負担第三段階("DBU060702", "利用者負担第三段階"),
    /**
     * コード:DBU060703 名称:利用者負担第二段階 略称:定義なし
     */
    利用者負担第二段階("DBU060703", "利用者負担第二段階"),
    /**
     * コード:DBU060704 名称:利用者負担第一段階 略称:定義なし
     */
    利用者負担第一段階("DBU060704", "利用者負担第一段階"),
    /**
     * コード:DBU060705 名称:合計 略称:定義なし
     */
    合計("DBU060705", "合計"),
    /**
     * コード:DBU060706 名称:再掲利用者負担第三段階 略称:定義なし
     */
    再掲利用者負担第三段階("DBU060706", "再掲利用者負担第三段階"),
    /**
     * コード:DBU060707 名称:再掲利用者負担第二段階 略称:定義なし
     */
    再掲利用者負担第二段階("DBU060707", "再掲利用者負担第二段階");

    private final RString code;
    private final RString fullName;

    private KonkyoCsv_Kougaku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 根拠CSV_高額のコードを返します。
     *
     * @return 根拠CSV_高額のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 根拠CSV_高額の名称を返します。
     *
     * @return 根拠CSV_高額の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 根拠CSV_高額のコードと一致する内容を探します。
     *
     * @param code 根拠CSV_高額のコード
     * @return {@code code} に対応する根拠CSV_高額
     */
    public static KonkyoCsv_Kougaku toValue(RString code) {
        for (KonkyoCsv_Kougaku konkyoCsv_Kougaku : KonkyoCsv_Kougaku.values()) {
            if (konkyoCsv_Kougaku.code.equals(code)) {
                return konkyoCsv_Kougaku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("根拠CSV_高額"));
    }
}
