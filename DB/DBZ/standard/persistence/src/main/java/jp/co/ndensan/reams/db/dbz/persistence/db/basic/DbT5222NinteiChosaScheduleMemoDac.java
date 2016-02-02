/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.chosachikucode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.memoKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.memoPriority;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.memoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemo.remban;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5222NinteiChosaScheduleMemoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュールメモ情報のデータアクセスクラスです。
 */
public class DbT5222NinteiChosaScheduleMemoDac implements ISaveable<DbT5222NinteiChosaScheduleMemoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査スケジュールメモ情報を取得します。
     *
     * @param メモ年月日 メモ年月日
     * @param メモ区分 メモ区分
     * @param 連番 連番
     * @return DbT5222NinteiChosaScheduleMemoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5222NinteiChosaScheduleMemoEntity selectByKey(
            FlexibleDate メモ年月日,
            Code メモ区分,
            int 連番) throws NullPointerException {
        requireNonNull(メモ年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ年月日"));
        requireNonNull(メモ区分, UrSystemErrorMessages.値がnull.getReplacedMessage("メモ区分"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5222NinteiChosaScheduleMemo.class).
                where(and(
                                eq(memoYMD, メモ年月日),
                                eq(memoKubun, メモ区分),
                                eq(remban, 連番))).
                toObject(DbT5222NinteiChosaScheduleMemoEntity.class);
    }

    /**
     * 認定調査スケジュールメモ情報を全件返します。
     *
     * @return DbT5222NinteiChosaScheduleMemoEntityの{@code list}
     */
    @Transaction
    public List<DbT5222NinteiChosaScheduleMemoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5222NinteiChosaScheduleMemo.class).
                toList(DbT5222NinteiChosaScheduleMemoEntity.class);
    }

    /**
     * DbT5222NinteiChosaScheduleMemoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5222NinteiChosaScheduleMemoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュールメモ情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5222NinteiChosaScheduleMemoEntityを削除します。状態によってdelete処理に振り分けられます。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT5222NinteiChosaScheduleMemoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュールメモ情報エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 認定調査スケジュールメモ情報を全件返します。
     *
     * @param メモ年月日 メモ年月日
     * @param 地区コード 地区コード
     * @return DbT5222NinteiChosaScheduleMemoEntityの{@code list}
     */
    public List<DbT5222NinteiChosaScheduleMemoEntity> get認定調査スケジュールメモ情報(
            FlexibleDate メモ年月日,
            Code 地区コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5222NinteiChosaScheduleMemo.class).
                where(and(
                                eq(memoYMD, メモ年月日),
                                eq(chosachikucode, 地区コード),
                                or(eq(memoKubun, new Code("1")),
                                        eq(memoKubun, new Code("2"))),
                                eq(memoPriority, new Code("2")))).
                toList(DbT5222NinteiChosaScheduleMemoEntity.class);
    }

    /**
     * MAX(連番) を取得します。
     *
     * @return MAX(連番)
     */
    public DbT5222NinteiChosaScheduleMemoEntity getMaxNo() {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(remban)).
                table(DbT5222NinteiChosaScheduleMemo.class).toObject(DbT5222NinteiChosaScheduleMemoEntity.class);
    }

    /**
     * メモ情報件数を取得します。
     *
     * @param makeShuruiCondition 検索条件
     * @return 通常件数／重要件数
     */
    public int getCount(ITrueFalseCriteria makeShuruiCondition) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().table(DbT5222NinteiChosaScheduleMemo.class).
                where(makeShuruiCondition).getCount();
    }
}
