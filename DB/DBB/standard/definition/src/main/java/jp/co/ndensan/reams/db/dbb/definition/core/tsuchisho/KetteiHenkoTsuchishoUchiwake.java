package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定変更通知書打ち分けを表す列挙型です。
 *
 * @author LDNS
 */
public enum KetteiHenkoTsuchishoUchiwake {

    /**
     * コード:0 名称:発行しない 略称:発行しない
     */
    発行しない("0", "発行しない", "発行しない"),
    /**
     * コード:1 名称:決定通知書 略称:決定通知書
     */
    決定通知書("1", "決定通知書", "決定通知書"),
    /**
     * コード:2 名称:変更通知書 略称:変更通知書
     */
    変更通知書("2", "変更通知書", "変更通知書");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KetteiHenkoTsuchishoUchiwake(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 決定変更通知書打ち分けのコードを返します。
     *
     * @return 決定変更通知書打ち分けのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 決定変更通知書打ち分けの名称を返します。
     *
     * @return 決定変更通知書打ち分けの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 決定変更通知書打ち分けの略称を返します。
     *
     * @return 決定変更通知書打ち分けの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 決定変更通知書打ち分けのコードと一致する内容を探します。
     *
     * @param code 決定変更通知書打ち分けのコード
     * @return {@code code} に対応する決定変更通知書打ち分け
     */
    public static KetteiHenkoTsuchishoUchiwake toValue(RString code) {
        for (KetteiHenkoTsuchishoUchiwake ketteiHenkoTsuchishoUchiwake : KetteiHenkoTsuchishoUchiwake.values()) {
            if (ketteiHenkoTsuchishoUchiwake.code.equals(code)) {
                return ketteiHenkoTsuchishoUchiwake;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定変更通知書打ち分け"));
    }
}
