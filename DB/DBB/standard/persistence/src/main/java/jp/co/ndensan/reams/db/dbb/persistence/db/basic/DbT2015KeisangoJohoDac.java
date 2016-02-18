/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.koseiZengoKubun;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.sakuseiShoriName;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJoho.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 計算後情報のデータアクセスクラスです。
 */
public class DbT2015KeisangoJohoDac implements ISaveable<DbT2015KeisangoJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで計算後情報を取得します。
     *
     * @param 調定年度
     * @param 賦課年度
     * @param 通知書番号
     * @param 更正前後区分
     * @param 作成処理名
     * @return DbT2015KeisangoJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2015KeisangoJohoEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RString 更正前後区分,
            RString 作成処理名) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(更正前後区分, UrSystemErrorMessages.値がnull.getReplacedMessage("更正前後区分"));
        requireNonNull(作成処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("作成処理名"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2015KeisangoJoho.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(koseiZengoKubun, 更正前後区分),
                                eq(sakuseiShoriName, 作成処理名))).
                toObject(DbT2015KeisangoJohoEntity.class);
    }

    /**
     * 計算後情報を全件返します。
     *
     * @return List<DbT2015KeisangoJohoEntity>
     */
    @Transaction
    public List<DbT2015KeisangoJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2015KeisangoJoho.class).
                toList(DbT2015KeisangoJohoEntity.class);
    }

    /**
     * DbT2015KeisangoJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2015KeisangoJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("計算後情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
