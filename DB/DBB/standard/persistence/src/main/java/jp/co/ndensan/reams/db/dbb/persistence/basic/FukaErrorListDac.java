/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorList;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課エラー一覧の情報を取得するDacです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorListDac {

    @InjectSession
    private SqlSession session;

    /**
     * 賦課エラー一覧から全ての情報を取得します。
     *
     * @return 賦課エラー一覧EntityList
     */
    @Transaction
    public List<DbT2010FukaErrorListEntity> select() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT2010FukaErrorList.class).toList(DbT2010FukaErrorListEntity.class);
    }

    /**
     * 内部帳票の作成日時を指定して、賦課エラー一覧から情報を取得します。
     *
     * @param reportCreationDateTime 内部帳票作成日時
     * @return 賦課エラー一覧EntityList
     */
    @Transaction
    public List<DbT2010FukaErrorListEntity> select(RDateTime reportCreationDateTime) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT2010FukaErrorList.class)
                .where(eq(DbT2010FukaErrorList.internalReportCreationDateTime, reportCreationDateTime))
                .toList(DbT2010FukaErrorListEntity.class);
    }

    /**
     * 賦課年度と通知書番号を指定して、賦課エラー一覧から1行分のデータを取得します。
     *
     * @param fukaNendo 賦課年度
     * @param tsuchishoNo 通知書番号
     * @return 賦課エラー一覧の、一行分のデータ
     */
    @Transaction
    public DbT2010FukaErrorListEntity select(FlexibleYear fukaNendo, TsuchishoNo tsuchishoNo) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT2010FukaErrorList.class)
                .where(
                        and(
                                eq(DbT2010FukaErrorList.fukaNendo, fukaNendo),
                                eq(DbT2010FukaErrorList.tsuchishoNo, tsuchishoNo)
                        )
                )
                .toObject(DbT2010FukaErrorListEntity.class);
    }

    /**
     * 賦課エラー一覧Entityを受け取り、その情報を元にテーブルを更新します。
     *
     * @param entity 賦課エラー一覧Entity
     * @return 更新に成功した場合、1
     */
    @Transaction
    public int update(DbT2010FukaErrorListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 賦課エラー一覧Entityを受け取り、その情報をテーブルから削除します。
     *
     * @param entity 賦課エラー一覧Entity
     * @return 削除に成功した場合、1
     */
    @Transaction
    public int delete(DbT2010FukaErrorListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

}
