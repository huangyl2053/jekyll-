package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kijunshunyugakutekiyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データ種別を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum DataShubetsu {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:申請中データ 略称:定義なし
     */
    申請中データ("1", "申請中データ"),
    /**
     * コード:2 名称:適用決定データ 略称:定義なし
     */
    適用決定データ("2", "適用決定データ");

    private final RString code;
    private final RString fullName;

    private DataShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * データ種別のコードを返します。
     *
     * @return データ種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * データ種別の名称を返します。
     *
     * @return データ種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * データ種別のコードと一致する内容を探します。
     *
     * @param code データ種別のコード
     * @return {@code code} に対応するデータ種別
     */
    public static DataShubetsu toValue(RString code) {
        for (DataShubetsu dataShubetsu : DataShubetsu.values()) {
            if (dataShubetsu.code.equals(code)) {
                return dataShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("データ種別"));
    }
}
