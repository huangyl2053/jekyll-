/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJoho.remban;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJoho.shinsakaiIinCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJoho.shinsakaiIinHoshuKubun;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJoho.shinsakaiKaisaiYMD;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5603ShinsakaiIinHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員報酬実績情報のデータアクセスクラスです。
 *
 * @author LDNS 焦蘇晋
 */
public class DbT5603ShinsakaiIinHoshuJissekiJohoDac implements ISaveable<DbT5603ShinsakaiIinHoshuJissekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会委員報酬実績情報を取得します。
     *
     * @param 介護認定審査会委員コード RString
     * @param 審査会委員報酬区分 Code
     * @param 実施年月日 FlexibleDate
     * @param 連番 int
     * @return DbT5603ShinsakaiIinHoshuJissekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5603ShinsakaiIinHoshuJissekiJohoEntity selectByKey(
            RString 介護認定審査会委員コード,
            Code 審査会委員報酬区分,
            FlexibleDate 実施年月日,
            int 連番) throws NullPointerException {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(審査会委員報酬区分, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員報酬区分"));
        requireNonNull(実施年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("実施年月日"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5603ShinsakaiIinHoshuJissekiJoho.class).
                where(and(
                                eq(shinsakaiIinCode, 介護認定審査会委員コード),
                                eq(shinsakaiIinHoshuKubun, 審査会委員報酬区分),
                                eq(shinsakaiKaisaiYMD, 実施年月日),
                                eq(remban, 連番))).
                toObject(DbT5603ShinsakaiIinHoshuJissekiJohoEntity.class);
    }

    /**
     * 介護認定審査会委員報酬実績情報を全件返します。
     *
     * @return List<DbT5603ShinsakaiIinHoshuJissekiJohoEntity>
     */
    @Transaction
    public List<DbT5603ShinsakaiIinHoshuJissekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5603ShinsakaiIinHoshuJissekiJoho.class).
                toList(DbT5603ShinsakaiIinHoshuJissekiJohoEntity.class);
    }

//    @Transaction
//    @Override
//    public int insert(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.insert(entity).execute();
//    }
//
//    @Transaction
//    @Override
//    public int update(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.update(entity).execute();
//    }
//    @Transaction
//    @Override
//    public int delete(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.delete(entity).execute();
//    }
//    @Transaction
//    public int delete(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.delete(entity).execute();
//    }
    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * OCR収入を物理削除。
     *
     * @param entity OCR収入
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * DbT5603ShinsakaiIinHoshuJissekiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員報酬入力実績情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
