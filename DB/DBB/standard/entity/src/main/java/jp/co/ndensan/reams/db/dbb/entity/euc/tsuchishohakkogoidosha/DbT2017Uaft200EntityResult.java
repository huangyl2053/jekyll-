/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.euc.tsuchishohakkogoidosha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;

/**
 * DbT2017Uaft200EntityResult
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbT2017Uaft200EntityResult implements Serializable {

    private final DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity;
    private final AtenaMeisho 名称;

    /**
     * DbT2017Uaft200EntityResult
     *
     * @param dbT2017Entity dbT2017Entity
     * @param 名称 名称
     */
    public DbT2017Uaft200EntityResult(DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity,
            AtenaMeisho 名称) {
        this.dbT2017Entity = dbT2017Entity;
        this.名称 = 名称;
    }

    /**
     * DbT2017Uaft200EntityResult
     */
    public DbT2017Uaft200EntityResult() {
        this.dbT2017Entity = null;
        this.名称 = null;
    }
}
