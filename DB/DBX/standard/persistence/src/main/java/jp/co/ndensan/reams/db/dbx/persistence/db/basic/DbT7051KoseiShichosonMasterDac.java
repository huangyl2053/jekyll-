/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.GappeiKyuShichosonKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.gappeiKyuShichosonKubun;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMaster.shichosonShokibetsuID;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタのデータアクセスクラスです。
 */
public class DbT7051KoseiShichosonMasterDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで構成市町村マスタを取得します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return DbT7051KoseiShichosonMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7051KoseiShichosonMasterEntity selectByKey(RString 市町村識別ID) throws NullPointerException {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(shichosonShokibetsuID, 市町村識別ID)).
                toObject(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 市町村識別IDで構成市町村マスタを取得します。
     * <p/>
     * 指定の市町村識別IDに該当し、削除されていないデータのみを返却します。
     * 該当するデータが存在しない場合は、{@code null}を返却します。
     *
     * @param shichosonShokibetsuID 市町村識別ID
     * @return DbT7051KoseiShichosonMasterEntityのlist
     * @throws NullPointerException 引数がnullの場合
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectBy市町村識別ID(RString shichosonShokibetsuID) {
        requireNonNull(shichosonShokibetsuID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        and(eq(DbT7051KoseiShichosonMaster.shichosonShokibetsuID, shichosonShokibetsuID),
                            eq(DbT7051KoseiShichosonMaster.isDeleted, false))).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 構成市町村マスタを返します。 合併旧市町村区分='1' 合併情報地域番号の一桁目＝上記①で取得された地域番号の一桁目
     *
     * @param 地域番号 RString
     * @return List<DbT7051KoseiShichosonMasterEntity>
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectKyuShichosonByChikiNoOneDigit(RString 地域番号) {
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7051KoseiShichosonMaster.class).
                where(and(eq(gappeiKyuShichosonKubun, GappeiKyuShichosonKubun.合併旧市町村.code()),
                          eq(substr(DbT7051KoseiShichosonMaster.gappeiChiikiNo, 1, 1), 地域番号.substring(0, 1)))).
                order(by(DbT7051KoseiShichosonMaster.gappeiChiikiNo, Order.DESC)).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 合併前の旧市町村と最新の広域構成市町村を含む全部市町村情報を取得します
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 全部市町村情報
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectZenShichosonJohoContainingKyuShichoson() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * 最新の広域構成市町村を含む現市町村情報を取得します
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 現市町村情報
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectPresenceShichosonJoho() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.
                select().
                table(DbT7051KoseiShichosonMaster.class).
                where(
                        eq(gappeiKyuShichosonKubun, GappeiKyuShichosonKubun.構成市町村.code())
                ).
                toList(DbT7051KoseiShichosonMasterEntity.class);
    }

    /**
     * DbT7051KoseiShichosonMasterEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT7051KoseiShichosonMasterEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタエンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
