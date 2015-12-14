package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 決定変更通知書打ち分け口座条件を表す列挙型です。
 *
 * @author LDNS
 */
public enum KetteiHenkoTsuchishoUchiwakeKozaJoken {

    /**
     * コード:0 名称:現金 略称:現金
     */
    現金("0", "現金", "現金"),
    /**
     * コード:1 名称:口座 略称:口座
     */
    口座("1", "口座", "口座"),
    /**
     * コード:2 名称:全て 略称:全て
     */
    全て("2", "全て", "全て");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KetteiHenkoTsuchishoUchiwakeKozaJoken(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 決定変更通知書打ち分け口座条件のコードを返します。
     *
     * @return 決定変更通知書打ち分け口座条件のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 決定変更通知書打ち分け口座条件の名称を返します。
     *
     * @return 決定変更通知書打ち分け口座条件の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 決定変更通知書打ち分け口座条件の略称を返します。
     *
     * @return 決定変更通知書打ち分け口座条件の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 決定変更通知書打ち分け口座条件のコードと一致する内容を探します。
     *
     * @param code 決定変更通知書打ち分け口座条件のコード
     * @return {@code code} に対応する決定変更通知書打ち分け口座条件
     */
    public static KetteiHenkoTsuchishoUchiwakeKozaJoken toValue(RString code) {
        for (KetteiHenkoTsuchishoUchiwakeKozaJoken value : KetteiHenkoTsuchishoUchiwakeKozaJoken.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("決定変更通知書打ち分け口座条件"));
    }
}
