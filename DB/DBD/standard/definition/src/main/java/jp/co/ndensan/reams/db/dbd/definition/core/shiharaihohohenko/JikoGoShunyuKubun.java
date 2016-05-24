package jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 時効後収入区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum JikoGoShunyuKubun {

    /**
     * コード:空 名称:なし 略称:定義なし
     */
    なし(RString.EMPTY.toString(), "なし"),
    /**
     * コード:1 名称:あり 略称:定義なし
     */
    あり("1", "あり");

    private final RString code;
    private final RString fullName;

    private JikoGoShunyuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 時効後収入区分のコードを返します。
     *
     * @return 時効後収入区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 時効後収入区分の名称を返します。
     *
     * @return 時効後収入区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 時効後収入区分のコードと一致する内容を探します。
     *
     * @param code 時効後収入区分のコード
     * @return {@code code} に対応する時効後収入区分
     */
    public static JikoGoShunyuKubun toValue(RString code) {
        for (JikoGoShunyuKubun jikoGoShunyuKubun : JikoGoShunyuKubun.values()) {
            if (jikoGoShunyuKubun.code.equals(code)) {
                return jikoGoShunyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("時効後収入区分"));
    }
}
