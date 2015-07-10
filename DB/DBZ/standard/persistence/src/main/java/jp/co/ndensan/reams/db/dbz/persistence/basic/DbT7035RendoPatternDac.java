/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPattern;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPattern.motoShichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPattern.sakiShichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPattern.shubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPattern.yukoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPattern.yukoShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連動パターンのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7035RendoPatternDac implements IModifiable<DbT7035RendoPatternEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連動パターンを取得します。
     *
     * @param 送信元市町村コード MotoShichosonCode
     * @param 送信先市町村コード SakiShichosonCode
     * @param 種別 Shubetsu
     * @param 有効開始年月日 YukoKaishiYMD
     * @param 有効終了年月日 YukoShuryoYMD
     * @return DbT7035RendoPatternEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7035RendoPatternEntity selectByKey(
            LasdecCode 送信元市町村コード,
            LasdecCode 送信先市町村コード,
            RString 種別,
            FlexibleDate 有効開始年月日,
            FlexibleDate 有効終了年月日) throws NullPointerException {
        requireNonNull(送信元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信元市町村コード"));
        requireNonNull(送信先市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("送信先市町村コード"));
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        requireNonNull(有効開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始年月日"));
        requireNonNull(有効終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7035RendoPattern.class).
                where(and(
                                eq(motoShichosonCode, 送信元市町村コード),
                                eq(sakiShichosonCode, 送信先市町村コード),
                                eq(shubetsu, 種別),
                                eq(yukoKaishiYMD, 有効開始年月日),
                                eq(yukoShuryoYMD, 有効終了年月日))).
                toObject(DbT7035RendoPatternEntity.class);
    }

    /**
     * 連動パターンを全件返します。
     *
     * @return List<DbT7035RendoPatternEntity>
     */
    @Transaction
    public List<DbT7035RendoPatternEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7035RendoPattern.class).
                toList(DbT7035RendoPatternEntity.class);
    }

    /**
     * 連動パターンを追加します。
     *
     * @param entity 連動パターン
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7035RendoPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 連動パターンをDBに更新します。
     *
     * @param entity 連動パターン
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7035RendoPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 連動パターンをDBから削除します。（論理削除）
     *
     * @param entity 連動パターン
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7035RendoPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 連動パターンを物理削除。
     *
     * @param entity 連動パターン
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7035RendoPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
