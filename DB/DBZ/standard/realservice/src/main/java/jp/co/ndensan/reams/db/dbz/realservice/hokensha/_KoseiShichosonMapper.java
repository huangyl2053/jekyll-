/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hokensha;

import jp.co.ndensan.reams.db.dbz.business.hokensha.KoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonMasterModel;
import jp.co.ndensan.reams.db.dbz.model.hokensha.KoseiShichosonModel;

/**
 * パッケージ内で用いる{@link IFunction}をまとめたクラスです。
 *
 * @author N3327 三浦 凌
 */
final class _KoseiShichosonMapper {

    private _KoseiShichosonMapper() {
    }

    static IFunction<KoseiShichosonMasterModel, KoseiShichosonModel> toKoseiShichosonModel() {
        //<editor-fold defaultstate="collapsed" desc="return (KoseiShichosonMasterModel t) -> KoseiShichosonModel(t)">
        return new IFunction<KoseiShichosonMasterModel, KoseiShichosonModel>() {
            @Override
            public KoseiShichosonModel apply(final KoseiShichosonMasterModel t) {
                return new KoseiShichosonModel(t);
            }
        };
        //</editor-fold>
    }

    static IFunction<KoseiShichosonModel, KoikiKoseiShichoson> toKoikiKoseiShichoson() {
        //<editor-fold defaultstate="collapsed" desc="return (KoseiShichosonModel t) -> new KoikiKoseiShichoson(t)">
        return new IFunction<KoseiShichosonModel, KoikiKoseiShichoson>() {
            @Override
            public KoikiKoseiShichoson apply(KoseiShichosonModel t) {
                return new KoikiKoseiShichoson(t);
            }
        };
        //</editor-fold>
    }
}
