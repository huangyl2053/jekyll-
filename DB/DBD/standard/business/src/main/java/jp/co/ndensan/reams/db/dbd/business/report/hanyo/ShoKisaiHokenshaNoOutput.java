package jp.co.ndensan.reams.db.dbd.business.report.hanyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証記載保険者番号印字有無を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ShoKisaiHokenshaNoOutput {

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

    private ShoKisaiHokenshaNoOutput(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 証記載保険者番号印字有無のコードを返します。
     *
     * @return 証記載保険者番号印字有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 証記載保険者番号印字有無の名称を返します。
     *
     * @return 証記載保険者番号印字有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 証記載保険者番号印字有無のコードと一致する内容を探します。
     *
     * @param code 証記載保険者番号印字有無のコード
     * @return {@code code} に対応する証記載保険者番号印字有無
     */
    public static ShoKisaiHokenshaNoOutput toValue(RString code) {
        for (ShoKisaiHokenshaNoOutput shoKisaiHokenshaNoOutput : ShoKisaiHokenshaNoOutput.values()) {
            if (shoKisaiHokenshaNoOutput.code.equals(code)) {
                return shoKisaiHokenshaNoOutput;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("証記載保険者番号印字有無"));
    }
}
