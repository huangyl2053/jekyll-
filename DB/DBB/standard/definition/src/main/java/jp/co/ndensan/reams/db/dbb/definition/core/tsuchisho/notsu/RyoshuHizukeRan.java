package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領収日付欄を表す列挙型です。
 *
 * @author LDNS
 */
public enum RyoshuHizukeRan {

    /**
     * コード:0 名称:何も表示しない 略称:定義なし
     */
    何も表示しない("0", "何も表示しない"),
    /**
     * コード:1 名称:期で出力する 略称:定義なし
     */
    期で出力する("1", "期で出力する"),
    /**
     * コード:2 名称:月で出力する 略称:定義なし
     */
    月で出力する("2", "月で出力する");

    private final RString code;
    private final RString fullName;

    private RyoshuHizukeRan(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 領収日付欄のコードを返します。
     *
     * @return 領収日付欄のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 領収日付欄の名称を返します。
     *
     * @return 領収日付欄の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 領収日付欄のコードと一致する内容を探します。
     *
     * @param code 領収日付欄のコード
     * @return {@code code} に対応する領収日付欄
     */
    public static RyoshuHizukeRan toValue(RString code) {
        for (RyoshuHizukeRan ryoshuHizukeRan : RyoshuHizukeRan.values()) {
            if (ryoshuHizukeRan.code.equals(code)) {
                return ryoshuHizukeRan;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("領収日付欄"));
    }
}
