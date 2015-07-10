/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki.hokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki.kanyurekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki.seiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyureki.taishoNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算申請書加入歴のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3069KogakuGassanShinseishoKanyurekiDac implements IModifiable<DbT3069KogakuGassanShinseishoKanyurekiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算申請書加入歴を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 整理番号 SeiriNo
     * @param 加入歴番号 KanyurekiNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3069KogakuGassanShinseishoKanyurekiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3069KogakuGassanShinseishoKanyurekiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            RString 加入歴番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(加入歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加入歴番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3069KogakuGassanShinseishoKanyureki.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(seiriNo, 整理番号),
                                eq(kanyurekiNo, 加入歴番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3069KogakuGassanShinseishoKanyurekiEntity.class);
    }

    /**
     * 高額合算申請書加入歴を全件返します。
     *
     * @return List<DbT3069KogakuGassanShinseishoKanyurekiEntity>
     */
    @Transaction
    public List<DbT3069KogakuGassanShinseishoKanyurekiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3069KogakuGassanShinseishoKanyureki.class).
                toList(DbT3069KogakuGassanShinseishoKanyurekiEntity.class);
    }

    /**
     * 高額合算申請書加入歴を追加します。
     *
     * @param entity 高額合算申請書加入歴
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額合算申請書加入歴をDBに更新します。
     *
     * @param entity 高額合算申請書加入歴
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額合算申請書加入歴をDBから削除します。（論理削除）
     *
     * @param entity 高額合算申請書加入歴
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額合算申請書加入歴を物理削除。
     *
     * @param entity 高額合算申請書加入歴
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
