package jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免・徴収猶予作成区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum GemmenChoshuYuyoSakuseiKubun {

    /**
     * コード:0 名称:申請 略称:定義なし
     */
    申請("0", "申請"),
    /**
     * コード:1 名称:決定_承認 略称:定義なし
     */
    決定_承認("1", "決定_承認"),
    /**
     * コード:2 名称:決定_不承認 略称:定義なし
     */
    決定_不承認("2", "決定_不承認"),
    /**
     * コード:3 名称:取消 略称:定義なし
     */
    取消("3", "取消"),
    /**
     * コード:4 名称:訂正 略称:定義なし
     */
    訂正("4", "訂正"),
    /**
     * コード:9 名称:論理削除 略称:定義なし
     */
    論理削除("9", "論理削除");

    private final RString code;
    private final RString fullName;

    private GemmenChoshuYuyoSakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 減免・徴収猶予作成区分のコードを返します。
     *
     * @return 減免・徴収猶予作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 減免・徴収猶予作成区分の名称を返します。
     *
     * @return 減免・徴収猶予作成区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 減免・徴収猶予作成区分のコードと一致する内容を探します。
     *
     * @param code 減免・徴収猶予作成区分のコード
     * @return {@code code} に対応する減免・徴収猶予作成区分
     */
    public static GemmenChoshuYuyoSakuseiKubun toValue(RString code) {
        for (GemmenChoshuYuyoSakuseiKubun gemmenChoshuYuyoSakuseiKubun : GemmenChoshuYuyoSakuseiKubun.values()) {
            if (gemmenChoshuYuyoSakuseiKubun.code.equals(code)) {
                return gemmenChoshuYuyoSakuseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("減免・徴収猶予作成区分"));
    }
}
