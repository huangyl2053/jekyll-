/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.util;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護業務で使用する、行の状態を表す列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum KaigoRowState {

    /**
     * 新規にグリッドに追加されたことを表します。状態列に"追加"を表示します。
     */
    追加("追加"),
    /**
     * グリッド上の既存データが修正されたことを表します。状態列に"修正"を表示します。
     */
    修正("修正"),
    /**
     * グリッド上に存在するデータが削除対象であることを表します。状態列に"削除"を表示します。
     */
    削除("削除"),
    /**
     * 処理のされていないデータであることを表します。状態列に" "(空白)を表示します。
     */
    空白("");

    private final RString status;

    private KaigoRowState(String status) {
        this.status = new RString(status);
    }

    public RString getStateName() {
        return status;
    }

    /**
     * 引数からグリッドの状態を表す文字列を受け取り、対応する状態を返却します。
     *
     * @param value 状態を表す文字列
     * @return 状態
     * @throws IllegalArgumentException 対応する状態の存在しない文字列が渡された場合
     */
    public static KaigoRowState toValue(RString value) throws IllegalArgumentException {
        for (KaigoRowState rowState : values()) {
            if (rowState.getStateName().equals(value)) {
                return rowState;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("KaigoRowStatus"));
    }
}
