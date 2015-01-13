/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanri;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanri.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連インターフェース管理のデータアクセスクラスです。
 *
 * @author n2810 久保里史
 */
public class KokuhorenInterfaceKanriDac implements IReplaceable<DbT3104KokuhorenInterfaceKanriEntity>, IDeletable<DbT3104KokuhorenInterfaceKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで国保連インターフェース管理を取得します。
     *
     * @param 処理年月 shoriYM
     * @param 交換情報識別番号 kokanShikibetsuNo
     * @return DbT3104KokuhorenInterfaceKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3104KokuhorenInterfaceKanriEntity selectByKey(
            RYearMonth 処理年月,
            RString 交換情報識別番号) throws NullPointerException {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                where(and(
                                eq(shoriYM, 処理年月),
                                eq(kokanShikibetsuNo, 交換情報識別番号))).
                toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 国保連インターフェース管理を全件返します。
     *
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    @Transaction
    public List<DbT3104KokuhorenInterfaceKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3104KokuhorenInterfaceKanri.class).
                toList(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    /**
     * 最大処理年月を取得します
     *
     * @return DbT3104KokuhorenInterfaceKanriEntity
     */
    public DbT3104KokuhorenInterfaceKanriEntity getMaxShoriYM() throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(DbT3104KokuhorenInterfaceKanri.shoriYM)).
                table(DbT3104KokuhorenInterfaceKanri.class).
                toObject(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    @Transaction
    @Override
    public int insertOrUpdate(DbT3104KokuhorenInterfaceKanriEntity data) {
        return getMatchRowCount(data) == 0 ? insert(data) : update(data);
    }

    @Transaction
    @Override
    public int insert(DbT3104KokuhorenInterfaceKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3104KokuhorenInterfaceKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3104KokuhorenInterfaceKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    private int getMatchRowCount(DbT3104KokuhorenInterfaceKanriEntity data) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select()
                .table(DbT3104KokuhorenInterfaceKanri.class)
                .where(and(
                                eq(shoriYM, data.getShoriYM()),
                                eq(kokanShikibetsuNo, data.getKokanShikibetsuNo())))
                .getCount();
    }
}
