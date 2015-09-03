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
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * 連動パターンのデータアクセスクラスです。
 */
public class DbT7035RendoPatternDac implements ISaveable<DbT7035RendoPatternEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連動パターンを取得します。
     *
     * @param 送信元市町村コード 送信元市町村コード
     * @param 送信先市町村コード 送信先市町村コード
     * @param 種別 種別
     * @param 有効開始年月日 有効開始年月日
     * @param 有効終了年月日 有効終了年月日
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
     * @return DbT7035RendoPatternEntityの{@code list}
     */
    @Transaction
    public List<DbT7035RendoPatternEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7035RendoPattern.class).
                toList(DbT7035RendoPatternEntity.class);
    }

    /**
     * DbT7035RendoPatternEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7035RendoPatternEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連動パターンエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
