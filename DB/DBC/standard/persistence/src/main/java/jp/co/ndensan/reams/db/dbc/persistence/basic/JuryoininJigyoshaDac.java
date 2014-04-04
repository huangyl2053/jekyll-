/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha.insertTimestamp;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha.jigyoshaKeiyakuNo;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IInsertable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorForAddType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任事業者のデータアクセスクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaDac implements
        IDeletable<DbT3077JuryoininKeiyakuJigyoshaEntity>,
        IInsertable<DbT3077JuryoininKeiyakuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 契約番号に対応する１つの受領委任事業者エンティティを取得します。
     *
     * @param 契約番号 契約番号
     * @return 受領委任事業者エンティティ
     */
    @Transaction
    public DbT3077JuryoininKeiyakuJigyoshaEntity select(KeiyakuNo 契約番号) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);

        List<DbT3077JuryoininKeiyakuJigyoshaEntity> entities;
        entities = accessor.
                select().
                table(DbT3077JuryoininKeiyakuJigyosha.class).
                where(eq(jigyoshaKeiyakuNo, 契約番号.value())).
                order(by(insertTimestamp, Order.DESC)).
                toList(DbT3077JuryoininKeiyakuJigyoshaEntity.class);

        if (entities.isEmpty()) {
            return null;
        }
        return entities.get(0);
    }

    /**
     * 検索条件に該当する受領委任事業者エンティティを複数取得します。
     *
     * @param criteria 検索条件
     * @return 受領委任事業者エンティティリスト
     */
    //TODO n3317 塚田萌　本実装の時に対応する。期限　本実装完了まで
    @Transaction
    public List<DbT3077JuryoininKeiyakuJigyoshaEntity> select(ITrueFalseCriteria criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insert(data).execute();
    }

    @Override
    public int delete(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        DbAccessorForAddType accessor = new DbAccessorForAddType(session);
        return accessor.insertDenialRow(data).execute();
    }
}
