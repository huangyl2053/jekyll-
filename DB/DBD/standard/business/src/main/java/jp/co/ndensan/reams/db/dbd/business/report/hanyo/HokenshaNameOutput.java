package jp.co.ndensan.reams.db.dbd.business.report.hanyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者名表示を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HokenshaNameOutput {

    /**
     * コード:0 名称:印字しない 略称:定義なし
     */
    印字しない("0", "印字しない"),
    /**
     * コード:1 名称:印字する 略称:定義なし
     */
    印字する("1", "印字する");

    private final RString code;
    private final RString fullName;

    private HokenshaNameOutput(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 保険者名表示のコードを返します。
     *
     * @return 保険者名表示のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 保険者名表示の名称を返します。
     *
     * @return 保険者名表示の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 保険者名表示のコードと一致する内容を探します。
     *
     * @param code 保険者名表示のコード
     * @return {@code code} に対応する保険者名表示
     */
    public static HokenshaNameOutput toValue(RString code) {
        for (HokenshaNameOutput hokenshaNameOutput : HokenshaNameOutput.values()) {
            if (hokenshaNameOutput.code.equals(code)) {
                return hokenshaNameOutput;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("保険者名表示"));
    }
}
