/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyosha;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyosha.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyosha.keiyakuKaishiYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyosha.serviceShubetsuCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
 * 受領委任契約事業者のデータアクセスクラスです。
 */
public class DbT7061JuryoIninJigyoshaDac implements ISaveable<DbT7061JuryoIninJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受領委任契約事業者を取得します。
     *
     * @param 受領委任契約事業者番号 JigyoshaNo
     * @param 受領委任契約開始日 KeiyakuKaishiYMD
     * @param 契約サービス種別 ServiceShubetsuCode
     * @return DbT7061JuryoIninJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7061JuryoIninJigyoshaEntity selectByKey(
            JigyoshaNo 受領委任契約事業者番号,
            FlexibleDate 受領委任契約開始日,
            RString 契約サービス種別) throws NullPointerException {
        requireNonNull(受領委任契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者番号"));
        requireNonNull(受領委任契約開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約開始日"));
        requireNonNull(契約サービス種別, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種別"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7061JuryoIninJigyosha.class).
                where(and(
                                eq(jigyoshaNo, 受領委任契約事業者番号),
                                eq(keiyakuKaishiYMD, 受領委任契約開始日),
                                eq(serviceShubetsuCode, 契約サービス種別))).
                toObject(DbT7061JuryoIninJigyoshaEntity.class);
    }

    /**
     * 受領委任契約事業者を全件返します。
     *
     * @return List<DbT7061JuryoIninJigyoshaEntity>
     */
    @Transaction
    public List<DbT7061JuryoIninJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7061JuryoIninJigyosha.class).
                toList(DbT7061JuryoIninJigyoshaEntity.class);
    }

    /**
     * DbT7061JuryoIninJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7061JuryoIninJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
