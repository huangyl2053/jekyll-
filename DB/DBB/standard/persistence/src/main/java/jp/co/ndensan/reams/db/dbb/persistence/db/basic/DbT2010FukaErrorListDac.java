/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.batchId;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.internalReportCreationDateTime;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.internalReportId;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.shoriKubunCode;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.subGyomuCode;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorList.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.NullsOrder;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import jp.co.ndensan.reams.uz.uza.util.db.OrderBy;
import jp.co.ndensan.reams.uz.uza.util.db.Restrictions;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課エラー一覧のデータアクセスクラスです。
 */
public class DbT2010FukaErrorListDac implements ISaveable<DbT2010FukaErrorListEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで賦課エラー一覧を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 内部帳票ID InternalReportId
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @return DbT2010FukaErrorListEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2010FukaErrorListEntity selectByKey(
            SubGyomuCode サブ業務コード,
            RString 内部帳票ID,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) throws NullPointerException {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(内部帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("内部帳票ID"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2010FukaErrorList.class).
                where(and(
                                eq(subGyomuCode, サブ業務コード),
                                eq(internalReportId, 内部帳票ID),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号))).
                toObject(DbT2010FukaErrorListEntity.class);
    }

    /**
     * 賦課エラー一覧を全件返します。
     *
     * @return List<DbT2010FukaErrorListEntity>
     */
    @Transaction
    public List<DbT2010FukaErrorListEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2010FukaErrorList.class).
                toList(DbT2010FukaErrorListEntity.class);
    }

    /**
     * DbT2010FukaErrorListEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2010FukaErrorListEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課エラー一覧エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 指示されたバッチIDについて、過去最大10件分の「リスト作成日時」を取得します。
     *
     * @param batchID バッチID
     * @return リスト作成日時リスト
     */
    @Transaction
    public List<DbT2010FukaErrorListEntity> select作成日時(RString batchID) {
        requireNonNull(batchID, UrSystemErrorMessages.値がnull.getReplacedMessage("バッチID"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(Restrictions.distinct(internalReportCreationDateTime)).
                table(DbT2010FukaErrorList.class).
                where(eq(batchId, batchID)).
                order(new OrderBy(internalReportCreationDateTime, Order.DESC, NullsOrder.LAST)).
                limit(10).
                toList(DbT2010FukaErrorListEntity.class);
    }

    /**
     * 選択されたリスト作成日時に合わせて業務概念「賦課エラーの情報」のリストを取得します。
     *
     * @param リスト作成日時 リスト作成日時
     * @return 作成日時リスト
     */
    @Transaction
    public List<DbT2010FukaErrorListEntity> select賦課エラー情報リスト(RDateTime リスト作成日時) {
        requireNonNull(リスト作成日時, UrSystemErrorMessages.値がnull.getReplacedMessage("リスト作成日時"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT2010FukaErrorList.class).
                where(eq(internalReportCreationDateTime, リスト作成日時)).
                order(new OrderBy(shoriKubunCode, Order.DESC, NullsOrder.LAST),
                        new OrderBy(fukaNendo, Order.DESC, NullsOrder.LAST),
                        new OrderBy(tsuchishoNo, Order.DESC, NullsOrder.LAST)).
                toList(DbT2010FukaErrorListEntity.class);
    }
}
