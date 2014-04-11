/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

/**
 * 採番をするオブジェクトであることをあらわします。
 *
 * @author N3327 三浦 凌
 * @param <T> 採番したいオブジェクトの型
 */
//TODO n3327 三浦凌 仮実装。採番APIの正しい利用方法がわかったら修正する。
public interface IKaigoSaiban<T> {

    /**
     * 新しい番号を採番します。
     *
     * @return 採番された番号
     */
    T number();
}
