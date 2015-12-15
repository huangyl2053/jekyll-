package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所編集都道府県名表示有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum JushoHenshuTodofukenHyojiUmu {

    /**
     * コード:0 名称:しない 略称:定義なし
     */
    しない("0", "しない"),
    /**
     * コード:1 名称:する 略称:定義なし
     */
    する("1", "する");

    private final RString code;
    private final RString fullName;

    private JushoHenshuTodofukenHyojiUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 住所編集都道府県名表示有無のコードを返します。
     *
     * @return 住所編集都道府県名表示有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 住所編集都道府県名表示有無の名称を返します。
     *
     * @return 住所編集都道府県名表示有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住所編集都道府県名表示有無のコードと一致する内容を探します。
     *
     * @param code 住所編集都道府県名表示有無のコード
     * @return {@code code} に対応する住所編集都道府県名表示有無
     */
    public static JushoHenshuTodofukenHyojiUmu toValue(RString code) {

        for (JushoHenshuTodofukenHyojiUmu jushoHenshuTodofukenHyojiUmu : JushoHenshuTodofukenHyojiUmu.values()) {
            if (jushoHenshuTodofukenHyojiUmu.code.equals(code)) {
                return jushoHenshuTodofukenHyojiUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住所編集都道府県名表示有無"));
    }
}
