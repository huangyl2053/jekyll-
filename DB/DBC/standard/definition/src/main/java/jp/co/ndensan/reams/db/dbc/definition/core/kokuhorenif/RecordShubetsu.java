/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * レコード種別を表す列挙型です。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
public enum RecordShubetsu {

    /**
     * コード:1 名称:コントロールレコード 略称:コントロールレコード
     */
    コントロールレコード("1", "コントロールレコード", "コントロールレコード"),
    /**
     * コード:2 名称:データレコード 略称:データレコード
     */
    データレコード("2", "データレコード", "データレコード"),
    /**
     * コード:3 名称:エンドレコード 略称:エンドレコード
     */
    エンドレコード("3", "エンドレコード", "エンドレコード");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private RecordShubetsu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * レコード種別のコードを返します。
     *
     * @return レコード種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * レコード種別の名称を返します。
     *
     * @return レコード種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * レコード種別の名称を返します。
     *
     * @return レコード種別の名称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * レコード種別のコードと一致する内容を探します。
     *
     * @param code レコード種別のコード
     * @return {@code code} に対応するレコード種別
     */
    public static RecordShubetsu toValue(RString code) {

        for (RecordShubetsu dataSaisoFlag : RecordShubetsu.values()) {
            if (dataSaisoFlag.code.equals(code)) {
                return dataSaisoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("レコード種別"));
    }
}
