package jp.co.ndensan.reams.db.dbd.definition.core.kanri;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サンプル文書グループコードを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 xuyue
 */
public enum SampleBunshoGroupCodes {

    /**
     * コード:1002 名称:減免減額_承認しない理由 略称:定義なし
     */
    減免減額_承認しない理由("1002", "減免減額_承認しない理由");

    private final RString code;
    private final RString fullName;

    private SampleBunshoGroupCodes(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サンプル文書グループコードのコードを返します。
     *
     * @return サンプル文書グループコードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * サンプル文書グループコードの名称を返します。
     *
     * @return サンプル文書グループコードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サンプル文書グループコードのコードと一致する内容を探します。
     *
     * @param code サンプル文書グループコードのコード
     * @return {@code code} に対応するサンプル文書グループコード
     */
    public static SampleBunshoGroupCodes toValue(RString code) {
        for (SampleBunshoGroupCodes sampleBunshoGroupCodes : SampleBunshoGroupCodes.values()) {
            if (sampleBunshoGroupCodes.code.equals(code)) {
                return sampleBunshoGroupCodes;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サンプル文書グループコード"));
    }
}
