package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 番号制度_使用制御を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum BangoseidoShiyoSeigyo {

    /**
     * コード:1 名称:使用する 略称:定義なし
     */
    使用する("1", "使用する"),

    /**
     * コード:2 名称:使用しない 略称:定義なし
     */
    使用しない("2", "使用しない");

    private final RString code;
    private final RString fullName;

    private BangoseidoShiyoSeigyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 番号制度_使用制御のコードを返します。
     *
     * @return 番号制度_使用制御のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 番号制度_使用制御の名称を返します。
     *
     * @return 番号制度_使用制御の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 番号制度_使用制御のコードと一致する内容を探します。
     *
     * @param code 番号制度_使用制御のコード
     * @return {@code code} に対応する番号制度_使用制御
     */
    public static BangoseidoShiyoSeigyo toValue(RString code) {
        for (BangoseidoShiyoSeigyo bangoseidoShiyoSeigyo : BangoseidoShiyoSeigyo.values()) {
            if (bangoseidoShiyoSeigyo.code.equals(code)) {
                return bangoseidoShiyoSeigyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
