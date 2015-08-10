/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaicho.kyuShichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJoho.chiikiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJoho.gappeiYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村のデータアクセスクラスです。
 */
public class DbT7056GappeiShichosonDac implements ISaveable<DbT7056GappeiShichosonEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合併市町村を取得します。
     *
     * @param 合併年月日 GappeiYMD
     * @param 地域番号 ChiikiNo
     * @param 旧市町村コード KyuShichosonCode
     * @return DbT7056GappeiShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7056GappeiShichosonEntity selectByKey(
            FlexibleDate 合併年月日,
            RString 地域番号,
            LasdecCode 旧市町村コード) throws NullPointerException {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                where(and(
                                eq(gappeiYMD, 合併年月日),
                                eq(chiikiNo, 地域番号),
                                eq(kyuShichosonCode, 旧市町村コード))).
                toObject(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * 合併市町村を全件返します。
     *
     * @return List<DbT7056GappeiShichosonEntity>
     */
    @Transaction
    public List<DbT7056GappeiShichosonEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                toList(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * DbT7056GappeiShichosonEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7056GappeiShichosonEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
