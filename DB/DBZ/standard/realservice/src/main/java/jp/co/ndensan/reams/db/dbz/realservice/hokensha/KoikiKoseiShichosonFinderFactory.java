/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

/**
 *
 * @author N3327 三浦 凌
 */
public final class KoikiKoseiShichosonFinderFactory {

    private KoikiKoseiShichosonFinderFactory() {
    }

    /**
     *
     * @return
     */
    public static IKoikiKoseiShichosonFinder createInstance() {
        return new _KoikiKoseiShichosonFinder(new KoseiShichosonMasterManager());
    }
}
