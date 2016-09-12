package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 根拠CSV_合算を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum KonkyoCsv_Gassan {

    /**
     * コード:DBU070801 名称:現役並み所得者 略称:定義なし
     */
    現役並み所得者("DBU070801", "現役並み所得者"),
    /**
     * コード:DBU070802 名称:一般 略称:定義なし
     */
    一般("DBU070802", "一般"),
    /**
     * コード:DBU070803 名称:低所得者Ⅱ 略称:定義なし
     */
    低所得者Ⅱ("DBU070803", "低所得者Ⅱ"),
    /**
     * コード:DBU070804 名称:低所得者Ⅰ 略称:定義なし
     */
    低所得者Ⅰ("DBU070804", "低所得者Ⅰ"),
    /**
     * コード:DBU070805 名称:合計 略称:定義なし
     */
    合計("DBU070805", "合計");

    private final RString code;
    private final RString fullName;

    private KonkyoCsv_Gassan(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 根拠CSV_合算のコードを返します。
     *
     * @return 根拠CSV_合算のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 根拠CSV_合算の名称を返します。
     *
     * @return 根拠CSV_合算の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 根拠CSV_合算のコードと一致する内容を探します。
     *
     * @param code 根拠CSV_合算のコード
     * @return {@code code} に対応する根拠CSV_合算
     */
    public static KonkyoCsv_Gassan toValue(RString code) {
        for (KonkyoCsv_Gassan konkyoCsv_Gassan : KonkyoCsv_Gassan.values()) {
            if (konkyoCsv_Gassan.code.equals(code)) {
                return konkyoCsv_Gassan;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("根拠CSV_合算"));
    }
}
