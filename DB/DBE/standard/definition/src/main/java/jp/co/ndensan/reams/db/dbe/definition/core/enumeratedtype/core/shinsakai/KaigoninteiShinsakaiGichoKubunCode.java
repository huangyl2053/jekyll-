package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai;

//import jp.co.ndensan.reams.dc.dca.definition.enumeratedtype.message.DcErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会議長区分コードを表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
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
//        requireNonNull(code, DcErrorMessages.E00001.getMessage().getMessage());
        for (KaigoninteiShinsakaiGichoKubunCode value : KaigoninteiShinsakaiGichoKubunCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
