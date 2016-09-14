package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データセット番号を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum DataSetNo {

    /**
     * コード:0101 名称:0101被保険者情報 略称:定義なし
     */
    _0101被保険者情報("0101", "0101被保険者情報"),

    /**
     * コード:0102 名称:0102住所地特例情報 略称:定義なし
     */
    _0102住所地特例情報("0102", "0102住所地特例情報"),

    /**
     * コード:0201 名称:0201受給者基本情報 略称:定義なし
     */
    _0201受給者基本情報("0201", "0201受給者基本情報"),

    /**
     * コード:0202 名称:0202負担割合 略称:定義なし
     */
    _0202負担割合("0202", "0202負担割合"),

    /**
     * コード:0300 名称:0300給付情報 略称:定義なし
     */
    _0300給付情報("0300", "0300給付情報"),

    /**
     * コード:0400 名称:0400総合事業 略称:定義なし
     */
    _0400総合事業("0400", "0400総合事業");

    private final RString code;
    private final RString fullName;

    private DataSetNo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * データセット番号のコードを返します。
     *
     * @return データセット番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * データセット番号の名称を返します。
     *
     * @return データセット番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * データセット番号のコードと一致する内容を探します。
     *
     * @param code データセット番号のコード
     * @return {@code code} に対応するデータセット番号
     */
    public static DataSetNo toValue(RString code) {
        for (DataSetNo dataSetNo : DataSetNo.values()) {
            if (dataSetNo.code.equals(code)) {
                return dataSetNo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
