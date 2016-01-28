package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 引渡し区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum HikiwatashiKubun {

    /**
     * コード:0 名称:引渡し未 略称:定義なし
     */
    引渡し未("0", "引渡し未"),
    /**
     * コード:1 名称:引渡し済 略称:定義なし
     */
    引渡し済("1", "引渡し済");

    private final RString code;
    private final RString fullName;

    private HikiwatashiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 引渡し区分のコードを返します。
     *
     * @return 引渡し区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 引渡し区分の名称を返します。
     *
     * @return 引渡し区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 引渡し区分のコードと一致する内容を探します。
     *
     * @param code 引渡し区分のコード
     * @return {@code code} に対応する引渡し区分
     */
    public static HikiwatashiKubun toValue(RString code) {

        for (HikiwatashiKubun hikiwatashiKubun : HikiwatashiKubun.values()) {
            if (hikiwatashiKubun.code.equals(code)) {
                return hikiwatashiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("引渡し区分"));
    }
}
