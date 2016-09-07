package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_データ区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum RiyojokyoTokeihyo_DataKubun {

    /**
     * コード:1 名称:集計 略称:合計
     */
    合計("1", "集計", "合計"),
    /**
     * コード:2 名称:明細 略称:明細
     */
    明細("2", "明細", "明細");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private RiyojokyoTokeihyo_DataKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 利用状況統計表_データ区分のコードを返します。
     *
     * @return 利用状況統計表_データ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_データ区分の名称を返します。
     *
     * @return 利用状況統計表_データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_データ区分の略称を返します。
     *
     * @return 利用状況統計表_データ区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 利用状況統計表_データ区分のコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_データ区分のコード
     * @return {@code code} に対応する利用状況統計表_データ区分
     */
    public static RiyojokyoTokeihyo_DataKubun toValue(RString code) {
        for (RiyojokyoTokeihyo_DataKubun riyojokyoTokeihyo_DataKubun : RiyojokyoTokeihyo_DataKubun.values()) {
            if (riyojokyoTokeihyo_DataKubun.code.equals(code)) {
                return riyojokyoTokeihyo_DataKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
