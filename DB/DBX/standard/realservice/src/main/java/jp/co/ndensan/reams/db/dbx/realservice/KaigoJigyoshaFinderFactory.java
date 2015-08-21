/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * 介護事業者を取得するインターフェースのファクトリクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者取得ファクトリー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated {@link KaigoJigyoshaRelateFinderFactory}を使用してください。
 */
public final class KaigoJigyoshaFinderFactory {

    private KaigoJigyoshaFinderFactory() {
    }

    /**
     * 介護事業者を取得するクラスを返します。
     *
     * @return {@link IKaigoJigyoshaFinder}を実装したクラスのインスタンス
     */
    public static IKaigoJigyoshaFinder getInstance() {
        return InstanceHolder.SINGLE_INSTANCE;
    }

    private static final class InstanceHolder {

        private static final IKaigoJigyoshaFinder SINGLE_INSTANCE = new _KaigoJigyoshaFinder();
    }
}
