/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseisho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseisho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseisho.hokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseisho.seiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseisho.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseisho.taishoNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3068KogakuGassanShinseishoEntity;
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
 * 高額合算申請書のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3068KogakuGassanShinseishoDac implements IModifiable<DbT3068KogakuGassanShinseishoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算申請書を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 整理番号 SeiriNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3068KogakuGassanShinseishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3068KogakuGassanShinseishoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3068KogakuGassanShinseisho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(seiriNo, 整理番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3068KogakuGassanShinseishoEntity.class);
    }

    /**
     * 高額合算申請書を全件返します。
     *
     * @return List<DbT3068KogakuGassanShinseishoEntity>
     */
    @Transaction
    public List<DbT3068KogakuGassanShinseishoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3068KogakuGassanShinseisho.class).
                toList(DbT3068KogakuGassanShinseishoEntity.class);
    }

    /**
     * 高額合算申請書を追加します。
     *
     * @param entity 高額合算申請書
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3068KogakuGassanShinseishoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額合算申請書をDBに更新します。
     *
     * @param entity 高額合算申請書
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3068KogakuGassanShinseishoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額合算申請書をDBから削除します。（論理削除）
     *
     * @param entity 高額合算申請書
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3068KogakuGassanShinseishoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額合算申請書を物理削除。
     *
     * @param entity 高額合算申請書
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3068KogakuGassanShinseishoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
