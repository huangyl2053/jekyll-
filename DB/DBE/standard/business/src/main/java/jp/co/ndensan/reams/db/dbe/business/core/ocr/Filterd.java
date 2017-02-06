/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

/**
 * 複数の要素を持つオブジェクトを何らかの条件で絞り込んだ際の条件に該当する要素と、条件に該当しない要素の双方を保持します。
 *
 * @param <T> 保持するオブジェクトの型
 */
public class Filterd<T> {

    private final T thePassed;
    private final T theRejected;

    /**
     * インスタンスを生成します。
     *
     * @param passed 条件に該当する要素
     * @param rejected 条件に該当しない要素
     */
    public Filterd(T passed, T rejected) {
        this.thePassed = passed;
        this.theRejected = rejected;
    }

    /**
     * @return 条件に該当する要素
     */
    public T passed() {
        return this.thePassed;
    }

    /**
     * @return 条件に該当しない要素
     */
    public T rejected() {
        return this.theRejected;
    }
}
