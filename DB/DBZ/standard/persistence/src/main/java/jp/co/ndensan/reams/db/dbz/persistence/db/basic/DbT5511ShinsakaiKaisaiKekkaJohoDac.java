/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJoho.shinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催結果情報のデータアクセスクラスです。
 */
public class DbT5511ShinsakaiKaisaiKekkaJohoDac implements ISaveable<DbT5511ShinsakaiKaisaiKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会開催結果情報を取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return DbT5511ShinsakaiKaisaiKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5511ShinsakaiKaisaiKekkaJohoEntity selectByKey(
            RString 介護認定審査会開催番号) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5511ShinsakaiKaisaiKekkaJoho.class).
                where(
                        eq(shinsakaiKaisaiNo, 介護認定審査会開催番号)).
                toObject(DbT5511ShinsakaiKaisaiKekkaJohoEntity.class);
    }

    /**
     * 介護認定審査会開催結果情報を全件返します。
     *
     * @return DbT5511ShinsakaiKaisaiKekkaJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5511ShinsakaiKaisaiKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5511ShinsakaiKaisaiKekkaJoho.class).
                toList(DbT5511ShinsakaiKaisaiKekkaJohoEntity.class);
    }

    /**
     * DbT5511ShinsakaiKaisaiKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5511ShinsakaiKaisaiKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催結果情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
