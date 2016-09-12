package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ページごと山分けを表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum PageGotoYamawake {

    /**
     * コード:0 名称:山分けしない 略称:定義なし
     */
    山分けしない("0", "山分けしない"),
    /**
     * コード:1 名称:山分けする 略称:定義なし
     */
    山分けする("1", "山分けする");

    private final RString code;
    private final RString fullName;

    private PageGotoYamawake(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * ページごと山分けのコードを返します。
     *
     * @return ページごと山分けのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * ページごと山分けの名称を返します。
     *
     * @return ページごと山分けの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * ページごと山分けのコードと一致する内容を探します。
     *
     * @param code ページごと山分けのコード
     * @return {@code code} に対応するページごと山分け
     */
    public static PageGotoYamawake toValue(RString code) {
        for (PageGotoYamawake pageGotoYamawake : PageGotoYamawake.values()) {
            if (pageGotoYamawake.code.equals(code)) {
                return pageGotoYamawake;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("ページごと山分け"));
    }
}
