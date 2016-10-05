package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新規異動区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum ShinkiIdoKubun {

    /**
     * コード:1 名称:当初 略称:定義なし
     */
    当初("1", "当初"),
    /**
     * コード:2 名称:版改定 略称:定義なし
     */
    版改定("2", "版改定"),
    /**
     * コード:3 名称:再登録 略称:定義なし
     */
    再登録("3", "再登録"),
    /**
     * コード:4 名称:異動 略称:定義なし
     */
    異動("4", "異動");

    private final RString code;
    private final RString fullName;

    private ShinkiIdoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 新規異動区分のコードを返します。
     *
     * @return 新規異動区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 新規異動区分の名称を返します。
     *
     * @return 新規異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 新規異動区分のコードと一致する内容を探します。
     *
     * @param code 新規異動区分のコード
     * @return {@code code} に対応する新規異動区分
     */
    public static ShinkiIdoKubun toValue(RString code) {
        for (ShinkiIdoKubun shinkiIdoKubun : ShinkiIdoKubun.values()) {
            if (shinkiIdoKubun.code.equals(code)) {
                return shinkiIdoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
