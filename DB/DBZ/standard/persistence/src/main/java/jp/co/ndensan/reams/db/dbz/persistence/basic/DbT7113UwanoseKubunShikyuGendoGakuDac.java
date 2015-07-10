/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7113UwanoseKubunShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7113UwanoseKubunShikyuGendoGaku.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7113UwanoseKubunShikyuGendoGaku.tekiyoKaishiYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7113UwanoseKubunShikyuGendoGaku.yoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7113UwanoseKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 上乗せ居宅サービス区分支給限度額のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7113UwanoseKubunShikyuGendoGakuDac implements IModifiable<DbT7113UwanoseKubunShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで上乗せ居宅サービス区分支給限度額を取得します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT7113UwanoseKubunShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7113UwanoseKubunShikyuGendoGakuEntity selectByKey(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7113UwanoseKubunShikyuGendoGaku.class).
                where(and(
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT7113UwanoseKubunShikyuGendoGakuEntity.class);
    }

    /**
     * 上乗せ居宅サービス区分支給限度額を全件返します。
     *
     * @return List<DbT7113UwanoseKubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7113UwanoseKubunShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7113UwanoseKubunShikyuGendoGaku.class).
                toList(DbT7113UwanoseKubunShikyuGendoGakuEntity.class);
    }

    /**
     * 上乗せ居宅サービス区分支給限度額を追加します。
     *
     * @param entity 上乗せ居宅サービス区分支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7113UwanoseKubunShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 上乗せ居宅サービス区分支給限度額をDBに更新します。
     *
     * @param entity 上乗せ居宅サービス区分支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7113UwanoseKubunShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 上乗せ居宅サービス区分支給限度額をDBから削除します。（論理削除）
     *
     * @param entity 上乗せ居宅サービス区分支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7113UwanoseKubunShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 上乗せ居宅サービス区分支給限度額を物理削除。
     *
     * @param entity 上乗せ居宅サービス区分支給限度額
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7113UwanoseKubunShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
