package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 単票発行区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TanpyoHakkoKubun {

    /**
     * コード:1 名称:出力しない 略称:定義なし
     */
    出力しない("1", "出力しない"),
    /**
     * コード:0 名称:出力する 略称:定義なし
     */
    出力する("0", "出力する");

    private final RString code;
    private final RString fullName;

    private TanpyoHakkoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 単票発行区分のコードを返します。
     *
     * @return 単票発行区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 単票発行区分の名称を返します。
     *
     * @return 単票発行区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 単票発行区分のコードと一致する内容を探します。
     *
     * @param code 単票発行区分のコード
     * @return {@code code} に対応する単票発行区分
     */
    public static TanpyoHakkoKubun toValue(RString code) {
        for (TanpyoHakkoKubun tanpyoHakkoKubun : TanpyoHakkoKubun.values()) {
            if (tanpyoHakkoKubun.code.equals(code)) {
                return tanpyoHakkoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("単票発行区分"));
    }
}
