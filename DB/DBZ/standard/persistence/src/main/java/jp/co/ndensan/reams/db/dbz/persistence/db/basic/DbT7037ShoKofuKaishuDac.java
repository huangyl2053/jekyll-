/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.hakkoShoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.kofuShoShurui;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.lastUpdateTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishu.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 証交付回収のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-020 suguangjun
 */
public class DbT7037ShoKofuKaishuDac implements ISaveable<DbT7037ShoKofuKaishuEntity> {

    private static final RString 引数_被保険者番号 = new RString("被保険者番号");
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで証交付回収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 交付証種類 KofuShoShurui
     * @param 履歴番号 RirekiNo
     * @return DbT7037ShoKofuKaishuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7037ShoKofuKaishuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 交付証種類,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(引数_被保険者番号.toString()));
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kofuShoShurui, 交付証種類),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * 証交付回収を全件返します。
     *
     * @return List<DbT7037ShoKofuKaishuEntity>
     */
    @Transaction
    public List<DbT7037ShoKofuKaishuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                toList(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * DbT7037ShoKofuKaishuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7037ShoKofuKaishuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで証交付回収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 論理削除フラグ logicalDeletedFlag
     * @return List<DbT7037ShoKofuKaishuEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7037ShoKofuKaishuEntity> select一覧取得(
            HihokenshaNo 被保険者番号,
            boolean 論理削除フラグ) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(引数_被保険者番号.toString()));
        requireNonNull(論理削除フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("論理削除フラグ"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, 論理削除フラグ))).
                toList(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * 主キーで証交付回収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 交付証種類 KofuShoShurui
     * @param 処理日時 hakkoShoriTimestamp
     * @return DbT7037ShoKofuKaishuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7037ShoKofuKaishuEntity> select更新処理(
            RString 交付証種類,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(引数_被保険者番号.toString()));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(and(
                                eq(kofuShoShurui, 交付証種類),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(hakkoShoriTimestamp, 処理日時))).
                toList(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * DbT7037ShoKofuKaishuEntityを更新します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 更新件数
     */
    @Transaction
    public int update(DbT7037ShoKofuKaishuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * DbT7037ShoKofuKaishuEntityを削除します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT7037ShoKofuKaishuEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * 証交付回収を取得します。
     *
     * @param makeShuruiCondition 証交付回収の検索条件
     * @return DbT7037ShoKofuKaishuEntity 証交付回収情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7037ShoKofuKaishuEntity> select(ITrueFalseCriteria makeShuruiCondition) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(makeShuruiCondition).
                toList(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * 履歴番号を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT7037ShoKofuKaishuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7037ShoKofuKaishuEntity getRirekiNo(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(引数_被保険者番号.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(
                        eq(hihokenshaNo, 被保険者番号)).
                order(new OrderBy(rirekiNo, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * 被保険者番号を取得します。
     *
     * @param 識別コード 識別コード
     * @return DbT7037ShoKofuKaishuEntity 証交付回収テーブルのエンティティク
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7037ShoKofuKaishuEntity selectHihokenshaNo(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(eq(shikibetsuCode, 識別コード)).
                order(new OrderBy(lastUpdateTimestamp, Order.DESC, NullsOrder.LAST)).
                limit(1).
                toObject(DbT7037ShoKofuKaishuEntity.class);
    }

    /**
     * 主キーで証交付回収を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 交付証種類 KofuShoShurui
     * @return DbT7037ShoKofuKaishuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7037ShoKofuKaishuEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 交付証種類) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(引数_被保険者番号.toString()));
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7037ShoKofuKaishu.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(kofuShoShurui, 交付証種類)
                        )).
                order(by(DbT7037ShoKofuKaishu.rirekiNo, Order.DESC)).
                limit(1).
                toObject(DbT7037ShoKofuKaishuEntity.class);
    }
}
