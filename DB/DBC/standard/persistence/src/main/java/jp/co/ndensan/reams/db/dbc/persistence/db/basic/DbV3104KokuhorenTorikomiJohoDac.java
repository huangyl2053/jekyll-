/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJoho;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJoho.kokanShikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJoho.shoriYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
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
 * 国保連取り込み情報のデータアクセスクラスです。
 *
 * @reamsid_L DBC-0980-520 quxiaodong
 */
public class DbV3104KokuhorenTorikomiJohoDac implements ISaveable<DbV3104KokuhorenTorikomiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで国保連取り込み情報を取得します。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     * @return DbV3104KokuhorenTorikomiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV3104KokuhorenTorikomiJohoEntity selectByKey(
            FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) throws NullPointerException {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3104KokuhorenTorikomiJoho.class).
                where(and(
                                eq(shoriYM, 処理年月),
                                eq(kokanShikibetsuNo, 交換情報識別番号))).
                toObject(DbV3104KokuhorenTorikomiJohoEntity.class);
    }

    /**
     * 国保連取り込み情報を全件返します。
     *
     * @return DbV3104KokuhorenTorikomiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbV3104KokuhorenTorikomiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3104KokuhorenTorikomiJoho.class).
                toList(DbV3104KokuhorenTorikomiJohoEntity.class);
    }

    /**
     * DbV3104KokuhorenTorikomiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV3104KokuhorenTorikomiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連取り込み情報エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 国保連送付情報を取得します。
     *
     * @param 処理年月 処理年月
     * @return List DbV3104KokuhorenTorikomiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbV3104KokuhorenTorikomiJohoEntity> selectBy処理年月(
            FlexibleYearMonth 処理年月) throws NullPointerException {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3104KokuhorenTorikomiJoho.class).
                where(
                        eq(shoriYM, 処理年月)).
                toList(DbV3104KokuhorenTorikomiJohoEntity.class);
    }
}
