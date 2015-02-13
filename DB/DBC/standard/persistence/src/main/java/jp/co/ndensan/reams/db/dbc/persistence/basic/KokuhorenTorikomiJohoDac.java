/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJoho;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJoho.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 国保連取込情報のデータアクセスクラスです。
 *
 * @author n2810 久保里史
 */
public class KokuhorenTorikomiJohoDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで国保連取込情報を取得します。
     *
     * @param 処理年月 shoriYM
     * @param 交換情報識別番号 kokanShikibetsuNo
     * @return DbV3104KokuhorenTorikomiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV3104KokuhorenTorikomiJohoEntity selectByKey(
            RYearMonth 処理年月,
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
     * 処理年月で国保連取込情報を取得します。
     *
     * @param 処理年月 shoriYM
     * @return DbV3104KokuhorenTorikomiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbV3104KokuhorenTorikomiJohoEntity> selectBy処理年月(
            RYearMonth 処理年月) throws NullPointerException {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3104KokuhorenTorikomiJoho.class).
                where(eq(shoriYM, 処理年月)).
                toList(DbV3104KokuhorenTorikomiJohoEntity.class);
    }

    /**
     * 国保連取込情報を全件返します。
     *
     * @return List<DbV3104KokuhorenTorikomiJohoEntity>
     */
    @Transaction
    public List<DbV3104KokuhorenTorikomiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3104KokuhorenTorikomiJoho.class).
                toList(DbV3104KokuhorenTorikomiJohoEntity.class);
    }
}
