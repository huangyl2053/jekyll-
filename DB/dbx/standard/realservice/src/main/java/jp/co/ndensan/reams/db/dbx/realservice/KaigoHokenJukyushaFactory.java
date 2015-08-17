/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * 介護保険受給者Finderのファクトリークラスです
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者ファクトリー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public final class KaigoHokenJukyushaFactory {

    private KaigoHokenJukyushaFactory() {
    }

    /**
     * 介護保険受給者Finderを作成します。
     *
     * @return 介護保険受給者Finderのインスタンス
     */
    public static IKaigoHokenJukyushaFinder createInstance() {
        return new _KaigoHokenJukyushaFinder();
    }
}
