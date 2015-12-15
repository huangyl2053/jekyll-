package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 外部出力データ区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum Datakubun {

    /**
     * コード:1 名称:申請情報 略称:定義なし
     */
    申請情報("1", "申請情報"),
    /**
     * コード:2 名称:4マスタ 略称:定義なし
     */
    _4マスタ("2", "4マスタ"),
    /**
     * コード:3 名称:資格喪失（死亡）情報 略称:定義なし
     */
    資格喪失_死亡_情報("3", "資格喪失（死亡）情報");

    private final RString code;
    private final RString fullName;

    private Datakubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 外部出力データ区分のコードを返します。
     *
     * @return 外部出力データ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 外部出力データ区分の名称を返します。
     *
     * @return 外部出力データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 外部出力データ区分のコードと一致する内容を探します。
     *
     * @param code 外部出力データ区分のコード
     * @return {@code code} に対応する外部出力データ区分
     */
    public static Datakubun toValue(RString code) {

        for (Datakubun datakubun : Datakubun.values()) {
            if (datakubun.code.equals(code)) {
                return datakubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("外部出力データ"));
    }
}
