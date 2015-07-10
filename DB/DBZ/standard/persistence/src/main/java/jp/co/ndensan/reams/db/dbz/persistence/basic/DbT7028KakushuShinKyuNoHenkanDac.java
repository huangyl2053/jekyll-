/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan.kyuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkan.noKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 各種新旧番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7028KakushuShinKyuNoHenkanDac implements IModifiable<DbT7028KakushuShinKyuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで各種新旧番号変換テーブルを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 番号区分 NoKubun
     * @param 旧番号 KyuNo
     * @return DbT7028KakushuShinKyuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7028KakushuShinKyuNoHenkanEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 番号区分,
            RString 旧番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(番号区分, UrSystemErrorMessages.値がnull.getReplacedMessage("番号区分"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7028KakushuShinKyuNoHenkan.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(noKubun, 番号区分),
                                eq(kyuNo, 旧番号))).
                toObject(DbT7028KakushuShinKyuNoHenkanEntity.class);
    }

    /**
     * 各種新旧番号変換テーブルを全件返します。
     *
     * @return List<DbT7028KakushuShinKyuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7028KakushuShinKyuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7028KakushuShinKyuNoHenkan.class).
                toList(DbT7028KakushuShinKyuNoHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7028KakushuShinKyuNoHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
