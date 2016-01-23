/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyo.chohyoBunruiID;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyo.kanriNendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyo.komokuName;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyo.subGyomuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御汎用のデータアクセスクラスです。
 */
public class DbT7067ChohyoSeigyoHanyoDac implements ISaveable<DbT7067ChohyoSeigyoHanyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで帳票制御汎用を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @param 管理年度 FlexibleYear
     * @param 項目名 KomokuName
     * @return DbT7067ChohyoSeigyoHanyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7067ChohyoSeigyoHanyoEntity selectByKey(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID,
            FlexibleYear 管理年度,
            RString 項目名) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        requireNonNull(管理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("管理年度"));
        requireNonNull(項目名, UrSystemErrorMessages.値がnull.getReplacedMessage("項目名"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7067ChohyoSeigyoHanyo.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(chohyoBunruiID, 帳票分類ID),
                                eq(kanriNendo, 管理年度),
                                eq(komokuName, 項目名))).
                toObject(DbT7067ChohyoSeigyoHanyoEntity.class);
    }

    /**
     * 帳票制御汎用を全件返します。
     *
     * @return List<DbT7067ChohyoSeigyoHanyoEntity>
     */
    @Transaction
    public List<DbT7067ChohyoSeigyoHanyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7067ChohyoSeigyoHanyo.class).
                toList(DbT7067ChohyoSeigyoHanyoEntity.class);
    }

    /**
     * DbT7067ChohyoSeigyoHanyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7067ChohyoSeigyoHanyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御汎用エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
