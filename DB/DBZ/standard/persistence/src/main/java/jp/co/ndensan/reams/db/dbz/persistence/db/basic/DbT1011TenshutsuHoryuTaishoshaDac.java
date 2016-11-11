/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishosha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishosha.atenaKanaShimei;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishosha.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishosha.seibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishosha.seinengappiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishosha.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転出保留対象者のデータアクセスクラスです。
 */
public class DbT1011TenshutsuHoryuTaishoshaDac implements ISaveable<DbT1011TenshutsuHoryuTaishoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで転出保留対象者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbT1011TenshutsuHoryuTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1011TenshutsuHoryuTaishoshaEntity selectByKey(
            ShikibetsuCode 識別コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1011TenshutsuHoryuTaishosha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT1011TenshutsuHoryuTaishoshaEntity.class);
    }

    /**
     * 識別コードで転出保留対象者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<DbT1011TenshutsuHoryuTaishoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1011TenshutsuHoryuTaishoshaEntity> selectBy識別コード(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1011TenshutsuHoryuTaishosha.class).
                where(eq(shikibetsuCode, 識別コード)).
                toList(DbT1011TenshutsuHoryuTaishoshaEntity.class);
    }

    /**
     * 転出保留対象者を全件返します。
     *
     * @return List<DbT1011TenshutsuHoryuTaishoshaEntity>
     */
    @Transaction
    public List<DbT1011TenshutsuHoryuTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1011TenshutsuHoryuTaishosha.class).
                toList(DbT1011TenshutsuHoryuTaishoshaEntity.class);
    }

    /**
     * 主キーで転出保留対象者を取得します。
     *
     * @param 宛名カナ氏名 AtenaKanaMeisho
     * @param 生年月日 FlexibleDate
     * @param 性別コード RString
     * @return List<DbT1011TenshutsuHoryuTaishoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1011TenshutsuHoryuTaishoshaEntity> get転出保留対象者(
            AtenaKanaMeisho 宛名カナ氏名, FlexibleDate 生年月日, RString 性別コード) throws NullPointerException {
        requireNonNull(宛名カナ氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("宛名カナ氏名"));
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));
        requireNonNull(性別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("性別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(rirekiNo), shikibetsuCode).
                table(DbT1011TenshutsuHoryuTaishosha.class).
                where(and(
                                eq(atenaKanaShimei, 宛名カナ氏名),
                                eq(seinengappiYMD, 生年月日),
                                eq(seibetsuCode, 性別コード))).
                groupBy(shikibetsuCode).toList(DbT1011TenshutsuHoryuTaishoshaEntity.class);
    }

    /**
     * 主キーで転出保留対象者を取得します。
     *
     * @param 生年月日 FlexibleDate
     * @return List<DbT1011TenshutsuHoryuTaishoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT1011TenshutsuHoryuTaishoshaEntity> get転出保留対象者(FlexibleDate 生年月日) throws NullPointerException {
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("生年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(rirekiNo), shikibetsuCode).
                table(DbT1011TenshutsuHoryuTaishosha.class).
                where(
                        eq(seinengappiYMD, 生年月日)).
                groupBy(shikibetsuCode).toList(DbT1011TenshutsuHoryuTaishoshaEntity.class);
    }

    /**
     * DbT1011TenshutsuHoryuTaishoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1011TenshutsuHoryuTaishoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転出保留対象者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT1011TenshutsuHoryuTaishoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int deletePhysical(DbT1011TenshutsuHoryuTaishoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転出保留対象者エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.deletePhysical(entity).execute();
    }

    /**
     * 転出保留対象者の履歴番号の取得。
     *
     * @param 識別コード 識別コード
     * @return DbT1011TenshutsuHoryuTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1011TenshutsuHoryuTaishoshaEntity get転出保留対象者の履歴番号Max(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT1011TenshutsuHoryuTaishosha.class).
                where(eq(shikibetsuCode, 識別コード)).
                toObject(DbT1011TenshutsuHoryuTaishoshaEntity.class);
    }
}
