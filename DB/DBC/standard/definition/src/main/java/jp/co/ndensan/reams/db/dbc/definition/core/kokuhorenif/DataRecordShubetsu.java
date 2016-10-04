/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データレコード種別種別を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhaowei
 */
public enum DataRecordShubetsu {

    /**
     * コード:H1 名称:ヘッダーレコード 略称:ヘッダーレコード
     */
    ヘッダーレコード("H1", "ヘッダーレコード", "ヘッダーレコード"),
    /**
     * コード:D1 名称:データレコード 略称:データレコード
     */
    データレコード("D1", "データレコード", "データレコード"),
    /**
     * コード:T1 名称:トレーラレコード 略称:トレーラレコード
     */
    トレーラレコード("T1", "トレーラレコード", "トレーラレコード");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private DataRecordShubetsu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * データレコード種別のコードを返します。
     *
     * @return データレコード種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * データレコード種別の名称を返します。
     *
     * @return データレコード種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * データレコード種別の名称を返します。
     *
     * @return データレコード種別の名称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * データレコード種別のコードと一致する内容を探します。
     *
     * @param code データレコード種別のコード
     * @return {@code code} に対応するデータレコード種別
     */
    public static DataRecordShubetsu toValue(RString code) {

        for (DataRecordShubetsu dataSaisoFlag : DataRecordShubetsu.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("データレコード種別"));
    }
}
