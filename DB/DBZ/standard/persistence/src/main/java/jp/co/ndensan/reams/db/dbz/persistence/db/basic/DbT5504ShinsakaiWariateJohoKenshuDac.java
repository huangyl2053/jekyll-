/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshu;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshu.shinsakaiKaisaiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshu.shinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当情報（研修用）のデータアクセスクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public class DbT5504ShinsakaiWariateJohoKenshuDac implements ISaveable<DbT5504ShinsakaiWariateJohoKenshuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会割当情報を取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5502ShinsakaiWariateJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5504ShinsakaiWariateJohoKenshuEntity selectByKey(
            RString 介護認定審査会開催番号,
            ShinseishoKanriNo 申請書管理番号) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5504ShinsakaiWariateJohoKenshu.class).
                where(and(
                                eq(shinsakaiKaisaiNo, 介護認定審査会開催番号),
                                eq(shinseishoKanriNo, 申請書管理番号))).
                toObject(DbT5504ShinsakaiWariateJohoKenshuEntity.class);
    }

    /**
     * 介護認定審査会開催番号で介護認定審査会割当情報のリストを取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return List<DbT5502ShinsakaiWariateJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5504ShinsakaiWariateJohoKenshuEntity> selectByShinsakaiKaisaiNo(RString 介護認定審査会開催番号) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5504ShinsakaiWariateJohoKenshu.class).
                where(eq(shinsakaiKaisaiNo, 介護認定審査会開催番号)).
                toList(DbT5504ShinsakaiWariateJohoKenshuEntity.class);
    }

    /**
     * 介護認定審査会割当情報を全件返します。
     *
     * @return DbT5502ShinsakaiWariateJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5504ShinsakaiWariateJohoKenshuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5504ShinsakaiWariateJohoKenshu.class).
                toList(DbT5504ShinsakaiWariateJohoKenshuEntity.class);
    }

    /**
     * 認定審査会の割り当て情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 情報件数
     */
    @Transaction
    public int getcount(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().table(DbT5504ShinsakaiWariateJohoKenshu.class).where(eq(shinseishoKanriNo, 申請書管理番号)).getCount();
    }

    /**
     * DbT5502ShinsakaiWariateJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5504ShinsakaiWariateJohoKenshuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報（研修用）エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5502ShinsakaiWariateJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT5504ShinsakaiWariateJohoKenshuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報（研修用）エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
