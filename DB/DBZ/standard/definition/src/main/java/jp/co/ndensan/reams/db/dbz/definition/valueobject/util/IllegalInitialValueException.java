/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.util;

import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * valueObjectに不正な値を設定したことを示すためにスローされます。
 *
 * @author N3327 三浦 凌
 */
//TODO TestCodeを作成する
public class IllegalInitialValueException extends RuntimeException {

    /**
     * 詳細メッセージ無しで IllegalInitializationValueException を構築します。
     */
    public IllegalInitialValueException() {
        super();
    }

    /**
     * 指定された詳細メッセージを持つ IllegalInitializationValueException を構築します。
     *
     * @param message 詳細メッセージ
     */
    public IllegalInitialValueException(Message message) {
        super(message.evaluate());
    }

    /**
     * 指定された詳細メッセージを持つ IllegalInitializationValueException を構築します。
     *
     * @param message 詳細メッセージ
     */
    public IllegalInitialValueException(String message) {
        super(message);
    }
}
