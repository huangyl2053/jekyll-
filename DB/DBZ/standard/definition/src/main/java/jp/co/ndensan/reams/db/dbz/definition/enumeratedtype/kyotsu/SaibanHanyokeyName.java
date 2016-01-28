package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 採番汎用キー名称を表す列挙型です。
 *
 * @author LDNS
 */
public enum SaibanHanyokeyName {

    /**
     * コード:01 名称:文書番号 略称:定義なし
     */
    文書番号("01", "文書番号"),
    /**
     * コード:02 名称:医療機関コード 略称:定義なし
     */
    医療機関コード("02", "医療機関コード"),
    /**
     * コード:03 名称:調査委託先コード 略称:定義なし
     */
    調査委託先コード("03", "調査委託先コード"),
    /**
     * コード:04 名称:被保険者番号自動採番 略称:定義なし
     */
    被保険者番号自動採番("04", "被保険者番号自動採番"),
    /**
     * コード:21 名称:被保険者番号自動MCD 略称:定義なし
     */
    被保険者番号自動MCD("21", "被保険者番号自動MCD"),
    /**
     * コード:05 名称:公費受給者番号 略称:定義なし
     */
    公費受給者番号("05", "公費受給者番号"),
    /**
     * コード:06 名称:償還整理番号 略称:定義なし
     */
    償還整理番号("06", "償還整理番号"),
    /**
     * コード:07 名称:実績管理番号 略称:定義なし
     */
    実績管理番号("07", "実績管理番号"),
    /**
     * コード:08 名称:確認番号 略称:定義なし
     */
    _08確認番号("08", "確認番号"),
    /**
     * コード:09 名称:特定住所管理番号 略称:定義なし
     */
    特定住所管理番号("09", "特定住所管理番号"),
    /**
     * コード:10 名称:確認番号 略称:定義なし
     */
    _10確認番号("10", "確認番号"),
    /**
     * コード:11 名称:受給者番号 略称:定義なし
     */
    受給者番号("11", "受給者番号"),
    /**
     * コード:12 名称:申請書整理番号 略称:定義なし
     */
    申請書整理番号("12", "申請書整理番号"),
    /**
     * コード:13 名称:証明書整理番号 略称:定義なし
     */
    証明書整理番号("13", "証明書整理番号"),
    /**
     * コード:14 名称:入浴券整理番号 略称:定義なし
     */
    入浴券整理番号("14", "入浴券整理番号"),
    /**
     * コード:22 名称:契約事業者番号 略称:定義なし
     */
    契約事業者番号("22", "契約事業者番号"),
    /**
     * コード:15 名称:第三者管理番号 略称:定義なし
     */
    第三者管理番号("15", "第三者管理番号"),
    /**
     * コード:91 名称:住民コード発番用 略称:定義なし
     */
    住民コード発番用("91", "住民コード発番用"),
    /**
     * コード:92 名称:世帯コード発番用 略称:定義なし
     */
    世帯コード発番用("92", "世帯コード発番用"),
    /**
     * コード:93 名称:住所コード発番用 略称:定義なし
     */
    住所コード発番用("93", "住所コード発番用"),
    /**
     * コード:94 名称:行政区コード発番用 略称:定義なし
     */
    行政区コード発番用("94", "行政区コード発番用"),
    /**
     * コード:95 名称:地区コード１発番用 略称:定義なし
     */
    地区コード１発番用("95", "地区コード１発番用"),
    /**
     * コード:96 名称:地区コード２発番用 略称:定義なし
     */
    地区コード２発番用("96", "地区コード２発番用"),
    /**
     * コード:41 名称:商品番号 略称:定義なし
     */
    商品番号("41", "商品番号");

    private final RString code;
    private final RString fullName;

    private SaibanHanyokeyName(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 採番汎用キー名称のコードを返します。
     *
     * @return 採番汎用キー名称のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 採番汎用キー名称の名称を返します。
     *
     * @return 採番汎用キー名称の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 採番汎用キー名称のコードと一致する内容を探します。
     *
     * @param code 採番汎用キー名称のコード
     * @return {@code code} に対応する採番汎用キー名称
     */
    public static SaibanHanyokeyName toValue(RString code) {

        for (SaibanHanyokeyName saibanHanyokeyName : SaibanHanyokeyName.values()) {
            if (saibanHanyokeyName.code.equals(code)) {
                return saibanHanyokeyName;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("採番汎用キー名称"));
    }
}
