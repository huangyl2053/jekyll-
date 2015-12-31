/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkan.kyuNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkan.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkan.shinNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧被保険者番号変換テーブルのデータアクセスクラスです。
 */
public class DbT7026ShinKyuHihokenshaNoHenkanDac implements ISaveable<DbT7026ShinKyuHihokenshaNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧被保険者番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧番号 KyuNo
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7026ShinKyuHihokenshaNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuNo, 旧番号))).
                toObject(DbT7026ShinKyuHihokenshaNoHenkanEntity.class);
    }

    /**
     * 新旧被保険者番号変換テーブルを全件返します。
     *
     * @return List<DbT7026ShinKyuHihokenshaNoHenkanEntity>
     */
    @Transaction
    public List<DbT7026ShinKyuHihokenshaNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                toList(DbT7026ShinKyuHihokenshaNoHenkanEntity.class);
    }

    /**
     * DbT7026ShinKyuHihokenshaNoHenkanEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧被保険者番号変換テーブルエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 旧被保険者番号の取得します。
     *
     * @param 新番号
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity 新旧被保険者番号変換
     *
     */
    @Transaction
    public List<DbT7026ShinKyuHihokenshaNoHenkanEntity> get旧被保険者番号(
            RString 新番号) {
        requireNonNull(新番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                where(
                        eq(shinNo, 新番号)).
                toList(DbT7026ShinKyuHihokenshaNoHenkanEntity.class);
    }

    /**
     * 旧被保険者番号の結果件数取得します。
     *
     * @param 新番号
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity 新旧被保険者番号変換
     *
     */
    @Transaction
    public int get旧被保険者結果件数(
            RString 新番号) {
        requireNonNull(新番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                where(eq(shinNo, 新番号)).getCount();
    }

    /**
     * 新被保険者番号の結果件数取得します。
     *
     * @param 市町村コード
     * @param 旧番号
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity 新旧被保険者番号変換
     *
     */
    @Transaction
    public int get新被保険者結果件数(
            LasdecCode 市町村コード,
            RString 旧番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuNo, 旧番号))).getCount();
    }

    /**
     * 新被保険者番号の取得します。
     *
     * @param 市町村コード
     * @param 旧番号
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity
     *
     */
    @Transaction
    public DbT7026ShinKyuHihokenshaNoHenkanEntity get新被保険者番号(
            LasdecCode 市町村コード,
            RString 旧番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuNo, 旧番号))).
                toObject(DbT7026ShinKyuHihokenshaNoHenkanEntity.class);
    }
}
