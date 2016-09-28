/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGaku.tekiyoKaishiYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGaku.yoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7113UwanoseKubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 上乗せ居宅サービス区分支給限度額のデータアクセスクラスです。
 */
public class DbT7113UwanoseKubunShikyuGendoGakuDac implements
        ISaveable<DbT7113UwanoseKubunShikyuGendoGakuEntity>, IDeletable<DbT7113UwanoseKubunShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 定値_要介護状態区分 = new RString("要介護状態区分");
    private static final RString 定値_適用開始年月 = new RString("適用開始年月");
    private static final RString 定値_履歴番号 = new RString("履歴番号");
    private static final RString 定値_エンティティ
            = new RString("上乗せ居宅サービス区分支給限度額エンティティ");

    /**
     * 主キーで上乗せ居宅サービス区分支給限度額を取得します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7113UwanoseKubunShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7113UwanoseKubunShikyuGendoGakuEntity selectByKey(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_要介護状態区分.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7113UwanoseKubunShikyuGendoGaku.class).
                where(and(
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
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
     * 上乗せ居宅サービス区分支給限度額を全件返します。
     *
     * @return List<DbT7113UwanoseKubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7113UwanoseKubunShikyuGendoGakuEntity> selectAllOrder() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7113UwanoseKubunShikyuGendoGaku.class).order(
                        by(tekiyoKaishiYM, Order.DESC),
                        by(yoKaigoJotaiKubun, Order.ASC)).
                toList(DbT7113UwanoseKubunShikyuGendoGakuEntity.class);
    }

    /**
     * DbT7113UwanoseKubunShikyuGendoGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7113UwanoseKubunShikyuGendoGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * データを物理削除する
     *
     * @param entity DbT7112ShokanShuruiShikyuGendoGakuEntity
     * @return 更新件数 更新結果の件数を返します。
     */
    @Override
    public int delete(DbT7113UwanoseKubunShikyuGendoGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_エンティティ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
