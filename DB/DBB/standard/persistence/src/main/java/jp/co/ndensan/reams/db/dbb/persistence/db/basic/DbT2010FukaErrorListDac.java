/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorList;
import static jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorList.*;
import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
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
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
