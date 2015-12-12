/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.chosaChikuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroup;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroup.chosaChikuGroupCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査地区グループマスタのデータアクセスクラスです。
 */
public class DbT5225ChosaChikuGroupDac implements ISaveable<DbT5225ChosaChikuGroupEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで調査地区グループマスタを取得します。
     *
     * @param 調査地区グループコード 調査地区グループコード
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @return DbT5225ChosaChikuGroupEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5225ChosaChikuGroupEntity selectByKey(
            Code 調査地区グループコード,
            Code 調査地区コード,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(調査地区グループコード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループコード"));
        requireNonNull(調査地区コード, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5225ChosaChikuGroup.class).
                where(and(
                                eq(chosaChikuGroupCode, 調査地区グループコード),
                                eq(chosaChikuCode, 調査地区コード),
                                eq(shichosonCode, 市町村コード))).
                toObject(DbT5225ChosaChikuGroupEntity.class);
    }

    /**
     * 調査地区グループマスタを全件返します。
     *
     * @return DbT5225ChosaChikuGroupEntityの{@code list}
     */
    @Transaction
    public List<DbT5225ChosaChikuGroupEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5225ChosaChikuGroup.class).
                toList(DbT5225ChosaChikuGroupEntity.class);
    }

    /**
     * DbT5225ChosaChikuGroupEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5225ChosaChikuGroupEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調査地区グループマスタエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
