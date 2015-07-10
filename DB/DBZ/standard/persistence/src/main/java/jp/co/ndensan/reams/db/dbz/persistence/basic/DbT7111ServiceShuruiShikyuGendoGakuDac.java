/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku.tekiyoKaishuYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGaku.yoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7111ServiceShuruiShikyuGendoGakuEntity;
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
 * サービス種類支給限度額のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7111ServiceShuruiShikyuGendoGakuDac implements IModifiable<DbT7111ServiceShuruiShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでサービス種類支給限度額を取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishuYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT7111ServiceShuruiShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7111ServiceShuruiShikyuGendoGakuEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishuYM, 適用開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * サービス種類支給限度額を全件返します。
     *
     * @return List<DbT7111ServiceShuruiShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7111ServiceShuruiShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7111ServiceShuruiShikyuGendoGaku.class).
                toList(DbT7111ServiceShuruiShikyuGendoGakuEntity.class);
    }

    /**
     * サービス種類支給限度額を追加します。
     *
     * @param entity サービス種類支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * サービス種類支給限度額をDBに更新します。
     *
     * @param entity サービス種類支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * サービス種類支給限度額をDBから削除します。（論理削除）
     *
     * @param entity サービス種類支給限度額
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * サービス種類支給限度額を物理削除。
     *
     * @param entity サービス種類支給限度額
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
