package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai;

//import jp.co.ndensan.reams.dc.dca.definition.enumeratedtype.message.DcErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員遅刻有無を表す列挙型です。
 *
 * @author LDNS 作成者漢字名
 */
public enum IsChikokuUmu {

    /**
     * コード:True 名称:遅刻 略称:定義なし
     */
    遅刻(true, "遅刻"),
    /**
     * コード:False 名称:遅刻なし 略称:定義なし
     */
    遅刻なし(false, "遅刻なし");

    private final boolean code;
    private final RString fullName;

    private IsChikokuUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 委員遅刻有無のコードを返します。
     *
     * @return 委員遅刻有無のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 委員遅刻有無の名称を返します。
     *
     * @return 委員遅刻有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 委員遅刻有無のコードと一致する内容を探します。
     *
     * @param code 委員遅刻有無のコード
     * @return {@code code} に対応する委員遅刻有無
     */
    public static IsChikokuUmu toValue(boolean code) {
        for (IsChikokuUmu isChikokuUmu : IsChikokuUmu.values()) {
            if (isChikokuUmu.code == code) {
                return isChikokuUmu;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
