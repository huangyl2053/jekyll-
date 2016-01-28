package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会議長区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum KaigoninteiShinsakaiGichoKubunCode {

    /**
     * コード:0 名称:委員 略称:定義なし
     */
    委員("0", "委員"),
    /**
     * コード:1 名称:議長 略称:定義なし
     */
    議長("1", "議長");

    private final RString code;
    private final RString fullName;

    private KaigoninteiShinsakaiGichoKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護認定審査会議長区分コードのコードを返します。
     *
     * @return 介護認定審査会議長区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護認定審査会議長区分コードの名称を返します。
     *
     * @return 介護認定審査会議長区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護認定審査会議長区分コードのコードと一致する内容を探します。
     *
     * @param code 介護認定審査会議長区分コードのコード
     * @return {@code code} に対応する介護認定審査会議長区分コード
     */
    public static KaigoninteiShinsakaiGichoKubunCode toValue(RString code) {

        for (KaigoninteiShinsakaiGichoKubunCode value : KaigoninteiShinsakaiGichoKubunCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護認定審査会議長区分コード"));
    }
}
