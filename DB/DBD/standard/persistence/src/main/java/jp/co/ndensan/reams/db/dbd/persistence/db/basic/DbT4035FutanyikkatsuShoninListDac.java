/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatch;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatch.hadApproved;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatch.isTest;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatch.ketteiYmd;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatch.ninteiBatchExecutedTimestamp;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatch.sakuseiNendo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4035FutanGendogakuNinteiBatchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 一括承認結果一覧のデータアクセスクラスです。
 */
public class DbT4035FutanyikkatsuShoninListDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで一括承認結果一覧を取得します。
     *
     * @param 一括認定バッチ処理日時 一括認定バッチ処理日時
     * @param 作成年度 作成年度
     * @param 決定日 決定日
     * @param テスト処理フラグ テスト処理フラグ
     * @param 承認済みフラグ 承認済みフラグ
     * @return DbT4035FutanGendogakuNinteiBatchEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4035FutanGendogakuNinteiBatchEntity selectByKey(
            YMDHMS 一括認定バッチ処理日時,
            FlexibleYear 作成年度,
            FlexibleDate 決定日,
            boolean テスト処理フラグ,
            boolean 承認済みフラグ) throws NullPointerException {
        requireNonNull(一括認定バッチ処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage(一括認定バッチ処理日時.toString()));
        requireNonNull(作成年度, UrSystemErrorMessages.値がnull.getReplacedMessage(作成年度.toString()));
        requireNonNull(決定日, UrSystemErrorMessages.値がnull.getReplacedMessage(決定日.toString()));
        requireNonNull(テスト処理フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("テスト処理フラグ"));
        requireNonNull(承認済みフラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("承認済みフラグ"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4035FutanGendogakuNinteiBatch.class).
                where(and(
                                eq(ninteiBatchExecutedTimestamp, 一括認定バッチ処理日時),
                                eq(sakuseiNendo, 作成年度),
                                eq(ketteiYmd, 決定日),
                                eq(isTest, テスト処理フラグ),
                                eq(hadApproved, 承認済みフラグ))).
                toObject(DbT4035FutanGendogakuNinteiBatchEntity.class);
    }

    /**
     * 負担限度額一括認定情報取得。
     *
     * @param 一括認定バッチ処理日時 YMDHMS
     * @return DbT4035FutanGendogakuNinteiBatchEntity
     */
    @Transaction
    public DbT4035FutanGendogakuNinteiBatchEntity select負担限度額一括認定情報(RString 一括認定バッチ処理日時) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4035FutanGendogakuNinteiBatch.class).
                where(
                        eq(ninteiBatchExecutedTimestamp, 一括認定バッチ処理日時)).
                toObject(DbT4035FutanGendogakuNinteiBatchEntity.class);
    }

    /**
     * 一括承認結果一覧を全件返します。
     *
     * @return DbT4035FutanGendogakuNinteiBatchEntityの{@code list}
     */
    @Transaction
    public List<DbT4035FutanGendogakuNinteiBatchEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4035FutanGendogakuNinteiBatch.class).
                toList(DbT4035FutanGendogakuNinteiBatchEntity.class);
    }

    /**
     * DbT4035FutanGendogakuNinteiBatchEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT4035FutanGendogakuNinteiBatchEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("一括承認結果一覧エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
