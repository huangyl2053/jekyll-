/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyusha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyusha.jukyuKaishiYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
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
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
