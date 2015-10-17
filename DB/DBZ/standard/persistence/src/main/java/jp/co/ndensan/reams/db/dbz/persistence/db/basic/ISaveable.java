/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * データアクセス用インターフェースです。
 *
 * @author N3317 塚田 萌
 * @jpName 変更インタフェース
 * @bizDomain 業務共通_コア
 * @category コア
 * @subCategory データ操作共通
 * @mainClass
 * @reference
 * @param <T> 扱うエンティティの型
 */
public interface ISaveable<T> {
    //TODO n8178 城間 UzVer1.5リリース時にUZに同じクラスが用意されるまでの代替えクラスです。後に削除されます。
    /**
     * 対象のEntityのEntityDataStateの設定値に従ってDBに保存します。
     *
     * @param entity 登録用Entity
     * @return 登録件数
     */
    @Transaction
    int save(T entity);
}
