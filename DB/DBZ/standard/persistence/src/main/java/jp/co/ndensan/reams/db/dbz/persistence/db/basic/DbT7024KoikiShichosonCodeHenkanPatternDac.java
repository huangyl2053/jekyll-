/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7024KoikiShichosonCodeHenkanPattern;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7024KoikiShichosonCodeHenkanPattern.*;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域市町村管理コード変換パターンのデータアクセスクラスです。
 */
public class DbT7024KoikiShichosonCodeHenkanPatternDac implements ISaveable<DbT7024KoikiShichosonCodeHenkanPatternEntity> {

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

    /**
     * DbT7024KoikiShichosonCodeHenkanPatternEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7024KoikiShichosonCodeHenkanPatternEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("広域市町村管理コード変換パターンエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
