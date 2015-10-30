/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJoho.renban;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJoho.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護連絡先情報のデータアクセスクラスです。
 */
public class DbT5150RenrakusakiJohoDac implements ISaveable<DbT5150RenrakusakiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護連絡先情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     *
     * @return DbT5150RenrakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5150RenrakusakiJohoEntity selectByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 連番) throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5150RenrakusakiJoho.class).
                where(and(
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(renban, 連番))).
                toObject(DbT5150RenrakusakiJohoEntity.class);
    }

    /**
     * 介護連絡先情報を全件返します。
     *
     * @return DbT5150RenrakusakiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5150RenrakusakiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5150RenrakusakiJoho.class).
                toList(DbT5150RenrakusakiJohoEntity.class);
    }

    /**
     * DbT5150RenrakusakiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5150RenrakusakiJohoEntity entity) {

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
