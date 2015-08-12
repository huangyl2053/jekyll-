/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJoho.shinsakaiIinCode;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJoho.shinsakaiKaisaiNo;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJoho.shinsakaiOrder;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会事前審査結果情報のデータアクセスクラスです。
 */
public class DbT5508ShinsakaiJizenKekkaJohoDac implements ISaveable<DbT5508ShinsakaiJizenKekkaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定審査会事前審査結果情報を取得します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 介護認定審査会審査順 介護認定審査会審査順
     * @return DbT5508ShinsakaiJizenKekkaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5508ShinsakaiJizenKekkaJohoEntity selectByKey(
            int 介護認定審査会開催番号,
            RString 介護認定審査会委員コード,
            int 介護認定審査会審査順) throws NullPointerException {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(介護認定審査会審査順, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5508ShinsakaiJizenKekkaJoho.class).
                where(and(
                                eq(shinsakaiKaisaiNo, 介護認定審査会開催番号),
                                eq(shinsakaiIinCode, 介護認定審査会委員コード),
                                eq(shinsakaiOrder, 介護認定審査会審査順))).
                toObject(DbT5508ShinsakaiJizenKekkaJohoEntity.class);
    }

    /**
     * 介護認定審査会事前審査結果情報を全件返します。
     *
     * @return DbT5508ShinsakaiJizenKekkaJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5508ShinsakaiJizenKekkaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5508ShinsakaiJizenKekkaJoho.class).
                toList(DbT5508ShinsakaiJizenKekkaJohoEntity.class);
    }

    /**
     * DbT5508ShinsakaiJizenKekkaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5508ShinsakaiJizenKekkaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会事前審査結果情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
