package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平準化変更通知書出力条件を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum HeijunkaHenkoOutputJoken {

    /**
     * コード:1 名称:全件_追加候補者含む 略称：全件（追加候補者含む）
     */
    全件_追加候補者含む("1", "全件_追加候補者含む", "全件（追加候補者含む）"),
    /**
     * コード:2 名称:全件_追加候補者含まない 略称:全件（追加候補者含まない）
     */
    全件_追加候補者含まない("2", "全件_追加候補者含まない", "全件（追加候補者含まない）"),
    /**
     * コード:3 名称:追加候補者のみ 略称:追加候補者のみ
     */
    追加候補者のみ("3", "追加候補者のみ", "追加候補者のみ");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HeijunkaHenkoOutputJoken(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 平準化変更通知書出力条件のコードを返します。
     *
     * @return 平準化変更通知書出力条件のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 平準化変更通知書出力条件の名称を返します。
     *
     * @return 平準化変更通知書出力条件の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 平準化変更通知書出力条件の略称を返します。
     *
     * @return 平準化変更通知書出力条件の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 平準化変更通知書出力条件のコードと一致する内容を探します。
     *
     * @param code 平準化変更通知書出力条件のコード
     * @return {@code code} に対応する平準化変更通知書出力条件
     */
    public static HeijunkaHenkoOutputJoken toValue(RString code) {
        for (HeijunkaHenkoOutputJoken heijunkaHenkoOutputJoken : HeijunkaHenkoOutputJoken.values()) {
            if (heijunkaHenkoOutputJoken.code.equals(code)) {
                return heijunkaHenkoOutputJoken;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("平準化変更通知書出力条件"));
    }
}
