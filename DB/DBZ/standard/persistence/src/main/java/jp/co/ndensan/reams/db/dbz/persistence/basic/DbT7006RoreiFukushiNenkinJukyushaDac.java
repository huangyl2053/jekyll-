/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyusha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyusha.jukyuKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyusha.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者のデータアクセスクラスです。
 *
 * @author LDNS 賈楽楽
 */
public class DbT7006RoreiFukushiNenkinJukyushaDac implements IModifiable<DbT7006RoreiFukushiNenkinJukyushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで老齢福祉年金受給者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 受給開始日 JukyuKaishiYMD
     * @return DbT7006RoreiFukushiNenkinJukyushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7006RoreiFukushiNenkinJukyushaEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 受給開始日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(受給開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7006RoreiFukushiNenkinJukyusha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(jukyuKaishiYMD, 受給開始日))).
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

    @Transaction
    @Override
    public int insert(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7006RoreiFukushiNenkinJukyushaEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
