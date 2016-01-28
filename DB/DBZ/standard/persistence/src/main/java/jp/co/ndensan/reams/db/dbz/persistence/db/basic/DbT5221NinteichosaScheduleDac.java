/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaSchedule;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査スケジュール情報のデータアクセスクラスです。
 */
public class DbT5221NinteichosaScheduleDac implements ISaveable<DbT5221NinteichosaScheduleEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査スケジュール情報を取得します。
     *
     * @param 認定調査予定年月日 認定調査予定年月日
     * @param 認定調査予定開始時間 認定調査予定開始時間
     * @param 認定調査予定終了時間 認定調査予定終了時間
     * @param 認定調査時間枠 認定調査時間枠
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return DbT5221NinteichosaScheduleEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
//    @Transaction
//    public DbT5221NinteichosaScheduleEntity selectByKey(
//            FlexibleDate 認定調査予定年月日,
//            RString 認定調査予定開始時間,
//            RString 認定調査予定終了時間,
//            Code 認定調査時間枠,
//            RString 認定調査委託先コード,
//            RString 認定調査員コード) throws NullPointerException {
//        requireNonNull(認定調査予定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定年月日"));
//        requireNonNull(認定調査予定開始時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定開始時間"));
//        requireNonNull(認定調査予定終了時間, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査予定終了時間"));
//        requireNonNull(認定調査時間枠, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査時間枠"));
//        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
//        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));
//
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//
//        return accessor.select().
//                table(DbT5221NinteichosaSchedule.class).
//                where(and(
//                                eq(ninteiChosaYoteiYMD, 認定調査予定年月日),
//                                eq(ninteiChosaYoteiKaishiTime, 認定調査予定開始時間),
//                                eq(ninteiChosaYoteiShuryoTime, 認定調査予定終了時間),
//                                eq(ninteiChosaJikanWaku, 認定調査時間枠),
//                                eq(ninteichosaItakusakiCode, 認定調査委託先コード),
//                                eq(ninteiChosainNo, 認定調査員コード))).
//                toObject(DbT5221NinteichosaScheduleEntity.class);
//    }

    /**
     * 認定調査スケジュール情報を全件返します。
     *
     * @return DbT5221NinteichosaScheduleEntityの{@code list}
     */
    @Transaction
    public List<DbT5221NinteichosaScheduleEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5221NinteichosaSchedule.class).
                toList(DbT5221NinteichosaScheduleEntity.class);
    }

    /**
     * DbT5221NinteichosaScheduleEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5221NinteichosaScheduleEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査スケジュール情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
