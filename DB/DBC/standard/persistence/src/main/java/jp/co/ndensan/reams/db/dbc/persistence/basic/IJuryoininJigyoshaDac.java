/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author N3317 塚田 萌
 */
public interface IJuryoininJigyoshaDac extends
        IDeletable<DbT3077JuryoininKeiyakuJigyoshaEntity>,
        IInsertable<DbT3077JuryoininKeiyakuJigyoshaEntity> {

    @Transaction
    DbT3077JuryoininKeiyakuJigyoshaEntity select(KeiyakuNo 契約番号);

    //TODO n3317 塚田萌　受領委任チケットにて実装するときに実装する。　2014/7月末
    @Transaction
    List<DbT3077JuryoininKeiyakuJigyoshaEntity> select(ITrueFalseCriteria criteria);

}
