/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaicho.remban;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
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
            Decimal 連番) throws NullPointerException {
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
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
