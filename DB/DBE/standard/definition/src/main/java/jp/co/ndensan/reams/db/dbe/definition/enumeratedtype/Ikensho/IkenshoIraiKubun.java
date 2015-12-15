package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書依頼区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum IkenshoIraiKubun {

    /**
     * コード:1 名称:初回依頼 略称:定義なし
     */
    初回依頼("1", "初回依頼"),
    /**
     * コード:2 名称:再依頼 略称:定義なし
     */
    再依頼("2", "再依頼"),
    /**
     * コード:3 名称:再意見書 略称:定義なし
     */
    再意見書("3", "再意見書");

    private final RString code;
    private final RString fullName;

    private IkenshoIraiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 主治医意見書依頼区分のコードを返します。
     *
     * @return 主治医意見書依頼区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 主治医意見書依頼区分の名称を返します。
     *
     * @return 主治医意見書依頼区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 主治医意見書依頼区分のコードと一致する内容を探します。
     *
     * @param code 主治医意見書依頼区分のコード
     * @return {@code code} に対応する主治医意見書依頼区分
     */
    public static IkenshoIraiKubun toValue(RString code) {

        for (IkenshoIraiKubun ikenshoIraiKubun : IkenshoIraiKubun.values()) {
            if (ikenshoIraiKubun.code.equals(code)) {
                return ikenshoIraiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("主治医意見書依頼区分"));
    }
}
