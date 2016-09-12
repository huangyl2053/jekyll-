package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生保先頭出力を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum SeihoSentoShutsuOutput {

    /**
     * コード:0 名称:出力しない 略称:定義なし
     */
    出力しない("0", "出力しない"),
    /**
     * コード:1 名称:出力する 略称:定義なし
     */
    出力する("1", "出力する");

    private final RString code;
    private final RString fullName;

    private SeihoSentoShutsuOutput(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 生保先頭出力のコードを返します。
     *
     * @return 生保先頭出力のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 生保先頭出力の名称を返します。
     *
     * @return 生保先頭出力の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 生保先頭出力のコードと一致する内容を探します。
     *
     * @param code 生保先頭出力のコード
     * @return {@code code} に対応する生保先頭出力
     */
    public static SeihoSentoShutsuOutput toValue(RString code) {
        for (SeihoSentoShutsuOutput seihoSentoShutsuOutput : SeihoSentoShutsuOutput.values()) {
            if (seihoSentoShutsuOutput.code.equals(code)) {
                return seihoSentoShutsuOutput;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("生保先頭出力"));
    }
}
