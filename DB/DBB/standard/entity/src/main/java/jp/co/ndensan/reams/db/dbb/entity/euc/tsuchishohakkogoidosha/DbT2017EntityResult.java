/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.euc.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;

/**
 * 対象データ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT2017EntityResult {

    private final DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity;
    private final ShikibetsuTaishoIdoJoho uaFt001Entity;

    /**
     * DbT2017EntityResult
     *
     * @param dbT2017Entity dbT2017Entity
     * @param uaFt001Entity uaFt001Entity
     */
    public DbT2017EntityResult(DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity,
            ShikibetsuTaishoIdoJoho uaFt001Entity) {
        this.dbT2017Entity = dbT2017Entity;
        this.uaFt001Entity = uaFt001Entity;
    }

    /**
     * DbT2017EntityResult
     */
    public DbT2017EntityResult() {
        this.dbT2017Entity = null;
        this.uaFt001Entity = null;
    }

}
