/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.batchID;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.batchIDEdaban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.gyomuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.nendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.nendoNaiRenban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanri.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付管理マスタのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7022ShoriDateKanriDac implements IModifiable<DbT7022ShoriDateKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで処理日付管理マスタを取得します。
     *
     * @param 業務コード GyomuCode
     * @param 市町村コード ShichosonCode
     * @param バッチＩＤ BatchID
     * @param バッチID枝番 BatchIDEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return DbT7022ShoriDateKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7022ShoriDateKanriEntity selectByKey(
            GyomuCode 業務コード,
            LasdecCode 市町村コード,
            RString バッチＩＤ,
            RString バッチID枝番,
            FlexibleYear 年度,
            RString 年度内連番) throws NullPointerException {
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(バッチＩＤ, UrSystemErrorMessages.値がnull.getReplacedMessage("バッチＩＤ"));
        requireNonNull(バッチID枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("バッチID枝番"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                where(and(
                                eq(gyomuCode, 業務コード),
                                eq(shichosonCode, 市町村コード),
                                eq(batchID, バッチＩＤ),
                                eq(batchIDEdaban, バッチID枝番),
                                eq(nendo, 年度),
                                eq(nendoNaiRenban, 年度内連番))).
                toObject(DbT7022ShoriDateKanriEntity.class);
    }

    /**
     * 処理日付管理マスタを全件返します。
     *
     * @return List<DbT7022ShoriDateKanriEntity>
     */
    @Transaction
    public List<DbT7022ShoriDateKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7022ShoriDateKanri.class).
                toList(DbT7022ShoriDateKanriEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7022ShoriDateKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7022ShoriDateKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7022ShoriDateKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7022ShoriDateKanriEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7022ShoriDateKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
