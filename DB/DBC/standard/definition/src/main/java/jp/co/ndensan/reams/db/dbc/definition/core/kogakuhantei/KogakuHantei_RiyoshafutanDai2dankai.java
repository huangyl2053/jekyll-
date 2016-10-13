package jp.co.ndensan.reams.db.dbc.definition.core.kogakuhantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額判定根拠_利用者負担第２段階を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 xuyue
 */
public enum KogakuHantei_RiyoshafutanDai2dankai {

    /**
     * コード:1 名称:利用者負担第２段階該当あり 略称:２
     */
    利用者負担第２段階該当あり("1", "利用者負担第２段階該当あり", "２"),
    /**
     * コード:2 名称:利用者負担第２段階該当なし 略称:"　"
     */
    利用者負担第２段階該当なし("2", "利用者負担第２段階該当なし", "　");

    private final RString code;
    private final RString fullName;
    private final RString hyojiName;

    private KogakuHantei_RiyoshafutanDai2dankai(String code, String fullname, String hyojiName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.hyojiName = new RString(hyojiName);
    }

    /**
     * 高額判定根拠_利用者負担第２段階のコードを返します。
     *
     * @return 高額判定根拠_利用者負担第２段階のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額判定根拠_利用者負担第２段階の名称を返します。
     *
     * @return 高額判定根拠_利用者負担第２段階の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額判定根拠_利用者負担第２段階の略称を返します。
     *
     * @return 高額判定根拠_利用者負担第２段階の略称
     */
    public RString get略称() {
        return hyojiName;
    }

    /**
     * 高額判定根拠_利用者負担第２段階のコードと一致する内容を探します。
     *
     * @param code 高額判定根拠_利用者負担第２段階のコード
     * @return {@code code} に対応する高額判定根拠_利用者負担第２段階
     */
    public static KogakuHantei_RiyoshafutanDai2dankai toValue(RString code) {

        for (KogakuHantei_RiyoshafutanDai2dankai kogakuHantei_TsukiokureKubun : KogakuHantei_RiyoshafutanDai2dankai.values()) {
            if (kogakuHantei_TsukiokureKubun.code.equals(code)) {
                return kogakuHantei_TsukiokureKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額判定根拠_利用者負担第２段階のコード"));
    }
}
