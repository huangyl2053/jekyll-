/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGaku;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGaku.tekiyoKaishiYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGaku.yoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
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
 * 居宅サービス区分支給限度額のデータアクセスクラスです。
 */
public class DbT7109KubunShikyuGendoGakuDac implements
        ISaveable<DbT7109KubunShikyuGendoGakuEntity>, IDeletable<DbT7109KubunShikyuGendoGakuEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString 定値_要介護状態区分 = new RString("要介護状態区分");
    private static final RString 定値_適用開始年月 = new RString("適用開始年月");
    private static final RString 定値_履歴番号 = new RString("履歴番号");
    private static final RString 定値_エンティティ
            = new RString("居宅サービス区分支給限度額エンティティ");

    /**
     * 主キーで居宅サービス区分支給限度額を取得します。
     *
     * @param 要介護状態区分 YoKaigoJotaiKubun
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7109KubunShikyuGendoGakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7109KubunShikyuGendoGakuEntity selectByKey(
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_要介護状態区分.toString()));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_適用開始年月.toString()));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_履歴番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7109KubunShikyuGendoGaku.class).
                where(and(
                                eq(yoKaigoJotaiKubun, 要介護状態区分),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7109KubunShikyuGendoGakuEntity.class);
    }

    /**
     * 居宅サービス区分支給限度額を全件返します。
     *
     * @return List<DbT7109KubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7109KubunShikyuGendoGakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7109KubunShikyuGendoGaku.class).
                toList(DbT7109KubunShikyuGendoGakuEntity.class);
    }

    /**
     * 居宅サービス区分支給限度額を全件返します。
     *
     * @return List<DbT7109KubunShikyuGendoGakuEntity>
     */
    @Transaction
    public List<DbT7109KubunShikyuGendoGakuEntity> selectAllOrder() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7109KubunShikyuGendoGaku.class).order(
                        by(tekiyoKaishiYM, Order.DESC),
                        by(yoKaigoJotaiKubun, Order.ASC)).
                toList(DbT7109KubunShikyuGendoGakuEntity.class);
    }

    /**
     * DbT7109KubunShikyuGendoGakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7109KubunShikyuGendoGakuEntity entity) {
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
    public int delete(DbT7109KubunShikyuGendoGakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(定値_エンティティ.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
