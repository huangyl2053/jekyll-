/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyosha.*;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;

/**
 * 受領委任事業者のデータアクセスクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaDac implements
        IReplaceable<DbT3077JuryoininKeiyakuJigyoshaEntity>, IDeletable<DbT3077JuryoininKeiyakuJigyoshaEntity> {

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
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT3077JuryoininKeiyakuJigyoshaEntity> entities;
        entities = accessor.
                select().
                table(DbT3077JuryoininKeiyakuJigyosha.class).
                where(eq(jigyoshaKeiyakuNo, 契約番号.value())).
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
    public int insertOrUpdate(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        return getMatchRowCount(data) == 0 ? insert(data) : update(data);
    }

    @Override
    public int insert(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(data).execute();
    }

    @Override
    public int update(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(data).execute();
    }

    @Override
    public int delete(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(data).execute();
    }

    private int getMatchRowCount(DbT3077JuryoininKeiyakuJigyoshaEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT3077JuryoininKeiyakuJigyosha.class)
                .where(and(
                                eq(jigyoshaKeiyakuNo, data.getJigyoshaKeiyakuNo()),
                                eq(kaishiYMD, data.getKaishiYMD()),
                                eq(shoriTimestamp, data.getShoriTimestamp())))
                .getCount();
    }
}
