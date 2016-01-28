package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会優先振分区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsakaiYusenWaritsukeKubunCode {

    /**
     * コード:0 名称:通常 略称:定義なし
     */
    通常("0", "通常"),
    /**
     * コード:1 名称:優先 略称:定義なし
     */
    優先("1", "優先");

    private final RString code;
    private final RString fullName;

    private ShinsakaiYusenWaritsukeKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護認定審査会優先振分区分コードのコードを返します。
     *
     * @return 介護認定審査会優先振分区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護認定審査会優先振分区分コードの名称を返します。
     *
     * @return 介護認定審査会優先振分区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護認定審査会優先振分区分コードのコードと一致する内容を探します。
     *
     * @param code 介護認定審査会優先振分区分コードのコード
     * @return {@code code} に対応する介護認定審査会優先振分区分コード
     */
    public static ShinsakaiYusenWaritsukeKubunCode toValue(RString code) {

        for (ShinsakaiYusenWaritsukeKubunCode value : ShinsakaiYusenWaritsukeKubunCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護認定審査会優先振分区分コード"));
    }
}
