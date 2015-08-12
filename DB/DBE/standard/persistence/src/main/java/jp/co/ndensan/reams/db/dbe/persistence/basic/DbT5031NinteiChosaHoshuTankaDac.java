/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTanka;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTanka.chosaKubun;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTanka.homonShubetsu;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTanka.ikenshoNyushuPatern;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTanka.kaishiYM;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTanka.shuryoYM;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査報酬単価のデータアクセスクラスです。
 */
public class DbT5031NinteiChosaHoshuTankaDac implements ISaveable<DbT5031NinteiChosaHoshuTankaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査報酬単価を取得します。
     *
     * @param 調査区分 調査区分
     * @param 訪問種別 訪問種別
     * @param 意見書入手パターン 意見書入手パターン
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @return DbT5031NinteiChosaHoshuTankaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5031NinteiChosaHoshuTankaEntity selectByKey(
            Code 調査区分,
            Code 訪問種別,
            Code 意見書入手パターン,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) throws NullPointerException {
        requireNonNull(調査区分, UrSystemErrorMessages.値がnull.getReplacedMessage("調査区分"));
        requireNonNull(訪問種別, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問種別"));
        requireNonNull(意見書入手パターン, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書入手パターン"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5031NinteiChosaHoshuTanka.class).
                where(and(
                                eq(chosaKubun, 調査区分),
                                eq(homonShubetsu, 訪問種別),
                                eq(ikenshoNyushuPatern, 意見書入手パターン),
                                eq(kaishiYM, 開始年月),
                                eq(shuryoYM, 終了年月))).
                toObject(DbT5031NinteiChosaHoshuTankaEntity.class);
    }

    /**
     * 認定調査報酬単価を全件返します。
     *
     * @return DbT5031NinteiChosaHoshuTankaEntityの{@code list}
     */
    @Transaction
    public List<DbT5031NinteiChosaHoshuTankaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5031NinteiChosaHoshuTanka.class).
                toList(DbT5031NinteiChosaHoshuTankaEntity.class);
    }

    /**
     * DbT5031NinteiChosaHoshuTankaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5031NinteiChosaHoshuTankaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査報酬単価エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
