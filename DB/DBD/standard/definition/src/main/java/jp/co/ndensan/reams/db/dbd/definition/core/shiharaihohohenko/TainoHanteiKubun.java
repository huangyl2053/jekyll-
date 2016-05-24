package jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 滞納判定区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TainoHanteiKubun {

    /**
     * コード:1 名称:予告登録 略称:定義なし
     */
    予告登録("1", "予告登録"),
    /**
     * コード:2 名称:償還払化登録 略称:定義なし
     */
    償還払化登録("2", "償還払化登録"),
    /**
     * コード:3 名称:差止登録 略称:定義なし
     */
    差止登録("3", "差止登録"),
    /**
     * コード:4 名称:控除登録 略称:定義なし
     */
    控除登録("4", "控除登録"),
    /**
     * コード:5 名称:給付額減額登録 略称:定義なし
     */
    給付額減額登録("5", "給付額減額登録");

    private final RString code;
    private final RString fullName;

    private TainoHanteiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 滞納判定区分のコードを返します。
     *
     * @return 滞納判定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 滞納判定区分の名称を返します。
     *
     * @return 滞納判定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 滞納判定区分のコードと一致する内容を探します。
     *
     * @param code 滞納判定区分のコード
     * @return {@code code} に対応する滞納判定区分
     */
    public static TainoHanteiKubun toValue(RString code) {
        for (TainoHanteiKubun tainoHanteiKubun : TainoHanteiKubun.values()) {
            if (tainoHanteiKubun.code.equals(code)) {
                return tainoHanteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("滞納判定区分"));
    }
}
