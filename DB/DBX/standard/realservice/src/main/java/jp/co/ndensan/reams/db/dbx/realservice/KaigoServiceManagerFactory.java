/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

/**
 * 介護サービスマネージャークラスのファクトリークラスです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス管理ファクトリー
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public final class KaigoServiceManagerFactory {

    private KaigoServiceManagerFactory() {
    }

    /**
     * インスタンスを生成します。
     *
     * @return 介護サービスマネージャークラス
     */
    public static IKaigoServiceManager createInstance() {
        return new _KaigoServiceManager();
    }
}
