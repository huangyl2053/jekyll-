/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsuban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsuban.codeKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsuban.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
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
 * 広域番号発番テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7025KoikiNoHatsubanDac implements IModifiable<DbT7025KoikiNoHatsubanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで広域番号発番テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @return DbT7025KoikiNoHatsubanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7025KoikiNoHatsubanEntity selectByKey(
            LasdecCode 市町村コード,
            RString コード区分) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7025KoikiNoHatsuban.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(codeKubun, コード区分))).
                toObject(DbT7025KoikiNoHatsubanEntity.class);
    }

    /**
     * 広域番号発番テーブルを全件返します。
     *
     * @return List<DbT7025KoikiNoHatsubanEntity>
     */
    @Transaction
    public List<DbT7025KoikiNoHatsubanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7025KoikiNoHatsuban.class).
                toList(DbT7025KoikiNoHatsubanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7025KoikiNoHatsubanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7025KoikiNoHatsubanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7025KoikiNoHatsubanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7025KoikiNoHatsubanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7025KoikiNoHatsubanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
