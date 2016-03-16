/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2001ChoshuHohoEntity;

/**
 * 対象データ
 */
@lombok.Getter
@lombok.Setter
public class DBV2001EntityResult {

    private final DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity;
    private final DbV2001ChoshuHohoEntity dbv2001Entity;

    public DBV2001EntityResult(DbT2017TsuchishoHakkogoIdoshaEntity dbT2017Entity,
            DbV2001ChoshuHohoEntity dbv2001Entity) {
        this.dbT2017Entity = dbT2017Entity;
        this.dbv2001Entity = dbv2001Entity;
    }

    public DBV2001EntityResult() {
        this.dbT2017Entity = null;
        this.dbv2001Entity = null;
    }
}
