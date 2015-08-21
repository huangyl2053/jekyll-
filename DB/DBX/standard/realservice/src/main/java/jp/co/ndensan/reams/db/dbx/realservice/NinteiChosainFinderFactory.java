/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * 認定調査員を取得するインターフェースのファクトリークラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 認定調査員取得ファクトリー
 * @bizDomain 介護
 * @category 認定調査員
 * @subCategory
 * @mainClass
 * @reference
 */
public final class NinteiChosainFinderFactory {

    private NinteiChosainFinderFactory() {
    }

    /**
     * 認定調査員を取得するクラスを返します。
     *
     * @return {@link INinteiChosainFinder}を実装したクラスのインスタンス
     */
    public static INinteiChosainFinder getInstance() {
        return InstanceHolder.SINGLE_INSTANCE;
    }

    private static final class InstanceHolder {

        private static final INinteiChosainFinder SINGLE_INSTANCE = new _NinteiChosainFinder();
    }
}
