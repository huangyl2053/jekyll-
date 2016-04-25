package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.shokan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定状況を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KetteiJokyo {

    /**
     * コード:0 名称:すべて 略称:支給区分の判定を行わない
     */
    支給区分の判定を行わない("0", "すべて", "支給区分の判定を行わない"),
    /**
     * コード:1 名称:支給分のみ 略称:支給決定されたデータのみ抽出
     */
    支給決定されたデータのみ抽出("1", "支給分のみ", "支給決定されたデータのみ抽出"),
    /**
     * コード:2 名称:不支給分のみ 略称:不支給決定されたデータのみ抽出
     */
    不支給決定されたデータのみ抽出("2", "不支給分のみ", "不支給決定されたデータのみ抽出");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KetteiJokyo(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 決定状況のコードを返します。
     *
     * @return 決定状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 決定状況の名称を返します。
     *
     * @return 決定状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 決定状況の略称を返します。
     *
     * @return 決定状況の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 決定状況のコードと一致する内容を探します。
     *
     * @param code 決定状況のコード
     * @return {@code code} に対応する決定状況
     */
    public static KetteiJokyo toValue(RString code) {
        for (KetteiJokyo ketteiJokyo : KetteiJokyo.values()) {
            if (ketteiJokyo.code.equals(code)) {
                return ketteiJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定状況"));
    }
}
