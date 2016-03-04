/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakusha;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakusha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakusha.keiyakuJigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakusha.keiyakuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakusha.keiyakuServiceShurui;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakusha.shinseiYMD;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還受領委任契約者のデータアクセスクラスです。
 */
public class DbT3078ShokanJuryoininKeiyakushaDac implements ISaveable<DbT3078ShokanJuryoininKeiyakushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還受領委任契約者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 申請年月日 FlexibleDate
     * @param 契約事業者番号 RString
     * @param 契約サービス種類 Decimal
     * @return DbT3078ShokanJuryoininKeiyakushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3078ShokanJuryoininKeiyakushaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 申請年月日,
            RString 契約事業者番号,
            RString 契約サービス種類) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        requireNonNull(契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));
        requireNonNull(契約サービス種類, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種類"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3078ShokanJuryoininKeiyakusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shinseiYMD, 申請年月日),
                                eq(keiyakuJigyoshaNo, 契約事業者番号),
                                eq(keiyakuServiceShurui, 契約サービス種類))).
                toObject(DbT3078ShokanJuryoininKeiyakushaEntity.class);
    }

    /**
     * 償還受領委任契約者を全件返します。
     *
     * @return List<DbT3078ShokanJuryoininKeiyakushaEntity>
     */
    @Transaction
    public List<DbT3078ShokanJuryoininKeiyakushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3078ShokanJuryoininKeiyakusha.class).
                toList(DbT3078ShokanJuryoininKeiyakushaEntity.class);
    }

    /**
     * DbT3078ShokanJuryoininKeiyakushaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還受領委任契約者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3078ShokanJuryoininKeiyakushaEntityを登録します。状態によってdelete処理に振り分けられます。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還受領委任契約者エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 償還受領委任契約者を全件返します。
     *
     * @param 契約番号 契約番号
     * @return List<DbT3078ShokanJuryoininKeiyakushaEntity>
     */
    @Transaction
    public List<DbT3078ShokanJuryoininKeiyakushaEntity> select償還受領委任契約者(RString 契約番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3078ShokanJuryoininKeiyakusha.class).
                where(
                        eq(keiyakuNo, 契約番号)).
                toList(DbT3078ShokanJuryoininKeiyakushaEntity.class);
    }
}
