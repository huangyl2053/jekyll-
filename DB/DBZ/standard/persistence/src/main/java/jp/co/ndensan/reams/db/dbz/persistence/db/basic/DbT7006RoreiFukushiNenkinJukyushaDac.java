/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyusha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyusha.jukyuKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyusha.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者のデータアクセスクラスです。
 */
public class DbT7006RoreiFukushiNenkinJukyushaDac implements ISaveable<DbT7006RoreiFukushiNenkinJukyushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで老齢福祉年金受給者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 受給開始年月日 JukyuKaishiYMD
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7006RoreiFukushiNenkinJukyushaEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 受給開始年月日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(受給開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7006RoreiFukushiNenkinJukyusha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(jukyuKaishiYMD, 受給開始年月日))).
                toObject(DbT7006RoreiFukushiNenkinJukyushaEntity.class);
    }

    /**
     * 老齢福祉年金受給者を全件返します。
     *
     * @return List<DbT7006RoreiFukushiNenkinJukyushaEntity>
     */
    @Transaction
    public List<DbT7006RoreiFukushiNenkinJukyushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7006RoreiFukushiNenkinJukyusha.class).
                toList(DbT7006RoreiFukushiNenkinJukyushaEntity.class);
    }

    /**
     * DbT7006RoreiFukushiNenkinJukyushaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 識別コードに老齢福祉年金受給者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity 老齢福祉年金受給者情報
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7006RoreiFukushiNenkinJukyushaEntity> selectByShikibetsuCode(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7006RoreiFukushiNenkinJukyusha.class).
                where(eq(DbT7006RoreiFukushiNenkinJukyusha.shikibetsuCode, 識別コード)).
                toList(DbT7006RoreiFukushiNenkinJukyushaEntity.class);
    }

    /**
     * 老齢福祉年金履歴情報を登録前重複チェックするです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 受給開始年月日 JukyuKaishiYMD
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int countfor老齢福祉年金履歴情報を取得(
            ShikibetsuCode 識別コード,
            FlexibleDate 受給開始年月日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(受給開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始年月日"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7006RoreiFukushiNenkinJukyusha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(jukyuKaishiYMD, 受給開始年月日))).getCount();
    }

    /**
     * 入力識別コードで老齢福祉年金履歴情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return List<DbT7006RoreiFukushiNenkinJukyushaEntity>
     *
     */
    @Transaction
    public List<DbT7006RoreiFukushiNenkinJukyushaEntity> selectfor老齢福祉年金履歴情報を取得(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7006RoreiFukushiNenkinJukyusha.class).
                where(eq(shikibetsuCode, 識別コード)).
                toList(DbT7006RoreiFukushiNenkinJukyushaEntity.class);
    }
}
