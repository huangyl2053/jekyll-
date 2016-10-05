package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 番号制度_機能使用制御を表す列挙型です。
 *
 *  @reamsid_L DBU-9999-023 sunhaidi
 */
public enum BangoseidoKinoShiyoSeigyo {

    /**
     * コード:0 名称:未稼働 略称:定義なし
     */
    未稼働("0", "未稼働"),

    /**
     * コード:1 名称:稼働 略称:定義なし
     */
    稼働("1", "稼働");

    private final RString code;
    private final RString fullName;

    private BangoseidoKinoShiyoSeigyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 番号制度_機能使用制御のコードを返します。
     *
     * @return 番号制度_機能使用制御のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 番号制度_機能使用制御の名称を返します。
     *
     * @return 番号制度_機能使用制御の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 番号制度_機能使用制御のコードと一致する内容を探します。
     *
     * @param code 番号制度_機能使用制御のコード
     * @return {@code code} に対応する番号制度_機能使用制御
     */
    public static BangoseidoKinoShiyoSeigyo toValue(RString code) {
        for (BangoseidoKinoShiyoSeigyo bangoseidoKinoShiyoSeigyo : BangoseidoKinoShiyoSeigyo.values()) {
            if (bangoseidoKinoShiyoSeigyo.code.equals(code)) {
                return bangoseidoKinoShiyoSeigyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
