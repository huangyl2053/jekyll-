/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanri;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanri.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連インターフェース管理のデータアクセスクラスです。
 */
public class DbT3104KokuhorenInterfaceKanriDac implements ISaveable<DbT3104KokuhorenInterfaceKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで国保連インターフェース管理を取得します。
     *
     * @param 処理年月 ShoriYM
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @return DbT3104KokuhorenInterfaceKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3104KokuhorenInterfaceKanriEntity selectByKey(
            FlexibleYearMonth 処理年月,
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
     * DbT3104KokuhorenInterfaceKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3104KokuhorenInterfaceKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連インターフェース管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
