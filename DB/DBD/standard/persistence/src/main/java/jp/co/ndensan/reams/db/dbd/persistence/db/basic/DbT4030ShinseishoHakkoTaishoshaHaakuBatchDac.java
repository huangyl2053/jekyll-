/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatch;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatch.batchExecutedTimestamp;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatch.gemmenGengakuShurui;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatch.haakuShoriID;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請書発行対象者把握情報を取得する。
 *
 * @reamsid_L DBD-3530-060 liuyl
 */
public class DbT4030ShinseishoHakkoTaishoshaHaakuBatchDac {

    @InjectSession
    private SqlSession sqlSession;

    /**
     * 最新の把握情報を取得する。
     *
     * @return DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity
     */
    @Transaction
    public DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity select最新の把握情報() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(sqlSession);
        return accessor.select().table(DbT4030ShinseishoHakkoTaishoshaHaakuBatch.class).
                order(by(DbT4030ShinseishoHakkoTaishoshaHaakuBatch.batchExecutedTimestamp, Order.DESC)).limit(1)
                .toObject(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity.class);
    }

    /**
     * 一年間の基準日時を取得する。
     *
     * @param 減免減額種類 RString
     * @return List<DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity>
     */
    @Transaction
    public List<DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity> select基準日時(RString 減免減額種類) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(sqlSession);
        return accessor.select().table(DbT4030ShinseishoHakkoTaishoshaHaakuBatch.class).
                where(and(
                                eq(gemmenGengakuShurui, 減免減額種類),
                                leq(batchExecutedTimestamp, YMDHMS.now()),
                                leq(YMDHMS.now().minusYear(1), batchExecutedTimestamp))).
                toList(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity.class);
    }

    /**
     * 把握情報を取得する。
     *
     * @param 把握処理ID UUID
     * @return DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity
     */
    @Transaction
    public DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity select把握情報(UUID 把握処理ID) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(sqlSession);
        return accessor.select().table(DbT4030ShinseishoHakkoTaishoshaHaakuBatch.class).
                where(
                        eq(haakuShoriID, 把握処理ID)
                ).limit(1).toObject(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity.class);
    }

    /**
     * 把握処理IDを取得する。
     *
     * @param バッチ処理日時 YMDHMS
     * @return DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity
     */
    @Transaction
    public DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity select把握処理ID(YMDHMS バッチ処理日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(sqlSession);
        return accessor.select().table(DbT4030ShinseishoHakkoTaishoshaHaakuBatch.class).
                where(
                        eq(batchExecutedTimestamp, バッチ処理日時)
                ).limit(1).toObject(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity.class);
    }
}
