/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * 高額介護サービス費を検索するクラスのファクトリーです。
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費取得ファクトリー
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public final class KogakuKaigoServiceHiFinderFactory {

    private KogakuKaigoServiceHiFinderFactory() {
    }

    /**
     * 高額介護サービス費Finderを返します。
     *
     * @return {@link IKogakuKaigoServiceHiFinder}を実装したクラスのインスタンス
     */
    public static IKogakuKaigoServiceHiFinder getInstance() {
        return _KogakuKaigoServiceHiFinderHolder.SINGLE_INSTANCE;
    }

    private static class _KogakuKaigoServiceHiFinderHolder {

        private static final IKogakuKaigoServiceHiFinder SINGLE_INSTANCE = new _KogakuKaigoServiceHiFinder();
    }
}
