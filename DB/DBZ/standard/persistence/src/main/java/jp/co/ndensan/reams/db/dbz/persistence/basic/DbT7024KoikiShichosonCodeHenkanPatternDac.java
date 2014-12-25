/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPattern;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPattern.codeKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPattern.koikiShichosonNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPattern.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
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
 * 広域市町村管理コード変換パターンのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7024KoikiShichosonCodeHenkanPatternDac implements IModifiable<DbT7024KoikiShichosonCodeHenkanPatternEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで広域市町村管理コード変換パターンを取得します。
     *
     * @param 広域内市町村番号 KoikiShichosonNo
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @return DbT7024KoikiShichosonCodeHenkanPatternEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7024KoikiShichosonCodeHenkanPatternEntity selectByKey(
            RString 広域内市町村番号,
            LasdecCode 市町村コード,
            RString コード区分) throws NullPointerException {
        requireNonNull(広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7024KoikiShichosonCodeHenkanPattern.class).
                where(and(
                                eq(koikiShichosonNo, 広域内市町村番号),
                                eq(shichosonCode, 市町村コード),
                                eq(codeKubun, コード区分))).
                toObject(DbT7024KoikiShichosonCodeHenkanPatternEntity.class);
    }

    /**
     * 広域市町村管理コード変換パターンを全件返します。
     *
     * @return List<DbT7024KoikiShichosonCodeHenkanPatternEntity>
     */
    @Transaction
    public List<DbT7024KoikiShichosonCodeHenkanPatternEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7024KoikiShichosonCodeHenkanPattern.class).
                toList(DbT7024KoikiShichosonCodeHenkanPatternEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7024KoikiShichosonCodeHenkanPatternEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
