/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * {@link IShisetsuNyutaishoFinder}のファクトリークラスです。
 * <p>
 * 施設入退所を取得するクラスのインスタンスを取得することができます。
 * </p>
 * <p>
 * ■関連クラス
 * <ul>
 * <li> {@link IShisetsuNyutaishoFinder}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author N3317 塚田 萌
 * @jpName 施設入退所取得ファクトリー
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public final class ShisetsuNyutaishoFinderFactory {

    private ShisetsuNyutaishoFinderFactory() {

    }

    /**
     * 施設入退所ファインダークラスのインスタンスを生成します。
     *
     * @return {@link IShisetsuNyutaishoFinder}を実装したクラスのインスタンス
     */
    public static IShisetsuNyutaishoFinder createInstance() {
        return new _ShisetsuNyutaishoFinder();
    }
}
