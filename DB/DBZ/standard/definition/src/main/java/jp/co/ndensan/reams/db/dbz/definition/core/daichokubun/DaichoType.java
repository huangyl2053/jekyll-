package jp.co.ndensan.reams.db.dbz.definition.core.daichokubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 台帳種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum DaichoType {

    /**
     * コード:1 名称:被保険者 略称:定義なし
     */
    被保険者("1", "被保険者"),
    /**
     * コード:2 名称:他市町村住所地特例者 略称:定義なし
     */
    他市町村住所地特例者("2", "他市町村住所地特例者"),
    /**
     * コード:3 名称:適用除外者 略称:定義なし
     */
    適用除外者("3", "適用除外者");

    private final RString code;
    private final RString fullName;

    private DaichoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 台帳種別のコードを返します。
     *
     * @return 台帳種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 台帳種別の名称を返します。
     *
     * @return 台帳種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 台帳種別のコードと一致する内容を探します。
     *
     * @param code 台帳種別のコード
     * @return {@code code} に対応する台帳種別
     */
    public static DaichoType toValue(RString code) {

        for (DaichoType daichoType : DaichoType.values()) {
            if (daichoType.code.equals(code)) {
                return daichoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("台帳種別"));
    }
}
