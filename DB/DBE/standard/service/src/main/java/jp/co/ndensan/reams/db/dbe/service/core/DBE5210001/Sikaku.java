package jp.co.ndensan.reams.db.dbe.service.core.DBE5210001;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.dc.dca.definition.message.DcErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格コードを表す列挙型です。
 *
 * @author LDNS 作成者漢字名
 */
public enum Sikaku {

    /**
     * コード:01 名称:医師 略称:定義なし
     */
    医師("01", "医師"),
    /**
     * コード:02 名称:歯科医師 略称:定義なし
     */
    歯科医師("02", "歯科医師"),
    /**
     * コード:03 名称:薬剤師 略称:定義なし
     */
    薬剤師("03", "薬剤師"),
    /**
     * コード:04 名称:保健師 略称:定義なし
     */
    保健師("04", "保健師"),
    /**
     * コード:05 名称:助産師 略称:定義なし
     */
    助産師("05", "助産師"),
    /**
     * コード:06 名称:（洵）看護師 略称:定義なし
     */
    _洵_看護師("06", "（洵）看護師"),
    /**
     * コード:07 名称:理学療法士 略称:定義なし
     */
    理学療法士("07", "理学療法士"),
    /**
     * コード:08 名称:作業療法士 略称:定義なし
     */
    作業療法士("08", "作業療法士"),
    /**
     * コード:09 名称:社会福祉士 略称:定義なし
     */
    社会福祉士("09", "社会福祉士"),
    /**
     * コード:10 名称:介護福祉士 略称:定義なし
     */
    介護福祉士("10", "介護福祉士"),
    /**
     * コード:11 名称:ソーシャルワーカー 略称:定義なし
     */
    ソーシャルワーカー("11", "ソーシャルワーカー"),
    /**
     * コード:12 名称:福祉事務所現業員等 略称:定義なし
     */
    福祉事務所現業員等("12", "福祉事務所現業員等"),
    /**
     * コード:13 名称:ホームヘルパー 略称:定義なし
     */
    ホームヘルパー("13", "ホームヘルパー"),
    /**
     * コード:14 名称:介護職員 略称:定義なし
     */
    介護職員("14", "介護職員"),
    /**
     * コード:15 名称:その他福祉関係者 略称:定義なし
     */
    その他福祉関係者("15", "その他福祉関係者"),
    /**
     * コード:16 名称:行政関係者 略称:定義なし
     */
    行政関係者("16", "行政関係者"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private Sikaku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格コードのコードを返します。
     *
     * @return 資格コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格コードの名称を返します。
     *
     * @return 資格コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格コードのコードと一致する内容を探します。
     *
     * @param code 資格コードのコード
     * @return {@code code} に対応する資格コード
     */
    public static Sikaku toValue(RString code) {
        requireNonNull(code, DcErrorMessages.E00002.getMessage().getMessage());
        for (Sikaku sikaku : Sikaku.values()) {
            if (sikaku.code.equals(code)) {
                return sikaku;
            }
        }
        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
    }
}
