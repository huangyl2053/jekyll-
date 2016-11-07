package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居室種別を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum KyoshitsuShubetsu {

    /**
     * コード:1 名称:ユニット型個室 略称:無
     */
    ユニット型個室("1", "ユニット型個室"),
    /**
     * コード:2 名称:ユニット型準個室 略称:無
     */
    ユニット型準個室("2", "ユニット型準個室"),
    /**
     * コード:3 名称:従来型個室 略称:無
     */
    従来型個室("3", "従来型個室"),
    /**
     * コード: 名称:多床室 略称:無
     */
    多床室("4", "多床室"),
    /**
     * コード: 名称:従来型個室（老健・療養等） 略称:無
     */
    従来型個室_老健_療養等("5", "従来型個室（老健・療養等）");

    private final RString code;
    private final RString fullName;

    private KyoshitsuShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 居室種別のコードを返します。
     *
     * @return 居室種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 居室種別の名称を返します。
     *
     * @return 居室種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 居室種別のコードと一致する内容を探します。
     *
     * @param code 居室種別のコード
     * @return {@code code} に対応する居室種別
     */
    public static KyoshitsuShubetsu toValue(RString code) {
        for (KyoshitsuShubetsu kyoshitsuShubetsu : KyoshitsuShubetsu.values()) {
            if (kyoshitsuShubetsu.code.equals(code)) {
                return kyoshitsuShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("居室種別"));
    }
}
