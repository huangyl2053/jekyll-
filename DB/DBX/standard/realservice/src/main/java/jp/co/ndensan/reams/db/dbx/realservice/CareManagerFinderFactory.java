/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * ケアマネージャマネージャーファクトリーです。
 *
 * @author n9944 趙 春暉
 * @jpName ケアマネージャ取得ファクトリー
 * @bizDomain 介護
 * @category ケアマネージャ
 * @subCategory
 * @mainClass
 * @reference
 */
public final class CareManagerFinderFactory {

    private CareManagerFinderFactory() {
    }

    /**
     * ケアマネージャマネージャーを返します。
     *
     * @return {@link ICareManagerFinder}を実装したクラスのインスタンス
     */
    public static ICareManagerFinder getInstance() {
        return InstanceHolder.SINGLE_INSTANCE;
    }

    private static final class InstanceHolder {

        private static final ICareManagerFinder SINGLE_INSTANCE = new _CareManagerFinder();
    }
}
