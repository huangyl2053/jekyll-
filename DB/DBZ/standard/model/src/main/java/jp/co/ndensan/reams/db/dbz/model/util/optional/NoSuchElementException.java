/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.optional;

/**
 * 要求のあった要素が存在しないことを表すためにスローされます。
 *
 * @author N3327 三浦 凌
 */
public class NoSuchElementException extends RuntimeException {

    /**
     * メッセージ無しで NoSuchElementException を生成します。
     */
    public NoSuchElementException() {
        super();
    }

    /**
     * 指定されたメッセージを持つ NoSuchElementException を生成します。
     *
     * @param s メッセージ
     */
    public NoSuchElementException(String s) {
        super(s);
    }
}
