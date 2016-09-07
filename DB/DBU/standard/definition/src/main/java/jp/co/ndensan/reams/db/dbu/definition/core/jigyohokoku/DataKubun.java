package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データ区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum DataKubun {

    /**
     * コード:11 名称:ヘッダーレコード_加算 略称:定義なし
     */
    ヘッダーレコード_加算("11", "ヘッダーレコード_加算"),
    /**
     * コード:12 名称:ヘッダーレコード_減算 略称:定義なし
     */
    ヘッダーレコード_減算("12", "ヘッダーレコード_減算"),
    /**
     * コード:21 名称:データレコード_加算 略称:定義なし
     */
    データレコード_加算("21", "データレコード_加算"),
    /**
     * コード:22 名称:データレコード_減算 略称:定義なし
     */
    データレコード_減算("22", "データレコード_減算");

    private final RString code;
    private final RString fullName;

    private DataKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * データ区分のコードを返します。
     *
     * @return データ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * データ区分の名称を返します。
     *
     * @return データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * データ区分のコードと一致する内容を探します。
     *
     * @param code データ区分のコード
     * @return {@code code} に対応するデータ区分
     */
    public static DataKubun toValue(RString code) {
        for (DataKubun dataKubun : DataKubun.values()) {
            if (dataKubun.code.equals(code)) {
                return dataKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("データ区分"));
    }
}
