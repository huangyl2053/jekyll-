/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkan.codeKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkan.gaibuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkan.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
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
 * 各種コード変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7027KakushuCodeHenkanDac implements IModifiable<DbT7027KakushuCodeHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで各種コード変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @param 外部コード GaibuCode
     * @return DbT7027KakushuCodeHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7027KakushuCodeHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString コード区分,
            RString 外部コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        requireNonNull(外部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7027KakushuCodeHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(codeKubun, コード区分),
                                eq(gaibuCode, 外部コード))).
                toObject(DbT7027KakushuCodeHenkanEntity.class);
    }

    /**
     * 各種コード変換テーブルを全件返します。
     *
     * @return List<DbT7027KakushuCodeHenkanEntity>
     */
    @Transaction
    public List<DbT7027KakushuCodeHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7027KakushuCodeHenkan.class).
                toList(DbT7027KakushuCodeHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7027KakushuCodeHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7027KakushuCodeHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7027KakushuCodeHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7027KakushuCodeHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7027KakushuCodeHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
