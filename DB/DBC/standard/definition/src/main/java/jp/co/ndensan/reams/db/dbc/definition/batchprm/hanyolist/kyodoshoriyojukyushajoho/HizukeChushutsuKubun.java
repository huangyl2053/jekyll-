package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyodoshoriyojukyushajoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 日付抽出区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum HizukeChushutsuKubun {

    /**
     * コード:0 名称:すべて 略称:すべて
     */
    すべて("0", "すべて", "すべて"),
    /**
     * コード:1 名称:直近のみ 略称:直近のみ
     */
    直近のみ("1", "直近のみ", "直近のみ"),
    /**
     * コード:2 名称:範囲指定 略称:範囲指定
     */
    範囲指定("2", "範囲指定", "範囲指定");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HizukeChushutsuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 日付抽出区分のコードを返します。
     *
     * @return 日付抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 日付抽出区分の名称を返します。
     *
     * @return 日付抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 日付抽出区分の略称を返します。
     *
     * @return 日付抽出区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 日付抽出区分のコードと一致する内容を探します。
     *
     * @param code 日付抽出区分のコード
     * @return {@code code} に対応する日付抽出区分
     */
    public static HizukeChushutsuKubun toValue(RString code) {
        for (HizukeChushutsuKubun hizukeChushutsuKubun : HizukeChushutsuKubun.values()) {
            if (hizukeChushutsuKubun.code.equals(code)) {
                return hizukeChushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
