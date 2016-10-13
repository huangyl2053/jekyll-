package jp.co.ndensan.reams.db.dbc.definition.core.kogakuhantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額判定根拠_老齢福祉年金を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 xuyue
 */
public enum KogakuHantei_Roreifukushinenkin {

    /**
     * コード:1 名称:老齢福祉年金受給あり 略称:老
     */
    老齢福祉年金受給あり("1", "老齢福祉年金受給あり", "老"),
    /**
     * コード:2 名称:老齢福祉年金受給なし 略称:"　"
     */
    老齢福祉年金受給なし("2", "老齢福祉年金受給なし", "　");

    private final RString code;
    private final RString fullName;
    private final RString hyojiName;

    private KogakuHantei_Roreifukushinenkin(String code, String fullname, String hyojiName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.hyojiName = new RString(hyojiName);
    }

    /**
     * 高額判定根拠_老齢福祉年金のコードを返します。
     *
     * @return 高額判定根拠_老齢福祉年金のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額判定根拠_老齢福祉年金の名称を返します。
     *
     * @return 高額判定根拠_老齢福祉年金の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額判定根拠_老齢福祉年金の略称を返します。
     *
     * @return 高額判定根拠_老齢福祉年金の略称
     */
    public RString get略称() {
        return hyojiName;
    }

    /**
     * 高額判定根拠_老齢福祉年金のコードと一致する内容を探します。
     *
     * @param code 高額判定根拠_老齢福祉年金のコード
     * @return {@code code} に対応する高額判定根拠_老齢福祉年金
     */
    public static KogakuHantei_Roreifukushinenkin toValue(RString code) {

        for (KogakuHantei_Roreifukushinenkin kogakuHantei_TsukiokureKubun : KogakuHantei_Roreifukushinenkin.values()) {
            if (kogakuHantei_TsukiokureKubun.code.equals(code)) {
                return kogakuHantei_TsukiokureKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額判定根拠_老齢福祉年金のコード"));
    }
}
