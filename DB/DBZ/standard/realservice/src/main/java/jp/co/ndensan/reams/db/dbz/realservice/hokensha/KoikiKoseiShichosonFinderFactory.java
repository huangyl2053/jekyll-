/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

/**
 * {@link IKoikiKoseiShichosonFinder}を生成する機能を持ちます。
 *
 * @author N3327 三浦 凌
 */
public final class KoikiKoseiShichosonFinderFactory {

    private KoikiKoseiShichosonFinderFactory() {
    }

    /**
     * {@link IKoikiKoseiShichosonFinder}を生成します。
     *
     * @return {@link IKoikiKoseiShichosonFinder}
     */
    public static IKoikiKoseiShichosonFinder createInstance() {
        return new _KoikiKoseiShichosonFinder(new KoseiShichosonMasterManager());
    }
}
