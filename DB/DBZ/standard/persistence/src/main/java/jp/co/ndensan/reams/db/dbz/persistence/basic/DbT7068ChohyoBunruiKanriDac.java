/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.subGyomuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanri;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanri.reportID;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票分類管理のデータアクセスクラスです。
 */
public class DbT7068ChohyoBunruiKanriDac implements ISaveable<DbT7068ChohyoBunruiKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで帳票分類管理を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票ID ReportID
     * @return DbT7068ChohyoBunruiKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7068ChohyoBunruiKanriEntity selectByKey(
            SubGyomuCode サブ業務コード,
            ReportId 帳票ID) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7068ChohyoBunruiKanri.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(reportID, 帳票ID))).
                toObject(DbT7068ChohyoBunruiKanriEntity.class);
    }

    /**
     * 帳票分類管理を全件返します。
     *
     * @return List<DbT7068ChohyoBunruiKanriEntity>
     */
    @Transaction
    public List<DbT7068ChohyoBunruiKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7068ChohyoBunruiKanri.class).
                toList(DbT7068ChohyoBunruiKanriEntity.class);
    }

    /**
     * DbT7068ChohyoBunruiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7068ChohyoBunruiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
