package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_共同_高額_世帯所得区分コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 xuyue
 */
public enum JukyushaIF_KyodoKogakuSetaiShotokuKubunCode {

    /**
     * コード:1 名称:一般 略称:低
     */
    一般("1", "一般", "低"),
    /**
     * コード:2 名称:市町村民税世帯非課税者等 略称:市
     */
    市町村民税世帯非課税者等("2", "市町村民税世帯非課税者等", "市"),
    /**
     * コード:3 名称:生活保護 略称:生
     */
    生活保護("3", "生活保護", "生"),
    /**
     * コード:2 名称:現役並み所得相当 略称:現
     */
    現役並み所得相当("4", "現役並み所得相当", "現");

    private final RString code;
    private final RString fullName;
    private final RString hyojiName;

    private JukyushaIF_KyodoKogakuSetaiShotokuKubunCode(String code, String fullname, String hyojiName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.hyojiName = new RString(hyojiName);
    }

    /**
     * 受給者IF_共同_高額_世帯所得区分コードのコードを返します。
     *
     * @return 受給者IF_共同_高額_世帯所得区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_共同_高額_世帯所得区分コードの名称を返します。
     *
     * @return 受給者IF_共同_高額_世帯所得区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_共同_高額_世帯所得区分コードの略称を返します。
     *
     * @return 受給者IF_共同_高額_世帯所得区分コードの略称
     */
    public RString get略称() {
        return hyojiName;
    }

    /**
     * 受給者IF_共同_高額_世帯所得区分コードのコードと一致する内容を探します。
     *
     * @param code 受給者IF_共同_高額_世帯所得区分コードのコード
     * @return {@code code} に対応する受給者IF_共同_高額_世帯所得区分コード
     */
    public static JukyushaIF_KyodoKogakuSetaiShotokuKubunCode toValue(RString code) {

        for (JukyushaIF_KyodoKogakuSetaiShotokuKubunCode jukyushaIF : JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_共同_高額_世帯所得区分コードのコード"));
    }
}
