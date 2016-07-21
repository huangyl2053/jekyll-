/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;

/**
 * 対象データ
 *
 * @reamsid_L DBB-0690-020 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class Dbv2001EntityResult {

    private final DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity;
    private final DbV2001ChoshuHohoEntity dbv2001Entity;

    /**
     * DBV2001EntityResult
     *
     * @param dbT2017Entity dbT2017Entity
     * @param dbv2001Entity dbv2001Entity
     */
    public Dbv2001EntityResult(DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity,
            DbV2001ChoshuHohoEntity dbv2001Entity) {
        this.dbT2017Entity = dbT2017Entity;
        this.dbv2001Entity = dbv2001Entity;
    }

    /**
     * DBV2001EntityResult
     */
    public Dbv2001EntityResult() {
        this.dbT2017Entity = null;
        this.dbv2001Entity = null;
    }
}
