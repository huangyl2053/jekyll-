package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準日区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum KijunbiKubun {

    /**
     * コード:1 名称:適用開始日 略称:定義なし
     */
    適用開始日("1", "適用開始日"),
    /**
     * コード:2 名称:適用開始届出日 略称:定義なし
     */
    適用開始届出日("2", "適用開始届出日");

    private final RString code;
    private final RString fullName;

    private KijunbiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 基準日区分のコードを返します。
     *
     * @return 基準日区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 基準日区分の名称を返します。
     *
     * @return 基準日区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 基準日区分のコードと一致する内容を探します。
     *
     * @param code 基準日区分のコード
     * @return {@code code} に対応する基準日区分
     */
    public static KijunbiKubun toValue(RString code) {
        for (KijunbiKubun kijunbiKubun : KijunbiKubun.values()) {
            if (kijunbiKubun.code.equals(code)) {
                return kijunbiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("基準日区分"));
    }
}
