package jp.co.ndensan.reams.db.dbd.business.report;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 集計改ページ表示タイプを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ShukeiKaiPageHyojiType {

    /**
     * コード:1 名称:全て表示 略称:定義なし
     */
    全て表示("1", "全て表示"),
    /**
     * コード:2 名称:出力順_昇降順のみ表示 略称:定義なし
     */
    出力順_昇降順のみ表示("2", "出力順_昇降順のみ表示"),
    /**
     * コード:3 名称:集計列非表示 略称:定義なし
     */
    集計列非表示("3", "集計列非表示"),
    /**
     * コード:4 名称:改頁条件列非表示 略称:定義なし
     */
    改頁条件列非表示("4", "改頁条件列非表示");

    private final RString code;
    private final RString fullName;

    private ShukeiKaiPageHyojiType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 集計改ページ表示タイプのコードを返します。
     *
     * @return 集計改ページ表示タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 集計改ページ表示タイプの名称を返します。
     *
     * @return 集計改ページ表示タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 集計改ページ表示タイプのコードと一致する内容を探します。
     *
     * @param code 集計改ページ表示タイプのコード
     * @return {@code code} に対応する集計改ページ表示タイプ
     */
    public static ShukeiKaiPageHyojiType toValue(RString code) {
        for (ShukeiKaiPageHyojiType shukeiKaiPageHyojiType : ShukeiKaiPageHyojiType.values()) {
            if (shukeiKaiPageHyojiType.code.equals(code)) {
                return shukeiKaiPageHyojiType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("集計改ページ表示タイプ"));
    }
}
