package jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigoInterface;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域認定支援システム_申請者並び順を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum KoikiNinteiShienSystemShinseishaSortOrder {

    /**
     * コード:1 名称:認定申請日順 略称:定義なし
     */
    認定申請日順("1", "認定申請日順"),
    /**
     * コード:2 名称:被保険者番号順 略称:定義なし
     */
    被保険者番号順("2", "被保険者番号順"),
    /**
     * コード:3 名称:氏名順 略称:定義なし
     */
    氏名順("3", "氏名順");

    private final RString code;
    private final RString fullName;

    private KoikiNinteiShienSystemShinseishaSortOrder(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域認定支援システム_申請者並び順のコードを返します。
     *
     * @return 広域認定支援システム_申請者並び順のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域認定支援システム_申請者並び順の名称を返します。
     *
     * @return 広域認定支援システム_申請者並び順の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域認定支援システム_申請者並び順のコードと一致する内容を探します。
     *
     * @param code 広域認定支援システム_申請者並び順のコード
     * @return {@code code} に対応する広域認定支援システム_申請者並び順
     */
    public static KoikiNinteiShienSystemShinseishaSortOrder toValue(RString code) {
        for (KoikiNinteiShienSystemShinseishaSortOrder value : KoikiNinteiShienSystemShinseishaSortOrder.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("広域認定支援システム_申請者並び順"));
    }
}
