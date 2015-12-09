/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.entity.Idokikan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokurei.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * 他市町村住所地特例のデータアクセスクラスです。
 */
public class DbT1003TashichosonJushochiTokureiDac implements ISaveable<DbT1003TashichosonJushochiTokureiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで他市町村住所地特例を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return DbT1003TashichosonJushochiTokureiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1003TashichosonJushochiTokureiEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * 他市町村住所地特例テーブルに適用年月日と解除年月日を取得する
     *
     * @param 識別コード 識別コード
     * @return 他市町村住所地特例テーブルに適用年月日と解除年月日のリスト
     * @throws NullPointerException 識別コードがnull
     */
    public List<Idokikan> selectIdokikanByShikibetsuCode(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT1003TashichosonJushochiTokureiEntity> tashichosonEntityList = accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(logicalDeletedFlag, false))).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);

        List<Idokikan> idokikanList = new ArrayList<>();
        for (DbT1003TashichosonJushochiTokureiEntity tashichosonJushochiTokurei : tashichosonEntityList) {
            Idokikan idokikan = new Idokikan();
            idokikan.setKaishiYMD(tashichosonJushochiTokurei.getTekiyoYMD());
            idokikan.setShuryoYMD(tashichosonJushochiTokurei.getKaijoYMD());
            idokikan.setIdoYMD(tashichosonJushochiTokurei.getIdoYMD());
            idokikan.setEdaNo(tashichosonJushochiTokurei.getEdaNo());
            idokikanList.add(idokikan);
        }
        return idokikanList;
    }

    /**
     * 他市町村住所地特例を全件返します。
     *
     * @return List<DbT1003TashichosonJushochiTokureiEntity>
     */
    @Transaction
    public List<DbT1003TashichosonJushochiTokureiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1003TashichosonJushochiTokurei.class).
                toList(DbT1003TashichosonJushochiTokureiEntity.class);
    }

    /**
     * DbT1003TashichosonJushochiTokureiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1003TashichosonJushochiTokureiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
