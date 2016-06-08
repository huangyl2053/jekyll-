/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.uzclasses;

/**
 * 識別子によって同一性が判断される「参照オブジェクト」であることを表します。
 * <p />
 * このインタフェースを実装するオブジェクトは、{@link #identifier() identifier()}が返す識別子が同じかどうかで、
 * 同一かどうかを判断する物である必要があります。
 *
 * @param <I> 識別子の型
 */
public interface IIdentifiable<I> {
    //TODO n8178 城間 UzVer1.5リリース時にUZに同じクラスが用意されるまでの代替えクラスです。後に削除されます。

    /**
     * 識別子を返します。
     *
     * @return 識別子
     */
    I identifier();
}
