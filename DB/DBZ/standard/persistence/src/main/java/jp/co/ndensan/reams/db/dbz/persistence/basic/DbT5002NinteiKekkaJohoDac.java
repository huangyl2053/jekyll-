/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJoho.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class DbT5002NinteiKekkaJohoDac implements IModifiable<DbT5002NinteiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定結果情報を取得します。
     *
     * @param 申請書管理番号 shinseishoKanriNo
     * @param 処理日時 shoriTimestamp
     * @return DbT5002NinteiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5002NinteiKekkaJohoEntity selectByKey(
            RString 申請書管理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5002NinteiKekkaJoho.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT5002NinteiKekkaJohoEntity.class);
    }

    /**
     * 要介護認定結果情報を全件返します。
     *
     * @return List<DbT5002NinteiKekkaJohoEntity>
     */
    @Transaction
    public List<DbT5002NinteiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5002NinteiKekkaJoho.class).
                toList(DbT5002NinteiKekkaJohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT5002NinteiKekkaJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT5002NinteiKekkaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
