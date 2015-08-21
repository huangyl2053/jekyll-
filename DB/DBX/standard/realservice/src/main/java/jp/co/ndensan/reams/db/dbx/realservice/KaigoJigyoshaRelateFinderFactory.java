/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * 介護事業者関連情報ファインダーファクトリーです。
 *
 * @author N8187 久保田 英男
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public final class KaigoJigyoshaRelateFinderFactory {

    private KaigoJigyoshaRelateFinderFactory() {
    }

    /**
     * 介護事業者関連情報ファインダーを作成します。
     *
     * @return {@link IKaigoJigyoshaRelateFinder}を実装したクラスのインスタンス
     */
    public static IKaigoJigyoshaRelateFinder createInstance() {
        return new _KaigoJigyoshaRelateManager();
    }
}
