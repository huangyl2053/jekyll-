/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanri;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanri.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanri.shikibetsuKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanri.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanri.yukoKaishiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者限度額管理のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7116JukyushaGendoGakuKanriDac implements IModifiable<DbT7116JukyushaGendoGakuKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受給者限度額管理を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別区分 ShikibetsuKubun
     * @param 有効開始年月 YukoKaishiYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT7116JukyushaGendoGakuKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7116JukyushaGendoGakuKanriEntity selectByKey(
            HihokenshaNo 被保険者番号,
            RString 識別区分,
            FlexibleYearMonth 有効開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(識別区分, UrSystemErrorMessages.値がnull.getReplacedMessage("識別区分"));
        requireNonNull(有効開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7116JukyushaGendoGakuKanri.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikibetsuKubun, 識別区分),
                                eq(yukoKaishiYM, 有効開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT7116JukyushaGendoGakuKanriEntity.class);
    }

    /**
     * 受給者限度額管理を全件返します。
     *
     * @return List<DbT7116JukyushaGendoGakuKanriEntity>
     */
    @Transaction
    public List<DbT7116JukyushaGendoGakuKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7116JukyushaGendoGakuKanri.class).
                toList(DbT7116JukyushaGendoGakuKanriEntity.class);
    }

    /**
     * 受給者限度額管理を追加します。
     *
     * @param entity 受給者限度額管理
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7116JukyushaGendoGakuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 受給者限度額管理をDBに更新します。
     *
     * @param entity 受給者限度額管理
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7116JukyushaGendoGakuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 受給者限度額管理をDBから削除します。（論理削除）
     *
     * @param entity 受給者限度額管理
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7116JukyushaGendoGakuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 受給者限度額管理を物理削除。
     *
     * @param entity 受給者限度額管理
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7116JukyushaGendoGakuKanriEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
