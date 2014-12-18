/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.kyuTekiyoJogaiShisetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
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
 * 新旧適用除外施設番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac implements IModifiable<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧適用除外施設番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧適用除外施設番号 KyuTekiyoJogaiShisetsuNo
     * @return DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧適用除外施設番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuTekiyoJogaiShisetsuNo, 旧適用除外施設番号))).
                toObject(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.class);
    }

    /**
     * 新旧適用除外施設番号変換テーブルを全件返します。
     *
     * @return List<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity>
     */
    @Transaction
    public List<DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkan.class).
                toList(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
