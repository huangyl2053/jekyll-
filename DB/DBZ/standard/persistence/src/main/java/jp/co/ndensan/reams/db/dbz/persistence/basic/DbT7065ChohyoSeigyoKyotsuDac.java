/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsu.chohyoBunruiID;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsu.subGyomuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御共通のデータアクセスクラスです。
 */
public class DbT7065ChohyoSeigyoKyotsuDac implements ISaveable<DbT7065ChohyoSeigyoKyotsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで帳票制御共通を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @return DbT7065ChohyoSeigyoKyotsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7065ChohyoSeigyoKyotsuEntity selectByKey(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7065ChohyoSeigyoKyotsu.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(chohyoBunruiID, 帳票分類ID))).
                toObject(DbT7065ChohyoSeigyoKyotsuEntity.class);
    }

    /**
     * 帳票制御共通を全件返します。
     *
     * @return List<DbT7065ChohyoSeigyoKyotsuEntity>
     */
    @Transaction
    public List<DbT7065ChohyoSeigyoKyotsuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7065ChohyoSeigyoKyotsu.class).
                toList(DbT7065ChohyoSeigyoKyotsuEntity.class);
    }

    /**
     * DbT7065ChohyoSeigyoKyotsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7065ChohyoSeigyoKyotsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
