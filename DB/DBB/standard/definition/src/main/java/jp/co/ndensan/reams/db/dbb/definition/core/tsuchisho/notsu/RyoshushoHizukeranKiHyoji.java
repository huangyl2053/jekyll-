package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領収書日付欄期表示を表す列挙型です。
 *
 * @author LDNS
 */
public enum RyoshushoHizukeranKiHyoji {

    /**
     * コード:0 名称:表示しない 略称:定義なし
     */
    表示しない("0", "表示しない"),
    /**
     * コード:1 名称:期表示 略称:定義なし
     */
    期表示("1", "期表示"),
    /**
     * コード:2 名称:月表示 略称:定義なし
     */
    月表示("2", "月表示");

    private final RString code;
    private final RString fullName;

    private RyoshushoHizukeranKiHyoji(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 領収書日付欄期表示のコードを返します。
     *
     * @return 領収書日付欄期表示のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 領収書日付欄期表示の名称を返します。
     *
     * @return 領収書日付欄期表示の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 領収書日付欄期表示のコードと一致する内容を探します。
     *
     * @param code 領収書日付欄期表示のコード
     * @return {@code code} に対応する領収書日付欄期表示
     */
    public static RyoshushoHizukeranKiHyoji toValue(RString code) {
        for (RyoshushoHizukeranKiHyoji ryoshushoHizukeranKiHyoji : RyoshushoHizukeranKiHyoji.values()) {
            if (ryoshushoHizukeranKiHyoji.code.equals(code)) {
                return ryoshushoHizukeranKiHyoji;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("領収書日付欄期表示"));
    }
}
