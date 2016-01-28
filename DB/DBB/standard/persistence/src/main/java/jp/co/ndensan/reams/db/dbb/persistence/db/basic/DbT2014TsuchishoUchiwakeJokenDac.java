/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJoken;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJoken.fukaShoriKubun;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJoken.hozonDateTime;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJoken.uchiwakeJoken;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 通知書打ち分け条件のデータアクセスクラスです。
 */
public class DbT2014TsuchishoUchiwakeJokenDac implements ISaveable<DbT2014TsuchishoUchiwakeJokenEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで通知書打ち分け条件を取得します。
     *
     * @param 打ち分け条件 RString
     * @param 保存日時 RDateTime
     * @param 賦課処理区分 RString
     * @return DbT2014TsuchishoUchiwakeJokenEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2014TsuchishoUchiwakeJokenEntity selectByKey(
            RString 打ち分け条件,
            RDateTime 保存日時,
            RString 賦課処理区分) throws NullPointerException {
        requireNonNull(打ち分け条件, UrSystemErrorMessages.値がnull.getReplacedMessage("打ち分け条件"));
        requireNonNull(保存日時, UrSystemErrorMessages.値がnull.getReplacedMessage("保存日時"));
        requireNonNull(賦課処理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課処理区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2014TsuchishoUchiwakeJoken.class).
                where(and(
                                eq(uchiwakeJoken, 打ち分け条件),
                                eq(hozonDateTime, 保存日時),
                                eq(fukaShoriKubun, 賦課処理区分))).
                toObject(DbT2014TsuchishoUchiwakeJokenEntity.class);
    }

    /**
     * 通知書打ち分け条件を全件返します。
     *
     * @return List<DbT2014TsuchishoUchiwakeJokenEntity>
     */
    @Transaction
    public List<DbT2014TsuchishoUchiwakeJokenEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2014TsuchishoUchiwakeJoken.class).
                toList(DbT2014TsuchishoUchiwakeJokenEntity.class);
    }

    /**
     * DbT2014TsuchishoUchiwakeJokenEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2014TsuchishoUchiwakeJokenEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書打ち分け条件エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
