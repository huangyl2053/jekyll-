package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴分配集約を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum TokuchoBunpaiShuyaku {

    /**
     * コード:0 名称:なし 略称:なし
     */
    なし("0", "なし", "なし"),
    /**
     * コード:1 名称:あり_国保_後期 略称:あり（国保／後期）
     */
    あり_国保_後期("1", "あり_国保_後期", "あり（国保／後期）"),
    /**
     * コード:3 名称:あり_後期 略称:あり（後期）
     */
    あり_後期("3", "あり_後期", "あり（後期）");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoBunpaiShuyaku(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴分配集約のコードを返します。
     *
     * @return 特徴分配集約のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴分配集約の名称を返します。
     *
     * @return 特徴分配集約の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴分配集約の略称を返します。
     *
     * @return 特徴分配集約の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴分配集約のコードと一致する内容を探します。
     *
     * @param code 特徴分配集約のコード
     * @return {@code code} に対応する特徴分配集約
     */
    public static TokuchoBunpaiShuyaku toValue(RString code) {
        for (TokuchoBunpaiShuyaku tokuchoBunpaiShuyaku : TokuchoBunpaiShuyaku.values()) {
            if (tokuchoBunpaiShuyaku.code.equals(code)) {
                return tokuchoBunpaiShuyaku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴分配集約"));
    }
}
