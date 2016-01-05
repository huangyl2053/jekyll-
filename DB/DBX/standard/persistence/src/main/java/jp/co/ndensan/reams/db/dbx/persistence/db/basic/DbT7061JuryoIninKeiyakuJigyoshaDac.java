/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyosha;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyosha.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyosha.keiyakuKaishiYMD;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyosha.serviceShubetsuCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7061JuryoIninKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
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
public class DbT7061JuryoIninKeiyakuJigyoshaDac implements ISaveable<DbT7061JuryoIninKeiyakuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受領委任契約事業者を取得します。
     *
     * @param 受領委任契約事業者番号 JigyoshaNo
     * @param 受領委任契約開始日 KeiyakuKaishiYMD
     * @param 契約サービス種別 ServiceShubetsuCode
     * @return DbT7061JuryoIninKeiyakuJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7061JuryoIninKeiyakuJigyoshaEntity selectByKey(
            KaigoJigyoshaNo 受領委任契約事業者番号,
            FlexibleDate 受領委任契約開始日,
            RString 契約サービス種別) throws NullPointerException {
        requireNonNull(受領委任契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者番号"));
        requireNonNull(受領委任契約開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約開始日"));
        requireNonNull(契約サービス種別, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種別"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7061JuryoIninKeiyakuJigyosha.class).
                where(and(
                                eq(jigyoshaNo, 受領委任契約事業者番号),
                                eq(keiyakuKaishiYMD, 受領委任契約開始日),
                                eq(serviceShubetsuCode, 契約サービス種別))).
                toObject(DbT7061JuryoIninKeiyakuJigyoshaEntity.class);
    }

    /**
     * 受領委任契約事業者を全件返します。
     *
     * @return List<DbT7061JuryoIninKeiyakuJigyoshaEntity>
     */
    @Transaction
    public List<DbT7061JuryoIninKeiyakuJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7061JuryoIninKeiyakuJigyosha.class).
                toList(DbT7061JuryoIninKeiyakuJigyoshaEntity.class);
    }

    /**
     * DbT7061JuryoIninKeiyakuJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7061JuryoIninKeiyakuJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
