package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告年報補正表示を表す列挙型です。
 *
 * @author LDNS
 */
public enum JigyohokokuNenpoHoseiHyoji {

    /**
     * コード:001 名称:保険者／所得段階別第１号被保険者数 略称:定義なし
     */
    保険者_所得段階別第１号被保険者数("001", "保険者／所得段階別第１号被保険者数"),
    /**
     * コード:101 名称:構成市町村／所得段階別第１号被保険者数 略称:定義なし
     */
    構成市町村_所得段階別第１号被保険者数("101", "構成市町村／所得段階別第１号被保険者数"),
    /**
     * コード:201 名称:旧市町村／所得段階別第１号被保険者数 略称:定義なし
     */
    旧市町村_所得段階別第１号被保険者数("201", "旧市町村／所得段階別第１号被保険者数"),
    /**
     * コード:002 名称:保険者／現物分／市町村特別給付 略称:定義なし
     */
    保険者_現物分_市町村特別給付("002", "保険者／現物分／市町村特別給付"),
    /**
     * コード:102 名称:構成市町村／現物分／市町村特別給付 略称:定義なし
     */
    構成市町村_現物分_市町村特別給付("102", "構成市町村／現物分／市町村特別給付"),
    /**
     * コード:202 名称:旧市町村／現物分／市町村特別給付 略称:定義なし
     */
    旧市町村_現物分_市町村特別給付("202", "旧市町村／現物分／市町村特別給付"),
    /**
     * コード:003 名称:保険者／保険料収納状況・保険給付支払状況 略称:定義なし
     */
    保険者_保険料収納状況_保険給付支払状況("003", "保険者／保険料収納状況・保険給付支払状況"),
    /**
     * コード:103 名称:構成市町村／保険料収納状況・保険給付支払状況 略称:定義なし
     */
    構成市町村_保険料収納状況_保険給付支払状況("103", "構成市町村／保険料収納状況・保険給付支払状況"),
    /**
     * コード:203 名称:旧市町村／保険料収納状況・保険給付支払状況 略称:定義なし
     */
    旧市町村_保険料収納状況_保険給付支払状況("203", "旧市町村／保険料収納状況・保険給付支払状況");

    private final RString code;
    private final RString fullName;

    private JigyohokokuNenpoHoseiHyoji(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業報告年報補正表示のコードを返します。
     *
     * @return 事業報告年報補正表示のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業報告年報補正表示の名称を返します。
     *
     * @return 事業報告年報補正表示の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業報告年報補正表示のコードと一致する内容を探します。
     *
     * @param code 事業報告年報補正表示のコード
     * @return {@code code} に対応する事業報告年報補正表示
     */
    public static JigyohokokuNenpoHoseiHyoji toValue(RString code) {

        for (JigyohokokuNenpoHoseiHyoji jigyohokokuNenpoHoseiHyoji : JigyohokokuNenpoHoseiHyoji.values()) {
            if (jigyohokokuNenpoHoseiHyoji.code.equals(code)) {
                return jigyohokokuNenpoHoseiHyoji;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業報告年報補正表示"));
    }
}
