package jp.co.ndensan.reams.db.dbc.definition.core.kogakuhantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額判定根拠_激変緩和区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 xuyue
 */
public enum KogakuHantei_GekihenkanwaKubun {

    /**
     * コード:1 名称:激変緩和該当無し 略称:"　"
     */
    激変緩和該当無し("1", "激変緩和該当無し", "　"),
    /**
     * コード:2 名称:激変緩和第1段階 略称:"緩１"
     */
    激変緩和第1段階("2", "激変緩和第1段階", "緩１"),
    /**
     * コード:2 名称:激変緩和第2段階 略称:"緩２"
     */
    激変緩和第2段階("3", "激変緩和第2段階", "緩２");

    private final RString code;
    private final RString fullName;
    private final RString hyojiName;

    private KogakuHantei_GekihenkanwaKubun(String code, String fullname, String hyojiName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.hyojiName = new RString(hyojiName);
    }

    /**
     * 高額判定根拠_激変緩和区分のコードを返します。
     *
     * @return 高額判定根拠_激変緩和区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額判定根拠_激変緩和区分の名称を返します。
     *
     * @return 高額判定根拠_激変緩和区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額判定根拠_激変緩和区分の略称を返します。
     *
     * @return 高額判定根拠_激変緩和区分の略称
     */
    public RString get略称() {
        return hyojiName;
    }

    /**
     * 高額判定根拠_激変緩和区分のコードと一致する内容を探します。
     *
     * @param code 高額判定根拠_激変緩和区分のコード
     * @return {@code code} に対応する高額判定根拠_激変緩和区分
     */
    public static KogakuHantei_GekihenkanwaKubun toValue(RString code) {

        for (KogakuHantei_GekihenkanwaKubun kogakuHantei_TsukiokureKubun : KogakuHantei_GekihenkanwaKubun.values()) {
            if (kogakuHantei_TsukiokureKubun.code.equals(code)) {
                return kogakuHantei_TsukiokureKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額判定根拠_激変緩和区分のコード"));
    }
}
