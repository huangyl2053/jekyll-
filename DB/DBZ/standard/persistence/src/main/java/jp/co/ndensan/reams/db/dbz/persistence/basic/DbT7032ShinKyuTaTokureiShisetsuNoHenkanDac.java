/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkan.kyuTaTokureiShisetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkan.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧他特例施設番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac implements IModifiable<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧他特例施設番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧他特例施設番号 KyuTaTokureiShisetsuNo
     * @return DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧他特例施設番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7032ShinKyuTaTokureiShisetsuNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuTaTokureiShisetsuNo, 旧他特例施設番号))).
                toObject(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity.class);
    }

    /**
     * 新旧他特例施設番号変換テーブルを全件返します。
     *
     * @return List<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7032ShinKyuTaTokureiShisetsuNoHenkan.class).
                toList(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
