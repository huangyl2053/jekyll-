package jp.co.ndensan.reams.db.dbc.definition.core.kogakuhantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額判定根拠_月遅れ区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 xuyue
 */
public enum KogakuHantei_TsukiokureKubun {

    /**
     * コード:1 名称:月遅れあり 略称:月
     */
    月遅れあり("1", "月遅れあり", "月"),
    /**
     * コード:2 名称:月遅れなし 略称:"　"
     */
    月遅れなし("2", "月遅れなし", "　");

    private final RString code;
    private final RString fullName;
    private final RString hyojiName;

    private KogakuHantei_TsukiokureKubun(String code, String fullname, String hyojiName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.hyojiName = new RString(hyojiName);
    }

    /**
     * 高額判定根拠_月遅れ区分のコードを返します。
     *
     * @return 高額判定根拠_月遅れ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額判定根拠_月遅れ区分の名称を返します。
     *
     * @return 高額判定根拠_月遅れ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額判定根拠_月遅れ区分の略称を返します。
     *
     * @return 高額判定根拠_月遅れ区分の略称
     */
    public RString get略称() {
        return hyojiName;
    }

    /**
     * 高額判定根拠_月遅れ区分のコードと一致する内容を探します。
     *
     * @param code 高額判定根拠_月遅れ区分のコード
     * @return {@code code} に対応する高額判定根拠_月遅れ区分
     */
    public static KogakuHantei_TsukiokureKubun toValue(RString code) {

        for (KogakuHantei_TsukiokureKubun kogakuHantei_TsukiokureKubun : KogakuHantei_TsukiokureKubun.values()) {
            if (kogakuHantei_TsukiokureKubun.code.equals(code)) {
                return kogakuHantei_TsukiokureKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額判定根拠_月遅れ区分のコード"));
    }
}
