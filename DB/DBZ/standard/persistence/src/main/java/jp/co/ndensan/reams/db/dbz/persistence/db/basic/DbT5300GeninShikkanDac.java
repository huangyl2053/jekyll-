/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkan;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkan.remban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkan.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 原因疾患のデータアクセスクラスです。
 */
public class DbT5300GeninShikkanDac implements ISaveable<DbT5300GeninShikkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで原因疾患を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     * @return DbT5300GeninShikkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5300GeninShikkanEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 連番) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5300GeninShikkan.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(remban, 連番))).
                toObject(DbT5300GeninShikkanEntity.class);
    }

    /**
     * 原因疾患を全件返します。
     *
     * @return DbT5300GeninShikkanEntityの{@code list}
     */
    @Transaction
    public List<DbT5300GeninShikkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5300GeninShikkan.class).
                toList(DbT5300GeninShikkanEntity.class);
    }

    /**
     * DbT5300GeninShikkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5300GeninShikkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("原因疾患エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
