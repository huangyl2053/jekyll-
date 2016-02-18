/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務分類です
 */
public enum GyomuBunrui {

    /**
     * 介護事務
     */
    介護事務("1"),
    /**
     * 介護認定
     */
    介護認定("2");
    private final RString aCode;

    private GyomuBunrui(String code) {
        this.aCode = new RString(code);
    }

    /**
     * コードを取得します。
     *
     * @return コード
     */
    public RString code() {
        return aCode;
    }

    /**
     * 指定したコードに対応する業務分類を取得します。
     *
     * @param コード コード
     * @return 対応する業務分類
     * @throws IllegalArgumentException 指定された名前を持つ定数を持っていない場合
     */
    public static GyomuBunrui toValue(RString コード) throws IllegalArgumentException {
        for (GyomuBunrui gyomuBunrui : GyomuBunrui.values()) {
            if (Objects.equals(gyomuBunrui.aCode, コード)) {
                return gyomuBunrui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("\"" + コード + "\"に対応する業務分類"));
    }

}
